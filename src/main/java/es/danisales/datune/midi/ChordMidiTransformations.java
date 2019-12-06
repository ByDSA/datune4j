package es.danisales.datune.midi;

import es.danisales.datune.interval.Interval;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.pitch.PitchException;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChordMidiTransformations {
    private ChordMidiTransformations() {
    }


    public static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllInversionsFrom(T chordMidi) {
        ChordMidi<N, I, P> c = chordMidi.clone();
        c.setMinOctave();
        minimize(c);

        return getAllDispositionsSub(c, true, 0, true);
    }

    public static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllDispositionsWithInv(T chordMidi) {
        List<T> ret = new ArrayList<>();
        List<T> bases = _getWithAllInversions(chordMidi);
        for (T c : bases)
            ret.addAll(getAllInversionsFrom(c));

        return ret;
    }

    private static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> ChordMidi newChord(ChordMidi<N, I, P> chordMidi) {
        if (chordMidi instanceof DiatonicChordMidi) {
            try {
                return DiatonicChordMidi.builder().build();
            } catch (BuildingException e) {
                throw NeverHappensException.make("Un DiatonicChordMidi vacío nunca lanza una excepción");
            }
        }
        else if (chordMidi instanceof ChromaticChordMidi)
            return ChromaticChordMidi.builder().build();

        return null;
    }

    protected static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>>
    List<T> getAllDispositionsSub(ChordMidi<N, I, P> chordMidi, boolean sub, int level, boolean first) {
        ArrayList<T> ret = new ArrayList<>();
        assert chordMidi.size() > 0;

        if (first && level == 0)
            ret.add((T) chordMidi.clone());

        try {
            while ((chordMidi.size() > 1 && chordMidi.get(0).getPitch().getMidiCode() < chordMidi.get(1).getPitch().getMidiCode()
                    || chordMidi.size() == 1)) {
                if (!first) {
                    T d = (T) chordMidi.clone();
                    ret.add(d);
                }

                if (sub && chordMidi.size() > 1) {
                    // Copia acorde desde la segunda a la última nota
                    T subChord = (T)newChord(chordMidi);
                    for (int j = 1; j < chordMidi.size(); j++)
                        subChord.add((N) chordMidi.get(j).clone());

                    List<T> subCombinations = getAllDispositionsSub(subChord.clone(), true, level + 1, first);
                    for (T subCombination : subCombinations) {
                        // Forma listOf superChord = [listOf[0] + subChordcombination]
                        T superChord = (T)newChord(chordMidi);
                        superChord.add((N) chordMidi.get(0).clone());
                        superChord.addAll(subCombination.clone());

                        // Combinaciones de 'número' dentro del listOf superChord = ['número' +
                        // subChordcombination]
                        List<T> superCombinations = getAllDispositionsSub(superChord.clone(), false, level, false);
                        ret.addAll(superCombinations);
                    }
                }

                chordMidi.get(0).getPitch().shiftOctave(1);
                first = false;
            }
        } catch (PitchMidiException e) {
// todo: ??
        }

        return ret;
    }

    public static <N extends NoteMidi<?>> void minimize(ChordMidi<N, ?, ?> chordMidi) {
        for (int i = 1; i < chordMidi.size(); i++) {
            N note = chordMidi.get(i);
            N prev = chordMidi.get(i - 1);

            try {
                while (note.getPitch().getOctave() > prev.getPitch().getOctave())
                    note.getPitch().shiftOctave(-1);
            } catch (PitchMidiException ignored) {
            }
        }
    }

    public static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> void minimizeDistanceTo(@NonNull T selfChord, @NonNull ChordMidi<N, I, P> otherChord) {
        Objects.requireNonNull(otherChord);
        Objects.requireNonNull(selfChord);

        List<T> ret = getAllDispositionsWithInv(selfChord);
        int minDist = Integer.MAX_VALUE;
        T minDistChord = null;
        for (T chordMidiCandidate : ret) {
            int distValue = dist(otherChord, chordMidiCandidate);
            int absDistValue = Math.abs(distValue);
            if (absDistValue < minDist) {
                minDist = absDistValue;
                minDistChord = chordMidiCandidate;
            }
        }
        Objects.requireNonNull(minDistChord);
        selfChord.assign(minDistChord);
    }

    private static <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> _getWithAllInversions(T chordMidi) {
        List<T> ret = new ArrayList<>();
        T last = chordMidi;
        for (int i = 0; i < chordMidi.size(); i++) {
            last = (T) last.clone();
            ret.add(last);
            try {
                last.inv(); // todo: hacer con NormalChord y así evitar excepciones
            } catch (PitchException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        return ret;
    }

    public static <C extends ChordMidi> List<C> shiftOctaveList(List<C> a, int o) throws PitchMidiException {
        for (C c : a)
            c.shiftOctave(o);

        return a;
    }


    public static <N2 extends NoteMidi<?>> int dist(@NonNull ChordMidi<N2, ?, ?> n1, @NonNull ChordMidi<N2, ?, ?> n) {
        return dist(n1, n, true);
    }

    protected static <N2 extends NoteMidi<?>> int dist(@NonNull ChordMidi<N2, ?, ?> n1, @NonNull ChordMidi<N2, ?, ?> n, boolean bidirectional) {
        int d = 0;

        for (N2 i : n1) {
            int localMin = 9999;
            assert n.size() > 0;
            for (N2 j : n) {
                int m = Math.abs(j.pitch.getMidiCode() - i.pitch.getMidiCode());
                if (m < localMin)
                    localMin = m;
            }
            assert localMin < 127 && localMin >= 0;
            d += localMin;
        }

        if (bidirectional)
            d = Math.max(d, dist(n, n1, false));

        return d;
    }
}

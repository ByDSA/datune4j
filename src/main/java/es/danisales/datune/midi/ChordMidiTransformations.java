package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChordMidiTransformations {
    private ChordMidiTransformations() {
    }


    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllInversionsFrom(T chordMidi) {
        ChordMidi<N, I, P> c = chordMidi.clone();
        c.setMinOctave();
        minimize(c);

        return getAllDispositionsSub(c, true, 0, true);
    }

    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllDispositionsWithInv(T chordMidi) {
        List<T> ret = new ArrayList<>();
        List<T> bases = _getAllInversions(chordMidi);
        for (T c : bases)
            ret.addAll((List<T>) getAllInversionsFrom(c));

        return ret;
    }

    private static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> ChordMidi newChord(ChordMidi<N, I, P> chordMidi) {
        if (chordMidi instanceof DiatonicChordMidi)
            return DiatonicChordMidi.builder().build();
        else if (chordMidi instanceof ChromaticChordMidi)
            return ChromaticChordMidi.builder().build();

        return null;
    }

    protected static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> getAllDispositionsSub(ChordMidi<N, I, P> chordMidi, boolean sub, int level, boolean first) {
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

        }

        return ret;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static <N extends Note<?>> void minimize(ChordMidi<N, ?, ?> chordMidi) {
        for (int i = 1; i < chordMidi.size(); i++) {
            N note = chordMidi.get(i);
            N prev = chordMidi.get(i - 1);

            try {
                while (true)
                    note.getPitch().shiftOctave(-1);
            } catch (PitchMidiException ignored) {
            }
        }
    }

    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> void minimizeDistanceTo(T chordMidi, @NonNull ChordMidi cIn) {
        Objects.requireNonNull(cIn);

        List<T> ret = getAllDispositionsWithInv(chordMidi);
        int minDist = 9999;
        T minDistChord = null;
        for (T c : ret) {
            int d = (int) Math.abs(cIn.dist(c));
            if (d < minDist) {
                minDist = d;
                minDistChord = c;
            }
        }
        chordMidi.assign(minDistChord);
    }

    private static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface<I>, T extends ChordMidi<N, I, P>> List<T> _getAllInversions(T chordMidi) {
        List<T> ret = new ArrayList<>();

        ret.add((T) chordMidi.clone());

        T last = (T) chordMidi;
        for (int i = 0; i < chordMidi.size(); i++) {
            ret.add(last);
            last.inv();
        }

        return ret;
    }

    public static <C extends ChordMidi> List<C> shiftOctaveList(List<C> a, int o) {
        for (C c : a)
            c.shiftOctave(o);

        return a;
    }
}

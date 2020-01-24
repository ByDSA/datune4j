package es.danisales.datune.midi;

import es.danisales.datune.chords.Chord;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.voicing.AbsoluteVoicing;
import es.danisales.datune.voicing.Voicing;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ChordMidiTransformations {
    private ChordMidiTransformations() {
    }


    public static <C extends CyclicDegree> List<AbsoluteVoicing<C>> getAllInversionsFrom(AbsoluteVoicing<C> chordMidi) {
        //Voicing<C> c = Voicing.from(chordMidi);
        //c.setMinOctave();
        //minimize(c);

        return null;
        //return getAllDispositionsSub(c, true, 0, true);
    }
/*
    public static <C extends CyclicDegree, CH extends Chord<C>> List<AbsoluteVoicing<C>> getAllAbsoluteVoicesWithInv(CH chordMidi) {
        List<CH> ret = new ArrayList<>();
        List<CH> bases = _getWithAllInversions(chordMidi);
        for (CH c : bases)
            ret.addAll(getAllInversionsFrom(c));

        return ret;
    }
*/
    private static ChordMidi newChord(ChordMidi chordMidi) {
        if (chordMidi != null) {
            return ChordMidi.builder().build();
        }

        return null;
    }

    protected static
    List<ChordMidi> getAllDispositionsSub(ChordMidi chordMidi, boolean sub, int level, boolean first) {
        ArrayList<ChordMidi> ret = new ArrayList<>();
        assert chordMidi.size() > 0;

        if (first && level == 0)
            ret.add(chordMidi.clone());

        try {
            while ((chordMidi.size() > 1 && chordMidi.get(0).getPitch().getMidiCode() < chordMidi.get(1).getPitch().getMidiCode()
                    || chordMidi.size() == 1)) {
                if (!first) {
                    ChordMidi d = chordMidi.clone();
                    ret.add(d);
                }

                if (sub && chordMidi.size() > 1) {
                    // Copia acorde desde la segunda a la última nota
                    ChordMidi subChord = (ChordMidi)newChord(chordMidi);
                    for (int j = 1; j < chordMidi.size(); j++)
                        subChord.add(chordMidi.get(j).clone());

                    List<ChordMidi> subCombinations = getAllDispositionsSub(subChord.clone(), true, level + 1, first);
                    for (ChordMidi subCombination : subCombinations) {
                        // Forma listOf superChord = [listOf[0] + subChordcombination]
                        ChordMidi superChord = (ChordMidi)newChord(chordMidi);
                        superChord.add(chordMidi.get(0).clone());
                        superChord.addAll(subCombination.clone());

                        // Combinaciones de 'número' dentro del listOf superChord = ['número' +
                        // subChordcombination]
                        List<ChordMidi> superCombinations = getAllDispositionsSub(superChord.clone(), false, level, false);
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

    public static <C extends CyclicDegree> void minimize(Voicing<C> chordMidi) {
        for (int i = 1; i < chordMidi.size(); i++) {
            Voicing.RelativeVoice<C> note = chordMidi.get(i);
            Voicing.RelativeVoice<C> prev = chordMidi.get(i - 1);

            while (note.getOctave() > prev.getOctave())
                note.shiftOctave(-1);
        }
    }
/*
    public static <C extends CyclicDegree> AbsoluteVoicing<C> minimizeDistanceTo(@NonNull AbsoluteVoicing<C> selfChord, @NonNull AbsoluteVoicing<C> otherChord) {
        Objects.requireNonNull(otherChord);
        Objects.requireNonNull(selfChord);

        List<AbsoluteVoicing<C>> ret = getAllAbsoluteVoicesWithInv(selfChord);
        int minDist = Integer.MAX_VALUE;
        AbsoluteVoicing<C> minDistChord = null;
        for (AbsoluteVoicing<C> chordMidiCandidate : ret) {
            int distValue = dist(otherChord, chordMidiCandidate);
            int absDistValue = Math.abs(distValue);
            if (absDistValue < minDist) {
                minDist = absDistValue;
                minDistChord = chordMidiCandidate;
            }
        }
        Objects.requireNonNull(minDistChord);
        return minDistChord;
    }
*/
    private static <C extends CyclicDegree> List<Chord<C>> _getWithAllInversions(Chord<C> chordMidi) {
        List<Chord<C>> ret = new ArrayList<>();
        Chord<C> last = chordMidi;
        for (int i = 0; i < chordMidi.size(); i++) {
            last = last.clone();
            ret.add(last);
            last.inv();
        }

        return ret;
    }

    public static List<ChordMidi> shiftOctaveList(List<ChordMidi> a, int o) throws PitchMidiException {
        for (ChordMidi c : a)
            c.shiftOctave(o);

        return a;
    }


    public static int dist(@NonNull ChordMidi n1, @NonNull ChordMidi n) {
        return dist(n1, n, true);
    }

    protected static int dist(@NonNull ChordMidi n1, @NonNull ChordMidi n, boolean bidirectional) {
        int d = 0;

        for (NoteMidi i : n1) {
            int localMin = 9999;
            assert n.size() > 0;
            for (NoteMidi j : n) {
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

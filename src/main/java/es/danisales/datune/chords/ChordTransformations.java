package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.NoteMidi;

import java.util.ArrayList;
import java.util.List;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public static <C extends CyclicDegree, T extends Chord<C>> T removeHigherDuplicates(T inputChord) {
        Chord<C> chord = new Chord<C>();
        for (C n : inputChord) {
            if (!chord.contains(n))
                chord.add(n);
        }

        inputChord.clear();
        inputChord.addAll(chord);

        return (T) chord;
    }

    public static <CH extends Chord<C>, C extends CyclicDegree> List<CH> getAllInversionsFrom(CH chord) {
        List<CH> ret = new ArrayList<>();

        CH last = (CH) chord.clone();
        for (int i = 0; i < chord.size(); i++) {
            ret.add((CH) last.clone());
            if (i < chord.size() - 1) {
                last.inv();
            }
        }

        return ret;
    }
}

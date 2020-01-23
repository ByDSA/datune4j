package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.ChromaticMidi;

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

    public static void removeHigherDuplicates(ChordMidi self) {
        ChordMidi out = ChordMidi.builder().build();
        for (ChromaticMidi chromaticMidi : self) {
            boolean found = false;
            for (ChromaticMidi chromaticMidi2 : out) {
                Chromatic chromaticN2 = chromaticMidi2.getPitch().getNote();
                Chromatic chromaticN = chromaticMidi.getPitch().getNote();
                if (chromaticN2.ordinal() == chromaticN.ordinal()) {
                    found = true;
                    break;
                }
            }

            if (!found)
                out.add(chromaticMidi);
        }

        self.clear();
        self.addAll(out);
    }

    public static <CH extends Chord<C>, C extends CyclicDegree> List<CH> getAllInversionsFrom(CH chordMutableInterface) {
        List<CH> ret = new ArrayList<>();

        CH last = (CH) chordMutableInterface.clone();
        for (int i = 0; i < chordMutableInterface.size(); i++) {
            ret.add((CH) last.clone());
            if (i < chordMutableInterface.size() - 1) {
                last.inv();
            }
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    public static <C extends Chord> ArrayList<C> duplicateList(List<C> a) {
        ArrayList<C> b = new ArrayList<>();
        for (C c : a)
            b.add((C) c.clone());

        return b;
    }
}

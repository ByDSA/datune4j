package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.CyclicDegree;

import java.util.ArrayList;
import java.util.List;

public class ChordTransformations {
    private ChordTransformations() {
    }

    public static <CH extends Chord<C>, C extends CyclicDegree> List<CH> getAllInversionsFrom(CH chord) {
        List<CH> ret = new ArrayList<>();

        //noinspection unchecked
        CH last = (CH) chord.clone();
        for (int i = 0; i < chord.size(); i++) {
            //noinspection unchecked
            ret.add((CH) last.clone());
            if (i < chord.size() - 1) {
                last.inv();
            }
        }

        return ret;
    }
}

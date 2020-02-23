package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

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

    static List<Integer> getMinDistances(ChromaticChord chromaticChordFrom, ChromaticChord chromaticChordTo) {
        List<Integer> ret = new ArrayList<>();
        for (Chromatic chromaticFrom : chromaticChordFrom){
            int min = Integer.MAX_VALUE;
            for (Chromatic chromaticTo : chromaticChordTo) {
                int semis = chromaticFrom.minDistSemitonesTo(chromaticTo);
                if (semis < min)
                    min = semis;
            }
            ret.add(min);
        }

        return ret;
    }

    public static List<IntervalChromatic> getIntraIntervals(@NonNull ChromaticChord chromaticChord) {
        List<IntervalChromatic> ret = new ArrayList<>();
        for (int i = 0; i < chromaticChord.size(); i++){
            for (int j = i+1; j < chromaticChord.size(); j++) {
                Chromatic chromaticFrom = chromaticChord.get(i);
                Chromatic chromaticTo = chromaticChord.get(j);

                int semis = chromaticFrom.distSemitonesTo(chromaticTo);
                IntervalChromatic intervalChromatic = IntervalChromatic.from(semis);
                ret.add(intervalChromatic);
            }
        }

        return ret;
    }

    public static List<Integer> getAllIntervalsWithNote(ChromaticChord chromaticChordFrom, Chromatic chromaticTo) {
        List<Integer> ret = new ArrayList<>();
        for (Chromatic chromaticFrom : chromaticChordFrom) {
            int semis = chromaticFrom.distSemitonesTo(chromaticTo);
            ret.add(semis);
        }

        return ret;
    }
}

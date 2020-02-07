package es.danisales.datune.chords;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.CyclicDegree;
import es.danisales.datune.interval.IntervalChromatic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static List<Integer> getMinIntraIntervals(ChromaticChord chromaticChord) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < chromaticChord.size(); i++){
            for (int j = 0; j < i; j++) {
                Chromatic chromaticFrom = chromaticChord.get(i);
                Chromatic chromaticTo = chromaticChord.get(j);

                int semis = chromaticFrom.minDistSemitonesTo(chromaticTo);
                ret.add(semis);
            }
        }

        return ret;
    }

    public static List<Integer> getMinDistances(ChromaticChord chromaticChordFrom, ChromaticChord chromaticChordTo) {
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

    public static List<IntervalChromatic> getIntraIntervals(ChromaticChord chromaticChord) {
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

    public static Set<Integer> getAllIntervals(ChromaticChord chromaticChordFrom, ChromaticChord chromaticChordTo) {
        Set<Integer> ret = new HashSet<>();
        for (int i = 0; i < chromaticChordFrom.size(); i++){
            for (int j = i+1; j < chromaticChordTo.size(); j++) {
                Chromatic chromaticFrom = chromaticChordFrom.get(i);
                Chromatic chromaticTo = chromaticChordTo.get(j);

                int semis = chromaticFrom.distSemitonesTo(chromaticTo);
                ret.add(semis);
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

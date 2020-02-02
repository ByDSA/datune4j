package es.danisales.datune.gravity;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import javafx.util.Pair;

import java.util.*;

public class GravityChromaticChords {
    private GravityChromaticChords() {
    }

    private ChromaticChord from, to;
    private List<Pair<Integer, Integer>> results;

    public static GravityChromaticChords from(ChromaticChord from, ChromaticChord to) {
        GravityChromaticChords gravityChords = new GravityChromaticChords();

        gravityChords.from = from.clone();
        gravityChords.to = to.clone();

        gravityChords.from.toFundamental();
        gravityChords.to.toFundamental();

        return gravityChords;
    }

    private static List<Pair<Chromatic, Chromatic>> getAllChordIntervals(ChromaticChord chromaticChord) {
        List<Pair<Chromatic, Chromatic>> ret = new ArrayList<>();
        for (int i = 0; i < chromaticChord.size(); i++) {
            for (int j = 0; j < chromaticChord.size(); j++) {
                if (i == j)
                    continue;

                Pair<Chromatic, Chromatic> pair = new Pair<>(chromaticChord.get(i), chromaticChord.get(j));
                ret.add(pair);
            }
        }

        return ret;
    }

    public static Set<Pair<Chromatic, Chromatic>> getTendencies(ChromaticChord chromaticChord) {
        Set<Pair<Chromatic, Chromatic>> tendencies = new HashSet<>();

        List<Pair<Chromatic, Chromatic>> list = getAllChordIntervals(chromaticChord);
        for (Pair<Chromatic, Chromatic> pair : list) {
            int semis = pair.getKey().distSemitonesTo(pair.getValue());
            if (semis == 5) {
                Pair<Chromatic, Chromatic> tendence = new Pair<>(pair.getValue(), pair.getValue().getPrevious());
                tendencies.add(tendence);
            } else if (semis == 6) {
                Pair<Chromatic, Chromatic> tendence1 = new Pair<>(pair.getKey(), pair.getKey().getNext());
                Pair<Chromatic, Chromatic> tendence2 = new Pair<>(pair.getValue(), pair.getValue().getNext(2));
                tendencies.add(tendence1);
                tendencies.add(tendence2);
            } else if (semis == 7) {
                Pair<Chromatic, Chromatic> tendence = new Pair<>(pair.getKey(), pair.getKey().getPrevious());
                tendencies.add(tendence);
            }
        }

        return tendencies;
    }

    private static Set<Pair<Chromatic, Chromatic>[]> getTendenciesCombinations(Set<Pair<Chromatic, Chromatic>> tendencies) {
        return TendenciesCombination.getCombinations(new ArrayList<>(tendencies));
    }

    public static Set<ChromaticChord> getChordsTendencies(ChromaticChord chromaticChord) {
        Set<ChromaticChord> ret = new HashSet<>();

        Set<Pair<Chromatic, Chromatic>> tendencies = getTendencies(chromaticChord);
        Set<Pair<Chromatic, Chromatic>[]> tendenciesCombinations = getTendenciesCombinations(tendencies);
        for (Pair<Chromatic, Chromatic>[] combination : tendenciesCombinations) {
            for (ChromaticChord chromaticChord1 : ChromaticChord.immutableValues())
                if (hasAllTendencyChromatic(combination, chromaticChord1))
                    ret.add(chromaticChord1);
        }
        return ret;
    }

    private static boolean hasAllTendencyChromatic(Pair<Chromatic, Chromatic>[] combination, ChromaticChord chromaticChord) {
        for (Pair<Chromatic, Chromatic> pair : combination)
            if (!chromaticChord.contains(pair.getValue()))
                return false;

        return true;
    }

        /*

Tendencia interválica (vertical)
    SUS4 -> Mayor (IV -> III) [0-5 -> 0-4] / [0-7 -> -1-7]
    DIM -> Mayor (VII -> I, II -> III, IV -> V) [0-6 -> 1-8]
    DIM -> Minor (VII -> I, II -> IIIm, IV -> V) [0-6 -> 1-8]

    Tendencia tonal (horizontal)

     */
}

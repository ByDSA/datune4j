package es.danisales.datune.musical;

import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;

import java.util.List;

public class ChromaticChordChecker {
    private ChromaticChordChecker() {
    }

    public static class Result {
        Tonality tonality;
        HarmonicFunction function;
    }

    public static List<Result> getWhatIs(ChromaticChord chromatics) {
        return null;
    }
}

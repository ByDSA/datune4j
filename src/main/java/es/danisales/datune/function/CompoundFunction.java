package es.danisales.datune.function;

import es.danisales.datune.degrees.scale.ChromaticDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CompoundFunction extends ChromaticDegreeFunction {
    CompoundFunction(String str, @NonNull ChromaticDegreeFunction... array) {
        super(str, getChromaticDegreeFromArray(array), array[array.length-1].getChromaticChordPattern());
    }

    private static ChromaticDegree getChromaticDegreeFromArray(@NonNull ChromaticDegreeFunction[] array) {
        ChromaticDegree chromaticDegree = ChromaticDegree.I;
        for (ChromaticDegreeFunction chromaticDegreeFunction : array) {
            chromaticDegree = chromaticDegree.getShifted(chromaticDegreeFunction.getChromaticDegree().ordinal());
        }

        return chromaticDegree;
    }

    public static ChromaticDegreeFunction from(@NonNull ChromaticDegreeFunction... array) {
        return new CompoundFunction("", array);
    }
}

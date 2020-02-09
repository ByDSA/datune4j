package es.danisales.datune.function;

import es.danisales.datune.degrees.scale.ChromaticDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ChromaticFunctionTransformations {
    private ChromaticFunctionTransformations() {
    }

    public static @NonNull ChromaticDegreeFunction shift(@NonNull ChromaticDegreeFunction chromaticDegreeFunction, int i) {
        ChromaticDegree chromaticDegree = chromaticDegreeFunction.getChromaticDegree().getShifted(i);

        return ChromaticDegreeFunction.from(chromaticDegree, chromaticDegreeFunction.getChromaticChordPattern());
    }
}

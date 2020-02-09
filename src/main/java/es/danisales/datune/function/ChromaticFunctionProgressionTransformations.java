package es.danisales.datune.function;

import java.util.Collections;

public class ChromaticFunctionProgressionTransformations {
    private ChromaticFunctionProgressionTransformations() {
    }

    @SuppressWarnings("WeakerAccess")
    public static ChromaticFunctionProgression rotate(ChromaticFunctionProgression chromaticFunctionProgression, int n) {
        ChromaticFunctionProgression chromaticFunctionProgression1 = chromaticFunctionProgression.clone();
        Collections.rotate(chromaticFunctionProgression1, n);
        return chromaticFunctionProgression1;
    }

    public static ChromaticFunctionProgression shift(ChromaticFunctionProgression chromaticFunctionProgression, int n) {
        ChromaticFunctionProgression chromaticFunctionProgression1 = chromaticFunctionProgression.clone();
        for (int i = 0; i < chromaticFunctionProgression1.size(); i++) {
            if (chromaticFunctionProgression1.get(i) instanceof ChromaticDegreeFunction)
                chromaticFunctionProgression1.set(i, ChromaticFunctionTransformations.shift((ChromaticDegreeFunction)chromaticFunctionProgression.get(i), n));
        }
        return chromaticFunctionProgression1;
    }
}

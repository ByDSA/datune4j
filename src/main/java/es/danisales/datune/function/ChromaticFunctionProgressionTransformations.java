package es.danisales.datune.function;

import java.util.Collection;
import java.util.Collections;

public class ChromaticFunctionProgressionTransformations {
    private ChromaticFunctionProgressionTransformations() {
    }

    public static ChromaticFunctionProgression rotate(ChromaticFunctionProgression chromaticFunctionProgression, int n) {
        ChromaticFunctionProgression chromaticFunctionProgression1 = chromaticFunctionProgression.clone();
        Collections.rotate(chromaticFunctionProgression1, n);
        return chromaticFunctionProgression1;
    }

    public static ChromaticFunctionProgression shift(ChromaticFunctionProgression chromaticFunctionProgression, int n) {
        ChromaticFunctionProgression chromaticFunctionProgression1 = chromaticFunctionProgression.clone();
        for (int i = 0; i < chromaticFunctionProgression1.size(); i++) {
            chromaticFunctionProgression1.set(i, ChromaticFunctionTransformations.shift(chromaticFunctionProgression.get(i), n));
        }
        return chromaticFunctionProgression1;
    }
}

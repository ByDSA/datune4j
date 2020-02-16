package es.danisales.datune.function.progression;

import es.danisales.datune.function.ChromaticDegreeFunction;

public class ChromaticFunctionProgressionTransformations {
    private ChromaticFunctionProgressionTransformations() {
    }

    public static HarmonicFunctionProgression shift(HarmonicFunctionProgression chromaticFunctionProgression, int n) {
        HarmonicFunctionProgression chromaticFunctionProgression1 = chromaticFunctionProgression.clone();
        for (int i = 0; i < chromaticFunctionProgression1.size(); i++) {
            if (chromaticFunctionProgression1.get(i) instanceof ChromaticDegreeFunction)
                chromaticFunctionProgression1.set(i, ((ChromaticDegreeFunction)chromaticFunctionProgression.get(i)).getShifted(n));
        }
        return chromaticFunctionProgression1;
    }
}

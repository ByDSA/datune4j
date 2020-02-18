package es.danisales.datune.function;

import es.danisales.datune.function.progression.HarmonicFunctionProgression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChromaticFunctionProgressionTransformationsTest {

    @Test
    public void rotate() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.builder()
                .addAll(HarmonicFunctionProgression.I_V_vi_IV)
                .rotate(2)
                .build();

        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(3));
    }

    @Test
    public void shift() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.builder()
                .addAll(HarmonicFunctionProgression.I_V_vi_IV)
                .shift(3)
                .build();

        assertEquals(ChromaticDegreeFunction.bIII, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.bVII, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.i, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.bVI, chromaticFunctionProgression.get(3));
    }
}
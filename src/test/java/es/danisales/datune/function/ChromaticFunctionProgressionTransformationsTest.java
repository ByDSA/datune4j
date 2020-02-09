package es.danisales.datune.function;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChromaticFunctionProgressionTransformationsTest {

    @Test
    public void rotate() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgressionTransformations.rotate(ChromaticFunctionProgression.I_V_vi_IV, 2);

        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(3));
    }

    @Test
    public void shift() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgressionTransformations.shift(ChromaticFunctionProgression.I_V_vi_IV, 3);

        assertEquals(ChromaticDegreeFunction.bIII, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.bVII, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.i, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.bVI, chromaticFunctionProgression.get(3));
    }
}
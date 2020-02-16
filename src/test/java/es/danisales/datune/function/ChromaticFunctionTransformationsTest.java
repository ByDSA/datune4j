package es.danisales.datune.function;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChromaticFunctionTransformationsTest {

    @Test
    public void shift() {
        ChromaticDegreeFunction chromaticDegreeFunction = ChromaticDegreeFunction.I.getShifted(4);
        assertEquals(ChromaticDegreeFunction.III, chromaticDegreeFunction);
    }
}
package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionProgressionTest {
    @Test
    public void I_V_vi_iv() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.I_V_vi_IV;

        assertEquals(ChromaticFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticFunction.IV, chromaticFunctionProgression.get(3));
    }

    @Test
    public void I_iv_vi_V() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.I_IV_vi_V;

        assertEquals(ChromaticFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticFunction.IV, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticFunction.V, chromaticFunctionProgression.get(3));
    }

    @Test
    public void i_vi_III_VII() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.i_VI_III_VII;

        assertEquals(ChromaticFunction.i, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticFunction.VI, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticFunction.III, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticFunction.VII, chromaticFunctionProgression.get(3));
    }

    @Test
    public void getChordsFrom_I_V_vi_iv() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.I_V_vi_IV;

        List<ChromaticChord> chromaticChordProgression = chromaticFunctionProgression.getChordsFrom(Tonality.ET12.C);
        assertEquals(ChromaticChord.C, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.G, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.Am, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.F, chromaticChordProgression.get(3));
    }

    @Test
    public void getChordsFrom_i_vi_III_VII() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.i_VI_III_VII;

        List<ChromaticChord> chromaticChordProgression = chromaticFunctionProgression.getChordsFrom(Tonality.ET12.Am);
        assertEquals(ChromaticChord.Am, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.F, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.C, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.G, chromaticChordProgression.get(3));
    }

    @Test
    public void create() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.create();
        assertNotNull(chromaticFunctionProgression);
    }

    @Test
    public void copyOf() {
        ChromaticFunctionProgression chromaticFunctionProgression = ChromaticFunctionProgression.copyOf(
                Arrays.asList(
                        ChromaticFunction.I,
                        ChromaticFunction.V,
                        ChromaticFunction.vi,
                        ChromaticFunction.IV
                )
        );

        assertEquals(ChromaticFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticFunction.IV, chromaticFunctionProgression.get(3));
    }
}
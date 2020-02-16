package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.progression.HarmonicFunctionProgression;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChromaticFunctionProgressionTest {
    @Test
    public void I_V_vi_iv() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.I_V_vi_IV;

        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(3));
    }

    @Test
    public void I_iv_vi_V() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.I_IV_vi_V;

        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(3));
    }

    @Test
    public void cloneTest() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.I_IV_vi_V.clone();

        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(3));
    }

    @Test
    public void i_VI_III_VII() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.i_bVI_bIII_bVII;

        assertEquals(ChromaticDegreeFunction.i, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.bVI, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.bIII, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.bVII, chromaticFunctionProgression.get(3));
    }

    @Test
    public void getChordsFrom_I_V_vi_IV() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.I_V_vi_IV;

        List<ChromaticChord> chromaticChordProgression = chromaticFunctionProgression.getChordsFrom(Tonality.ET12.C);
        assertEquals(ChromaticChord.C, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.G, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.Am, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.F, chromaticChordProgression.get(3));
    }

    @Test
    public void getChordsFrom_i_VI_III_VII() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.i_bVI_bIII_bVII;

        List<ChromaticChord> chromaticChordProgression = chromaticFunctionProgression.getChordsFrom(Tonality.ET12.Am);
        assertEquals(ChromaticChord.Am, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.F, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.C, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.G, chromaticChordProgression.get(3));
    }

    @Test
    public void create() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.create();
        assertNotNull(chromaticFunctionProgression);
    }

    @Test
    public void copyOf() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.copyOf(
                Arrays.asList(
                        ChromaticDegreeFunction.I,
                        ChromaticDegreeFunction.V,
                        ChromaticDegreeFunction.vi,
                        ChromaticDegreeFunction.IV
                )
        );

        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(3));
    }
}
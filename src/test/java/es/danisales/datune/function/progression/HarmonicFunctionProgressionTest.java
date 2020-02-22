package es.danisales.datune.function.progression;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.tonality.Tonality;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HarmonicFunctionProgressionTest {
    @Test
    public void I_V_vi_iv() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.I_V_vi_IV;

        Assert.assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(3));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutable_areReallyImmutable_remove() {
        HarmonicFunctionProgression.I_V_vi_IV.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutable_areReallyImmutable_set() {
        HarmonicFunctionProgression.I_V_vi_IV.set(0, ChromaticDegreeFunction.i);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutable_areReallyImmutable_add1() {
        HarmonicFunctionProgression.I_V_vi_IV.add(0,ChromaticDegreeFunction.i);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutable_areReallyImmutable_add2() {
        HarmonicFunctionProgression.I_V_vi_IV.add(ChromaticDegreeFunction.i);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutable_areReallyImmutable_clear() {
        HarmonicFunctionProgression.I_V_vi_IV.clear();
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
    public void getChordsFrom_rhythmChanges() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.RHYTHM_CHANGES;

        List<ChromaticChord> chromaticChordProgression = chromaticFunctionProgression.getChordsFrom(Tonality.ET12.DD);
        assertEquals(ChromaticChord.DDMaj7, chromaticChordProgression.get(0));
        assertEquals(ChromaticChord.Cm7, chromaticChordProgression.get(1));
        assertEquals(ChromaticChord.Fm7, chromaticChordProgression.get(2));
        assertEquals(ChromaticChord.AA7, chromaticChordProgression.get(3));
        assertEquals(ChromaticChord.Gm7, chromaticChordProgression.get(4));
        assertEquals(ChromaticChord.C7, chromaticChordProgression.get(5));
        assertEquals(ChromaticChord.Fm7, chromaticChordProgression.get(6));
        assertEquals(ChromaticChord.AA7, chromaticChordProgression.get(7));
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
    public void build_empty() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.builder().build();
        assertNotNull(chromaticFunctionProgression);
    }

    @Test
    public void copyOf() {
        HarmonicFunctionProgression chromaticFunctionProgression = HarmonicFunctionProgression.builder()
                .add(
                        ChromaticDegreeFunction.I,
                        ChromaticDegreeFunction.V,
                        ChromaticDegreeFunction.vi,
                        ChromaticDegreeFunction.IV
                ).build();

        assertEquals(ChromaticDegreeFunction.I, chromaticFunctionProgression.get(0));
        assertEquals(ChromaticDegreeFunction.V, chromaticFunctionProgression.get(1));
        assertEquals(ChromaticDegreeFunction.vi, chromaticFunctionProgression.get(2));
        assertEquals(ChromaticDegreeFunction.IV, chromaticFunctionProgression.get(3));
    }
}
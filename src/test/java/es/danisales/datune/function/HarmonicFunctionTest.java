package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HarmonicFunctionTest {
    @Test
    public void get() {
        Tonality<Chromatic> tonality = Tonality.Cm;
        ChromaticChord chromaticChord = ChromaticChord.DD;
        Set<HarmonicFunction> harmonicFunctions = tonality.getFunctionsFrom(chromaticChord);

        assertEquals(2, harmonicFunctions.size());
        assertTrue(harmonicFunctions.contains(DiatonicFunction.III));
        assertTrue(harmonicFunctions.contains(ChromaticDegreeFunction.bIII));
    }

    @Test
    public void get_chromaticChordInverted() {
        Tonality<Chromatic> tonality = Tonality.Cm;
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        chromaticChord.inv();
        Set<HarmonicFunction> harmonicFunctions = tonality.getFunctionsFrom(chromaticChord);

        assertEquals(2, harmonicFunctions.size());
        assertTrue(harmonicFunctions.contains(DiatonicFunction.III));
        assertTrue(harmonicFunctions.contains(ChromaticDegreeFunction.bIII));
    }

    @Test
    public void get_cachePersistence_setScale() {
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        Tonality<Chromatic> tonality = Tonality.C.clone();
        tonality.getFunctionsFrom(chromaticChord); // creates caches
        tonality.setScale(Scale.MINOR); // should clear caches
        Set<HarmonicFunction> harmonicFunctions = tonality.getFunctionsFrom(chromaticChord); // should recreate caches

        assertEquals(2, harmonicFunctions.size());
        assertTrue(harmonicFunctions.contains(DiatonicFunction.III));
        assertTrue(harmonicFunctions.contains(ChromaticDegreeFunction.bIII));
    }

    @Test
    public void get_cachePersistence_setRoot() {
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        Tonality<Chromatic> tonality = Tonality.C.clone();
        tonality.getFunctionsFrom(chromaticChord); // creates caches
        tonality.setRoot(Chromatic.DD); // should clear caches
        Set<HarmonicFunction> harmonicFunctions = tonality.getFunctionsFrom(chromaticChord); // should recreate caches

        assertEquals(3, harmonicFunctions.size());
        assertTrue(harmonicFunctions.contains(DiatonicFunction.I));
        assertTrue(harmonicFunctions.contains(ChromaticDegreeFunction.I));
        assertTrue(harmonicFunctions.contains(SecondaryDominant.V_IV));
    }
}
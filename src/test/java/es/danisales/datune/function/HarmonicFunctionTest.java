package es.danisales.datune.function;

import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HarmonicFunctionTest {
    @Test
    public void get() {
        Tonality tonality = Tonality.Cm;
        ChromaticChord chromaticChord = ChromaticChord.DD;
        HarmonicFunction harmonicFunction = HarmonicFunction.get(chromaticChord, tonality);

        assertTrue(harmonicFunction instanceof DiatonicFunction);
        assertEquals(DiatonicFunction.III, harmonicFunction);
    }

    @Test
    public void get_chromaticChordInverted() {
        Tonality tonality = Tonality.Cm;
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        chromaticChord.inv();
        HarmonicFunction harmonicFunction = HarmonicFunction.get(chromaticChord, tonality);

        assertTrue(harmonicFunction instanceof DiatonicFunction);
        assertEquals(DiatonicFunction.III, harmonicFunction);
    }

    @Test
    public void get_cachePersistence_setScale() {
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        Tonality tonality = Tonality.C.clone();
        HarmonicFunction.get(chromaticChord, tonality); // creates caches
        tonality.setScale(Scale.MINOR); // should clear caches
        HarmonicFunction harmonicFunction = HarmonicFunction.get(chromaticChord, tonality); // should recreate caches

        assertTrue(harmonicFunction instanceof DiatonicFunction);
        assertEquals(DiatonicFunction.III, harmonicFunction);
    }

    @Test
    public void get_cachePersistence_setRoot() {
        ChromaticChord chromaticChord = ChromaticChord.DD.clone();
        Tonality tonality = Tonality.C.clone();
        HarmonicFunction.get(chromaticChord, tonality); // creates cache
        tonality.setRoot(DiatonicAlt.Eb); // should clear caches
        HarmonicFunction harmonicFunction = HarmonicFunction.get(chromaticChord, tonality); // should recreate caches

        assertTrue(harmonicFunction instanceof DiatonicFunction);
        assertEquals(DiatonicFunction.I, harmonicFunction);
    }
}
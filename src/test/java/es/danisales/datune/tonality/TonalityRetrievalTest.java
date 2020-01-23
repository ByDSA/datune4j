package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicAlt;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TonalityRetrievalTest {
    /* Main Major */

    @Test
    public void mainMajorSize() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ET12.ALL_MAJOR;

        assertEquals(12, tonalitySet.size());
    }

    @Test
    public void mainMajorContent() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ET12.ALL_MAJOR;

        assertTrue(tonalitySet.contains(Tonality.ET12.C));
        assertTrue(tonalitySet.contains(Tonality.ET12.CC));
        assertTrue(tonalitySet.contains(Tonality.ET12.D));
        assertTrue(tonalitySet.contains(Tonality.ET12.DD));
        assertTrue(tonalitySet.contains(Tonality.ET12.E));
        assertTrue(tonalitySet.contains(Tonality.ET12.F));
        assertTrue(tonalitySet.contains(Tonality.ET12.FF));
        assertTrue(tonalitySet.contains(Tonality.ET12.G));
        assertTrue(tonalitySet.contains(Tonality.ET12.GG));
        assertTrue(tonalitySet.contains(Tonality.ET12.A));
        assertTrue(tonalitySet.contains(Tonality.ET12.AA));
        assertTrue(tonalitySet.contains(Tonality.ET12.B));
    }

    @Test
    public void mainMajorAreReallyMajor() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ET12.ALL_MAJOR;

        for (Tonality tonality : tonalitySet)
            assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    /* Main Minor */

    @Test
    public void getScale_ALL_MINOR() {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ET12.ALL_MINOR;
        for (Tonality<Chromatic> tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test
    public void getScale_ALL_MAJOR() {
        Set<Tonality<Chromatic>> tonalities = TonalityRetrieval.ET12.ALL_MAJOR;
        for (Tonality<Chromatic> tonality : tonalities)
            TestCase.assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    @Test
    public void mainMinorSize() {
        Set<Tonality<Chromatic>> tonalityList = TonalityRetrieval.ET12.ALL_MINOR;

        assertEquals(12, tonalityList.size());
    }

    @Test
    public void mainMinorContent() {
        Set<Tonality<Chromatic>> tonalitySet = TonalityRetrieval.ET12.ALL_MINOR;

        assertTrue(tonalitySet.contains(Tonality.ET12.Cm));
        assertTrue(tonalitySet.contains(Tonality.ET12.CCm));
        assertTrue(tonalitySet.contains(Tonality.ET12.Dm));
        assertTrue(tonalitySet.contains(Tonality.ET12.DDm));
        assertTrue(tonalitySet.contains(Tonality.ET12.Em));
        assertTrue(tonalitySet.contains(Tonality.ET12.Fm));
        assertTrue(tonalitySet.contains(Tonality.ET12.FFm));
        assertTrue(tonalitySet.contains(Tonality.ET12.Gm));
        assertTrue(tonalitySet.contains(Tonality.ET12.GGm));
        assertTrue(tonalitySet.contains(Tonality.ET12.Am));
        assertTrue(tonalitySet.contains(Tonality.ET12.AAm));
        assertTrue(tonalitySet.contains(Tonality.ET12.Bm));
    }

    @Test
    public void mainMinorAreRealleMinor() {
        Set<Tonality<Chromatic>> tonalityList = TonalityRetrieval.ET12.ALL_MINOR;

        for (Tonality tonality : tonalityList)
            assertEquals(tonality.getScale(), Scale.MINOR);
    }

    @Test(timeout = 1000)
    public void fromChordHarmonicFunction() {
        List<Tonality<Chromatic>> ts = TonalityRetrieval.listFromChordAllFunctions(ChromaticChord.C);
        assertFalse(ts.isEmpty());
    }

    @Test
    public void getEnharmonicMinimalAltsFromPentatonic() {
        Tonality target = Tonality.from(DiatonicAlt.Eb, Scale.PENTATONIC_MINOR);
        Tonality target2 = Tonality.from(DiatonicAlt.DD, Scale.PENTATONIC_MINOR);
        Tonality source = Tonality.from(DiatonicAlt.Fbb, Scale.PENTATONIC_MINOR);
        Set<Tonality> result = TonalityRetrieval.getEnharmonicMinimalAltsFrom(source);

        assertEquals(2, result.size());
        assertTrue(result.contains(target));
        assertTrue(result.contains(target2));
    }

    @Test
    public void getEnharmonicMinimalAltsFromDiatonic() {
        Tonality target1 = Tonality.FF;
        Tonality target2 = Tonality.Gb;
        Tonality tonality = Tonality.from(DiatonicAlt.EEE, Scale.MAJOR);
        Set<Tonality> result = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);

        assertEquals(2, result.size());
        assertTrue(result.contains(target1));
        assertTrue(result.contains(target2));
    }
}

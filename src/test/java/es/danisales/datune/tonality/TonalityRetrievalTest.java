package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
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
        Set<Tonality> tonalitySet = TonalityRetrieval.getMainMajorScaleTonalities();

        assertEquals(13, tonalitySet.size());
    }

    @Test
    public void mainMajorContent() {
        Set<Tonality> tonalitySet = TonalityRetrieval.getMainMajorScaleTonalities();

        assertTrue(tonalitySet.contains(Tonality.C));
        assertTrue(tonalitySet.contains(Tonality.Db));
        assertTrue(tonalitySet.contains(Tonality.D));
        assertTrue(tonalitySet.contains(Tonality.Eb));
        assertTrue(tonalitySet.contains(Tonality.E));
        assertTrue(tonalitySet.contains(Tonality.F));
        assertTrue(tonalitySet.contains(Tonality.FF));
        assertTrue(tonalitySet.contains(Tonality.Gb));
        assertTrue(tonalitySet.contains(Tonality.G));
        assertTrue(tonalitySet.contains(Tonality.Ab));
        assertTrue(tonalitySet.contains(Tonality.A));
        assertTrue(tonalitySet.contains(Tonality.Bb));
        assertTrue(tonalitySet.contains(Tonality.B));
    }

    @Test
    public void mainMajorAreReallyMajor() {
        Set<Tonality> tonalitySet = TonalityRetrieval.getMainMajorScaleTonalities();

        for (Tonality tonality : tonalitySet)
            assertEquals(tonality.getScale(), Scale.MAJOR);
    }

    /* Main Minor */

    @Test
    public void mainMinorSize() {
        Set<Tonality> tonalityList = TonalityRetrieval.getMainMinorScaleTonalities();

        assertEquals(13, tonalityList.size());
    }

    @Test
    public void mainMinorContent() {
        Set<Tonality> tonalitySet = TonalityRetrieval.getMainMinorScaleTonalities();

        assertTrue(tonalitySet.contains(Tonality.Cm));
        assertTrue(tonalitySet.contains(Tonality.CCm));
        assertTrue(tonalitySet.contains(Tonality.Dm));
        assertTrue(tonalitySet.contains(Tonality.DDm));
        assertTrue(tonalitySet.contains(Tonality.Ebm));
        assertTrue(tonalitySet.contains(Tonality.Em));
        assertTrue(tonalitySet.contains(Tonality.Fm));
        assertTrue(tonalitySet.contains(Tonality.FFm));
        assertTrue(tonalitySet.contains(Tonality.Gm));
        assertTrue(tonalitySet.contains(Tonality.GGm));
        assertTrue(tonalitySet.contains(Tonality.Am));
        assertTrue(tonalitySet.contains(Tonality.Bbm));
        assertTrue(tonalitySet.contains(Tonality.Bm));
    }

    @Test
    public void mainMinorAreRealleMinor() {
        Set<Tonality> tonalityList = TonalityRetrieval.getMainMinorScaleTonalities();

        for (Tonality tonality : tonalityList)
            assertEquals(tonality.getScale(), Scale.MINOR);
    }

    /* Main Major And Minor */

    @Test
    public void mainMajorMinorAreMajorOrMinor() {
        Set<Tonality> tonalityList = TonalityRetrieval.getMainMajorAndMinorScaleTonalities();

        for (Tonality tonality : tonalityList)
            assertTrue(ScaleUtils.isMajorOrMinor(tonality.getScale()));
    }

    @Test
    public void mainMajorMinorContainsAllTonalityEnum() {
        Set<Tonality> tonalitySet = TonalityRetrieval.getMainMajorAndMinorScaleTonalities();

        for (TonalityInnerImmutable tonalityEnum : TonalityInnerImmutable.values()) {
            Tonality tonality = Tonality.from(tonalityEnum.getRoot(), tonalityEnum.getScale());
            assertTrue(tonalitySet.contains(tonality));
        }
    }

    /* From Chord */

    @Test
    public void fromChordDiatonicFunction() {
        List<Tonality> ts = TonalityRetrieval.listFromChordDiatonicFunction(ChromaticChord.C);
        assertFalse(ts.isEmpty());
    }

    @Test(timeout = 1000)
    public void fromChordHarmonicFunction() {
        List<Tonality> ts = TonalityRetrieval.listFromChordAllFunctions(ChromaticChord.C);
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

    @Test
    public void getEnharmonicMinimalAltsFromChromatic() {
        Tonality target1 = Tonality.from(Chromatic.FF, Scale.CHROMATIC);
        Tonality target2 = Tonality.from(DiatonicAlt.Gb, Scale.CHROMATIC);
        Tonality tonality = Tonality.from(DiatonicAlt.EEE, Scale.CHROMATIC);
        Set<Tonality> result = TonalityRetrieval.getEnharmonicMinimalAltsFrom(tonality);
        assertEquals(2, result.size());
        assertTrue(result.contains(target1));
        assertTrue(result.contains(target2));
    }
}

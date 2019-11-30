package es.danisales.datune.tonality;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TonalityRetrievalTest {
    @Test
    public void fromChord() {
        List<Tonality> ts = TonalityRetrieval.listFromChord( ChromaticChord.C);
        Assert.assertFalse(ts.isEmpty());
    }

    @Test
    public void outScaleFromChord() {
        List<Tonality> ts = TonalityRetrieval.listFromChordOutScale(ChromaticChord.C);
        Assert.assertFalse(ts.isEmpty());
    }

    @Test
    public void majorSize() {
        Set<Tonality> tonalityList = TonalityRetrieval.mainMajor();

        assertEquals(13, tonalityList.size());
    }

    @Test
    public void minorSize() {
        Set<Tonality> tonalityList = TonalityRetrieval.mainMinor();
        for (Tonality tonality : tonalityList)
            System.out.println(tonality.getNotes());

        assertEquals(13, tonalityList.size());
    }

    @Test
    public void majorMinorAreMajorOrMinor() {
        List<Tonality> tonalityList = TonalityRetrieval.majorMinor();

        for (Tonality tonality : tonalityList)
            assertTrue( tonality.isMajorOrMinor() );
    }

    @Test
    public void isMajor() {
        Set<Tonality> tonalityList = TonalityRetrieval.mainMajor();

        for (Tonality tonality : tonalityList)
            assertTrue( tonality.isMajor() );
    }

    @Test
    public void isMinor() {
        Set<Tonality> tonalityList = TonalityRetrieval.mainMinor();

        for (Tonality tonality : tonalityList)
            assertTrue( tonality.isMinor() );
    }

    @Test
    public void containsAllTonalityEnum() {
        List<Tonality> tonalityList = TonalityRetrieval.majorMinor();

        for (TonalityInnerImmutable tonalityEnum : TonalityInnerImmutable.values()) {
            Tonality tonality = Tonality.from(tonalityEnum.getRoot(), tonalityEnum.getScale());
            assertTrue(tonalityList.contains(tonality));
        }
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

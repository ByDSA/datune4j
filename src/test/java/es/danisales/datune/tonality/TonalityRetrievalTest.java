package es.danisales.datune.tonality;

import es.danisales.datune.musical.ChromaticChordEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TonalityRetrievalTest {
    @Test
    public void fromChord() {
        List<Tonality> ts = TonalityRetrieval.listFromChord( ChromaticChordEnum.C);
        Assert.assertFalse(ts.isEmpty());
    }

    @Test
    public void outScaleFromChord() {
        List<Tonality> ts = TonalityRetrieval.listFromChordOutScale( ChromaticChordEnum.C);
        Assert.assertFalse(ts.isEmpty());
    }

    @Test
    public void majorMinorSize() {
        Set<Tonality> tonalityList = TonalityRetrieval.majorMinor();

        assertEquals(TonalityEnum.values().length, tonalityList.size());
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
        Set<Tonality> tonalityList = TonalityRetrieval.majorMinor();

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
        Set<Tonality> tonalityList = TonalityRetrieval.majorMinor();

        for (TonalityEnum tonalityEnum : TonalityEnum.values())
            assertTrue( tonalityList.contains(tonalityEnum) );
    }
}

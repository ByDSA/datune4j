package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.lang.Language;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaleUtilsTest {
    @Test
    public void getDistancesFromEng() {
        Language.current = Language.ENG;
        String str = ScaleUtils.getStringDistancesFrom(Scale.MAJOR);
        assertEquals("W-W-H-W-W-W-H", str);
    }

    @Test
    public void getDistancesFromEng2() {
        Language.current = Language.ENG;
        String str = ScaleUtils.getStringDistancesFrom(Scale.PENTATONIC);
        assertEquals("W-W-WH-W-WH", str);
    }

    @Test
    public void getDistancesFromEngAllNotNull() {
        Language.current = Language.ENG;
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getStringDistancesFrom(scale);
            assertNotNull(str);
        }
    }

    @Test
    public void getDistancesFromEsp() {
        Language.current = Language.ESP;
        String str = ScaleUtils.getStringDistancesFrom(Scale.MAJOR);
        assertEquals("T-T-ST-T-T-T-ST", str);
    }

    @Test
    public void getDistancesFromEsp2() {
        Language.current = Language.ESP;
        String str = ScaleUtils.getStringDistancesFrom(Scale.PENTATONIC);
        assertEquals("T-T-TS-T-TS", str);
    }


    @Test
    public void getDistancesFromEspAllNotNull() {
        Language.current = Language.ESP;
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getStringDistancesFrom(scale);
            assertNotNull(str);
        }
    }

    @Test
    public void getMajorScaleAlterationsFrom() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.MAJOR);
        assertEquals("1-2-3-4-5-6-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom2() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.MINOR);
        assertEquals("1-2-b3-4-5-b6-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom3() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.LYDIAN);
        assertEquals("1-2-3-#4-5-6-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromPentatonic() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC);
        assertEquals("1-2-3-5-6", str);
    }

    @Test
    public void getMajorScaleAlterationsFromPentatonicMinor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC_MINOR);
        assertEquals("1-b3-4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromEgyptian() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.EGYPCIAN);
        assertEquals("1-2-4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromBluesMinor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_MINOR);
        assertEquals("1-b3-4-b6-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromBluesMajor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_MAJOR);
        assertEquals("1-2-4-5-6", str);
    }

    @Test
    public void getMajorScaleAlterationsFromWholeNote() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.WHOLE_TONE);
        assertEquals("1-2-3-#4-#5-#6", str);
    }

    @Test
    public void getMajorScaleAlterationsFromChromatic() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.CHROMATIC);
        assertEquals("1-#1-2-#2-3-4-#4-5-#5-6-#6-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromBluesb5() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_b5);
        assertEquals("1-b3-4-b5-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromBluesa4() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_a4);
        assertEquals("1-b3-4-#4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromChromaticCustom() {
        Scale scale = Scale.CHROMATIC.clone();
        ScaleDegreeReparametrizer scaleDiatonicReparametrizer = ScaleDegreeReparametrizer.create();
        scaleDiatonicReparametrizer.put(0, DiatonicDegree.I);
        scaleDiatonicReparametrizer.put(1, DiatonicDegree.I);
        scaleDiatonicReparametrizer.put(2, DiatonicDegree.II);
        scaleDiatonicReparametrizer.put(3, DiatonicDegree.III);
        scaleDiatonicReparametrizer.put(4, DiatonicDegree.III);
        scaleDiatonicReparametrizer.put(5, DiatonicDegree.IV);
        scaleDiatonicReparametrizer.put(6, DiatonicDegree.IV);
        scaleDiatonicReparametrizer.put(7, DiatonicDegree.V);
        scaleDiatonicReparametrizer.put(8, DiatonicDegree.V);
        scaleDiatonicReparametrizer.put(9, DiatonicDegree.VI);
        scaleDiatonicReparametrizer.put(10, DiatonicDegree.VII);
        scaleDiatonicReparametrizer.put(11, DiatonicDegree.VII);
        scale.setScaleDegreeReparametrizer(scaleDiatonicReparametrizer);

        String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
        assertEquals("1-#1-2-b3-3-4-#4-5-#5-6-b7-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromAllNotNull() {
        Language.current = Language.ENG;
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
            assertNotNull(str);
        }
    }

    @Test
    public void getStringDistancesFrom() {
        fail();
    }

    @Test
    public void hasIntervalChromatic() {
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MAJOR_THIRD));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.PENTATONIC, IntervalChromatic.MAJOR_THIRD));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MINOR_THIRD));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.PENTATONIC, IntervalChromatic.MINOR_THIRD));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.MINOR_THIRD));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.PENTATONIC_MINOR, IntervalChromatic.MINOR_THIRD));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.PERFECT_FIFTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.PERFECT_FIFTH));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.LOCRIAN, IntervalChromatic.PERFECT_FIFTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.LOCRIAN, IntervalChromatic.PERFECT_OCTAVE));
    }

    @Test
    public void hasIntervalChromaticGreaterThan12() {
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MAJOR_TENTH));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MINOR_TENTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.MINOR_TENTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.PERFECT_TWELFTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.PERFECT_TWELFTH));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.LOCRIAN, IntervalChromatic.PERFECT_TWELFTH));
    }
}
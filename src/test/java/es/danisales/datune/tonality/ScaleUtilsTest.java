package es.danisales.datune.tonality;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.lang.Language;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaleUtilsTest {

    /* getStringDistancesFrom */

    @Test
    public void getStringDistancesFrom_Eng() {
        GlobalSettings.sigleton().setLanguage(Language.EN);
        String str = ScaleUtils.getStringDistancesFrom(Scale.MAJOR);
        assertEquals("W-W-H-W-W-W-H", str);
    }

    @Test
    public void getStringDistancesFrom_Eng2() {
        GlobalSettings.sigleton().setLanguage(Language.EN);
        String str = ScaleUtils.getStringDistancesFrom(Scale.PENTATONIC);
        assertEquals("W-W-WH-W-WH", str);
    }

    @Test
    public void getStringDistancesFrom_EngAllNotNull() {
        GlobalSettings.sigleton().setLanguage(Language.EN);
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getStringDistancesFrom(scale);
            assertNotNull(str);
        }
    }

    @Test
    public void getStringDistancesFrom_Esp() {
        GlobalSettings.sigleton().setLanguage(Language.ES);
        String str = ScaleUtils.getStringDistancesFrom(Scale.MAJOR);
        assertEquals("T-T-ST-T-T-T-ST", str);
    }

    @Test
    public void getStringDistancesFrom_Esp2() {
        GlobalSettings.sigleton().setLanguage(Language.ES);
        String str = ScaleUtils.getStringDistancesFrom(Scale.PENTATONIC);
        assertEquals("T-T-TS-T-TS", str);
    }

    @Test
    public void getStringDistancesFrom_EspAllNotNull() {
        GlobalSettings.sigleton().setLanguage(Language.ES);
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getStringDistancesFrom(scale);
            assertNotNull(str);
        }
    }

    /* getMajorScaleAlterationsFrom */

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
    public void getMajorScaleAlterationsFrom_Pentatonic() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC);
        assertEquals("1-2-3-5-6", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_PentatonicMinor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC_MINOR);
        assertEquals("1-b3-4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_Egyptian() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.EGYPCIAN);
        assertEquals("1-2-4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_BluesMinor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_MINOR);
        assertEquals("1-b3-4-b6-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_BluesMajor() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_MAJOR);
        assertEquals("1-2-4-5-6", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_WholeNote() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.WHOLE_TONE);
        assertEquals("1-2-3-#4-#5-#6", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_Chromatic() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.CHROMATIC);
        assertEquals("1-#1-2-#2-3-4-#4-5-#5-6-#6-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_Bluesb5() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_b5);
        assertEquals("1-b3-4-b5-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_Bluesa4() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.BLUES_a4);
        assertEquals("1-b3-4-#4-5-b7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_ChromaticCustom() {
        Scale scale = Scale.CHROMATIC.clone();
        ScaleDegreeReparameterize scaleDiatonicReparameterize = ScaleDegreeReparameterize.create();
        scaleDiatonicReparameterize.put(0, DiatonicDegree.I);
        scaleDiatonicReparameterize.put(1, DiatonicDegree.I);
        scaleDiatonicReparameterize.put(2, DiatonicDegree.II);
        scaleDiatonicReparameterize.put(3, DiatonicDegree.III);
        scaleDiatonicReparameterize.put(4, DiatonicDegree.III);
        scaleDiatonicReparameterize.put(5, DiatonicDegree.IV);
        scaleDiatonicReparameterize.put(6, DiatonicDegree.IV);
        scaleDiatonicReparameterize.put(7, DiatonicDegree.V);
        scaleDiatonicReparameterize.put(8, DiatonicDegree.V);
        scaleDiatonicReparameterize.put(9, DiatonicDegree.VI);
        scaleDiatonicReparameterize.put(10, DiatonicDegree.VII);
        scaleDiatonicReparameterize.put(11, DiatonicDegree.VII);
        scale.setScaleDegreeReparametrizer(scaleDiatonicReparameterize);

        String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
        assertEquals("1-#1-2-b3-3-4-#4-5-#5-6-b7-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom_AllNotNull() {
        GlobalSettings.sigleton().setLanguage(Language.EN);
        for (Scale scale : Scale.allUsualScales()) {
            String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
            assertNotNull(str);
        }
    }

    /* hasIntervalFromRoot */

    @Test
    public void hasIntervalFromRoot() {
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
    public void hasIntervalFromRoot_GreaterThan12() {
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MAJOR_TENTH));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.MINOR_TENTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.MINOR_TENTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MAJOR, IntervalChromatic.PERFECT_TWELFTH));
        assertTrue(ScaleUtils.hasIntervalFromRoot(Scale.MINOR, IntervalChromatic.PERFECT_TWELFTH));
        assertFalse(ScaleUtils.hasIntervalFromRoot(Scale.LOCRIAN, IntervalChromatic.PERFECT_TWELFTH));
    }
}
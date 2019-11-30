package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.lang.Language;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ScaleUtilsTest {
    @Test
    public void getDistancesFromEng() {
        Language.current = Language.ENG;
        String str = ScaleUtils.getDistancesFrom(Scale.MAJOR);
        assertEquals("W-W-H-W-W-W-H", str);
    }

    @Test
    public void getDistancesFromEng2() {
        Language.current = Language.ENG;
        String str = ScaleUtils.getDistancesFrom(Scale.PENTATONIC);
        assertEquals("W-W-WH-W-WH", str);
    }

    @Test
    public void getDistancesFromEngAllNotNull() {
        Language.current = Language.ENG;
        for (Scale scale : Scale.ALL) {
            String str = ScaleUtils.getDistancesFrom(scale);
            assertNotNull(str);
        }
    }

    @Test
    public void getDistancesFromEsp() {
        Language.current = Language.ESP;
        String str = ScaleUtils.getDistancesFrom(Scale.MAJOR);
        assertEquals("T-T-ST-T-T-T-ST", str);
    }

    @Test
    public void getDistancesFromEsp2() {
        Language.current = Language.ESP;
        String str = ScaleUtils.getDistancesFrom(Scale.PENTATONIC);
        assertEquals("T-T-TS-T-TS", str);
    }


    @Test
    public void getDistancesFromEspAllNotNull() {
        Language.current = Language.ESP;
        for (Scale scale : Scale.ALL) {
            String str = ScaleUtils.getDistancesFrom(scale);
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
        scale.setScaleDiatonicReparametrizer(scaleDiatonicReparametrizer);

        String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
        assertEquals("1-#1-2-b3-3-4-#4-5-#5-6-b7-7", str);
    }

    @Test
    public void getMajorScaleAlterationsFromAllNotNull() {
        Language.current = Language.ENG;
        for (Scale scale : Scale.ALL) {
            String str = ScaleUtils.getMajorScaleAlterationsFrom(scale);
            assertNotNull(str);
        }
    }
}
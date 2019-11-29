package es.danisales.datune.tonality;

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
    public void getMajorScaleAlterationsFrom4() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC);
        assertEquals("1-2-3-5-6", str);
    }

    @Test
    public void getMajorScaleAlterationsFrom5() {
        String str = ScaleUtils.getMajorScaleAlterationsFrom(Scale.PENTATONIC_MINOR);
        assertEquals("1-b3-4-5-b7", str);
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
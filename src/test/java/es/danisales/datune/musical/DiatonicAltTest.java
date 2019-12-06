package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.lang.Language;
import es.danisales.datune.tonality.ScaleDistance;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

public class DiatonicAltTest {
    @Test
    public void from_ChromaticAndDiatonic() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Chromatic.C, Diatonic.C);
        assertSame(DiatonicAlt.C, diatonicAlt);
    }

    @Test
    public void from_ChromaticAndDiatonic2() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Chromatic.C, Diatonic.B);
        assertSame(DiatonicAlt.BB, diatonicAlt);
    }

    @Test
    public void from_ChromaticAndDiatonic3() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Chromatic.C, Diatonic.D);
        assertSame(DiatonicAlt.Dbb, diatonicAlt);
    }

    @Test
    public void from_ChromaticAndDiatonic4() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Chromatic.DD, Diatonic.E);
        assertSame(DiatonicAlt.Eb, diatonicAlt);
    }

    @Test
    public void from_ChromaticAndDiatonic5() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Chromatic.AA, Diatonic.B);
        assertSame(DiatonicAlt.Bb, diatonicAlt);
    }

    @Test
    public void from_DiatonicAndAlt() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Diatonic.B, 1);
        assertEquals(1.0f, diatonicAlt.getAlterations());
        assertEquals(1.0f, diatonicAlt.getUnsignedAlterations());
        assertEquals(1, diatonicAlt.getSemitonesAdded());
        assertEquals(0.0f, diatonicAlt.getMicrotonalPartAdded());
        assertSame(DiatonicAlt.BB, diatonicAlt);
    }

    @Test
    public void from_DiatonicAndAlt2() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Diatonic.B, -1);
        assertEquals(-1.0f, diatonicAlt.getAlterations());
        assertEquals(1.0f, diatonicAlt.getUnsignedAlterations());
        assertEquals(-1, diatonicAlt.getSemitonesAdded());
        assertEquals(0.0f, diatonicAlt.getMicrotonalPartAdded());
        assertSame(DiatonicAlt.Bb, diatonicAlt);
    }

    @Test
    public void from_DiatonicAndAlt3() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Diatonic.B, 1.5f);
        assertNotEquals(DiatonicAlt.BB, diatonicAlt);
        assertNotEquals(DiatonicAlt.BBB, diatonicAlt);
        assertEquals(Diatonic.B, diatonicAlt.getDiatonic());
        assertEquals(1.5f, diatonicAlt.getAlterations());
        assertEquals(1.5f, diatonicAlt.getUnsignedAlterations());
        assertEquals(1, diatonicAlt.getSemitonesAdded());
        assertEquals(0.5f, diatonicAlt.getMicrotonalPartAdded());
    }

    @Test
    public void from_DiatonicAndAlt4() {
        DiatonicAlt diatonicAlt = DiatonicAlt.from(Diatonic.B, -1.5f);
        assertNotEquals(DiatonicAlt.Bb, diatonicAlt);
        assertNotEquals(DiatonicAlt.Bbb, diatonicAlt);
        assertEquals(Diatonic.B, diatonicAlt.getDiatonic());
        assertEquals(-1.5f, diatonicAlt.getAlterations());
        assertEquals(1.5f, diatonicAlt.getUnsignedAlterations());
        assertEquals(-1, diatonicAlt.getSemitonesAdded());
        assertEquals(-0.5f, diatonicAlt.getMicrotonalPartAdded());
    }

    @Test
    public void getDiatonic() {
        DiatonicAlt diatonicAlt = DiatonicAlt.Cb;
        assertSame(Diatonic.C, diatonicAlt.getDiatonic());
    }

    @Test
    public void add() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.add(ScaleDistance.QUARTER));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(0.5f, diatonicAlt.getAlterations());
    }

    @Test
    public void add2() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.add(ScaleDistance.HALF));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(1.0f, diatonicAlt.getAlterations());

    }

    @Test
    public void add3() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.add(ScaleDistance.WHOLE_HALF));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(3.0f, diatonicAlt.getAlterations());

    }

    @Test
    public void sub() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.sub(ScaleDistance.QUARTER));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(-0.5f, diatonicAlt.getAlterations());
    }
    @Test
    public void sub2() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.sub(ScaleDistance.QUARTER));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(-1.0f, diatonicAlt.getAlterations());
    }

    @Test
    public void addSemi() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.getAddSemi(1));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(1.0f, diatonicAlt.getAlterations());
    }

    @Test
    public void addSemi2() {
        DiatonicAlt diatonicAlt = DiatonicAlt.C;
        assertNotEquals(DiatonicAlt.C, diatonicAlt.getAddSemi(-1));
        assertEquals(Diatonic.C, diatonicAlt.getDiatonic());
        assertNotEquals(-1.0f, diatonicAlt.getAlterations());
    }

    @Test
    public void toStringTest_ENG() {
        Language.current = Language.ENG;
        assertEquals("C#(+1q)",
                DiatonicAlt.CC.add(ScaleDistance.QUARTER).toString()
        );
    }

    @Test
    public void toStringTest2_ENG() {
        Language.current = Language.ENG;
        assertEquals("Eb(-1q)",
                DiatonicAlt.Eb.sub(ScaleDistance.QUARTER).toString()
        );
    }

    @Test
    public void toStringTest_ESP() {
        Language.current = Language.ESP;
        assertEquals("Do#(+1q)",
                DiatonicAlt.CC.add(ScaleDistance.QUARTER).toString()
        );
    }

    @Test
    public void toStringTest2_ESP() {
        Language.current = Language.ESP;
        assertEquals("Mib(-1q)",
                DiatonicAlt.Eb.sub(ScaleDistance.QUARTER).toString()
        );
    }
}

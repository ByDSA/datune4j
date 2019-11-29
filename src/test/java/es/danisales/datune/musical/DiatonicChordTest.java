package es.danisales.datune.musical;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiatonicChordTest {
    @Test
    public void invNotSameRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        assertNotSame(DiatonicChordImmutable.C_TRIAD, diatonicChord.innerChord);
        assertEquals(DiatonicChord.C_TRIAD.getNotes(), diatonicChord.getNotes());
        assertNotEquals(DiatonicChord.C_TRIAD, diatonicChord);
    }

    @Test
    public void invSameRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.setRootIndex(0);
        assertEquals(DiatonicChord.C_TRIAD, diatonicChord);
        assertSame(DiatonicChordImmutable.C_TRIAD, diatonicChord.innerChord);
    }

    @Test
    public void fromCollection() {
        List<Diatonic> diatonicList = Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D);
        DiatonicChord diatonicChord = DiatonicChord.from(diatonicList);
        assertEquals(DiatonicChord.C_NINTH, diatonicChord);
        assertSame(DiatonicChord.C_NINTH.innerChord, diatonicChord.innerChord);
    }

    @Test
    public void toStringTest() {
        assertEquals("C_TRIAD", DiatonicChord.C_TRIAD.toString());
    }

    @Test
    public void toStringTest2() {
        DiatonicChord diatonicChord = DiatonicChord.from(Diatonic.C, DiatonicChordPattern.TRIAD);
        assertEquals("C_TRIAD", diatonicChord.toString());
    }

    @Test
    public void fromDiatonicFunction() {
        DiatonicChord diatonicChord = DiatonicChord.from(Diatonic.C, DiatonicChordPattern.TRIAD);
        assertNotNull(diatonicChord.innerChord);
        assertEquals(DiatonicChord.C_TRIAD, diatonicChord);
        assertSame(DiatonicChord.C_TRIAD.innerChord, diatonicChord.innerChord);
    }

    @Test
    public void fromDiatonicFunction2() {
        DiatonicChord diatonicChord = DiatonicChord.from(Diatonic.C, DiatonicChordPattern.NINTH);
        assertEquals(DiatonicChord.C_NINTH, diatonicChord);
        assertSame(DiatonicChord.C_NINTH.innerChord, diatonicChord.innerChord);
    }

    @Test
    public void fromDiatonicFunction3() {
        DiatonicChord diatonicChord = DiatonicChord.from(DiatonicFunction.V7, Diatonic.C);
        assertEquals(DiatonicChord.C_SEVENTH.getShifted(IntervalDiatonic.FIFTH), diatonicChord);
    }
}

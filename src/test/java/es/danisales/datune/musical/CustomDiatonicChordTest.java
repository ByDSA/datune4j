package es.danisales.datune.musical;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CustomDiatonicChordTest {
    @Test
    public void from() {
    }

    @Test
    public void shift() {
    }

    @Test
    public void getShifted() {
    }

    @Test
    public void testClone() {
    }

    @Test
    public void updateWhatIsIt() {
    }

    @Test
    public void updateWhatIsItIfNeeded() {
    }

    @Test
    public void add() {
    }

    @Test
    public void removeHigherDuplicates() {
    }

    @Test
    public void getDiatonicMidi() {
    }

    @Test
    public void getDegree() {
    }

    @Test
    public void getInv() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.inv();
        DiatonicChordInterface diatonicChordInv = DiatonicChordInterface.from( Arrays.asList(Diatonic.G, Diatonic.B, Diatonic.E) );
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.inv(2);
        DiatonicChordInterface diatonicChordInv = DiatonicChordInterface.from( Arrays.asList(Diatonic.B, Diatonic.E, Diatonic.G) );
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getInvToEnum() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        assertNotSame(DiatonicChordEnum.TRIAD, diatonicChord);
        assertNotEquals(DiatonicChordEnum.TRIAD, diatonicChord);
    }

    @Test
    public void getInvToEnumResetRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.setRootPos(0);
        assertSame(DiatonicChordEnum.TRIAD, diatonicChord);
    }

    @Test
    public void getAllInversions() {
    }

    @Test
    public void testEquals() {
    }
}

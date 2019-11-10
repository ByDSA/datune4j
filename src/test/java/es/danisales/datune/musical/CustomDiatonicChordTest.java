package es.danisales.datune.musical;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.B, Diatonic.E) );
        assertEquals(diatonicChordInv, diatonicChord.getInv());
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.B, Diatonic.E, Diatonic.G) );
        assertEquals(diatonicChordInv, diatonicChord.getInv());
    }

    @Test
    public void getInvToEnum() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        assertSame(DiatonicChordEnum.TRIAD, diatonicChord.getInv());
    }

    @Test
    public void getAllInversions() {
    }

    @Test
    public void testEquals() {
    }
}

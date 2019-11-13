package es.danisales.datune.musical;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.B, Diatonic.E) );
        diatonicChordInv.setRootPos(2);
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.inv(2);
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.B, Diatonic.E, Diatonic.G) );
        diatonicChordInv.setRootPos(1);
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
        assertSame(DiatonicChordEnum.TRIAD, diatonicChord.innerChord);
    }

    @Test
    public void getAllInversions() {
        CustomDiatonicChord diatonicChord = CustomDiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        List<CustomDiatonicChord> customDiatonicChords = diatonicChord.getAllInversions();

        CustomDiatonicChord inv1 = CustomDiatonicChord.from(diatonicChord);
        inv1.inv();

        CustomDiatonicChord inv2 = CustomDiatonicChord.from(diatonicChord);
        inv2.inv(2);

        assertEquals( diatonicChord, customDiatonicChords.get(0) );
        assertEquals( inv1, customDiatonicChords.get(1) );
        assertEquals( inv2, customDiatonicChords.get(2) );

        assertEquals( Arrays.asList(
                diatonicChord,
                inv1,
                inv2
        ), customDiatonicChords );
    }
}

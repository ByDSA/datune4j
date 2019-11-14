package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiatonicChordCustomTest {
    @Test
    public void fromList() {
        DiatonicChordCustom diatonicChord = DiatonicChordCustom.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );

        assertEquals(
                Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B),
                diatonicChord);
    }

    @Test
    public void shift() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD);
        diatonicChordCustom.setRootPos(1);
        diatonicChordCustom.shift( IntervalDiatonic.SECOND );
        assertEquals( 3, diatonicChordCustom.size() );
        assertEquals( Diatonic.D, diatonicChordCustom.get(0) );
        assertEquals( Diatonic.F, diatonicChordCustom.get(1) );
        assertEquals( Diatonic.A, diatonicChordCustom.get(2) );
        assertEquals( Diatonic.F, diatonicChordCustom.getRoot() );
    }

    @Test
    public void shiftOctave() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD);
        diatonicChordCustom.setRootPos(1);
        DiatonicChordCustom reference = DiatonicChordCustom.from(diatonicChordCustom);
        diatonicChordCustom.shift( IntervalDiatonic.OCTAVE );
        assertEquals( reference, diatonicChordCustom );
    }

    @Test
    public void shiftOctaveMultipleShift() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD);
        diatonicChordCustom.setRootPos(1);
        DiatonicChordCustom reference = DiatonicChordCustom.from(diatonicChordCustom);
        for (int i = 0; i < 7; i++)
            diatonicChordCustom.shift( IntervalDiatonic.SECOND );

        assertEquals( reference, diatonicChordCustom );
    }

    @Test
    public void duplicate() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));
        DiatonicChordCustom duplicated = diatonicChordCustom.duplicate();

        assertEquals(diatonicChordCustom, duplicated);
        assertNotSame(diatonicChordCustom, duplicated);
    }

    @Test
    public void add() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));
        DiatonicChordCustom target = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD);
        diatonicChordCustom.add(Diatonic.G);
        assertEquals(target, diatonicChordCustom);
    }

    @Test
    public void getDegree() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));

        for (int i = 0; i < 8; i++) {
            assertEquals(i%7, diatonicChordCustom.getDegree().val());
            diatonicChordCustom.shift(IntervalDiatonic.SECOND);
        }
    }

    @Test
    public void getInv() {
        DiatonicChordCustom diatonicChord = DiatonicChordCustom.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.inv();
        DiatonicChordCustom diatonicChordInv = DiatonicChordCustom.from( Arrays.asList(Diatonic.G, Diatonic.B, Diatonic.E) );
        diatonicChordInv.setRootPos(2);
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getInv2() {
        DiatonicChordCustom diatonicChord = DiatonicChordCustom.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.inv(2);
        DiatonicChordCustom diatonicChordInv = DiatonicChordCustom.from( Arrays.asList(Diatonic.B, Diatonic.E, Diatonic.G) );
        diatonicChordInv.setRootPos(1);
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getAllInversions() {
        DiatonicChordCustom diatonicChord = DiatonicChordCustom.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        List<DiatonicChordCustom> customDiatonicChords = diatonicChord.getAllInversions();

        DiatonicChordCustom inv1 = DiatonicChordCustom.from(diatonicChord);
        inv1.inv();

        DiatonicChordCustom inv2 = DiatonicChordCustom.from(diatonicChord);
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

package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test(expected = ClassCastException.class)
    public void of() { // todo: quitar de datils
        DiatonicChordCustom diatonicChordCustom = (DiatonicChordCustom)DiatonicChordCustom.of(new ArrayList<>());
    }


    @Test
    public void isEmpty() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Collections.emptyList());
        assertTrue( diatonicChordCustom.isEmpty() );
    }

    @Test
    public void isEmptyFalse() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));
        assertFalse( diatonicChordCustom.isEmpty() );
    }

    @Test
    public void add() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));
        diatonicChordCustom.add(Diatonic.G);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }

    @Test
    public void addIndex() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.G));
        diatonicChordCustom.add(1, Diatonic.E);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }

    @Test
    public void addIndexWhenEmpty() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Collections.emptyList());
        diatonicChordCustom.add(0, Diatonic.C);
        assertEquals(1, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }

    @Test
    public void addAll() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Collections.singletonList(Diatonic.C));
        diatonicChordCustom.addAll(Arrays.asList(Diatonic.E, Diatonic.G));
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }

    @Test
    public void addAllIndex() { // todo: falla porque addAll está mal, arreglar en datils
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Collections.singletonList(Diatonic.G));
        diatonicChordCustom.addAll(0, Arrays.asList(Diatonic.C, Diatonic.E));
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(2, diatonicChordCustom.getRootPos());
    }

    @Test
    public void set() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.D, Diatonic.G));
        diatonicChordCustom.set(1, Diatonic.E);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }


    @Test
    public void setAndItsRoot() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.D, Diatonic.E, Diatonic.G));
        diatonicChordCustom.set(0, Diatonic.C);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootPos());
    }

    @Test
    public void duplicate() {
        DiatonicChordCustom diatonicChordCustom = DiatonicChordCustom.from(Arrays.asList(Diatonic.C, Diatonic.E));
        DiatonicChordCustom duplicated = diatonicChordCustom.clone();

        assertEquals(diatonicChordCustom, duplicated);
        assertNotSame(diatonicChordCustom, duplicated);
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

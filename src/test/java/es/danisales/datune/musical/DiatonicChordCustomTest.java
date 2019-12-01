package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.interval.IntervalDiatonic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DiatonicChordCustomTest {
    @Test
    public void fromList() {
        DiatonicChordMutable diatonicChord = DiatonicChordMutable.from(Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B));

        assertEquals(
                Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B),
                diatonicChord);
    }

    @Test
    public void shift() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordCustom.setRootIndex(1);
        diatonicChordCustom.shift( IntervalDiatonic.SECOND );
        assertEquals( 3, diatonicChordCustom.size() );
        assertEquals( Diatonic.D, diatonicChordCustom.get(0) );
        assertEquals( Diatonic.F, diatonicChordCustom.get(1) );
        assertEquals( Diatonic.A, diatonicChordCustom.get(2) );
        assertEquals( Diatonic.F, diatonicChordCustom.getRoot() );
    }

    @Test
    public void shiftOctave() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordCustom.setRootIndex(1);
        DiatonicChordMutable reference = DiatonicChordMutable.from(diatonicChordCustom);
        diatonicChordCustom.shift( IntervalDiatonic.OCTAVE );
        assertEquals( reference, diatonicChordCustom );
    }

    @Test
    public void shiftOctaveMultipleShift() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordCustom.setRootIndex(1);
        DiatonicChordMutable reference = DiatonicChordMutable.from(diatonicChordCustom);
        for (int i = 0; i < 7; i++)
            diatonicChordCustom.shift( IntervalDiatonic.SECOND );

        assertEquals( reference, diatonicChordCustom );
    }

    @Test(expected = ClassCastException.class)
    public void of() { // todo: quitar de datils
        DiatonicChordMutable diatonicChordCustom = (DiatonicChordMutable) DiatonicChordMutable.of(new ArrayList<>());
    }


    @Test
    public void isEmpty() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Collections.emptyList());
        assertTrue( diatonicChordCustom.isEmpty() );
    }

    @Test
    public void isEmptyFalse() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        assertFalse( diatonicChordCustom.isEmpty() );
    }

    @Test
    public void add() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        diatonicChordCustom.add(Diatonic.G);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void addIndex() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.G));
        diatonicChordCustom.add(1, Diatonic.E);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void addIndexWhenEmpty() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Collections.emptyList());
        diatonicChordCustom.add(0, Diatonic.C);
        assertEquals(1, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void addAll() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Collections.singletonList(Diatonic.C));
        diatonicChordCustom.addAll(Arrays.asList(Diatonic.E, Diatonic.G));
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void addAllIndex() { // todo: falla porque addAll está mal, arreglar en datils
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Collections.singletonList(Diatonic.G));
        diatonicChordCustom.addAll(0, Arrays.asList(Diatonic.C, Diatonic.E));
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(2, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void set() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.D, Diatonic.G));
        diatonicChordCustom.set(1, Diatonic.E);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }


    @Test
    public void setAndItsRoot() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.D, Diatonic.E, Diatonic.G));
        diatonicChordCustom.set(0, Diatonic.C);
        assertEquals(3, diatonicChordCustom.size());
        assertEquals(Diatonic.C, diatonicChordCustom.get(0));
        assertEquals(Diatonic.E, diatonicChordCustom.get(1));
        assertEquals(Diatonic.G, diatonicChordCustom.get(2));
        assertEquals(0, diatonicChordCustom.getRootIndex());
    }

    @Test
    public void duplicate() {
        DiatonicChordMutable diatonicChordCustom = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        DiatonicChordMutable duplicated = diatonicChordCustom.clone();

        assertEquals(diatonicChordCustom, duplicated);
        assertNotSame(diatonicChordCustom, duplicated);
    }

    @Test
    public void getInv() {
        DiatonicChordMutable diatonicChord = DiatonicChordMutable.from(Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B));
        diatonicChord.inv();
        DiatonicChordMutable diatonicChordInv = DiatonicChordMutable.from(Arrays.asList(Diatonic.G, Diatonic.B, Diatonic.E));
        diatonicChordInv.setRootIndex(2);
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getInv2() {
        DiatonicChordMutable diatonicChord = DiatonicChordMutable.from(Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B));
        diatonicChord.inv(2);
        DiatonicChordMutable diatonicChordInv = DiatonicChordMutable.from(Arrays.asList(Diatonic.B, Diatonic.E, Diatonic.G));
        diatonicChordInv.setRootIndex(1);
        assertEquals(diatonicChordInv, diatonicChord);
    }

    @Test
    public void getAllInversions() {
        DiatonicChordMutable diatonicChord = DiatonicChordMutable.from(Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E));
        List<DiatonicChordMutable> customDiatonicChords = ChordTransformations.getAllInversionsFrom(diatonicChord);

        DiatonicChordMutable inv1 = DiatonicChordMutable.from(diatonicChord);
        inv1.inv();

        DiatonicChordMutable inv2 = DiatonicChordMutable.from(diatonicChord);
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

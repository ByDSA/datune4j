package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.interval.IntervalDiatonic;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DiatonicChordMutableTest {
    @Test
    public void fromList() {
        DiatonicChordMutable diatonicChord = DiatonicChordMutable.from(Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B));

        assertEquals(
                Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B),
                diatonicChord);
    }

    @Test
    public void shift() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordMutable.setRootIndex(1);
        diatonicChordMutable.shift(IntervalDiatonic.SECOND);
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.D, diatonicChordMutable.get(0));
        assertEquals(Diatonic.F, diatonicChordMutable.get(1));
        assertEquals(Diatonic.A, diatonicChordMutable.get(2));
        assertEquals(Diatonic.F, diatonicChordMutable.getRoot());
    }

    @Test
    public void shiftOctave() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordMutable.setRootIndex(1);
        DiatonicChordMutable reference = DiatonicChordMutable.from(diatonicChordMutable);
        diatonicChordMutable.shift(IntervalDiatonic.OCTAVE);
        assertEquals(reference, diatonicChordMutable);
    }

    @Test
    public void shiftOctaveMultipleShift() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(DiatonicChordImmutable.C_TRIAD);
        diatonicChordMutable.setRootIndex(1);
        DiatonicChordMutable reference = DiatonicChordMutable.from(diatonicChordMutable);
        for (int i = 0; i < 7; i++)
            diatonicChordMutable.shift(IntervalDiatonic.SECOND);

        assertEquals(reference, diatonicChordMutable);
    }

    @Test
    public void isEmpty() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Collections.emptyList());
        assertTrue(diatonicChordMutable.isEmpty());
    }

    @Test
    public void isEmptyFalse() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        assertFalse(diatonicChordMutable.isEmpty());
    }

    @Test
    public void add() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        diatonicChordMutable.add(Diatonic.G);
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void addIndex() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.G));
        diatonicChordMutable.add(1, Diatonic.E);
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void addIndexWhenEmpty() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Collections.emptyList());
        diatonicChordMutable.add(0, Diatonic.C);
        assertEquals(1, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void addAll() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Collections.singletonList(Diatonic.C));
        diatonicChordMutable.addAll(Arrays.asList(Diatonic.E, Diatonic.G));
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void addAllIndex() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Collections.singletonList(Diatonic.G));
        diatonicChordMutable.addAll(0, Arrays.asList(Diatonic.C, Diatonic.E));
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(2, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void set() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.D, Diatonic.G));
        diatonicChordMutable.set(1, Diatonic.E);
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }


    @Test
    public void setAndItsRoot() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.D, Diatonic.E, Diatonic.G));
        diatonicChordMutable.set(0, Diatonic.C);
        assertEquals(3, diatonicChordMutable.size());
        assertEquals(Diatonic.C, diatonicChordMutable.get(0));
        assertEquals(Diatonic.E, diatonicChordMutable.get(1));
        assertEquals(Diatonic.G, diatonicChordMutable.get(2));
        assertEquals(0, diatonicChordMutable.getRootIndex());
    }

    @Test
    public void duplicate() {
        DiatonicChordMutable diatonicChordMutable = DiatonicChordMutable.from(Arrays.asList(Diatonic.C, Diatonic.E));
        DiatonicChordMutable duplicated = diatonicChordMutable.clone();

        assertEquals(diatonicChordMutable, duplicated);
        assertNotSame(diatonicChordMutable, duplicated);
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

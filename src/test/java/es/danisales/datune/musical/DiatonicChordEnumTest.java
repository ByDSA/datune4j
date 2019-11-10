package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class DiatonicChordEnumTest {
    @Test
    public void getRootPos() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertEquals(0, diatonicChordEnum.getRootPos());
    }

    @Test
    public void getRoot() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertSame(diatonicChordEnum.get(diatonicChordEnum.getRootPos()), diatonicChordEnum.getRoot());
    }

    @Test
    public void getAllInversions() {
    }

    @Test
    public void from() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        assertSame(DiatonicChordEnum.TRIAD, diatonicChord);
    }

    @Test
    public void getOver() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        assertEquals(diatonicChord, DiatonicChordEnum.TRIAD.getOver(Diatonic.E));
    }

    @Test
    public void getOverNoChanges() {
        assertSame(DiatonicChordEnum.TRIAD, DiatonicChordEnum.TRIAD.getOver(Diatonic.C));
    }

    @Test
    public void getInv() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        assertEquals(diatonicChordInv, DiatonicChordEnum.TRIAD.getInv());
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        assertEquals(diatonicChordInv, DiatonicChordEnum.TRIAD.getInv(2));
    }

    @Test
    public void getInv3Same() {
        assertSame(DiatonicChordEnum.TRIAD, DiatonicChordEnum.TRIAD.getInv(3));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        DiatonicChordEnum.TRIAD.add(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        DiatonicChordEnum.TRIAD.addAll( Arrays.asList(Diatonic.C, Diatonic.D) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        DiatonicChordEnum.TRIAD.clear();
    }

    @Test
    public void containsTrue() {
        assertTrue( DiatonicChordEnum.TRIAD.contains(Diatonic.C) );
    }

    @Test
    public void containsFalse() {
        assertFalse( DiatonicChordEnum.TRIAD.contains(Diatonic.D) );
    }

    @Test
    public void containsAll() {
        assertTrue( DiatonicChordEnum.TRIAD.containsAll( Arrays.asList(Diatonic.C, Diatonic.E) ) );
    }

    @Test
    public void containsAllFalse() {
        assertFalse( DiatonicChordEnum.TRIAD.containsAll( Arrays.asList(Diatonic.C, Diatonic.D) ) );
    }

    @Test
    public void get() {
        assertEquals( Diatonic.C, DiatonicChordEnum.TRIAD.get(0) );
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getNegative() {
        assertEquals( Diatonic.C, DiatonicChordEnum.TRIAD.get(-1) );
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceed() {
        assertEquals( Diatonic.C, DiatonicChordEnum.TRIAD.get(3) );
    }

    @Test
    public void indexOf() {
        assertEquals(1, DiatonicChordEnum.TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void indexOfFalse() {
        assertEquals(-1, DiatonicChordEnum.TRIAD.indexOf(Diatonic.D));
    }

    @Test
    public void isEmpty() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertFalse(diatonicChordEnum.isEmpty());
    }

    @Test
    public void iteratorNotNull() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertNotNull(diatonicChordEnum.iterator());
    }

    @Test
    public void lastIndexOf() {
        assertEquals(1, DiatonicChordEnum.TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void lastIndexOfFalse() {
        assertEquals(-1, DiatonicChordEnum.TRIAD.indexOf(Diatonic.D));
    }

    @Test
    public void listIterator() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertNotNull(diatonicChordEnum.listIterator());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        DiatonicChordEnum.TRIAD.remove(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        DiatonicChordEnum.TRIAD.removeAll( Arrays.asList(Diatonic.C, Diatonic.E) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        DiatonicChordEnum.TRIAD.retainAll( Arrays.asList(Diatonic.C, Diatonic.E) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        DiatonicChordEnum.TRIAD.set(0, Diatonic.C);
    }

    @Test
    public void size() {
        assertEquals( 3, DiatonicChordEnum.TRIAD.size() );
        assertEquals( 4, DiatonicChordEnum.SEVENTH.size() );
        assertEquals( 5, DiatonicChordEnum.NINTH.size() );
    }

    @Test
    public void subList() {
        assertEquals( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B), DiatonicChordEnum.NINTH.subList(1, 4) );
    }

    @Test
    public void toArray() {
        assertArrayEquals( new Diatonic[]{Diatonic.C, Diatonic.E, Diatonic.G}, DiatonicChordEnum.TRIAD.toArray() );
    }

    @Test
    public void getDegree() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertEquals(diatonicChordEnum.toString(), DiatonicDegree.I, diatonicChordEnum.getDegree());
    }
}

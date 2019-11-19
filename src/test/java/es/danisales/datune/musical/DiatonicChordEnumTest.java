package es.danisales.datune.musical;

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
    public void from() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        assertSame(DiatonicChord.TRIAD.innerChord, diatonicChord.innerChord);
    }

    @Test
    public void getOver() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.TRIAD);
        dc.over(Diatonic.E);

        assertNotEquals(diatonicChord, dc); // Root es diferente
    }

    @Test
    public void getOverResetRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.TRIAD);
        dc.over(Diatonic.E);
        dc.resetRoot();

        assertEquals(diatonicChord, dc); // Root es el mismo
    }

    @Test
    public void getOverNoChanges() {
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.TRIAD);
        dc.over(Diatonic.C);

        assertEquals(DiatonicChord.TRIAD, dc);
        assertSame(DiatonicChord.TRIAD.innerChord, dc.innerChord);
    }

    @Test
    public void getInv() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        diatonicChordInv.setRootPos(2);
        DiatonicChord dc = DiatonicChord.TRIAD.duplicate();
        dc.inv();

        assertEquals(diatonicChordInv, dc);
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChordInv.setRootPos(1);
        DiatonicChord dc = DiatonicChord.TRIAD.duplicate();
        dc.inv(2);
        assertEquals(diatonicChordInv, dc);
    }

    @Test
    public void getInv3Same() {
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.TRIAD);
        dc.inv(3);

        assertEquals(DiatonicChord.TRIAD, dc);
        assertEquals(DiatonicChord.TRIAD.innerChord, dc.innerChord);
        assertSame(DiatonicChord.TRIAD.innerChord, dc.innerChord);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        DiatonicChord.TRIAD.add(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        DiatonicChord.TRIAD.addAll( Arrays.asList(Diatonic.C, Diatonic.D) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        DiatonicChord.TRIAD.clear();
    }

    @Test
    public void containsTrue() {
        assertTrue( DiatonicChord.TRIAD.contains(Diatonic.C) );
    }

    @Test
    public void containsFalse() {
        assertFalse( DiatonicChord.TRIAD.contains(Diatonic.D) );
    }

    @Test
    public void containsAll() {
        assertTrue( DiatonicChord.TRIAD.containsAll( Arrays.asList(Diatonic.C, Diatonic.E) ) );
    }

    @Test
    public void containsAllFalse() {
        assertFalse( DiatonicChord.TRIAD.containsAll( Arrays.asList(Diatonic.C, Diatonic.D) ) );
    }

    @Test
    public void get() {
        assertEquals( Diatonic.C, DiatonicChord.TRIAD.get(0) );
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getNegative() {
        assertEquals( Diatonic.C, DiatonicChord.TRIAD.get(-1) );
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceed() {
        assertEquals( Diatonic.C, DiatonicChord.TRIAD.get(3) );
    }

    @Test
    public void indexOf() {
        assertEquals(1, DiatonicChord.TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void indexOfFalse() {
        assertEquals(-1, DiatonicChord.TRIAD.indexOf(Diatonic.D));
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
        assertEquals(1, DiatonicChord.TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void lastIndexOfFalse() {
        assertEquals(-1, DiatonicChord.TRIAD.indexOf(Diatonic.D));
    }

    @Test
    public void listIterator() {
        for (DiatonicChordEnum diatonicChordEnum : DiatonicChordEnum.values())
            assertNotNull(diatonicChordEnum.listIterator());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        DiatonicChord.TRIAD.remove(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        DiatonicChord.TRIAD.removeAll( Arrays.asList(Diatonic.C, Diatonic.E) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        DiatonicChord.TRIAD.retainAll( Arrays.asList(Diatonic.C, Diatonic.E) );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        DiatonicChord.TRIAD.set(0, Diatonic.C);
    }

    @Test
    public void size() {
        assertEquals( 3, DiatonicChord.TRIAD.size() );
        assertEquals( 4, DiatonicChordEnum.SEVENTH.size() );
        assertEquals( 5, DiatonicChordEnum.NINTH.size() );
    }

    @Test
    public void subList() {
        assertEquals( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B), DiatonicChordEnum.NINTH.subList(1, 4) );
    }

    @Test
    public void toArray() {
        assertArrayEquals( new Diatonic[]{Diatonic.C, Diatonic.E, Diatonic.G}, DiatonicChord.TRIAD.toArray() );
    }

    @Test
    public void equalsCustomBidirectional() {
        DiatonicChord original = DiatonicChord.TRIAD;
        DiatonicChord other = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );

        assertEquals(other, original);
        assertEquals(original, other);
    }

    @Test
    public void duplicate() {
        DiatonicChord original = DiatonicChord.TRIAD;
        DiatonicChord duplicated = original.duplicate();

        assertEquals(original, duplicated);
        assertNotSame(original, duplicated);
        assertSame(original.innerChord, duplicated.innerChord);
    }

    @Test
    public void duplicateWithChange() {
        DiatonicChord original = DiatonicChord.TRIAD;
        DiatonicChord duplicated = original.duplicate();
        duplicated.inv();

        assertNotEquals(original, duplicated);
        assertNotSame(original, duplicated);
        assertNotSame(original.innerChord, duplicated.innerChord);
    }
}

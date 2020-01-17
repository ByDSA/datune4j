package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Diatonic;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class DiatonicChordImmutableTest {
    @Test
    public void getRootPos() {
        for (DiatonicChordImmutable diatonicChordImmutable : DiatonicChordImmutable.values())
            assertEquals(0, diatonicChordImmutable.getRootIndex());
    }

    @Test
    public void getRoot() {
        for (DiatonicChordImmutable diatonicChordImmutable : DiatonicChordImmutable.values())
            assertSame(diatonicChordImmutable.get(diatonicChordImmutable.getRootIndex()), diatonicChordImmutable.getRoot());
    }

    @Test
    public void from() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        assertSame(DiatonicChord.C_TRIAD.innerChord, diatonicChord.innerChord);
    }

    @Test
    public void getOver() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.C_TRIAD);
        dc.over(Diatonic.E);

        assertNotEquals(diatonicChord, dc); // Root es diferente
    }

    @Test
    public void getOverResetRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.C_TRIAD);
        dc.over(Diatonic.E);
        dc.resetRoot();

        assertEquals(diatonicChord, dc); // Root es el mismo
    }

    @Test
    public void getOverNoChanges() {
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.C_TRIAD);
        dc.over(Diatonic.C);

        assertEquals(DiatonicChord.C_TRIAD, dc);
        assertSame(DiatonicChord.C_TRIAD.innerChord, dc.innerChord);
    }

    @Test
    public void getInv() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        diatonicChordInv.setRootIndex(2);
        DiatonicChord dc = DiatonicChord.C_TRIAD.clone();
        dc.inv();

        assertEquals(diatonicChordInv, dc);
    }

    @Test
    public void getInv2() {
        DiatonicChord diatonicChordInv = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChordInv.setRootIndex(1);
        DiatonicChord dc = DiatonicChord.C_TRIAD.clone();
        dc.inv(2);
        assertEquals(diatonicChordInv, dc);
    }

    @Test
    public void getInv3Same() {
        DiatonicChord dc = DiatonicChord.from(DiatonicChord.C_TRIAD);
        dc.inv(3);

        assertEquals(DiatonicChord.C_TRIAD, dc);
        assertEquals(DiatonicChord.C_TRIAD.innerChord, dc.innerChord);
        assertSame(DiatonicChord.C_TRIAD.innerChord, dc.innerChord);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        DiatonicChord.C_TRIAD.add(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        DiatonicChord.C_TRIAD.addAll(Arrays.asList(Diatonic.C, Diatonic.D));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        DiatonicChord.C_TRIAD.clear();
    }

    @Test
    public void containsTrue() {
        assertTrue(DiatonicChord.C_TRIAD.contains(Diatonic.C));
    }

    @Test
    public void containsFalse() {
        assertFalse(DiatonicChord.C_TRIAD.contains(Diatonic.D));
    }

    @Test
    public void containsAll() {
        assertTrue(DiatonicChord.C_TRIAD.containsAll(Arrays.asList(Diatonic.C, Diatonic.E)));
    }

    @Test
    public void containsAllFalse() {
        assertFalse(DiatonicChord.C_TRIAD.containsAll(Arrays.asList(Diatonic.C, Diatonic.D)));
    }

    @Test
    public void get() {
        assertEquals(Diatonic.C, DiatonicChord.C_TRIAD.get(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getNegative() {
        assertEquals(Diatonic.C, DiatonicChord.C_TRIAD.get(-1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceed() {
        assertEquals(Diatonic.C, DiatonicChord.C_TRIAD.get(3));
    }

    @Test
    public void indexOf() {
        assertEquals(1, DiatonicChord.C_TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void indexOfFalse() {
        assertEquals(-1, DiatonicChord.C_TRIAD.indexOf(Diatonic.D));
    }

    @Test
    public void isEmpty() {
        for (DiatonicChordImmutable diatonicChordImmutable : DiatonicChordImmutable.values())
            assertFalse(diatonicChordImmutable.isEmpty());
    }

    @Test
    public void iteratorNotNull() {
        for (DiatonicChordImmutable diatonicChordImmutable : DiatonicChordImmutable.values())
            assertNotNull(diatonicChordImmutable.iterator());
    }

    @Test
    public void lastIndexOf() {
        assertEquals(1, DiatonicChord.C_TRIAD.indexOf(Diatonic.E));
    }

    @Test
    public void lastIndexOfFalse() {
        assertEquals(-1, DiatonicChord.C_TRIAD.indexOf(Diatonic.D));
    }

    @Test
    public void listIterator() {
        for (DiatonicChordImmutable diatonicChordImmutable : DiatonicChordImmutable.values())
            assertNotNull(diatonicChordImmutable.listIterator());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        DiatonicChord.C_TRIAD.remove(Diatonic.C);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        DiatonicChord.C_TRIAD.removeAll(Arrays.asList(Diatonic.C, Diatonic.E));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        DiatonicChord.C_TRIAD.retainAll(Arrays.asList(Diatonic.C, Diatonic.E));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        DiatonicChord.C_TRIAD.set(0, Diatonic.C);
    }

    @Test
    public void size() {
        assertEquals(3, DiatonicChord.C_TRIAD.size());
        assertEquals(4, DiatonicChordImmutable.C_SEVENTH.size());
        assertEquals(5, DiatonicChordImmutable.C_NINTH.size());
    }

    @Test
    public void subList() {
        assertEquals(Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.B), DiatonicChordImmutable.C_NINTH.subList(1, 4));
    }

    @Test
    public void toArray() {
        assertArrayEquals(new Diatonic[]{Diatonic.C, Diatonic.E, Diatonic.G}, DiatonicChord.C_TRIAD.toArray());
    }

    @Test
    public void equalsCustomBidirectional() {
        DiatonicChord original = DiatonicChord.C_TRIAD;
        DiatonicChord other = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );

        assertEquals(other, original);
        assertEquals(original, other);
    }

    @Test
    public void duplicate() {
        DiatonicChord original = DiatonicChord.C_TRIAD;
        DiatonicChord duplicated = original.clone();

        assertEquals(original, duplicated);
        assertNotSame(original, duplicated);
        assertSame(original.innerChord, duplicated.innerChord);
    }

    @Test
    public void duplicateWithChange() {
        DiatonicChord original = DiatonicChord.C_TRIAD;
        DiatonicChord duplicated = original.clone();
        duplicated.inv();

        assertNotEquals(original, duplicated);
        assertNotSame(original, duplicated);
        assertNotSame(original.innerChord, duplicated.innerChord);
    }
}

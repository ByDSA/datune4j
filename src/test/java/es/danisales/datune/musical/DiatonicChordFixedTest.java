package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class DiatonicChordFixedTest {
    @Test(expected = UnsupportedOperationException.class)
    public void inv() {
        DiatonicChord.TRIAD.inv();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void inv2() {
        DiatonicChord.TRIAD.inv(2);
    }

    @Test
    public void getAllInversions() {
        List<DiatonicChord> diatonicChordList = DiatonicChord.TRIAD.getAllInversions();

        assertEquals(3, diatonicChordList.size());

        DiatonicChord inv1 = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.G, Diatonic.C) );
        inv1.setRootPos(2);

        DiatonicChord inv2 = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        inv2.setRootPos(1);

        assertEquals(
                Arrays.asList(
                        DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) ),
                        inv1,
                        inv2
                ),
                diatonicChordList
        );
    }

    @Test
    public void getRootPos() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertEquals(0, diatonicChord.getRootPos());
    }

    @Test
    public void getRoot() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertEquals(Diatonic.C, diatonicChord.getRoot());
    }

    @Test
    public void duplicate() {
        DiatonicChord diatonicChord = DiatonicChord.TRIAD.duplicate();
        diatonicChord.set(1, Diatonic.D);
        assertEquals(DiatonicChord.SUS2, diatonicChord);
        assertSame(DiatonicChord.SUS2.innerObject, diatonicChord.innerObject);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setRootPos() {
        DiatonicChord.TRIAD.setRootPos(1);
    }

    @Test
    public void getDegree() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertEquals(diatonicChord.toString(), DiatonicDegree.I, diatonicChord.getDegree());
    }

    @Test
    public void size() {
        assertEquals(3, DiatonicChord.TRIAD.size());
    }

    @Test
    public void isEmpty() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertFalse(diatonicChord.isEmpty());
    }

    @Test
    public void contains() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertTrue(diatonicChord.contains(Diatonic.C));
    }

    @Test
    public void iteratorNext() {
        Iterator<Diatonic> iterator = DiatonicChord.TRIAD.iterator();

        assertEquals(Diatonic.C, iterator.next());
    }

    @Test
    public void iteratorHasNextTrue() {
        Iterator<Diatonic> iterator = DiatonicChord.TRIAD.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorHasNextFalse() {
        Iterator<Diatonic> iterator = DiatonicChord.TRIAD.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove() {
        Iterator<Diatonic> iterator = DiatonicChord.TRIAD.iterator();

        iterator.next();
        iterator.remove();
    }

    @Test
    public void toArray() {
        Object[] array = DiatonicChord.TRIAD.toArray();
        assertArrayEquals(new Diatonic[]{
                Diatonic.C,
                Diatonic.E,
                Diatonic.G
        }, array);
    }

    @Test
    public void toArray1() {
        Diatonic[] array = new Diatonic[3];
        array = DiatonicChord.TRIAD.toArray(array);
        assertArrayEquals(new Diatonic[]{
                Diatonic.C,
                Diatonic.E,
                Diatonic.G
        }, array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        DiatonicChord.TRIAD.add(Diatonic.B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addPos() {
        DiatonicChord.TRIAD.add(1, Diatonic.B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removePosition() {
        DiatonicChord.TRIAD.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeValue() {
        DiatonicChord.TRIAD.remove(Diatonic.C);
    }

    @Test
    public void containsAll() {
        assertTrue(DiatonicChord.TRIAD.containsAll(Arrays.asList(Diatonic.C, Diatonic.G)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        DiatonicChord.TRIAD.addAll(Arrays.asList(Diatonic.D, Diatonic.B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllPos() {
        DiatonicChord.TRIAD.addAll(1, Arrays.asList(Diatonic.D, Diatonic.B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        DiatonicChord.TRIAD.removeAll(Arrays.asList(Diatonic.C, Diatonic.G));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        DiatonicChord.TRIAD.retainAll(Arrays.asList(Diatonic.C, Diatonic.G));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        DiatonicChord.TRIAD.clear();
    }

    @Test
    public void get() {
        assertEquals(Diatonic.C, DiatonicChord.TRIAD.get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        DiatonicChord.TRIAD.set(1, Diatonic.D);
    }

    @Test
    public void indexOf() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertEquals(0, diatonicChord.indexOf(Diatonic.C));
    }

    @Test
    public void lastIndexOf() {
        for (DiatonicChord diatonicChord : DiatonicChord.values())
            assertEquals(0, diatonicChord.lastIndexOf(Diatonic.C));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorRemove() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator();
        listIterator.next();

        listIterator.remove();
    }

    @Test
    public void listIteratorHasNextTrue() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator();
        listIterator.next();
        listIterator.next();
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void listIteratorHasNextFalse() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorSet() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.set(Diatonic.D);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorAdd() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.add(Diatonic.B);
    }

    @Test
    public void listIterator1() {
        ListIterator<Diatonic> listIterator = DiatonicChord.TRIAD.listIterator(3);
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void subList() {
        assertEquals(
                Arrays.asList(
                        Diatonic.G,
                        Diatonic.B
                ),
                DiatonicChord.SEVENTH.subList(2, 4));
    }

    @Test
    public void toStringTest() {
        assertEquals("TRIAD", DiatonicChord.TRIAD.toString());
    }

    @Test
    public void toStringTestManually() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.resetRoot();
        assertEquals("TRIAD", diatonicChord.toString());
    }

    @Test
    public void equals() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.resetRoot();
        assertEquals(DiatonicChord.TRIAD, diatonicChord);
    }

    @Test
    public void hashCodeTest() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.resetRoot();
        assertEquals(DiatonicChord.TRIAD.hashCode(), diatonicChord.hashCode());
    }

    @Test
    public void hashCodeTestDifferentRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        assertNotEquals(DiatonicChord.TRIAD.hashCode(), diatonicChord.hashCode());
    }

    @Test
    public void hashCodeTestDifferentOrder() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.E, Diatonic.C, Diatonic.G) );
        assertNotEquals(DiatonicChord.TRIAD.hashCode(), diatonicChord.hashCode());
    }

    @Test
    public void sameAfterResetRoot() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.inv();
        diatonicChord.resetRoot();
        assertNotSame(DiatonicChord.TRIAD, diatonicChord);
        assertSame(DiatonicChord.TRIAD.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterInv() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.G, Diatonic.C, Diatonic.E) );
        diatonicChord.setRootPos(1);
        diatonicChord.inv();
        assertSame(DiatonicChord.TRIAD.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterSet() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        diatonicChord.set(1, Diatonic.D);
        assertSame(DiatonicChord.SUS2.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterAdd() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        diatonicChord.add(Diatonic.B);
        assertSame(DiatonicChord.SEVENTH.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterRemove() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.remove(Diatonic.G);
        assertSame(DiatonicChord.SEVENTH_O5.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterRemove2() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B) );
        diatonicChord.remove(2);
        assertSame(DiatonicChord.SEVENTH_O5.innerObject, diatonicChord.innerObject);
    }

    @Test
    public void sameAfterAddPos() {
        DiatonicChord diatonicChord = DiatonicChord.from( Arrays.asList(Diatonic.C, Diatonic.E, Diatonic.G) );
        diatonicChord.add(3,Diatonic.B);
        assertSame(DiatonicChord.SEVENTH.innerObject, diatonicChord.innerObject);
    }
}
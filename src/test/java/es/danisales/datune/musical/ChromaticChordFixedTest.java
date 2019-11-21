package es.danisales.datune.musical;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ChromaticChordFixedTest {
    @Test(expected = UnsupportedOperationException.class)
    public void inv() {
        ChromaticChord.C.inv();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void inv2() {
        ChromaticChord.C.inv(2);
    }

    @Test
    public void same() {
        assertSame(ChromaticChordEnum.C5, ChromaticChord.C5.innerChord);
    }

    @Test
    public void getAllInversions() {
        List<ChromaticChord> chromaticChordList = ChromaticChord.C.getAllInversions();

        assertEquals(3, chromaticChordList.size());

        ChromaticChord inv1 = ChromaticChord.from( Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C) );
        inv1.setRootPos(2);

        ChromaticChord inv2 = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        inv2.setRootPos(1);

        assertEquals(
                Arrays.asList(
                        ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G) ),
                        inv1,
                        inv2
                ),
                chromaticChordList
        );
    }

    @Test
    public void getRootPos() {
        for (ChromaticChord chromaticChord : ChromaticChord.values())
            assertEquals(0, chromaticChord.getRootPos());
    }

    @Test
    public void sizeLikeEnum() {
        assertEquals(ChromaticChordEnum.values().length, ChromaticChord.values().size());
    }

    @Test
    public void getRoot() {
        assertEquals( Chromatic.G, ChromaticChord.G7.getRoot() );
        assertEquals( Chromatic.AA, ChromaticChord.AAMaj13a5a9.getRoot() );
    }

    @Test
    public void duplicate() {
        ChromaticChord chromaticChord = ChromaticChord.C.duplicate();
        chromaticChord.set(1, Chromatic.D);
        assertEquals(ChromaticChord.Csus2, chromaticChord);
        assertSame(ChromaticChord.Csus2.innerChord, chromaticChord.innerChord);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setRootPos() {
        ChromaticChord.C.setRootPos(1);
    }

    @Test
    public void size() {
        assertEquals(3, ChromaticChord.C.size());
    }

    @Test
    public void isEmpty() {
        for (ChromaticChord chromaticChord : ChromaticChord.values())
            assertFalse(chromaticChord.isEmpty());
    }

    @Test
    public void contains() {
        assertTrue( ChromaticChord.C.contains(Chromatic.G) );
        assertTrue( ChromaticChord.C13a5b9.contains(Chromatic.GG) );
    }

    @Test
    public void iteratorNext() {
        Iterator<Chromatic> iterator = ChromaticChord.C.iterator();

        assertEquals(Chromatic.C, iterator.next());
    }

    @Test
    public void iteratorHasNextTrue() {
        Iterator<Chromatic> iterator = ChromaticChord.C.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorHasNextFalse() {
        Iterator<Chromatic> iterator = ChromaticChord.C.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove() {
        Iterator<Chromatic> iterator = ChromaticChord.C.iterator();

        iterator.next();
        iterator.remove();
    }

    @Test
    public void toArray() {
        Object[] array = ChromaticChord.C.toArray();
        assertArrayEquals(new Chromatic[]{
                Chromatic.C,
                Chromatic.E,
                Chromatic.G
        }, array);
    }

    @Test
    public void toArray1() {
        Chromatic[] array = new Chromatic[3];
        array = ChromaticChord.C.toArray(array);
        assertArrayEquals(new Chromatic[]{
                Chromatic.C,
                Chromatic.E,
                Chromatic.G
        }, array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        ChromaticChord.C.add(Chromatic.B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addPos() {
        ChromaticChord.C.add(1, Chromatic.B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removePosition() {
        ChromaticChord.C.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeValue() {
        ChromaticChord.C.remove(Chromatic.C);
    }

    @Test
    public void containsAll() {
        assertTrue(ChromaticChord.C.containsAll(Arrays.asList(Chromatic.C, Chromatic.G)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        ChromaticChord.C.addAll(Arrays.asList(Chromatic.D, Chromatic.B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllPos() {
        ChromaticChord.C.addAll(1, Arrays.asList(Chromatic.D, Chromatic.B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        ChromaticChord.C.removeAll(Arrays.asList(Chromatic.C, Chromatic.G));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        ChromaticChord.C.retainAll(Arrays.asList(Chromatic.C, Chromatic.G));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        ChromaticChord.C.clear();
    }

    @Test
    public void get() {
        assertEquals(Chromatic.C, ChromaticChord.C.get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        ChromaticChord.C.set(1, Chromatic.D);
    }

    @Test
    public void indexOf() {
        assertEquals(0, ChromaticChord.C.indexOf(Chromatic.C));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(0, ChromaticChord.C.lastIndexOf(Chromatic.C));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorRemove() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator();
        listIterator.next();

        listIterator.remove();
    }

    @Test
    public void listIteratorHasNextTrue() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator();
        listIterator.next();
        listIterator.next();
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void listIteratorHasNextFalse() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorSet() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.set(Chromatic.D);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorAdd() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.add(Chromatic.B);
    }

    @Test
    public void listIterator1() {
        ListIterator<Chromatic> listIterator = ChromaticChord.C.listIterator(3);
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void subList() {
        assertEquals(
                Arrays.asList(
                        Chromatic.G,
                        Chromatic.AA
                ),
                ChromaticChord.C7.subList(2, 4));
    }

    @Test
    public void toStringTest() {
        assertEquals("C", ChromaticChord.C.toString());
    }

    @Test
    public void toStringTestManually() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.inv();
        chromaticChord.resetRoot();
        assertEquals("C", chromaticChord.toString());
    }

    @Test
    public void equals() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.inv();
        chromaticChord.resetRoot();
        assertEquals(ChromaticChord.C, chromaticChord);
        assertEquals(chromaticChord, ChromaticChord.C);
    }

    @Test
    public void hashCodeTest() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.inv();
        chromaticChord.resetRoot();
        assertEquals(ChromaticChord.C.hashCode(), chromaticChord.hashCode());
    }

    @Test
    public void hashCodeTestDifferentRoot() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.inv();
        assertNotEquals(ChromaticChord.C.hashCode(), chromaticChord.hashCode());
    }

    @Test
    public void hashCodeTestDifferentOrder() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.E, Chromatic.C, Chromatic.G) );
        assertNotEquals(ChromaticChord.C.hashCode(), chromaticChord.hashCode());
    }

    @Test
    public void sameAfterResetRoot() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.inv();
        chromaticChord.resetRoot();
        assertNotSame(ChromaticChord.C, chromaticChord);
        assertSame(ChromaticChord.C.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterInv() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.E) );
        chromaticChord.setRootPos(1);
        chromaticChord.inv();
        assertSame(ChromaticChord.C.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterSet() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G) );
        chromaticChord.set(1, Chromatic.D);
        assertSame(ChromaticChord.Csus2.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterAdd() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G) );
        chromaticChord.add(Chromatic.AA);
        assertSame(ChromaticChord.C7.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterRemove() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA) );
        chromaticChord.remove(Chromatic.AA);
        assertSame(ChromaticChord.C.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterRemove2() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.GG) );
        chromaticChord.remove(2);
        assertSame(ChromaticChord.Caug.innerChord, chromaticChord.innerChord);
    }

    @Test
    public void sameAfterAddPos() {
        ChromaticChord chromaticChord = ChromaticChord.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.AA) );
        chromaticChord.add(2, Chromatic.G);
        assertSame(ChromaticChord.C7.innerChord, chromaticChord.innerChord);
    }
}
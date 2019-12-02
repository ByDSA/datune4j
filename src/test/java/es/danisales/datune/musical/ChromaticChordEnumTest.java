package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordEnumTest {
	@Test
	public void fromList() {
		ChromaticChordImmutable c = ChromaticChordImmutable.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G));
		assertSame(ChromaticChordImmutable.C, c);
	}

	@Test
	public void fromListNonNullValues() {
		for (ChromaticChordImmutable cc : ChromaticChordImmutable.values())
			assertNotNull(ChromaticChordImmutable.from(cc));
	}

	@Test
	public void testSomeValues() {
		assertEquals(Arrays.asList(Chromatic.C, Chromatic.G), ChromaticChordImmutable.C5);
	}

	@Test
	public void fromListNotFound() {
		ChromaticChordImmutable chromaticChordEnum = ChromaticChordImmutable.from(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E));
		assertNull( chromaticChordEnum );
	}

	@Test
	public void size() {
		assertEquals(2, ChromaticChordImmutable.C5.size());
		assertEquals(3, ChromaticChordImmutable.C.size());
		assertEquals(4, ChromaticChordImmutable.C7.size());
		assertEquals(5, ChromaticChordImmutable.C9.size());
		assertEquals(6, ChromaticChordImmutable.C11.size());
		assertEquals(7, ChromaticChordImmutable.Cm13.size());
	}

	@Test
	public void get() {
		assertEquals(Chromatic.C, ChromaticChordImmutable.C.get(0));
		assertEquals(Chromatic.E, ChromaticChordImmutable.C.get(1));
		assertEquals(Chromatic.G, ChromaticChordImmutable.C.get(2));
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(expected = IndexOutOfBoundsException.class)
	public void getIndexExceed() {
		ChromaticChordImmutable.C.get(3);
	}

	@Test
	public void getRootAll() {
		for (ChromaticChordImmutable c : ChromaticChordImmutable.values())
			assertEquals( c.get( 0 ), c.getRoot() );

	}

	@Test
	public void getRootManual() {
		assertEquals(Chromatic.C, ChromaticChordImmutable.C.getRoot());
		assertEquals(Chromatic.D, ChromaticChordImmutable.D.getRoot());
		assertEquals(Chromatic.G, ChromaticChordImmutable.G7.getRoot());
	}

	@Test
	public void getRootPosAll() {
		for (ChromaticChordImmutable c : ChromaticChordImmutable.values())
			assertEquals(0, c.getRootIndex());
	}

	@Test
	public void getInversionNumberAll() {
		for (ChromaticChordImmutable c : ChromaticChordImmutable.values())
			assertEquals( 0, c.getInversionNumber() );
	}

	@Test
	public void getQuality() {
		for (ChromaticChordImmutable c : ChromaticChordImmutable.values())
            assertNotNull(c.toString(), c.getInfo().getQuality());

        assertEquals(Quality.MAJOR, ChromaticChordImmutable.C.getInfo().getQuality());
        assertEquals(Quality.MINOR, ChromaticChordImmutable.Cm.getInfo().getQuality());
        assertEquals(Quality.DIMINISHED, ChromaticChordImmutable.Cdim.getInfo().getQuality());
        assertEquals(Quality.AUGMENTED, ChromaticChordImmutable.Caug.getInfo().getQuality());
        assertEquals(Quality.INDETERMINATED, ChromaticChordImmutable.Csus2.getInfo().getQuality());
	}

	@Test
	public void isEmpty() {
		for (ChromaticChordImmutable c : ChromaticChordImmutable.values())
			assertFalse( c.isEmpty() );
	}

	@Test
	public void contians() {
		assertTrue(ChromaticChordImmutable.C.contains(Chromatic.C));
		assertFalse(ChromaticChordImmutable.C.contains(Chromatic.D));
		assertTrue(ChromaticChordImmutable.D.contains(Chromatic.D));
		assertFalse(ChromaticChordImmutable.D.contains(Chromatic.C));
		assertTrue(ChromaticChordImmutable.C7.contains(Chromatic.C));
		assertFalse(ChromaticChordImmutable.C7.contains(Chromatic.D));
		assertTrue(ChromaticChordImmutable.D7.contains(Chromatic.D));
		assertFalse(ChromaticChordImmutable.D7.contains(Chromatic.E));
	}

	@Test
	public void contiansAll() {
		Collection<Chromatic> c = Arrays.asList( Chromatic.C, Chromatic.E );
		assertTrue(ChromaticChordImmutable.C.containsAll(c));
		assertTrue(ChromaticChordImmutable.C7.containsAll(c));
		assertTrue(ChromaticChordImmutable.C6.containsAll(c));
		assertFalse(ChromaticChordImmutable.Csus4.containsAll(c));
		assertFalse(ChromaticChordImmutable.Csus2.containsAll(c));
		assertFalse(ChromaticChordImmutable.C5.containsAll(c));
	}

	@Test
	public void indexOf() {
		assertEquals(0, ChromaticChordImmutable.C.indexOf(Chromatic.C));
		assertEquals(3, ChromaticChordImmutable.D7.indexOf(Chromatic.C));
		assertEquals(1, ChromaticChordImmutable.C13sus4.indexOf(Chromatic.F));
	}

	@Test
	public void iteratorNotNull() {
		ChromaticChordImmutable chromaticChordEnum = ChromaticChordImmutable.C;
		assertNotNull(chromaticChordEnum.iterator());
	}

	@Test
	public void lastIndexOf() {
		assertEquals(5, ChromaticChordImmutable.C13sus4.lastIndexOf(Chromatic.F));
	}
	@Test
	public void listIteratorNotNull() {
		ChromaticChordImmutable chromaticChordEnum = ChromaticChordImmutable.C;
		assertNotNull(chromaticChordEnum.listIterator());
	}

@Test
	public void listIteratorIndexNotNull() {
	ChromaticChordImmutable chromaticChordEnum = ChromaticChordImmutable.C;
		assertNotNull(chromaticChordEnum.listIterator(2));
	}

	@Test
	public void subList() {
		assertEquals(ChromaticChord.C.getNotes(), ChromaticChordImmutable.C7.subList(0, 3));
		assertEquals(ChromaticChord.Edim.getNotes(), ChromaticChordImmutable.C7.subList(1, 4));
	}

	@Test
	public void toArray() {
		Object[] objs = ChromaticChordImmutable.C.toArray();

		Chromatic[] c = new Chromatic[objs.length];
		for (int i = 0; i < objs.length; i++)
			c[i] = (Chromatic) objs[i];

		assertEquals(c.length, ChromaticChordImmutable.C.size());
		for (int i = 0; i < c.length; i++)
			assertEquals(c[i], ChromaticChordImmutable.C.get(i));
	}

	@Test
	public void toArray2() {
		Chromatic[] c = new Chromatic[ChromaticChordImmutable.C.size()];
		c = ChromaticChordImmutable.C.toArray(c);

		assertEquals(c.length, ChromaticChordImmutable.C.size());
		for (int i = 0; i < c.length; i++)
			assertEquals(c[i], ChromaticChordImmutable.C.get(i));
	}

	/**
	 *  UnsupportedOperation
	 */

	@Test(expected = UnsupportedOperationException.class)
	public void clear() {
		ChromaticChordImmutable.C.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeObject() {
		ChromaticChordImmutable.C.remove(Chromatic.C);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeIndex() {
		ChromaticChordImmutable.C.remove(0);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeAll() {
		List<Chromatic> removeList = new ArrayList<>();
		removeList.add( Chromatic.C );
		removeList.add( Chromatic.E );
		removeList.add( Chromatic.F );
		ChromaticChordImmutable.C.removeAll(removeList);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void retainAll() {
		List<Chromatic> retainList = new ArrayList<>();
		retainList.add( Chromatic.C );
		retainList.add( Chromatic.E );
		retainList.add( Chromatic.G );
		ChromaticChordImmutable.C.retainAll(retainList);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void set() {
		ChromaticChordImmutable.C.set(0, Chromatic.D);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void add() {
		ChromaticChordImmutable.C.add(Chromatic.D);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void add2() {
		ChromaticChordImmutable.C.add(0, Chromatic.D);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAll() {
		ChromaticChordImmutable.C.addAll(ChromaticChordImmutable.D);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAll2() {
		ChromaticChordImmutable.C.addAll(0, ChromaticChordImmutable.D);
	}

    @Test
    public void content() {
		ChromaticChordImmutable chromaticChordEnum = ChromaticChordImmutable.B9;
        assertSame(5, chromaticChordEnum.size());
        assertSame(Chromatic.B, chromaticChordEnum.get(0));
        assertSame(Chromatic.DD, chromaticChordEnum.get(1));
        assertSame(Chromatic.FF, chromaticChordEnum.get(2));
        assertSame(Chromatic.A, chromaticChordEnum.get(3));
        assertSame(Chromatic.CC, chromaticChordEnum.get(4));
    }
}

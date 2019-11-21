package es.danisales.datune.musical;

import es.danisales.datune.diatonic.Quality;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordEnumTest {
	@Test
	public void fromList() {
		ChromaticChordEnum c = ChromaticChordEnum.from( Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G) );
		assertSame(ChromaticChordEnum.C, c);
	}

	@Test
	public void fromListNonNullValues() {
		for (ChromaticChordEnum cc : ChromaticChordEnum.values())
			assertNotNull( ChromaticChordEnum.from( cc ) );
	}

	@Test
	public void testSomeValues() {
		assertEquals(Arrays.asList(Chromatic.C, Chromatic.G), ChromaticChordEnum.C5);
	}

	@Test
	public void fromListNotFound() {
		ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.from( Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.E) );
		assertNull( chromaticChordEnum );
	}

	@Test
	public void size() {
			assertEquals(2, ChromaticChordEnum.C5.size());
			assertEquals(3, ChromaticChordEnum.C.size());
			assertEquals(4, ChromaticChordEnum.C7.size());
			assertEquals(5, ChromaticChordEnum.C9.size());
			assertEquals(6, ChromaticChordEnum.C11.size());
			assertEquals(7, ChromaticChordEnum.Cm13.size());
	}

	@Test
	public void get() {
		assertEquals(Chromatic.C, ChromaticChordEnum.C.get(0));
		assertEquals(Chromatic.E, ChromaticChordEnum.C.get(1));
		assertEquals(Chromatic.G, ChromaticChordEnum.C.get(2));
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(expected = IndexOutOfBoundsException.class)
	public void getIndexExceed() {
		ChromaticChordEnum.C.get(3);
	}

	@Test
	public void getRootAll() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertEquals( c.get( 0 ), c.getRoot() );

	}

	@Test
	public void getRootManual() {
		assertEquals(Chromatic.C, ChromaticChordEnum.C.getRoot());
		assertEquals(Chromatic.D, ChromaticChordEnum.D.getRoot());
		assertEquals(Chromatic.G, ChromaticChordEnum.G7.getRoot());
	}

	@Test
	public void getRootPosAll() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertEquals( 0, c.getRootPos() );
	}

	@Test
	public void getInversionNumberAll() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertEquals( 0, c.getInversionNumber() );
	}

	@Test
	public void getQuality() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertNotNull( c.toString(), c.getQuality() );

		assertEquals( Quality.MAJOR, ChromaticChordEnum.C.getQuality() );
		assertEquals( Quality.MINOR, ChromaticChordEnum.Cm.getQuality() );
		assertEquals( Quality.DIMINISHED, ChromaticChordEnum.Cdim.getQuality() );
		assertEquals( Quality.AUGMENTED, ChromaticChordEnum.Caug.getQuality() );
		assertEquals( Quality.INDETERMINATED, ChromaticChordEnum.Csus2.getQuality() );
	}

	@Test
	public void isEmpty() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertFalse( c.isEmpty() );
	}

	@Test
	public void contians() {
		assertTrue( ChromaticChordEnum.C.contains( Chromatic.C ) );
		assertFalse( ChromaticChordEnum.C.contains( Chromatic.D ) );
		assertTrue( ChromaticChordEnum.D.contains( Chromatic.D ) );
		assertFalse( ChromaticChordEnum.D.contains( Chromatic.C ) );
		assertTrue( ChromaticChordEnum.C7.contains( Chromatic.C ) );
		assertFalse( ChromaticChordEnum.C7.contains( Chromatic.D ) );
		assertTrue( ChromaticChordEnum.D7.contains( Chromatic.D ) );
		assertFalse( ChromaticChordEnum.D7.contains( Chromatic.E ) );
	}

	@Test
	public void contiansAll() {
		Collection<Chromatic> c = Arrays.asList( Chromatic.C, Chromatic.E );
		assertTrue( ChromaticChordEnum.C.containsAll( c ) );
		assertTrue( ChromaticChordEnum.C7.containsAll( c ) );
		assertTrue( ChromaticChordEnum.C6.containsAll( c ) );
		assertFalse( ChromaticChordEnum.Csus4.containsAll( c ) );
		assertFalse( ChromaticChordEnum.Csus2.containsAll( c ) );
		assertFalse( ChromaticChordEnum.C5.containsAll( c ) );
	}

	@Test
	public void indexOf() {
		assertEquals( 0, ChromaticChordEnum.C.indexOf( Chromatic.C ) );
		assertEquals( 3, ChromaticChordEnum.D7.indexOf( Chromatic.C ) );
		assertEquals( 1, ChromaticChordEnum.C13sus4.indexOf( Chromatic.F ) );
	}

	@Test
	public void iteratorNotNull() {
		ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.C;
		assertNotNull(chromaticChordEnum.iterator());
	}

	@Test
	public void lastIndexOf() {
		assertEquals( 5, ChromaticChordEnum.C13sus4.lastIndexOf( Chromatic.F ) );
	}
	@Test
	public void listIteratorNotNull() {
		ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.C;
		assertNotNull(chromaticChordEnum.listIterator());
	}

@Test
	public void listIteratorIndexNotNull() {
		ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.C;
		assertNotNull(chromaticChordEnum.listIterator(2));
	}

	@Test
	public void subList() {
		assertEquals( ChromaticChord.C, ChromaticChordEnum.C7.subList( 0, 3 ) );
		assertEquals( ChromaticChord.Edim, ChromaticChordEnum.C7.subList( 1, 4 ) );
	}

	@Test
	public void toArray() {
		Object[] objs = ChromaticChordEnum.C.toArray();

		Chromatic[] c = new Chromatic[objs.length];
		for (int i = 0; i < objs.length; i++)
			c[i] = (Chromatic) objs[i];

		assertEquals(c.length, ChromaticChordEnum.C.size());
		for (int i = 0; i < c.length; i++)
			assertEquals(c[i], ChromaticChordEnum.C.get( i ));
	}

	@Test
	public void toArray2() {
		Chromatic[] c = new Chromatic[ChromaticChordEnum.C.size()];
		c = ChromaticChordEnum.C.toArray(c);

		assertEquals(c.length, ChromaticChordEnum.C.size());
		for (int i = 0; i < c.length; i++)
			assertEquals(c[i], ChromaticChordEnum.C.get( i ));
	}

	/**
	 *  UnsupportedOperation
	 */

	@Test(expected = UnsupportedOperationException.class)
	public void clear() {
		ChromaticChordEnum.C.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeObject() {
		ChromaticChordEnum.C.remove(Chromatic.C);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeIndex() {
		ChromaticChordEnum.C.remove(0);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeAll() {
		List<Chromatic> removeList = new ArrayList<>();
		removeList.add( Chromatic.C );
		removeList.add( Chromatic.E );
		removeList.add( Chromatic.F );
		ChromaticChordEnum.C.removeAll( removeList );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void retainAll() {
		List<Chromatic> retainList = new ArrayList<>();
		retainList.add( Chromatic.C );
		retainList.add( Chromatic.E );
		retainList.add( Chromatic.G );
		ChromaticChordEnum.C.retainAll( retainList );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void set() {
		ChromaticChordEnum.C.set( 0, Chromatic.D );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void add() {
		ChromaticChordEnum.C.add( Chromatic.D );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void add2() {
		ChromaticChordEnum.C.add( 0, Chromatic.D );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAll() {
		ChromaticChordEnum.C.addAll( ChromaticChordEnum.D );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAll2() {
		ChromaticChordEnum.C.addAll( 0, ChromaticChordEnum.D );
	}
}

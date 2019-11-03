package es.danisales.datune;

import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChordEnum;
import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ChromaticChordEnumTest {
	@Test
	public void over() {
		PitchChromaticChord<Chromatic> c = ChromaticChordEnum.C.over(Chromatic.C);

		c = ChromaticChordEnum.C.over(Chromatic.E);

		assertEquals( Chromatic.E, c.get( 0 ) );

		assertEquals( ChromaticChordEnum.C.getInv(), c );
	}

	@Test(expected = CustomChromaticChord.ImpossibleChord.class)
	public void overImpossibleChord() {
		PitchChromaticChord<Chromatic> c = ChromaticChordEnum.C.over(Chromatic.F);
	}

	@Test
	public void isEmpty() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertFalse( c.isEmpty() );
	}

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
		List<Chromatic> removeList = new ArrayList();
		removeList.add( Chromatic.C );
		removeList.add( Chromatic.E );
		removeList.add( Chromatic.F );
		ChromaticChordEnum.C.removeAll( removeList );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void retainAll() {
		List<Chromatic> retainList = new ArrayList();
		retainList.add( Chromatic.C );
		retainList.add( Chromatic.E );
		retainList.add( Chromatic.G );
		ChromaticChordEnum.C.retainAll( retainList );
	}

	@Test(expected = UnsupportedOperationException.class)
	public void set() {
		ChromaticChordEnum.C.set( 0, Chromatic.D );
	}

	@Test
	public void size() {
		for (ChromaticChordEnum c : ChromaticChordEnum.CHORDS_FIFTH)
			assertEquals(2, c.size());

		for (ChromaticChordEnum c : ChromaticChordEnum.TRIAD_CHORDS)
			assertEquals(3, c.size());

		for (ChromaticChordEnum c : ChromaticChordEnum.SEVENTH_CHORDS)
			if (ChromaticChordEnum.CHORDS_7add11.contains( c ) || ChromaticChordEnum.CHORDS_7add13.contains( c ))
				assertEquals(c.toString(), 5, c.size());
			else
				assertEquals(c.toString(), 4, c.size());

		for (ChromaticChordEnum c : ChromaticChordEnum.NINTH_CHORDS)
			if (ChromaticChordEnum.CHORDS_9add6.contains( c ) || ChromaticChordEnum.CHORDS_9a11.contains( c ) || ChromaticChordEnum.CHORDS_Maj9a11.contains( c ))
				assertEquals(c.toString(), 6, c.size());
			else
				assertEquals(c.toString(), 5, c.size());

		for (ChromaticChordEnum c : ChromaticChordEnum.ELEVENTH_CHORDS)
			assertEquals(c.toString(), 6, c.size());

		for (ChromaticChordEnum c : ChromaticChordEnum.THIRTEENTH_CHORDS)
			assertEquals(c.toString(), 7, c.size());
	}

	@Test
	public void get() {
		assertEquals(Chromatic.C, ChromaticChordEnum.C.get(0));
		assertEquals(Chromatic.E, ChromaticChordEnum.C.get(1));
		assertEquals(Chromatic.G, ChromaticChordEnum.C.get(2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getException() {
		ChromaticChordEnum.C.get(3);
	}

	@Test
	public void getRoot() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertEquals( c.get( 0 ), c.getRoot() );
	}

	@Test
	public void getRootPos() {
		for (ChromaticChordEnum c : ChromaticChordEnum.values())
			assertEquals( 0, c.getRootPos() );
	}
	@Test
	public void getInversionNumber() {
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
	public void of() {
		ChromaticChordEnum c = ChromaticChordEnum.of( Chromatic.C, Chromatic.E, Chromatic.G );
		assertEquals(ChromaticChordEnum.C, c);

		for (ChromaticChordEnum cc : ChromaticChordEnum.values())
			assertNotNull( ChromaticChordEnum.of( cc ) );

		assertNull( ChromaticChordEnum.of( Chromatic.C, Chromatic.D, Chromatic.E ) );
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
	public void lastIndexOf() {
		assertEquals( 5, ChromaticChordEnum.C13sus4.lastIndexOf( Chromatic.F ) );
	}
	
	@Test
	public void subList() {
		assertEquals( ChromaticChordEnum.C, ChromaticChordEnum.C7.subList( 0, 3 ) );
		assertEquals( ChromaticChordEnum.Edim, ChromaticChordEnum.C7.subList( 1, 4 ) );
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
}

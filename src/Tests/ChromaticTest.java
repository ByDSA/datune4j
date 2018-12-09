package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pitch.Chromatic;

public class ChromaticTest {

	@Test
	public void noteName() {
		Chromatic note = Chromatic.C;

		assertEquals( 0, note.val() );

		note = Chromatic.A;

		assertEquals( 9, note.val() );
	}
	@Test
	public void add() {
		Chromatic c = Chromatic.C.add(2);
		assertEquals(Chromatic.D, c);
		
		c = Chromatic.B.add(2);
		assertEquals(Chromatic.CC, c);
		
		c = Chromatic.C.add(-2);
		assertEquals(Chromatic.AA, c);
	}
	
	@Test
	public void equals() {
		assertFalse(Chromatic.Bb.equals(Chromatic.AA));
		assertFalse(Chromatic.Eb.equals(Chromatic.DD));
		assertFalse(Chromatic.C.equals(Chromatic.BB));
		assertFalse(Chromatic.CCC.equals(Chromatic.D));
		assertFalse(Chromatic.CCCC.equals(Chromatic.DD));
		
		
		assertTrue(Chromatic.C.equals(Chromatic.C));
		assertTrue(Chromatic.Bb.equals(Chromatic.Bb));
	}
	
	@Test
	public void equalsEnharmonics() {
		assertTrue(Chromatic.Bb.equalsEnharmonic(Chromatic.AA));
		assertTrue(Chromatic.Eb.equalsEnharmonic(Chromatic.DD));
		assertTrue(Chromatic.C.equalsEnharmonic(Chromatic.BB));
		assertTrue(Chromatic.CCC.equalsEnharmonic(Chromatic.D));
		assertTrue(Chromatic.CCCC.equalsEnharmonic(Chromatic.DD));
	}
	
	@Test
	public void getEnharmonics() {
		Chromatic[] cs = Chromatic.C.getEnharmonics();
		assertEquals(4, cs.length);
	}
	
	@Test
	public void delimit() {
		assertEquals(Chromatic.C, Chromatic.get(0));
		assertEquals(Chromatic.C, Chromatic.get(12));
		assertEquals(Chromatic.C, Chromatic.get(24));
		assertEquals(Chromatic.B, Chromatic.get(-1));
		assertEquals(Chromatic.B, Chromatic.get(-13));
		assertEquals(Chromatic.B, Chromatic.get(-25));
	}
	
	@Test
	public void dist() {
		assertEquals((Integer)1, Chromatic.B.dist(Chromatic.C));
		assertEquals((Integer)11, Chromatic.C.dist(Chromatic.B));
		assertEquals((Integer)11, Chromatic.CC.dist(Chromatic.C));
		assertEquals((Integer)11, Chromatic.B.dist(Chromatic.Bb));
	}
	
	@Test
	public void mean() {
		assertEquals(Chromatic.C.val(), (int)Chromatic.C.getPitchMean());
		assertEquals(Chromatic.G.val(), (int)Chromatic.G.getPitchMean());
	}
}

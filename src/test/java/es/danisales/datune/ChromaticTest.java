package es.danisales.datune;

import es.danisales.datune.musical.Chromatic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ChromaticTest {

	@Test
	public void noteName() {
		Chromatic note = Chromatic.C;

		assertEquals( 0, note.distSemitonesFromC() );

		note = Chromatic.A;

		assertEquals( 9, note.distSemitonesFromC() );
	}
	@Test
	public void add() {
		Chromatic c = Chromatic.C.addSemi(2);
		assertEquals(Chromatic.D, c);
		
		c = Chromatic.B.addSemi(2);
		assertEquals(Chromatic.CC, c);
		
		c = Chromatic.C.addSemi(-2);
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
		assertTrue(Chromatic.Bb.compareEnharmonicTo(Chromatic.AA) == 0);
		assertTrue(Chromatic.Eb.compareEnharmonicTo(Chromatic.DD) == 0);
		assertTrue(Chromatic.C.compareEnharmonicTo(Chromatic.BB) == 0);
		assertTrue(Chromatic.CCC.compareEnharmonicTo(Chromatic.D) == 0);
		assertTrue(Chromatic.CCCC.compareEnharmonicTo(Chromatic.DD) == 0);
	}
	
	@Test
	public void getEnharmonics() {
		List<Chromatic> cs = Chromatic.C.getEnharmonics();
		assertEquals(4, cs.size());
	}
	
	@Test
	public void delimit() {
		assertEquals(Chromatic.C, Chromatic.from(0));
		assertEquals(Chromatic.C, Chromatic.from(12));
		assertEquals(Chromatic.C, Chromatic.from(24));
		assertEquals(Chromatic.B, Chromatic.from(-1));
		assertEquals(Chromatic.B, Chromatic.from(-13));
		assertEquals(Chromatic.B, Chromatic.from(-25));
	}
	
	@Test
	public void dist() {
		assertEquals(1, Chromatic.B.distSemitonesTo(Chromatic.C));
		assertEquals(11, Chromatic.C.distSemitonesTo(Chromatic.B));
		assertEquals(11, Chromatic.CC.distSemitonesTo(Chromatic.C));
		assertEquals(11, Chromatic.B.distSemitonesTo(Chromatic.Bb));
	}
}

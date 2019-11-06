package es.danisales.datune;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ChromaticTest {

	@Test
	public void noteName() {
		Chromatic note = Chromatic.C;

		assertEquals( 0, note.ordinal() );

		note = Chromatic.A;

		assertEquals( 9, note.ordinal() );
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
		assertNotEquals(DiatonicAlt.Bb, DiatonicAlt.AA);
		assertNotEquals(DiatonicAlt.Eb, DiatonicAlt.DD);
		assertNotEquals(DiatonicAlt.C, DiatonicAlt.BB);
		assertNotEquals(DiatonicAlt.CCC, DiatonicAlt.D);
		assertNotEquals(DiatonicAlt.CCCC, DiatonicAlt.DD);


		assertEquals(DiatonicAlt.C, DiatonicAlt.C);
		assertEquals(DiatonicAlt.Bb, DiatonicAlt.Bb);
	}
	
	@Test
	public void equalsEnharmonics() {
		assertSame(Chromatic.from(DiatonicAlt.Bb), Chromatic.AA);
		assertSame(Chromatic.from(DiatonicAlt.Eb), Chromatic.DD);
		assertSame(Chromatic.from(DiatonicAlt.BB), Chromatic.C);
		assertSame(Chromatic.from(DiatonicAlt.CCC), Chromatic.D);
		assertSame(Chromatic.from(DiatonicAlt.CCCC), Chromatic.DD);
	}
	
	@Test
	public void getEnharmonics() {
		List<DiatonicAlt> cs = Chromatic.C.getEnharmonics(3);
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
		assertEquals(11, Chromatic.B.distSemitonesTo(Chromatic.from(DiatonicAlt.Bb)));
	}
}

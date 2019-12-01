package es.danisales.datune;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.EnharmonicsRetrieval;
import es.danisales.datune.tonality.ScaleDistance;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ChromaticTest {
	private void fromDiatonicAltTargetSource(Chromatic target, DiatonicAlt source) {
		Chromatic actual = Chromatic.from(source);
		assertSame(target, actual);
	}

	@Test
	public void fromDiatonicAlt() {
		fromDiatonicAltTargetSource(Chromatic.C, DiatonicAlt.C);
	}

	@Test
	public void fromDiatonicAlt2() {
		fromDiatonicAltTargetSource(Chromatic.CC, DiatonicAlt.CC);
	}

	@Test
	public void fromDiatonicAlt3() {
		fromDiatonicAltTargetSource(Chromatic.D, DiatonicAlt.CCC);
	}

	@Test
	public void fromDiatonicAlt4() {
		fromDiatonicAltTargetSource(Chromatic.DD, DiatonicAlt.CCCC);
	}

	@Test
	public void fromDiatonicAlt5() {
		fromDiatonicAltTargetSource(Chromatic.E, DiatonicAlt.CCCCC);
	}

	@Test
	public void fromDiatonicAlt6() {
		fromDiatonicAltTargetSource(Chromatic.C, DiatonicAlt.Dbb);
	}

	@Test
	public void fromDiatonicAlt7() {
		fromDiatonicAltTargetSource(Chromatic.C, DiatonicAlt.BB);
	}

	@Test
	public void fromDiatonicAlt8() {
		fromDiatonicAltTargetSource(Chromatic.DD, DiatonicAlt.Eb);
	}

	@Test
	public void fromDiatonicAltMicro() {
		fromDiatonicAltTargetSource(Chromatic.CC,
				DiatonicAlt.C.add(ScaleDistance.QUARTER));
	}

	@Test
	public void fromDiatonicAltMicro2() {
		fromDiatonicAltTargetSource(Chromatic.CC,
				DiatonicAlt.C.add(ScaleDistance.QUARTER).add(ScaleDistance.QUARTER));
	}

	@Test
	public void fromDiatonicAltMicro3() {
		fromDiatonicAltTargetSource(Chromatic.C,
				DiatonicAlt.C.sub(ScaleDistance.QUARTER));
	}

	@Test
	public void fromDiatonicAltMicro4() {
		fromDiatonicAltTargetSource(Chromatic.B,
				DiatonicAlt.C.sub(ScaleDistance.QUARTER).sub(ScaleDistance.QUARTER));
	}

	@Test
	public void noteName() {
		Chromatic note = Chromatic.C;

		assertEquals( 0, note.ordinal() );

		note = Chromatic.A;

		assertEquals( 9, note.ordinal() );
	}
	@Test
	public void add() {
		Chromatic c = Chromatic.C.getNext(2);
		assertEquals(Chromatic.D, c);

		c = Chromatic.B.getNext(2);
		assertEquals(Chromatic.CC, c);

		c = Chromatic.C.getNext(-2);
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
		Set<DiatonicAlt> cs = EnharmonicsRetrieval.getFromChromatic(Chromatic.C, 3);
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

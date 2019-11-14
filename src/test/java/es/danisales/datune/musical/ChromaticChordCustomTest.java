package es.danisales.datune.musical;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ChromaticChordCustomTest {
	@Test
	public void over() {
		ChromaticChordCustom c = ChromaticChordCustom.from(ChromaticChordEnum.C);
		c.over(Chromatic.C);

		c = ChromaticChordCustom.from( ChromaticChordEnum.C);
		c.over(Chromatic.E);

		Assert.assertEquals( Chromatic.E, c.get( 0 ) );

		ChromaticChordCustom reference = ChromaticChordCustom.from(ChromaticChordEnum.C);
		reference.inv();
		Assert.assertEquals(reference, c );
	}

	@Test(expected = ImpossibleChordException.class)
	public void overImpossibleChord() {
		ChromaticChordCustom c = ChromaticChordCustom.from(ChromaticChordEnum.C);
		c.over(Chromatic.F);
	}

	@Test
	public void fromList() {
		ChromaticChordCustom chromaticChordCustom1 = ChromaticChordCustom.from(
				Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
		);

		ChromaticChordCustom chromaticChordCustom2 = new ChromaticChordCustom();
		chromaticChordCustom2.add(Chromatic.C);
		chromaticChordCustom2.add(Chromatic.E);
		chromaticChordCustom2.add(Chromatic.G);

		assertEquals(
				chromaticChordCustom1,
				chromaticChordCustom2
		);
	}

	@Test
	public void fromChord() {
		ChromaticChordCustom chromaticChordCustom1 = ChromaticChordCustom.from(
				Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)
		);
		chromaticChordCustom1.setRootPos(2);

		ChromaticChordCustom chromaticChordCustom2 = ChromaticChordCustom.from(
				Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
		);
		chromaticChordCustom2.inv();

		assertEquals(
				chromaticChordCustom1,
				chromaticChordCustom2
		);
	}

	@Test
	public void duplicate() {
		ChromaticChordCustom ca = ChromaticChordCustom.from(
				Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
		);
		ChromaticChordCustom ca2 = ca.duplicate();

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		ChromaticChordCustom c = ChromaticChordCustom.from( ChromaticChordEnum.C );
		c.inv();
		assertEquals( Chromatic.E, c.get( 0 ) );
		assertEquals( Chromatic.G, c.get( 1 ) );
		assertEquals( Chromatic.C, c.get( 2 ) );
		assertEquals( Chromatic.C, c.getRoot() );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		assertEquals( Chromatic.C, ChromaticChordEnum.C.getRoot() );
		ChromaticChordCustom c = ChromaticChordCustom.from( ChromaticChordEnum.C );
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot() );
		c = ChromaticChordCustom.from( ChromaticChordEnum.F5 );
		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot() );
	}
}

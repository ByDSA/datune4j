package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ChromaticChordCustomTest {
	@Test
	public void over() {
		ChromaticChordMutable c = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		c.over(Chromatic.C);

		c = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		c.over(Chromatic.E);

		Assert.assertEquals( Chromatic.E, c.get( 0 ) );

		ChromaticChordMutable reference = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		reference.inv();
		Assert.assertEquals(reference, c );
	}

    @Test(expected = InvalidChordException.class)
	public void overImpossibleChord() {
		ChromaticChordMutable c = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		c.over(Chromatic.F);
	}

	@Test
	public void fromList() {
		ChromaticChordMutable chromaticChordCustom1 = ChromaticChordMutable.from(
				Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
		);

		ChromaticChordMutable chromaticChordCustom2 = new ChromaticChordMutable();
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
		ChromaticChordMutable chromaticChordCustom1 = ChromaticChordMutable.from(
				Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)
		);
		chromaticChordCustom1.setRootIndex(2);

		ChromaticChordMutable chromaticChordCustom2 = ChromaticChordMutable.from(
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
		ChromaticChordMutable ca = ChromaticChordMutable.from(
				Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G)
		);
		ChromaticChordMutable ca2 = ca.clone();

		assertEquals(ca.getRootIndex(), ca2.getRootIndex());
		assertEquals(ca.size(), ca2.size());
		for (int i = 0; i < ca.size(); i++)
			assertEquals(ca.get(i), ca2.get(i));

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		ChromaticChordMutable c = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		c.inv();
		assertEquals( Chromatic.E, c.get( 0 ) );
		assertEquals( Chromatic.G, c.get( 1 ) );
		assertEquals( Chromatic.C, c.get( 2 ) );
		assertEquals( Chromatic.C, c.getRoot() );
		assertEquals(2, c.getRootIndex());
	}

	@Test
	public void getRoot() {
		assertEquals(Chromatic.C, ChromaticChordImmutable.C.getRoot());
		ChromaticChordMutable c = ChromaticChordMutable.from(ChromaticChordImmutable.C);
		c.inv();
		assertEquals(2, c.getRootIndex());
		assertEquals( Chromatic.C, c.getRoot() );
		c = ChromaticChordMutable.from(ChromaticChordImmutable.F5);
		c.inv();
		assertEquals(1, c.getRootIndex());
		assertEquals( Chromatic.F, c.getRoot() );
	}
}

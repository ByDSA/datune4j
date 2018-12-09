package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import diatonic.DiatonicFunction;
import diatonic.Tonality;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.DiatonicChordMidi;

public class ChromaticChordTest {
	@Test
	public void duplicate() {
		ChromaticChord ca = new ChromaticChord( Chromatic.C, Chromatic.E, Chromatic.G );
		ChromaticChord ca2 = ca.duplicate();

		assertEquals( ca, ca2 );
	}

	@Test
	public void inv() {
		ChromaticChord c = ChromaticChord.C.duplicate();
		c.inv();
		assertEquals( Chromatic.E, c.get( 0 ) );
		assertEquals( Chromatic.G, c.get( 1 ) );
		assertEquals( Chromatic.C, c.get( 2 ) );
		assertEquals( Chromatic.C, c.getRoot() );
		assertEquals( 2, c.getRootPos() );
	}

	@Test
	public void getRoot() {
		assertEquals( Chromatic.C, ChromaticChord.C.getRoot() );
		ChromaticChord c = ChromaticChord.C.duplicate();
		c.inv();
		assertEquals( 2, c.getRootPos() );
		assertEquals( Chromatic.C, c.getRoot() );
		c = ChromaticChord.F5.duplicate();
		c.inv();
		assertEquals( 1, c.getRootPos() );
		assertEquals( Chromatic.F, c.getRoot() );
	}

	@Test
	public void names() {
		assertEquals( "C", ChromaticChord.C.toString() );

		ChromaticChord cc = new ChromaticChord( Chromatic.C, Chromatic.E, Chromatic.G );

		assertEquals( "C", cc.toString() );

		assertEquals( "Cm", ChromaticChord.Cm.toString() );
		assertEquals( "C7", ChromaticChord.C7.toString() );
		assertEquals(
			"C/E (I)", new DiatonicChordMidi( DiatonicFunction.I, Tonality.C ).inv().toString()
		);
		assertEquals( "C/E", ChromaticChord.C.duplicate().inv().toString() );
		assertEquals( "C/G", ChromaticChord.C.duplicate().inv( 2 ).toString() );
		assertEquals( "C", ChromaticChord.C.duplicate().inv( 3 ).toString() );
		assertEquals( "F5", ChromaticChord.F5.duplicate().toString() );
		assertEquals( "F5/C", ChromaticChord.F5.duplicate().inv().toString() );

		assertEquals( "Csus2", ChromaticChord.Csus2.toString() );
		assertEquals( "Csus2/D", ChromaticChord.Csus2.duplicate().inv().toString() );
		assertEquals( "Gsus4", ChromaticChord.Gsus4.toString() );
		assertEquals( "Gsus4/C", ChromaticChord.Gsus4.duplicate().inv().toString() );
	}

	@Test
	public void mean() {
		assertEquals( Chromatic.E.val(), Math.round( ChromaticChord.C.getPitchMean() ) );
	}

	@Test
	public void dist() {
		ChromaticChord cc = ChromaticChord.C;
		assertEquals( 4, Math.round( Chromatic.C.dist( ChromaticChord.C ) ) );
		assertEquals( 0, Math.round( Chromatic.E.dist( ChromaticChord.C ) ) );
	}
}

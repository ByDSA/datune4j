package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.Tonality;
import pitch.Chromatic;
import pitch.ChromaticChord;
import pitch.DiatonicChordMidi;

public class ChromaticFunctionTest {
	@Test
	public void degree() {
		Tonality ton = Tonality.C;
		ChromaticChord cc = new ChromaticChord( ChromaticFunction.I, ton );
		assertEquals( Degree.I, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.II, ton );
		assertEquals( Degree.II, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.III, ton );
		assertEquals( Degree.III, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.IV, ton );
		assertEquals( Degree.IV, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.V, ton );
		assertEquals( Degree.V, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.VI, ton );
		assertEquals( Degree.VI, ton.getDegree( cc.get( 0 ) ) );
		cc = new ChromaticChord( ChromaticFunction.VII, ton );
		assertEquals( Degree.VII, ton.getDegree( cc.get( 0 ) ) );

		DiatonicChordMidi dc = new ChromaticChord( ChromaticFunction.I, ton )
				.toMidi()
				.toDiatonicChordMidi( ton );
		assertEquals( Degree.I, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.ii, ton ).toMidi().toDiatonicChordMidi( ton );
		Chromatic c = dc.getRoot().getChromatic();
		Degree d = ton.getDegree( c );
		assertEquals( Degree.II, d );
		assertEquals( Degree.II, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.iii, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.III, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.IV, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.IV, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.V, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.V, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.vi, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.VI, dc.getDegree() );
		dc = new ChromaticChord( ChromaticFunction.VII0, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.VII, dc.getDegree() );
	}

	@Test
	public void get() {
		Tonality t = Tonality.C;
		ChromaticChord cc = ChromaticChord.F5;
		assertEquals( ChromaticFunction.IV5, ChromaticFunction.get( cc, t ) );

		checkTonality( Tonality.C );
		checkTonality( Tonality.D );
		checkTonality( Tonality.Cm );
		checkTonality( Tonality.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( ChromaticFunction cf : ChromaticFunction.ALL ) {
			if ( cf == ChromaticFunction.V_IV || cf == ChromaticFunction.V7_IV )
				continue;
			diatonicChordMidi = ton.get( cf ).toDiatonicChordMidi( ton );
			assertEquals( cf, ChromaticFunction.get( diatonicChordMidi ) );
		}
	}
	
	@Test
	public void _toStringNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.toString() );
		}
	}
	
	@Test
	public void getDregreeNotNull() {
		for (ChromaticFunction cf : ChromaticFunction.values()) {
			assertNotNull( cf.getDegree() );
		}
	}
}

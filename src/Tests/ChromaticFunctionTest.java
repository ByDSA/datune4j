package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import chromaticchord.ChromaticChordEnum;
import chromaticchord.CustomChromaticChord;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import pitch.Chromatic;
import pitch.DiatonicChordMidi;
import tonality.Tonality;
import tonality.TonalityEnum;

public class ChromaticFunctionTest {
	@Test
	public void degree() {
		Tonality ton = TonalityEnum.C;
		CustomChromaticChord cc = new CustomChromaticChord( ChromaticFunction.I, ton );
		assertEquals( Degree.I, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.II, ton );
		assertEquals( Degree.II, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.III, ton );
		assertEquals( Degree.III, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.IV, ton );
		assertEquals( Degree.IV, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.V, ton );
		assertEquals( Degree.V, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.VI, ton );
		assertEquals( Degree.VI, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.VII, ton );
		assertEquals( Degree.VII, ton.getDegree( cc.get( 0 ) ) );

		DiatonicChordMidi dc = new CustomChromaticChord( ChromaticFunction.I, ton )
				.toMidi()
				.toDiatonicChordMidi( ton );
		assertEquals( Degree.I, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.ii, ton ).toMidi().toDiatonicChordMidi( ton );
		Chromatic c = dc.getRoot().getChromatic();
		Degree d = ton.getDegree( c );
		assertEquals( Degree.II, d );
		assertEquals( Degree.II, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.iii, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.III, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.IV, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.IV, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.V, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.V, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.vi, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.VI, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.VII0, ton ).toMidi().toDiatonicChordMidi( ton );
		assertEquals( Degree.VII, dc.getDegree() );
	}
/*
	@Test
	public void get() {
		Tonality t = TonalityEnum.C;
		ChromaticChordEnum cc = ChromaticChordEnum.F5;
		assertEquals( ChromaticFunction.IV5, ChromaticFunction.get( cc, t ) );

		checkTonality( TonalityEnum.C );
		checkTonality( TonalityEnum.D );
		checkTonality( TonalityEnum.Cm );
		checkTonality( TonalityEnum.Dm );
	}

	public void checkTonality(Tonality ton) {
		DiatonicChordMidi diatonicChordMidi = null;
		for ( ChromaticFunction cf : ChromaticFunction.ALL ) {
			if ( cf == ChromaticFunction.V_IV || cf == ChromaticFunction.V7_IV )
				continue;
			diatonicChordMidi = ton.get( cf ).toDiatonicChordMidi( ton );
			assertEquals( cf, ChromaticFunction.get( diatonicChordMidi ) );
		}
	}*/
	
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

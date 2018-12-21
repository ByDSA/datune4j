package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import diatonic.ChromaticFunction;
import diatonic.DiatonicDegree;
import musical.Chromatic;
import musical.ChromaticChordEnum;
import musical.CustomChromaticChord;
import pitch.DiatonicChordMidi;
import tonality.Tonality;
import tonality.TonalityEnum;

public class ChromaticFunctionTest {
	@Test
	public void degree() {
		Tonality ton = TonalityEnum.C;
		CustomChromaticChord cc = new CustomChromaticChord( ChromaticFunction.I, ton );
		assertEquals( DiatonicDegree.I, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.II, ton );
		assertEquals( DiatonicDegree.II, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.III, ton );
		assertEquals( DiatonicDegree.III, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.IV, ton );
		assertEquals( DiatonicDegree.IV, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.V, ton );
		assertEquals( DiatonicDegree.V, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.VI, ton );
		assertEquals( DiatonicDegree.VI, ton.getDegree( cc.get( 0 ) ) );
		cc = new CustomChromaticChord( ChromaticFunction.VII, ton );
		assertEquals( DiatonicDegree.VII, ton.getDegree( cc.get( 0 ) ) );

		DiatonicChordMidi dc = new CustomChromaticChord( ChromaticFunction.I, ton )
				.toMidi()
				.getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.I, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.ii, ton ).toMidi().getDiatonicChordMidi( ton );
		Chromatic c = dc.getRoot().getChromatic();
		DiatonicDegree d = ton.getDegree( c );
		assertEquals( DiatonicDegree.II, d );
		assertEquals( DiatonicDegree.II, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.iii, ton ).toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.III, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.IV, ton ).toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.IV, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.V, ton ).toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.V, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.vi, ton ).toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.VI, dc.getDegree() );
		dc = new CustomChromaticChord( ChromaticFunction.VII0, ton ).toMidi().getDiatonicChordMidi( ton );
		assertEquals( DiatonicDegree.VII, dc.getDegree() );
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

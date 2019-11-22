package es.danisales.datune;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Tests {
	@Test
	public void diatonicAltToDiatonic() {
		DiatonicAlt c = DiatonicAlt.Cb;
		assertSame( Diatonic.C, Diatonic.from( c ) );
		assertSame( Diatonic.C, c.getDiatonic() );
	}

	@Test
	public void diatonicAltToChromatic() {
		assertEquals( Chromatic.C, Chromatic.from(DiatonicAlt.BB ) );
		assertEquals( Chromatic.G, Chromatic.from(DiatonicAlt.FFF ) );
		assertEquals( Chromatic.GG, Chromatic.from(DiatonicAlt.FFFF ) );
	}

	@Test
	public void chordFunction() {
		assertEquals( 0, DiatonicFunction.I.getDegree().ordinal() );
	}

	@Test
	public void whatIsItStatic() {
		Tonality s = Tonality.C;
		DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.I, 5, s );

		ChromaticChordMidi notes = ChromaticChordMidi.newEmpty();
		for ( DiatonicMidi n : c ) {
			ChromaticMidi chromaticMidi = ChromaticMidi.from(n);
			notes.add(chromaticMidi);
		}

		List<DiatonicChordMidi> chords = notes.toDiatonicChordMidi( false );
		assert ( chords.size() > 0 );
	}


	@Test
	public void dist() {
		ChromaticChordMidi notes = ChromaticChordMidi.of(
				Chromatic.FF, Chromatic.A, Chromatic.CC
		);

		assertEquals( PitchChromaticMidi.FF5, notes.get( 0 ).getPitch());

		List<Integer> n = notes.integerNotationFromRoot();

		assertArrayEquals(
				new Integer[] {
						0,
						3,
						7
				}, n.toArray()
		);
	}

	@Test
	public void getCode() {
		PitchChromaticMidi p = PitchChromaticMidi.from( 60 );
		assertEquals( PitchChromaticMidi.C5, p );
		p = PitchChromaticMidi.from( Chromatic.C, 5 );
		assertEquals( PitchChromaticMidi.C5, p );
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5 ).build();
		assertEquals( PitchChromaticMidi.C5, n.getPitch() );

		n = ChromaticMidi.builder().pitch(Chromatic.B, 5 ).build();
		assertEquals( PitchChromaticMidi.B5, n.getPitch() );

		DiatonicMidi n2 = DiatonicMidi.from( DiatonicDegree.I, Tonality.C, 5 );
		assertEquals( PitchChromaticMidi.C5, n2.getPitch() );
		n2 = DiatonicMidi.from( DiatonicDegree.VII, Tonality.C, 5 );
		assertEquals( PitchChromaticMidi.B5, n2.getPitch() );
	}
}

package es.danisales.datune;

import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
		PitchChromaticMidi p = PitchChromaticMidi.C5.getShift( 4 );
		assertEquals( PitchChromaticMidi.E5, p );
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
		PitchChromaticMidi p = PitchChromaticMidi.C5.getWithOctave( 4 );
		assertEquals( PitchChromaticMidi.C4, p );
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
		PitchChromaticMidi p = PitchChromaticMidi.C5.getWithShiftOctave( 1 );
		assertEquals( PitchChromaticMidi.C6, p );
		assertEquals( 60, PitchChromaticMidi.C5.getCode() );
	}

	@Test
	public void get() {
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchChromaticMidi.GG5.getOctave() );
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( Chromatic.GG, PitchChromaticMidi.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, ChromaticAdapter.from( PitchChromaticMidi.GG5 ) );
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( ChromaticAdapter.from( PitchChromaticMidi.GG5 ), 5 ) );
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( ChromaticAdapter.from( PitchChromaticMidi.GG5 ), PitchChromaticMidi.GG5.getOctave() ) );
		assertEquals( PitchChromaticMidi.GG5.getCode(), PitchChromaticMidi.GG5.getCode() );
	}
}

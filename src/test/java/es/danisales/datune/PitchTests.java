package es.danisales.datune;

import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, PitchMidi.C5.getCode() );
		PitchMidi p = PitchMidi.C5.shift( 4 );
		assertEquals( PitchMidi.E5, p );
		assertEquals( 60, PitchMidi.C5.getCode() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, PitchMidi.C5.getCode() );
		PitchMidi p = PitchMidi.C5.setOctave( 4 );
		assertEquals( PitchMidi.C4, p );
		assertEquals( 60, PitchMidi.C5.getCode() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, PitchMidi.C5.getCode() );
		PitchMidi p = PitchMidi.C5.shiftOctave( 1 );
		assertEquals( PitchMidi.C6, p );
		assertEquals( 60, PitchMidi.C5.getCode() );
	}

	@Test
	public void get() {
		assertEquals( PitchMidi.GG5, PitchMidi.from( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchMidi.GG5.getOctave() );
		assertEquals( PitchMidi.GG5, PitchMidi.from( Chromatic.GG, PitchMidi.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, ChromaticAdapter.from( PitchMidi.GG5 ) );
		assertEquals( PitchMidi.GG5, PitchMidi.from( ChromaticAdapter.from( PitchMidi.GG5 ), 5 ) );
		assertEquals( PitchMidi.GG5, PitchMidi.from( ChromaticAdapter.from( PitchMidi.GG5 ), PitchMidi.GG5.getOctave() ) );
		assertEquals( PitchMidi.GG5.getCode(), PitchMidi.GG5.getCode() );
	}
}

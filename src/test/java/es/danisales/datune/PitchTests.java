package es.danisales.datune;

import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
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
		assertEquals( PitchMidi.GG5, PitchMidi.of( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchMidi.GG5.getOctave() );
		assertEquals( PitchMidi.GG5, PitchMidi.of( Chromatic.GG, PitchMidi.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, PitchMidi.GG5.getChromatic() );
		assertEquals( PitchMidi.GG5, PitchMidi.of( PitchMidi.GG5.getChromatic(), 5 ) );
		assertEquals( PitchMidi.GG5, PitchMidi.of( PitchMidi.GG5.getChromatic(), PitchMidi.GG5.getOctave() ) );
		assertEquals( PitchMidi.GG5.getCode(), PitchMidi.GG5.getCode() );
	}
}

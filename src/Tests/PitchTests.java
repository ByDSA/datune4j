package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.PitchMidi;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, PitchMidi.C5.val() );
		PitchMidi p = PitchMidi.add( PitchMidi.C5, 4 );
		assertEquals( PitchMidi.E5, p );
		assertEquals( 60, PitchMidi.C5.val() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, PitchMidi.C5.val() );
		PitchMidi p = PitchMidi.C5.setOctave( 4 );
		assertEquals( PitchMidi.C4, p );
		assertEquals( 60, PitchMidi.C5.val() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, PitchMidi.C5.val() );
		PitchMidi p = PitchMidi.C5.shiftOctave( 1 );
		assertEquals( PitchMidi.C6, p );
		assertEquals( 60, PitchMidi.C5.val() );
	}

	@Test
	public void get() {
		assertEquals( PitchMidi.GG5, PitchMidi.get( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchMidi.GG5.getOctave() );
		assertEquals( PitchMidi.GG5, PitchMidi.get( Chromatic.GG, PitchMidi.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, PitchMidi.GG5.getChromatic() );
		assertEquals( PitchMidi.GG5, PitchMidi.get( PitchMidi.GG5.getChromatic(), 5 ) );
		assertEquals( PitchMidi.GG5, PitchMidi.get( PitchMidi.GG5.getChromatic(), PitchMidi.GG5.getOctave() ) );
		assertEquals( PitchMidi.GG5, PitchMidi.GG5.toMidi().getPitchCode() );
	}
}

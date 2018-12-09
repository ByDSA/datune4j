package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.ChromaticMidi;
import pitch.Pitch;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, Pitch.C5.val() );
		Pitch p = Pitch.add( Pitch.C5, 4 );
		assertEquals( Pitch.E5, p );
		assertEquals( 60, Pitch.C5.val() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, Pitch.C5.val() );
		Pitch p = Pitch.C5.setOctave( 4 );
		assertEquals( Pitch.C4, p );
		assertEquals( 60, Pitch.C5.val() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, Pitch.C5.val() );
		Pitch p = Pitch.C5.shiftOctave( 1 );
		assertEquals( Pitch.C6, p );
		assertEquals( 60, Pitch.C5.val() );
	}

	@Test
	public void get() {
		assertEquals( Pitch.GG5, Pitch.get( Chromatic.GG, 5 ) );
		assertEquals( 5, Pitch.GG5.getOctave() );
		assertEquals( Pitch.GG5, Pitch.get( Chromatic.GG, Pitch.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, Pitch.GG5.getChromatic() );
		assertEquals( Pitch.GG5, Pitch.get( Pitch.GG5.getChromatic(), 5 ) );
		assertEquals( Pitch.GG5, Pitch.get( Pitch.GG5.getChromatic(), Pitch.GG5.getOctave() ) );
		assertEquals( Pitch.GG5, Pitch.GG5.toMidi().getPitchCode() );
	}
}

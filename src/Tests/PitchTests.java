package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pitch.Chromatic;
import pitch.PitchMidiEnum;
import pitch.PitchMidiSingle;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
		PitchMidiEnum p = PitchMidiEnum.C5.addMidi( 4 );
		assertEquals( PitchMidiEnum.E5, p );
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
		PitchMidiEnum p = PitchMidiEnum.C5.setOctave( 4 );
		assertEquals( PitchMidiEnum.C4, p );
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
		PitchMidiEnum p = PitchMidiEnum.C5.shiftOctave( 1 );
		assertEquals( PitchMidiEnum.C6, p );
		assertEquals( 60, PitchMidiEnum.C5.getCode() );
	}

	@Test
	public void get() {
		assertEquals( PitchMidiEnum.GG5, PitchMidiSingle.of( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchMidiEnum.GG5.getOctave() );
		assertEquals( PitchMidiEnum.GG5, PitchMidiSingle.of( Chromatic.GG, PitchMidiEnum.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, PitchMidiEnum.GG5.getChromatic() );
		assertEquals( PitchMidiEnum.GG5, PitchMidiSingle.of( PitchMidiEnum.GG5.getChromatic(), 5 ) );
		assertEquals( PitchMidiEnum.GG5, PitchMidiSingle.of( PitchMidiEnum.GG5.getChromatic(), PitchMidiEnum.GG5.getOctave() ) );
		assertEquals( PitchMidiEnum.GG5, PitchMidiEnum.GG5.toMidi().getCode() );
	}
}

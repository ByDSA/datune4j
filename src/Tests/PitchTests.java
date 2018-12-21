package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import musical.Chromatic;
import pitch.NoteMidi;

public class PitchTests {
	@Test
	public void add() {
		assertEquals( 60, NoteMidi.C5.getCode() );
		NoteMidi p = NoteMidi.C5.shift( 4 );
		assertEquals( NoteMidi.E5, p );
		assertEquals( 60, NoteMidi.C5.getCode() );
	}

	@Test
	public void setOctave() {
		assertEquals( 60, NoteMidi.C5.getCode() );
		NoteMidi p = NoteMidi.C5.setOctave( 4 );
		assertEquals( NoteMidi.C4, p );
		assertEquals( 60, NoteMidi.C5.getCode() );
	}

	@Test
	public void shiftOctave() {
		assertEquals( 60, NoteMidi.C5.getCode() );
		NoteMidi p = NoteMidi.C5.shiftOctave( 1 );
		assertEquals( NoteMidi.C6, p );
		assertEquals( 60, NoteMidi.C5.getCode() );
	}

	@Test
	public void get() {
		assertEquals( NoteMidi.GG5, NoteMidi.of( Chromatic.GG, 5 ) );
		assertEquals( 5, NoteMidi.GG5.getOctave() );
		assertEquals( NoteMidi.GG5, NoteMidi.of( Chromatic.GG, NoteMidi.GG5.getOctave() ) );
		assertEquals( Chromatic.GG, NoteMidi.GG5.getChromatic() );
		assertEquals( NoteMidi.GG5, NoteMidi.of( NoteMidi.GG5.getChromatic(), 5 ) );
		assertEquals( NoteMidi.GG5, NoteMidi.of( NoteMidi.GG5.getChromatic(), NoteMidi.GG5.getOctave() ) );
		assertEquals( NoteMidi.GG5.getCode(), NoteMidi.GG5.toMidi().getCode() );
	}
}

package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PitchTests {
	@Test
	public void shift() throws PitchMidiException {
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
		PitchChromaticMidi p = PitchChromaticMidi.C5.clone();
		p.shift(IntervalChromatic.MAJOR_THIRD);
		assertEquals( PitchChromaticMidi.E5, p );
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
	}

	@Test
	public void setOctave() throws PitchMidiException {
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
		PitchChromaticMidi p = PitchChromaticMidi.C5.clone();
		p.setOctave(4);
		assertEquals( PitchChromaticMidi.C4, p );
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
	}

	@Test
	public void shiftOctave() throws PitchMidiException {
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
		PitchChromaticMidi p = PitchChromaticMidi.C5.clone();
		p.shiftOctave(1);
		assertEquals( PitchChromaticMidi.C6, p );
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
	}

	@Test
	public void get() throws PitchMidiException {
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( Chromatic.GG, 5 ) );
		assertEquals( 5, PitchChromaticMidi.GG5.getOctave() );
		assertEquals( PitchChromaticMidi.GG5, PitchChromaticMidi.from( Chromatic.GG, PitchChromaticMidi.GG5.getOctave() ) );
		assertEquals(Chromatic.GG, PitchChromaticMidi.GG5.getChromatic());
		assertEquals(PitchChromaticMidi.GG5, PitchChromaticMidi.from(PitchChromaticMidi.GG5.getChromatic(), 5));
		assertEquals(PitchChromaticMidi.GG5, PitchChromaticMidi.from(PitchChromaticMidi.GG5.getChromatic(), PitchChromaticMidi.GG5.getOctave()));
        assertEquals(PitchChromaticMidi.GG5.getMidiCode(), PitchChromaticMidi.GG5.getMidiCode());
	}
}

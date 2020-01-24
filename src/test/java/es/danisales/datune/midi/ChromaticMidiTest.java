package es.danisales.datune.midi;

import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChromaticMidiTest {
	@Test
	public void builder() {
		NoteMidi chromaticMidi = NoteMidi.builder()
				.pitch(Settings.DefaultValues.PITCH_CHROMATIC_MIDI)
				.build();

		assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
		assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
		assertEquals(Settings.DefaultValues.PITCH_CHROMATIC_MIDI, chromaticMidi.getPitch());
	}

	@Test
	public void privateConstructor() {
		NoteMidi chromaticMidi = new NoteMidi();
		assertNull(chromaticMidi.pitch);
		assertEquals(0, chromaticMidi.velocity);
		assertEquals(0, chromaticMidi.length);
	}

	@Test
	public void cloneTest() {
		NoteMidi chromaticMidi = NoteMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();
		NoteMidi clonedChromaticMidi1 = chromaticMidi.clone();

		assertEquals(chromaticMidi, clonedChromaticMidi1);
	}

	@Test
	public void equals() {
		NoteMidi builtChromaticMidi = NoteMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		NoteMidi builtChromaticMidi2 = NoteMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		assertEquals(builtChromaticMidi, builtChromaticMidi2);
	}

	@Test
	public void toStringTest() throws PitchMidiException {
		NoteMidi chromaticMidi = NoteMidi.builder()
				.pitch(60)
				.build();

		assertEquals("C5 (vel=127, length=960)", chromaticMidi.toString());
	}

	@Test
	public void hashCodeTest() throws PitchMidiException {
		NoteMidi chromaticMidi = NoteMidi.builder()
				.pitch(60)
				.build();
		NoteMidi clonedChromaticMidi = chromaticMidi.clone();

		assertEquals(chromaticMidi, clonedChromaticMidi);
		assertEquals(chromaticMidi.hashCode(), clonedChromaticMidi.hashCode());
	}
}

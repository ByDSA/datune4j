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
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(Settings.DefaultValues.PITCH_CHROMATIC_MIDI)
				.build();

		assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
		assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
		assertEquals(Settings.DefaultValues.PITCH_CHROMATIC_MIDI, chromaticMidi.getPitch());
	}

	@Test
	public void fromDiatonicMidi() throws PitchMidiException {
		DiatonicMidi diatonicMidi = DiatonicMidi.builder()
				.pitch(PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5))
				.length(DurationMidi.L16)
				.velocity(32)
				.build();

		ChromaticMidi chromaticMidi = ChromaticMidi.from(diatonicMidi);

		assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
		assertEquals(DurationMidi.L16, chromaticMidi.getLength());
		assertEquals(32, chromaticMidi.getVelocity());
	}

	@Test
	public void privateConstructor() {
		ChromaticMidi chromaticMidi = new ChromaticMidi();
		assertNull(chromaticMidi.pitch);
		assertEquals(0, chromaticMidi.velocity);
		assertEquals(0, chromaticMidi.length);
	}

	@Test
	public void cloneTest() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();
		ChromaticMidi clonedChromaticMidi1 = chromaticMidi.clone();

		assertEquals(chromaticMidi, clonedChromaticMidi1);
	}

	@Test
	public void equals() {
		ChromaticMidi builtChromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		ChromaticMidi builtChromaticMidi2 = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		assertEquals(builtChromaticMidi, builtChromaticMidi2);
	}

	@Test
	public void toStringTest() throws PitchMidiException {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(60)
				.build();

		assertEquals("C5 (vel=127, length=960)", chromaticMidi.toString());
	}

	@Test
	public void hashCodeTest() throws PitchMidiException {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(60)
				.build();
		ChromaticMidi clonedChromaticMidi = chromaticMidi.clone();

		assertEquals(chromaticMidi, clonedChromaticMidi);
		assertEquals(chromaticMidi.hashCode(), clonedChromaticMidi.hashCode());
	}
}

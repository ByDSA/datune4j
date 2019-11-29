package es.danisales.datune.midi;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static junit.framework.TestCase.fail;
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
				.length(Duration.L16)
				.velocity(32)
				.build();

		ChromaticMidi chromaticMidi = ChromaticMidi.from(diatonicMidi);

		assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
		assertEquals(Duration.L16, chromaticMidi.getLength());
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
	public void distTo() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();
		ChromaticMidi chromaticMidi2 = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C6)
				.build();

		assertEquals(12, chromaticMidi.distTo(chromaticMidi2));
		assertEquals(-12, chromaticMidi2.distTo(chromaticMidi));
	}

	@Test
	public void distToItself() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();
		ChromaticMidi chromaticMidi2 = chromaticMidi.clone();

		assertEquals(0, chromaticMidi.distTo(chromaticMidi2));
		assertEquals(0, chromaticMidi2.distTo(chromaticMidi));
	}

	@Test
	public void getEvents() {
		fail();
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

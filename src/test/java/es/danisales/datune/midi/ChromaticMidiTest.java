package es.danisales.datune.midi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChromaticMidiTest {
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
	public void equals() {
		ChromaticMidi builtChromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		ChromaticMidi builtChromaticMidi2 = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		assertEquals(builtChromaticMidi, builtChromaticMidi2);
	}
}

package es.danisales.datune.midi;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChromaticMidiTest {
	@Test
	public void builder() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.length(Duration.V1)
				.velocity(64)
				.build();

		assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
		assertEquals(64, chromaticMidi.getVelocity());
		assertEquals(Duration.V1, chromaticMidi.getLength());
	}

	@Test
	public void builderPitch() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
		assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
		assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
	}

	@Test
	public void builderWithoutParams() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.build();

		assertEquals(Settings.DefaultValues.PITCH_CHROMATIC_MIDI, chromaticMidi.getPitch());
		assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
		assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
	}

	@Test
	public void packageConstructor() {
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
		ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build();
		ChromaticMidi chromaticMidi2 = ChromaticMidi.builder().pitch(PitchChromaticMidi.C6).build();

		assertEquals(12, chromaticMidi.distTo(chromaticMidi2));
		assertEquals(-12, chromaticMidi2.distTo(chromaticMidi));
	}

	@Test
	public void distToItself() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build();
		ChromaticMidi chromaticMidi2 = chromaticMidi.clone();

		assertEquals(0, chromaticMidi.distTo(chromaticMidi2));
		assertEquals(0, chromaticMidi2.distTo(chromaticMidi));
	}

	@Test
	public void shift() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder().pitch(60).build();
		chromaticMidi.shift(IntervalChromatic.PERFECT_UNISON);
		assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch() );
		chromaticMidi.shift(IntervalChromatic.PERFECT_OCTAVE);
		assertEquals(PitchChromaticMidi.C6, chromaticMidi.getPitch() );
	}

	@Test
	public void noteConstructor() {
		ChromaticMidi n = ChromaticMidi.builder().pitch(Chromatic.C, 5).build();

		assertEquals( PitchChromaticMidi.C5.getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getPitch().getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(5), 5).build();

		assertEquals( PitchChromaticMidi.from( 60 + 5 ).getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getPitch().getOctave() );

		n = ChromaticMidi.builder().pitch(Chromatic.C.addSemi(12), 5).build();

		assertEquals( PitchChromaticMidi.C5.getCode(), n.getPitch().getCode() );
		assertEquals( 5, n.getPitch().getOctave() );
	}

	@Test
	public void toDiatonic() {
		ChromaticMidi cm = ChromaticMidi.builder().pitch(Chromatic.F).build();
		DiatonicMidi dm = DiatonicMidi.builder().fromChromatic(cm, Tonality.C).build();
		Chromatic chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.F, chromaticDm);
		cm = ChromaticMidi.builder().pitch(Chromatic.C).build();
		dm = DiatonicMidi.builder().fromChromatic(cm, Tonality.C).build();
		chromaticDm = Chromatic.from(dm);
		assertEquals(Chromatic.C, chromaticDm);
	}

	@Test
	public void equals() {
		ChromaticMidi chromaticMidi = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		ChromaticMidi chromaticMidi2 = ChromaticMidi.builder()
				.pitch(PitchChromaticMidi.C5)
				.build();

		assertEquals(chromaticMidi, chromaticMidi2);
	}

	@Test
	public void fromBuilderChromaticAndOctave() {
		ChromaticMidi n = ChromaticMidi.builder()
				.pitch(Chromatic.C, 5 )
				.build();

		assertEquals( PitchChromaticMidi.C5, n.getPitch() );
	}
}

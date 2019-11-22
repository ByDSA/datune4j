package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChromaticMidiBuilderTest {
    @Test
    public void fromChromaticAndOctave() {
        ChromaticMidi n = ChromaticMidi.builder()
                .pitch(Chromatic.C, 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());
    }

    @Test
    public void pitchChromaticOctave() {
        ChromaticMidi n = ChromaticMidi.builder()
                .pitch(Chromatic.C, 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());

        n = ChromaticMidi.builder()
                .pitch(Chromatic.C.addSemi(5), 5)
                .build();

        assertEquals(PitchChromaticMidi.from(60 + 5), n.getPitch());
        assertEquals(5, n.getPitch().getOctave());

        n = ChromaticMidi.builder()
                .pitch(Chromatic.C.addSemi(12), 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());
    }

    @Test
    public void all() {
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
    public void pitch() {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();

        assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
        assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
        assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
    }

    @Test
    public void withoutParams() {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .build();

        assertEquals(Settings.DefaultValues.PITCH_CHROMATIC_MIDI, chromaticMidi.getPitch());
        assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
        assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
    }

}
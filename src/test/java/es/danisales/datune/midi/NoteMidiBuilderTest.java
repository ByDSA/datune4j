package es.danisales.datune.midi;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoteMidiBuilderTest {
    @Test
    public void fromChromaticAndOctave() throws PitchMidiException {
        NoteMidi n = NoteMidi.builder()
                .pitch(Chromatic.C, 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());
    }

    @Test
    public void pitchChromaticOctave() throws PitchMidiException {
        NoteMidi n = NoteMidi.builder()
                .pitch(Chromatic.C, 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());

        n = NoteMidi.builder()
                .pitch(Chromatic.C.getNext(5), 5)
                .build();

        assertEquals(PitchChromaticMidi.from(60 + 5), n.getPitch());
        assertEquals(5, n.getPitch().getOctave());

        n = NoteMidi.builder()
                .pitch(Chromatic.C.getNext(12), 5)
                .build();

        assertEquals(PitchChromaticMidi.C5, n.getPitch());
    }

    @Test
    public void all() {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .length(DurationMidi.L1)
                .velocity(64)
                .build();

        assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
        assertEquals(64, chromaticMidi.getVelocity());
        assertEquals(DurationMidi.L1, chromaticMidi.getLength());
    }

    @Test
    public void pitch() {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();

        assertEquals(PitchChromaticMidi.C5, chromaticMidi.getPitch());
        assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
        assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
    }

    @Test
    public void withoutParams() {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .build();

        assertEquals(Settings.DefaultValues.PITCH_CHROMATIC_MIDI, chromaticMidi.getPitch());
        assertEquals(Settings.DefaultValues.VELOCITY, chromaticMidi.getVelocity());
        assertEquals(Settings.DefaultValues.LENGTH_NOTE, chromaticMidi.getLength());
    }

}
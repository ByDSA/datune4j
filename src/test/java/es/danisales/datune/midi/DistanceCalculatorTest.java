package es.danisales.datune.midi;

import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {
    @Test
    public void calculateDistanceInSemitonesChromaticMidi() {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();
        NoteMidi chromaticMidi2 = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C6)
                .build();

        assertEquals(12, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi, chromaticMidi2));
        assertEquals(-12, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi2, chromaticMidi));
    }

    @Test
    public void calculateDistanceInSemitonesChromaticMidiToItself() {
        NoteMidi chromaticMidi = NoteMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();
        NoteMidi chromaticMidi2 = chromaticMidi.clone();

        assertEquals(0, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi, chromaticMidi2));
        assertEquals(0, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi2, chromaticMidi));
    }
}
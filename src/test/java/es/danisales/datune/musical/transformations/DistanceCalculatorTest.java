package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {
    @Test
    public void calculateDistanceInSemitonesChromaticMidi() {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();
        ChromaticMidi chromaticMidi2 = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C6)
                .build();

        assertEquals(12, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi, chromaticMidi2));
        assertEquals(-12, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi2, chromaticMidi));
    }

    @Test
    public void calculateDistanceInSemitonesChromaticMidiToItself() {
        ChromaticMidi chromaticMidi = ChromaticMidi.builder()
                .pitch(PitchChromaticMidi.C5)
                .build();
        ChromaticMidi chromaticMidi2 = chromaticMidi.clone();

        assertEquals(0, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi, chromaticMidi2));
        assertEquals(0, DistanceCalculator.calculateDistanceInSemitones(chromaticMidi2, chromaticMidi));
    }
}
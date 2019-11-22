package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PitchDiatonicMidiTest {
    @Test
    public void fromTonalityOctave() {
        PitchDiatonicMidi pitchMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);
        assertEquals(PitchChromaticMidi.C5, pitchChromaticMidi);

        pitchMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 5);
        pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);
        assertEquals(PitchChromaticMidi.C6, pitchChromaticMidi);

        pitchMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 10);
        pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);
        assertEquals(PitchChromaticMidi.C10, pitchChromaticMidi);

        pitchMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, -1);
        pitchChromaticMidi = PitchChromaticMidi.from(pitchMidi);
        assertEquals(PitchChromaticMidi.C0, pitchChromaticMidi);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid() {
        PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, 10);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid2() {
        PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, -1);
    }

}
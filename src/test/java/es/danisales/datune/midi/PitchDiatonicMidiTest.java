package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void fromTonalityOctaveInvalid() {
        assertNull(PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, 10));
    }

    @Test
    public void fromTonalityOctaveInvalid2() {
        assertNull(PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, -1));
    }

    @Test
    public void fromPitchChromaticMidi() {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, Tonality.C);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional() {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi2() {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 4);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, Tonality.Am);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional2() {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi3() {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 4);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional3() {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }


    @Test
    public void fromPitchChromaticMidi4() {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.A4;

        Tonality tonality = Tonality.from(DiatonicAlt.Cbbb, Scale.MINOR);

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 5);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional4() {
        Tonality tonality = Tonality.from(DiatonicAlt.Cbbb, Scale.MINOR);

        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.A4;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }
}
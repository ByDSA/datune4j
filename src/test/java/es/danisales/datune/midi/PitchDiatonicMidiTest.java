package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class PitchDiatonicMidiTest {
    @Test
    public void from() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(DiatonicDegree.I, pitchDiatonicMidi.getDegree());
        assertEquals(Tonality.C, pitchDiatonicMidi.getTonality());
        assertEquals(5, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void from2() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(DiatonicDegree.III, pitchDiatonicMidi.getDegree());
        assertEquals(Tonality.Am, pitchDiatonicMidi.getTonality());
        assertEquals(5, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void from3() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 10);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(PitchChromaticMidi.C10.getMidiCode(), pitchDiatonicMidi.getMidiCode());
    }

    @Test
    public void from4() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, -1);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(PitchChromaticMidi.C0.getMidiCode(), pitchDiatonicMidi.getMidiCode());
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid() throws PitchMidiException {
        PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, 10);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid2() throws PitchMidiException {
        PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.C, -1);
    }

    @Test
    public void fromPitchChromaticMidi() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, Tonality.C);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi2() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 4);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, Tonality.Am);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional2() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.III, Tonality.Am, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi3() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 4);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional3() throws PitchMidiException {
        Tonality tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }


    @Test
    public void fromPitchChromaticMidi4() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.A4;

        Tonality tonality = Tonality.from(DiatonicAlt.Cbbb, Scale.MINOR);

        PitchDiatonicMidi pitchDiatonicMidiExpected = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 5);
        PitchDiatonicMidi pitchDiatonicMidiActual = PitchDiatonicMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void fromPitchChromaticMidiBidirectional4() throws PitchMidiException {
        Tonality tonality = Tonality.from(DiatonicAlt.Cbbb, Scale.MINOR);

        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.A4;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    private void _shiftNegative(PitchChromaticMidi pirchChromaticMidi, IntervalDiatonic intervalDiatonic) throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.V, Tonality.E, 6);
        assertNotNull(pitchDiatonicMidi);
        pitchDiatonicMidi.shiftNegative(intervalDiatonic);
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(pitchDiatonicMidi);
        assertEquals(pirchChromaticMidi, pitchChromaticMidi);
    }

    @Test
    public void shiftNegative() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.B6, IntervalDiatonic.UNISON);
    }

    @Test
    public void shiftNegative2() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.A6, IntervalDiatonic.SECOND);
    }

    @Test
    public void shiftNegative3() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.GG6, IntervalDiatonic.THIRD);
    }

    @Test
    public void shiftNegative4() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.FF6, IntervalDiatonic.FOURTH);
    }

    @Test
    public void shiftNegative5() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.E6, IntervalDiatonic.FIFTH);
    }

    @Test
    public void shiftNegative6() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.DD6, IntervalDiatonic.SIXTH);
    }

    @Test
    public void shiftNegative7() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.CC6, IntervalDiatonic.SEVENTH);
    }

    @Test
    public void shiftNegative8() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.B5, IntervalDiatonic.OCTAVE);
    }

    @Test
    public void shiftNegative9() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.A5, IntervalDiatonic.NINTH);
    }

    @Test
    public void shiftNegative10() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.GG5, IntervalDiatonic.TENTH);
    }

    @Test
    public void shiftNegative11() throws PitchMidiException {
        _shiftNegative(PitchChromaticMidi.FF5, IntervalDiatonic.ELEVENTH);
    }

    private void _shift(int code, IntervalDiatonic intervalDiatonic) throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MIXOLYDIAN);
        PitchDiatonicMidi diatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, tonality, 3);
        assertNotNull(diatonicMidi);
        diatonicMidi.shift(intervalDiatonic);
        assertEquals(code, diatonicMidi.getMidiCode());
    }

    @Test
    public void shift() throws PitchMidiException {
        _shift(42, IntervalDiatonic.UNISON);
    }

    @Test
    public void shift2() throws PitchMidiException {
        _shift(46, IntervalDiatonic.THIRD);
    }

    @Test
    public void shift3() throws PitchMidiException {
        _shift(49, IntervalDiatonic.FIFTH);
    }

    @Test
    public void shift4() throws PitchMidiException {
        _shift(52, IntervalDiatonic.SEVENTH);
    }

    @Test
    public void shiftPos() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.Gm, 5);
        assertNotNull(pitchDiatonicMidi);

        pitchDiatonicMidi.shift(2);
        assertEquals(DiatonicDegree.I, pitchDiatonicMidi.degree);
        assertEquals(6, pitchDiatonicMidi.octave);
    }

    @Test
    public void getMidiCode() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.C, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(60, pitchDiatonicMidi.getMidiCode());
    }

    @Test
    public void getMidiCode2() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.VI, Tonality.Gm, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(75, pitchDiatonicMidi.getMidiCode());
    }
}
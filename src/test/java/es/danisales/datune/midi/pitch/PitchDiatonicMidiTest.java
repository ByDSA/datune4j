package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class PitchDiatonicMidiTest {
    @Test
    public void from() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, TonalityModern.C, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(DiatonicDegree.I, pitchDiatonicMidi.getDegree());
        assertEquals(TonalityModern.C, pitchDiatonicMidi.getTonality());
        assertEquals(5, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void from2() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.III, TonalityModern.Am, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(DiatonicDegree.III, pitchDiatonicMidi.getDegree());
        assertEquals(TonalityModern.Am, pitchDiatonicMidi.getTonality());
        assertEquals(5, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void from3() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, TonalityModern.C, 10);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(PitchChromaticMidi.C10.getMidiCode(), pitchDiatonicMidi.getMidiCode());
    }

    @Test
    public void from4() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.III, TonalityModern.Am, -1);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(PitchChromaticMidi.C0.getMidiCode(), pitchDiatonicMidi.getMidiCode());
    }

    @Test
    public void from5() throws TonalityException {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.Cb, Scale.MAJOR);
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(PitchChromaticMidi.FF6, tonality);
        assertEquals(DiatonicDegree.V, pitchDiatonicMidi.getDegree());
        assertEquals(TonalityModern.B, pitchDiatonicMidi.getTonality());
        assertEquals(5, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void from5Bidirectional() throws TonalityException {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.Cb, Scale.MAJOR);
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(PitchChromaticMidi.FF6, tonality);

        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(pitchDiatonicMidi);
        assertEquals(PitchChromaticMidi.FF6, pitchChromaticMidi);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid() throws PitchMidiException {
        PitchTonalMidi.from(DiatonicDegree.VI, TonalityModern.C, 10);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid2() throws PitchMidiException {
        PitchTonalMidi.from(DiatonicDegree.VI, TonalityModern.C, -1);
    }

    @Test
    public void fromPitchChromaticMidi() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.I, TonalityModern.C, 5);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, TonalityModern.C);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, TonalityModern.C, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi2() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.III, TonalityModern.Am, 4);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, TonalityModern.Am);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional2() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.III, TonalityModern.Am, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi3() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5;

        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.I, tonality, 4);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional3() throws PitchMidiException {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.BB, Scale.MAJOR);

        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, tonality, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.C5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }


    @Test
    public void fromPitchChromaticMidi4() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.A4;

        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.from(Diatonic.C, -3), Scale.MINOR);

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.I, tonality, 5);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, tonality);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional4() throws PitchMidiException {
        Tonality<DiatonicAlt> tonality = Tonality.from(DiatonicAlt.from(Diatonic.C, -3), Scale.MINOR);

        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, tonality, 5);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.A4;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi5() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.B4;

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.II, TonalityModern.Am, 4);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, TonalityModern.Am);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional5() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.II, TonalityModern.Am, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.B4;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }

    @Test
    public void fromPitchChromaticMidi6() throws PitchMidiException, TonalityException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.D5;

        PitchTonalMidi pitchDiatonicMidiExpected = PitchTonalMidi.from(DiatonicDegree.IV, TonalityModern.Am, 4);
        PitchTonalMidi pitchDiatonicMidiActual = PitchTonalMidi.from(pitchChromaticMidi, TonalityModern.Am);

        assertEquals(pitchDiatonicMidiExpected, pitchDiatonicMidiActual);
    }

    @Test
    public void fromPitchChromaticMidiBidirectional6() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.IV, TonalityModern.Am, 4);

        PitchChromaticMidi pitchChromaticMidiExpected = PitchChromaticMidi.D5;
        PitchChromaticMidi pitchChromaticMidiActual = PitchChromaticMidi.from(pitchDiatonicMidi);

        assertEquals(pitchChromaticMidiExpected, pitchChromaticMidiActual);
    }


    private void _shiftNegative(PitchChromaticMidi pirchChromaticMidi, IntervalDiatonic intervalDiatonic) throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.V, TonalityModern.E, 6);
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
        Tonality<Chromatic> tonality = Tonality.from(Chromatic.FF, Scale.MIXOLYDIAN);
        PitchTonalMidi diatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, tonality, 3);
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
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.VI, TonalityModern.Gm, 5);
        assertNotNull(pitchDiatonicMidi);

        pitchDiatonicMidi.shift(2);
        assertEquals(DiatonicDegree.I, pitchDiatonicMidi.getDegree());
        assertEquals(6, pitchDiatonicMidi.getOctave());
    }

    @Test
    public void getMidiCode() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.I, TonalityModern.C, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(60, pitchDiatonicMidi.getMidiCode());
    }

    @Test
    public void getMidiCode2() throws PitchMidiException {
        PitchTonalMidi pitchDiatonicMidi = PitchTonalMidi.from(DiatonicDegree.VI, TonalityModern.Gm, 5);
        assertNotNull(pitchDiatonicMidi);
        assertEquals(75, pitchDiatonicMidi.getMidiCode());
    }
}
package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class PitchChromaticMidiTest {
    @Test
    public void getChromatic() {
        assertSame( Chromatic.C, PitchChromaticMidi.C5.getNote() );
        assertSame( Chromatic.B, PitchChromaticMidi.B7.getNote() );
    }

    @Test
    public void shiftOctave() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.shiftOctave(1);
        assertEquals(PitchChromaticMidi.C6, pitchChromaticMidi);

        pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.shiftOctave(-1);
        assertEquals(PitchChromaticMidi.C4, pitchChromaticMidi);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shiftOctaveFixed() throws PitchMidiException {
        PitchChromaticMidi.C5.shiftOctave(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shiftOctaveFixed2() throws PitchMidiException {
        PitchChromaticMidi.C5.shiftOctave(-1);
    }

    @Test(expected = PitchMidiException.class)
    public void shiftOctaveInvalid() throws PitchMidiException {
        PitchChromaticMidi.C10.clone().shiftOctave(1);
    }

    @Test(expected = PitchMidiException.class)
    public void shiftOctaveInvalid2() throws PitchMidiException {
        PitchChromaticMidi.C0.clone().shiftOctave(-1);
    }

    @Test
    public void setOctave() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.setOctave(10);
        assertEquals(PitchChromaticMidi.C10, pitchChromaticMidi);

        pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.setOctave(0);
        assertEquals(PitchChromaticMidi.C0, pitchChromaticMidi);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setOctaveFixed() throws PitchMidiException {
        PitchChromaticMidi.C5.setOctave(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setOctave2Fixed() throws PitchMidiException {
        PitchChromaticMidi.A5.setOctave(9);
    }

    @Test(expected = PitchMidiException.class)
    public void setOctaveInvalid() throws PitchMidiException {
        PitchChromaticMidi.C5.clone().setOctave(-1);
    }

    @Test(expected = PitchMidiException.class)
    public void setOctaveInvalid2() throws PitchMidiException {
        PitchChromaticMidi.A5.clone().setOctave(10);
    }

    @Test
    public void getCodeLimits() {
        assertEquals(0, PitchChromaticMidi.MIN.getMidiCode());
        assertEquals(127, PitchChromaticMidi.MAX.getMidiCode());
    }

    @Test
    public void getCode() {
        assertEquals(60, PitchChromaticMidi.C5.getMidiCode());
        assertEquals(72, PitchChromaticMidi.C6.getMidiCode());
    }

    @Test
    public void equals() throws PitchMidiException {
        PitchChromaticMidi pitchMidi = PitchChromaticMidi.from( Chromatic.C, 0 );
        assertEquals( PitchChromaticMidi.MIN, pitchMidi );

        pitchMidi = PitchChromaticMidi.from( Chromatic.G, 10 );
        assertEquals(  PitchChromaticMidi.MAX, pitchMidi );
    }

    @Test
    public void getOctave() {
        assertEquals(5, PitchChromaticMidi.C5.getOctave());
        assertEquals(6, PitchChromaticMidi.C6.getOctave());
        assertEquals(PitchChromaticMidi.MIN_OCTAVE, PitchChromaticMidi.MIN.getOctave());
        assertEquals(PitchChromaticMidi.MAX_OCTAVE, PitchChromaticMidi.MAX.getOctave());
    }

    @Test
    public void fromCode() throws PitchMidiException {
        assertEquals(PitchChromaticMidi.C5, PitchChromaticMidi.from(60));
        assertEquals(PitchChromaticMidi.MIN, PitchChromaticMidi.from(0));
        assertEquals(PitchChromaticMidi.MAX, PitchChromaticMidi.from(127));
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid() throws PitchMidiException {
        PitchChromaticMidi.from(600);
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid2() throws PitchMidiException {
        PitchChromaticMidi.from(-1);
    }

    @Test
    public void getShift() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.B4.clone();
        pitchChromaticMidi.shift(IntervalChromatic.MINOR_NINTH);
        assertEquals(PitchChromaticMidi.C6, pitchChromaticMidi);

        pitchChromaticMidi = PitchChromaticMidi.C6.clone();
        pitchChromaticMidi.shiftNegative(IntervalChromatic.MINOR_NINTH);
        assertEquals(PitchChromaticMidi.B4, pitchChromaticMidi);
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C0.clone();
        pitchChromaticMidi.shiftNegative(IntervalChromatic.MINOR_SECOND);
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid2() throws PitchMidiException {
        PitchChromaticMidi.G10.clone().shift(IntervalChromatic.MINOR_SECOND);
    }

    @Test
    public void next() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.next();
        assertEquals(PitchChromaticMidi.CC5, pitchChromaticMidi);
    }

    @Test
    public void next2() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.B4.clone();
        pitchChromaticMidi.next();
        assertEquals(PitchChromaticMidi.C5, pitchChromaticMidi);
    }

    @Test
    public void previous() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.CC5.clone();
        pitchChromaticMidi.previous();
        assertEquals(PitchChromaticMidi.C5, pitchChromaticMidi);
    }

    @Test
    public void previous2() throws PitchMidiException {
        PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.C5.clone();
        pitchChromaticMidi.previous();
        assertEquals(PitchChromaticMidi.B4, pitchChromaticMidi);
    }

    @Test(expected = PitchMidiException.class)
    public void previousFails() throws PitchMidiException {
        PitchChromaticMidi.MIN.clone().previous();
    }

    @Test
    public void limits() throws PitchMidiException {
        PitchChromaticMidi pitchMidi = PitchChromaticMidi.from( Chromatic.C, 0 );
        assertEquals( PitchChromaticMidi.MIN, pitchMidi );

        pitchMidi = PitchChromaticMidi.from( Chromatic.G, 10 );
        assertEquals(  PitchChromaticMidi.MAX, pitchMidi );
    }

    @Test
    public void fromChromaticAndOctave() throws PitchMidiException {
        PitchChromaticMidi p = PitchChromaticMidi.from( Chromatic.C, 5 );
        assertEquals( PitchChromaticMidi.C5, p );
    }
}
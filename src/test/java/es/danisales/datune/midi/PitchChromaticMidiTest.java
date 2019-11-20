package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class PitchChromaticMidiTest {
    @Test
    public void getChromatic() {
        assertSame( Chromatic.C, PitchChromaticMidi.C5.getChromatic() );
        assertSame( Chromatic.B, PitchChromaticMidi.B7.getChromatic() );
    }

    @Test
    public void getWithShiftOctave() {
        assertSame( PitchChromaticMidi.C6, PitchChromaticMidi.C5.getWithShiftOctave(1) );
        assertSame( PitchChromaticMidi.C4, PitchChromaticMidi.C5.getWithShiftOctave(-1) );
    }

    @Test(expected = PitchMidiException.class)
    public void getWithShiftOctaveInvalid() {
        PitchChromaticMidi.C10.getWithShiftOctave(1);
    }

    @Test(expected = PitchMidiException.class)
    public void getWithShiftOctaveInvalid2() {
        PitchChromaticMidi.C0.getWithShiftOctave(-1);
    }

    @Test
    public void getWithOctave() {
        assertEquals( PitchChromaticMidi.C10, PitchChromaticMidi.C5.getWithOctave(10) );
        assertEquals( PitchChromaticMidi.C0, PitchChromaticMidi.C5.getWithOctave(0) );
    }

    @Test(expected = PitchMidiException.class)
    public void getWithOctaveInvalid() {
        PitchChromaticMidi.C5.getWithOctave(-1);
    }

    @Test(expected = PitchMidiException.class)
    public void getWithOctaveInvalid2() {
        PitchChromaticMidi.A5.getWithOctave(10);
    }

    @Test
    public void getCodeLimits() {
        assertEquals(0, PitchChromaticMidi.MIN.getCode());
        assertEquals(127, PitchChromaticMidi.MAX.getCode());
    }

    @Test
    public void getCode() {
        assertEquals(60, PitchChromaticMidi.C5.getCode());
        assertEquals(72, PitchChromaticMidi.C6.getCode());
    }

    @Test
    public void equals() {
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
    public void fromCode() {
        assertSame( PitchChromaticMidi.C5, PitchChromaticMidi.from(60) );
        assertSame( PitchChromaticMidi.MIN, PitchChromaticMidi.from(0) );
        assertSame( PitchChromaticMidi.MAX, PitchChromaticMidi.from(127) );
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid() {
        PitchChromaticMidi.from(600);
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid2() {
        PitchChromaticMidi.from(-1);
    }

    @Test
    public void getShift() {
        assertSame( PitchChromaticMidi.C6, PitchChromaticMidi.B4.getShift(13) );
        assertSame( PitchChromaticMidi.B4, PitchChromaticMidi.C6.getShift(-13) );
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid() {
        PitchChromaticMidi.B4.getShift(-130);
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid2() {
        PitchChromaticMidi.B4.getShift(130);
    }

    @Test
    public void getDegree() {
    }

    @Test
    public void getNext() {
        assertSame( PitchChromaticMidi.CC5, PitchChromaticMidi.C5.getNext() );
    }

    @Test
    public void getNext2() {
        assertSame( PitchChromaticMidi.C5, PitchChromaticMidi.B4.getNext() );
    }

    @Test
    public void getPrevious() {
        assertSame( PitchChromaticMidi.C5, PitchChromaticMidi.CC5.getPrevious() );
    }

    @Test
    public void getPrevious2() {
        assertSame( PitchChromaticMidi.B4, PitchChromaticMidi.C5.getPrevious() );
    }

    @Test(expected = PitchMidiException.class)
    public void getPreviousFails() {
        PitchChromaticMidi.MIN.getPrevious();
    }

    @Test
    public void limits() {
        PitchChromaticMidi pitchMidi = PitchChromaticMidi.from( Chromatic.C, 0 );
        assertEquals( PitchChromaticMidi.MIN, pitchMidi );

        pitchMidi = PitchChromaticMidi.from( Chromatic.G, 10 );
        assertEquals(  PitchChromaticMidi.MAX, pitchMidi );
    }

    @Test
    public void fromChromaticAndOctave() {
        PitchChromaticMidi p = PitchChromaticMidi.from( Chromatic.C, 5 );
        assertEquals( PitchChromaticMidi.C5, p );
    }
}
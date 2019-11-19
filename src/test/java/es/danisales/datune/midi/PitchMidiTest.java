package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.*;

public class PitchMidiTest {
    @Test
    public void getChromatic() {
        assertSame( Chromatic.C, PitchMidi.C5.getChromatic() );
        assertSame( Chromatic.B, PitchMidi.B7.getChromatic() );
    }

    @Test
    public void getWithShiftOctave() {
        assertSame( PitchMidi.C6, PitchMidi.C5.getWithShiftOctave(1) );
        assertSame( PitchMidi.C4, PitchMidi.C5.getWithShiftOctave(-1) );
    }

    @Test(expected = PitchMidiException.class)
    public void getWithShiftOctaveInvalid() {
        PitchMidi.C10.getWithShiftOctave(1);
    }

    @Test(expected = PitchMidiException.class)
    public void getWithShiftOctaveInvalid2() {
        PitchMidi.C0.getWithShiftOctave(-1);
    }

    @Test
    public void getWithOctave() {
        assertEquals( PitchMidi.C10, PitchMidi.C5.getWithOctave(10) );
        assertEquals( PitchMidi.C0, PitchMidi.C5.getWithOctave(0) );
    }

    @Test(expected = PitchMidiException.class)
    public void getWithOctaveInvalid() {
        PitchMidi.C5.getWithOctave(-1);
    }

    @Test(expected = PitchMidiException.class)
    public void getWithOctaveInvalid2() {
        PitchMidi.A5.getWithOctave(10);
    }

    @Test
    public void getCodeLimits() {
        assertEquals(0, PitchMidi.MIN.getCode());
        assertEquals(127, PitchMidi.MAX.getCode());
    }

    @Test
    public void getCode() {
        assertEquals(60, PitchMidi.C5.getCode());
        assertEquals(72, PitchMidi.C6.getCode());
    }

    @Test
    public void equals() {
        PitchMidi pitchMidi = PitchMidi.from( Chromatic.C, 0 );
        assertEquals( PitchMidi.MIN, pitchMidi );

        pitchMidi = PitchMidi.from( Chromatic.G, 10 );
        assertEquals(  PitchMidi.MAX, pitchMidi );
    }

    @Test
    public void getOctave() {
        assertEquals(5, PitchMidi.C5.getOctave());
        assertEquals(6, PitchMidi.C6.getOctave());
        assertEquals(PitchMidi.MIN_OCTAVE, PitchMidi.MIN.getOctave());
        assertEquals(PitchMidi.MAX_OCTAVE, PitchMidi.MAX.getOctave());
    }

    @Test
    public void fromCode() {
        assertSame( PitchMidi.C5, PitchMidi.from(60) );
        assertSame( PitchMidi.MIN, PitchMidi.from(0) );
        assertSame( PitchMidi.MAX, PitchMidi.from(127) );
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid() {
        PitchMidi.from(600);
    }

    @Test(expected = PitchMidiException.class)
    public void fromCodeInvalid2() {
        PitchMidi.from(-1);
    }

    @Test
    public void fromTonalityOctave() {
        PitchMidi pitchMidi = PitchMidi.from(DiatonicDegree.I, Tonality.C, 5);
        assertSame(PitchMidi.C5, pitchMidi);

        pitchMidi = PitchMidi.from(DiatonicDegree.III, Tonality.Am, 5);
        assertSame(PitchMidi.C6, pitchMidi);

        pitchMidi = PitchMidi.from(DiatonicDegree.I, Tonality.C, 10);
        assertSame(PitchMidi.C10, pitchMidi);

        pitchMidi = PitchMidi.from(DiatonicDegree.III, Tonality.Am, -1);
        assertSame(PitchMidi.C0, pitchMidi);
    }

    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid() {
        PitchMidi.from(DiatonicDegree.VI, Tonality.C, 10);
    }
    @Test(expected = PitchMidiException.class)
    public void fromTonalityOctaveInvalid2() {
        PitchMidi.from(DiatonicDegree.VI, Tonality.C, -1);
    }

    @Test
    public void getShift() {
        assertSame( PitchMidi.C6, PitchMidi.B4.getShift(13) );
        assertSame( PitchMidi.B4, PitchMidi.C6.getShift(-13) );
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid() {
        PitchMidi.B4.getShift(-130);
    }

    @Test(expected = PitchMidiException.class)
    public void getShiftInvalid2() {
        PitchMidi.B4.getShift(130);
    }

    @Test
    public void getDegree() {
    }

    @Test
    public void getNext() {
        assertSame( PitchMidi.CC5, PitchMidi.C5.getNext() );
    }

    @Test
    public void getNext2() {
        assertSame( PitchMidi.C5, PitchMidi.B4.getNext() );
    }

    @Test
    public void getPrevious() {
        assertSame( PitchMidi.C5, PitchMidi.CC5.getPrevious() );
    }

    @Test
    public void getPrevious2() {
        assertSame( PitchMidi.B4, PitchMidi.C5.getPrevious() );
    }

    @Test(expected = PitchMidiException.class)
    public void getPreviousFails() {
        PitchMidi.MIN.getPrevious();
    }

    @Test
    public void limits() {
        PitchMidi pitchMidi = PitchMidi.from( Chromatic.C, 0 );
        assertEquals( PitchMidi.MIN, pitchMidi );

        pitchMidi = PitchMidi.from( Chromatic.G, 10 );
        assertEquals(  PitchMidi.MAX, pitchMidi );
    }

    @Test
    public void fromChromaticAndOctave() {
        PitchMidi p = PitchMidi.from( Chromatic.C, 5 );
        assertEquals( PitchMidi.C5, p );
    }
}
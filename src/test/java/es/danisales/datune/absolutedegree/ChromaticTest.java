package es.danisales.datune.absolutedegree;

import es.danisales.datune.degree.ChromaticDegree;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.lang.Language;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ChromaticTest {

    @Test
    public void from_int() {
        assertSame(Chromatic.C, Chromatic.from(0));
        assertSame(Chromatic.B, Chromatic.from(11));
    }

    @Test
    public void from_int_overLimits() {
        assertSame(Chromatic.C, Chromatic.from(12));
        assertSame(Chromatic.B, Chromatic.from(-1));
        assertSame(Chromatic.A, Chromatic.from(-15));
    }

    @Test
    public void from_diatonic() {
        assertSame(Chromatic.C, Chromatic.from(Diatonic.C));
        assertSame(Chromatic.D, Chromatic.from(Diatonic.D));
        assertSame(Chromatic.E, Chromatic.from(Diatonic.E));
        assertSame(Chromatic.F, Chromatic.from(Diatonic.F));
        assertSame(Chromatic.G, Chromatic.from(Diatonic.G));
        assertSame(Chromatic.A, Chromatic.from(Diatonic.A));
        assertSame(Chromatic.B, Chromatic.from(Diatonic.B));
    }

    @Test
    public void from_DiatonicAlt() {
        assertSame(Chromatic.C, Chromatic.from(DiatonicAlt.C));
        assertSame(Chromatic.C, Chromatic.from(DiatonicAlt.BB));
        assertSame(Chromatic.G, Chromatic.from(DiatonicAlt.FFF));
        assertSame(Chromatic.GG, Chromatic.from(DiatonicAlt.FFFF));
    }

    @Test
    public void from_pitchDiatonicMidi() throws PitchMidiException {
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(DiatonicDegree.I, Tonality.from(DiatonicAlt.Cb, Scale.MINOR), 5);
        assertSame(Chromatic.B, Chromatic.from(pitchDiatonicMidi));
    }

    @Test
    public void ordinal() {
        assertEquals(0, Chromatic.C.ordinal());
        assertEquals(1, Chromatic.CC.ordinal());
        assertEquals(2, Chromatic.D.ordinal());
        assertEquals(3, Chromatic.DD.ordinal());
        assertEquals(4, Chromatic.E.ordinal());
        assertEquals(5, Chromatic.F.ordinal());
        assertEquals(6, Chromatic.FF.ordinal());
        assertEquals(7, Chromatic.G.ordinal());
        assertEquals(8, Chromatic.GG.ordinal());
        assertEquals(9, Chromatic.A.ordinal());
        assertEquals(10, Chromatic.AA.ordinal());
        assertEquals(11, Chromatic.B.ordinal());
    }

    @Test
    public void compareTo() {
        assertEquals(-1, Chromatic.C.compareTo(Chromatic.CC));
        assertEquals(-2, Chromatic.C.compareTo(Chromatic.D));
        assertEquals(1, Chromatic.D.compareTo(Chromatic.CC));
        assertEquals(2, Chromatic.D.compareTo(Chromatic.C));
    }

    @Test
    public void getNext() {
        assertSame(Chromatic.CC, Chromatic.C.getNext());
        assertSame(Chromatic.C, Chromatic.B.getNext());
    }

    @Test
    public void getShifted() {
        assertEquals(Chromatic.D, Chromatic.C.getShifted(IntervalChromatic.MAJOR_SECOND));
        assertEquals(Chromatic.C, Chromatic.A.getShifted(IntervalChromatic.MINOR_THIRD));
        assertEquals(Chromatic.B, Chromatic.B.getShifted(IntervalChromatic.PERFECT_OCTAVE));
    }

    @Test
    public void getShiftedNegative() {
        assertEquals(Chromatic.C, Chromatic.D.getShiftedNegative(IntervalChromatic.MAJOR_SECOND));
        assertEquals(Chromatic.A, Chromatic.C.getShiftedNegative(IntervalChromatic.MINOR_THIRD));
        assertEquals(Chromatic.B, Chromatic.B.getShiftedNegative(IntervalChromatic.PERFECT_OCTAVE));
    }

    @Test
    public void distSemitonesTo() {
        assertEquals(0, Chromatic.C.distSemitonesTo(Chromatic.C));
        assertEquals(2, Chromatic.C.distSemitonesTo(Chromatic.D));
        assertEquals(11, Chromatic.C.distSemitonesTo(Chromatic.B));
        assertEquals(1, Chromatic.B.distSemitonesTo(Chromatic.C));
        assertEquals(10, Chromatic.B.distSemitonesTo(Chromatic.A));
    }

    @Test
    public void getDegree() {
        assertSame(ChromaticDegree.I, Chromatic.C.getDegree());
        assertSame(ChromaticDegree.II, Chromatic.CC.getDegree());
        assertSame(ChromaticDegree.III, Chromatic.D.getDegree());
        assertSame(ChromaticDegree.IV, Chromatic.DD.getDegree());
        assertSame(ChromaticDegree.V, Chromatic.E.getDegree());
        assertSame(ChromaticDegree.VI, Chromatic.F.getDegree());
        assertSame(ChromaticDegree.VII, Chromatic.FF.getDegree());
        assertSame(ChromaticDegree.VIII, Chromatic.G.getDegree());
        assertSame(ChromaticDegree.IX, Chromatic.GG.getDegree());
        assertSame(ChromaticDegree.X, Chromatic.A.getDegree());
        assertSame(ChromaticDegree.XI, Chromatic.AA.getDegree());
        assertSame(ChromaticDegree.XII, Chromatic.B.getDegree());
    }

    @Test
    public void getPrevious() {
        assertSame(Chromatic.C, Chromatic.CC.getPrevious());
        assertSame(Chromatic.B, Chromatic.C.getPrevious());
    }

    @Test
    public void toStringTest_ENG() {
        Language.current = Language.ENG;
        assertSame("C", Chromatic.C.toString());
        assertEquals("C#", Chromatic.CC.toString());
        assertSame("D", Chromatic.D.toString());
        assertEquals("D#", Chromatic.DD.toString());
        assertSame("E", Chromatic.E.toString());
        assertSame("F", Chromatic.F.toString());
        assertEquals("F#", Chromatic.FF.toString());
        assertSame("G", Chromatic.G.toString());
        assertEquals("G#", Chromatic.GG.toString());
        assertSame("A", Chromatic.A.toString());
        assertEquals("A#", Chromatic.AA.toString());
        assertSame("B", Chromatic.B.toString());
    }

    @Test
    public void toStringTest_ESP() {
        Language.current = Language.ESP;
        assertSame("Do", Chromatic.C.toString());
        assertEquals("Do#", Chromatic.CC.toString());
        assertSame("Re", Chromatic.D.toString());
        assertEquals("Re#", Chromatic.DD.toString());
        assertSame("Mi", Chromatic.E.toString());
        assertSame("Fa", Chromatic.F.toString());
        assertEquals("Fa#", Chromatic.FF.toString());
        assertSame("Sol", Chromatic.G.toString());
        assertEquals("Sol#", Chromatic.GG.toString());
        assertSame("La", Chromatic.A.toString());
        assertEquals("La#", Chromatic.AA.toString());
        assertSame("Si", Chromatic.B.toString());
    }
}
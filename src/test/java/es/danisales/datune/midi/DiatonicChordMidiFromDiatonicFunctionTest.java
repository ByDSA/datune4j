package es.danisales.datune.midi;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiatonicChordMidiFromDiatonicFunctionTest {

    static void assertPitchInChord(PitchChromaticMidi pitchChromaticMidi, DiatonicChordMidi diatonicChordMidi, int pos) {
        assertEquals("Actual: " + PitchChromaticMidi.from(diatonicChordMidi.get(pos).getPitch()) + " Expected: " + pitchChromaticMidi,
                pitchChromaticMidi.getMidiCode(), diatonicChordMidi.get(pos).getPitch().getMidiCode());
    }

    @Test
    public void fromDiatonicFunction() throws BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction2() throws BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(IntervalDiatonic.THIRD, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction3() throws BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(IntervalDiatonic.THIRD, Tonality.Gm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.AA5, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction4() throws BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicDegree.II, IntervalDiatonic.THIRD, Tonality.Gm)
                .octave(6)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.C7, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction5() throws BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicDegree.VI, IntervalDiatonic.THIRD, Tonality.Gm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.DD6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G6, diatonicChordMidi, 1);
    }

    @Test
    public void fromDiatonicFunction6() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi;
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction7() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.II, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.F5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction8() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.III, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction9() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.IV, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.F5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.C6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction10() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.V, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction11() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.C6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction12() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VII, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.F6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction13() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.FF5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.CC6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction14() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.II, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.GG5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction15() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.III, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.CC6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction16() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.IV, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction17() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.V, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.CC6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.GG6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction18() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.A6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction19() throws BuildingException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VII, tonality)
                .octave(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.GG6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.B6, diatonicChordMidi, 2);
    }


    @Test
    public void fromDiatonicFunction20() throws BuildingException {
        Tonality s = Tonality.B;
        int o = 5;
        DiatonicChordMidi c1 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, s)
                .octave(o)
                .build();
        DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                .from(DiatonicFunction.II, s)
                .octave(o)
                .build();

        assertPitchInChord(PitchChromaticMidi.B5, c1, 0);
        assertPitchInChord(PitchChromaticMidi.CC6, c2, 0);
    }

    @Test
    public void fromDiatonicFunction21() throws BuildingException {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .octave(5)
                .build();
        assertPitchInChord(PitchChromaticMidi.C5, c, 0);
        assertPitchInChord(PitchChromaticMidi.E5, c, 1);
        assertPitchInChord(PitchChromaticMidi.G5, c, 2);
    }
}

package es.danisales.datune.midi;

import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityModern;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChordMidiFromDiatonicFunctionTest {
    private static void assertPitchInChord(PitchChromaticMidi pitchChromaticMidi, ChordMidi diatonicChordMidi, int pos) {
        assertEquals("Actual: " + diatonicChordMidi.get(pos).getPitch() + " Expected: " + pitchChromaticMidi,
                pitchChromaticMidi.getMidiCode(), diatonicChordMidi.get(pos).getPitch().getMidiCode());
    }

    @Test
    public void fromDiatonicFunction() throws PitchMidiException {
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(TonalityModern.C, DiatonicFunction.I))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction6() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi;
        diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.I))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction7() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.II))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.F5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction8() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.III))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.E5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction9() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.IV))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.F5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.C6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction10() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.V))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction11() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VI))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.C6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction12() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.C, Scale.MAJOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VII))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.F6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction13() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.I))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.FF5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.CC6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction14() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.II))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.GG5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction15() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.III))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.CC6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction16() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.IV))
                .octaveBase(5)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction17() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi chordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.V))
                .octaveBase(5)
                .build();
        assertEquals(3, chordMidi.size());
        assertPitchInChord(PitchChromaticMidi.CC5, chordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.E5, chordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.GG5, chordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction18() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VI))
                .octaveBase(6)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.A6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction19() throws PitchMidiException {
        Tonality tonality = Tonality.from(Chromatic.FF, Scale.MINOR);
        ChordMidi diatonicChordMidi = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VII))
                .octaveBase(6)
                .build();
        assertEquals(3, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.E6, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.GG6, diatonicChordMidi, 1);
        assertPitchInChord(PitchChromaticMidi.B6, diatonicChordMidi, 2);
    }

    @Test
    public void fromDiatonicFunction20() {
        Tonality tonality = TonalityModern.B;
        int o = 5;
        ChordMidi c1 = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.I))
                .octaveBase(o)
                .build();
        ChordMidi c2 = ChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.II))
                .octaveBase(o)
                .build();

        assertPitchInChord(PitchChromaticMidi.B5, c1, 0);
        assertPitchInChord(PitchChromaticMidi.CC5, c2, 0);
    }

    @Test
    public void fromDiatonicFunction21() {
        ChordMidi c = ChordMidi.builder()
                .from(TonalChord.from(TonalityModern.C, DiatonicFunction.I))
                .octaveBase(5)
                .build();
        assertPitchInChord(PitchChromaticMidi.C5, c, 0);
        assertPitchInChord(PitchChromaticMidi.E5, c, 1);
        assertPitchInChord(PitchChromaticMidi.G5, c, 2);
    }
}

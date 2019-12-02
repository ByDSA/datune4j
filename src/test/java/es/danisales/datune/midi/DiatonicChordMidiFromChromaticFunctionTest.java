package es.danisales.datune.midi;

import es.danisales.building.BuildingException;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.junit.Test;

import static es.danisales.datune.midi.DiatonicChordMidiFromDiatonicFunctionTest.assertPitchInChord;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DiatonicChordMidiFromChromaticFunctionTest {
    @Test
    public void fromPowerChordFunction() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.I5, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.C5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.G5, diatonicChordMidi, 1);
    }

    @Test(expected = BuildingException.class)
    public void fromPowerChordFunction2() { // todo: datils, throw building exception
        DiatonicChordMidi.builder()
                .from(ChromaticFunction.II5, Tonality.from(DiatonicAlt.C, Scale.PENTATONIC_MINOR))
                .octave(5)
                .build();
    }

    @Test
    public void fromPowerChordFunction6() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.III5, Tonality.from(DiatonicAlt.C, Scale.PENTATONIC_MINOR))
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.DD5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.AA5, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction7() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.VII5, Tonality.from(DiatonicAlt.C, Scale.CHROMATIC))
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction3() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.VII5, Tonality.C)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.B5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.FF6, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction4() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.VII5, Tonality.from(DiatonicAlt.C, Scale.MIXOLYDIAN))
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.AA5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.F6, diatonicChordMidi, 1);
    }

    @Test
    public void fromPowerChordFunction5() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.II5, Tonality.Cm)
                .octave(5)
                .build();
        assertEquals(2, diatonicChordMidi.size());
        assertPitchInChord(PitchChromaticMidi.D5, diatonicChordMidi, 0);
        assertPitchInChord(PitchChromaticMidi.A5, diatonicChordMidi, 1);
    }

    @Test
    public void fromChromaticChordAndTonality() {
        DiatonicChordMidi ca = DiatonicChordMidi.builder()
                .from(ChromaticChord.C, Tonality.C)
                .build();
        assertNotNull(ca);
        assertEquals(Tonality.C, ca.getTonality());
    }

    @Test
    public void chromaticFunctionTonality() {
        Tonality tonality = Tonality.C;
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.V7_IV, tonality)
                .octave(5)
                .build();

        assertEquals(
                Tonality.F,
                diatonicChordMidi.getTonality()
        );
    }

    @Test
    public void chromaticFunctionTonality2() {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(ChromaticFunction.V7_V, Tonality.E)
                .octave(5)
                .build();

        assertEquals(
                Tonality.B,
                diatonicChordMidi.getTonality()
        );
    }


    @Test
    public void powerChord() {
        DiatonicChordMidi c = DiatonicChordMidi.builder()
                .from(ChromaticFunction.I5, Tonality.C)
                .octave(5)
                .build();
        assertPitchInChord(PitchChromaticMidi.C5, c, 0);
        assertPitchInChord(PitchChromaticMidi.G5, c, 1);
    }
}

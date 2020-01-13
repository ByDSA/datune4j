package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.lang.Language;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.PitchException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiatonicChordMidiNamesTest {
    {
        Language.current = Language.ENG;
    }

    @Test
    public void names() throws PitchException, BuildingException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();

        assertEquals("C (C)", diatonicChordMidi.toString());

        diatonicChordMidi = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.Cm).build();
        assertEquals("Cm (C)", diatonicChordMidi.toString());
        diatonicChordMidi = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();
        diatonicChordMidi.inv();

        assertEquals("C/E (C)", diatonicChordMidi.toString());
        diatonicChordMidi.inv();
        assertEquals("C/G (C)", diatonicChordMidi.toString());
        diatonicChordMidi.inv();
        assertEquals("C (C)", diatonicChordMidi.toString());

        diatonicChordMidi = DiatonicChordMidi.builder().from(ChromaticFunction.IV5, Tonality.C).build();
        assertEquals("F5 (IV5)", diatonicChordMidi.toString());
        diatonicChordMidi.inv();
        assertEquals("F5/C (IV5)", diatonicChordMidi.toString());

        diatonicChordMidi = DiatonicChordMidi.builder().from(DiatonicFunction.ISUS2, Tonality.C).build();
        assertEquals("Csus2 (ISUS2)", diatonicChordMidi.toString());
        diatonicChordMidi = DiatonicChordMidi.builder().from(DiatonicFunction.VSUS4, Tonality.C).build();
        assertEquals("Gsus4 (VSUS4)", diatonicChordMidi.toString());
        diatonicChordMidi.inv();
        assertEquals("Gsus4/C (VSUS4)", diatonicChordMidi.toString());

        ChromaticChord chromaticChord = ChromaticChord.builder().addAll(
                Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)
        ).build();
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(chromaticChord, Tonality.C)
                .build();
        assertEquals("Csus2 (ISUS2)", diatonicChordMidi.toString());
    }

    @Test
    public void toStringTest() throws BuildingException {
        Language.current = Language.ENG;
        DiatonicChordMidi dcm = DiatonicChordMidi.builder()
                .from(ChromaticChord.F5, Tonality.C)
                .build();

        assertEquals("F5 (IV5, C Mayor, oct 5)", dcm.toString());
    }
}

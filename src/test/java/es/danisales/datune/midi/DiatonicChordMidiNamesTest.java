package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiatonicChordMidiNamesTest {

    @Test
    public void names() {
        DiatonicChordMidi ccm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();
        assertEquals(
                "C/E (C)", ccm.toString()
        );

        assertEquals("C", ChromaticChord.C.toString());

        DiatonicChordMidi dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();

        assertEquals("C (C)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.Cm).build();
        assertEquals("Cm (C)", dcm.toString());
        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I, Tonality.C).build();
        dcm.inv();

        assertEquals("C/E (C)", dcm.toString());
        dcm.inv();
        assertEquals("C/G (C)", dcm.toString());
        dcm.inv();
        assertEquals("C (C)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(ChromaticFunction.IV5, Tonality.C).build();
        assertEquals("F5 (IV5)", dcm.toString());
        dcm.inv();
        assertEquals("F5/C (IV5)", dcm.toString());

        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.I2, Tonality.C).build();
        assertEquals("Csus2 (I2)", dcm.toString());
        dcm = DiatonicChordMidi.builder().from(DiatonicFunction.V4, Tonality.C).build();
        assertEquals("Gsus4 (V4)", dcm.toString());
        dcm.inv();
        assertEquals("Gsus4/C (V4)", dcm.toString());

        ChromaticChord chromaticChord = ChromaticChord.builder().fromChromatic(
                Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)
        ).build();
        dcm = DiatonicChordMidi.builder()
                .from(chromaticChord, Tonality.C)
                .build();
        assertEquals("Csus2 (I2)", dcm.toString());
    }

    @Test
    public void toStringTest() throws PitchMidiException, TonalityException {
        DiatonicChordMidi dcm = DiatonicChordMidi.builder()
                .from(ChromaticChord.F5, Tonality.C)
                .build();

        assertEquals("F5 (IV5, C Mayor, oct 5)", dcm.toString());
    }
}

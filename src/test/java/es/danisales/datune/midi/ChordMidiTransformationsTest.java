package es.danisales.datune.midi;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChordMidiTransformationsTest {
    @Test
    public void getAllInversionsFrom() {
        fail();
    }

    @Test
    public void getAllDispositionsWithInv() {
        DiatonicChordMidi diatonicChordMidiOther = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .build();
        List<DiatonicChordMidi> list = ChordMidiTransformations.getAllDispositionsWithInv(diatonicChordMidiOther);
        assertEquals(518, list.size());
    }

    @Test
    public void getAllDispositionsSub() {
        fail();
    }

    @Test
    public void minimize() throws TonalityException {
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder().tonality(Tonality.C).build();
        diatonicChordMidi.addAll(
                Arrays.asList(
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.C5).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.E6).build(),
                        ChromaticMidi.builder().pitch(PitchChromaticMidi.G7).build()
                )
        );
        ChordMidiTransformations.minimize(diatonicChordMidi);
        assertEquals(PitchChromaticMidi.C5.getMidiCode(), diatonicChordMidi.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.E5.getMidiCode(), diatonicChordMidi.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.G5.getMidiCode(), diatonicChordMidi.get(2).getPitch().getMidiCode());
    }

    @Test
    public void minimizeDistanceTo() {
        DiatonicChordMidi diatonicChordMidiEditing = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VII, Tonality.C)
                .build();

        DiatonicChordMidi diatonicChordMidiSource = diatonicChordMidiEditing.clone();

        DiatonicChordMidi diatonicChordMidiOther = DiatonicChordMidi.builder()
                .from(DiatonicFunction.I, Tonality.C)
                .build();
        ChordMidiTransformations.minimizeDistanceTo(diatonicChordMidiEditing, diatonicChordMidiOther);

        assertNotEquals(diatonicChordMidiSource, diatonicChordMidiEditing);

        assertEquals(PitchChromaticMidi.D5.getMidiCode(), diatonicChordMidiEditing.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.F5.getMidiCode(), diatonicChordMidiEditing.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), diatonicChordMidiEditing.get(2).getPitch().getMidiCode());
    }

    @Test
    public void shiftOctaveList() {
        fail();
    }

    @Test
    public void dist() {
        fail();
    }

    @Test
    public void dist1() {
        fail();
    }
}
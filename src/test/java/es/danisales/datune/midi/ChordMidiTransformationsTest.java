package es.danisales.datune.midi;

import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChordMidiTransformationsTest {
/*
    @Test
    public void getAllDispositionsWithInv() throws PitchMidiException {
        ChordMidi diatonicChordMidiOther = ChordMidi.builder()
                .from(TonalChord.from(Tonality.C, DiatonicFunction.I))
                .build();
        List<ChordMidi> list = ChordMidiTransformations.getAllAbsoluteVoicesWithInv(diatonicChordMidiOther);
        assertEquals(518, list.size());
    }

    @Test
    public void minimize() throws TonalityException, BuildingException {
        ChordMidi diatonicChordMidi = ChordMidi.builder().tonality(Tonality.C).build();
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
    public void minimizeDistanceTo() throws BuildingException {
        ChordMidi diatonicChordMidiEditing = ChordMidi.builder()
                .from(TonalChord.from(Tonality.C, DiatonicFunction.VII))
                .build();

        ChordMidi diatonicChordMidiSource = diatonicChordMidiEditing.clone();

        ChordMidi diatonicChordMidiOther = ChordMidi.builder()
                .from(TonalChord.from(Tonality.C, DiatonicFunction.I))
                .build();
        ChordMidiTransformations.minimizeDistanceTo(diatonicChordMidiEditing, diatonicChordMidiOther);

        assertNotEquals(diatonicChordMidiSource, diatonicChordMidiEditing);

        assertEquals(PitchChromaticMidi.D5.getMidiCode(), diatonicChordMidiEditing.get(0).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.F5.getMidiCode(), diatonicChordMidiEditing.get(1).getPitch().getMidiCode());
        assertEquals(PitchChromaticMidi.B5.getMidiCode(), diatonicChordMidiEditing.get(2).getPitch().getMidiCode());
    }
*/
}
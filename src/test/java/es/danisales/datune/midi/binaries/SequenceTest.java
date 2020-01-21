package es.danisales.datune.midi.binaries;

import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import es.danisales.utils.building.BuildingException;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertNotNull;

public class SequenceTest {
    @Test
    public void aa() throws BuildingException {
        Path path = Paths.get("aa1234.mid");
        Sequence sequence = new Sequence(path, 120);
        Track track = sequence.firstChannel;
        Tonality tonality = Tonality.Cm;
        DiatonicChordMidi diatonicChordMidi = DiatonicChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.I))
                .length(DurationMidi.L1)
                .build();
        track.add(diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VI))
                .length(DurationMidi.L1)
                .build();
        track.add(DurationMidi.L1, diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.III))
                .length(DurationMidi.L2)
                .build();
        track.add(DurationMidi.L1 * 2, diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(TonalChord.from(tonality, DiatonicFunction.VII))
                .length(DurationMidi.L2)
                .build();
        track.add((DurationMidi.L1 * 3), diatonicChordMidi);
        Tonality tonalityRelative = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertNotNull(tonalityRelative);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(TonalChord.from(tonalityRelative, DiatonicFunction.VII))
                .length(DurationMidi.L2)
                .build();
        track.add((int) (DurationMidi.L1 * 3.5), diatonicChordMidi);
        sequence.save();
    }
}
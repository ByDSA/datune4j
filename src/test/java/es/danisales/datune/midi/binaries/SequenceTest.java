package es.danisales.datune.midi.binaries;

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
                .from(DiatonicFunction.I, tonality)
                .length(DurationMidi.L1)
                .build();
        track.add(diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VI, tonality)
                .length(DurationMidi.L1)
                .build();
        track.add(DurationMidi.L1, diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.III, tonality)
                .length(DurationMidi.L2)
                .build();
        track.add(DurationMidi.L1 * 2, diatonicChordMidi);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VII, tonality)
                .length(DurationMidi.L2)
                .build();
        track.add((DurationMidi.L1 * 3), diatonicChordMidi);
        Tonality tonalityRelative = TonalityRetrieval.getRelativeMajorFrom(tonality);
        assertNotNull(tonalityRelative);
        diatonicChordMidi = DiatonicChordMidi.builder()
                .from(DiatonicFunction.VII, tonalityRelative)
                .length(DurationMidi.L2)
                .build();
        track.add((int) (DurationMidi.L1 * 3.5), diatonicChordMidi);
        sequence.save();
    }
}
package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.WhatIsIt;
import es.danisales.datune.pitch.ChordCommon;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.function.BiFunction;

public class WhatIsItChordMidi {
    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface>
    void updateWhatIsIt(@NonNull ChordMidi<N, I, P> chordMidi, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> f) {
        if (chordMidi instanceof ChromaticChordMidi)
            chordMidi.meta = ChromaticChord.builder().fromChromaticMidi((ChromaticChordMidi) chordMidi).build();
        else if (chordMidi instanceof DiatonicChordMidi) {
            ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder().fromDiatonicChordMidi((DiatonicChordMidi) chordMidi).build();
            updateWhatIsIt(chromaticChordMidi, f);
            return;
        }
        assert f != null;
        WhatIsIt.updateWhatIsIt(chordMidi.meta, f );
        chordMidi.setRootIndex(chordMidi.meta.getRootIndex());
    }
}

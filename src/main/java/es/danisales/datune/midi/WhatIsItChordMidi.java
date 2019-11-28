package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.WhatIsIt;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class WhatIsItChordMidi {
    public static <N extends Note<P>, I extends Interval, P extends PitchMidiInterface>
    void updateWhatIsIt(@NonNull ChordMidi<N, I, P> chordMidi, BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> f) {
        chordMidi.meta = ChromaticChord.builder().fromList((Collection<? extends PitchChromaticSingle>) chordMidi).build();
        assert f != null;
        WhatIsIt.updateWhatIsIt(chordMidi.meta, f );
        chordMidi.setRootPos( chordMidi.meta.getRootPos() );
    }
}

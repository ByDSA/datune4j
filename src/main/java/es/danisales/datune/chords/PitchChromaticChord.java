package es.danisales.datune.chords;

import es.danisales.datune.chords.ChordCommon;
import es.danisales.datune.chords.ChromaticChordInfo;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N> {
	@NonNull
	ChromaticChordInfo getInfo();
}

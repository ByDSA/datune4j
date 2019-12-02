package es.danisales.datune.pitch;

import es.danisales.datune.musical.ChromaticChordInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N> {
	@NonNull
	ChromaticChordInfo getInfo();
}

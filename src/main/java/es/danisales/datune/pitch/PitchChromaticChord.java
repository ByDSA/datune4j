package es.danisales.datune.pitch;

import es.danisales.datune.musical.Quality;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N> {
	@NonNull
	Quality getQuality();
}

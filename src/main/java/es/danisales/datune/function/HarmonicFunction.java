package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface HarmonicFunction {
    static @Nullable HarmonicFunction get(@NonNull ChromaticChord chromaticChord, @NonNull Tonality tonality) {
        return tonality.getFunctionFrom(chromaticChord);
	}
}

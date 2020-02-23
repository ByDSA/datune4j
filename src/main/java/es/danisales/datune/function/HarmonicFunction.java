package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.TonalityModern;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface HarmonicFunction {
    @NonNull ChromaticChord getChord(@NonNull TonalityModern tonality) throws ScaleRelativeDegreeException;
    @NonNull HarmonicFunction getShifted(int i);
}

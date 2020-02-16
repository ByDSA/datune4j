package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ChromaticFunction extends HarmonicFunction {
    @NonNull ChromaticChord getChromaticChordFromTonality(Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException;
    @NonNull ChromaticFunction getShifted(int i);
}

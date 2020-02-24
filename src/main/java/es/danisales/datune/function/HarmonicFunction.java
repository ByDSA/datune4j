package es.danisales.datune.function;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.TonalityModern;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class HarmonicFunction {
    private static FunctionCache functionCache = new FunctionCache();

    @Nullable public final ChromaticChord getChord(@NonNull TonalityModern tonality) {
        TonalChord tonalChord = TonalChord.from(tonality, this);
        ChromaticChord chromaticChord = (ChromaticChord)functionCache.get(tonalChord);
        if (functionCache.containsKey(tonalChord)) {
            chromaticChord = calculateChord(tonality);
            functionCache.put(tonalChord.clone(), ChromaticChord.immutableFrom(chromaticChord));
        }

        return chromaticChord;
    }
    @Nullable protected abstract ChromaticChord calculateChord(TonalityModern tonalityModern);
    @NonNull public abstract HarmonicFunction getShifted(int i);
}

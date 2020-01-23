package es.danisales.datune.tonality;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.chords.ChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class TonalityUtils {
    private TonalityUtils() {
    }

    public static boolean isMajorOrMinor(@NonNull Tonality tonality) {
        return isMajor(tonality) || isMinor(tonality);
    }

    public static boolean isMajor(@NonNull Tonality tonality) {
        return ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MAJOR_THIRD)
                && !ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MINOR_THIRD);
    }

    public static boolean isMinor(@NonNull Tonality tonality) {
        return !ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MAJOR_THIRD)
                && ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MINOR_THIRD);
    }


    public static boolean hasAsChromaticFunction(@NonNull Tonality tonality, @NonNull ChromaticChord chromaticChord) {
        Objects.requireNonNull(chromaticChord);

        for (ChromaticFunction f : ChromaticFunction.values()) {
            if (tonality.size() != Diatonic.NUMBER && ArrayUtils.contains(f, ChromaticFunction.TENSIONS))
                continue;

            ChromaticChord c2 = ChromaticChord.builder()
                    .chromaticFunction(f)
                    .tonality(tonality)
                    .build();
            if (chromaticChord.equals(c2))
                return true;
        }

        return false;
    }


    public static boolean hasAsDiatonicFunction(@NonNull Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
        ChromaticChord chromaticChord2 = ChromaticChord.builder()
                .chromaticFunction(chromaticFunction)
                .tonality(tonality)
                .build();
        return tonality.containsAll(chromaticChord2);
    }

}

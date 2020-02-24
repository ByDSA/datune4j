package es.danisales.datune.tonality;

import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TonalityUtils {
    private TonalityUtils() {
    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isMajorOrMinor(@NonNull Tonality tonality) {
        return isMajor(tonality) || isMinor(tonality);
    }

    public static boolean isMajor(@NonNull Tonality tonality) {
        return ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MAJOR_THIRD)
                && !ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MINOR_THIRD);
    }

    @SuppressWarnings("WeakerAccess")
    public static boolean isMinor(@NonNull Tonality tonality) {
        return !ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MAJOR_THIRD)
                && ScaleUtils.hasIntervalFromRoot(tonality.getScale(), IntervalChromatic.MINOR_THIRD);
    }
}

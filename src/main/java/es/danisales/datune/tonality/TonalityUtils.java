package es.danisales.datune.tonality;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.utils.building.BuildingException;
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


    public static boolean hasAsChromaticFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticChord chromaticChord) {
        Objects.requireNonNull(chromaticChord);

        for (SecondaryDominant secondaryDominant : SecondaryDominant.values()) {
            if (tonality.size() != Diatonic.NUMBER && SecondaryDominant.ALL.contains(secondaryDominant))
                continue;

            try {
                secondaryDominant.getChromaticChordFromTonality(tonality);
            } catch (ScaleRelativeDegreeException e) {
                continue;
            }

            ChromaticChord c2;
            try {
                c2 = ChromaticChord.builder()
                        .function(secondaryDominant)
                        .tonality(tonality)
                        .build();
            } catch (BuildingException e) {
                continue;
            }
            if (chromaticChord.equals(c2))
                return true;
        }

        return false;
    }


    public static boolean hasAsDiatonicFunction(@NonNull Tonality<Chromatic> tonality, @NonNull ChromaticFunction chromaticFunction) {
        ChromaticChord chromaticChord2 = null;
        try {
            chromaticChord2 = ChromaticChord.builder()
                    .function(chromaticFunction)
                    .tonality(tonality)
                    .build();
        } catch (BuildingException e) {
            return false;
        }
        return tonality.containsAll(chromaticChord2);
    }

}

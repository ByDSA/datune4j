package es.danisales.datune.interval;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.lang.Nominator;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public enum IntervalDiatonic implements Interval {
    UNISON, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH,
    OCTAVE, NINTH, TENTH, ELEVENTH, TWELFTH, THIRTEENTH, FOURTEENTH,
    FIFTEENTH;

    public static @NonNull IntervalDiatonic fromIndex(int n) {
    	n = trimToValidValue(n);

    	return IntervalDiatonic.values()[n];
    }

    private static int trimToValidValue(int n) {
        return (n < 0 ? -n : n) % (IntervalDiatonic.values().length);
    }

    @SuppressWarnings("Duplicates")
    public static @NonNull IntervalDiatonic from(@NonNull DiatonicDegree diatonicDegree) {
        switch (diatonicDegree) {
            case I:
                return UNISON;
            case II:
                return SECOND;
            case III:
                return THIRD;
            case IV:
                return FOURTH;
            case V:
                return FIFTH;
            case VI:
                return SIXTH;
            case VII:
                return SEVENTH;
        }

        throw NeverHappensException.switchOf(diatonicDegree);
    }

    public static @NonNull IntervalDiatonic from(@NonNull IntervalChromatic intervalChromatic) {
        switch (intervalChromatic) {
            case AUGMENTED_UNISON:
            case PERFECT_UNISON:
                return IntervalDiatonic.UNISON;
            case AUGMENTED_SECOND:
            case DIMINISHED_SECOND:
            case MAJOR_SECOND:
            case MINOR_SECOND:
                return IntervalDiatonic.SECOND;
            case AUGMENTED_THIRD:
            case DIMINISHED_THIRD:
            case MAJOR_THIRD:
            case MINOR_THIRD:
                return IntervalDiatonic.THIRD;
            case AUGMENTED_FOURTH:
            case DIMINISHED_FOURTH:
            case PERFECT_FOURTH:
                return IntervalDiatonic.FOURTH;
            case AUGMENTED_FIFTH:
            case DIMINISHED_FIFTH:
            case PERFECT_FIFTH:
                return IntervalDiatonic.FIFTH;
            case AUGMENTED_SIXTH:
            case DIMINISHED_SIXTH:
            case MAJOR_SIXTH:
            case MINOR_SIXTH:
                return IntervalDiatonic.SIXTH;
            case AUGMENTED_SEVENTH:
            case DIMINISHED_SEVENTH:
            case MAJOR_SEVENTH:
            case MINOR_SEVENTH:
                return IntervalDiatonic.SEVENTH;
            case DIMINISHED_OCTAVE:
            case PERFECT_OCTAVE:
            case AUGMENTED_OCTAVE:
                return IntervalDiatonic.OCTAVE;
            case AUGMENTED_NINTH:
            case DIMINISHED_NINTH:
            case MAJOR_NINTH:
            case MINOR_NINTH:
                return IntervalDiatonic.NINTH;
            case AUGMENTED_TENTH:
            case DIMINISHED_TENTH:
            case MAJOR_TENTH:
            case MINOR_TENTH:
                return IntervalDiatonic.TENTH;
            case AUGMENTED_ELEVENTH:
            case DIMINISHED_ELEVENTH:
            case PERFECT_ELEVENTH:
                return IntervalDiatonic.ELEVENTH;
            case AUGMENTED_TWELFTH:
            case DIMINISHED_TWELFTH:
            case PERFECT_TWELFTH:
                return IntervalDiatonic.TWELFTH;
            case AUGMENTED_THIRTEENTH:
            case DIMINISHED_THIRTEENTH:
            case MAJOR_THIRTEENTH:
            case MINOR_THIRTEENTH:
                return IntervalDiatonic.THIRTEENTH;
            case AUGMENTED_FOURTEENTH:
            case DIMINISHED_FOURTEENTH:
            case MAJOR_FOURTEENTH:
            case MINOR_FOURTEENTH:
                return IntervalDiatonic.FOURTEENTH;
            case DIMINISHED_FIFTEENTH:
            case PERFECT_FIFTEENTH:
            case AUGMENTED_FIFTEENTH:
                return IntervalDiatonic.FIFTEENTH;
        }

        throw NeverHappensException.switchOf(intervalChromatic);
    }

    public String toString() {
        return "Intervalo de " + Nominator.from(this);
    }

    @Override
    public boolean isCompound() {
        return ordinal() > Diatonic.NUMBER;
    }

    public @Nullable IntervalDiatonic getNext() {
        int index = ordinal() + 1;
        if (index >= values().length)
            return null;
        return values()[index];
    }

    public @Nullable IntervalDiatonic getPrevious() {
        int index = ordinal() - 1;
        if (index < 0)
            return null;
        return values()[index];
    }
}

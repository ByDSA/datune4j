package es.danisales.datune.interval;

import es.danisales.datune.musical.Pentatonic;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum IntervalPentatonic implements Interval {
    UNISON, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH,
    OCTAVE, NINTH, TENTH, ELEVENTH, TWELFTH, THIRTEENTH, FOURTEENTH,
    FIFTEENTH;

    @Deprecated
    public static @NonNull IntervalPentatonic fromIndex(int n) {
    	n = trimToValidValue(n);

    	return IntervalPentatonic.values()[n];
    }

    private static int trimToValidValue(int n) {
        return (n < 0 ? -n : n) % (IntervalPentatonic.values().length);
    }

    @Override
    public boolean isCompound() {
        return ordinal() > Pentatonic.NUMBER;
    }
}

package es.danisales.datune.tonality;

import org.checkerframework.checker.nullness.qual.Nullable;

public enum ScaleDistance {
    HALF(1), WHOLE(2), WHOLE_HALF(3),
    FOUR(4), FIVE(5), SIX(6);

    private int value;

    ScaleDistance(int v) {
        value = v;
    }

    public int getSemitones() {
        return value;
    }

    public static @Nullable ScaleDistance from(int value) {
        switch(value) {
            case 1: return HALF;
            case 2: return WHOLE;
            case 3: return WHOLE_HALF;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
        }

        return null;
    }
}

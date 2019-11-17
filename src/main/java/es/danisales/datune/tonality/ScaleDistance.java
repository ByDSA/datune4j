package es.danisales.datune.tonality;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum ScaleDistance {
    HALF(1), WHOLE(2), WHOLE_HALF(3);

    private int value;

    ScaleDistance(int v) {
        value = v;
    }

    public int getSemitones() {
        return value;
    }

    public static @NonNull ScaleDistance from(int value) {
        switch(value) {
            case 1: return HALF;
            case 2: return WHOLE;
            case 3: return WHOLE_HALF;
        }

        throw new RuntimeException("Value invalid: " + value);
    }
}

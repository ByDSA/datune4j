package es.danisales.datune.tonality;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum ScaleDistance {
    QUARTER(0.5f), HALF(1), WHOLE(2), WHOLE_HALF(3),
    NONE(0), // para devolver nulo. no se usa para construir Scales
    TWO_WHOLE(4);

    private float value;

    ScaleDistance(float v) {
        value = v;
    }

    public int getSemitones() {
        return Math.round(value);
    }
    public float getMicrotonalSemitones() {
        return value;
    }

    public static boolean compare(float f, int i) {
        return Math.abs(f-i) < 0.01;
    }

    public static @NonNull ScaleDistance from(int value) {
        switch (value) {
            case 1: return HALF;
            case 2: return WHOLE;
            case 3: return WHOLE_HALF;
            case 0:
                return NONE;
            case 4:
                return TWO_WHOLE;
        }

        throw new RuntimeException("Value invalid: " + value);
    }

    public static @NonNull ScaleDistance fromMicrotonal(float value) {
        if (value == 0.5f)
            return QUARTER;
        else
            return from((int)value);
    }

    @Override
    public String toString() {
        return ScaleNamer.from(this);
    }
}

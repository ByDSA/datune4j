package es.danisales.datune.cultural;

import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

public class OccidentalCulture implements Cultural {
    private enum Consonance {
        I0, I12, I7, I5, I4, I8, I3, I9, I2, I10, I1, I11, I6
    }

    private static OccidentalCulture occidentalCulture;

    private OccidentalCulture() {
    }

    public static OccidentalCulture singleton() {
        if (occidentalCulture == null)
            occidentalCulture = new OccidentalCulture();
        return occidentalCulture;
    }

    @Override
    public int getIntervalConsonance(@NonNull IntervalChromatic intervalChromatic) {
        switch (intervalChromatic.getSemitones()) {
            case 0: return Consonance.I0.ordinal();
            case 1: return Consonance.I1.ordinal();
            case 2: return Consonance.I2.ordinal();
            case 3: return Consonance.I3.ordinal();
            case 4: return Consonance.I4.ordinal();
            case 5: return Consonance.I5.ordinal();
            case 6: return Consonance.I6.ordinal();
            case 7: return Consonance.I7.ordinal();
            case 8: return Consonance.I8.ordinal();
            case 9: return Consonance.I9.ordinal();
            case 10: return Consonance.I10.ordinal();
            case 11: return Consonance.I11.ordinal();
            case 12: return Consonance.I12.ordinal();
        }

        throw new RuntimeException();
    }
}

package es.danisales.datune.musical;

import static com.google.common.base.Preconditions.checkArgument;

class MusicalChecker {
    public static void semitoneIntValue(int semitoneValue) {
        checkArgument(semitoneValue >= 0 && semitoneValue <= 11);
    }
}

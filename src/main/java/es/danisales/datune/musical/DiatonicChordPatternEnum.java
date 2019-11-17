package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

enum DiatonicChordPatternEnum implements DiatonicChordPatternInterface {
    TRIAD(0, 2, 4),
    THIRD(0, 2),
    SUS2(0, 1, 4),
    SUS2_O5(0, 1),
    SUS4(0, 3, 4),
    SUS4_O5(0, 3),
    SIXTH(0, 2, 4, 5),
    SIXTH_O5(0, 2, 5),
    SEVENTH(0, 2, 4, 6),
    SEVENTH_O3(0, 4, 6),
    SEVENTH_O5(0, 2, 6),
    NINTH(0, 2, 4, 6, 8),
    NINTH_O7(0, 2, 4, 8),
    NINTH_O3_O7(0, 4, 8),
    ELEVENTH(0, 2, 4, 6, 8, 10),
    THIRTEENTH(0, 2, 4, 6, 8, 10, 12);

    private final List<Integer> pattern;

    DiatonicChordPatternEnum(Integer... patternArray) {
        pattern = Collections.unmodifiableList(
                Arrays.asList(patternArray)
        );
    }

    public static @Nullable DiatonicChordPatternEnum from(Integer... patternArray) {
        List<Integer> patternList = Arrays.asList(patternArray);
        for (DiatonicChordPatternEnum pattern : values())
            if (pattern.pattern.equals(patternList))
                return pattern;

        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return pattern.iterator();
    }

    @Override
    public List<Integer> getList() {
        return pattern;
    }
}

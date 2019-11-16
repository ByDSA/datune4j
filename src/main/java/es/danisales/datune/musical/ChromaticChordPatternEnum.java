package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

enum ChromaticChordPatternEnum implements ChromaticChordPatternInterface {
    POWER_CHORD(0, 7),
    TRIAD_MAJOR(0, 4, 7),
    TRIAD_MINOR(0, 3, 7),
    TRIAD_DIMINISHED(0, 3, 6),
    TRIAD_AUGMENTED(0, 4, 8),
    SUS4(0, 5, 7),
    SUS2(0, 2, 7),
    SEVENTH(0, 4, 7, 10),
    SEVENTH_b5(0, 4, 6, 10),
    SEVENTH_a5(0, 4, 8, 10),
    SEVENTH_SUS4(0, 5, 7, 10),
    SEVENTH_MINOR(0, 3, 7, 10),
    SEVENTH_MINOR_b5(0, 3, 6, 10),
    SEVENTH_MINOR_a5(0, 3, 8, 10),
    SIXTH(0, 4, 7, 9),
    SIXTH_MINOR(0, 3, 7, 9),
    SIXTH_SUS4(0, 5, 7, 9),
    SEVENTH_MAJ7(0, 4, 7, 11),
    SEVENTH_MINOR_MAJ7(0, 3, 7, 11),
    SIXTH_ADD9(0, 4, 7, 9, 14),
    SIXTH_MINOR_ADD9(0, 3, 7, 9, 14),
    SEVENTH_b9(0, 4, 7, 10, 13),
    SEVENTH_a9(0, 4, 7, 10, 15),
    SEVENTH_MINOR_b9(0, 3, 7, 10, 13),
    SEVENTH_ADD11(0, 4, 7, 10, 17),
    SEVENTH_ADD13(0, 4, 7, 10, 21),
    NINTH(0, 4, 7, 10, 14),
    NINTH_MINOR(0, 3, 7, 10, 14),
    NINTH_b5(0, 4, 6, 10, 14),
    NINTH_a5(0, 4, 8, 10, 14),
    NINTH_SUS4(0, 5, 7, 10, 14),
    NINTH_MAJ9(0, 4, 7, 11, 14),
    NINTH_MINOR_MAJ9(0, 3, 7, 11, 14),
    NINTH_ADD6(0, 4, 7, 9, 10, 14),
    NINTH_a11(0, 4, 7, 10, 14, 18),
    NINTH_MAJ9_a11(0, 4, 7, 11, 14, 18),
    ELEVENTH(0, 4, 7, 10, 14, 21),
    ELEVENTH_MINOR(0, 3, 7, 10, 14, 21),
    ELEVENTH_b9(0, 4, 7, 10, 13, 21),
    ELEVENTH_a9(0, 4, 7, 10, 15, 21),
    ELEVENTH_MAJ11(0, 4, 7, 11, 14, 21),
    ELEVENTH_MINOR_MAJ11(0, 3, 7, 11, 14, 21),
    THIRTEENTH_MINOR(0, 3, 7, 10, 14, 17, 21),
    THIRTEENTH_SUS4(0, 5, 7, 10, 14, 17, 21),
    THIRTEENTH_b5(0, 4, 6, 10, 14, 17, 21),
    THIRTEENTH_a5(0, 4, 8, 10, 14, 17, 21),
    THIRTEENTH_b9(0, 4, 7, 10, 13, 17, 21),
    THIRTEENTH_a9(0, 4, 7, 10, 15, 17, 21),
    THIRTEENTH_b5b9(0, 4, 6, 10, 13, 17, 21),
    THIRTEENTH_b5a9(0, 4, 6, 10, 15, 17, 21),
    THIRTEENTH_a5b9(0, 4, 8, 10, 13, 17, 21),
    THIRTEENTH_a5a9(0, 4, 8, 10, 15, 17, 21),
    THIRTEENTH_MAJ13(0, 4, 7, 11, 14, 17, 21),
    THIRTEENTH_MINOR_MAJ13(0, 3, 7, 11, 14, 17, 21),
    THIRTEENTH_MAJ13_b5(0, 4, 6, 11, 14, 17, 21),
    THIRTEENTH_MAJ13_a5(0, 4, 8, 11, 14, 17, 21),
    THIRTEENTH_MAJ13_b9(0, 4, 7, 11, 13, 17, 21),
    THIRTEENTH_MAJ13_a9(0, 4, 7, 11, 15, 17, 21),
    THIRTEENTH_MAJ13_b5b9(0, 4, 6, 11, 13, 17, 21),
    THIRTEENTH_MAJ13_b5a9(0, 4, 6, 11, 15, 17, 21),
    THIRTEENTH_MAJ13_a5b9(0, 4, 8, 11, 13, 17, 21),
    THIRTEENTH_MAJ13_a5a9(0, 4, 8, 11, 15, 17, 21),
    SUS4a4(0, 6, 7),
    SUS2b2(0, 1, 7),
    SUS2b2b5(0, 1, 6);

    private final List<Integer> pattern;

    ChromaticChordPatternEnum(Integer... patternArray) {
        pattern = Collections.unmodifiableList(
                Arrays.asList(patternArray)
        );
    }

    public static @Nullable ChromaticChordPatternEnum from(Integer... patternArray) {
        List<Integer> patternList = Arrays.asList(patternArray);
        for (ChromaticChordPatternEnum pattern : values())
            if (pattern.pattern.equals(patternList))
                return pattern;

        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return pattern.iterator();
    }

    @Override
    public List<Integer> getPattern() {
        return pattern;
    }
}

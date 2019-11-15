package es.danisales.datune.musical;

import java.util.*;

public enum ChromaticChordPattern implements Iterable<Integer> {
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
    SEVENTH_ADD11(0, 4, 7, 17),


    private final List<Integer> pattern;

    ChromaticChordPattern(Integer... patternArray) {
        pattern = Collections.unmodifiableList(
                Arrays.asList(patternArray)
        );
    }

    @Override
    public Iterator<Integer> iterator() {
        return pattern.iterator();
    }
}

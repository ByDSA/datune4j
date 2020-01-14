package es.danisales.datune.musical;

import com.google.common.collect.ImmutableMap;
import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.NoteMidi;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

@SuppressWarnings("WeakerAccess")
public final class ChromaticChordPattern extends Pattern {
    public static final ChromaticChordPattern POWER_CHORD = new ChromaticChordPattern(0, 7);
    public static final ChromaticChordPattern TRIAD_MAJOR = new ChromaticChordPattern(0, 4, 7);
    public static final ChromaticChordPattern TRIAD_MINOR = new ChromaticChordPattern(0, 3, 7);
    public static final ChromaticChordPattern TRIAD_DIMINISHED = new ChromaticChordPattern(0, 3, 6);
    public static final ChromaticChordPattern TRIAD_AUGMENTED = new ChromaticChordPattern(0, 4, 8);
    public static final ChromaticChordPattern SUS4 = new ChromaticChordPattern(0, 5, 7);
    public static final ChromaticChordPattern SEVENTH = new ChromaticChordPattern(0, 4, 7, 10);
    public static final ChromaticChordPattern SEVENTH_b5 = new ChromaticChordPattern(0, 4, 6, 10);
    public static final ChromaticChordPattern SEVENTH_a5 = new ChromaticChordPattern(0, 4, 8, 10);
    public static final ChromaticChordPattern SEVENTH_SUS4 = new ChromaticChordPattern(0, 5, 7, 10);
    public static final ChromaticChordPattern SEVENTH_MINOR = new ChromaticChordPattern(0, 3, 7, 10);
    public static final ChromaticChordPattern SEVENTH_MINOR_b5 = new ChromaticChordPattern(0, 3, 6, 10);
    public static final ChromaticChordPattern SEVENTH_MINOR_a5 = new ChromaticChordPattern(0, 3, 8, 10);
    public static final ChromaticChordPattern SIXTH = new ChromaticChordPattern(0, 4, 7, 9);
    public static final ChromaticChordPattern SIXTH_MINOR = new ChromaticChordPattern(0, 3, 7, 9);
    public static final ChromaticChordPattern SIXTH_SUS4 = new ChromaticChordPattern(0, 5, 7, 9);
    public static final ChromaticChordPattern SEVENTH_MAJ7 = new ChromaticChordPattern(0, 4, 7, 11);
    public static final ChromaticChordPattern SEVENTH_MINOR_MAJ7 = new ChromaticChordPattern(0, 3, 7, 11);
    public static final ChromaticChordPattern SIXTH_ADD9 = new ChromaticChordPattern(0, 4, 7, 9, 14);
    public static final ChromaticChordPattern SIXTH_MINOR_ADD9 = new ChromaticChordPattern(0, 3, 7, 9, 14);
    public static final ChromaticChordPattern SEVENTH_b9 = new ChromaticChordPattern(0, 4, 7, 10, 13);
    public static final ChromaticChordPattern SEVENTH_a9 = new ChromaticChordPattern(0, 4, 7, 10, 15);
    public static final ChromaticChordPattern SEVENTH_MINOR_b9 = new ChromaticChordPattern(0, 3, 7, 10, 13);
    public static final ChromaticChordPattern SEVENTH_ADD11 = new ChromaticChordPattern(0, 4, 7, 10, 17);
    public static final ChromaticChordPattern SEVENTH_ADD13 = new ChromaticChordPattern(0, 4, 7, 10, 21);
    public static final ChromaticChordPattern NINTH = new ChromaticChordPattern(0, 4, 7, 10, 14);
    public static final ChromaticChordPattern NINTH_MINOR = new ChromaticChordPattern(0, 3, 7, 10, 14);
    public static final ChromaticChordPattern NINTH_b5 = new ChromaticChordPattern(0, 4, 6, 10, 14);
    public static final ChromaticChordPattern NINTH_a5 = new ChromaticChordPattern(0, 4, 8, 10, 14);
    public static final ChromaticChordPattern NINTH_SUS4 = new ChromaticChordPattern(0, 5, 7, 10, 14);
    public static final ChromaticChordPattern NINTH_MAJ9 = new ChromaticChordPattern(0, 4, 7, 11, 14);
    public static final ChromaticChordPattern NINTH_MINOR_MAJ9 = new ChromaticChordPattern(0, 3, 7, 11, 14);
    public static final ChromaticChordPattern NINTH_ADD6 = new ChromaticChordPattern(0, 4, 7, 9, 10, 14);
    public static final ChromaticChordPattern NINTH_a11 = new ChromaticChordPattern(0, 4, 7, 10, 14, 18);
    public static final ChromaticChordPattern NINTH_MAJ9_a11 = new ChromaticChordPattern(0, 4, 7, 11, 14, 18);
    public static final ChromaticChordPattern ELEVENTH = new ChromaticChordPattern(0, 4, 7, 10, 14, 17);
    public static final ChromaticChordPattern ELEVENTH_MINOR = new ChromaticChordPattern(0, 3, 7, 10, 14, 17);
    public static final ChromaticChordPattern ELEVENTH_b9 = new ChromaticChordPattern(0, 4, 7, 10, 13, 17);
    public static final ChromaticChordPattern ELEVENTH_a9 = new ChromaticChordPattern(0, 4, 7, 10, 15, 17);
    public static final ChromaticChordPattern ELEVENTH_MAJ11 = new ChromaticChordPattern(0, 4, 7, 11, 14, 17);
    public static final ChromaticChordPattern ELEVENTH_MINOR_MAJ11 = new ChromaticChordPattern(0, 3, 7, 11, 14, 17);
    public static final ChromaticChordPattern THIRTEENTH_MINOR = new ChromaticChordPattern(0, 3, 7, 10, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_SUS4 = new ChromaticChordPattern(0, 5, 7, 10, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5 = new ChromaticChordPattern(0, 4, 6, 10, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5 = new ChromaticChordPattern(0, 4, 8, 10, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_b9 = new ChromaticChordPattern(0, 4, 7, 10, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_a9 = new ChromaticChordPattern(0, 4, 7, 10, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5b9 = new ChromaticChordPattern(0, 4, 6, 10, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5a9 = new ChromaticChordPattern(0, 4, 6, 10, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5b9 = new ChromaticChordPattern(0, 4, 8, 10, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5a9 = new ChromaticChordPattern(0, 4, 8, 10, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13 = new ChromaticChordPattern(0, 4, 7, 11, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MINOR_MAJ13 = new ChromaticChordPattern(0, 3, 7, 11, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5 = new ChromaticChordPattern(0, 4, 6, 11, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5 = new ChromaticChordPattern(0, 4, 8, 11, 14, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b9 = new ChromaticChordPattern(0, 4, 7, 11, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a9 = new ChromaticChordPattern(0, 4, 7, 11, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5b9 = new ChromaticChordPattern(0, 4, 6, 11, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5a9 = new ChromaticChordPattern(0, 4, 6, 11, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5b9 = new ChromaticChordPattern(0, 4, 8, 11, 13, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5a9 = new ChromaticChordPattern(0, 4, 8, 11, 15, 17, 21);
    public static final ChromaticChordPattern THIRTEENTH_MINOR_OMIT11 = new ChromaticChordPattern(0, 3, 7, 10, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_SUS4_OMIT11 = new ChromaticChordPattern(0, 5, 7, 10, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5_OMIT11 = new ChromaticChordPattern(0, 4, 6, 10, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5_OMIT11 = new ChromaticChordPattern(0, 4, 8, 10, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_b9_OMIT11 = new ChromaticChordPattern(0, 4, 7, 10, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_a9_OMIT11 = new ChromaticChordPattern(0, 4, 7, 10, 15, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5b9_OMIT11 = new ChromaticChordPattern(0, 4, 6, 10, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_b5a9_OMIT11 = new ChromaticChordPattern(0, 4, 6, 10, 15, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5b9_OMIT11 = new ChromaticChordPattern(0, 4, 8, 10, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_a5a9_OMIT11 = new ChromaticChordPattern(0, 4, 8, 10, 15, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_OMIT11 = new ChromaticChordPattern(0, 4, 7, 11, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_MINOR_MAJ13_OMIT11 = new ChromaticChordPattern(0, 3, 7, 11, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5_OMIT11 = new ChromaticChordPattern(0, 4, 6, 11, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5_OMIT11 = new ChromaticChordPattern(0, 4, 8, 11, 14, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b9_OMIT11 = new ChromaticChordPattern(0, 4, 7, 11, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a9_OMIT11 = new ChromaticChordPattern(0, 4, 7, 11, 15, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5b9_OMIT11 = new ChromaticChordPattern(0, 4, 6, 11, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5a9_OMIT11 = new ChromaticChordPattern(0, 4, 6, 11, 15, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5b9_OMIT11 = new ChromaticChordPattern(0, 4, 8, 11, 13, 21);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5a9_OMIT11 = new ChromaticChordPattern(0, 4, 8, 11, 15, 21);
    public static final ChromaticChordPattern SUS4a4 = new ChromaticChordPattern(0, 6, 7);
    public static final ChromaticChordPattern SUS2b2 = new ChromaticChordPattern(0, 1, 7);
    public static final ChromaticChordPattern SUS2b2b5 = new ChromaticChordPattern(0, 1, 6);
    public static final ChromaticChordPattern N6 = new ChromaticChordPattern(5, 8, 13);

    private static final Map<Integer, ChromaticChordPattern> registeredImmutables;

    static {
        ImmutableMap.Builder<Integer, ChromaticChordPattern> builder = ImmutableMap.builder();
        for (ChromaticChordPattern chromaticChordPattern : values())
            builder.put(Arrays.hashCode(chromaticChordPattern.toArray()), chromaticChordPattern);

        registeredImmutables = builder.build();
    }

    /* Immutables */

    private ChromaticChordPattern(Integer... chromaticChordPatternEnum) {
        super(chromaticChordPatternEnum);
    }

    private ChromaticChordPattern(@NonNull List<Integer> chromaticChordPattern) {
        super(chromaticChordPattern);
    }

    public static @NonNull ChromaticChordPattern immutableOf(Integer... patternArray) {
        return immutableFromIntegers(patternArray);
    }

    public static @NonNull ChromaticChordPattern immutableOf(@NonNull ChromaticChordPattern pattern) {
        if (pattern.isImmutable())
            return pattern;
        else
            return registeredImmutables.getOrDefault(
                    pattern.hashCode(),
                    new ChromaticChordPattern(pattern)
            );
    }

    private static @NonNull ChromaticChordPattern immutableFromIntegers(Integer[] patternArray) {
        return registeredImmutables.getOrDefault(
                Arrays.hashCode(patternArray),
                new ChromaticChordPattern(Arrays.asList(patternArray))
        );
    }

    private static ChromaticChordPattern[] values() {
        return new ChromaticChordPattern[]{
                POWER_CHORD,
                TRIAD_MAJOR,
                TRIAD_MINOR,
                TRIAD_DIMINISHED,
                TRIAD_AUGMENTED,
                SUS4,
                SEVENTH,
                SEVENTH_b5,
                SEVENTH_a5,
                SEVENTH_SUS4,
                SEVENTH_MINOR,
                SEVENTH_MINOR_b5,
                SEVENTH_MINOR_a5,
                SIXTH,
                SIXTH_MINOR,
                SIXTH_SUS4,
                SEVENTH_MAJ7,
                SEVENTH_MINOR_MAJ7,
                SIXTH_ADD9,
                SIXTH_MINOR_ADD9,
                SEVENTH_b9,
                SEVENTH_a9,
                SEVENTH_MINOR_b9,
                SEVENTH_ADD11,
                SEVENTH_ADD13,
                NINTH,
                NINTH_MINOR,
                NINTH_b5,
                NINTH_a5,
                NINTH_SUS4,
                NINTH_MAJ9,
                NINTH_MINOR_MAJ9,
                NINTH_ADD6,
                NINTH_a11,
                NINTH_MAJ9_a11,
                ELEVENTH,
                ELEVENTH_MINOR,
                ELEVENTH_b9,
                ELEVENTH_a9,
                ELEVENTH_MAJ11,
                ELEVENTH_MINOR_MAJ11,
                THIRTEENTH_MINOR,
                THIRTEENTH_SUS4,
                THIRTEENTH_b5,
                THIRTEENTH_a5,
                THIRTEENTH_b9,
                THIRTEENTH_a9,
                THIRTEENTH_b5b9,
                THIRTEENTH_b5a9,
                THIRTEENTH_a5b9,
                THIRTEENTH_a5a9,
                THIRTEENTH_MAJ13,
                THIRTEENTH_MINOR_MAJ13,
                THIRTEENTH_MAJ13_b5,
                THIRTEENTH_MAJ13_a5,
                THIRTEENTH_MAJ13_b9,
                THIRTEENTH_MAJ13_a9,
                THIRTEENTH_MAJ13_b5b9,
                THIRTEENTH_MAJ13_b5a9,
                THIRTEENTH_MAJ13_a5b9,
                THIRTEENTH_MAJ13_a5a9,
                THIRTEENTH_MINOR_OMIT11,
                THIRTEENTH_SUS4_OMIT11,
                THIRTEENTH_b5_OMIT11,
                THIRTEENTH_a5_OMIT11,
                THIRTEENTH_b9_OMIT11,
                THIRTEENTH_a9_OMIT11,
                THIRTEENTH_b5b9_OMIT11,
                THIRTEENTH_b5a9_OMIT11,
                THIRTEENTH_a5b9_OMIT11,
                THIRTEENTH_a5a9_OMIT11,
                THIRTEENTH_MAJ13_OMIT11,
                THIRTEENTH_MINOR_MAJ13_OMIT11,
                THIRTEENTH_MAJ13_b5_OMIT11,
                THIRTEENTH_MAJ13_a5_OMIT11,
                THIRTEENTH_MAJ13_b9_OMIT11,
                THIRTEENTH_MAJ13_a9_OMIT11,
                THIRTEENTH_MAJ13_b5b9_OMIT11,
                THIRTEENTH_MAJ13_b5a9_OMIT11,
                THIRTEENTH_MAJ13_a5b9_OMIT11,
                THIRTEENTH_MAJ13_a5a9_OMIT11,
                SUS4a4,
                SUS2b2,
                SUS2b2b5,
                N6
        };
    }

    /* Mutables */

    private ChromaticChordPattern() {
        super();
    }

    public static @NonNull ChromaticChordPattern from(Integer... patternArray) {
        ChromaticChordPattern chromaticChordPattern = new ChromaticChordPattern();
        chromaticChordPattern.addAll(Arrays.asList(patternArray));
        return chromaticChordPattern;
    }

    public static @NonNull ChromaticChordPattern from(List<Chromatic> collection) {
        checkArgument(!collection.isEmpty());

        Integer[] patternArray = new Integer[collection.size()];
        patternArray[0] = 0;
        for (int i = 1; i < collection.size(); i++) {
            Chromatic last = collection.get(i - 1);
            Chromatic current = collection.get(i);
            patternArray[i] = patternArray[i - 1] + last.distSemitonesTo(current);
        }

        return from(patternArray);
    }

    public static @NonNull ChromaticChordPattern from(ChromaticChord chromaticChordBase) {
        checkArgument(!chromaticChordBase.isEmpty());

        if (chromaticChordBase.getRootIndex() != 0) {
            chromaticChordBase = chromaticChordBase.clone();
            chromaticChordBase.toFundamental();
        }

        return from((List<Chromatic>) chromaticChordBase);
    }

    public static <N extends NoteMidi<?>> @NonNull ChromaticChordPattern from(@NonNull ChordMidi<N, ?, ?> chordMidi) {
        checkArgument(!chordMidi.isEmpty());

        Integer[] integerPitchMidiArray = new Integer[chordMidi.size()];
        integerPitchMidiArray[0] = 0;
        int firstCode = chordMidi.get(0).getPitch().getMidiCode();
        for (int i = 0; i < chordMidi.size(); i++) {

            int code = chordMidi.get(i).getPitch().getMidiCode();
            integerPitchMidiArray[i] = code - firstCode;
        }

        return immutableFromIntegers(integerPitchMidiArray);
    }

    /* Object */

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof ChromaticChordPattern) )
            return false;

        ChromaticChordPattern otherCasted = (ChromaticChordPattern) o;

        return super.equals(otherCasted);
    }

    @Override
    public DiatonicChordPattern clone() {
        return (DiatonicChordPattern) super.clone();
    }
}

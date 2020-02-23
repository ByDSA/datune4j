package es.danisales.datune.chords.chromatic;

import com.google.common.collect.ImmutableMap;
import es.danisales.datune.chords.Pattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.lang.ChordNotation;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

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

    /* Object */

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof ChromaticChordPattern) )
            return false;

        ChromaticChordPattern otherCasted = (ChromaticChordPattern) o;

        return super.equals(otherCasted);
    }

    @Override
    public ChromaticChordPattern clone() {
        return (ChromaticChordPattern) super.clone();
    }

    @Override
    public String toString() {
        String str = stringMap.get(this);

        if (str == null)
            return super.toString();

        return str;
    }

    private static final Map<ChromaticChordPattern, String> stringMap = new ImmutableMap.Builder<ChromaticChordPattern, String>()
            .put(ChromaticChordPattern.TRIAD_MAJOR, "MAJOR")
            .put(ChromaticChordPattern.TRIAD_MINOR, "MINOR")
            .put(ChromaticChordPattern.TRIAD_DIMINISHED, "DIMINISHED")
            .put(ChromaticChordPattern.TRIAD_AUGMENTED, "AUGMENTED")
            .put(ChromaticChordPattern.SUS4, "SUS4")
            .put(ChromaticChordPattern.POWER_CHORD, "POWER CHORD")
            .put(ChromaticChordPattern.SEVENTH, "SEVENTH")
            .build();

    public @Nullable String getSuffix() {
        String str = suffixMap.get(this);

        if (str == null)
            return super.toString();

        return str;
    }

    private static final Map<ChromaticChordPattern, String> suffixMap = new ImmutableMap.Builder<ChromaticChordPattern, String>()
            .put(POWER_CHORD, ChordNotation.POWER_CHORD)
            .put(TRIAD_MAJOR, ChordNotation.MAJOR)
            .put(TRIAD_MINOR, ChordNotation.MINOR)
            .put(TRIAD_DIMINISHED, ChordNotation.DIMINISHED)
            .put(TRIAD_AUGMENTED, ChordNotation.AUGMENTED)
            .put(SUS4, ChordNotation.SUS4)
            .put(SEVENTH, ChordNotation.SEVENTH)
            .put(SEVENTH_MAJ7, ChordNotation.MAJOR2 + ChordNotation.SEVENTH)
            .put(SEVENTH_MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH)
            .put(SEVENTH_b5, ChordNotation.SEVENTH + ChordNotation.b5)
            .put(SEVENTH_MINOR_MAJ7, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.SEVENTH)
            .put(SEVENTH_a5, ChordNotation.SEVENTH + ChordNotation.a5)
            .put(SEVENTH_MINOR_a5, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.a5)
            .put(SEVENTH_SUS4, ChordNotation.SEVENTH + ChordNotation.SUS4)
            .put(SEVENTH_MINOR_b5, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b5)
            .put(SEVENTH_ADD11, ChordNotation.SEVENTH + ChordNotation.ADD_ELEVENTH)
            .put(SEVENTH_ADD13, ChordNotation.SEVENTH + ChordNotation.ADD_THIRTEEN)
            .put(SUS4a4, ChordNotation.SUSa4)
            .put(SUS2b2, ChordNotation.SUSb2)
            .put(SUS2b2b5, ChordNotation.SUSb2b5)
            .put(SEVENTH_b9, ChordNotation.SEVENTH + ChordNotation.b9)
            .put(SEVENTH_a9, ChordNotation.SEVENTH + ChordNotation.a9)
            .put(SEVENTH_MINOR_b9, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b9)
            .put(NINTH, ChordNotation.NINTH)
            .put(NINTH_MINOR, ChordNotation.MINOR2 + ChordNotation.NINTH)
            .put(NINTH_b5, ChordNotation.NINTH + ChordNotation.b5)
            .put(NINTH_a5, ChordNotation.NINTH + ChordNotation.a5)
            .put(NINTH_SUS4, ChordNotation.NINTH + ChordNotation.SUS4)
            .put(NINTH_MAJ9, ChordNotation.MAJOR2 + ChordNotation.NINTH)
            .put(NINTH_MINOR_MAJ9, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.NINTH)
            .put(NINTH_ADD6, ChordNotation.NINTH + ChordNotation.ADD_SIXTH)
            .put(NINTH_a11, ChordNotation.NINTH + ChordNotation.a11)
            .put(NINTH_MAJ9_a11, ChordNotation.MAJOR2 + ChordNotation.NINTH + ChordNotation.a11)
            .put(SIXTH, ChordNotation.SIXTH)
            .put(SIXTH_MINOR, ChordNotation.MINOR2 + ChordNotation.SIXTH)
            .put(SIXTH_SUS4, ChordNotation.SIXTH + ChordNotation.SUS4)
            .put(SIXTH_ADD9, ChordNotation.SIXTH + ChordNotation.ADD_NINTH)
            .put(SIXTH_MINOR_ADD9, ChordNotation.MINOR2 + ChordNotation.SIXTH + ChordNotation.ADD_NINTH)
            .put(ELEVENTH, ChordNotation.ELEVENTH)
            .put(ELEVENTH_MINOR, ChordNotation.MINOR2 + ChordNotation.ELEVENTH)
            .put(ELEVENTH_b9, ChordNotation.ELEVENTH + ChordNotation.b9)
            .put(ELEVENTH_a9, ChordNotation.ELEVENTH + ChordNotation.a9)
            .put(ELEVENTH_MAJ11, ChordNotation.MAJOR2 + ChordNotation.ELEVENTH)
            .put(ELEVENTH_MINOR_MAJ11, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.ELEVENTH)
            .put(THIRTEENTH_MINOR, ChordNotation.MINOR2 + ChordNotation.THIRTEEN)
            .put(THIRTEENTH_SUS4, ChordNotation.THIRTEEN + ChordNotation.SUS4)
            .put(THIRTEENTH_b5, ChordNotation.THIRTEEN + ChordNotation.b5)
            .put(THIRTEENTH_a5, ChordNotation.THIRTEEN + ChordNotation.a5)
            .put(THIRTEENTH_b9, ChordNotation.THIRTEEN + ChordNotation.b9)
            .put(THIRTEENTH_a9, ChordNotation.THIRTEEN + ChordNotation.a9)
            .put(THIRTEENTH_b5b9, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9)
            .put(THIRTEENTH_b5a9, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9)
            .put(THIRTEENTH_a5b9, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9)
            .put(THIRTEENTH_a5a9, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9)
            .put(THIRTEENTH_MAJ13, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN)
            .put(THIRTEENTH_MINOR_MAJ13, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN)
            .put(THIRTEENTH_MAJ13_b5, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5)
            .put(THIRTEENTH_MAJ13_a5, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5)
            .put(THIRTEENTH_MAJ13_b9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9)
            .put(THIRTEENTH_MAJ13_a9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9)
            .put(THIRTEENTH_MAJ13_b5b9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9)
            .put(THIRTEENTH_MAJ13_b5a9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9)
            .put(THIRTEENTH_MAJ13_a5b9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9)

            .put(THIRTEENTH_MAJ13_a5a9, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9)

            .put(THIRTEENTH_MINOR_OMIT11, ChordNotation.MINOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11)
            .put(THIRTEENTH_SUS4_OMIT11, ChordNotation.THIRTEEN + ChordNotation.SUS4 + ChordNotation.OMIT11)
            .put(THIRTEENTH_b5_OMIT11, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.OMIT11)
            .put(THIRTEENTH_a5_OMIT11, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.OMIT11)
            .put(THIRTEENTH_b9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_a9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.a9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_b5b9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_b5a9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_a5b9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_a5a9_OMIT11, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11)
            .put(THIRTEENTH_MINOR_MAJ13_OMIT11, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_b5_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_a5_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_b9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_a9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_b5b9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_b5a9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_a5b9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9 + ChordNotation.OMIT11)
            .put(THIRTEENTH_MAJ13_a5a9_OMIT11, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9 + ChordNotation.OMIT11)
            .build();


}

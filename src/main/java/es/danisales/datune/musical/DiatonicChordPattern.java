package es.danisales.datune.musical;

import com.google.common.collect.ImmutableMap;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.function.DiatonicFunction;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public final class DiatonicChordPattern extends Pattern {
    public static final DiatonicChordPattern TRIAD = new DiatonicChordPattern(0, 2, 4);
    public static final DiatonicChordPattern THIRD = new DiatonicChordPattern(0, 2);
    public static final DiatonicChordPattern SECOND = new DiatonicChordPattern(0, 1);
    public static final DiatonicChordPattern FOURTH = new DiatonicChordPattern(0, 3);
    public static final DiatonicChordPattern SIXTH = new DiatonicChordPattern(0, 2, 4, 5);
    public static final DiatonicChordPattern SIXTH_O5 = new DiatonicChordPattern(0, 2, 5);
    public static final DiatonicChordPattern SEVENTH = new DiatonicChordPattern(0, 2, 4, 6);
    public static final DiatonicChordPattern SEVENTH_O3 = new DiatonicChordPattern(0, 4, 6);
    public static final DiatonicChordPattern SEVENTH_O5 = new DiatonicChordPattern(0, 2, 6);
    public static final DiatonicChordPattern NINTH = new DiatonicChordPattern(0, 2, 4, 6, 8);
    public static final DiatonicChordPattern NINTH_O7 = new DiatonicChordPattern(0, 2, 4, 8);
    public static final DiatonicChordPattern NINTH_O3_O7 = new DiatonicChordPattern(0, 4, 8);
    public static final DiatonicChordPattern ELEVENTH = new DiatonicChordPattern(0, 2, 4, 6, 8, 10);
    public static final DiatonicChordPattern THIRTEENTH = new DiatonicChordPattern(0, 2, 4, 6, 8, 10, 12);

    private static final Map<Integer, DiatonicChordPattern> registeredImmutables;

    static {
        ImmutableMap.Builder<Integer, DiatonicChordPattern> builder = ImmutableMap.builder();
        for (DiatonicChordPattern diatonicChordPattern : values())
            builder.put(Arrays.hashCode(diatonicChordPattern.toArray()), diatonicChordPattern);

        registeredImmutables = builder.build();
    }

    /* Immutable */

    private DiatonicChordPattern(Integer... patternInterface) {
        super(patternInterface);
    }

    private DiatonicChordPattern(@NonNull List<Integer> diatonicChordPattern) {
        super(diatonicChordPattern);
    }

    public static @NonNull DiatonicChordPattern immutableOf(Integer... patternArray) {
        return immutableFromIntegers(patternArray);
    }

    public static @NonNull DiatonicChordPattern immutableOf(@NonNull DiatonicChordPattern pattern) {
        if (pattern.isImmutable())
            return pattern;
        else
            return registeredImmutables.getOrDefault(
                    pattern.hashCode(),
                    new DiatonicChordPattern(pattern)
            );
    }

    private static @NonNull DiatonicChordPattern immutableFromIntegers(Integer[] patternArray) {
        return registeredImmutables.getOrDefault(
                Arrays.hashCode(patternArray),
                new DiatonicChordPattern(Arrays.asList(patternArray))
        );
    }

    private static DiatonicChordPattern[] values() {
        return new DiatonicChordPattern[]{
                TRIAD,
                THIRD,
                SIXTH,
                SIXTH_O5,
                SEVENTH,
                SEVENTH_O3,
                SEVENTH_O5,
                NINTH,
                NINTH_O7,
                NINTH_O3_O7,
                ELEVENTH,
                THIRTEENTH
        };
    }

    /* Mutable */

    private DiatonicChordPattern() {
        super();
    }

    public static @NonNull DiatonicChordPattern from(Integer... patternArray) {
        DiatonicChordPattern diatonicChordPattern = new DiatonicChordPattern();
        diatonicChordPattern.addAll(Arrays.asList(patternArray));
        return diatonicChordPattern;
    }

    public static @NonNull DiatonicChordPattern from(List<Diatonic> collection) {
        checkArgument(!collection.isEmpty());

        Integer[] patternArray = new Integer[collection.size()];
        patternArray[0] = 0;
        for (int i = 1; i < collection.size(); i++) {
            Diatonic last = collection.get(i - 1);
            Diatonic current = collection.get(i);
            patternArray[i] = patternArray[i - 1] + last.dist(current).ordinal();
        }

        return from(patternArray);
    }

    public static @NonNull DiatonicChordPattern from(DiatonicChord chromaticChordBase) {
        checkArgument(!chromaticChordBase.isEmpty());

        if (chromaticChordBase.getRootIndex() != 0) {
            chromaticChordBase = chromaticChordBase.clone();
            chromaticChordBase.toFundamental();
        }

        return from((List<Diatonic>) chromaticChordBase);
    }

    public static @NonNull DiatonicChordPattern from(@NonNull DiatonicFunction diatonicFunction) {
        return DiatonicChordInterfaceAdapter.patternFrom(diatonicFunction);
    }

    /* Object */

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicChordPattern) )
            return false;

        DiatonicChordPattern otherCasted = (DiatonicChordPattern) o;

        return super.equals(otherCasted);
    }

    @Override
    public DiatonicChordPattern clone() {
        return (DiatonicChordPattern) super.clone();
    }
}

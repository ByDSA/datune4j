package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;

public final class DiatonicChordPattern extends Pattern {
    public static final DiatonicChordPattern TRIAD = new DiatonicChordPattern(0, 2, 4);
    public static final DiatonicChordPattern THIRD = new DiatonicChordPattern(0, 2);
    public static final DiatonicChordPattern SUS2 = new DiatonicChordPattern(0, 1, 4);
    public static final DiatonicChordPattern SUS2_O5 = new DiatonicChordPattern(0, 1);
    public static final DiatonicChordPattern SUS4 = new DiatonicChordPattern(0, 3, 4);
    public static final DiatonicChordPattern SUS4_O5 = new DiatonicChordPattern(0, 3);
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

    private DiatonicChordPattern(Integer... patternInterface) {
        super(patternInterface);
    }

    private DiatonicChordPattern() {
        super();
    }

    public static DiatonicChordPattern from(Integer... patternArray) {
        DiatonicChordPattern inner = fromValues(patternArray);
        if (inner == null) {
            inner = new DiatonicChordPattern();
            inner.addAll(Arrays.asList(patternArray));
        }

        return inner;
    }

    private static @Nullable DiatonicChordPattern fromValues(Integer[] patternArray) {
        List<Integer> patternList = Arrays.asList(patternArray);
        for (DiatonicChordPattern v : values()) {
            if (v.numbersPattern.equals(patternList))
                return v;
        }

        return null;
    }

    private static DiatonicChordPattern[] values() {
        return new DiatonicChordPattern[]{
                TRIAD,
                THIRD,
                SUS2,
                SUS2_O5,
                SUS4,
                SUS4_O5,
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

    private static DiatonicChordPattern fromFirst(List<Diatonic> collection) {
        Integer[] patternArray = new Integer[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            if (i == 0)
                patternArray[0] = 0;
            else {
                Diatonic last = collection.get(i-1);
                Diatonic current = collection.get(i);
                patternArray[i] = patternArray[i-1] + last.dist(current).ordinal();
            }
        }

        return from(patternArray);
    }

    public static DiatonicChordPattern from(DiatonicChord diatonicChord) {
        if ( diatonicChord.getRootPos() == 0 )
            return fromFirst(diatonicChord);
        else {
            DiatonicChord chromaticChord = diatonicChord.clone();
            chromaticChord.inv(chromaticChord.getRootPos());
            return fromFirst(chromaticChord);
        }
    }

    public static @NonNull DiatonicChordPattern from(@NonNull DiatonicFunction f) {
        return DiatonicChordInterfaceAdapter.from(f);
    }

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

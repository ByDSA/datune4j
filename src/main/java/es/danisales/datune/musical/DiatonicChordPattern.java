package es.danisales.datune.musical;

import java.util.List;

public class DiatonicChordPattern extends Pattern<DiatonicChordPatternInterface> {
    public static final DiatonicChordPattern TRIAD = new DiatonicChordPattern(DiatonicChordPatternEnum.TRIAD);
    public static final DiatonicChordPattern THIRD = new DiatonicChordPattern(DiatonicChordPatternEnum.THIRD);
    public static final DiatonicChordPattern SUS2 = new DiatonicChordPattern(DiatonicChordPatternEnum.SUS2);
    public static final DiatonicChordPattern SUS2_O5 = new DiatonicChordPattern(DiatonicChordPatternEnum.SUS2_O5);
    public static final DiatonicChordPattern SUS4 = new DiatonicChordPattern(DiatonicChordPatternEnum.SUS4);
    public static final DiatonicChordPattern SUS4_O5 = new DiatonicChordPattern(DiatonicChordPatternEnum.SUS4_O5);
    public static final DiatonicChordPattern SIXTH = new DiatonicChordPattern(DiatonicChordPatternEnum.SIXTH);
    public static final DiatonicChordPattern SIXTH_O5 = new DiatonicChordPattern(DiatonicChordPatternEnum.SIXTH_O5);
    public static final DiatonicChordPattern SEVENTH = new DiatonicChordPattern(DiatonicChordPatternEnum.SEVENTH);
    public static final DiatonicChordPattern SEVENTH_O3 = new DiatonicChordPattern(DiatonicChordPatternEnum.SEVENTH_O3);
    public static final DiatonicChordPattern SEVENTH_O5 = new DiatonicChordPattern(DiatonicChordPatternEnum.SEVENTH_O5);
    public static final DiatonicChordPattern NINTH = new DiatonicChordPattern(DiatonicChordPatternEnum.NINTH);
    public static final DiatonicChordPattern NINTH_O7 = new DiatonicChordPattern(DiatonicChordPatternEnum.NINTH_O7);
    public static final DiatonicChordPattern NINTH_O3_O7 = new DiatonicChordPattern(DiatonicChordPatternEnum.NINTH_O3_O7);
    public static final DiatonicChordPattern ELEVENTH = new DiatonicChordPattern(DiatonicChordPatternEnum.ELEVENTH);
    public static final DiatonicChordPattern THIRTEENTH = new DiatonicChordPattern(DiatonicChordPatternEnum.THIRTEENTH);

    private DiatonicChordPattern(DiatonicChordPatternInterface patternInterface) {
        super(patternInterface);
    }

    public static DiatonicChordPattern from(Integer... patternArray) {
        DiatonicChordPatternInterface inner = DiatonicChordPatternEnum.from(patternArray);
        if (inner == null)
            inner = DiatonicChordPatternCustom.from(patternArray);

        return new DiatonicChordPattern(inner);
    }

    public static DiatonicChordPattern from(List<Diatonic> collection) {
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
            return from((List<Diatonic>)diatonicChord);
        else {
            DiatonicChord chromaticChord = diatonicChord.duplicate();
            chromaticChord.inv(chromaticChord.getRootPos());
            return from((List<Diatonic>)chromaticChord);
        }
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof DiatonicChordPattern) )
            return false;

        DiatonicChordPattern otherCasted = (DiatonicChordPattern) o;

        return innerPattern.getList().equals(otherCasted.innerPattern.getList());
    }
}

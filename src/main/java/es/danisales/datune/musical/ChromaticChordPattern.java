package es.danisales.datune.musical;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ChromaticChordPattern extends Pattern<ChromaticChordPatternInterface> {
    public static final ChromaticChordPattern POWER_CHORD = new ChromaticChordPattern(ChromaticChordPatternEnum.POWER_CHORD);
    public static final ChromaticChordPattern TRIAD_MAJOR = new ChromaticChordPattern(ChromaticChordPatternEnum.TRIAD_MAJOR);
    public static final ChromaticChordPattern TRIAD_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.TRIAD_MINOR);
    public static final ChromaticChordPattern TRIAD_DIMINISHED = new ChromaticChordPattern(ChromaticChordPatternEnum.TRIAD_DIMINISHED);
    public static final ChromaticChordPattern TRIAD_AUGMENTED = new ChromaticChordPattern(ChromaticChordPatternEnum.TRIAD_AUGMENTED);
    public static final ChromaticChordPattern SUS4 = new ChromaticChordPattern(ChromaticChordPatternEnum.SUS4);
    public static final ChromaticChordPattern SUS2 = new ChromaticChordPattern(ChromaticChordPatternEnum.SUS2);
    public static final ChromaticChordPattern SEVENTH = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH);
    public static final ChromaticChordPattern SEVENTH_b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_b5);
    public static final ChromaticChordPattern SEVENTH_a5 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_a5);
    public static final ChromaticChordPattern SEVENTH_SUS4 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_SUS4);
    public static final ChromaticChordPattern SEVENTH_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MINOR);
    public static final ChromaticChordPattern SEVENTH_MINOR_b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MINOR_b5);
    public static final ChromaticChordPattern SEVENTH_MINOR_a5 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MINOR_a5);
    public static final ChromaticChordPattern SIXTH = new ChromaticChordPattern(ChromaticChordPatternEnum.SIXTH);
    public static final ChromaticChordPattern SIXTH_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.SIXTH_MINOR);
    public static final ChromaticChordPattern SIXTH_SUS4 = new ChromaticChordPattern(ChromaticChordPatternEnum.SIXTH_SUS4);
    public static final ChromaticChordPattern SEVENTH_MAJ7 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MAJ7);
    public static final ChromaticChordPattern SEVENTH_MINOR_MAJ7 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MINOR_MAJ7);
    public static final ChromaticChordPattern SIXTH_ADD9 = new ChromaticChordPattern(ChromaticChordPatternEnum.SIXTH_ADD9);
    public static final ChromaticChordPattern SIXTH_MINOR_ADD9 = new ChromaticChordPattern(ChromaticChordPatternEnum.SIXTH_MINOR_ADD9);
    public static final ChromaticChordPattern SEVENTH_b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_b9);
    public static final ChromaticChordPattern SEVENTH_a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_a9);
    public static final ChromaticChordPattern SEVENTH_MINOR_b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_MINOR_b9);
    public static final ChromaticChordPattern SEVENTH_ADD11 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_ADD11);
    public static final ChromaticChordPattern SEVENTH_ADD13 = new ChromaticChordPattern(ChromaticChordPatternEnum.SEVENTH_ADD13);
    public static final ChromaticChordPattern NINTH = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH);
    public static final ChromaticChordPattern NINTH_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_MINOR);
    public static final ChromaticChordPattern NINTH_b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_b5);
    public static final ChromaticChordPattern NINTH_a5 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_a5);
    public static final ChromaticChordPattern NINTH_SUS4 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_SUS4);
    public static final ChromaticChordPattern NINTH_MAJ9 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_MAJ9);
    public static final ChromaticChordPattern NINTH_MINOR_MAJ9 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_MINOR_MAJ9);
    public static final ChromaticChordPattern NINTH_ADD6 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_ADD6);
    public static final ChromaticChordPattern NINTH_a11 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_a11);
    public static final ChromaticChordPattern NINTH_MAJ9_a11 = new ChromaticChordPattern(ChromaticChordPatternEnum.NINTH_MAJ9_a11);
    public static final ChromaticChordPattern ELEVENTH = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH);
    public static final ChromaticChordPattern ELEVENTH_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH_MINOR);
    public static final ChromaticChordPattern ELEVENTH_b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH_b9);
    public static final ChromaticChordPattern ELEVENTH_a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH_a9);
    public static final ChromaticChordPattern ELEVENTH_MAJ11 = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH_MAJ11);
    public static final ChromaticChordPattern ELEVENTH_MINOR_MAJ11 = new ChromaticChordPattern(ChromaticChordPatternEnum.ELEVENTH_MINOR_MAJ11);
    public static final ChromaticChordPattern THIRTEENTH_MINOR = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MINOR);
    public static final ChromaticChordPattern THIRTEENTH_SUS4 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_SUS4);
    public static final ChromaticChordPattern THIRTEENTH_b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5);
    public static final ChromaticChordPattern THIRTEENTH_a5 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5);
    public static final ChromaticChordPattern THIRTEENTH_b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b9);
    public static final ChromaticChordPattern THIRTEENTH_a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a9);
    public static final ChromaticChordPattern THIRTEENTH_b5b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5b9);
    public static final ChromaticChordPattern THIRTEENTH_b5a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5a9);
    public static final ChromaticChordPattern THIRTEENTH_a5b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5b9);
    public static final ChromaticChordPattern THIRTEENTH_a5a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5a9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13);
    public static final ChromaticChordPattern THIRTEENTH_MINOR_MAJ13 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MINOR_MAJ13);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5b9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5a9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5b9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5b9);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5a9 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5a9);

    public static final ChromaticChordPattern THIRTEENTH_MINOR_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MINOR_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_SUS4_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_SUS4_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_b5_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_a5_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_b5b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_b5a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_b5a9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_a5b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_a5a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_a5a9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MINOR_MAJ13_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MINOR_MAJ13_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_b5a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_b5a9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5b9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5b9_OMIT11);
    public static final ChromaticChordPattern THIRTEENTH_MAJ13_a5a9_OMIT11 = new ChromaticChordPattern(ChromaticChordPatternEnum.THIRTEENTH_MAJ13_a5a9_OMIT11);

    public static final ChromaticChordPattern SUS4a4 = new ChromaticChordPattern(ChromaticChordPatternEnum.SUS4a4);
    public static final ChromaticChordPattern SUS2b2 = new ChromaticChordPattern(ChromaticChordPatternEnum.SUS2b2);
    public static final ChromaticChordPattern SUS2b2b5 = new ChromaticChordPattern(ChromaticChordPatternEnum.SUS2b2b5);
    public static final ChromaticChordPattern N6 = new ChromaticChordPattern(ChromaticChordPatternEnum.N6);

    private ChromaticChordPattern(ChromaticChordPatternInterface chromaticChordPatternEnum) {
        super(chromaticChordPatternEnum);
    }

    public static ChromaticChordPattern from(Integer... patternArray) {
        ChromaticChordPatternInterface inner = ChromaticChordPatternEnum.from(patternArray);
        if (inner == null)
            inner = ChromaticChordPatternCustom.from(patternArray);

        return new ChromaticChordPattern(inner);
    }

    public static ChromaticChordPattern from(List<Chromatic> collection) {
        Integer[] patternArray = new Integer[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            if (i == 0)
                patternArray[0] = 0;
            else {
                Chromatic last = collection.get(i-1);
                Chromatic current = collection.get(i);
                patternArray[i] = patternArray[i-1] + last.distSemitonesTo(current);
            }
        }

        return from(patternArray);
    }

    public static ChromaticChordPattern from(ChromaticChord chromaticChordBase) {
        if ( chromaticChordBase.getRootPos() == 0 )
            return from((List<Chromatic>)chromaticChordBase);
        else {
            ChromaticChord chromaticChord = chromaticChordBase.duplicate();
            chromaticChord.inv(chromaticChord.getRootPos());
            return from((List<Chromatic>)chromaticChord);
        }
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof ChromaticChordPattern) )
            return false;

        ChromaticChordPattern otherCasted = (ChromaticChordPattern) o;

        return innerPattern.getList().equals(otherCasted.innerPattern.getList());
    }
}

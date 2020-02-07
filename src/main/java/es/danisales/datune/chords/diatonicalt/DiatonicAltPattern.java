package es.danisales.datune.chords.diatonicalt;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.octave.DiatonicAlt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiatonicAltPattern extends ArrayList<DiatonicAltRelative> {
    public static final DiatonicAltPattern MAJOR_TRIAD = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5)
    );

    public static final DiatonicAltPattern MINOR_TRIAD = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5)
    );

    public static final DiatonicAltPattern AUGMENTED_TRIAD = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5, 1)
    );

    public static final DiatonicAltPattern DIMINISHED_TRIAD = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5, -1)
    );

    public static final DiatonicAltPattern MAJOR_SIXTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5),
            DiatonicAltRelative.from(6)
    );

    public static final DiatonicAltPattern MINOR_SIXTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5),
            DiatonicAltRelative.from(6)
    );

    public static final DiatonicAltPattern MAJ7_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5),
            DiatonicAltRelative.from(7)
    );

    public static final DiatonicAltPattern MINOR_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5),
            DiatonicAltRelative.from(7, -1)
    );

    public static final DiatonicAltPattern m7b5_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5, -1),
            DiatonicAltRelative.from(7, -1)
    );

    public static final DiatonicAltPattern DOMINANT_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5),
            DiatonicAltRelative.from(7, -1)
    );

    public static final DiatonicAltPattern DOMINANT_a5_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3),
            DiatonicAltRelative.from(5, 1),
            DiatonicAltRelative.from(7, -1)
    );

    public static final DiatonicAltPattern DIMINISHED_SEVENTH = new DiatonicAltPattern(
            DiatonicAltRelative.from(1),
            DiatonicAltRelative.from(3, -1),
            DiatonicAltRelative.from(5, -1),
            DiatonicAltRelative.from(7, -2)
    );

    private DiatonicAltPattern(DiatonicAltRelative... diatonicAltRelatives) {
        this(Arrays.asList(diatonicAltRelatives));
    }

    private DiatonicAltPattern(List<DiatonicAltRelative> list) {
        this.addAll(list);
    }

    public static DiatonicAltPattern from(DiatonicAlt... diatonicAlts) {
        return new DiatonicAltPattern(diatonicAlt2List(diatonicAlts));
    }

    private static List<DiatonicAltRelative> diatonicAlt2List(DiatonicAlt... diatonicAlts) {
        List<DiatonicAltRelative> ret = new ArrayList<>();

        DiatonicAltRelative previous = null;
        int firstOrdinal = diatonicAlts[0].getDiatonic().ordinal() - 1;
        for (DiatonicAlt diatonicAlt : diatonicAlts) {
            int diatonicNumber = diatonicAlt.getDiatonic().ordinal() - firstOrdinal;
            if (previous != null && diatonicNumber <= previous.getDiatonicNumber())
                diatonicNumber += Diatonic.NUMBER;
            DiatonicAltRelative diatonicAltRelative = DiatonicAltRelative.from(diatonicNumber, diatonicAlt.getSemitonesAdded());
            ret.add(diatonicAltRelative);
            previous = diatonicAltRelative;
        }

        return ret;
    }
}

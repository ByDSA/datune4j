package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Objects;

class DiatonicChordInterfaceAdapter {
    private DiatonicChordInterfaceAdapter() {
    }

    public static @NonNull DiatonicChordInterface from(@NonNull Collection<Diatonic> diatonicChord) {
        Objects.requireNonNull(diatonicChord);

        DiatonicChordInterface ret = DiatonicChordImmutable.from(diatonicChord);
        if (ret == null) {
            ret = new DiatonicChordMutable();
            ret.addAll(diatonicChord);
            if (diatonicChord instanceof DiatonicChordMutable) {
                DiatonicChordMutable retCustom = (DiatonicChordMutable) ret;
                DiatonicChordMutable inCustom = (DiatonicChordMutable) diatonicChord;
                retCustom.setRootIndex(inCustom.getRootIndex());
            }
        }

        return ret;
    }

    static DiatonicChordPattern patternFrom(@NonNull DiatonicFunction diatonicFunction) {
        Objects.requireNonNull(diatonicFunction);

        switch (diatonicFunction) {
            case I:
            case II:
            case III:
            case IV:
            case V:
            case VI:
            case VII:
                return DiatonicChordPattern.TRIAD;

            case I7:
            case II7:
            case III7:
            case IV7:
            case V7:
            case VI7:
            case VII7:
                return DiatonicChordPattern.SEVENTH;

            case I6:
            case II6:
            case III6:
            case IV6:
            case V6:
            case VI6:
            case VII6:
                return DiatonicChordPattern.SIXTH;

            case I9:
            case II9:
            case III9:
            case IV9:
            case V9:
            case VI9:
            case VII9:
                return DiatonicChordPattern.NINTH;

            case I11:
            case II11:
            case III11:
            case IV11:
            case V11:
            case VI11:
            case VII11:
                return DiatonicChordPattern.ELEVENTH;

            case I13:
            case II13:
            case III13:
            case IV13:
            case V13:
            case VI13:
            case VII13:
                return DiatonicChordPattern.THIRTEENTH;

            case I_SECOND:
            case II_SECOND:
            case III_SECOND:
            case IV_SECOND:
            case V_SECOND:
            case VI_SECOND:
            case VII_SECOND:
                return DiatonicChordPattern.SECOND;

            case I_FOURTH:
            case II_FOURTH:
            case III_FOURTH:
            case IV_FOURTH:
            case V_FOURTH:
            case VI_FOURTH:
            case VII_FOURTH:
                return DiatonicChordPattern.FOURTH;

            case I6_O5:
            case II6_O5:
            case III6_O5:
            case IV6_O5:
            case V6_O5:
            case VI6_O5:
            case VII6_O5:
                return DiatonicChordPattern.SIXTH_O5;

            case I7_O3:
            case II7_O3:
            case III7_O3:
            case IV7_O3:
            case V7_O3:
            case VI7_O3:
            case VII7_O3:
                return DiatonicChordPattern.SEVENTH_O3;

            case I7_O5:
            case II7_O5:
            case III7_O5:
            case IV7_O5:
            case V7_O5:
            case VI7_O5:
            case VII7_O5:
                return DiatonicChordPattern.SEVENTH_O5;

            case I9_O3_O7:
            case II9_O3_O7:
            case III9_O3_O7:
            case IV9_O3_O7:
            case V9_O3_O7:
            case VI9_O3_O7:
            case VII9_O3_O7:
                return DiatonicChordPattern.NINTH_O3_O7;

            case I9_O7:
            case II9_O7:
            case III9_O7:
            case IV9_O7:
            case V9_O7:
            case VI9_O7:
            case VII9_O7:
                return DiatonicChordPattern.NINTH_O7;

            case I_THIRD:
            case II_THIRD:
            case III_THIRD:
            case IV_THIRD:
            case V_THIRD:
            case VI_THIRD:
            case VII_THIRD:
                return DiatonicChordPattern.THIRD;
        }
        throw NeverHappensException.switchOf(diatonicFunction);
    }

    static boolean equals(DiatonicChordInterface self, Object o) {
        if ( !(o instanceof DiatonicChordInterface))
            return false;

        DiatonicChordInterface notes = (DiatonicChordInterface)o;

        if (self.getRootIndex() != notes.getRootIndex())
            return false;

        if (self.size() != notes.size())
            return false;

        for (int i = 0; i < self.size(); i++) {
            if (self.get(i).ordinal() != notes.get(i).ordinal())
                return false;
        }

        return true;
    }
}

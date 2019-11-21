package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Objects;

class DiatonicChordInterfaceAdapter {
    private DiatonicChordInterfaceAdapter() {
    }

    public static @NonNull DiatonicChordInterface from(@NonNull Collection<? extends PitchDiatonicSingle> diatonicChord) {
        Objects.requireNonNull(diatonicChord);

        DiatonicChordInterface ret = DiatonicChordEnum.from(diatonicChord);
        if (ret == null) {
            ret = new DiatonicChordCustom();
            for (PitchDiatonicSingle diatonic : diatonicChord) {
                Diatonic c = diatonic.getDiatonic();
                ret.add(c);
            }
            if (diatonicChord instanceof DiatonicChordCustom) {
                DiatonicChordCustom retCustom = (DiatonicChordCustom)ret;
                DiatonicChordCustom inCustom = (DiatonicChordCustom)diatonicChord;
                retCustom.setRootPos(inCustom.getRootPos());
            }
        }

        return ret;
    }

    public static DiatonicChordInterface from(@NonNull DiatonicFunction f) {
        Objects.requireNonNull(f);

        switch ( f ) {
            case I:
                return DiatonicChordEnum.TRIAD;
            case II:
                DiatonicChordCustom c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.SECOND ); return c;
            case III:
                c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV:
                c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V:
                c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.FIFTH); return c;
            case VI:
                c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.SIXTH); return c;
            case VII:
                c = DiatonicChordCustom.from(DiatonicChordEnum.TRIAD); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I7:
                return DiatonicChordEnum.SEVENTH;
            case II7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.SECOND ); return c;
            case III7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I2:
                return DiatonicChordEnum.SUS2;
            case II2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.SECOND ); return c;
            case III2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII2:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I4:
                return DiatonicChordEnum.SUS4;
            case II4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.SECOND ); return c;
            case III4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII4:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I6:
                return DiatonicChordEnum.SIXTH;
            case II6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.SECOND ); return c;
            case III6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII6:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case I9:
                return DiatonicChordEnum.NINTH;
            case II9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.SECOND ); return c;
            case III9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII9:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I11:
                return DiatonicChordEnum.ELEVENTH;
            case II11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.SECOND ); return c;
            case III11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII11:
                c = DiatonicChordCustom.from(DiatonicChordEnum.ELEVENTH); c.shift( IntervalDiatonic.SEVENTH ); return c;

            case I13:
                return DiatonicChordEnum.THIRTEENTH;
            case II13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.SECOND ); return c;
            case III13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII13:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRTEENTH); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case I_SECOND:
                return DiatonicChordEnum.SUS2_O5;
            case I_FOURTH:
                return DiatonicChordEnum.SUS4_O5;
            case I6_O5:
                return DiatonicChordEnum.SIXTH_O5;
            case I7_O3:
                return DiatonicChordEnum.SEVENTH_O3;
            case I7_O5:
                return DiatonicChordEnum.SEVENTH_O5;
            case I9_O3_O7:
                return DiatonicChordEnum.NINTH_O3_O7;
            case I9_O7:
                return DiatonicChordEnum.NINTH_O7;
            case II_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.SECOND ); return c;
            case II_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.SECOND ); return c;
            case II6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.SECOND ); return c;
            case II7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.SECOND ); return c;
            case II7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.SECOND ); return c;
            case II9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.SECOND ); return c;
            case II9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.SECOND ); return c;
            case III_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.THIRD ); return c;
            case III_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.THIRD ); return c;
            case III6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.THIRD ); return c;
            case III7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.THIRD ); return c;
            case III7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.THIRD ); return c;
            case III9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.THIRD ); return c;
            case III9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.THIRD ); return c;
            case IV_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.FOURTH ); return c;
            case IV9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.FOURTH ); return c;
            case V_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.FIFTH ); return c;
            case V9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.FIFTH ); return c;
            case VI_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VI9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.SIXTH ); return c;
            case VII_SECOND:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS2_O5); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII_FOURTH:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SUS4_O5); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII6_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SIXTH_O5); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII7_O3:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O3); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII7_O5:
                c = DiatonicChordCustom.from(DiatonicChordEnum.SEVENTH_O5); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII9_O3_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O3_O7); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VII9_O7:
                c = DiatonicChordCustom.from(DiatonicChordEnum.NINTH_O7); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case III_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.THIRD ); return c;
            case II_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.SECOND ); return c;
            case IV_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.FOURTH ); return c;
            case I_THIRD:
                return DiatonicChordEnum.THIRD;
            case VII_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.SEVENTH ); return c;
            case VI_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.SIXTH ); return c;
            case V_THIRD:
                c = DiatonicChordCustom.from(DiatonicChordEnum.THIRD); c.shift( IntervalDiatonic.FIFTH ); return c;
        }
        throw new RuntimeException( " " + f + " " );

        // return null;
    }

    static boolean equals(DiatonicChordInterface self, Object o) {
        if ( !(o instanceof DiatonicChordInterface))
            return false;

        DiatonicChordInterface notes = (DiatonicChordInterface)o;

        if (self.getRootPos() != notes.getRootPos())
            return false;

        if (self.size() != notes.size())
            return false;

        for (int i = 0; i < self.size(); i++) {
            if (self.get(i).getDiatonic().ordinal() != notes.get(i).getDiatonic().ordinal())
                return false;
        }

        return true;
    }
}

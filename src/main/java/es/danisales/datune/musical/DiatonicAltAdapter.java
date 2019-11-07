package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

class DiatonicAltAdapter {
    static DiatonicAlt from(@NonNull Chromatic chromatic, @NonNull Diatonic diatonic) {
        Objects.requireNonNull(diatonic);
        Objects.requireNonNull(chromatic);

        switch ( diatonic ) {
            case C:
                switch ( chromatic ) {
                    case C:
                        return DiatonicAlt.C;
                    case CC:
                        return DiatonicAlt.CC;
                    case D:
                        return DiatonicAlt.CCC;
                    case DD:
                        return DiatonicAlt.CCCC;
                    case E:
                        return DiatonicAlt.CCCCC;
                    case B:
                        return DiatonicAlt.Cb;
                    case AA:
                        return DiatonicAlt.Cbb;
                    case A:
                        return DiatonicAlt.Cbbb;
                }
                break;
            case D:
                switch ( chromatic ) {
                    case D:
                        return DiatonicAlt.D;
                    case DD:
                        return DiatonicAlt.DD;
                    case E:
                        return DiatonicAlt.DDD;
                    case F:
                        return DiatonicAlt.DDDD;
                    case FF:
                        return DiatonicAlt.DDDDD;
                    case CC:
                        return DiatonicAlt.Db;
                    case C:
                        return DiatonicAlt.Dbb;
                    case B:
                        return DiatonicAlt.Dbbb;
                }
                break;
            case E:
                switch ( chromatic ) {
                    case E:
                        return DiatonicAlt.E;
                    case F:
                        return DiatonicAlt.EE;
                    case FF:
                        return DiatonicAlt.EEE;
                    case G:
                        return DiatonicAlt.EEEE;
                    case GG:
                        return DiatonicAlt.EEEEE;
                    case DD:
                        return DiatonicAlt.Eb;
                    case D:
                        return DiatonicAlt.Ebb;
                    case CC:
                        return DiatonicAlt.Ebbb;
                }
                break;
            case F:
                switch ( chromatic ) {
                    case F:
                        return DiatonicAlt.F;
                    case FF:
                        return DiatonicAlt.FF;
                    case G:
                        return DiatonicAlt.FFF;
                    case GG:
                        return DiatonicAlt.FFFF;
                    case A:
                        return DiatonicAlt.FFFFF;
                    case E:
                        return DiatonicAlt.Fb;
                    case DD:
                        return DiatonicAlt.Fbb;
                    case D:
                        return DiatonicAlt.Fbbb;
                }
                break;
            case G:
                switch ( chromatic ) {
                    case G:
                        return DiatonicAlt.G;
                    case GG:
                        return DiatonicAlt.GG;
                    case A:
                        return DiatonicAlt.GGG;
                    case AA:
                        return DiatonicAlt.GGGG;
                    case B:
                        return DiatonicAlt.GGGGG;
                    case FF:
                        return DiatonicAlt.Gb;
                    case F:
                        return DiatonicAlt.Gbb;
                    case E:
                        return DiatonicAlt.Gbbb;
                }
                break;
            case A:
                switch ( chromatic ) {
                    case A:
                        return DiatonicAlt.A;
                    case AA:
                        return DiatonicAlt.AA;
                    case B:
                        return DiatonicAlt.AAA;
                    case C:
                        return DiatonicAlt.AAAA;
                    case CC:
                        return DiatonicAlt.AAAAA;
                    case GG:
                        return DiatonicAlt.Ab;
                    case G:
                        return DiatonicAlt.Abb;
                    case FF:
                        return DiatonicAlt.Abbb;
                }
                break;
            case B:
                switch ( chromatic ) {
                    case B:
                        return DiatonicAlt.B;
                    case C:
                        return DiatonicAlt.BB;
                    case CC:
                        return DiatonicAlt.BBB;
                    case D:
                        return DiatonicAlt.BBBB;
                    case DD:
                        return DiatonicAlt.BBBBB;
                    case AA:
                        return DiatonicAlt.Bb;
                    case A:
                        return DiatonicAlt.Bbb;
                    case GG:
                        return DiatonicAlt.Bbbb;
                }
                break;
        }
        throw new RuntimeException("Impossible conversion");
    }
}

package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class AlterationsCalculator {
    private AlterationsCalculator() {
    }

    public static int from(Chromatic chromatic) {
        switch(chromatic) {
            case CC:
            case DD:
            case EE:
            case FF:
            case GG:
            case AA:
            case BB:
            case Cb:
            case Db:
            case Eb:
            case Fb:
            case Gb:
            case Ab:
            case Bb:
                return 1;
            case CCC:
            case DDD:
            case EEE:
            case FFF:
            case GGG:
            case AAA:
            case BBB:
            case Cbb:
            case Dbb:
            case Ebb:
            case Fbb:
            case Gbb:
            case Abb:
            case Bbb:
                return 2;
            case CCCC:
            case DDDD:
            case EEEE:
            case FFFF:
            case GGGG:
            case AAAA:
            case BBBB:
            case Cbbb:
            case Dbbb:
            case Ebbb:
            case Fbbb:
            case Gbbb:
            case Abbb:
            case Bbbb:
                return 3;
            case CCCCC:
            case DDDDD:
            case EEEEE:
            case FFFFF:
            case GGGGG:
            case AAAAA:
            case BBBBB:
                return 4;
            case A:
            case B:
            case C:
            case D:
            case E:
            case F:
            case G:
                return 0;
        }
        return 0;
    }

    public static @NonNull Chromatic minAlterationsFrom(@NonNull Chromatic chromatic) {
        Objects.requireNonNull(chromatic);
        switch (chromatic) {
            case C:
            case D:
            case E:
            case F:
            case G:
            case A:
            case B:
            case CC:
            case DD:
            case FF:
            case GG:
            case AA:
                return chromatic;
            case BB:
                return Chromatic.C;
            case EE:
                return Chromatic.F;
            case CCC:
                return Chromatic.D;
            case DDD:
                return Chromatic.E;
            case EEE:
                return Chromatic.FF;
            case FFF:
                return Chromatic.G;
            case GGG:
                return Chromatic.A;
            case AAA:
                return Chromatic.B;
            case BBB:
                return Chromatic.CC;
            case CCCC:
                return Chromatic.DD;
            case DDDD:
                return Chromatic.F;
            case EEEE:
                return Chromatic.G;
            case FFFF:
                return Chromatic.GG;
            case GGGG:
                return Chromatic.AA;
            case AAAA:
                return Chromatic.C;
            case BBBB:
                return Chromatic.D;
            case CCCCC:
                return Chromatic.E;
            case DDDDD:
                return Chromatic.FF;
            case EEEEE:
                return Chromatic.GG;
            case FFFFF:
                return Chromatic.A;
            case GGGGG:
                return Chromatic.G;
            case AAAAA:
                return Chromatic.CC;
            case BBBBB:
                return Chromatic.DD;
            case Db:
                return Chromatic.CC;
            case Eb:
                return Chromatic.DD;
            case Gb:
                return Chromatic.FF;
            case Ab:
                return Chromatic.GG;
            case Bb:
                return Chromatic.AA;
            case Cb:
                return Chromatic.B;
            case Fb:
                return Chromatic.E;
            case Cbb:
                return Chromatic.B;
            case Dbb:
                return Chromatic.C;
            case Ebb:
                return Chromatic.D;
            case Fbb:
                return Chromatic.DD;
            case Gbb:
                return Chromatic.F;
            case Abb:
                return Chromatic.G;
            case Bbb:
                return Chromatic.A;
            case Cbbb:
                return Chromatic.AA;
            case Dbbb:
                return Chromatic.B;
            case Ebbb:
                return Chromatic.CC;
            case Fbbb:
                return Chromatic.D;
            case Gbbb:
                return Chromatic.E;
            case Abbb:
                return Chromatic.FF;
            case Bbbb:
                return Chromatic.GG;
        }
        throw new RuntimeException("Impossible");
    }

    public static @NonNull Chromatic removeAlterationsFrom(@NonNull Chromatic chromatic) {
        Objects.requireNonNull(chromatic);

        switch(chromatic) {
            case C:
            case CC:
            case CCC:
            case CCCC:
            case CCCCC:
            case Cb:
            case Cbb:
            case Cbbb:
                return Chromatic.C;
            case D:
            case DD:
            case DDD:
            case DDDD:
            case DDDDD:
            case Db:
            case Dbb:
            case Dbbb:
                return Chromatic.D;
            case E:
            case EE:
            case EEE:
            case EEEE:
            case EEEEE:
            case Eb:
            case Ebb:
            case Ebbb:
                return Chromatic.E;
            case F:
            case FF:
            case FFF:
            case FFFF:
            case FFFFF:
            case Fb:
            case Fbb:
            case Fbbb:
                return Chromatic.F;
            case G:
            case GG:
            case GGG:
            case GGGG:
            case GGGGG:
            case Gb:
            case Gbb:
            case Gbbb:
                return Chromatic.G;
            case A:
            case AA:
            case AAA:
            case AAAA:
            case AAAAA:
            case Ab:
            case Abb:
            case Abbb:
                return Chromatic.A;
            case B:
            case BB:
            case BBB:
            case BBBB:
            case BBBBB:
            case Bb:
            case Bbb:
            case Bbbb:
                return Chromatic.B;
        }

        return null;
    }
}

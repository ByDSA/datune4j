package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.AlterationException;
import es.danisales.datune.musical.Chromatic;

public class PitchTransformation {

    public static Chromatic addSemi(Chromatic chromatic) {
        switch(chromatic) {
            case A: 	return Chromatic.AA;
            case AA: 	return Chromatic.AAA;
            case AAA: 	return Chromatic.AAAA;
            case AAAA: 	return Chromatic.AAAAA;
            case Ab: 	return Chromatic.A;
            case Abb:	return Chromatic.Ab;
            case Abbb:	return Chromatic.Abb;
            case B:		return Chromatic.BB;
            case BB:	return Chromatic.BBB;
            case BBB:	return Chromatic.BBBB;
            case BBBB:	return Chromatic.BBBBB;
            case Bb:	return Chromatic.B;
            case Bbb:	return Chromatic.Bb;
            case Bbbb:	return Chromatic.Bbb;
            case C:		return Chromatic.CC;
            case CC:	return Chromatic.CCC;
            case CCC:	return Chromatic.CCCC;
            case CCCC:	return Chromatic.CCCCC;
            case Cb:	return Chromatic.C;
            case Cbb:	return Chromatic.Cb;
            case Cbbb:	return Chromatic.Cbb;
            case D:		return Chromatic.DD;
            case DD:	return Chromatic.DDD;
            case DDD:	return Chromatic.DDDD;
            case DDDD:	return Chromatic.DDDDD;
            case Db:	return Chromatic.D;
            case Dbb:	return Chromatic.Db;
            case Dbbb:	return Chromatic.Dbb;
            case E:		return Chromatic.EE;
            case EE:	return Chromatic.EEE;
            case EEE:	return Chromatic.EEEE;
            case EEEE:	return Chromatic.EEEEE;
            case Eb:	return Chromatic.E;
            case Ebb:	return Chromatic.Eb;
            case Ebbb:	return Chromatic.Ebb;
            case F:		return Chromatic.FF;
            case FF:	return Chromatic.FFF;
            case FFF:	return Chromatic.FFFF;
            case FFFF:	return Chromatic.FFFFF;
            case Fb:	return Chromatic.F;
            case Fbb:	return Chromatic.Fb;
            case Fbbb:	return Chromatic.Fbb;
            case G:		return Chromatic.GG;
            case GG:	return Chromatic.GGG;
            case GGG:	return Chromatic.GGGG;
            case GGGG:	return Chromatic.GGGGG;
            case Gb:	return Chromatic.G;
            case Gbb:	return Chromatic.Gb;
            case Gbbb:	return Chromatic.Gbb;
            case CCCCC:
            case DDDDD:
            case EEEEE:
            case FFFFF:
            case GGGGG:
            case AAAAA:
            case BBBBB:
            default:	throw new AlterationException();
        }
    }

    public static Chromatic subSemi(Chromatic chromatic) {
        switch(chromatic) {
            case A: 	return Chromatic.Ab;
            case AA: 	return Chromatic.A;
            case AAA: 	return Chromatic.AA;
            case AAAA: 	return Chromatic.AAA;
            case AAAAA:	return Chromatic.AAAA;
            case Ab: 	return Chromatic.Abb;
            case Abb:	return Chromatic.Abbb;
            case B:		return Chromatic.Bb;
            case BB:	return Chromatic.B;
            case BBB:	return Chromatic.BB;
            case BBBB:	return Chromatic.BBB;
            case BBBBB:	return Chromatic.BBBB;
            case Bb:	return Chromatic.Bbb;
            case Bbb:	return Chromatic.Bbbb;
            case C:		return Chromatic.Cb;
            case CC:	return Chromatic.C;
            case CCC:	return Chromatic.CC;
            case CCCC:	return Chromatic.CCC;
            case CCCCC:	return Chromatic.CCCC;
            case Cb:	return Chromatic.Cbb;
            case Cbb:	return Chromatic.Cbbb;
            case D:		return Chromatic.Db;
            case DD:	return Chromatic.D;
            case DDD:	return Chromatic.DD;
            case DDDD:	return Chromatic.DDD;
            case DDDDD:	return Chromatic.DDDD;
            case Db:	return Chromatic.Dbb;
            case Dbb:	return Chromatic.Dbbb;
            case E:		return Chromatic.Eb;
            case EE:	return Chromatic.E;
            case EEE:	return Chromatic.EE;
            case EEEE:	return Chromatic.EEE;
            case EEEEE:	return Chromatic.EEEE;
            case Eb:	return Chromatic.Ebb;
            case Ebb:	return Chromatic.Ebbb;
            case F:		return Chromatic.Fb;
            case FF:	return Chromatic.F;
            case FFF:	return Chromatic.FF;
            case FFFF:	return Chromatic.FFF;
            case FFFFF:	return Chromatic.FFFF;
            case Fb:	return Chromatic.Fbb;
            case Fbb:	return Chromatic.Fbbb;
            case G:		return Chromatic.Gb;
            case GG:	return Chromatic.G;
            case GGG:	return Chromatic.GG;
            case GGGG:	return Chromatic.GGG;
            case GGGGG:	return Chromatic.GGGG;
            case Gb:	return Chromatic.Gbb;
            case Gbb:	return Chromatic.Gbbb;
            case Cbbb:
            case Dbbb:
            case Ebbb:
            case Fbbb:
            case Gbbb:
            case Abbb:
            case Bbbb:
            default:	throw new AlterationException();
        }
    }
}

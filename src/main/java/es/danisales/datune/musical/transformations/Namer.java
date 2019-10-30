package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Tonality;

public class Namer {
    private Namer() {
    }

    public static final String FLAT = "b";
    public static final String SHARP = "#";

    public static String from(Chromatic chromatic) {
        Chromatic chromaticWithoutAlterations = AlterationsCalculator.removeAlterationsFrom(chromatic);

        switch(chromatic) {
            case C: return "C";
            case D: return "D";
            case E: return "E";
            case F: return "F";
            case G: return "G";
            case A: return "A";
            case B: return "B";
            case CC:
            case DD:
            case EE:
            case FF:
            case GG:
            case AA:
            case BB:
                return chromaticWithoutAlterations + SHARP;
            case CCC:
            case DDD:
            case EEE:
            case FFF:
            case GGG:
            case AAA:
            case BBB:
                return chromaticWithoutAlterations + SHARP + SHARP;
            case CCCC:
            case DDDD:
            case EEEE:
            case FFFF:
            case GGGG:
            case AAAA:
            case BBBB:
                return chromaticWithoutAlterations + SHARP + SHARP;
            case CCCCC:
            case DDDDD:
            case EEEEE:
            case FFFFF:
            case GGGGG:
            case AAAAA:
            case BBBBB:
                return chromaticWithoutAlterations + SHARP + SHARP + SHARP;
            case Cb:
            case Db:
            case Eb:
            case Fb:
            case Gb:
            case Ab:
            case Bb:
                return chromaticWithoutAlterations + FLAT;
            case Cbb:
            case Dbb:
            case Ebb:
            case Fbb:
            case Gbb:
            case Abb:
            case Bbb:
                return chromaticWithoutAlterations + FLAT + FLAT;
            case Cbbb:
            case Dbbb:
            case Ebbb:
            case Fbbb:
            case Gbbb:
            case Abbb:
            case Bbbb:
                return chromaticWithoutAlterations + FLAT + FLAT + FLAT;
            default: return "Nota desconocida";
        }
    }

    public static String from(ChromaticMidi chromaticMidi) {
        return from(chromaticMidi, null);
    }

    public static String from(ChromaticMidi chromaticMidi, Tonality tonality) {
        return ChromaticMidi.literal(ChromaticAdapter.from(chromaticMidi.getPitch()), tonality ) + chromaticMidi.getOctave();
    }
}

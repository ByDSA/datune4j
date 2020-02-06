package es.danisales.datune.tonality;

import es.danisales.datune.GlobalSettings;
import es.danisales.datune.lang.Language;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

class ScaleNamer {
    private ScaleNamer() {
    }

    static @NonNull String numberFrom(@NonNull ScaleDistance scaleDistance) {
        switch (scaleDistance) {
            case HALF: return "1";
            case WHOLE: return "2";
            case WHOLE_HALF: return "3";
        }

        throw new RuntimeException();
    }

    static @NonNull String from(@NonNull ScaleInnerImmutable scaleEnum) {
        switch (scaleEnum) {
            case MAJOR:
                return "Mayor";
            case IONIAN:
                return "Jónica";
            case MINOR:
                return "Menor";
            case HARMONIC_MINOR:
                return ScaleInnerImmutable.MINOR + " armónica";
            case MELODIC_MINOR:
                return ScaleInnerImmutable.MINOR + " Melódica";
            case AEOLIAN:
                return "Eólica";
            case DORIAN:
                return "Dórica";
            case LOCRIAN:
                return "Locria";
            case SUPERLOCRIAN:
                return "Superlocria";
            case PHRYGIAN:
                return "Frigia";
            case LYDIAN:
                return "Lidia";
            case LYDIAN_b7:
                return ScaleInnerImmutable.LYDIAN + " b7";
            case MIXOLYDIAN:
                return "Mixolidia";
            case LOCRIAN_H6:
                return ScaleInnerImmutable.LOCRIAN + " #6";
            case IONIAN_H5:
                return ScaleInnerImmutable.IONIAN + " #5";
            case DORIAN_H4:
                return ScaleInnerImmutable.DORIAN + " #4";
            case UKRANIAN_MINOR_SCALE:
                break;
            case MIXOLIDIAN_b9_b13:
                return ScaleInnerImmutable.MIXOLYDIAN + "b9 b13";
            case MIXOLIDIAN_b13:
                return ScaleInnerImmutable.MIXOLYDIAN + " b13";
            case LYDIAN_H2:
                return ScaleInnerImmutable.LYDIAN + " #2";
            case SUPERLOCRIAN_bb7:
                return "Superlocria bb7";
            case HARMONIC_MAJOR:
                return ScaleInnerImmutable.MAJOR + " Armónica";
            case DORIAN_b5:
                return ScaleInnerImmutable.DORIAN + " b5";
            case PHRYGIAN_b4:
                return ScaleInnerImmutable.PHRYGIAN + " b4";
            case LYDIAN_b3:
                return ScaleInnerImmutable.LYDIAN + " b3";
            case MIXOLYDIAN_b2:
                return ScaleInnerImmutable.MIXOLYDIAN + " b2";
            case AEOLIAN_b1:
                return ScaleInnerImmutable.AEOLIAN + " b1";
            case LOCRIAN_bb7:
                return ScaleInnerImmutable.LOCRIAN + " bb7";
            case DORIAN_b2:
                return ScaleInnerImmutable.DORIAN + " b2";
            case LYDIAN_H5:
                return ScaleInnerImmutable.LYDIAN + " #5";
            case LOCRIAN_H2:
                return ScaleInnerImmutable.LOCRIAN + " #2";
            case DOUBLE_HARMONIC:
                return "Doble Armónica";
            case LYDIAN_H2_H6:
                return ScaleInnerImmutable.LYDIAN + " #2 #6";
            case ULTRAPHRYGIAN:
                return "Ultrafrigia";
            case HUNGARIAN_MINOR:
                return "Húngara menor";
            case ORIENTAL:
                return "Oriental";
            case IONIAN_AUGMENTED_H2:
                return ScaleInnerImmutable.IONIAN + " aumentada #2";
            case LOCRIAN_bb3_bb7:
                return ScaleInnerImmutable.LOCRIAN + " bb3 bb7";
            case NEAPOLITAN_MINOR:
                return "Napolitana menor";
            case NEAPOLITAN_MAJOR:
                return "Napolitana mayor";
            case BLUES_b5:
                break;
            case WHOLE_TONE:
                break;
            case PENTATONIC_MINOR:
                return ScaleInnerImmutable.PENTATONIC + " " + ScaleInnerImmutable.MINOR;
            case PENTATONIC: return "Pentatónica";
            case EGYPCIAN:
                break;
            case SUSPENDED:
                break;
            case BLUES_MINOR:
                break;
            case MAN_GONG:
                break;
            case BLUES_MAJOR:
                break;
            case YO_SCALE:
                break;
            case CHROMATIC: return "Cromática";
        }

        return scaleEnum.name();
    }

    static @NonNull String from(@NonNull Scale scale) {
        ScaleInner scaleInner = scale.innerScale;
        if (scaleInner instanceof ScaleInnerImmutable) {
            return from((ScaleInnerImmutable) scaleInner);
        }

        return ScaleUtils.getStringDistancesFrom(scale);
    }

    public static String from(ScaleDistance scaleDistance) {
        switch (GlobalSettings.sigleton().getLanguage()) {
            case ES:
                switch (scaleDistance) {
                    case QUARTER:
                        return "1/4";
                    case HALF:
                        return "ST";
                    case WHOLE:
                        return "T";
                    case WHOLE_HALF:
                        return "TS";
                    case NONE:
                        return "0";
                    case TWO_WHOLE:
                        return "TT";
                    default:
                        throw NeverHappensException.switchOf(scaleDistance);
                }
            default:
            case EN:
                switch (scaleDistance) {
                    case QUARTER:
                        return "1/4";
                    case HALF:
                        return "H";
                    case WHOLE:
                        return "W";
                    case WHOLE_HALF:
                        return "WH";
                    case NONE:
                        return "0";
                    case TWO_WHOLE:
                        return "WW";
                    default:
                        throw NeverHappensException.switchOf(scaleDistance);
                }
        }
    }
}

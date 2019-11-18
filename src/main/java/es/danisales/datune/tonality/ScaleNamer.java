package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

class ScaleNamer {
    private ScaleNamer() {
    }

    public static String distOf(@NonNull Scale scale) {
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        for ( ScaleDistance distanceScale : scale.getCode() ) {
            if (first)
                first = false;
            else
                sb.append("-");
            sb.append(distanceScale);
        }

        return sb.toString();
    }

    public static String from(@NonNull ScaleDistance distanceScale) {
        switch (distanceScale) {
            case HALF: return "1";
            case WHOLE: return "2";
            case WHOLE_HALF: return "3";
        }

        return null;
    }

    public static @NonNull String from(@NonNull ScaleEnum scaleEnum) {
        switch (scaleEnum) {
            case MAJOR:
                return "Mayor";
            case IONIAN:
                return "Jónica";
            case MINOR:
                return "Menor";
            case HARMONIC_MINOR:
                return ScaleEnum.MINOR + " armónica";
            case MELODIC_MINOR:
                return ScaleEnum.MINOR + " Melódica";
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
                return ScaleEnum.LYDIAN + " b7";
            case MIXOLYDIAN:
                return "Mixolidia";
            case LOCRIAN_H6:
                return ScaleEnum.LOCRIAN + " #6";
            case IONIAN_H5:
                return ScaleEnum.IONIAN + " #5";
            case DORIAN_H4:
                return ScaleEnum.DORIAN + " #4";
            case UKRANIAN_MINOR_SCALE:
                break;
            case MIXOLIDIAN_b9_b13:
                return ScaleEnum.MIXOLYDIAN + "b9 b13";
            case MIXOLIDIAN_b13:
                return ScaleEnum.MIXOLYDIAN + " b13";
            case LYDIAN_H2:
                return ScaleEnum.LYDIAN + " #2";
            case SUPERLOCRIAN_bb7:
                return "Superlocria bb7";
            case HARMONIC_MAJOR:
                return ScaleEnum.MAJOR + " Armónica";
            case DORIAN_b5:
                return ScaleEnum.DORIAN + " b5";
            case PHRYGIAN_b4:
                return ScaleEnum.PHRYGIAN + " b4";
            case LYDIAN_b3:
                return ScaleEnum.LYDIAN + " b3";
            case MIXOLYDIAN_b2:
                return ScaleEnum.MIXOLYDIAN + " b2";
            case AEOLIAN_b1:
                return ScaleEnum.AEOLIAN + " b1";
            case LOCRIAN_bb7:
                return ScaleEnum.LOCRIAN + " bb7";
            case DORIAN_b2:
                return ScaleEnum.DORIAN + " b2";
            case LYDIAN_H5:
                return ScaleEnum.LYDIAN + " #5";
            case LOCRIAN_H2:
                return ScaleEnum.LOCRIAN + " #2";
            case DOUBLE_HARMONIC:
                return "Doble Armónica";
            case LYDIAN_H2_H6:
                return ScaleEnum.LYDIAN + " #2 #6";
            case ULTRAPHRYGIAN:
                return "Ultrafrigia";
            case HUNGARIAN_MINOR:
                return "Húngara menor";
            case ORIENTAL:
                return "Oriental";
            case IONIAN_AUGMENTED_H2:
                return ScaleEnum.IONIAN + " aumentada #2";
            case LOCRIAN_bb3_bb7:
                return ScaleEnum.LOCRIAN + " bb3 bb7";
            case NEAPOLITAN_MINOR:
                return "Napolitana menor";
            case NEAPOLITAN_MAJOR:
                return "Napolitana mayor";
            case BLUES:
                break;
            case WOLE_TONE:
                break;
            case PENTATONIC_MINOR: return ScaleEnum.PENTATONIC + " " + ScaleEnum.MINOR;
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

    public static String from(@NonNull Scale scale) {
        ScaleInterface scaleInterface = scale.innerScale;
        if (scaleInterface instanceof ScaleEnum) {
            ScaleEnum scaleEnum = (ScaleEnum) scaleInterface;

            return from(scaleEnum);
        }

        return distOf(scale);
    }

    public static String alterationsFrom(Scale scale) {
        List<Integer> alterations = getMajorScaleAlterationsFrom(scale);

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < alterations.size(); i++ ) {
            if ( i > 0 )
                sb.append( " " );

            int altered = alterations.get(i);
            if ( altered == -1 )
                sb.append( "b" );
            else if ( altered == -2 )
                sb.append( "bb" );
            else if ( altered == 1 )
                sb.append( "#" );
            else if ( altered != 0 )
                sb.append( "?" );

            sb.append( i + 1 );
        }

        return sb.toString();
    }

    private static List<Integer> getMajorScaleAlterationsFrom(Scale scale) {
        checkArgument(scale.getCode().size() == 7);

        List<Integer> ret = new ArrayList<>();
        int majorScale = 0;
        int alteredScale = 0;

        for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
            majorScale += Scale.MAJOR.get( diatonicDegree ).getSemitones();
            alteredScale += scale.get( diatonicDegree ).getSemitones();
            ret.add(alteredScale - majorScale);
        }

        return ret;
    }
}

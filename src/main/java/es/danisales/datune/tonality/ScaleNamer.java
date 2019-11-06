package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

class ScaleNamer {
    private ScaleNamer() {
    }

    public static String distOf(@NonNull Scale scale) {
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        for ( Integer i : scale.getValue() ) {
            if (first)
                first = false;
            else
                sb.append("-");
            sb.append(i);
        }

        return sb.toString();
    }


    public static String from(Scale scale) {
        if (scale instanceof ScaleEnum) {
            ScaleEnum scaleEnum = (ScaleEnum) scale;

            if ( scaleEnum.equals( ScaleEnum.MAJOR ) )
                return "Mayor";
            else if ( scaleEnum.equals( ScaleEnum.MINOR ) )
                return "Menor";
            else if ( scaleEnum.equals( ScaleEnum.HARMONIC_MINOR ) )
                return ScaleEnum.MINOR + " armónica";
            else if ( scaleEnum.equals( ScaleEnum.MELODIC_MINOR ) )
                return ScaleEnum.MINOR + " melódica";
            else if ( scaleEnum.equals( ScaleEnum.AEOLIAN ) )
                return "Eólica";
            else if ( scaleEnum.equals( ScaleEnum.DORIAN ) )
                return "Dórica";
            else if ( scaleEnum.equals( ScaleEnum.LOCRIAN ) )
                return "Locria";
            else if ( scaleEnum.equals( ScaleEnum.SUPERLOCRIAN ) )
                return "Superlocria";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN ) )
                return "Lidia";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_b7 ) )
                return ScaleEnum.LYDIAN + " b7";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLYDIAN ) )
                return "Mixolidia";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLIDIAN_b9_b13 ) )
                return ScaleEnum.MIXOLYDIAN + "b9 b13";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLIDIAN_b13 ) )
                return ScaleEnum.MIXOLYDIAN + "b13";
            else if ( scaleEnum.equals( ScaleEnum.PHRYGIAN ) )
                return "Frigia";
            else if ( scaleEnum.equals( ScaleEnum.NEAPOLITAN_MAJOR ) )
                return "Napolitana mayor";
            else if ( scaleEnum.equals( ScaleEnum.NEAPOLITAN_MINOR ) )
                return "Napolitana menor";
            else if ( scaleEnum.equals( ScaleEnum.HARMONIC_MINOR ) )
                return ScaleEnum.MINOR + " Armónica";
            else if ( scaleEnum.equals( ScaleEnum.LOCRIAN_H6 ) )
                return ScaleEnum.LOCRIAN + " #6";
            else if ( scaleEnum.equals( ScaleEnum.IONIAN_H5 ) )
                return ScaleEnum.IONIAN + " #5";
            else if ( scaleEnum.equals( ScaleEnum.DORIAN_H4 ) )
                return ScaleEnum.DORIAN + " #4";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLIDIAN_b9_b13 ) )
                return ScaleEnum.MIXOLYDIAN + " b9 b13";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_H2 ) )
                return ScaleEnum.LYDIAN + " #2";
            else if ( scaleEnum.equals( ScaleEnum.SUPERLOCRIAN_bb7 ) )
                return "Superlocria bb7";
            else if ( scaleEnum.equals( ScaleEnum.HARMONIC_MAJOR ) )
                return ScaleEnum.MAJOR + " Armónica";
            else if ( scaleEnum.equals( ScaleEnum.DORIAN_b5 ) )
                return ScaleEnum.DORIAN + " b5";
            else if ( scaleEnum.equals( ScaleEnum.PHRYGIAN_b4 ) )
                return ScaleEnum.PHRYGIAN + " b4";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_b3 ) )
                return ScaleEnum.LYDIAN + " b3";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLYDIAN_b2 ) )
                return ScaleEnum.MIXOLYDIAN + " b2";
            else if ( scaleEnum.equals( ScaleEnum.AEOLIAN_b1 ) )
                return ScaleEnum.AEOLIAN + " b1";
            else if ( scaleEnum.equals( ScaleEnum.LOCRIAN_bb7 ) )
                return ScaleEnum.LOCRIAN + " bb7";
            else if ( scaleEnum.equals( ScaleEnum.MELODIC_MINOR ) )
                return ScaleEnum.MINOR + " Melódica";
            else if ( scaleEnum.equals( ScaleEnum.DORIAN_b2 ) )
                return ScaleEnum.DORIAN + " b2";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_H5 ) )
                return ScaleEnum.LYDIAN + " #5";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_b7 ) )
                return ScaleEnum.LYDIAN + " b7";
            else if ( scaleEnum.equals( ScaleEnum.MIXOLIDIAN_b13 ) )
                return ScaleEnum.MIXOLYDIAN + " b13";
            else if ( scaleEnum.equals( ScaleEnum.LOCRIAN_H2 ) )
                return ScaleEnum.LOCRIAN + " #2";
            else if ( scaleEnum.equals( ScaleEnum.SUPERLOCRIAN ) )
                return "Superlocria";
            else if ( scaleEnum.equals( ScaleEnum.DOUBLE_HARMONIC ) )
                return "Doble Armónica";
            else if ( scaleEnum.equals( ScaleEnum.LYDIAN_H2_H6 ) )
                return ScaleEnum.LYDIAN + " #2 #6";
            else if ( scaleEnum.equals( ScaleEnum.ULTRAPHRYGIAN ) )
                return "Ultrafrigia";
            else if ( scaleEnum.equals( ScaleEnum.HUNGARIAN_MINOR ) )
                return "Húngara menor";
            else if ( scaleEnum.equals( ScaleEnum.ORIENTAL ) )
                return "Oriental";
            else if ( scaleEnum.equals( ScaleEnum.IONIAN_AUGMENTED_H2 ) )
                return ScaleEnum.IONIAN + " aumentada #2";
            else if ( scaleEnum.equals( ScaleEnum.LOCRIAN_bb3_bb7 ) )
                return ScaleEnum.LOCRIAN + " bb3 bb7";

            throw new RuntimeException("Impossible");
        }

        return null;
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
        checkArgument(scale.getValue().size() == 7);

        List<Integer> ret = new ArrayList<>();
        int majorScale = 0;
        int alteredScale = 0;

        for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
            majorScale += ScaleEnum.MAJOR.get( diatonicDegree );
            alteredScale += scale.get( diatonicDegree );
            ret.add(alteredScale - majorScale);
        }

        return ret;
    }
}

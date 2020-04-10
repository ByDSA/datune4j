import { Scale } from '../../tonality/Scale';
import { Settings } from '../../settings/Settings';
import { ScalePrecalc } from '../../tonality/ScalePrecalc';

export class NamingScale {
    private constructor() {
    }

    public static toString(scale: Scale): string {
        switch (scale) {
            case ScalePrecalc.MAJOR: return Settings.scales.MAJOR;
            case ScalePrecalc.MINOR: return Settings.scales.MINOR;
            case ScalePrecalc.DORIAN: return Settings.scales.DORIAN;
            case ScalePrecalc.PHRYGIAN: return Settings.scales.PHRYGIAN;
            case ScalePrecalc.LYDIAN: return Settings.scales.LYDIAN;
            case ScalePrecalc.MIXOLYDIAN: return Settings.scales.MIXOLYDIAN;
            case ScalePrecalc.LOCRIAN: return Settings.scales.LOCRIAN;
            case ScalePrecalc.HARMONIC_MINOR: return Settings.scales.HARMONIC_MINOR;
            case ScalePrecalc.LOCRIAN_a6: return Settings.scales.LOCRIAN_a6;
            case ScalePrecalc.IONIAN_a5: return Settings.scales.IONIAN_a5;
            case ScalePrecalc.DORIAN_a4: return Settings.scales.DORIAN_a4;
            case ScalePrecalc.MIXOLYDIAN_b9_b13: return Settings.scales.MIXOLYDIAN_b9_b13;
            case ScalePrecalc.LYDIAN_a2: return Settings.scales.LYDIAN_a2;
            case ScalePrecalc.SUPERLOCRIAN_bb7: return Settings.scales.SUPERLOCRIAN_bb7;
            case ScalePrecalc.HARMONIC_MAJOR: return Settings.scales.HARMONIC_MAJOR;
            case ScalePrecalc.DORIAN_b5: return Settings.scales.DORIAN_b5;
            case ScalePrecalc.PHRYGIAN_b4: return Settings.scales.PHRYGIAN_b4;
            case ScalePrecalc.LYDIAN_b3: return Settings.scales.LYDIAN_b3;
            case ScalePrecalc.MIXOLYDIAN_b2: return Settings.scales.MIXOLYDIAN_b2;
            case ScalePrecalc.AEOLIAN_b1: return Settings.scales.AEOLIAN_b1;
            case ScalePrecalc.LOCRIAN_bb7: return Settings.scales.LOCRIAN_bb7;
            case ScalePrecalc.MELODIC_MINOR: return Settings.scales.MELODIC_MINOR;
            case ScalePrecalc.DORIAN_b2: return Settings.scales.DORIAN_b2;
            case ScalePrecalc.LYDIAN_a5: return Settings.scales.LYDIAN_a5;
            case ScalePrecalc.LYDIAN_b7: return Settings.scales.LYDIAN_b7;
            case ScalePrecalc.MIXOLYDIAN_b13: return Settings.scales.MIXOLYDIAN_b13;
            case ScalePrecalc.LOCRIAN_a2: return Settings.scales.LOCRIAN_a2;
            case ScalePrecalc.SUPERLOCRIAN: return Settings.scales.SUPERLOCRIAN;
            case ScalePrecalc.DOUBLE_HARMONIC: return Settings.scales.DOUBLE_HARMONIC;
            case ScalePrecalc.LYDIAN_a2_a6: return Settings.scales.LYDIAN_a2_a6;
            case ScalePrecalc.ULTRAPHRYGIAN: return Settings.scales.ULTRAPHRYGIAN;
            case ScalePrecalc.HUNGARIAN_MINOR: return Settings.scales.HUNGARIAN_MINOR;
            case ScalePrecalc.ORIENTAL: return Settings.scales.ORIENTAL;
            case ScalePrecalc.IONIAN_AUGMENTED_a2: return Settings.scales.IONIAN_AUGMENTED_a2;
            case ScalePrecalc.LOCRIAN_bb3_bb7: return Settings.scales.LOCRIAN_bb3_bb7;
            case ScalePrecalc.NEAPOLITAN_MINOR: return Settings.scales.NEAPOLITAN_MINOR;
            case ScalePrecalc.NEAPOLITAN_MAJOR: return Settings.scales.NEAPOLITAN_MAJOR;
            case ScalePrecalc.BLUES_b5: return Settings.scales.BLUES_b5;
            case ScalePrecalc.WHOLE_TONE: return Settings.scales.WHOLE_TONE;
            case ScalePrecalc.PENTATONIC_MINOR: return Settings.scales.PENTATONIC_MINOR;
            case ScalePrecalc.PENTATONIC: return Settings.scales.PENTATONIC;
            case ScalePrecalc.EGYPCIAN: return Settings.scales.EGYPCIAN;
            case ScalePrecalc.BLUES_MINOR: return Settings.scales.BLUES_MINOR;
            case ScalePrecalc.BLUES_MAJOR: return Settings.scales.BLUES_MAJOR;
            case ScalePrecalc.CHROMATIC: return Settings.scales.CHROMATIC;
            case ScalePrecalc.AUGMENTED_TRIAD: return Settings.scales.AUGMENTED_TRIAD;
            case ScalePrecalc.DIMINISHED_7th: return Settings.scales.DIMINISHED_7th;
            case ScalePrecalc.MESSIAEN_V_TRUNCATED: return Settings.scales.MESSIAEN_V_TRUNCATED;
            case ScalePrecalc.DOM7b5: return Settings.scales.DOM7b5;
            case ScalePrecalc.MESSIAEN_INV_III_V_TRUNCATED_n2: return Settings.scales.MESSIAEN_INV_III_V_TRUNCATED_n2;
            case ScalePrecalc.HALF_DIMINISHED: return Settings.scales.HALF_DIMINISHED;
            case ScalePrecalc.MESSIAEN_V: return Settings.scales.MESSIAEN_V;
            case ScalePrecalc.RAGA_INDRUPRIYA_INDIA: return Settings.scales.RAGA_INDRUPRIYA_INDIA;
            case ScalePrecalc.MESSIAEN_II_TRUNCATED_n3: return Settings.scales.MESSIAEN_II_TRUNCATED_n3;
            case ScalePrecalc.MESSIAEN_III_INV: return Settings.scales.MESSIAEN_III_INV;
            case ScalePrecalc.MESSIAEN_IV: return Settings.scales.MESSIAEN_IV;
            case ScalePrecalc.MESSIAEN_VI: return Settings.scales.MESSIAEN_VI;
            case ScalePrecalc.MESSIAEN_VII: return Settings.scales.MESSIAEN_VII;
            case ScalePrecalc.BEBOP_MAJOR: return Settings.scales.BEBOP_MAJOR;
        }

        return this.scaleToStringByIntervals(scale);
    }

    private static scaleToStringByIntervals(scale: Scale): string {
        let first = true;
        let ret: string = "";
        scale.intervals.forEach(i => {
            if (first)
                first = false;
            else
                ret += "-";
            ret += i;
        });

        return ret;
    }
}
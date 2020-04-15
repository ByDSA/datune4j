import { Scale } from '../../tonality/Scale';
import { Settings } from '../../settings/Settings';

export class NamingScale {
    private constructor() {
    }

    public static toString(scale: Scale): string {
        switch (scale) {
            case Scale.MAJOR: return Settings.scales.MAJOR;
            case Scale.MINOR: return Settings.scales.MINOR;
            case Scale.DORIAN: return Settings.scales.DORIAN;
            case Scale.PHRYGIAN: return Settings.scales.PHRYGIAN;
            case Scale.LYDIAN: return Settings.scales.LYDIAN;
            case Scale.MIXOLYDIAN: return Settings.scales.MIXOLYDIAN;
            case Scale.LOCRIAN: return Settings.scales.LOCRIAN;
            case Scale.HARMONIC_MINOR: return Settings.scales.HARMONIC_MINOR;
            case Scale.LOCRIAN_a6: return Settings.scales.LOCRIAN_a6;
            case Scale.IONIAN_a5: return Settings.scales.IONIAN_a5;
            case Scale.DORIAN_a4: return Settings.scales.DORIAN_a4;
            case Scale.MIXOLYDIAN_b9_b13: return Settings.scales.MIXOLYDIAN_b9_b13;
            case Scale.LYDIAN_a2: return Settings.scales.LYDIAN_a2;
            case Scale.SUPERLOCRIAN_bb7: return Settings.scales.SUPERLOCRIAN_bb7;
            case Scale.HARMONIC_MAJOR: return Settings.scales.HARMONIC_MAJOR;
            case Scale.DORIAN_b5: return Settings.scales.DORIAN_b5;
            case Scale.PHRYGIAN_b4: return Settings.scales.PHRYGIAN_b4;
            case Scale.LYDIAN_b3: return Settings.scales.LYDIAN_b3;
            case Scale.MIXOLYDIAN_b2: return Settings.scales.MIXOLYDIAN_b2;
            case Scale.AEOLIAN_b1: return Settings.scales.AEOLIAN_b1;
            case Scale.LOCRIAN_bb7: return Settings.scales.LOCRIAN_bb7;
            case Scale.MELODIC_MINOR: return Settings.scales.MELODIC_MINOR;
            case Scale.DORIAN_b2: return Settings.scales.DORIAN_b2;
            case Scale.LYDIAN_a5: return Settings.scales.LYDIAN_a5;
            case Scale.LYDIAN_b7: return Settings.scales.LYDIAN_b7;
            case Scale.MIXOLYDIAN_b13: return Settings.scales.MIXOLYDIAN_b13;
            case Scale.LOCRIAN_a2: return Settings.scales.LOCRIAN_a2;
            case Scale.SUPERLOCRIAN: return Settings.scales.SUPERLOCRIAN;
            case Scale.DOUBLE_HARMONIC: return Settings.scales.DOUBLE_HARMONIC;
            case Scale.LYDIAN_a2_a6: return Settings.scales.LYDIAN_a2_a6;
            case Scale.ULTRAPHRYGIAN: return Settings.scales.ULTRAPHRYGIAN;
            case Scale.HUNGARIAN_MINOR: return Settings.scales.HUNGARIAN_MINOR;
            case Scale.ORIENTAL: return Settings.scales.ORIENTAL;
            case Scale.IONIAN_AUGMENTED_a2: return Settings.scales.IONIAN_AUGMENTED_a2;
            case Scale.LOCRIAN_bb3_bb7: return Settings.scales.LOCRIAN_bb3_bb7;
            case Scale.NEAPOLITAN_MINOR: return Settings.scales.NEAPOLITAN_MINOR;
            case Scale.NEAPOLITAN_MAJOR: return Settings.scales.NEAPOLITAN_MAJOR;
            case Scale.BLUES_b5: return Settings.scales.BLUES_b5;
            case Scale.WHOLE_TONE: return Settings.scales.WHOLE_TONE;
            case Scale.PENTATONIC_MINOR: return Settings.scales.PENTATONIC_MINOR;
            case Scale.PENTATONIC: return Settings.scales.PENTATONIC;
            case Scale.EGYPCIAN: return Settings.scales.EGYPCIAN;
            case Scale.BLUES_MINOR: return Settings.scales.BLUES_MINOR;
            case Scale.BLUES_MAJOR: return Settings.scales.BLUES_MAJOR;
            case Scale.CHROMATIC: return Settings.scales.CHROMATIC;
            case Scale.AUGMENTED_TRIAD: return Settings.scales.AUGMENTED_TRIAD;
            case Scale.DIMINISHED_7th: return Settings.scales.DIMINISHED_7th;
            case Scale.MESSIAEN_V_TRUNCATED: return Settings.scales.MESSIAEN_V_TRUNCATED;
            case Scale.DOM7b5: return Settings.scales.DOM7b5;
            case Scale.MESSIAEN_INV_III_V_TRUNCATED_n2: return Settings.scales.MESSIAEN_INV_III_V_TRUNCATED_n2;
            case Scale.HALF_DIMINISHED: return Settings.scales.HALF_DIMINISHED;
            case Scale.MESSIAEN_V: return Settings.scales.MESSIAEN_V;
            case Scale.RAGA_INDRUPRIYA_INDIA: return Settings.scales.RAGA_INDRUPRIYA_INDIA;
            case Scale.MESSIAEN_II_TRUNCATED_n3: return Settings.scales.MESSIAEN_II_TRUNCATED_n3;
            case Scale.MESSIAEN_III_INV: return Settings.scales.MESSIAEN_III_INV;
            case Scale.MESSIAEN_IV: return Settings.scales.MESSIAEN_IV;
            case Scale.MESSIAEN_VI: return Settings.scales.MESSIAEN_VI;
            case Scale.MESSIAEN_VII: return Settings.scales.MESSIAEN_VII;
            case Scale.BEBOP_MAJOR: return Settings.scales.BEBOP_MAJOR;
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
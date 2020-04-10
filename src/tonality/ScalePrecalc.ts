import { Scale } from './Scale';
import { ScaleModeUtils } from './ScaleModeUtils';
import { Utils } from 'Utils';

export class ScalePrecalc {
    private constructor() {
    }

    public static MAJOR = Scale.from(2, 2, 1, 2, 2, 2, 1);
    public static DORIAN = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 2);
    public static PHRYGIAN = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 3);
    public static LYDIAN = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 4);
    public static MIXOLYDIAN = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 5);
    public static MINOR = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 6);
    public static LOCRIAN = ScaleModeUtils.getMode(ScalePrecalc.MAJOR, 7);

    public static HARMONIC_MINOR = Scale.from(2, 1, 2, 2, 1, 3, 1);
    public static LOCRIAN_a6 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 2);
    public static IONIAN_a5 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 3);
    public static DORIAN_a4 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 4);
    public static MIXOLYDIAN_b9_b13 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 5);
    public static LYDIAN_a2 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 6);
    public static SUPERLOCRIAN_bb7 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MINOR, 7);

    public static HARMONIC_MAJOR = Scale.from(2, 2, 1, 2, 1, 3, 1);
    public static DORIAN_b5 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 2);
    public static PHRYGIAN_b4 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 3);
    public static LYDIAN_b3 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 4);
    public static MIXOLYDIAN_b2 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 5);
    public static AEOLIAN_b1 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 6);
    public static LOCRIAN_bb7 = ScaleModeUtils.getMode(ScalePrecalc.HARMONIC_MAJOR, 7);

    public static MELODIC_MINOR = Scale.from(2, 1, 2, 2, 2, 2, 1);
    public static DORIAN_b2 = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 2);
    public static LYDIAN_a5 = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 3);
    public static LYDIAN_b7 = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 4);
    public static MIXOLYDIAN_b13 = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 5);
    public static LOCRIAN_a2 = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 6);
    public static SUPERLOCRIAN = ScaleModeUtils.getMode(ScalePrecalc.MELODIC_MINOR, 7);

    public static DOUBLE_HARMONIC = Scale.from(1, 3, 1, 2, 1, 3, 1);
    public static LYDIAN_a2_a6 = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 2);
    public static ULTRAPHRYGIAN = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 3);
    public static HUNGARIAN_MINOR = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 4);
    public static ORIENTAL = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 5);
    public static IONIAN_AUGMENTED_a2 = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 6);
    public static LOCRIAN_bb3_bb7 = ScaleModeUtils.getMode(ScalePrecalc.DOUBLE_HARMONIC, 7);

    public static NEAPOLITAN_MINOR = Scale.from(1, 2, 2, 2, 1, 3, 1);
    public static NEAPOLITAN_MAJOR = Scale.from(1, 2, 2, 2, 2, 2, 1);

    // 6
    public static BLUES_b5 = Scale.from(3, 2, 1, 1, 3, 2);

    // 5
    public static PENTATONIC_MINOR = Scale.from(3, 2, 2, 3, 2);
    public static PENTATONIC = ScaleModeUtils.getMode(ScalePrecalc.PENTATONIC_MINOR, 2);
    public static EGYPCIAN = ScaleModeUtils.getMode(ScalePrecalc.PENTATONIC_MINOR, 3);
    public static BLUES_MINOR = ScaleModeUtils.getMode(ScalePrecalc.PENTATONIC_MINOR, 4);
    public static BLUES_MAJOR = ScaleModeUtils.getMode(ScalePrecalc.PENTATONIC_MINOR, 5);

    // Symmetric
    public static CHROMATIC = Scale.from(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    public static WHOLE_TONE = Scale.from(2, 2, 2, 2, 2, 2);
    public static AUGMENTED_TRIAD = Scale.from(4, 4, 4);
    public static DIMINISHED_7th = Scale.from(3, 3, 3, 3);
    public static MESSIAEN_V_TRUNCATED = Scale.from(1, 5, 1, 5);
    public static DOM7b5 = Scale.from(4, 2, 4, 2);
    public static MESSIAEN_INV_III_V_TRUNCATED_n2 = Scale.from(1, 3, 1, 3, 1, 3);
    public static HALF_DIMINISHED = Scale.from(1, 2, 1, 2, 1, 2, 1, 2);
    public static MESSIAEN_V = Scale.from(1, 1, 4, 1, 1, 4);
    public static RAGA_INDRUPRIYA_INDIA = Scale.from(1, 3, 2, 3, 1, 2);
    public static MESSIAEN_II_TRUNCATED_n3 = Scale.from(3, 1, 2, 3, 1, 2);
    public static MESSIAEN_III_INV = Scale.from(2, 1, 1, 2, 1, 1, 2, 1, 1);
    public static MESSIAEN_IV = Scale.from(1, 1, 1, 3, 1, 1, 1, 3);
    public static MESSIAEN_VI = Scale.from(1, 1, 2, 2, 1, 1, 2, 2);
    public static MESSIAEN_VII = Scale.from(1, 1, 1, 1, 2, 1, 1, 1, 1, 2);

    // Bebop
    public static BEBOP_MAJOR = Scale.from(2, 2, 1, 2, 1, 1, 2, 1);


    public static get allDiatonicScales(): Scale[] {
        return [
            this.MAJOR,
            this.DORIAN,
            this.PHRYGIAN,
            this.LYDIAN,
            this.MIXOLYDIAN,
            this.MINOR,
            this.LOCRIAN
        ];
    }

    public static get allHeptatonicScales(): Scale[] {
        return []
            .concat(this.allDiatonicScales)
            .concat([
                this.HARMONIC_MINOR,
                this.LOCRIAN_a6,
                this.IONIAN_a5,
                this.DORIAN_a4,
                this.MIXOLYDIAN_b9_b13,
                this.LYDIAN_a2,
                this.SUPERLOCRIAN_bb7,

                this.HARMONIC_MAJOR,
                this.DORIAN_b5,
                this.PHRYGIAN_b4,
                this.LYDIAN_b3,
                this.MIXOLYDIAN_b2,
                this.AEOLIAN_b1,
                this.LOCRIAN_bb7,

                this.MELODIC_MINOR,
                this.DORIAN_b2,
                this.LYDIAN_a5,
                this.LYDIAN_b7,
                this.MIXOLYDIAN_b13,
                this.LOCRIAN_a2,
                this.SUPERLOCRIAN,

                this.DOUBLE_HARMONIC,
                this.LYDIAN_a2_a6,
                this.ULTRAPHRYGIAN,
                this.HUNGARIAN_MINOR,
                this.ORIENTAL,
                this.IONIAN_AUGMENTED_a2,
                this.LOCRIAN_bb3_bb7,

                this.NEAPOLITAN_MINOR,
                this.NEAPOLITAN_MAJOR
            ]);
    }

    public static get allBebopScales() {
        return [
            this.BEBOP_MAJOR
        ];
    }

    public static get allPentatonicScales() {
        return [
            this.PENTATONIC_MINOR,
            this.PENTATONIC,
            this.EGYPCIAN,
            this.BLUES_MINOR
        ];
    }

    public static get allHexatonicScales() {
        return [
            this.BLUES_b5,
            //this.BLUES_a4,
            this.WHOLE_TONE
        ];
    }

    public static get all(): Set<Scale> {
        let ret: Set<Scale> = new Set<Scale>();
        Utils.setAddArray(ret, this.allHeptatonicScales);
        Utils.setAddArray(ret, this.allPentatonicScales);
        Utils.setAddArray(ret, this.allHexatonicScales);
        Utils.setAddArray(ret, this.allBebopScales);
        Utils.setAddArray(ret, ScalePrecalc.symmetricScales);

        return ret;
    }

    public static get symmetricScales(): Scale[] {
        return [
            ScalePrecalc.CHROMATIC,
            ScalePrecalc.WHOLE_TONE,
            ScalePrecalc.AUGMENTED_TRIAD,
            ScalePrecalc.DIMINISHED_7th,
            ScalePrecalc.MESSIAEN_V_TRUNCATED,
            ScalePrecalc.DOM7b5,
            ScalePrecalc.MESSIAEN_INV_III_V_TRUNCATED_n2,
            ScalePrecalc.HALF_DIMINISHED,
            ScalePrecalc.MESSIAEN_V,
            ScalePrecalc.RAGA_INDRUPRIYA_INDIA,
            ScalePrecalc.MESSIAEN_II_TRUNCATED_n3,
            ScalePrecalc.MESSIAEN_III_INV,
            ScalePrecalc.MESSIAEN_IV,
            ScalePrecalc.MESSIAEN_VI,
            ScalePrecalc.MESSIAEN_VII
        ];
    }
}
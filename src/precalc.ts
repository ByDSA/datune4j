import { DiatonicAlt } from './degrees/DiatonicAlt';
import { Scale } from './tonality/Scale';
import { ScaleModeUtils } from './tonality/ScaleModeUtils';
import { SourceScaleUtils } from './tonality/SourceScaleUtils';
import { Tonality } from './tonality/Tonality';
import { Chromatic } from './degrees/Chromatic';
import { Diatonic } from './degrees/Diatonic';
import { ChromaticChordPattern } from './chords/chromatic/ChromaticChordPattern';

// DIATONICS
export function diatonics() {
    (<any>Diatonic).initialize();
}

// DIATONIC ALTS
export function diatonicAlts() {
    (<any>DiatonicAlt).initialize();
}

// CHROMATICS
export function chromatics() {
    (<any>Chromatic).initialize();
}

// CHROMATIC CHORD PATTERNS
export function chromaticChordPatterns() {
    (<any>ChromaticChordPattern).initialize();
}

// SCALES
export function scales() {
    Scale.MAJOR = Scale.from(2, 2, 1, 2, 2, 2, 1);
    Scale.DORIAN = ScaleModeUtils.getMode(Scale.MAJOR, 2);
    Scale.PHRYGIAN = ScaleModeUtils.getMode(Scale.MAJOR, 3);
    Scale.LYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 4);
    Scale.MIXOLYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 5);
    Scale.MINOR = ScaleModeUtils.getMode(Scale.MAJOR, 6);
    Scale.LOCRIAN = ScaleModeUtils.getMode(Scale.MAJOR, 7);

    Scale.HARMONIC_MINOR = Scale.from(2, 1, 2, 2, 1, 3, 1);
    Scale.LOCRIAN_a6 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 2);
    Scale.IONIAN_a5 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 3);
    Scale.DORIAN_a4 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 4);
    Scale.MIXOLYDIAN_b9_b13 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 5);
    Scale.LYDIAN_a2 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 6);
    Scale.SUPERLOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 7);

    Scale.HARMONIC_MAJOR = Scale.from(2, 2, 1, 2, 1, 3, 1);
    Scale.DORIAN_b5 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 2);
    Scale.PHRYGIAN_b4 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 3);
    Scale.LYDIAN_b3 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 4);
    Scale.MIXOLYDIAN_b2 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 5);
    Scale.AEOLIAN_b1 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 6);
    Scale.LOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 7);

    Scale.MELODIC_MINOR = Scale.from(2, 1, 2, 2, 2, 2, 1);
    Scale.DORIAN_b2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 2);
    Scale.LYDIAN_a5 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 3);
    Scale.LYDIAN_b7 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 4);
    Scale.MIXOLYDIAN_b13 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 5);
    Scale.LOCRIAN_a2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 6);
    Scale.SUPERLOCRIAN = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 7);

    Scale.DOUBLE_HARMONIC = Scale.from(1, 3, 1, 2, 1, 3, 1);
    Scale.LYDIAN_a2_a6 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 2);
    Scale.ULTRAPHRYGIAN = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 3);
    Scale.HUNGARIAN_MINOR = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 4);
    Scale.ORIENTAL = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 5);
    Scale.IONIAN_AUGMENTED_a2 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 6);
    Scale.LOCRIAN_bb3_bb7 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 7);

    Scale.NEAPOLITAN_MINOR = Scale.from(1, 2, 2, 2, 1, 3, 1);
    Scale.NEAPOLITAN_MAJOR = Scale.from(1, 2, 2, 2, 2, 2, 1);

    // 6
    Scale.BLUES_b5 = Scale.from(3, 2, 1, 1, 3, 2);

    // 5
    Scale.PENTATONIC_MINOR = Scale.from(3, 2, 2, 3, 2);
    Scale.PENTATONIC = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 2);
    Scale.EGYPCIAN = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 3);
    Scale.BLUES_MINOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 4);
    Scale.BLUES_MAJOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 5);

    // Symmetric
    Scale.CHROMATIC = Scale.from(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    Scale.WHOLE_TONE = Scale.from(2, 2, 2, 2, 2, 2);
    Scale.AUGMENTED_TRIAD = Scale.from(4, 4, 4);
    Scale.DIMINISHED_7th = Scale.from(3, 3, 3, 3);
    Scale.MESSIAEN_V_TRUNCATED = Scale.from(1, 5, 1, 5);
    Scale.DOM7b5 = Scale.from(4, 2, 4, 2);
    Scale.MESSIAEN_INV_III_V_TRUNCATED_n2 = Scale.from(1, 3, 1, 3, 1, 3);
    Scale.HALF_DIMINISHED = Scale.from(1, 2, 1, 2, 1, 2, 1, 2);
    Scale.MESSIAEN_V = Scale.from(1, 1, 4, 1, 1, 4);
    Scale.RAGA_INDRUPRIYA_INDIA = Scale.from(1, 3, 2, 3, 1, 2);
    Scale.MESSIAEN_II_TRUNCATED_n3 = Scale.from(3, 1, 2, 3, 1, 2);
    Scale.MESSIAEN_III_INV = Scale.from(2, 1, 1, 2, 1, 1, 2, 1, 1);
    Scale.MESSIAEN_IV = Scale.from(1, 1, 1, 3, 1, 1, 1, 3);
    Scale.MESSIAEN_VI = Scale.from(1, 1, 2, 2, 1, 1, 2, 2);
    Scale.MESSIAEN_VII = Scale.from(1, 1, 1, 1, 2, 1, 1, 1, 1, 2);

    // Bebop
    Scale.BEBOP_MAJOR = Scale.from(2, 2, 1, 2, 1, 1, 2, 1);


    Scale.allDiatonicScales = function () {
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

    Scale.allHeptatonicScales = function () {
        return []
            .concat(this.allDiatonicScales())
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

    Scale.allBebopScales = function () {
        return [
            this.BEBOP_MAJOR
        ];
    }

    Scale.allPentatonicScales = function () {
        return [
            this.PENTATONIC_MINOR,
            this.PENTATONIC,
            this.EGYPCIAN,
            this.BLUES_MINOR
        ];
    }

    Scale.allHexatonicScales = function () {
        return [
            this.BLUES_b5,
            //this.BLUES_a4,
            this.WHOLE_TONE
        ];
    }

    Scale.all = function (): Scale[] {
        let ret: Scale[];
        ret = Scale.allHeptatonicScales();
        ret = ret.concat(Scale.allPentatonicScales());
        ret = ret.concat(Scale.allHexatonicScales());
        ret = ret.concat(Scale.allBebopScales());
        ret = ret.concat(Scale.symmetricScales());

        return ret;
    }

    Scale.symmetricScales = function () {
        return [
            Scale.CHROMATIC,
            Scale.WHOLE_TONE,
            Scale.AUGMENTED_TRIAD,
            Scale.DIMINISHED_7th,
            Scale.MESSIAEN_V_TRUNCATED,
            Scale.DOM7b5,
            Scale.MESSIAEN_INV_III_V_TRUNCATED_n2,
            Scale.HALF_DIMINISHED,
            Scale.MESSIAEN_V,
            Scale.RAGA_INDRUPRIYA_INDIA,
            Scale.MESSIAEN_II_TRUNCATED_n3,
            Scale.MESSIAEN_III_INV,
            Scale.MESSIAEN_IV,
            Scale.MESSIAEN_VI,
            Scale.MESSIAEN_VII
        ];
    };
};

// SOURCE SCALES
export function sourceScales() {
    (<any>SourceScaleUtils)._sourceScales = [
        Scale.MAJOR,
        Scale.HARMONIC_MINOR,
        Scale.MELODIC_MINOR,
        Scale.HARMONIC_MAJOR,
        Scale.DOUBLE_HARMONIC,
        Scale.PENTATONIC
    ];

    // Static initialization
    (<any>SourceScaleUtils).sourceScaleMapInitialize();

};

// TONALITIES
export function tonalities() {
    Tonality.C = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
    Tonality.CC = Tonality.from(DiatonicAlt.CC, Scale.MAJOR);
    Tonality.D = Tonality.from(DiatonicAlt.D, Scale.MAJOR);
    Tonality.DD = Tonality.from(DiatonicAlt.DD, Scale.MAJOR);
    Tonality.E = Tonality.from(DiatonicAlt.E, Scale.MAJOR);
    Tonality.F = Tonality.from(DiatonicAlt.F, Scale.MAJOR);
    Tonality.FF = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);
    Tonality.G = Tonality.from(DiatonicAlt.G, Scale.MAJOR);
    Tonality.GG = Tonality.from(DiatonicAlt.GG, Scale.MAJOR);
    Tonality.A = Tonality.from(DiatonicAlt.A, Scale.MAJOR);
    Tonality.B = Tonality.from(DiatonicAlt.B, Scale.MAJOR);

    Tonality.Cm = Tonality.from(DiatonicAlt.C, Scale.MINOR);
    Tonality.CCm = Tonality.from(DiatonicAlt.CC, Scale.MINOR);
    Tonality.Dm = Tonality.from(DiatonicAlt.D, Scale.MINOR);
    Tonality.DDm = Tonality.from(DiatonicAlt.DD, Scale.MINOR);
    Tonality.Em = Tonality.from(DiatonicAlt.E, Scale.MINOR);
    Tonality.Fm = Tonality.from(DiatonicAlt.F, Scale.MINOR);
    Tonality.FFm = Tonality.from(DiatonicAlt.FF, Scale.MINOR);
    Tonality.Gm = Tonality.from(DiatonicAlt.G, Scale.MINOR);
    Tonality.GGm = Tonality.from(DiatonicAlt.GG, Scale.MINOR);
    Tonality.Am = Tonality.from(DiatonicAlt.A, Scale.MINOR);
    Tonality.Bm = Tonality.from(DiatonicAlt.B, Scale.MINOR);
};

export function all() {
    diatonics();
    diatonicAlts();
    chromatics();
    chromaticChordPatterns();
    scales();
    sourceScales();
    tonalities();
}
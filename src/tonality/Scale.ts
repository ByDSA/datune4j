import { DiatonicAltChordPattern } from '../chords/diatonicalt/DiatonicAltChordPattern';
import { DiatonicAltDegree } from '../degrees/scale/DiatonicAltDegree';
import { DiatonicDegree } from '../degrees/scale/DiatonicDegree';
import { DegreeFunction } from '../function/DegreeFunction';
import { NamingScale } from '../lang/naming/NamingScale';
import { Hashable } from '../Utils/Hashable';
import { Hashing } from '../Utils/Hashing';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { ScaleModeUtils } from './ScaleModeUtils';
import { ScaleUtils } from './ScaleUtils';

export class Scale implements Hashable {
    static MAJOR: Scale;
    static DORIAN: Scale;
    static PHRYGIAN: Scale;
    static LYDIAN: Scale;
    static MIXOLYDIAN: Scale;
    static MINOR: Scale;
    static LOCRIAN: Scale;

    static HARMONIC_MINOR: Scale;
    static LOCRIAN_a6: Scale;
    static IONIAN_a5: Scale;
    static DORIAN_a4: Scale;
    static MIXOLYDIAN_b9_b13: Scale;
    static LYDIAN_a2: Scale;
    static SUPERLOCRIAN_bb7: Scale;

    static HARMONIC_MAJOR: Scale;
    static DORIAN_b5: Scale;
    static PHRYGIAN_b4: Scale;
    static LYDIAN_b3: Scale;
    static MIXOLYDIAN_b2: Scale;
    static AEOLIAN_b1: Scale;
    static LOCRIAN_bb7: Scale;

    static MELODIC_MINOR: Scale;
    static DORIAN_b2: Scale;
    static LYDIAN_a5: Scale;
    static LYDIAN_b7: Scale;
    static MIXOLYDIAN_b13: Scale;
    static LOCRIAN_a2: Scale;
    static SUPERLOCRIAN: Scale;

    static DOUBLE_HARMONIC: Scale;
    static LYDIAN_a2_a6: Scale;
    static ULTRAPHRYGIAN: Scale;
    static HUNGARIAN_MINOR: Scale;
    static ORIENTAL: Scale;
    static IONIAN_AUGMENTED_a2: Scale;
    static LOCRIAN_bb3_bb7: Scale;

    static NEAPOLITAN_MINOR: Scale;
    static NEAPOLITAN_MAJOR: Scale;

    // 6
    static BLUES_b5: Scale;

    // 5
    static PENTATONIC_MINOR: Scale;
    static PENTATONIC: Scale;
    static EGYPCIAN: Scale;
    static BLUES_MINOR: Scale;
    static BLUES_MAJOR: Scale;

    // Symmetric
    static CHROMATIC: Scale;
    static WHOLE_TONE: Scale;
    static AUGMENTED_TRIAD: Scale;
    static DIMINISHED_7th: Scale;
    static MESSIAEN_V_TRUNCATED: Scale;
    static DOM7b5: Scale;
    static MESSIAEN_INV_III_V_TRUNCATED_n2: Scale;
    static HALF_DIMINISHED: Scale;
    static MESSIAEN_V: Scale;
    static RAGA_INDRUPRIYA_INDIA: Scale;
    static MESSIAEN_II_TRUNCATED_n3: Scale;
    static MESSIAEN_III_INV: Scale;
    static MESSIAEN_IV: Scale;
    static MESSIAEN_VI: Scale;
    static MESSIAEN_VII: Scale;

    // Bebop
    static BEBOP_MAJOR: Scale;

    static allDiatonicScales: () => Scale[];

    static allHeptatonicScales: () => Scale[];

    static allBebopScales: () => Scale[];

    static allPentatonicScales: () => Scale[];

    static allHexatonicScales: () => Scale[];

    static all: () => Scale[];

    static symmetricScales: () => Scale[];

    private static immutablesCache = new ImmutablesCache<Scale, number[]>(
        function (hashingObject: number[]) {
            return Hashing.hashArray(hashingObject);
        },
        function (scale: Scale) {
            return scale._distances;
        },
        function (intervals: number[]): Scale {
            return new Scale(...intervals);
        }
    );

    private _distances: number[];
    private _absoluteIntervals: DiatonicAltDegree[] = null;
    private _absoluteDistances: number[] = null;
    private _modes: Scale[] = null;

    private constructor(...distances: number[]) {
        this._distances = distances;
    }

    public static from(...distances: number[]): Scale {
        return Scale.immutablesCache.getOrCreate(distances);
    }

    // Relative Intervals

    public get distances(): number[] {
        return Array.from(this._distances);
    }

    // Modes

    public get modes(): Scale[] {
        if (!this._modes)
            this.calculateModes();

        return this._modes;
    }

    private calculateModes(): void {
        let scaleTmp: Scale = this;
        this._modes = [this];
        while (true) {
            scaleTmp = ScaleModeUtils.getRotatedScale(scaleTmp, 1);
            if (scaleTmp == this)
                break;
            this._modes.push(scaleTmp);
        }
    }

    // Absolute Intervals

    public get absoluteIntervals(): DiatonicAltDegree[] {
        if (this._absoluteIntervals == null) {
            this._absoluteIntervals = this.calculateAbsoluteIntervals();
        }

        return this._absoluteIntervals;
    }

    public get absoluteDistances(): number[] {
        if (this._absoluteDistances == null) {
            this._absoluteDistances = this.calculateAbsoluteDistances();
        }

        return this._absoluteDistances;
    }

    private calculateAbsoluteDistances(): number[] {
        let absoluteDistances = [0];

        let relativeIntervals = this.distances;
        relativeIntervals.pop();

        let acc = 0;
        for (let i = 0; i < relativeIntervals.length; i++) {
            let n = relativeIntervals[i];
            acc += n;
            absoluteDistances.push(acc);
        };

        return absoluteDistances;
    }

    private calculateAbsoluteIntervals(): DiatonicAltDegree[] {
        let absoluteIntervals = [DiatonicAltDegree.I];

        let relativeIntervals = this.distances;
        relativeIntervals.pop();

        let acc = 0;
        for (let i = 1; i <= relativeIntervals.length; i++) {
            let n = relativeIntervals[i - 1];
            acc += n;
            let alts = 0;
            let iFixed = ScaleUtils.getRefNum(this, i);
            if (this != Scale.MAJOR)
                alts = acc - Scale.MAJOR.absoluteDistances[iFixed];

            let diatonicDegree = DiatonicDegree.fromInt(iFixed);
            let diatonicAltDegree = DiatonicAltDegree.from(diatonicDegree, alts);
            absoluteIntervals.push(diatonicAltDegree);
        };

        return absoluteIntervals;
    }

    get degreeFunctions(): DegreeFunction[] {
        let ret: DegreeFunction[] = [];
        let diatonicAltChordPatterns: DiatonicAltChordPattern[] = DiatonicAltChordPattern.all();

        for (const diatonicAltDegree of this.absoluteIntervals) {
            patternLoop: for (const diatonicAltChordPattern of diatonicAltChordPatterns) {
                let degreeFunction = DegreeFunction.from(diatonicAltDegree, diatonicAltChordPattern);
                for (let diatonicAltDegree2 of degreeFunction.degrees) {
                    if (!this.absoluteIntervals.includes(diatonicAltDegree2))
                        continue patternLoop;
                }
                ret.push(degreeFunction);
            }
        }

        return ret;
    }

    // General

    public get length(): number {
        return this._distances.length;
    }

    public toString(): string {
        return NamingScale.toString(this);
    }

    public clone(): Scale {
        let scale = new Scale(0);
        scale._distances = this.distances;
        return scale;
    }

    hashCode(): string {
        return Hashing.hashArray(this.distances);
    }

    private static initialize() {
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
    }
}
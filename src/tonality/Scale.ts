import { DiatonicAltChordPattern } from '../chords/diatonicalt/DiatonicAltChordPattern';
import { Chromatic } from '../degrees/Chromatic';
import { Diatonic } from '../degrees/Diatonic';
import { DiatonicAltDegree } from '../degrees/scale/DiatonicAltDegree';
import { DiatonicDegree } from '../degrees/scale/DiatonicDegree';
import { DegreeFunction } from '../function/DegreeFunction';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { NamingScale } from '../lang/naming/NamingScale';
import { Hashable } from '../Utils/Hashable';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { MathUtils } from '../Utils/MathUtils';
import { ScaleModeUtils } from './ScaleModeUtils';

type Reparametrizer = (i, acc) => number;
type HashingObject = IntervalDiatonicAlt[];
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

    static sets = (class {
        static allDiatonicScales: () => Scale[];

        static allHeptatonicScales: () => Scale[];

        static allBebopScales: () => Scale[];

        static allPentatonicScales: () => Scale[];

        static allHexatonicScales: () => Scale[];

        static all: () => Scale[];

        static symmetricScales: () => Scale[];
    });

    private static immutablesCache = new ImmutablesCache<Scale, HashingObject>(
        function (hashingObject: HashingObject): string {
            let ret = "";
            for (const interval of hashingObject)
                ret += interval.hashCode();
            return ret;
        },
        function (scale: Scale): HashingObject {
            return scale.intervals;
        },
        function (hashingObject: HashingObject): Scale {
            return new Scale(...hashingObject);
        }
    );

    private _degrees: DiatonicAltDegree[] = null;
    private _modes: Scale[] = null;
    reparametrizer: (i, acc) => number;

    private constructor(...intervals: IntervalDiatonicAlt[]) {
        this._intervals = intervals;
        Object.freeze(this._intervals);
    }

    public static fromIntCode(d1: number, d2: number, d3: number, d4: number, d5: number, d6: number, d7: number): Scale {
        let degrees = this.distances2Degrees([d1, d2, d3, d4, d5, d6, d7]);
        let scale = this.fromDegrees((i) => i, ...degrees);
        if (!Object.isFrozen(scale._degrees)) {
            scale._degrees = degrees;
            Object.freeze(scale._degrees);
        }

        return scale;
    }

    public static fromReparam(reparametrizer: Reparametrizer, ...distances: number[]): Scale {
        let degrees = this.distances2Degrees(distances, reparametrizer);
        return this.fromDegrees(reparametrizer, ...degrees);
    }

    public static fromDegrees(reparametrizer: Reparametrizer, ...degrees: DiatonicAltDegree[]): Scale {
        let intervals = this.degrees2Intervals(reparametrizer, degrees);
        return this.fromIntervals(...intervals);
    }

    public static fromIntervals(...intervals: IntervalDiatonicAlt[]): Scale {
        return Scale.immutablesCache.getOrCreate(intervals);
    }

    private static degrees2Intervals(reparametrizer: Reparametrizer, degrees: DiatonicAltDegree[]): IntervalDiatonicAlt[] {
        let intervals: IntervalDiatonicAlt[] = [];
        for (let i = 1; i <= degrees.length; i++) {
            let degree = degrees[i % degrees.length];
            let prevDegree = degrees[i - 1];
            let distDiatonicInt = degree.diatonicDegree.intValue - prevDegree.diatonicDegree.intValue;
            distDiatonicInt = MathUtils.rotativeTrim(distDiatonicInt, Diatonic.NUMBER);
            let distChromaticInt = degree.semis - prevDegree.semis;
            distChromaticInt = MathUtils.rotativeTrim(distChromaticInt, Chromatic.NUMBER);
            let interval = IntervalDiatonicAlt.from(distChromaticInt, distDiatonicInt);
            intervals.push(interval);
        }

        return intervals;
    }

    private static distances2Degrees(distances: number[], reparametrizer = (i, acc) => i): DiatonicAltDegree[] {
        let degrees: DiatonicAltDegree[] = [DiatonicAltDegree.I];
        let distancesAcc = 0;
        for (let i = 2; i <= distances.length; i++) {
            distancesAcc += distances[i - 2];
            let iFixed = reparametrizer(i, distancesAcc);
            let diatonicDegree = DiatonicDegree.fromInt(iFixed - 1);
            let alts = distancesAcc - Scale.MAJOR.degrees[iFixed - 1].semis;
            let degree: DiatonicAltDegree = DiatonicAltDegree.from(diatonicDegree, alts);
            degrees.push(degree);
        }

        return degrees;
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

    public get degrees(): DiatonicAltDegree[] {
        if (this._degrees == null)
            this.calculateDegrees();
        return this._degrees;
    }

    private calculateDegrees() {
        this._degrees = [DiatonicAltDegree.I];
        for (let i = 0; i < this._intervals.length - 1; i++) {
            const interval = this._intervals[i];
            let diatonicAltDegree = this._degrees[this._degrees.length - 1].getAdd(interval);
            this._degrees.push(diatonicAltDegree);
        }
        Object.freeze(this._degrees);
    }

    get degreeFunctions(): DegreeFunction[] {
        let ret: DegreeFunction[] = [];
        let diatonicAltChordPatterns: DiatonicAltChordPattern[] = DiatonicAltChordPattern.all();

        for (const diatonicAltDegree of this.degrees) {
            patternLoop: for (const diatonicAltChordPattern of diatonicAltChordPatterns) {
                let degreeFunction = DegreeFunction.from(diatonicAltDegree, diatonicAltChordPattern);
                for (let diatonicAltDegree2 of degreeFunction.degrees) {
                    if (!this.degrees.includes(diatonicAltDegree2))
                        continue patternLoop;
                }
                ret.push(degreeFunction);
            }
        }

        return ret;
    }

    // General

    public get length(): number {
        return this._intervals.length;
    }

    public toString(): string {
        return NamingScale.toString(this);
    }

    public clone(): Scale {
        let scale = new Scale();
        scale._degrees = this.degrees;
        return scale;
    }

    hashCode(): string {
        let ret = "";
        for (const interval of this._intervals)
            ret += "-" + interval.hashCode();
            
        return ret;
    }

    private _intervals: IntervalDiatonicAlt[];
    get intervals(): IntervalDiatonicAlt[] {
        return Array.from(this._intervals);
    }

    private static initialize() {
        Scale.MAJOR = Scale.fromDegrees(
            (i) => i,
            DiatonicAltDegree.I,
            DiatonicAltDegree.II,
            DiatonicAltDegree.III,
            DiatonicAltDegree.IV,
            DiatonicAltDegree.V,
            DiatonicAltDegree.VI,
            DiatonicAltDegree.VII,
        );
        Scale.MAJOR._degrees = [
            DiatonicAltDegree.I,
            DiatonicAltDegree.II,
            DiatonicAltDegree.III,
            DiatonicAltDegree.IV,
            DiatonicAltDegree.V,
            DiatonicAltDegree.VI,
            DiatonicAltDegree.VII
        ];

        Scale.MINOR = ScaleModeUtils.getMode(Scale.MAJOR, 6);

        Scale.DORIAN = ScaleModeUtils.getMode(Scale.MAJOR, 2);
        Scale.PHRYGIAN = ScaleModeUtils.getMode(Scale.MAJOR, 3);
        Scale.LYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 4);
        Scale.MIXOLYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 5);
        Scale.LOCRIAN = ScaleModeUtils.getMode(Scale.MAJOR, 7);

        Scale.HARMONIC_MINOR = Scale.fromIntCode(2, 1, 2, 2, 1, 3, 1);
        Scale.LOCRIAN_a6 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 2);
        Scale.IONIAN_a5 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 3);
        Scale.DORIAN_a4 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 4);
        Scale.MIXOLYDIAN_b9_b13 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 5);
        Scale.LYDIAN_a2 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 6);
        Scale.SUPERLOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 7);

        Scale.HARMONIC_MAJOR = Scale.fromIntCode(2, 2, 1, 2, 1, 3, 1);
        Scale.DORIAN_b5 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 2);
        Scale.PHRYGIAN_b4 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 3);
        Scale.LYDIAN_b3 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 4);
        Scale.MIXOLYDIAN_b2 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 5);
        Scale.AEOLIAN_b1 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 6);
        Scale.LOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 7);

        Scale.MELODIC_MINOR = Scale.fromIntCode(2, 1, 2, 2, 2, 2, 1);
        Scale.DORIAN_b2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 2);
        Scale.LYDIAN_a5 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 3);
        Scale.LYDIAN_b7 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 4);
        Scale.MIXOLYDIAN_b13 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 5);
        Scale.LOCRIAN_a2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 6);
        Scale.SUPERLOCRIAN = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 7);

        Scale.DOUBLE_HARMONIC = Scale.fromIntCode(1, 3, 1, 2, 1, 3, 1);
        Scale.LYDIAN_a2_a6 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 2);
        Scale.ULTRAPHRYGIAN = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 3);
        Scale.HUNGARIAN_MINOR = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 4);
        Scale.ORIENTAL = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 5);
        Scale.IONIAN_AUGMENTED_a2 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 6);
        Scale.LOCRIAN_bb3_bb7 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 7);

        Scale.NEAPOLITAN_MINOR = Scale.fromIntCode(1, 2, 2, 2, 1, 3, 1);
        Scale.NEAPOLITAN_MAJOR = Scale.fromIntCode(1, 2, 2, 2, 2, 2, 1);


        let reparametrizers = {
            BLUES_b5: (i) => (i > 1 ? i + 1 : i),
            PENTATONIC_MINOR: (i) => {
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        return i + 1;
                    case 5: return i + 2;
                }

                return i;
            },
            default: (i, acc) => {
                switch (acc) {
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 2;
                    case 4:
                        return 3;
                    case 5:
                    case 6:
                        return 4;
                    case 7:
                    case 8:
                        return 5;
                    case 9:
                    case 10:
                        return 6;
                    case 11:
                        return 7;
                }
            },
            BLUES_a4: (i) => {
                switch (i) {
                    case 2:
                    case 3:
                        return i + 1;
                }

                return i;
            },
            PENTATONIC: (i) => {
                switch (i) {
                    case 4:
                    case 5: return i + 1;
                }

                return i;
            },
            EGYPCIAN: (i) => {
                switch (i) {
                    case 3:
                    case 4: return i + 1;
                    case 5: return i + 2;
                }

                return i;
            },
            BLUES_MINOR: (i) => {
                switch (i) {
                    case 2:
                    case 3: return i + 1;
                    case 4:
                    case 5:
                        return i + 2;
                }

                return i;
            },
            BLUES_MAJOR: (i) => {
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                        return i + 1;
                }

                return i;
            },
            BEBOP_MAJOR: (i) => {
                switch (i) {
                    case 7:
                    case 8:
                        return i - 1;
                }

                return i;
            },
            AUGMENTED_TRIAD: (i) => {
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                }

                return i;
            },
            DIMINISHED_7th: (i) => {
                return reparametrizers.DOM7b5(i);
            },
            DOM7b5: (i) => {
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                    case 4: return 7;
                }

                return i;
            }
        };


        // 6
        Scale.BLUES_b5 = Scale.fromReparam(
            reparametrizers.BLUES_b5,
            3, 2, 1, 1, 3, 2
        );

        // 5
        Scale.PENTATONIC_MINOR = Scale.fromReparam(
            reparametrizers.PENTATONIC_MINOR,
            3, 2, 2, 3, 2
        );
        Scale.PENTATONIC = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 2);
        Scale.EGYPCIAN = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 3);
        Scale.BLUES_MINOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 4);
        Scale.BLUES_MAJOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 5);

        // Symmetric
        Scale.CHROMATIC = Scale.fromReparam(reparametrizers.default, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        Scale.WHOLE_TONE = Scale.fromReparam(reparametrizers.default, 2, 2, 2, 2, 2, 2);
        Scale.AUGMENTED_TRIAD = Scale.fromReparam(reparametrizers.default, 4, 4, 4);
        Scale.DIMINISHED_7th = Scale.fromReparam(reparametrizers.DIMINISHED_7th, 3, 3, 3, 3);
        Scale.MESSIAEN_V_TRUNCATED = Scale.fromReparam(reparametrizers.default, 1, 5, 1, 5);
        Scale.DOM7b5 = Scale.fromReparam(reparametrizers.DOM7b5, 4, 2, 4, 2);
        Scale.MESSIAEN_INV_III_V_TRUNCATED_n2 = Scale.fromReparam(reparametrizers.default, 1, 3, 1, 3, 1, 3);
        Scale.HALF_DIMINISHED = Scale.fromReparam(reparametrizers.default, 1, 2, 1, 2, 1, 2, 1, 2);
        Scale.MESSIAEN_V = Scale.fromReparam(reparametrizers.default, 1, 1, 4, 1, 1, 4);
        Scale.RAGA_INDRUPRIYA_INDIA = Scale.fromReparam(reparametrizers.default, 1, 3, 2, 3, 1, 2);
        Scale.MESSIAEN_II_TRUNCATED_n3 = Scale.fromReparam(reparametrizers.default, 3, 1, 2, 3, 1, 2);
        Scale.MESSIAEN_III_INV = Scale.fromReparam(reparametrizers.default, 2, 1, 1, 2, 1, 1, 2, 1, 1);
        Scale.MESSIAEN_IV = Scale.fromReparam(reparametrizers.default, 1, 1, 1, 3, 1, 1, 1, 3);
        Scale.MESSIAEN_VI = Scale.fromReparam(reparametrizers.default, 1, 1, 2, 2, 1, 1, 2, 2);
        Scale.MESSIAEN_VII = Scale.fromReparam(reparametrizers.default, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2);

        // Bebop
        Scale.BEBOP_MAJOR = Scale.fromReparam(reparametrizers.BEBOP_MAJOR, 2, 2, 1, 2, 1, 1, 2, 1);


        Scale.sets.allDiatonicScales = function () {
            return [
                Scale.MAJOR,
                Scale.DORIAN,
                Scale.PHRYGIAN,
                Scale.LYDIAN,
                Scale.MIXOLYDIAN,
                Scale.MINOR,
                Scale.LOCRIAN
            ];
        }

        Scale.sets.allHeptatonicScales = function () {
            return []
                .concat(Scale.sets.allDiatonicScales())
                .concat([
                    Scale.HARMONIC_MINOR,
                    Scale.LOCRIAN_a6,
                    Scale.IONIAN_a5,
                    Scale.DORIAN_a4,
                    Scale.MIXOLYDIAN_b9_b13,
                    Scale.LYDIAN_a2,
                    Scale.SUPERLOCRIAN_bb7,

                    Scale.HARMONIC_MAJOR,
                    Scale.DORIAN_b5,
                    Scale.PHRYGIAN_b4,
                    Scale.LYDIAN_b3,
                    Scale.MIXOLYDIAN_b2,
                    Scale.AEOLIAN_b1,
                    Scale.LOCRIAN_bb7,

                    Scale.MELODIC_MINOR,
                    Scale.DORIAN_b2,
                    Scale.LYDIAN_a5,
                    Scale.LYDIAN_b7,
                    Scale.MIXOLYDIAN_b13,
                    Scale.LOCRIAN_a2,
                    Scale.SUPERLOCRIAN,

                    Scale.DOUBLE_HARMONIC,
                    Scale.LYDIAN_a2_a6,
                    Scale.ULTRAPHRYGIAN,
                    Scale.HUNGARIAN_MINOR,
                    Scale.ORIENTAL,
                    Scale.IONIAN_AUGMENTED_a2,
                    Scale.LOCRIAN_bb3_bb7,

                    Scale.NEAPOLITAN_MINOR,
                    Scale.NEAPOLITAN_MAJOR
                ]);
        }

        Scale.sets.allBebopScales = function () {
            return [
                Scale.BEBOP_MAJOR
            ];
        }

        Scale.sets.allPentatonicScales = function () {
            return [
                Scale.PENTATONIC_MINOR,
                Scale.PENTATONIC,
                Scale.EGYPCIAN,
                Scale.BLUES_MINOR
            ];
        }

        Scale.sets.allHexatonicScales = function () {
            return [
                Scale.BLUES_b5,
                //Scale.BLUES_a4,
                Scale.WHOLE_TONE
            ];
        }

        Scale.sets.all = function (): Scale[] {
            let ret: Scale[];
            ret = Scale.sets.allHeptatonicScales();
            ret = ret.concat(Scale.sets.allPentatonicScales());
            ret = ret.concat(Scale.sets.allHexatonicScales());
            ret = ret.concat(Scale.sets.allBebopScales());
            ret = ret.concat(Scale.sets.symmetricScales());

            return ret;
        }

        Scale.sets.symmetricScales = function () {
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
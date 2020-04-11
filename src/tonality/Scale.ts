import { Hashable } from '../Utils/Hashable';
import { Hashing } from '../Utils/Hashing';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { NamingScale } from '../lang/naming/NamingScale';
import { ScaleModeUtils } from './ScaleModeUtils';

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
            return scale._intervals;
        },
        function (intervals: number[]): Scale {
            return new Scale(...intervals);
        }
    );

    private _intervals: number[];
    private _absoluteIntervals: number[] = null;
    private _modes: Scale[] = null;

    private constructor(...intervals: number[]) {
        this._intervals = intervals;
    }

    public static from(...intervals: number[]): Scale {
        return Scale.immutablesCache.getOrCreate(intervals);
    }

    // Relative Intervals

    public get intervals(): number[] {
        return Array.from(this._intervals);
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

    public get absoluteIntervals() {
        if (this._absoluteIntervals == null)
            this._absoluteIntervals = this.calculateAbsoluteIntervals();

        return this._absoluteIntervals;
    }

    private calculateAbsoluteIntervals(): number[] {
        let absoluteIntervals = [0];

        let relativeIntervals = this.intervals;
        relativeIntervals.pop();

        let acc = 0;
        relativeIntervals.forEach(n => {
            acc += n;
            absoluteIntervals.push(acc);
        });

        return absoluteIntervals;
    }

    // General

    public get length(): number {
        return this._intervals.length;
    }

    public toString(): string {
        return NamingScale.toString(this);
    }

    public clone(): Scale {
        let scale = new Scale(0);
        scale._intervals = this.intervals;
        return scale;
    }

    hashCode(): string {
        return Hashing.hashArray(this.intervals);
    }
}
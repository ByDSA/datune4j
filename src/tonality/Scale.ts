import { Hashable } from '../Hashable';
import { Hashing } from '../Hashing';
import { Immutables } from '../Immutables';
import { NamingScale } from '../lang/naming/NamingScale';
import { ScaleModeUtils } from './ScaleModeUtils';

export class Scale implements Hashable {
    static MAJOR;
    static DORIAN;
    static PHRYGIAN;
    static LYDIAN;
    static MIXOLYDIAN;
    static MINOR;
    static LOCRIAN;

    static HARMONIC_MINOR;
    static LOCRIAN_a6;
    static IONIAN_a5;
    static DORIAN_a4;
    static MIXOLYDIAN_b9_b13;
    static LYDIAN_a2;
    static SUPERLOCRIAN_bb7;

    static HARMONIC_MAJOR;
    static DORIAN_b5;
    static PHRYGIAN_b4;
    static LYDIAN_b3;
    static MIXOLYDIAN_b2;
    static AEOLIAN_b1;
    static LOCRIAN_bb7;

    static MELODIC_MINOR;
    static DORIAN_b2;
    static LYDIAN_a5;
    static LYDIAN_b7;
    static MIXOLYDIAN_b13;
    static LOCRIAN_a2;
    static SUPERLOCRIAN;

    static DOUBLE_HARMONIC;
    static LYDIAN_a2_a6;
    static ULTRAPHRYGIAN;
    static HUNGARIAN_MINOR;
    static ORIENTAL;
    static IONIAN_AUGMENTED_a2;
    static LOCRIAN_bb3_bb7;

    static NEAPOLITAN_MINOR;
    static NEAPOLITAN_MAJOR;

    // 6
    static BLUES_b5;

    // 5
    static PENTATONIC_MINOR;
    static PENTATONIC;
    static EGYPCIAN;
    static BLUES_MINOR;
    static BLUES_MAJOR;

    // Symmetric
    static CHROMATIC;
    static WHOLE_TONE;
    static AUGMENTED_TRIAD;
    static DIMINISHED_7th;
    static MESSIAEN_V_TRUNCATED;
    static DOM7b5;
    static MESSIAEN_INV_III_V_TRUNCATED_n2;
    static HALF_DIMINISHED;
    static MESSIAEN_V;
    static RAGA_INDRUPRIYA_INDIA;
    static MESSIAEN_II_TRUNCATED_n3;
    static MESSIAEN_III_INV;
    static MESSIAEN_IV;
    static MESSIAEN_VI;
    static MESSIAEN_VII;

    // Bebop
    static BEBOP_MAJOR;

    static allDiatonicScales: () => Scale[];

    static allHeptatonicScales: () => Scale[];

    static allBebopScales: () => Scale[];

    static allPentatonicScales: () => Scale[];

    static allHexatonicScales: () => Scale[];

    static all: () => Scale[];

    static symmetricScales: () => Scale[];

    private static immutables = new Immutables<Scale, number[]>(
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
        return Scale.immutables.getOrCreate(intervals);
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
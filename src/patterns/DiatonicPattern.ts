import { Diatonic } from '../degrees/Diatonic';
import { DegreePattern } from './DegreePattern';

export class DiatonicPattern implements DegreePattern<Diatonic> {
    public static FIFTH;
    public static TRIAD;
    public static QUARTAL;
    public static SIXTH;
    public static SIXTH_ADD9;
    public static SEVENTH;
    public static SEVENTH_ADD11;
    public static SEVENTH_ADD13;
    public static NINTH;
    public static NINTH_SUS4;
    public static NINTH_ADD6;
    public static ELEVENTH;
    public static THIRTEENTH;
    public static THIRTEENTH_SUS4;
    public static SUS4;
    public static SEVENTH_SUS4;

    private _rootIndex: number;
    private _values: number[];

    private constructor(first?: number | number[], ...rest: number[]) {
        this._values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        this._rootIndex = 0;
    }

    public static from(first?: number | number[], ...rest: number[]): DiatonicPattern {
        let patternArray =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        return new DiatonicPattern(patternArray);
    }

    public get values(): number[] {
        return Array.from(this._values);
    }

    public get inversionNumber(): number {
        return (this.values.length - this.rootIndex) % this.values.length;
    }

    public get rootIndex(): number {
        return this._rootIndex;
    }

    public getInv(n: number = 1): DiatonicPattern {
        let values = this.values;
        for (let i = 0; i < n; i++) {
            let firstValue = values.shift();
            values.push(firstValue + Diatonic.NUMBER);
            values = values.map((value: number) => value - values[0]);
        }

        return DiatonicPattern.from(...values);
    }

    public get shortName(): string {
        return this.toString();
    }

    public toString(): string {
        return this._values.toString();
    }

    private static initialize() {
        this.FIFTH = DiatonicPattern.from(0, 4);
        this.TRIAD = DiatonicPattern.from(0, 2, 4);
        this.QUARTAL = DiatonicPattern.from(0, 3, 6);
        this.SIXTH = DiatonicPattern.from(0, 2, 4, 5);
        this.SIXTH_ADD9 = DiatonicPattern.from(0, 2, 4, 5, 8);
        this.SEVENTH = DiatonicPattern.from(0, 2, 4, 6);
        this.SEVENTH_ADD11 = DiatonicPattern.from(0, 2, 4, 6, 10);
        this.SEVENTH_ADD13 = DiatonicPattern.from(0, 2, 4, 6, 12);
        this.NINTH = DiatonicPattern.from(0, 2, 4, 6, 8);
        this.NINTH_SUS4 = DiatonicPattern.from(0, 3, 4, 6, 8);
        this.NINTH_ADD6 = DiatonicPattern.from(0, 2, 4, 5, 6, 8);
        this.ELEVENTH = DiatonicPattern.from(0, 2, 4, 6, 8, 10);
        this.THIRTEENTH = DiatonicPattern.from(0, 2, 4, 6, 8, 10, 12);
        this.THIRTEENTH_SUS4 = DiatonicPattern.from(0, 3, 4, 6, 8, 10, 12);
        this.SUS4 = DiatonicPattern.from(0, 3, 4);
        this.SEVENTH_SUS4 = DiatonicPattern.from(0, 3, 4, 6);
    }
}
export class DiatonicPattern {
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

    private _values: number[];
    private diatonicChordPattern: DiatonicPattern;

    private constructor(first?: number | number[], ...rest: number[]) {
        this._values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];
    }

    public static fromArray(first?: number | number[], ...rest: number[]): DiatonicPattern {
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

    public toString(): string {
        return this._values.toString();
    }

    private static initialize() {
        this.FIFTH = DiatonicPattern.fromArray(0, 4);
        this.TRIAD = DiatonicPattern.fromArray(0, 2, 4);
        this.QUARTAL = DiatonicPattern.fromArray(0, 3, 6);
        this.SIXTH = DiatonicPattern.fromArray(0, 2, 4, 5);
        this.SIXTH_ADD9 = DiatonicPattern.fromArray(0, 2, 4, 5, 8);
        this.SEVENTH = DiatonicPattern.fromArray(0, 2, 4, 6);
        this.SEVENTH_ADD11 = DiatonicPattern.fromArray(0, 2, 4, 6, 10);
        this.SEVENTH_ADD13 = DiatonicPattern.fromArray(0, 2, 4, 6, 12);
        this.NINTH = DiatonicPattern.fromArray(0, 2, 4, 6, 8);
        this.NINTH_SUS4 = DiatonicPattern.fromArray(0, 3, 4, 6, 8);
        this.NINTH_ADD6 = DiatonicPattern.fromArray(0, 2, 4, 5, 6, 8);
        this.ELEVENTH = DiatonicPattern.fromArray(0, 2, 4, 6, 8, 10);
        this.THIRTEENTH = DiatonicPattern.fromArray(0, 2, 4, 6, 8, 10, 12);
        this.THIRTEENTH_SUS4 = DiatonicPattern.fromArray(0, 3, 4, 6, 8, 10, 12);
        this.SUS4 = DiatonicPattern.fromArray(0, 3, 4);
        this.SEVENTH_SUS4 = DiatonicPattern.fromArray(0, 3, 4, 6);
    }
}
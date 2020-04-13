export class DiatonicChordPattern {
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
    private diatonicChordPattern: DiatonicChordPattern;

    private constructor(first?: number | number[], ...rest: number[]) {
        this._values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];
    }

    public static fromArray(first?: number | number[], ...rest: number[]): DiatonicChordPattern {
        let patternArray =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        return new DiatonicChordPattern(patternArray);
    }

    public get values(): number[] {
        return Array.from(this._values);
    }

    public toString(): string {
        return this._values.toString();
    }

    private static initialize() {
        this.FIFTH = DiatonicChordPattern.fromArray(0, 4);
        this.TRIAD = DiatonicChordPattern.fromArray(0, 2, 4);
        this.QUARTAL = DiatonicChordPattern.fromArray(0, 3, 6);
        this.SIXTH = DiatonicChordPattern.fromArray(0, 2, 4, 5);
        this.SIXTH_ADD9 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 8);
        this.SEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6);
        this.SEVENTH_ADD11 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 10);
        this.SEVENTH_ADD13 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 12);
        this.NINTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8);
        this.NINTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8);
        this.NINTH_ADD6 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 6, 8);
        this.ELEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10);
        this.THIRTEENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10, 12);
        this.THIRTEENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8, 10, 12);
        this.SUS4 = DiatonicChordPattern.fromArray(0, 3, 4);
        this.SEVENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6);
    }
}
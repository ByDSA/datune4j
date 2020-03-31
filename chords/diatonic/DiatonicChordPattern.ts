import { ChromaticChord } from './ChromaticChord';
import { Chromatic } from './Chromatic';

export class DiatonicChordPattern {
    public static FIFTH = DiatonicChordPattern.fromArray(0, 4);
    public static TRIAD = DiatonicChordPattern.fromArray(0, 2, 4);
    public static QUARTAL = DiatonicChordPattern.fromArray(0, 3, 6);
    public static SIXTH = DiatonicChordPattern.fromArray(0, 2, 4, 5);
    public static SIXTH_ADD9 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 8);
    public static SEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6);
    public static SEVENTH_ADD11 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 10);
    public static SEVENTH_ADD13 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 12);
    public static NINTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8);
    public static NINTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8);
    public static NINTH_ADD6 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 6, 8);
    public static ELEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10);
    public static THIRTEENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10, 12);
    public static THIRTEENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8, 10, 12);
    public static SUS4 = DiatonicChordPattern.fromArray(0, 3, 4);
    public static SEVENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6);

    private values: number[];
    private diatonicChordPattern: DiatonicChordPattern;

    private constructor(first?: number | number[], ...rest: number[]) {
        this.values =
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

    public getValues(): number[] {
        return this.values;
    }

    public toString(): string {
        return this.values.toString();
    }
}
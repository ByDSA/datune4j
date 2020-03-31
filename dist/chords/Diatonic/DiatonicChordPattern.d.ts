export declare class DiatonicChordPattern {
    static FIFTH: DiatonicChordPattern;
    static TRIAD: DiatonicChordPattern;
    static QUARTAL: DiatonicChordPattern;
    static SIXTH: DiatonicChordPattern;
    static SIXTH_ADD9: DiatonicChordPattern;
    static SEVENTH: DiatonicChordPattern;
    static SEVENTH_ADD11: DiatonicChordPattern;
    static SEVENTH_ADD13: DiatonicChordPattern;
    static NINTH: DiatonicChordPattern;
    static NINTH_SUS4: DiatonicChordPattern;
    static NINTH_ADD6: DiatonicChordPattern;
    static ELEVENTH: DiatonicChordPattern;
    static THIRTEENTH: DiatonicChordPattern;
    static THIRTEENTH_SUS4: DiatonicChordPattern;
    static SUS4: DiatonicChordPattern;
    static SEVENTH_SUS4: DiatonicChordPattern;
    private values;
    private diatonicChordPattern;
    private constructor();
    static fromArray(first?: number | number[], ...rest: number[]): DiatonicChordPattern;
    getValues(): number[];
    toString(): string;
}

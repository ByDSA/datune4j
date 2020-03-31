export class DiatonicChordPattern {
    constructor(first, ...rest) {
        this.values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];
    }
    static fromArray(first, ...rest) {
        let patternArray = first === undefined
            ? []
            : first instanceof Array
                ? [...first, ...rest]
                : [first, ...rest];
        return new DiatonicChordPattern(patternArray);
    }
    getValues() {
        return this.values;
    }
    toString() {
        return this.values.toString();
    }
}
DiatonicChordPattern.FIFTH = DiatonicChordPattern.fromArray(0, 4);
DiatonicChordPattern.TRIAD = DiatonicChordPattern.fromArray(0, 2, 4);
DiatonicChordPattern.QUARTAL = DiatonicChordPattern.fromArray(0, 3, 6);
DiatonicChordPattern.SIXTH = DiatonicChordPattern.fromArray(0, 2, 4, 5);
DiatonicChordPattern.SIXTH_ADD9 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 8);
DiatonicChordPattern.SEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6);
DiatonicChordPattern.SEVENTH_ADD11 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 10);
DiatonicChordPattern.SEVENTH_ADD13 = DiatonicChordPattern.fromArray(0, 2, 4, 6, 12);
DiatonicChordPattern.NINTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8);
DiatonicChordPattern.NINTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8);
DiatonicChordPattern.NINTH_ADD6 = DiatonicChordPattern.fromArray(0, 2, 4, 5, 6, 8);
DiatonicChordPattern.ELEVENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10);
DiatonicChordPattern.THIRTEENTH = DiatonicChordPattern.fromArray(0, 2, 4, 6, 8, 10, 12);
DiatonicChordPattern.THIRTEENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6, 8, 10, 12);
DiatonicChordPattern.SUS4 = DiatonicChordPattern.fromArray(0, 3, 4);
DiatonicChordPattern.SEVENTH_SUS4 = DiatonicChordPattern.fromArray(0, 3, 4, 6);
//# sourceMappingURL=DiatonicChordPattern.js.map
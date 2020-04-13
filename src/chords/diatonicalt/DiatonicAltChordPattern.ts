import { Chromatic } from '../../degrees/Chromatic';
import { Diatonic } from '../../degrees/Diatonic';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';
import { Hashing } from '../../Utils/Hashing';
import { Immutables } from '../../Utils/Immutables';
import { ImmutablesCache } from '../../Utils/ImmutablesCache';
import { ChromaticChordPattern } from '../chromatic/ChromaticChordPattern';
import { DiatonicChordPattern } from '../Diatonic/DiatonicChordPattern';

export type DiatonicAltChordPatternValueType = { semis: number, diatonicIntValue: number };
export class DiatonicAltChordPattern implements Iterable<DiatonicAltChordPatternValueType> {
    public static POWER_CHORD: DiatonicAltChordPattern;
    public static TRIAD_MAJOR: DiatonicAltChordPattern;
    public static TRIAD_MINOR: DiatonicAltChordPattern;
    public static TRIAD_DIMINISHED: DiatonicAltChordPattern;
    public static TRIAD_AUGMENTED: DiatonicAltChordPattern;
    public static TRIAD_SUS4: DiatonicAltChordPattern;
    public static TRIAD_QUARTAL: DiatonicAltChordPattern;
    public static SEVENTH: DiatonicAltChordPattern;
    public static SEVENTH_b5: DiatonicAltChordPattern;
    public static SEVENTH_a5: DiatonicAltChordPattern;
    public static SEVENTH_SUS4: DiatonicAltChordPattern;
    public static SEVENTH_MINOR: DiatonicAltChordPattern;
    public static SEVENTH_MINOR_b5: DiatonicAltChordPattern;
    public static SEVENTH_MINOR_a5: DiatonicAltChordPattern;
    public static SIXTH: DiatonicAltChordPattern;
    public static SIXTH_MINOR: DiatonicAltChordPattern;
    public static SIXTH_SUS4: DiatonicAltChordPattern;
    public static SEVENTH_MAJ7: DiatonicAltChordPattern;
    public static SEVENTH_MINOR_MAJ7: DiatonicAltChordPattern;
    public static SIXTH_ADD9: DiatonicAltChordPattern;
    public static SIXTH_MINOR_ADD9: DiatonicAltChordPattern;
    public static SEVENTH_b9: DiatonicAltChordPattern;
    public static SEVENTH_a9: DiatonicAltChordPattern;
    public static SEVENTH_MINOR_b9: DiatonicAltChordPattern;
    public static SEVENTH_ADD11: DiatonicAltChordPattern;
    public static SEVENTH_ADD13: DiatonicAltChordPattern;
    public static NINTH: DiatonicAltChordPattern;
    public static NINTH_MINOR: DiatonicAltChordPattern;
    public static NINTH_b5: DiatonicAltChordPattern;
    public static NINTH_a5: DiatonicAltChordPattern;
    public static NINTH_SUS4: DiatonicAltChordPattern;
    public static NINTH_MAJ9: DiatonicAltChordPattern;
    public static NINTH_MINOR_MAJ9: DiatonicAltChordPattern;
    public static NINTH_ADD6: DiatonicAltChordPattern;
    public static NINTH_a11: DiatonicAltChordPattern;
    public static NINTH_MAJ9_a11: DiatonicAltChordPattern;
    public static ELEVENTH: DiatonicAltChordPattern;
    public static ELEVENTH_MINOR: DiatonicAltChordPattern;
    public static ELEVENTH_b9: DiatonicAltChordPattern;
    public static ELEVENTH_a9: DiatonicAltChordPattern;
    public static ELEVENTH_MAJ11: DiatonicAltChordPattern;
    public static ELEVENTH_MINOR_MAJ11: DiatonicAltChordPattern;
    public static THIRTEENTH_MINOR: DiatonicAltChordPattern;
    public static THIRTEENTH_SUS4: DiatonicAltChordPattern;
    public static THIRTEENTH_b5: DiatonicAltChordPattern;
    public static THIRTEENTH_a5: DiatonicAltChordPattern;
    public static THIRTEENTH_b9: DiatonicAltChordPattern;
    public static THIRTEENTH_a9: DiatonicAltChordPattern;
    public static THIRTEENTH_b5b9: DiatonicAltChordPattern;
    public static THIRTEENTH_b5a9: DiatonicAltChordPattern;
    public static THIRTEENTH_a5b9: DiatonicAltChordPattern;
    public static THIRTEENTH_a5a9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13: DiatonicAltChordPattern;
    public static THIRTEENTH_MINOR_MAJ13: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_b5: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_a5: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_b9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_a9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_b5b9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_b5a9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_a5b9: DiatonicAltChordPattern;
    public static THIRTEENTH_MAJ13_a5a9: DiatonicAltChordPattern;

    public static all: () => DiatonicAltChordPattern[];

    private static immutablesCache = new ImmutablesCache<DiatonicAltChordPattern, DiatonicAltChordPatternValueType[]>(
        function (values: DiatonicAltChordPatternValueType[]): string {
            let hash = "";
            for (const value of values) {
                hash += Hashing.hash(value.semis) + Hashing.hash(value.diatonicIntValue) + "|";
            }
            return hash;
        },
        function (diatonicAltChordPattern: DiatonicAltChordPattern) {
            return diatonicAltChordPattern._values;
        },
        function (values: DiatonicAltChordPatternValueType[]): DiatonicAltChordPattern {
            return new DiatonicAltChordPattern(...values);
        }
    );

    private _values: DiatonicAltChordPatternValueType[];

    private _diatonicChordPattern: DiatonicChordPattern;
    private _chromaticChordPattern: ChromaticChordPattern;

    private constructor(...values: DiatonicAltChordPatternValueType[]) {
        this._values = values;

        let arrayChromaticChordPattern: number[] = [];
        let arrayDiatonicChordPattern: number[] = [];
        for (const value of values) {
            arrayChromaticChordPattern.push(value.semis);
            arrayDiatonicChordPattern.push(value.diatonicIntValue);
        }

        this._chromaticChordPattern = ChromaticChordPattern.from(...arrayChromaticChordPattern);
        this._diatonicChordPattern = DiatonicChordPattern.fromArray(...arrayDiatonicChordPattern);
    }

    public static fromPatterns(chromaticChordPattern: ChromaticChordPattern, diatonicChordPattern: DiatonicChordPattern): DiatonicAltChordPattern {
        let values: DiatonicAltChordPatternValueType[] = [];

        values.push({ semis: 0, diatonicIntValue: 0 });

        for (let i = 1; i < chromaticChordPattern.values.length; i++)
            values.push(
                {
                    semis: chromaticChordPattern.values[i],
                    diatonicIntValue: diatonicChordPattern.values[i]
                }
            );

        return this.from(...values);
    }

    public static from(...values: DiatonicAltChordPatternValueType[]): DiatonicAltChordPattern {
        return this.immutablesCache.getOrCreate(values);
    }

    static fromIntervals(intervals: IntervalDiatonicAlt[]): DiatonicAltChordPattern {
        let semisAcc = 0;
        let diatonicChordPatternAcc = 0;
        let arrayChromaticChordPattern = [0];
        let arrayDiatonicChordPattern = [0];

        for (const interval of intervals) {
            semisAcc += interval.semis;
            diatonicChordPatternAcc += interval.intervalDiatonic;

            arrayChromaticChordPattern.push(semisAcc);
            arrayDiatonicChordPattern.push(diatonicChordPatternAcc);
        }

        let chromaticChordPattern = ChromaticChordPattern.from(...arrayChromaticChordPattern);
        let diatonicChordPattern = DiatonicChordPattern.fromArray(arrayDiatonicChordPattern);

        return DiatonicAltChordPattern.fromPatterns(chromaticChordPattern, diatonicChordPattern);
    }

    public static fromArray(...values: DiatonicAltChordPatternValueType[]): DiatonicAltChordPattern {
        return this.immutablesCache.getOrCreate(values);
    }

    [Symbol.iterator](): Iterator<DiatonicAltChordPatternValueType> {
        return this.values[Symbol.iterator]();
    }

    get diatonicChordPattern(): DiatonicChordPattern {
        return this._diatonicChordPattern;
    }

    get chromaticChordPattern(): ChromaticChordPattern {
        return this._chromaticChordPattern;
    }

    public get values(): DiatonicAltChordPatternValueType[] {
        return Array.from(this._values);
    }

    public getInv(n: number = 1): DiatonicAltChordPattern {
        let values: DiatonicAltChordPatternValueType[] = this.values;
        for (let i = 0; i < n; i++) {
            let firstValue: DiatonicAltChordPatternValueType = values.shift();
            firstValue.semis += Chromatic.NUMBER;
            firstValue.diatonicIntValue += Diatonic.NUMBER;
            values.push(firstValue);
            values = values.map((value: DiatonicAltChordPatternValueType) => {
                return {
                    semis: value.semis - values[0].semis,
                    diatonicIntValue: value.diatonicIntValue - value[0].diatonicIntValue
                }
            });
        }

        return DiatonicAltChordPattern.fromArray(...values);
    }

    public toString() {
        return this._chromaticChordPattern.toString();
    }

    public toStringShort() {
        return this._chromaticChordPattern.toStringShort();
    }

    public hashCode(): string {
        let ret = "";
        for (const value of this.values) {
            ret += "s:" + value.semis + "d:" + value.diatonicIntValue;
        }
        return ret;
    }

    private static initialize() {
        DiatonicAltChordPattern.POWER_CHORD = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.POWER_CHORD, DiatonicChordPattern.FIFTH);
        DiatonicAltChordPattern.TRIAD_MAJOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_MAJOR, DiatonicChordPattern.TRIAD);
        DiatonicAltChordPattern.TRIAD_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_MINOR, DiatonicChordPattern.TRIAD);
        DiatonicAltChordPattern.TRIAD_DIMINISHED = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_DIMINISHED, DiatonicChordPattern.TRIAD);
        DiatonicAltChordPattern.TRIAD_AUGMENTED = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_AUGMENTED, DiatonicChordPattern.TRIAD);
        DiatonicAltChordPattern.TRIAD_SUS4 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_SUS4, DiatonicChordPattern.SUS4);
        DiatonicAltChordPattern.TRIAD_QUARTAL = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.TRIAD_QUARTAL, DiatonicChordPattern.QUARTAL);
        DiatonicAltChordPattern.SEVENTH = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_b5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_b5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_a5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_a5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_SUS4 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_SUS4, DiatonicChordPattern.SEVENTH_SUS4);
        DiatonicAltChordPattern.SEVENTH_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_MINOR_b5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_b5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_MINOR_a5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_a5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SIXTH = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SIXTH, DiatonicChordPattern.SIXTH);
        DiatonicAltChordPattern.SIXTH_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SIXTH_MINOR, DiatonicChordPattern.SIXTH);
        DiatonicAltChordPattern.SIXTH_SUS4 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SIXTH_SUS4, DiatonicChordPattern.SIXTH);
        DiatonicAltChordPattern.SEVENTH_MAJ7 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MAJ7, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_MINOR_MAJ7 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_MAJ7, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SIXTH_ADD9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SIXTH_MINOR_ADD9, DiatonicChordPattern.SIXTH_ADD9);
        DiatonicAltChordPattern.SIXTH_MINOR_ADD9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SIXTH_MINOR_ADD9, DiatonicChordPattern.SIXTH_ADD9);
        DiatonicAltChordPattern.SEVENTH_b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_b5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_a5, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_MINOR_b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_MINOR_b9, DiatonicChordPattern.SEVENTH);
        DiatonicAltChordPattern.SEVENTH_ADD11 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_ADD11, DiatonicChordPattern.SEVENTH_ADD11);
        DiatonicAltChordPattern.SEVENTH_ADD13 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.SEVENTH_ADD13, DiatonicChordPattern.SEVENTH_ADD13);
        DiatonicAltChordPattern.NINTH = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_MINOR, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_b5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_b5, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_a5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_SUS4, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_SUS4 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_SUS4, DiatonicChordPattern.NINTH_SUS4);
        DiatonicAltChordPattern.NINTH_MAJ9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_MAJ9, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_MINOR_MAJ9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_MINOR, DiatonicChordPattern.NINTH);
        DiatonicAltChordPattern.NINTH_ADD6 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_ADD6, DiatonicChordPattern.NINTH_ADD6);
        DiatonicAltChordPattern.NINTH_a11 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_a11, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.NINTH_MAJ9_a11 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.NINTH_MAJ9_a11, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH_MINOR, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH_b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH_b9, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH_a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH_a9, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH_MAJ11 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH_MAJ11, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.ELEVENTH_MINOR_MAJ11 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.ELEVENTH_MINOR_MAJ11, DiatonicChordPattern.ELEVENTH);
        DiatonicAltChordPattern.THIRTEENTH_MINOR = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MINOR, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_SUS4 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_SUS4, DiatonicChordPattern.THIRTEENTH_SUS4);
        DiatonicAltChordPattern.THIRTEENTH_b5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_b5, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_a5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_a5, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_a9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_b5b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_b5b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_b5a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_b5a9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_a5b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_a5b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_a5a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_a5a9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MINOR_MAJ13 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_b5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_b5, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_a5 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_a5, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_a9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_b5b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_b5a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_a5b9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9, DiatonicChordPattern.THIRTEENTH);
        DiatonicAltChordPattern.THIRTEENTH_MAJ13_a5a9 = DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9, DiatonicChordPattern.THIRTEENTH);

        DiatonicAltChordPattern.all = function () {
            return [
                this.POWER_CHORD,
                this.TRIAD_MAJOR,
                this.TRIAD_MINOR,
                this.TRIAD_DIMINISHED,
                this.TRIAD_AUGMENTED,
                this.TRIAD_SUS4,
                this.TRIAD_QUARTAL,
                this.SEVENTH,
                this.SEVENTH_b5,
                this.SEVENTH_a5,
                this.SEVENTH_SUS4,
                this.SEVENTH_MINOR,
                this.SEVENTH_MINOR_b5,
                this.SEVENTH_MINOR_a5,
                this.SIXTH,
                this.SIXTH_MINOR,
                this.SIXTH_SUS4,
                this.SEVENTH_MAJ7,
                this.SEVENTH_MINOR_MAJ7,
                this.SIXTH_ADD9,
                this.SIXTH_MINOR_ADD9,
                this.SEVENTH_b9,
                this.SEVENTH_a9,
                this.SEVENTH_MINOR_b9,
                this.SEVENTH_ADD11,
                this.SEVENTH_ADD13,
                this.NINTH,
                this.NINTH_MINOR,
                this.NINTH_b5,
                this.NINTH_a5,
                this.NINTH_SUS4,
                this.NINTH_MAJ9,
                this.NINTH_MINOR_MAJ9,
                this.NINTH_ADD6,
                this.NINTH_a11,
                this.NINTH_MAJ9_a11,
                this.ELEVENTH,
                this.ELEVENTH_MINOR,
                this.ELEVENTH_b9,
                this.ELEVENTH_a9,
                this.ELEVENTH_MAJ11,
                this.ELEVENTH_MINOR_MAJ11,
                this.THIRTEENTH_MINOR,
                this.THIRTEENTH_SUS4,
                this.THIRTEENTH_b5,
                this.THIRTEENTH_a5,
                this.THIRTEENTH_b9,
                this.THIRTEENTH_a9,
                this.THIRTEENTH_b5b9,
                this.THIRTEENTH_b5a9,
                this.THIRTEENTH_a5b9,
                this.THIRTEENTH_a5a9,
                this.THIRTEENTH_MAJ13,
                this.THIRTEENTH_MINOR_MAJ13,
                this.THIRTEENTH_MAJ13_b5,
                this.THIRTEENTH_MAJ13_a5,
                this.THIRTEENTH_MAJ13_b9,
                this.THIRTEENTH_MAJ13_a9,
                this.THIRTEENTH_MAJ13_b5b9,
                this.THIRTEENTH_MAJ13_b5a9,
                this.THIRTEENTH_MAJ13_a5b9,
                this.THIRTEENTH_MAJ13_a5a9
            ];
        }

        Immutables.lockrIf(DiatonicAltChordPattern, (obj) => !(obj instanceof ImmutablesCache));
    }
}
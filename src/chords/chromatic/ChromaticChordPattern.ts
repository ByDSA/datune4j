import { Chromatic } from '../../degrees/Chromatic';
import { NamingChromaticChordPattern } from '../../lang/naming/NamingChromaticChordPattern';
import { Immutables } from '../../common/Immutables';
import { ImmutablesCache } from '../../common/ImmutablesCache';

export class ChromaticChordPattern implements Iterable<number> {
    public static POWER_CHORD: ChromaticChordPattern;
    public static TRIAD_MAJOR: ChromaticChordPattern;
    public static TRIAD_MINOR: ChromaticChordPattern;
    public static TRIAD_DIMINISHED: ChromaticChordPattern;
    public static TRIAD_AUGMENTED: ChromaticChordPattern;
    public static TRIAD_SUS4: ChromaticChordPattern;
    public static TRIAD_QUARTAL: ChromaticChordPattern;
    public static SEVENTH: ChromaticChordPattern;
    public static SEVENTH_b5: ChromaticChordPattern;
    public static SEVENTH_a5: ChromaticChordPattern;
    public static SEVENTH_SUS4: ChromaticChordPattern;
    public static SEVENTH_MINOR: ChromaticChordPattern;
    public static SEVENTH_MINOR_b5: ChromaticChordPattern;
    public static SEVENTH_MINOR_a5: ChromaticChordPattern;
    public static SIXTH: ChromaticChordPattern;
    public static SIXTH_MINOR: ChromaticChordPattern;
    public static SIXTH_SUS4: ChromaticChordPattern;
    public static SEVENTH_MAJ7: ChromaticChordPattern;
    public static SEVENTH_MINOR_MAJ7: ChromaticChordPattern;
    public static SIXTH_ADD9: ChromaticChordPattern;
    public static SIXTH_MINOR_ADD9: ChromaticChordPattern;
    public static SEVENTH_b9: ChromaticChordPattern;
    public static SEVENTH_a9: ChromaticChordPattern;
    public static SEVENTH_MINOR_b9: ChromaticChordPattern;
    public static SEVENTH_ADD11: ChromaticChordPattern;
    public static SEVENTH_ADD13: ChromaticChordPattern;
    public static NINTH: ChromaticChordPattern;
    public static NINTH_MINOR: ChromaticChordPattern;
    public static NINTH_b5: ChromaticChordPattern;
    public static NINTH_a5: ChromaticChordPattern;
    public static NINTH_SUS4: ChromaticChordPattern;
    public static NINTH_MAJ9: ChromaticChordPattern;
    public static NINTH_MINOR_MAJ9: ChromaticChordPattern;
    public static NINTH_ADD6: ChromaticChordPattern;
    public static NINTH_a11: ChromaticChordPattern;
    public static NINTH_MAJ9_a11: ChromaticChordPattern;
    public static ELEVENTH: ChromaticChordPattern;
    public static ELEVENTH_MINOR: ChromaticChordPattern;
    public static ELEVENTH_b9: ChromaticChordPattern;
    public static ELEVENTH_a9: ChromaticChordPattern;
    public static ELEVENTH_MAJ11: ChromaticChordPattern;
    public static ELEVENTH_MINOR_MAJ11: ChromaticChordPattern;
    public static THIRTEENTH_MINOR: ChromaticChordPattern;
    public static THIRTEENTH_SUS4: ChromaticChordPattern;
    public static THIRTEENTH_b5: ChromaticChordPattern;
    public static THIRTEENTH_a5: ChromaticChordPattern;
    public static THIRTEENTH_b9: ChromaticChordPattern;
    public static THIRTEENTH_a9: ChromaticChordPattern;
    public static THIRTEENTH_b5b9: ChromaticChordPattern;
    public static THIRTEENTH_b5a9: ChromaticChordPattern;
    public static THIRTEENTH_a5b9: ChromaticChordPattern;
    public static THIRTEENTH_a5a9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13: ChromaticChordPattern;
    public static THIRTEENTH_MINOR_MAJ13: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_b5: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_a5: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_b9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_a9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_b5b9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_b5a9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_a5b9: ChromaticChordPattern;
    public static THIRTEENTH_MAJ13_a5a9: ChromaticChordPattern;

    public static all: () => ChromaticChordPattern[];

    private static immutablesCache = new ImmutablesCache<ChromaticChordPattern, number[]>(
        function (hashingObject: number[]) {
            return hashingObject.toString();
        },
        function (chromaticChordPattern: ChromaticChordPattern) {
            return chromaticChordPattern._values;
        },
        function (values: number[]): ChromaticChordPattern {
            return new ChromaticChordPattern(...values);
        }
    );

    private _values: number[];

    private constructor(...values: number[]) {
        this._values = values;
    }

    public static from(...values: number[]): ChromaticChordPattern {
        return this.immutablesCache.getOrCreate(values);
    }

    [Symbol.iterator](): Iterator<number> {
        return this.values[Symbol.iterator]();
    }

    public get values(): number[] {
        return Array.from(this._values);
    }

    public getInv(n: number = 1): ChromaticChordPattern {
        let values = this.values;
        for (let i = 0; i < n; i++) {
            let firstValue = values.shift();
            values.push(firstValue + Chromatic.NUMBER);
            values = values.map((value: number) => value - values[0]);
        }

        return ChromaticChordPattern.from(...values);
    }

    public toString() {
        return NamingChromaticChordPattern.toString(this);
    }

    public toStringShort() {
        return NamingChromaticChordPattern.toStringShort(this);
    }

    private static initialize() {
        ChromaticChordPattern.POWER_CHORD = ChromaticChordPattern.from(0, 7);
        ChromaticChordPattern.TRIAD_MAJOR = ChromaticChordPattern.from(0, 4, 7);
        ChromaticChordPattern.TRIAD_MINOR = ChromaticChordPattern.from(0, 3, 7);
        ChromaticChordPattern.TRIAD_DIMINISHED = ChromaticChordPattern.from(0, 3, 6);
        ChromaticChordPattern.TRIAD_AUGMENTED = ChromaticChordPattern.from(0, 4, 8);
        ChromaticChordPattern.TRIAD_SUS4 = ChromaticChordPattern.from(0, 5, 7);
        ChromaticChordPattern.TRIAD_QUARTAL = ChromaticChordPattern.from(0, 5, 10);
        ChromaticChordPattern.SEVENTH = ChromaticChordPattern.from(0, 4, 7, 10);
        ChromaticChordPattern.SEVENTH_b5 = ChromaticChordPattern.from(0, 4, 6, 10);
        ChromaticChordPattern.SEVENTH_a5 = ChromaticChordPattern.from(0, 4, 8, 10);
        ChromaticChordPattern.SEVENTH_SUS4 = ChromaticChordPattern.from(0, 5, 7, 10);
        ChromaticChordPattern.SEVENTH_MINOR = ChromaticChordPattern.from(0, 3, 7, 10);
        ChromaticChordPattern.SEVENTH_MINOR_b5 = ChromaticChordPattern.from(0, 3, 6, 10);
        ChromaticChordPattern.SEVENTH_MINOR_a5 = ChromaticChordPattern.from(0, 3, 8, 10);
        ChromaticChordPattern.SIXTH = ChromaticChordPattern.from(0, 4, 7, 9);
        ChromaticChordPattern.SIXTH_MINOR = ChromaticChordPattern.from(0, 3, 7, 9);
        ChromaticChordPattern.SIXTH_SUS4 = ChromaticChordPattern.from(0, 5, 7, 9);
        ChromaticChordPattern.SEVENTH_MAJ7 = ChromaticChordPattern.from(0, 4, 7, 11);
        ChromaticChordPattern.SEVENTH_MINOR_MAJ7 = ChromaticChordPattern.from(0, 3, 7, 11);
        ChromaticChordPattern.SIXTH_ADD9 = ChromaticChordPattern.from(0, 4, 7, 9, 14);
        ChromaticChordPattern.SIXTH_MINOR_ADD9 = ChromaticChordPattern.from(0, 3, 7, 9, 14);
        ChromaticChordPattern.SEVENTH_b9 = ChromaticChordPattern.from(0, 4, 7, 10, 13);
        ChromaticChordPattern.SEVENTH_a9 = ChromaticChordPattern.from(0, 4, 7, 10, 15);
        ChromaticChordPattern.SEVENTH_MINOR_b9 = ChromaticChordPattern.from(0, 3, 7, 10, 13);
        ChromaticChordPattern.SEVENTH_ADD11 = ChromaticChordPattern.from(0, 4, 7, 10, 17);
        ChromaticChordPattern.SEVENTH_ADD13 = ChromaticChordPattern.from(0, 4, 7, 10, 21);
        ChromaticChordPattern.NINTH = ChromaticChordPattern.from(0, 4, 7, 10, 14);
        ChromaticChordPattern.NINTH_MINOR = ChromaticChordPattern.from(0, 3, 7, 10, 14);
        ChromaticChordPattern.NINTH_b5 = ChromaticChordPattern.from(0, 4, 6, 10, 14);
        ChromaticChordPattern.NINTH_a5 = ChromaticChordPattern.from(0, 4, 8, 10, 14);
        ChromaticChordPattern.NINTH_SUS4 = ChromaticChordPattern.from(0, 5, 7, 10, 14);
        ChromaticChordPattern.NINTH_MAJ9 = ChromaticChordPattern.from(0, 4, 7, 11, 14);
        ChromaticChordPattern.NINTH_MINOR_MAJ9 = ChromaticChordPattern.from(0, 3, 7, 11, 14);
        ChromaticChordPattern.NINTH_ADD6 = ChromaticChordPattern.from(0, 4, 7, 9, 10, 14);
        ChromaticChordPattern.NINTH_a11 = ChromaticChordPattern.from(0, 4, 7, 10, 14, 18);
        ChromaticChordPattern.NINTH_MAJ9_a11 = ChromaticChordPattern.from(0, 4, 7, 11, 14, 18);
        ChromaticChordPattern.ELEVENTH = ChromaticChordPattern.from(0, 4, 7, 10, 14, 17);
        ChromaticChordPattern.ELEVENTH_MINOR = ChromaticChordPattern.from(0, 3, 7, 10, 14, 17);
        ChromaticChordPattern.ELEVENTH_b9 = ChromaticChordPattern.from(0, 4, 7, 10, 13, 17);
        ChromaticChordPattern.ELEVENTH_a9 = ChromaticChordPattern.from(0, 4, 7, 10, 15, 17);
        ChromaticChordPattern.ELEVENTH_MAJ11 = ChromaticChordPattern.from(0, 4, 7, 11, 14, 17);
        ChromaticChordPattern.ELEVENTH_MINOR_MAJ11 = ChromaticChordPattern.from(0, 3, 7, 11, 14, 17);
        ChromaticChordPattern.THIRTEENTH_MINOR = ChromaticChordPattern.from(0, 3, 7, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_SUS4 = ChromaticChordPattern.from(0, 5, 7, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5 = ChromaticChordPattern.from(0, 4, 6, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5 = ChromaticChordPattern.from(0, 4, 8, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b9 = ChromaticChordPattern.from(0, 4, 7, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a9 = ChromaticChordPattern.from(0, 4, 7, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5b9 = ChromaticChordPattern.from(0, 4, 6, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5a9 = ChromaticChordPattern.from(0, 4, 6, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5b9 = ChromaticChordPattern.from(0, 4, 8, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5a9 = ChromaticChordPattern.from(0, 4, 8, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13 = ChromaticChordPattern.from(0, 4, 7, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13 = ChromaticChordPattern.from(0, 3, 7, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5 = ChromaticChordPattern.from(0, 4, 6, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5 = ChromaticChordPattern.from(0, 4, 8, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b9 = ChromaticChordPattern.from(0, 4, 7, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a9 = ChromaticChordPattern.from(0, 4, 7, 11, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9 = ChromaticChordPattern.from(0, 4, 6, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9 = ChromaticChordPattern.from(0, 4, 6, 11, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9 = ChromaticChordPattern.from(0, 4, 8, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9 = ChromaticChordPattern.from(0, 4, 8, 11, 15, 17, 21);

        ChromaticChordPattern.all = function () {
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

        Immutables.lockrIf(ChromaticChordPattern, (obj) => !(obj instanceof ImmutablesCache));
    }
}
import { DegreePattern } from 'patterns/DegreePattern';
import { Immutables } from '../common/Immutables';
import { ImmutablesCache } from '../common/ImmutablesCache';
import { Chromatic } from '../degrees/Chromatic';
import { NamingChromaticChordPattern } from '../lang/naming/NamingChromaticChordPattern';

type Difference = number;
export class ChromaticPattern implements DegreePattern<Chromatic>, Iterable<number> {
    public static POWER_CHORD: ChromaticPattern;
    public static TRIAD_MAJOR: ChromaticPattern;
    public static TRIAD_MINOR: ChromaticPattern;
    public static TRIAD_DIMINISHED: ChromaticPattern;
    public static TRIAD_AUGMENTED: ChromaticPattern;
    public static TRIAD_SUS4: ChromaticPattern;
    public static TRIAD_QUARTAL: ChromaticPattern;
    public static SEVENTH: ChromaticPattern;
    public static SEVENTH_b5: ChromaticPattern;
    public static SEVENTH_a5: ChromaticPattern;
    public static SEVENTH_SUS4: ChromaticPattern;
    public static SEVENTH_MINOR: ChromaticPattern;
    public static SEVENTH_MINOR_b5: ChromaticPattern;
    public static SEVENTH_MINOR_a5: ChromaticPattern;
    public static SIXTH: ChromaticPattern;
    public static SIXTH_MINOR: ChromaticPattern;
    public static SIXTH_SUS4: ChromaticPattern;
    public static SEVENTH_MAJ7: ChromaticPattern;
    public static SEVENTH_MINOR_MAJ7: ChromaticPattern;
    public static SIXTH_ADD9: ChromaticPattern;
    public static SIXTH_MINOR_ADD9: ChromaticPattern;
    public static SEVENTH_b9: ChromaticPattern;
    public static SEVENTH_a9: ChromaticPattern;
    public static SEVENTH_MINOR_b9: ChromaticPattern;
    public static SEVENTH_ADD11: ChromaticPattern;
    public static SEVENTH_ADD13: ChromaticPattern;
    public static NINTH: ChromaticPattern;
    public static NINTH_MINOR: ChromaticPattern;
    public static NINTH_b5: ChromaticPattern;
    public static NINTH_a5: ChromaticPattern;
    public static NINTH_SUS4: ChromaticPattern;
    public static NINTH_MAJ9: ChromaticPattern;
    public static NINTH_MINOR_MAJ9: ChromaticPattern;
    public static NINTH_ADD6: ChromaticPattern;
    public static NINTH_a11: ChromaticPattern;
    public static NINTH_MAJ9_a11: ChromaticPattern;
    public static ELEVENTH: ChromaticPattern;
    public static ELEVENTH_MINOR: ChromaticPattern;
    public static ELEVENTH_b9: ChromaticPattern;
    public static ELEVENTH_a9: ChromaticPattern;
    public static ELEVENTH_MAJ11: ChromaticPattern;
    public static ELEVENTH_MINOR_MAJ11: ChromaticPattern;
    public static THIRTEENTH_MINOR: ChromaticPattern;
    public static THIRTEENTH_SUS4: ChromaticPattern;
    public static THIRTEENTH_b5: ChromaticPattern;
    public static THIRTEENTH_a5: ChromaticPattern;
    public static THIRTEENTH_b9: ChromaticPattern;
    public static THIRTEENTH_a9: ChromaticPattern;
    public static THIRTEENTH_b5b9: ChromaticPattern;
    public static THIRTEENTH_b5a9: ChromaticPattern;
    public static THIRTEENTH_a5b9: ChromaticPattern;
    public static THIRTEENTH_a5a9: ChromaticPattern;
    public static THIRTEENTH_MAJ13: ChromaticPattern;
    public static THIRTEENTH_MINOR_MAJ13: ChromaticPattern;
    public static THIRTEENTH_MAJ13_b5: ChromaticPattern;
    public static THIRTEENTH_MAJ13_a5: ChromaticPattern;
    public static THIRTEENTH_MAJ13_b9: ChromaticPattern;
    public static THIRTEENTH_MAJ13_a9: ChromaticPattern;
    public static THIRTEENTH_MAJ13_b5b9: ChromaticPattern;
    public static THIRTEENTH_MAJ13_b5a9: ChromaticPattern;
    public static THIRTEENTH_MAJ13_a5b9: ChromaticPattern;
    public static THIRTEENTH_MAJ13_a5a9: ChromaticPattern;

    public static all: () => ChromaticPattern[];

    private static immutablesCache = new ImmutablesCache<ChromaticPattern, Difference[]>(
        function (hashingObject: Difference[]) {
            return hashingObject.toString();
        },
        function (chromaticChordPattern: ChromaticPattern) {
            return chromaticChordPattern._values;
        },
        function (values: Difference[]): ChromaticPattern {
            return new ChromaticPattern(...values);
        }
    );

    private _values: Difference[];
    private _rootIndex: number;

    private constructor(...values: Difference[]) {
        this._values = values;
        this._rootIndex = 0;
    }

    public static from(...values: Difference[]): ChromaticPattern {
        return this.immutablesCache.getOrCreate(values);
    }

    [Symbol.iterator](): Iterator<number> {
        return this.values[Symbol.iterator]();
    }

    public get rootIndex(): number {
        return this._rootIndex;
    }

    public get values(): number[] {
        return Array.from(this._values);
    }

    public getInv(n: number = 1): ChromaticPattern {
        let values = this.values;
        for (let i = 0; i < n; i++) {
            let firstValue = values.shift();
            values.push(firstValue + Chromatic.NUMBER);
            values = values.map((value: number) => value - values[0]);
        }

        return ChromaticPattern.from(...values);
    }

    public toString() {
        return NamingChromaticChordPattern.toString(this);
    }

    public get shortName(): string {
        return NamingChromaticChordPattern.toStringShort(this);
    }

    public get inversionNumber(): number {
        return (this.values.length - this.rootIndex) % this.values.length;
    }

    private static initialize() {
        ChromaticPattern.POWER_CHORD = ChromaticPattern.from(0, 7);
        ChromaticPattern.TRIAD_MAJOR = ChromaticPattern.from(0, 4, 7);
        ChromaticPattern.TRIAD_MAJOR.getInv(1)._rootIndex = 2;
        ChromaticPattern.TRIAD_MAJOR.getInv(2)._rootIndex = 1;
        ChromaticPattern.TRIAD_MINOR = ChromaticPattern.from(0, 3, 7);
        ChromaticPattern.TRIAD_DIMINISHED = ChromaticPattern.from(0, 3, 6);
        ChromaticPattern.TRIAD_AUGMENTED = ChromaticPattern.from(0, 4, 8);
        ChromaticPattern.TRIAD_SUS4 = ChromaticPattern.from(0, 5, 7);
        ChromaticPattern.TRIAD_QUARTAL = ChromaticPattern.from(0, 5, 10);
        ChromaticPattern.SEVENTH = ChromaticPattern.from(0, 4, 7, 10);
        ChromaticPattern.SEVENTH_b5 = ChromaticPattern.from(0, 4, 6, 10);
        ChromaticPattern.SEVENTH_a5 = ChromaticPattern.from(0, 4, 8, 10);
        ChromaticPattern.SEVENTH_SUS4 = ChromaticPattern.from(0, 5, 7, 10);
        ChromaticPattern.SEVENTH_MINOR = ChromaticPattern.from(0, 3, 7, 10);
        ChromaticPattern.SEVENTH_MINOR_b5 = ChromaticPattern.from(0, 3, 6, 10);
        ChromaticPattern.SEVENTH_MINOR_a5 = ChromaticPattern.from(0, 3, 8, 10);
        ChromaticPattern.SIXTH = ChromaticPattern.from(0, 4, 7, 9);
        ChromaticPattern.SIXTH_MINOR = ChromaticPattern.from(0, 3, 7, 9);
        ChromaticPattern.SIXTH_SUS4 = ChromaticPattern.from(0, 5, 7, 9);
        ChromaticPattern.SEVENTH_MAJ7 = ChromaticPattern.from(0, 4, 7, 11);
        ChromaticPattern.SEVENTH_MINOR_MAJ7 = ChromaticPattern.from(0, 3, 7, 11);
        ChromaticPattern.SIXTH_ADD9 = ChromaticPattern.from(0, 4, 7, 9, 14);
        ChromaticPattern.SIXTH_MINOR_ADD9 = ChromaticPattern.from(0, 3, 7, 9, 14);
        ChromaticPattern.SEVENTH_b9 = ChromaticPattern.from(0, 4, 7, 10, 13);
        ChromaticPattern.SEVENTH_a9 = ChromaticPattern.from(0, 4, 7, 10, 15);
        ChromaticPattern.SEVENTH_MINOR_b9 = ChromaticPattern.from(0, 3, 7, 10, 13);
        ChromaticPattern.SEVENTH_ADD11 = ChromaticPattern.from(0, 4, 7, 10, 17);
        ChromaticPattern.SEVENTH_ADD13 = ChromaticPattern.from(0, 4, 7, 10, 21);
        ChromaticPattern.NINTH = ChromaticPattern.from(0, 4, 7, 10, 14);
        ChromaticPattern.NINTH_MINOR = ChromaticPattern.from(0, 3, 7, 10, 14);
        ChromaticPattern.NINTH_b5 = ChromaticPattern.from(0, 4, 6, 10, 14);
        ChromaticPattern.NINTH_a5 = ChromaticPattern.from(0, 4, 8, 10, 14);
        ChromaticPattern.NINTH_SUS4 = ChromaticPattern.from(0, 5, 7, 10, 14);
        ChromaticPattern.NINTH_MAJ9 = ChromaticPattern.from(0, 4, 7, 11, 14);
        ChromaticPattern.NINTH_MINOR_MAJ9 = ChromaticPattern.from(0, 3, 7, 11, 14);
        ChromaticPattern.NINTH_ADD6 = ChromaticPattern.from(0, 4, 7, 9, 10, 14);
        ChromaticPattern.NINTH_a11 = ChromaticPattern.from(0, 4, 7, 10, 14, 18);
        ChromaticPattern.NINTH_MAJ9_a11 = ChromaticPattern.from(0, 4, 7, 11, 14, 18);
        ChromaticPattern.ELEVENTH = ChromaticPattern.from(0, 4, 7, 10, 14, 17);
        ChromaticPattern.ELEVENTH_MINOR = ChromaticPattern.from(0, 3, 7, 10, 14, 17);
        ChromaticPattern.ELEVENTH_b9 = ChromaticPattern.from(0, 4, 7, 10, 13, 17);
        ChromaticPattern.ELEVENTH_a9 = ChromaticPattern.from(0, 4, 7, 10, 15, 17);
        ChromaticPattern.ELEVENTH_MAJ11 = ChromaticPattern.from(0, 4, 7, 11, 14, 17);
        ChromaticPattern.ELEVENTH_MINOR_MAJ11 = ChromaticPattern.from(0, 3, 7, 11, 14, 17);
        ChromaticPattern.THIRTEENTH_MINOR = ChromaticPattern.from(0, 3, 7, 10, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_SUS4 = ChromaticPattern.from(0, 5, 7, 10, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_b5 = ChromaticPattern.from(0, 4, 6, 10, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_a5 = ChromaticPattern.from(0, 4, 8, 10, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_b9 = ChromaticPattern.from(0, 4, 7, 10, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_a9 = ChromaticPattern.from(0, 4, 7, 10, 15, 17, 21);
        ChromaticPattern.THIRTEENTH_b5b9 = ChromaticPattern.from(0, 4, 6, 10, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_b5a9 = ChromaticPattern.from(0, 4, 6, 10, 15, 17, 21);
        ChromaticPattern.THIRTEENTH_a5b9 = ChromaticPattern.from(0, 4, 8, 10, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_a5a9 = ChromaticPattern.from(0, 4, 8, 10, 15, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13 = ChromaticPattern.from(0, 4, 7, 11, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_MINOR_MAJ13 = ChromaticPattern.from(0, 3, 7, 11, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_b5 = ChromaticPattern.from(0, 4, 6, 11, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_a5 = ChromaticPattern.from(0, 4, 8, 11, 14, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_b9 = ChromaticPattern.from(0, 4, 7, 11, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_a9 = ChromaticPattern.from(0, 4, 7, 11, 15, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_b5b9 = ChromaticPattern.from(0, 4, 6, 11, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_b5a9 = ChromaticPattern.from(0, 4, 6, 11, 15, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_a5b9 = ChromaticPattern.from(0, 4, 8, 11, 13, 17, 21);
        ChromaticPattern.THIRTEENTH_MAJ13_a5a9 = ChromaticPattern.from(0, 4, 8, 11, 15, 17, 21);

        ChromaticPattern.all = function () {
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

        Immutables.lockrIf(ChromaticPattern, (obj) => !(obj instanceof ImmutablesCache));
    }
}
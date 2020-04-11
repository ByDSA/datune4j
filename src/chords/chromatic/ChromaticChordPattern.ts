import { Chromatic } from '../../degrees/Chromatic';
import { Hashing } from '../../Utils/Hashing';
import { Utils } from '../../Utils/Utils';
import { DiatonicChordPattern } from '../Diatonic/DiatonicChordPattern';
import { ChromaticChord } from './ChromaticChord';
import { NamingChromaticChordPattern } from '../../lang/naming/NamingChromaticChordPattern';
import { DiatonicAltChord } from '../../chords/DiatonicAltChord';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';

export class ChromaticChordPattern implements Iterable<number> {
    private static immutables = new Map<string, ChromaticChordPattern>();

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

    private _values: number[];
    private valuesHash: string;
    private _diatonicChordPattern: DiatonicChordPattern;

    private constructor(first?: number | number[], ...rest: number[]) {
        this._values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        this.valuesHash = Hashing.hashArray(this.values);
    }

    private static fromArrayAndDiatonicChordPattern(diatonicChordPattern: DiatonicChordPattern, ...rest: number[]): ChromaticChordPattern {
        let instance = this.fromArray(rest);
        instance._diatonicChordPattern = diatonicChordPattern;
        return instance;
    }

    public static fromArray(first?: number | number[], ...rest: number[]): ChromaticChordPattern {
        let patternArray =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        let immutableCache = new ChromaticChordPattern(patternArray);
        ChromaticChordPattern.immutables.set(Hashing.hashArray(immutableCache.values), immutableCache);

        return immutableCache;
    }

    public static getUnsortedNotes(chord: ChromaticChord): Chromatic[] {
        let sortedNotes = chord.notes;
        let unsortedNotes = sortedNotes;
        Utils.arrayRotate(unsortedNotes, chord.rootIndex);
        return unsortedNotes;
    }

    public static from(chord: ChromaticChord): ChromaticChordPattern {
        let patternArray = [0];
        let last: Chromatic;
        let lastValue = 0;

        let unsortedNotes: Chromatic[] = this.getUnsortedNotes(chord);

        let first = true;
        unsortedNotes.forEach(current => {
            if (first) {
                first = false;
                last = current;
                return;
            }

            let value = (current.intValue - last.intValue) % Chromatic.NUMBER;
            if (value < 0)
                value += 12;
            lastValue = value;
            patternArray.push(value);
        });

        let valuesHash = Hashing.hashArray(patternArray);
        let immutableCache = ChromaticChordPattern.immutables.get(valuesHash);

        if (immutableCache == null)
            immutableCache = this.fromArray(patternArray);

        return immutableCache;
    }

    static fromDiatonicAltChord(chord: DiatonicAltChord): ChromaticChordPattern {
        let chromaticChord: ChromaticChord = ChromaticChord.fromDiatonicAltChord(chord);

        return ChromaticChordPattern.from(chromaticChord);
    }

    [Symbol.iterator](): Iterator<number> {
        return this.values[Symbol.iterator]();
    }

    get diatonicChordPattern(): DiatonicChordPattern {
        return this._diatonicChordPattern;
    }

    public get values(): number[] {
        return this._values;
    }

    public toString() {
        return NamingChromaticChordPattern.toString(this);
    }

    public toStringShort() {
        return NamingChromaticChordPattern.toStringShort(this);
    }

    private static initialize() {
        ChromaticChordPattern.POWER_CHORD = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.FIFTH, 0, 7);
        ChromaticChordPattern.TRIAD_MAJOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 4, 7);
        ChromaticChordPattern.TRIAD_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 3, 7);
        ChromaticChordPattern.TRIAD_DIMINISHED = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 3, 6);
        ChromaticChordPattern.TRIAD_AUGMENTED = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 4, 8);
        ChromaticChordPattern.TRIAD_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SUS4, 0, 5, 7);
        ChromaticChordPattern.TRIAD_QUARTAL = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.QUARTAL, 0, 5, 10);
        ChromaticChordPattern.SEVENTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10);
        ChromaticChordPattern.SEVENTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 6, 10);
        ChromaticChordPattern.SEVENTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 8, 10);
        ChromaticChordPattern.SEVENTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_SUS4, 0, 5, 7, 10);
        ChromaticChordPattern.SEVENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 10);
        ChromaticChordPattern.SEVENTH_MINOR_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 6, 10);
        ChromaticChordPattern.SEVENTH_MINOR_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 8, 10);
        ChromaticChordPattern.SIXTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 4, 7, 9);
        ChromaticChordPattern.SIXTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 3, 7, 9);
        ChromaticChordPattern.SIXTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 5, 7, 9);
        ChromaticChordPattern.SEVENTH_MAJ7 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 11);
        ChromaticChordPattern.SEVENTH_MINOR_MAJ7 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 11);
        ChromaticChordPattern.SIXTH_ADD9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH_ADD9, 0, 4, 7, 9, 14);
        ChromaticChordPattern.SIXTH_MINOR_ADD9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH_ADD9, 0, 3, 7, 9, 14);
        ChromaticChordPattern.SEVENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10, 13);
        ChromaticChordPattern.SEVENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10, 15);
        ChromaticChordPattern.SEVENTH_MINOR_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 10, 13);
        ChromaticChordPattern.SEVENTH_ADD11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_ADD11, 0, 4, 7, 10, 17);
        ChromaticChordPattern.SEVENTH_ADD13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_ADD13, 0, 4, 7, 10, 21);
        ChromaticChordPattern.NINTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 7, 10, 14);
        ChromaticChordPattern.NINTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 3, 7, 10, 14);
        ChromaticChordPattern.NINTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 6, 10, 14);
        ChromaticChordPattern.NINTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 8, 10, 14);
        ChromaticChordPattern.NINTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH_SUS4, 0, 5, 7, 10, 14);
        ChromaticChordPattern.NINTH_MAJ9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 7, 11, 14);
        ChromaticChordPattern.NINTH_MINOR_MAJ9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 3, 7, 11, 14);
        ChromaticChordPattern.NINTH_ADD6 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH_ADD6, 0, 4, 7, 9, 10, 14);
        ChromaticChordPattern.NINTH_a11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 14, 18);
        ChromaticChordPattern.NINTH_MAJ9_a11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 11, 14, 18);
        ChromaticChordPattern.ELEVENTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 14, 17);
        ChromaticChordPattern.ELEVENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 3, 7, 10, 14, 17);
        ChromaticChordPattern.ELEVENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 13, 17);
        ChromaticChordPattern.ELEVENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 15, 17);
        ChromaticChordPattern.ELEVENTH_MAJ11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 11, 14, 17);
        ChromaticChordPattern.ELEVENTH_MINOR_MAJ11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 3, 7, 11, 14, 17);
        ChromaticChordPattern.THIRTEENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 3, 7, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH_SUS4, 0, 5, 7, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_b5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_a5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 3, 7, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 14, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 15, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 13, 17, 21);
        ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 15, 17, 21);

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
    }
}
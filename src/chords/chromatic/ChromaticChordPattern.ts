import { Chromatic } from '../../degrees/Chromatic';
import { Utils } from '../../Utils';
import { DiatonicChordPattern } from '../Diatonic/DiatonicChordPattern';
import { ChromaticChord } from './ChromaticChord';
import { Settings } from '../../Settings';

export class ChromaticChordPattern implements Iterable<number> {
    private static immutables = new Map<string, ChromaticChordPattern>();

    public static POWER_CHORD = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.FIFTH, 0, 7);
    public static TRIAD_MAJOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 4, 7);
    public static TRIAD_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 3, 7);
    public static TRIAD_DIMINISHED = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 3, 6);
    public static TRIAD_AUGMENTED = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.TRIAD, 0, 4, 8);
    public static TRIAD_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SUS4, 0, 5, 7);
    public static TRIAD_QUARTAL = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.QUARTAL, 0, 5, 10);
    public static SEVENTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10);
    public static SEVENTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 6, 10);
    public static SEVENTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 8, 10);
    public static SEVENTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_SUS4, 0, 5, 7, 10);
    public static SEVENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 10);
    public static SEVENTH_MINOR_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 6, 10);
    public static SEVENTH_MINOR_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 8, 10);
    public static SIXTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 4, 7, 9);
    public static SIXTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 3, 7, 9);
    public static SIXTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH, 0, 5, 7, 9);
    public static SEVENTH_MAJ7 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 11);
    public static SEVENTH_MINOR_MAJ7 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 11);
    public static SIXTH_ADD9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH_ADD9, 0, 4, 7, 9, 14);
    public static SIXTH_MINOR_ADD9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SIXTH_ADD9, 0, 3, 7, 9, 14);
    public static SEVENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10, 13);
    public static SEVENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 4, 7, 10, 15);
    public static SEVENTH_MINOR_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH, 0, 3, 7, 10, 13);
    public static SEVENTH_ADD11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_ADD11, 0, 4, 7, 10, 17);
    public static SEVENTH_ADD13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.SEVENTH_ADD13, 0, 4, 7, 10, 21);
    public static NINTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 7, 10, 14);
    public static NINTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 3, 7, 10, 14);
    public static NINTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 6, 10, 14);
    public static NINTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 8, 10, 14);
    public static NINTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH_SUS4, 0, 5, 7, 10, 14);
    public static NINTH_MAJ9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 4, 7, 11, 14);
    public static NINTH_MINOR_MAJ9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH, 0, 3, 7, 11, 14);
    public static NINTH_ADD6 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.NINTH_ADD6, 0, 4, 7, 9, 10, 14);
    public static NINTH_a11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 14, 18);
    public static NINTH_MAJ9_a11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 11, 14, 18);
    public static ELEVENTH = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 14, 17);
    public static ELEVENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 3, 7, 10, 14, 17);
    public static ELEVENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 13, 17);
    public static ELEVENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 10, 15, 17);
    public static ELEVENTH_MAJ11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 4, 7, 11, 14, 17);
    public static ELEVENTH_MINOR_MAJ11 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.ELEVENTH, 0, 3, 7, 11, 14, 17);
    public static THIRTEENTH_MINOR = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 3, 7, 10, 14, 17, 21);
    public static THIRTEENTH_SUS4 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH_SUS4, 0, 5, 7, 10, 14, 17, 21);
    public static THIRTEENTH_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 14, 17, 21);
    public static THIRTEENTH_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 14, 17, 21);
    public static THIRTEENTH_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 10, 13, 17, 21);
    public static THIRTEENTH_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 10, 15, 17, 21);
    public static THIRTEENTH_b5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 13, 17, 21);
    public static THIRTEENTH_b5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 10, 15, 17, 21);
    public static THIRTEENTH_a5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 13, 17, 21);
    public static THIRTEENTH_a5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 10, 15, 17, 21);
    public static THIRTEENTH_MAJ13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 14, 17, 21);
    public static THIRTEENTH_MINOR_MAJ13 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 3, 7, 11, 14, 17, 21);
    public static THIRTEENTH_MAJ13_b5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 14, 17, 21);
    public static THIRTEENTH_MAJ13_a5 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 14, 17, 21);
    public static THIRTEENTH_MAJ13_b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 13, 17, 21);
    public static THIRTEENTH_MAJ13_a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 7, 11, 15, 17, 21);
    public static THIRTEENTH_MAJ13_b5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 13, 17, 21);
    public static THIRTEENTH_MAJ13_b5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 6, 11, 15, 17, 21);
    public static THIRTEENTH_MAJ13_a5b9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 13, 17, 21);
    public static THIRTEENTH_MAJ13_a5a9 = ChromaticChordPattern.fromArrayAndDiatonicChordPattern(DiatonicChordPattern.THIRTEENTH, 0, 4, 8, 11, 15, 17, 21);

    public static all(): ChromaticChordPattern[] {
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

    private _values: number[];
    private valuesHash: string;
    private diatonicChordPattern: DiatonicChordPattern;

    private constructor(first?: number | number[], ...rest: number[]) {
        this._values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];

        this.valuesHash = Utils.hashArray(this.values);
    }

    private static fromArrayAndDiatonicChordPattern(diatonicChordPattern: DiatonicChordPattern, ...rest: number[]): ChromaticChordPattern {
        let instance = this.fromArray(rest);
        instance.diatonicChordPattern = diatonicChordPattern;
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
        ChromaticChordPattern.immutables.set(Utils.hashArray(immutableCache.values), immutableCache);

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

        let unsortedNotes = this.getUnsortedNotes(chord);

        let first = true;
        unsortedNotes.forEach(current => {
            if (first) {
                first = false;
                last = current;
                return;
            }

            let value = (current - last) % 12;
            if (value < 0)
                value += 12;
            lastValue = value;
            patternArray.push(value);
        });

        let valuesHash = Utils.hashArray(patternArray);
        let immutableCache = ChromaticChordPattern.immutables.get(valuesHash);

        if (immutableCache == null)
            immutableCache = this.fromArray(patternArray);

        return immutableCache;
    }

    [Symbol.iterator](): Iterator<number> {
        return this.values[Symbol.iterator]();
    }

    getDiatonicChordPattern(): DiatonicChordPattern {
        return this.diatonicChordPattern;
    }

    public get values(): number[] {
        return this._values;
    }

    public toString(): string {
        switch (this.valuesHash) {
            case ChromaticChordPattern.TRIAD_MAJOR.valuesHash: return "MAJOR";
            case ChromaticChordPattern.TRIAD_MINOR.valuesHash: return "MINOR";
            case ChromaticChordPattern.TRIAD_AUGMENTED.valuesHash: return "AUGMENTED";
            case ChromaticChordPattern.TRIAD_DIMINISHED.valuesHash: return "DIMINISHED";
            case ChromaticChordPattern.TRIAD_SUS4.valuesHash: return "SUS4";
            case ChromaticChordPattern.TRIAD_QUARTAL.valuesHash: return "QUARTAL";
            case ChromaticChordPattern.ELEVENTH.valuesHash: return "ELEVENTH";
            case ChromaticChordPattern.ELEVENTH_MAJ11.valuesHash: return "ELEVENTH MAJ11";
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11.valuesHash: return "ELEVENTH MINOR MAJ11";
            case ChromaticChordPattern.ELEVENTH_a9.valuesHash: return "ELEVENTH " + Settings.mods.a9;
            case ChromaticChordPattern.ELEVENTH_b9.valuesHash: return "ELEVENTH " + Settings.mods.b9;
            case ChromaticChordPattern.NINTH.valuesHash: return "NINTH";
            case ChromaticChordPattern.NINTH_ADD6.valuesHash: return "NINTH ADD6";
            case ChromaticChordPattern.NINTH_MAJ9.valuesHash: return "NINTH MAJ9";
            case ChromaticChordPattern.NINTH_MAJ9_a11.valuesHash: return "NINTH MAJ9 " + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_MINOR.valuesHash: return "NINTH_MINOR";
            case ChromaticChordPattern.NINTH_MINOR_MAJ9.valuesHash: return "NINTH MINOR MAJ9";
            case ChromaticChordPattern.NINTH_SUS4.valuesHash: return "NINTH SUS4";
            case ChromaticChordPattern.NINTH_a11.valuesHash: return "NINTH " + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_a5.valuesHash: return "NINTH " + Settings.mods.a5;
            case ChromaticChordPattern.NINTH_b5.valuesHash: return "NINTH " + Settings.mods.b5;
            case ChromaticChordPattern.POWER_CHORD.valuesHash: return "POWER CHORD";
            case ChromaticChordPattern.SEVENTH.valuesHash: return "SEVENTH";
            case ChromaticChordPattern.SEVENTH_ADD11.valuesHash: return "SEVENTH ADD11";
            case ChromaticChordPattern.SEVENTH_ADD13.valuesHash: return "SEVENTH ADD13";
            case ChromaticChordPattern.SEVENTH_MAJ7.valuesHash: return "SEVENTH MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR.valuesHash: return "SEVENTH MINOR";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7.valuesHash: return "SEVENTH MINOR MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5.valuesHash: return "SEVENTH MINOR " + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5.valuesHash: return "SEVENTH MINOR " + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9.valuesHash: return "SEVENTH MINOR " + Settings.mods.b9;
            case ChromaticChordPattern.SEVENTH_SUS4.valuesHash: return "SEVENTH SUS4";
            case ChromaticChordPattern.SEVENTH_a5.valuesHash: return "SEVENTH " + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_a9.valuesHash: return "SEVENTH " + Settings.mods.a9;
            case ChromaticChordPattern.SEVENTH_b5.valuesHash: return "SEVENTH " + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_b9.valuesHash: return "SEVENTH " + Settings.mods.b9;
            case ChromaticChordPattern.SIXTH.valuesHash: return "SIXTH";
            case ChromaticChordPattern.SIXTH_ADD9.valuesHash: return "SIXTH ADD9";
            case ChromaticChordPattern.SIXTH_MINOR.valuesHash: return "SIXTH MINOR";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9.valuesHash: return "SIXTH MINOR ADD9";
            case ChromaticChordPattern.SIXTH_SUS4.valuesHash: return "SIXTH SUS4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13.valuesHash: return "THIRTEENTH MAJ13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5.valuesHash: return "THIRTEENTH MAJ13 " + Settings.mods.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9.valuesHash: return "THIRTEENTH MAJ13 " + Settings.mods.a5 + Settings.mods.a9;
        }
        return this.values.toString();
    }

    public toStringShort(): string {
        switch (this.valuesHash) {
            case ChromaticChordPattern.TRIAD_MAJOR.valuesHash: return "";
            case ChromaticChordPattern.TRIAD_MINOR.valuesHash: return "m";
            case ChromaticChordPattern.TRIAD_AUGMENTED.valuesHash: return "+";
            case ChromaticChordPattern.TRIAD_DIMINISHED.valuesHash: return "dim";
            case ChromaticChordPattern.TRIAD_SUS4.valuesHash: return "sus4";
            case ChromaticChordPattern.TRIAD_QUARTAL.valuesHash: return "quartal";
            case ChromaticChordPattern.ELEVENTH.valuesHash: return "11";
            case ChromaticChordPattern.ELEVENTH_MAJ11.valuesHash: return "Maj11";
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11.valuesHash: return "mMaj11";
            case ChromaticChordPattern.ELEVENTH_a9.valuesHash: return "11#9";
            case ChromaticChordPattern.ELEVENTH_b9.valuesHash: return "11b9";
            case ChromaticChordPattern.NINTH.valuesHash: return "9";
            case ChromaticChordPattern.NINTH_ADD6.valuesHash: return "9add6";
            case ChromaticChordPattern.NINTH_MAJ9.valuesHash: return "Maj9";
            case ChromaticChordPattern.NINTH_MAJ9_a11.valuesHash: return "Maj9#11";
            case ChromaticChordPattern.NINTH_MINOR.valuesHash: return "m9";
            case ChromaticChordPattern.NINTH_MINOR_MAJ9.valuesHash: return "mMaj9";
            case ChromaticChordPattern.NINTH_SUS4.valuesHash: return "9sus4";
            case ChromaticChordPattern.NINTH_a11.valuesHash: return "9" + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_a5.valuesHash: return "9" + Settings.mods.a5;
            case ChromaticChordPattern.NINTH_b5.valuesHash: return "9" + Settings.mods.b5;
            case ChromaticChordPattern.POWER_CHORD.valuesHash: return "5";
            case ChromaticChordPattern.SEVENTH.valuesHash: return "7";
            case ChromaticChordPattern.SEVENTH_ADD11.valuesHash: return "7add11";
            case ChromaticChordPattern.SEVENTH_ADD13.valuesHash: return "7add13";
            case ChromaticChordPattern.SEVENTH_MAJ7.valuesHash: return "Maj7";
            case ChromaticChordPattern.SEVENTH_MINOR.valuesHash: return "m7";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7.valuesHash: return "mMaj7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5.valuesHash: return "m7" + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5.valuesHash: return "m7" + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9.valuesHash: return "m7" + Settings.mods.b9;
            case ChromaticChordPattern.SEVENTH_SUS4.valuesHash: return "7sus4";
            case ChromaticChordPattern.SEVENTH_a5.valuesHash: return "7" + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_a9.valuesHash: return "7" + Settings.mods.a9;
            case ChromaticChordPattern.SEVENTH_b5.valuesHash: return "7" + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_b9.valuesHash: return "7" + Settings.mods.b9;
            case ChromaticChordPattern.SIXTH.valuesHash: return "6";
            case ChromaticChordPattern.SIXTH_ADD9.valuesHash: return "6add9";
            case ChromaticChordPattern.SIXTH_MINOR.valuesHash: return "m6";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9.valuesHash: return "m6add9";
            case ChromaticChordPattern.SIXTH_SUS4.valuesHash: return "6sus4";
            case ChromaticChordPattern.TRIAD_SUS4.valuesHash: return "sus4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13.valuesHash: return "Maj13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5.valuesHash: return "Maj13" + Settings.mods.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9.valuesHash: return "Maj13" + Settings.mods.a5 + Settings.mods.a9;
        }

        return this.values.toString();
    }
}
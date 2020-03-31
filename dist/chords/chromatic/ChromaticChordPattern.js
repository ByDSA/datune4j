import { DiatonicChordPattern } from '../Diatonic/DiatonicChordPattern';
import { NameUtils } from '../../lang/NameUtils';
import { Utils } from '../../Utils';
export class ChromaticChordPattern {
    constructor(first, ...rest) {
        this.values =
            first === undefined
                ? []
                : first instanceof Array
                    ? [...first, ...rest]
                    : [first, ...rest];
        this.valuesHash = Utils.hashArray(this.values);
    }
    static all() {
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
    static fromArrayAndDiatonicChordPattern(diatonicChordPattern, ...rest) {
        let instance = this.fromArray(rest);
        instance.diatonicChordPattern = diatonicChordPattern;
        return instance;
    }
    static fromArray(first, ...rest) {
        let patternArray = first === undefined
            ? []
            : first instanceof Array
                ? [...first, ...rest]
                : [first, ...rest];
        let immutableCache = new ChromaticChordPattern(patternArray);
        ChromaticChordPattern.immutables.set(Utils.hashArray(immutableCache.values), immutableCache);
        return immutableCache;
    }
    static getUnsortedNotes(chord) {
        let sortedNotes = chord.getNotes();
        let unsortedNotes = sortedNotes;
        Utils.arrayRotate(unsortedNotes, chord.getRootIndex());
        return unsortedNotes;
    }
    static from(chord) {
        let patternArray = [0];
        let last;
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
    [Symbol.iterator]() {
        return this.getValues()[Symbol.iterator]();
    }
    getDiatonicChordPattern() {
        return this.diatonicChordPattern;
    }
    getValues() {
        return this.values;
    }
    toString() {
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
            case ChromaticChordPattern.ELEVENTH_a9.valuesHash: return "ELEVENTH " + NameUtils.a9;
            case ChromaticChordPattern.ELEVENTH_b9.valuesHash: return "ELEVENTH " + NameUtils.b9;
            case ChromaticChordPattern.NINTH.valuesHash: return "NINTH";
            case ChromaticChordPattern.NINTH_ADD6.valuesHash: return "NINTH ADD6";
            case ChromaticChordPattern.NINTH_MAJ9.valuesHash: return "NINTH MAJ9";
            case ChromaticChordPattern.NINTH_MAJ9_a11.valuesHash: return "NINTH MAJ9 " + NameUtils.a11;
            case ChromaticChordPattern.NINTH_MINOR.valuesHash: return "NINTH_MINOR";
            case ChromaticChordPattern.NINTH_MINOR_MAJ9.valuesHash: return "NINTH MINOR MAJ9";
            case ChromaticChordPattern.NINTH_SUS4.valuesHash: return "NINTH SUS4";
            case ChromaticChordPattern.NINTH_a11.valuesHash: return "NINTH " + NameUtils.a11;
            case ChromaticChordPattern.NINTH_a5.valuesHash: return "NINTH " + NameUtils.a5;
            case ChromaticChordPattern.NINTH_b5.valuesHash: return "NINTH " + NameUtils.b5;
            case ChromaticChordPattern.POWER_CHORD.valuesHash: return "POWER CHORD";
            case ChromaticChordPattern.SEVENTH.valuesHash: return "SEVENTH";
            case ChromaticChordPattern.SEVENTH_ADD11.valuesHash: return "SEVENTH ADD11";
            case ChromaticChordPattern.SEVENTH_ADD13.valuesHash: return "SEVENTH ADD13";
            case ChromaticChordPattern.SEVENTH_MAJ7.valuesHash: return "SEVENTH MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR.valuesHash: return "SEVENTH MINOR";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7.valuesHash: return "SEVENTH MINOR MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5.valuesHash: return "SEVENTH MINOR " + NameUtils.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5.valuesHash: return "SEVENTH MINOR " + NameUtils.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9.valuesHash: return "SEVENTH MINOR " + NameUtils.b9;
            case ChromaticChordPattern.SEVENTH_SUS4.valuesHash: return "SEVENTH SUS4";
            case ChromaticChordPattern.SEVENTH_a5.valuesHash: return "SEVENTH " + NameUtils.a5;
            case ChromaticChordPattern.SEVENTH_a9.valuesHash: return "SEVENTH " + NameUtils.a9;
            case ChromaticChordPattern.SEVENTH_b5.valuesHash: return "SEVENTH " + NameUtils.b5;
            case ChromaticChordPattern.SEVENTH_b9.valuesHash: return "SEVENTH " + NameUtils.b9;
            case ChromaticChordPattern.SIXTH.valuesHash: return "SIXTH";
            case ChromaticChordPattern.SIXTH_ADD9.valuesHash: return "SIXTH ADD9";
            case ChromaticChordPattern.SIXTH_MINOR.valuesHash: return "SIXTH MINOR";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9.valuesHash: return "SIXTH MINOR ADD9";
            case ChromaticChordPattern.SIXTH_SUS4.valuesHash: return "SIXTH SUS4";
            case ChromaticChordPattern.TRIAD_SUS4.valuesHash: return "SUS4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13.valuesHash: return "THIRTEENTH MAJ13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5.valuesHash: return "THIRTEENTH MAJ13 " + NameUtils.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9.valuesHash: return "THIRTEENTH MAJ13 " + NameUtils.a5 + NameUtils.a9;
        }
        return this.values.toString();
    }
    toStringShort() {
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
            case ChromaticChordPattern.NINTH_a11.valuesHash: return "9" + NameUtils.a11;
            case ChromaticChordPattern.NINTH_a5.valuesHash: return "9" + NameUtils.a5;
            case ChromaticChordPattern.NINTH_b5.valuesHash: return "9" + NameUtils.b5;
            case ChromaticChordPattern.POWER_CHORD.valuesHash: return "5";
            case ChromaticChordPattern.SEVENTH.valuesHash: return "7";
            case ChromaticChordPattern.SEVENTH_ADD11.valuesHash: return "7add11";
            case ChromaticChordPattern.SEVENTH_ADD13.valuesHash: return "7add13";
            case ChromaticChordPattern.SEVENTH_MAJ7.valuesHash: return "Maj7";
            case ChromaticChordPattern.SEVENTH_MINOR.valuesHash: return "m7";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7.valuesHash: return "mMaj7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5.valuesHash: return "m7" + NameUtils.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5.valuesHash: return "m7" + NameUtils.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9.valuesHash: return "m7" + NameUtils.b9;
            case ChromaticChordPattern.SEVENTH_SUS4.valuesHash: return "7sus4";
            case ChromaticChordPattern.SEVENTH_a5.valuesHash: return "7" + NameUtils.a5;
            case ChromaticChordPattern.SEVENTH_a9.valuesHash: return "7" + NameUtils.a9;
            case ChromaticChordPattern.SEVENTH_b5.valuesHash: return "7" + NameUtils.b5;
            case ChromaticChordPattern.SEVENTH_b9.valuesHash: return "7" + NameUtils.b9;
            case ChromaticChordPattern.SIXTH.valuesHash: return "6";
            case ChromaticChordPattern.SIXTH_ADD9.valuesHash: return "6add9";
            case ChromaticChordPattern.SIXTH_MINOR.valuesHash: return "m6";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9.valuesHash: return "m6add9";
            case ChromaticChordPattern.SIXTH_SUS4.valuesHash: return "6sus4";
            case ChromaticChordPattern.TRIAD_SUS4.valuesHash: return "sus4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13.valuesHash: return "Maj13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5.valuesHash: return "Maj13" + NameUtils.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9.valuesHash: return "Maj13" + NameUtils.a5 + NameUtils.a9;
        }
        return this.values.toString();
    }
}
ChromaticChordPattern.immutables = new Map();
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
//# sourceMappingURL=ChromaticChordPattern.js.map
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { DiatonicChordPattern } from '../chords/Diatonic/DiatonicChordPattern';
import { DiatonicAltChord } from '../chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern } from '../chords/diatonicalt/DiatonicAltChordPattern';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { Scale } from './Scale';

type HashingObjectType = { root: DiatonicAlt, scale: Scale };
export class Tonality {
    // Precalc

    public static C: Tonality;
    public static CC: Tonality;
    public static D: Tonality;
    public static DD: Tonality;
    public static E: Tonality;
    public static F: Tonality;
    public static FF: Tonality;
    public static G: Tonality;
    public static GG: Tonality;
    public static A: Tonality;
    public static B: Tonality;

    public static Cm: Tonality;
    public static CCm: Tonality;
    public static Dm: Tonality;
    public static DDm: Tonality;
    public static Em: Tonality;
    public static Fm: Tonality;
    public static FFm: Tonality;
    public static Gm: Tonality;
    public static GGm: Tonality;
    public static Am: Tonality;
    public static Bm: Tonality;

    private static immutablesCache = new ImmutablesCache<Tonality, HashingObjectType>(
        function (hashingObject: HashingObjectType): string {
            return hashingObject.scale.hashCode() + hashingObject.root.hashCode();
        },
        function (tonality: Tonality): HashingObjectType {
            return { root: tonality.root, scale: tonality.scale };
        },
        function (hashingObject: HashingObjectType): Tonality {
            return new Tonality(hashingObject.root, hashingObject.scale);
        }
    );

    private _notes: DiatonicAlt[] = [];
    private _rootChord3: DiatonicAltChord;
    private _rootChord4: DiatonicAltChord;

    private constructor(private _root: DiatonicAlt, private _scale: Scale) {
        this.calculateNotes();
        this.calculateRootChord();
    }

    public static fromChromatic(chromaticRoot: Chromatic, scale: Scale) {
        let root = DiatonicAlt.fromChromatic(chromaticRoot);
        return Tonality.from(root, scale);
    }

    public static from(root: DiatonicAlt, scale: Scale) {
        return this.immutablesCache.getOrCreate({ root: root, scale: scale });
    }

    private calculateNotes(): void {
        this._notes.push(this.root);
        let i = 2;
        for (let interval of this.scale.intervals) {
            if (i > this.scale.intervals.length)
                break;
            let lastNote = this._notes[this._notes.length - 1];
            let note = lastNote.getAdd(interval);
            this._notes.push(note);
            i++;
        }

        Object.freeze(this._notes);
    }

    private calculateRootChord() {
        this.calculateRootChord3();
        this.calculateRootChord4();

    }

    private calculateRootChord3() {
        let chordRootPatternPriority = [
            { interval: IntervalDiatonicAlt.PERFECT_UNISON, pattern: DiatonicAltChordPattern.TRIAD_MAJOR },
            { interval: IntervalDiatonicAlt.PERFECT_UNISON, pattern: DiatonicAltChordPattern.TRIAD_MINOR },
            { interval: IntervalDiatonicAlt.MAJOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_MINOR },
            { interval: IntervalDiatonicAlt.MAJOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_MAJOR },
            { interval: IntervalDiatonicAlt.MINOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_MINOR },
            { interval: IntervalDiatonicAlt.MINOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_MAJOR },
            { interval: IntervalDiatonicAlt.MAJOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_MINOR },
            { interval: IntervalDiatonicAlt.MAJOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_MAJOR },
            { interval: IntervalDiatonicAlt.MINOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_MINOR },
            { interval: IntervalDiatonicAlt.MINOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_MAJOR },
            { interval: IntervalDiatonicAlt.PERFECT_UNISON, pattern: DiatonicAltChordPattern.TRIAD_DIMINISHED },
            { interval: IntervalDiatonicAlt.PERFECT_UNISON, pattern: DiatonicAltChordPattern.TRIAD_AUGMENTED },
            { interval: IntervalDiatonicAlt.MAJOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_DIMINISHED },
            { interval: IntervalDiatonicAlt.MAJOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_AUGMENTED },
            { interval: IntervalDiatonicAlt.MINOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_DIMINISHED },
            { interval: IntervalDiatonicAlt.MINOR_THIRD, pattern: DiatonicAltChordPattern.TRIAD_AUGMENTED },
            { interval: IntervalDiatonicAlt.MAJOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_DIMINISHED },
            { interval: IntervalDiatonicAlt.MAJOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_AUGMENTED },
            { interval: IntervalDiatonicAlt.MINOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_DIMINISHED },
            { interval: IntervalDiatonicAlt.MINOR_SIXTH, pattern: DiatonicAltChordPattern.TRIAD_AUGMENTED },
        ];

        this._rootChord3 = null;
        let notesChromatic = this.notes.map(diatonicAlt => diatonicAlt.chromatic);
        for (const pattern of chordRootPatternPriority) {
            let note = this.root.getAdd(pattern.interval);
            let chord = DiatonicAltChord.fromRootPattern(note, pattern.pattern);

            if (this.containsChord(chord)) {
                this._rootChord3 = chord;
                break;
            }
        }

        Object.freeze(this._rootChord3);
    }

    private calculateRootChord4() {
        let chordRootPatternPriority = [
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 4, 7, 11), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 3, 7, 11), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 4, 7, 10), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 3, 7, 10), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 3, 6, 10), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 3, 6, 11), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 4, 8, 10), DiatonicChordPattern.SEVENTH),
            DiatonicAltChordPattern.fromPatterns(ChromaticChordPattern.from(0, 4, 8, 11), DiatonicChordPattern.SEVENTH)
        ];

        this._rootChord4 = null;
        for (const pattern of chordRootPatternPriority) {
            let chord = DiatonicAltChord.fromRootPattern(this.root, pattern);
            if (this.containsChord(chord)) {
                this._rootChord4 = chord;
                break;
            }
        }

        Object.freeze(this._rootChord4);
    }

    public containsChord(chord: DiatonicAltChord): boolean {
        for (let diatonicAlt of chord.notes) {
            if (!this.containsNote(diatonicAlt))
                return false;
        }

        return true;
    }

    public containsNote(note: DiatonicAlt): boolean {
        return this.notes.includes(note);
    }

    get root(): DiatonicAlt {
        return this._root;
    }

    get rootChord3(): DiatonicAltChord {
        return this._rootChord3;
    }

    get rootChord4(): DiatonicAltChord {
        return this._rootChord4;
    }

    get scale(): Scale {
        return this._scale;
    }

    get length(): number {
        return this._scale.length;
    }

    get notes(): DiatonicAlt[] {
        return Array.from(this._notes);
    }

    public hashCode(): string {
        return "tonality:" + this.root.hashCode() + "|" + this.scale.hashCode();
    }
}
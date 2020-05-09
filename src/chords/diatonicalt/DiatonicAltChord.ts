import { PatternChord } from '../../chords/pattern/PatternChord';
import { ChromaticChord } from '../../chords/chromatic/ChromaticChord';
import { Assert } from '../../common/Assert';
import { Immutables } from '../../common/Immutables';
import { ImmutablesCache } from '../../common/ImmutablesCache';
import { MathUtils } from '../../common/MathUtils';
import { Utils } from '../../common/Utils';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';
import { NameChordCalculator } from '../../lang/naming/NameChordCalculator';
import { DiatonicAltPattern } from '../../patterns/DiatonicAltPattern';
import { Chord } from '../Chord';

type HashingObjectType = DiatonicAlt[];
export class DiatonicAltChord implements Chord<DiatonicAlt> {
    // Precalc
    public static C: DiatonicAltChord;
    public static D: DiatonicAltChord;
    public static E: DiatonicAltChord;
    public static F: DiatonicAltChord;
    public static G: DiatonicAltChord;
    public static A: DiatonicAltChord;
    public static B: DiatonicAltChord;

    public static Cm: DiatonicAltChord;
    public static Dm: DiatonicAltChord;
    public static Em: DiatonicAltChord;
    public static Fm: DiatonicAltChord;
    public static Gm: DiatonicAltChord;
    public static Am: DiatonicAltChord;
    public static Bm: DiatonicAltChord;

    public static CMaj7: DiatonicAltChord;
    public static FMaj7: DiatonicAltChord;

    public static CmMaj7: DiatonicAltChord;

    public static C7: DiatonicAltChord;
    public static C0: DiatonicAltChord;

    private static immutablesCache = new ImmutablesCache<DiatonicAltChord, HashingObjectType>(
        function (hashingObject: HashingObjectType) {
            let ret = "";
            for (let diatonicAlt of hashingObject)
                ret += "d" + diatonicAlt.valueOf();

            return ret;
        },
        function (diatonicAltChord: DiatonicAltChord): HashingObjectType {
            return diatonicAltChord.notes;
        },
        function (hashingObject: HashingObjectType): DiatonicAltChord {
            return new DiatonicAltChord(hashingObject);
        }
    );

    private constructor(private _notes: DiatonicAlt[]) {
        Immutables.lockr(this);
    }

    private static checkValidNotes(notes: DiatonicAlt[]) {
        for (let note of notes)
            Assert.notNull(note);
    }

    public static from(notes: DiatonicAlt[]): DiatonicAltChord {
        this.checkValidNotes(notes);
        return DiatonicAltChord.immutablesCache.getOrCreate(notes);
    }

    public getInv(n: number = 1): DiatonicAltChord {
        let rootIndex = this.rootIndex - n;
        rootIndex = MathUtils.rotativeTrim(rootIndex, this._notes.length);
        let notes = this.notes;
        notes = Utils.arrayRotateLeft(notes, n);
        return DiatonicAltChord.from(notes);
    }

    private static getNotesFromPattern(root: DiatonicAlt, pattern: DiatonicAltPattern) {
        let notes: DiatonicAlt[] = [root];

        for (let i = 1; i < pattern.values.length; i++) {
            let chromatic = root.chromatic.getShift(pattern.values[i].semis);
            let intervalDiatonic = pattern.values[i].intervalDiatonic;
            let diatonic = root.diatonic.getAdd(intervalDiatonic);

            let diatonicAlt = DiatonicAlt.fromChromatic(chromatic, diatonic);
            notes.push(diatonicAlt);
        }

        return notes;
    }

    public get root(): DiatonicAlt {
        return this._notes[this.rootIndex];
    }

    public get rootIndex(): number {
        return this.pattern.rootIndex;
    }

    public get inversionNumber(): number {
        return this.pattern.inversionNumber;
    }

    public get notes(): DiatonicAlt[] {
        return Array.from(this._notes);
    }

    public get length() {
        return this._notes.length;
    }

    public get pattern(): DiatonicAltPattern {
        let intervals: IntervalDiatonicAlt[] = DiatonicAltChord.getIntervalsFromNotes(this.notes);

        return DiatonicAltPattern.fromIntervals(intervals);
    }

    public get chromaticChord(): ChromaticChord {
        let notesChromatic = this.notes.map((diatonicAlt: DiatonicAlt) => diatonicAlt.chromatic);

        return ChromaticChord.from(notesChromatic);
    }

    private static getIntervalsFromNotes(notes: DiatonicAlt[]): IntervalDiatonicAlt[] {
        let intervals: IntervalDiatonicAlt[] = [];
        for (let i = 1; i < notes.length; i++) {
            let interval = IntervalDiatonicAlt.betweenDiatonicAlt(notes[i - 1], notes[i]);
            intervals.push(interval);
        }

        return intervals;
    }

    public toString(): string {
        return new NameChordCalculator(this).get();
    }

    private static diatonicAlt2Str(diatonicAlt: DiatonicAlt): string {
        switch (diatonicAlt) {
            case DiatonicAlt.C: return "C";
            case DiatonicAlt.CC: return "CC";
            case DiatonicAlt.Db: return "Db";
            case DiatonicAlt.D: return "D";
            case DiatonicAlt.DD: return "DD";
            case DiatonicAlt.Eb: return "Eb";
            case DiatonicAlt.E: return "E";
            case DiatonicAlt.Fb: return "Fb";
            case DiatonicAlt.F: return "F";
            case DiatonicAlt.FF: return "FF";
            case DiatonicAlt.Gb: return "Gb";
            case DiatonicAlt.G: return "G";
            case DiatonicAlt.GG: return "GG";
            case DiatonicAlt.Ab: return "Ab";
            case DiatonicAlt.A: return "A";
            case DiatonicAlt.AA: return "AA";
            case DiatonicAlt.Bb: return "Bb";
            case DiatonicAlt.B: return "B";
        }

        return null;
    }

    private static diatonicAltChordPattern2Str(diatonicAltChordPattern: DiatonicAltPattern): string {
        switch (diatonicAltChordPattern) {
            case DiatonicAltPattern.TRIAD_MAJOR: return "";
            case DiatonicAltPattern.TRIAD_MINOR: return "m";
            case DiatonicAltPattern.TRIAD_AUGMENTED: return "AUG";
            case DiatonicAltPattern.TRIAD_DIMINISHED: return "0";
            case DiatonicAltPattern.TRIAD_SUS4: return "sus4";
            case DiatonicAltPattern.TRIAD_SUS2: return "sus2";
            case DiatonicAltPattern.SEVENTH_MAJ7: return "Maj7";
            case DiatonicAltPattern.SEVENTH: return "7";
            case DiatonicAltPattern.SEVENTH_MINOR: return "m7";
            case DiatonicAltPattern.SEVENTH_MINOR_MAJ7: return "mMaj7";
            case DiatonicAltPattern.THIRTEENTH_b5a9: return "13b5a9";
        }

        return null;
    }


    private static initialize() {
        let diatonicAlts = [
            DiatonicAlt.C,
            DiatonicAlt.CC,
            DiatonicAlt.Db,
            DiatonicAlt.D,
            DiatonicAlt.DD,
            DiatonicAlt.Eb,
            DiatonicAlt.E,
            DiatonicAlt.Fb,
            DiatonicAlt.F,
            DiatonicAlt.FF,
            DiatonicAlt.Gb,
            DiatonicAlt.G,
            DiatonicAlt.GG,
            DiatonicAlt.Ab,
            DiatonicAlt.A,
            DiatonicAlt.AA,
            DiatonicAlt.Bb,
            DiatonicAlt.B,
        ];

        let diatonicAltChordPatterns = DiatonicAltPattern.all();

        for (const diatonicAlt of diatonicAlts) {
            const diatonicAltStr = this.diatonicAlt2Str(diatonicAlt);
            if (diatonicAltStr == null)
                continue;

            for (const diatonicAltChordPattern of diatonicAltChordPatterns) {
                const diatonicAltChordPatternStr = this.diatonicAltChordPattern2Str(diatonicAltChordPattern);
                if (diatonicAltChordPatternStr == null)
                    continue;

                const name = diatonicAltStr + diatonicAltChordPatternStr;

                DiatonicAltChord[name] = PatternChord.from(diatonicAlt, diatonicAltChordPattern).chord;
            }
        }

        Immutables.lockrIf(DiatonicAltChord, (obj) => !(obj instanceof ImmutablesCache));
    }
}
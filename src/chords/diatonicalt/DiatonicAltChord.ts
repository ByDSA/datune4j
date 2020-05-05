import { ChromaticChord } from '../../chords/chromatic/ChromaticChord';
import { Assert } from '../../common/Assert';
import { Immutables } from '../../common/Immutables';
import { ImmutablesCache } from '../../common/ImmutablesCache';
import { MathUtils } from '../../common/MathUtils';
import { Utils } from '../../common/Utils';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';
import { NameDiatonicAltChordCalculator } from '../../lang/naming/NameDiatonicAltChordCalculator';
import { DiatonicAltChordPattern } from './DiatonicAltChordPattern';
import { IntervalDiatonic } from '../../interval/IntervalDiatonic';

type HashingObjectType = { rootIndex: number, notes: DiatonicAlt[] };
export class DiatonicAltChord {
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
            let ret = hashingObject.rootIndex + "|";
            for (let diatonicAlt of hashingObject.notes)
                ret += "d" + diatonicAlt.valueOf();

            return ret;
        },
        function (diatonicAltChord: DiatonicAltChord): HashingObjectType {
            return { rootIndex: diatonicAltChord.rootIndex, notes: diatonicAltChord.notes };
        },
        function (hashingObject: HashingObjectType): DiatonicAltChord {
            return new DiatonicAltChord(hashingObject.rootIndex, hashingObject.notes);
        }
    );

    private constructor(private _rootIndex: number, private _notes: DiatonicAlt[]) {
        Immutables.lockr(this);
    }

    private static checkValidNotes(notes: DiatonicAlt[]) {
        for (let note of notes)
            Assert.notNull(note);
    }

    public static fromRootNotes(rootIndex: number, notes: DiatonicAlt[]): DiatonicAltChord {
        this.checkValidNotes(notes);
        return DiatonicAltChord.immutablesCache.getOrCreate(
            {
                rootIndex: rootIndex,
                notes: notes
            }
        );
    }

    public static fromRootPattern(root: DiatonicAlt, pattern: DiatonicAltChordPattern, inversion: number = 0): DiatonicAltChord {
        let rootPos = this.inversionToRootPos(inversion, pattern.values.length);
        let notes = this.getNotesFromPattern(root, pattern);

        return DiatonicAltChord.fromRootNotes(rootPos, notes);
    }

    public getInv(n: number = 1): DiatonicAltChord {
        let rootIndex = this.rootIndex - n;
        rootIndex = MathUtils.rotativeTrim(rootIndex, this._notes.length);
        return DiatonicAltChord.fromRootNotes(rootIndex, this.notesFromRoot);
    }

    private static getNotesFromPattern(root: DiatonicAlt, pattern: DiatonicAltChordPattern) {
        let notes: DiatonicAlt[] = [root];

        for (let i = 1; i < pattern.values.length; i++) {
            let chromatic = root.chromatic.getShift(pattern.values[i].semis);
            let intervalDiatonic = IntervalDiatonic.from(pattern.values[i].diatonicIntValue);
            let diatonic = root.diatonic.getAdd(intervalDiatonic);

            let diatonicAlt = DiatonicAlt.fromChromatic(chromatic, diatonic);
            notes.push(diatonicAlt);
        }

        return notes;
    }

    public get root(): DiatonicAlt {
        return this._notes[0];
    }

    private static inversionToRootPos(inv: number, length: number): number {
        return (length - inv) % length;
    }

    public get rootIndex(): number {
        return this._rootIndex;
    }

    public get inversionNumber(): number {
        return (this.notes.length - this.rootIndex) % this.notes.length;
    }

    public get notes(): DiatonicAlt[] {
        let notes = this.notesFromRoot;

        Utils.arrayRotate(notes, this.rootIndex, true);
        return notes;
    }

    public get length() {
        return this._notes.length;
    }

    public get notesFromRoot(): DiatonicAlt[] {
        return Array.from(this._notes);
    }

    public get pattern(): DiatonicAltChordPattern {
        let intervals: IntervalDiatonicAlt[] = DiatonicAltChord.getIntervalsFromNotes(this.notes);

        return DiatonicAltChordPattern.fromIntervals(intervals);
    }

    public get patternFromRoot(): DiatonicAltChordPattern {
        let intervals: IntervalDiatonicAlt[] = DiatonicAltChord.getIntervalsFromNotes(this.notesFromRoot);

        return DiatonicAltChordPattern.fromIntervals(intervals);
    }

    public get chromaticChord(): ChromaticChord {
        let notesChromatic = this.notes.map((diatonicAlt: DiatonicAlt) => diatonicAlt.chromatic);

        return ChromaticChord.fromRootNotes(this.rootIndex, notesChromatic);
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
        return new NameDiatonicAltChordCalculator(this).get();
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

    private static diatonicAltChordPattern2Str(diatonicAltChordPattern: DiatonicAltChordPattern): string {
        switch (diatonicAltChordPattern) {
            case DiatonicAltChordPattern.TRIAD_MAJOR: return "";
            case DiatonicAltChordPattern.TRIAD_MINOR: return "m";
            case DiatonicAltChordPattern.TRIAD_AUGMENTED: return "AUG";
            case DiatonicAltChordPattern.TRIAD_DIMINISHED: return "0";
            case DiatonicAltChordPattern.TRIAD_SUS4: return "SUS4";
            case DiatonicAltChordPattern.SEVENTH_MAJ7: return "Maj7";
            case DiatonicAltChordPattern.SEVENTH: return "7";
            case DiatonicAltChordPattern.SEVENTH_MINOR: return "m7";
            case DiatonicAltChordPattern.SEVENTH_MINOR_MAJ7: return "mMaj7";
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

        let diatonicAltChordPatterns = DiatonicAltChordPattern.all();

        for (const diatonicAlt of diatonicAlts) {
            const diatonicAltStr = this.diatonicAlt2Str(diatonicAlt);
            if (diatonicAltStr == null)
                continue;

            for (const diatonicAltChordPattern of diatonicAltChordPatterns) {
                const diatonicAltChordPatternStr = this.diatonicAltChordPattern2Str(diatonicAltChordPattern);
                if (diatonicAltChordPatternStr == null)
                    continue;

                const name = diatonicAltStr + diatonicAltChordPatternStr;

                DiatonicAltChord[name]
                    = DiatonicAltChord.fromRootPattern(diatonicAlt, diatonicAltChordPattern);
            }
        }

        Immutables.lockrIf(DiatonicAltChord, (obj) => !(obj instanceof ImmutablesCache));
    }
}
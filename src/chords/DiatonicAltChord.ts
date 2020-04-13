import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { NameDiatonicAltChordCalculator } from '../lang/naming/NameDiatonicAltChordCalculator';
import { Assert } from '../Utils/Assert';
import { Hashing } from '../Utils/Hashing';
import { Immutables } from '../Utils/Immutables';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { MathUtils } from '../Utils/MathUtils';
import { Utils } from '../Utils/Utils';
import { DiatonicAltChordPattern } from './DiatonicAltChordPattern';

type HashingObjectType = { rootIndex: number, notes: DiatonicAlt[] };
export class DiatonicAltChord {
    public static C: DiatonicAltChord;
    public static C7: DiatonicAltChord;

    private static immutablesCache = new ImmutablesCache<DiatonicAltChord, HashingObjectType>(
        function (hashingObject: HashingObjectType) {
            let ret = Hashing.hash(hashingObject.rootIndex) + "|";
            for (let diatonicAlt of hashingObject.notes)
                ret += diatonicAlt.hashCode();

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
            let diatonic = root.diatonic.getAdd(pattern.values[i].diatonicIntValue);

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

    private static getIntervalsFromNotes(notes: DiatonicAlt[]): IntervalDiatonicAlt[] {
        let intervals: IntervalDiatonicAlt[] = [];
        for (let i = 1; i < notes.length; i++) {
            let interval = IntervalDiatonicAlt.between(notes[i - 1], notes[i]);
            intervals.push(interval);
        }

        return intervals;
    }

    public toString(): string {
        return new NameDiatonicAltChordCalculator(this).get();
    }

    private static initialize() {
        DiatonicAltChord.C = DiatonicAltChord.fromRootNotes(0, [DiatonicAlt.C, DiatonicAlt.E, DiatonicAlt.G]);
        DiatonicAltChord.C7 = DiatonicAltChord.fromRootNotes(0, [DiatonicAlt.C, DiatonicAlt.E, DiatonicAlt.G, DiatonicAlt.Bb]);

        Immutables.lockrIf(DiatonicAltChord, (obj) => !(obj instanceof ImmutablesCache));
    }
}
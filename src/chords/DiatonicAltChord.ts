import { Chromatic } from '../degrees/Chromatic';
import { Diatonic } from '../degrees/Diatonic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { NameDiatonicAltChordCalculator } from '../lang/naming/NameDiatonicAltChordCalculator';
import { Assert } from '../Utils/Assert';
import { Hashing } from '../Utils/Hashing';
import { Immutables } from '../Utils/Immutables';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { MathUtils } from '../Utils/MathUtils';
import { Utils } from '../Utils/Utils';
import { ChromaticChordPattern } from './chromatic/ChromaticChordPattern';

type HashingObjectType = { rootIndex: number, notes: DiatonicAlt[] };
export class DiatonicAltChord {
    public static C: DiatonicAltChord;
    public static C7: DiatonicAltChord;

    private static immutablesCache = new ImmutablesCache<DiatonicAltChord, HashingObjectType>(
        function (hashingObject: HashingObjectType) {
            let ret = Hashing.hash(hashingObject.rootIndex);
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

    public static fromRootPattern(root: DiatonicAlt, pattern: ChromaticChordPattern, inversion: number = 0): DiatonicAltChord {
        let rootPos = this.inversionToRootPos(inversion, pattern.values.length);
        let notes = this.getNotesFromPattern(root, pattern);

        return DiatonicAltChord.fromRootNotes(rootPos, notes);
    }

    public getInv(n: number = 1): DiatonicAltChord {
        let rootIndex = this.rootIndex - n;
        rootIndex = MathUtils.rotativeTrim(rootIndex, this._notes.length);
        return DiatonicAltChord.fromRootNotes(rootIndex, this.notesPattern);
    }

    private static getNotesFromPattern(root: DiatonicAlt, pattern: ChromaticChordPattern) {
        let notes: DiatonicAlt[] = [root];
        let rootChromaticInt = root.chromatic.intValue;
        let rootDiatonicInt = root.diatonic.intValue;
        let first = true;
        for (let i = 0; i < pattern.values.length; i++) {
            if (first) {
                first = false;
                continue;
            }

            let chromaticInt = rootChromaticInt + pattern.values[i];
            let chromatic = Chromatic.fromInt(chromaticInt);

            let diatonicInt = rootDiatonicInt + pattern.diatonicChordPattern.values[i];
            let diatonic = Diatonic.fromInt(diatonicInt);

            let diatonicAlt = DiatonicAlt.fromChromatic(chromatic, diatonic);
            notes.push(diatonicAlt);
        }

        return notes;
    }

    public get root(): DiatonicAlt {
        return this.notesPattern[0];
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
        let notes = this.notesPattern;

        Utils.arrayRotate(notes, this.rootIndex, true);
        return notes;
    }

    public get notesPattern(): DiatonicAlt[] {
        return Array.from(this._notes);
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
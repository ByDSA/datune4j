import { DiatonicAltChord } from '../diatonicalt/DiatonicAltChord';
import { Chromatic } from '../../degrees/Chromatic';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { NameChromaticChordCalculator } from '../../lang/naming/NameChromaticChordCalculator';
import { Hashing } from '../../common/Hashing';
import { Immutables } from '../../common/Immutables';
import { ImmutablesCache } from '../../common/ImmutablesCache';
import { Utils } from '../../common/Utils';
import { ChromaticChordPattern } from './ChromaticChordPattern';
import { MathUtils } from '../../common/MathUtils';

type HashingObjectType = { rootIndex: number, chromatics: Chromatic[] };
export class ChromaticChord {
    // Precalc

    public static C;
    public static Dm;
    public static C7;
    public static Dm7;

    private static immutablesCache = new ImmutablesCache<ChromaticChord, HashingObjectType>(
        function (hashingObject: HashingObjectType) {
            let ret = Hashing.hash(hashingObject.rootIndex) + "|";
            for (const chromatic of hashingObject.chromatics)
                ret += chromatic.hashCode();

            return ret;
        },
        function (chromaticChord: ChromaticChord): HashingObjectType {
            return { rootIndex: chromaticChord.rootIndex, chromatics: chromaticChord.notesFromRoot };
        },
        function (hashingObject: HashingObjectType): ChromaticChord {
            return new ChromaticChord(hashingObject.rootIndex, hashingObject.chromatics);
        }
    );

    private constructor(private _rootIndex: number, private _notes: Chromatic[]) {
    }

    public static fromRootNotes(rootIndex: number, notes: Chromatic[]): ChromaticChord {
        return this.immutablesCache.getOrCreate({ rootIndex: rootIndex, chromatics: notes });
    }

    public static fromRootPattern(root: Chromatic, pattern: ChromaticChordPattern, inversion: number = 0): ChromaticChord {
        let rootPos = this.inversionToRootPos(inversion, pattern.values.length);
        let notes: Chromatic[] = [root];

        let first = true;
        for (let semis of pattern) {
            if (first) {
                first = false;
                continue;
            }

            let chromaticShifted = root.getShift(semis);
            notes.push(chromaticShifted);
        }

        return ChromaticChord.fromRootNotes(rootPos, notes);
    }

    public static fromDiatonicAltChord(diatonicAltChord: DiatonicAltChord) {
        let notesChromatic = diatonicAltChord.notes.map((diatonicAlt: DiatonicAlt) => diatonicAlt.chromatic);

        return ChromaticChord.fromRootNotes(diatonicAltChord.rootIndex, notesChromatic);
    }

    public get root(): Chromatic {
        return this.notes[this.rootIndex];
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

    public get notes(): Chromatic[] {
        let notes = this.notesFromRoot;

        Utils.arrayRotate(notes, this.rootIndex, true);
        return notes;
    }

    public getInv(n: number = 1): ChromaticChord {
        let rootIndex = this.rootIndex - n;
        rootIndex = MathUtils.rotativeTrim(rootIndex, this._notes.length);
        return ChromaticChord.fromRootNotes(rootIndex, this.notesFromRoot);
    }

    public get notesFromRoot(): Chromatic[] {
        return Array.from(this._notes);
    }
    
    public get pattern(): ChromaticChordPattern {
        let patternArray = this.getArrayFromChromaticChord();

        return ChromaticChordPattern.from(...patternArray);
    }

    public get patternFromRoot(): ChromaticChordPattern {
        let patternArray = this.getArrayFromChromaticChordRoot();

        return ChromaticChordPattern.from(...patternArray);
    }

    private getArrayFromChromaticChord(): number[] {
        let patternArray = [0];
        let last: Chromatic;

        let unsortedNotes: Chromatic[] = this.notes;

        let first = true;
        unsortedNotes.forEach(current => {
            if (first) {
                first = false;
                last = current;
                return;
            }

            let dist = MathUtils.rotativeTrim(current.intValue - last.intValue, Chromatic.NUMBER);
            patternArray.push(dist);
        });

        return patternArray;
    }

    private getArrayFromChromaticChordRoot(): number[] {
        let patternArray = [0];
        let last: Chromatic;

        let unsortedNotes: Chromatic[] = this.notesFromRoot;

        let first = true;
        unsortedNotes.forEach(current => {
            if (first) {
                first = false;
                last = current;
                return;
            }

            let dist = MathUtils.rotativeTrim(current.intValue - last.intValue, Chromatic.NUMBER);
            patternArray.push(dist);
        });

        return patternArray;
    }

    public toString(): string {
        return new NameChromaticChordCalculator(this).get();
    }

    private static initialize() {
        this.C = ChromaticChord.fromRootNotes(0, [Chromatic.C, Chromatic.E, Chromatic.G]);
        this.Dm = ChromaticChord.fromRootNotes(0, [Chromatic.D, Chromatic.F, Chromatic.A]);
        this.C7 = ChromaticChord.fromRootNotes(0, [Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA]);
        this.Dm7 = ChromaticChord.fromRootNotes(0, [Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA]);

        Immutables.lockrIf(ChromaticChord, (obj) => !(obj instanceof ImmutablesCache));

    }
}
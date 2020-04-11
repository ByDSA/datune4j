import { Chromatic } from '../../degrees/Chromatic'
import { ChromaticChordPattern } from './ChromaticChordPattern';
import { NameChromaticChordCalculator } from '../../lang/naming/NameChromaticChordCalculator';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { Utils } from '../../Utils/Utils';
import { DiatonicAltChord } from '../../chords/DiatonicAltChord';

export class ChromaticChord {
    public static C = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G]);
    public static Dm = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A]);
    public static C7 = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA]);
    public static Dm7 = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA]);

    private constructor(private _rootIndex: number, private _notes: Chromatic[], private str?: string) {
    }

    public static fromRootNotes(rootIndex: number, notes: Chromatic[], str?: string): ChromaticChord {
        return new ChromaticChord(rootIndex, notes, str);
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
        let notes: DiatonicAlt[] = diatonicAltChord.notes;
        let notesChromatic: Chromatic[] = [];
        for (let diatonicAlt of notes) {
            let chromatic = Chromatic.fromDiatonicAlt(diatonicAlt);
            notesChromatic.push(chromatic);
        }
        return ChromaticChord.fromRootNotes(0, notesChromatic);
    }

    public get root(): Chromatic {
        return this.notes[this.rootIndex];
    }

    private static inversionToRootPos(inv: number, length: number): number {
        return (length - inv) % length;
    }

    public updateName(rootDiatonicAlt: DiatonicAlt): void {
        Utils.assertNotNull(rootDiatonicAlt);
        this.str = new NameChromaticChordCalculator(this, rootDiatonicAlt).get();
    }

    public get rootIndex(): number {
        return this._rootIndex;
    }

    public get inversionNumber(): number {
        return (this.notes.length - this.rootIndex) % this.notes.length;
    }

    public get notes(): Chromatic[] {
        let notes = Array.from(this._notes);

        Utils.arrayRotate(notes, this.rootIndex, true);
        return notes;
    }

    public toString(): string | undefined {
        return this.str;
    }
}
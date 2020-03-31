import { Chromatic } from './Chromatic'
import { ChromaticChordPattern } from './ChromaticChordPattern';
import { ChromaticUtils } from './ChromaticUtils';
import { from } from 'rxjs';
import { NameChordCalculator } from './NameChordCalculator';
import { DiatonicAlt } from './DiatonicAlt';
import { Utils } from './Utils';

export class ChromaticChord {
    public static C = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G]);
    public static Dm = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A]);
    public static C7 = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA]);
    public static Dm7 = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA]);

    private constructor(private rootIndex: number, private notes: Chromatic[], private str?: string) {
    }

    public static fromRootNotes(rootIndex: number, notes: Chromatic[], str?: string): ChromaticChord {
        return new ChromaticChord(rootIndex, notes, str);
    }

    public static fromRootPattern(root: Chromatic, pattern: ChromaticChordPattern, inversion: number = 0): ChromaticChord {
        let rootPos = this.inversionToRootPos(inversion, pattern.getValues().length);
        let notes: Chromatic[] = [root];

        let first = true;
        for (let semis of pattern) {
            if (first) {
                first = false;
                continue;
            }

            let chromaticShifted = ChromaticUtils.getShiftedBySemis(root, semis);
            notes.push(chromaticShifted);
        }

        return ChromaticChord.fromRootNotes(rootPos, notes);
    }

    public getRoot(): Chromatic {
        return this.notes[this.rootIndex];
    }

    private static inversionToRootPos(inv: number, length: number): number {
        return (length - inv) % length;
    }

    public updateName(rootDiatonicAlt: DiatonicAlt): void {
        Utils.assertNotNull(rootDiatonicAlt);
        this.str = new NameChordCalculator(this, rootDiatonicAlt).get();
    }

    public getName(): string {
        return this.str;
    }

    public getRootIndex(): number {
        return this.rootIndex;
    }

    public getInversionNumber(): number {
        return (this.notes.length - this.rootIndex) % this.notes.length;
    }

    public getNotes(): Chromatic[] {
        let notes = Array.from(this.notes);

        Utils.arrayRotate(notes, this.getRootIndex(), true);
        return notes;
    }

    public toString(): string {
        return this.str;
    }
}
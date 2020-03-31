import { Chromatic } from '../../degrees/Chromatic';
import { ChromaticChordPattern } from './ChromaticChordPattern';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
export declare class ChromaticChord {
    private rootIndex;
    private notes;
    private str?;
    static C: ChromaticChord;
    static Dm: ChromaticChord;
    static C7: ChromaticChord;
    static Dm7: ChromaticChord;
    private constructor();
    static fromRootNotes(rootIndex: number, notes: Chromatic[], str?: string): ChromaticChord;
    static fromRootPattern(root: Chromatic, pattern: ChromaticChordPattern, inversion?: number): ChromaticChord;
    getRoot(): Chromatic;
    private static inversionToRootPos;
    updateName(rootDiatonicAlt: DiatonicAlt): void;
    getName(): string | undefined;
    getRootIndex(): number;
    getInversionNumber(): number;
    getNotes(): Chromatic[];
    toString(): string | undefined;
}

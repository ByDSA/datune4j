import { Diatonic } from '../degrees/Diatonic';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { ChromaticChordPattern } from './chromatic/ChromaticChordPattern';
import { Utils } from '../Utils/Utils';
import { NameDiatonicAltChordCalculator } from '../lang/naming/NameDiatonicAltChordCalculator';
import { Immutables } from '../Utils/Immutables';

export class DiatonicAltChord {
    public static C: DiatonicAltChord;

    private str: string;

    private constructor(private _rootIndex: number, private _notes: DiatonicAlt[]) {
        this.calculateName();
        Immutables.lockr(this);
    }

    public static fromRootNotes(rootIndex: number, notes: DiatonicAlt[]): DiatonicAltChord {
        return new DiatonicAltChord(rootIndex, notes);
    }

    public static fromRootPattern(root: DiatonicAlt, pattern: ChromaticChordPattern, inversion: number = 0): DiatonicAltChord {
        let rootPos = this.inversionToRootPos(inversion, pattern.values.length);
        let notes: DiatonicAlt[] = [root];
        let rootChromaticInt = Chromatic.fromDiatonicAlt(root).intValue;
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

        return DiatonicAltChord.fromRootNotes(rootPos, notes);
    }

    public get root(): DiatonicAlt {
        return this.notes[this.rootIndex];
    }

    private static inversionToRootPos(inv: number, length: number): number {
        return (length - inv) % length;
    }

    private calculateName(): void {
        this.str = new NameDiatonicAltChordCalculator(this).get();
    }

    public get rootIndex(): number {
        return this._rootIndex;
    }

    public get inversionNumber(): number {
        return (this.notes.length - this.rootIndex) % this.notes.length;
    }

    public get notes(): DiatonicAlt[] {
        let notes = Array.from(this._notes);

        Utils.arrayRotate(notes, this.rootIndex, true);
        return notes;
    }

    public toString(): string {
        return this.str;
    }

    private static initialize() {
        DiatonicAltChord.C = new DiatonicAltChord(0, [DiatonicAlt.C, DiatonicAlt.E, DiatonicAlt.G]);

        Immutables.lockr(DiatonicAlt);
    }
}
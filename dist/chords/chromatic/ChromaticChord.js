import { Chromatic } from '../../degrees/Chromatic';
import { ChromaticUtils } from '../../degrees/ChromaticUtils';
import { NameChordCalculator } from '../../lang/NameChordCalculator';
import { Utils } from '../../Utils';
export class ChromaticChord {
    constructor(rootIndex, notes, str) {
        this.rootIndex = rootIndex;
        this.notes = notes;
        this.str = str;
    }
    static fromRootNotes(rootIndex, notes, str) {
        return new ChromaticChord(rootIndex, notes, str);
    }
    static fromRootPattern(root, pattern, inversion = 0) {
        let rootPos = this.inversionToRootPos(inversion, pattern.getValues().length);
        let notes = [root];
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
    getRoot() {
        return this.notes[this.rootIndex];
    }
    static inversionToRootPos(inv, length) {
        return (length - inv) % length;
    }
    updateName(rootDiatonicAlt) {
        Utils.assertNotNull(rootDiatonicAlt);
        this.str = new NameChordCalculator(this, rootDiatonicAlt).get();
    }
    getName() {
        return this.str;
    }
    getRootIndex() {
        return this.rootIndex;
    }
    getInversionNumber() {
        return (this.notes.length - this.rootIndex) % this.notes.length;
    }
    getNotes() {
        let notes = Array.from(this.notes);
        Utils.arrayRotate(notes, this.getRootIndex(), true);
        return notes;
    }
    toString() {
        return this.str;
    }
}
ChromaticChord.C = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G]);
ChromaticChord.Dm = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A]);
ChromaticChord.C7 = new ChromaticChord(0, [Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA]);
ChromaticChord.Dm7 = new ChromaticChord(0, [Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA]);
//# sourceMappingURL=ChromaticChord.js.map
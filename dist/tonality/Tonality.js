import { Chromatic } from '../degrees/Chromatic';
import { Scale } from './Scale';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
export class Tonality {
    constructor(root, scale) {
        this.root = root;
        this.scale = scale;
        this.notes = [];
        this.calculateNotes();
    }
    static from(root, scale) {
        return new Tonality(root, scale);
    }
    calculateNotes() {
        this.notes.push(this.root);
        let lastNote = this.root;
        let i = 0;
        for (let n of this.scale.getIntervals()) {
            if (i >= this.scale.getIntervals().length)
                continue;
            lastNote += n;
            lastNote %= ChromaticUtils.NUMBER;
            this.notes.push(lastNote);
        }
    }
    getRoot() {
        return this.root;
    }
    getScale() {
        return this.scale;
    }
    getNotes() {
        return Array.from(this.notes);
    }
}
Tonality.C = Tonality.from(Chromatic.C, Scale.MAJOR);
Tonality.CC = Tonality.from(Chromatic.CC, Scale.MAJOR);
Tonality.D = Tonality.from(Chromatic.D, Scale.MAJOR);
Tonality.DD = Tonality.from(Chromatic.DD, Scale.MAJOR);
Tonality.E = Tonality.from(Chromatic.E, Scale.MAJOR);
Tonality.F = Tonality.from(Chromatic.F, Scale.MAJOR);
Tonality.FF = Tonality.from(Chromatic.FF, Scale.MAJOR);
Tonality.G = Tonality.from(Chromatic.G, Scale.MAJOR);
Tonality.GG = Tonality.from(Chromatic.GG, Scale.MAJOR);
Tonality.A = Tonality.from(Chromatic.A, Scale.MAJOR);
Tonality.B = Tonality.from(Chromatic.B, Scale.MAJOR);
Tonality.Cm = Tonality.from(Chromatic.C, Scale.MINOR);
Tonality.CCm = Tonality.from(Chromatic.CC, Scale.MINOR);
Tonality.Dm = Tonality.from(Chromatic.D, Scale.MINOR);
Tonality.DDm = Tonality.from(Chromatic.DD, Scale.MINOR);
Tonality.Em = Tonality.from(Chromatic.E, Scale.MINOR);
Tonality.Fm = Tonality.from(Chromatic.F, Scale.MINOR);
Tonality.FFm = Tonality.from(Chromatic.FF, Scale.MINOR);
Tonality.Gm = Tonality.from(Chromatic.G, Scale.MINOR);
Tonality.GGm = Tonality.from(Chromatic.GG, Scale.MINOR);
Tonality.Am = Tonality.from(Chromatic.A, Scale.MINOR);
Tonality.Bm = Tonality.from(Chromatic.B, Scale.MINOR);
//# sourceMappingURL=Tonality.js.map
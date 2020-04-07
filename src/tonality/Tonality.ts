import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { DiatonicUtils } from '../degrees/DiatonicUtils';
import { Chromatic } from '../degrees/Chromatic';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { Scale } from './Scale';

export class Tonality {
    public static C = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
    public static CC = Tonality.from(DiatonicAlt.CC, Scale.MAJOR);
    public static D = Tonality.from(DiatonicAlt.D, Scale.MAJOR);
    public static DD = Tonality.from(DiatonicAlt.DD, Scale.MAJOR);
    public static E = Tonality.from(DiatonicAlt.E, Scale.MAJOR);
    public static F = Tonality.from(DiatonicAlt.F, Scale.MAJOR);
    public static FF = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);
    public static G = Tonality.from(DiatonicAlt.G, Scale.MAJOR);
    public static GG = Tonality.from(DiatonicAlt.GG, Scale.MAJOR);
    public static A = Tonality.from(DiatonicAlt.A, Scale.MAJOR);
    public static B = Tonality.from(DiatonicAlt.B, Scale.MAJOR);

    public static Cm = Tonality.from(DiatonicAlt.C, Scale.MINOR);
    public static CCm = Tonality.from(DiatonicAlt.CC, Scale.MINOR);
    public static Dm = Tonality.from(DiatonicAlt.D, Scale.MINOR);
    public static DDm = Tonality.from(DiatonicAlt.DD, Scale.MINOR);
    public static Em = Tonality.from(DiatonicAlt.E, Scale.MINOR);
    public static Fm = Tonality.from(DiatonicAlt.F, Scale.MINOR);
    public static FFm = Tonality.from(DiatonicAlt.FF, Scale.MINOR);
    public static Gm = Tonality.from(DiatonicAlt.G, Scale.MINOR);
    public static GGm = Tonality.from(DiatonicAlt.GG, Scale.MINOR);
    public static Am = Tonality.from(DiatonicAlt.A, Scale.MINOR);
    public static Bm = Tonality.from(DiatonicAlt.B, Scale.MINOR);

    private notes: DiatonicAlt[] = [];

    private constructor(private root: DiatonicAlt, private scale: Scale) {
        this.calculateNotes();
    }

    public static fromChromatic(chromaticRoot: Chromatic, scale: Scale) {
        let root = DiatonicAlt.fromChromatic(chromaticRoot);
        return Tonality.from(root, scale);
    }

    public static from(root: DiatonicAlt, scale: Scale) {
        return new Tonality(root, scale);
    }

    private calculateNotes(): void {
        this.notes.push(this.root);

        let lastNote = ChromaticUtils.fromDiatonicAlt(this.root);
        let lastDiatonic = this.root.diatonic;
        let i = 0;
        for (let n of this.scale.getIntervals()) {
            if (i >= this.scale.getIntervals().length)
                continue;
            lastNote += n;
            lastNote %= ChromaticUtils.NUMBER;
            lastDiatonic++;
            lastDiatonic %= DiatonicUtils.NUMBER;
            let note = DiatonicAlt.fromChromatic(lastNote, lastDiatonic);
            this.notes.push(note);
        }
    }

    getRoot(): DiatonicAlt {
        return this.root;
    }

    getScale(): Scale {
        return this.scale;
    }

    getNotes(): DiatonicAlt[] {
        return Array.from(this.notes);
    }
}
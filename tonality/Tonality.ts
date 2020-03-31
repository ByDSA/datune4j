import { Chromatic } from './Chromatic';
import { Scale } from './Scale';
import { ChromaticUtils } from './ChromaticUtils';

export class Tonality {
    public static C = Tonality.from(Chromatic.C, Scale.MAJOR);
    public static CC = Tonality.from(Chromatic.CC, Scale.MAJOR);
    public static D = Tonality.from(Chromatic.D, Scale.MAJOR);
    public static DD = Tonality.from(Chromatic.DD, Scale.MAJOR);
    public static E = Tonality.from(Chromatic.E, Scale.MAJOR);
    public static F = Tonality.from(Chromatic.F, Scale.MAJOR);
    public static FF = Tonality.from(Chromatic.FF, Scale.MAJOR);
    public static G = Tonality.from(Chromatic.G, Scale.MAJOR);
    public static GG = Tonality.from(Chromatic.GG, Scale.MAJOR);
    public static A = Tonality.from(Chromatic.A, Scale.MAJOR);
    public static B = Tonality.from(Chromatic.B, Scale.MAJOR);

    public static Cm = Tonality.from(Chromatic.C, Scale.MINOR);
    public static CCm = Tonality.from(Chromatic.CC, Scale.MINOR);
    public static Dm = Tonality.from(Chromatic.D, Scale.MINOR);
    public static DDm = Tonality.from(Chromatic.DD, Scale.MINOR);
    public static Em = Tonality.from(Chromatic.E, Scale.MINOR);
    public static Fm = Tonality.from(Chromatic.F, Scale.MINOR);
    public static FFm = Tonality.from(Chromatic.FF, Scale.MINOR);
    public static Gm = Tonality.from(Chromatic.G, Scale.MINOR);
    public static GGm = Tonality.from(Chromatic.GG, Scale.MINOR);
    public static Am = Tonality.from(Chromatic.A, Scale.MINOR);
    public static Bm = Tonality.from(Chromatic.B, Scale.MINOR);

    private notes: Chromatic[] = [];

    private constructor(private root: Chromatic, private scale: Scale) {
        this.calculateNotes();
    }

    public static from(root: Chromatic, scale: Scale) {
        return new Tonality(root, scale);
    }

    private calculateNotes(): void {
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

    getRoot(): Chromatic {
        return this.root;
    }

    getScale(): Scale {
        return this.scale;
    }

    getNotes(): Chromatic[] {
        return Array.from(this.notes);
    }
}
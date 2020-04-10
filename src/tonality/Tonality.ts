import { Chromatic } from '../degrees/Chromatic';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { DiatonicUtils } from '../degrees/DiatonicUtils';
import { Immutables } from '../Immutables';
import { Scale } from './Scale';

type HashingObjectType = { root: DiatonicAlt, scale: Scale };
export class Tonality {
    public static C;
    public static CC;
    public static D;
    public static DD;
    public static E;
    public static F;
    public static FF;
    public static G;
    public static GG;
    public static A;
    public static B;

    public static Cm;
    public static CCm;
    public static Dm;
    public static DDm;
    public static Em;
    public static Fm;
    public static FFm;
    public static Gm;
    public static GGm;
    public static Am;
    public static Bm;

    private static immutables = new Immutables<Tonality, HashingObjectType>(
        function (hashingObject: HashingObjectType) {
            return hashingObject.scale.hashCode() + hashingObject.root.hashCode();
        },
        function (tonality: Tonality) {
            return { root: tonality.root, scale: tonality.scale };
        },
        function (hashingObject: HashingObjectType): Tonality {
            return new Tonality(hashingObject.root, hashingObject.scale);
        }
    );

    private _notes: DiatonicAlt[] = [];

    private constructor(private _root: DiatonicAlt, private _scale: Scale) {
        this.calculateNotes();
    }

    public static fromChromatic(chromaticRoot: Chromatic, scale: Scale) {
        let root = DiatonicAlt.fromChromatic(chromaticRoot);
        return Tonality.from(root, scale);
    }

    public static from(root: DiatonicAlt, scale: Scale) {
        return this.immutables.getOrCreate({ root: root, scale: scale });
    }

    private calculateNotes(): void {
        this.notes.push(this.root);

        let lastNote = ChromaticUtils.fromDiatonicAlt(this.root);
        let lastDiatonic = this.root.diatonic;
        let i = 0;
        for (let n of this.scale.intervals) {
            if (i >= this.scale.intervals.length)
                continue;
            lastNote += n;
            lastNote %= ChromaticUtils.NUMBER;
            lastDiatonic++;
            lastDiatonic %= DiatonicUtils.NUMBER;
            let note = DiatonicAlt.fromChromatic(lastNote, lastDiatonic);
            this.notes.push(note);
        }
    }

    get root(): DiatonicAlt {
        return this._root;
    }

    get scale(): Scale {
        return this._scale;
    }

    get notes(): DiatonicAlt[] {
        return Array.from(this._notes);
    }
}
import { Diatonic } from '../degrees/Diatonic';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Immutables } from '../Immutables';
import { Scale } from './Scale';

type HashingObjectType = { root: DiatonicAlt, scale: Scale };
export class Tonality {
    public static C: Tonality;
    public static CC: Tonality;
    public static D: Tonality;
    public static DD: Tonality;
    public static E: Tonality;
    public static F: Tonality;
    public static FF: Tonality;
    public static G: Tonality;
    public static GG: Tonality;
    public static A: Tonality;
    public static B: Tonality;

    public static Cm: Tonality;
    public static CCm: Tonality;
    public static Dm: Tonality;
    public static DDm: Tonality;
    public static Em: Tonality;
    public static Fm: Tonality;
    public static FFm: Tonality;
    public static Gm: Tonality;
    public static GGm: Tonality;
    public static Am: Tonality;
    public static Bm: Tonality;

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

        let lastChromaticInt = Chromatic.fromDiatonicAlt(this.root).intValue;
        let lastDiatonicInt = this.root.diatonic.intValue;
        let i = 0;
        for (let n of this.scale.intervals) {
            if (i >= this.scale.intervals.length)
                continue;
            lastChromaticInt += n;
            lastChromaticInt %= Chromatic.NUMBER;
            lastDiatonicInt++;
            lastDiatonicInt %= Diatonic.NUMBER;
            let lastChromatic = Chromatic.fromInt(lastChromaticInt);
            let lastDiatonic = Diatonic.fromInt(lastDiatonicInt);
            let note = DiatonicAlt.fromChromatic(lastChromatic, lastDiatonic);
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
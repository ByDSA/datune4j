import { Chromatic } from '../degrees/Chromatic';
import { Diatonic } from '../degrees/Diatonic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { ImmutablesCache } from '../Utils/ImmutablesCache';
import { Scale } from './Scale';
import { ScaleUtils } from './ScaleUtils';

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

    private static immutables = new ImmutablesCache<Tonality, HashingObjectType>(
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
        this._notes.push(this.root);

        let lastChromatic = this.root.chromatic;
        let lastDiatonic = this.root.diatonic;
        let i = 1;
        for (let n of this.scale.intervals) {
            if (i >= this.scale.intervals.length)
                break;
            lastChromatic = lastChromatic.getShift(n);
            lastDiatonic = Diatonic.fromInt(ScaleUtils.getRefNum(this.scale, i));
            let note = DiatonicAlt.fromChromatic(lastChromatic, lastDiatonic);
            this._notes.push(note);
            i++;
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
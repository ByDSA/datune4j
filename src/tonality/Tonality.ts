import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { DiatonicUtils } from '../degrees/DiatonicUtils';
import { Chromatic } from '../degrees/Chromatic';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { Scale } from './Scale';

export class Tonality {
    private _notes: DiatonicAlt[] = [];

    private constructor(private _root: DiatonicAlt, private _scale: Scale) {
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
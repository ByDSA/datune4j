import { DiatonicDegree } from './DiatonicDegree';

export class DiatonicAltDegree {
    public static I: DiatonicAltDegree;
    public static bII: DiatonicAltDegree;
    public static II: DiatonicAltDegree;
    public static bIII: DiatonicAltDegree;
    public static III: DiatonicAltDegree;
    public static IV: DiatonicAltDegree;
    public static bV: DiatonicAltDegree;
    public static V: DiatonicAltDegree;
    public static bVI: DiatonicAltDegree;
    public static VI: DiatonicAltDegree;
    public static bVII: DiatonicAltDegree;
    public static VII: DiatonicAltDegree;

    private constructor(private _diatonicDegree: DiatonicDegree, private _alts: number) {
    }

    public static from(diatonicDegree: DiatonicDegree, alts: number): DiatonicAltDegree {
        return new DiatonicAltDegree(diatonicDegree, alts);
    }

    public get diatonicDegree(): DiatonicDegree {
        return this._diatonicDegree;
    }

    public get alts(): number {
        return this._alts;
    }

    private static initialize() {
        DiatonicAltDegree.I = DiatonicAltDegree.from(DiatonicDegree.I, 0);
    }
}
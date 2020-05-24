import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { Settings } from '../../settings/Settings';

export class NamingDiatonicAlt {
    private constructor() {
    }

    public static toString(diatonicAlt: DiatonicAlt): string {
        return diatonicAlt.diatonic.toString() + Settings.symbols.alts(diatonicAlt.alts);
    }

    static get(str: string): DiatonicAlt {
        str = this.normalizeInputString(str);

        switch (str) {
            case DiatonicAlt.C.toString(): return DiatonicAlt.C;
            case DiatonicAlt.CC.toString(): return DiatonicAlt.CC;
            case DiatonicAlt.CCC.toString(): return DiatonicAlt.CCC;
            case DiatonicAlt.Cb.toString(): return DiatonicAlt.Cb;
            case DiatonicAlt.Cbb.toString(): return DiatonicAlt.Cbb;
            case DiatonicAlt.D.toString(): return DiatonicAlt.D;
            case DiatonicAlt.DD.toString(): return DiatonicAlt.DD;
            case DiatonicAlt.DDD.toString(): return DiatonicAlt.DDD;
            case DiatonicAlt.Db.toString(): return DiatonicAlt.Db;
            case DiatonicAlt.Dbb.toString(): return DiatonicAlt.Dbb;
            case DiatonicAlt.E.toString(): return DiatonicAlt.E;
            case DiatonicAlt.EE.toString(): return DiatonicAlt.EE;
            case DiatonicAlt.EEE.toString(): return DiatonicAlt.EEE;
            case DiatonicAlt.Eb.toString(): return DiatonicAlt.Eb;
            case DiatonicAlt.Ebb.toString(): return DiatonicAlt.Ebb;
            case DiatonicAlt.F.toString(): return DiatonicAlt.F;
            case DiatonicAlt.FF.toString(): return DiatonicAlt.FF;
            case DiatonicAlt.FFF.toString(): return DiatonicAlt.FFF;
            case DiatonicAlt.Fb.toString(): return DiatonicAlt.Fb;
            case DiatonicAlt.Fbb.toString(): return DiatonicAlt.Fbb;
            case DiatonicAlt.G.toString(): return DiatonicAlt.G;
            case DiatonicAlt.GG.toString(): return DiatonicAlt.GG;
            case DiatonicAlt.GGG.toString(): return DiatonicAlt.GGG;
            case DiatonicAlt.Gb.toString(): return DiatonicAlt.Gb;
            case DiatonicAlt.Gbb.toString(): return DiatonicAlt.Gbb;
            case DiatonicAlt.A.toString(): return DiatonicAlt.A;
            case DiatonicAlt.AA.toString(): return DiatonicAlt.AA;
            case DiatonicAlt.AAA.toString(): return DiatonicAlt.AAA;
            case DiatonicAlt.Ab.toString(): return DiatonicAlt.Ab;
            case DiatonicAlt.Abb.toString(): return DiatonicAlt.Abb;
            case DiatonicAlt.B.toString(): return DiatonicAlt.B;
            case DiatonicAlt.BB.toString(): return DiatonicAlt.BB;
            case DiatonicAlt.BBB.toString(): return DiatonicAlt.BBB;
            case DiatonicAlt.Bb.toString(): return DiatonicAlt.Bb;
            case DiatonicAlt.Bbb.toString(): return DiatonicAlt.Bbb;
        }
        throw new Error("Can't convert '" + str + "' to DiatonicAlt.");
    }

    private static normalizeInputString(strValue: string): string {
        return strValue.replace(/ /g, '')
            .replace(/#/g, Settings.symbols.sharp)
            .replace(/b/g, Settings.symbols.bemol);
    }
}
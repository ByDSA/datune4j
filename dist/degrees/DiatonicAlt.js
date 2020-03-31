import { Diatonic } from './Diatonic';
import { Chromatic } from './Chromatic';
import { DiatonicUtils } from './DiatonicUtils';
import { IntervalDiatonicUtils } from '../interval/IntervalDiatonicUtils';
import { ChromaticUtils } from './ChromaticUtils';
import { Utils } from '../Utils';
import { NameUtils } from '../lang/NameUtils';
export class DiatonicAlt {
    constructor(diatonic, alts) {
        this.diatonic = diatonic;
        this.alts = alts;
    }
    static from(diatonic, alts) {
        return new DiatonicAlt(diatonic, alts);
    }
    static fromChromatic(chromatic, diatonic) {
        switch (chromatic) {
            case Chromatic.C:
                switch (diatonic) {
                    case Diatonic.B:
                        return DiatonicAlt.BB;
                    case undefined:
                    case Diatonic.C:
                        return DiatonicAlt.C;
                    case Diatonic.D:
                        return DiatonicAlt.Dbb;
                }
                break;
            case Chromatic.CC:
                switch (diatonic) {
                    case Diatonic.B:
                        return DiatonicAlt.BBB;
                    case undefined:
                    case Diatonic.C:
                        return DiatonicAlt.CC;
                    case Diatonic.D:
                        return DiatonicAlt.Db;
                }
                break;
            case Chromatic.D:
                switch (diatonic) {
                    case Diatonic.C:
                        return DiatonicAlt.CCC;
                    case undefined:
                    case Diatonic.D:
                        return DiatonicAlt.D;
                    case Diatonic.E:
                        return DiatonicAlt.Ebb;
                }
                break;
            case Chromatic.DD:
                switch (diatonic) {
                    case undefined:
                    case Diatonic.D:
                        return DiatonicAlt.DD;
                    case Diatonic.E:
                        return DiatonicAlt.Eb;
                    case Diatonic.F:
                        return DiatonicAlt.Fbb;
                }
                break;
            case Chromatic.E:
                switch (diatonic) {
                    case Diatonic.D:
                        return DiatonicAlt.DDD;
                    case undefined:
                    case Diatonic.E:
                        return DiatonicAlt.E;
                    case Diatonic.F:
                        return DiatonicAlt.Fb;
                }
                break;
            case Chromatic.F:
                switch (diatonic) {
                    case Diatonic.E:
                        return DiatonicAlt.EE;
                    case undefined:
                    case Diatonic.F:
                        return DiatonicAlt.F;
                    case Diatonic.G:
                        return DiatonicAlt.Gbb;
                }
                break;
            case Chromatic.FF:
                switch (diatonic) {
                    case Diatonic.E:
                        return DiatonicAlt.EEE;
                    case undefined:
                    case Diatonic.F:
                        return DiatonicAlt.FF;
                    case Diatonic.G:
                        return DiatonicAlt.Gb;
                }
                break;
            case Chromatic.G:
                switch (diatonic) {
                    case Diatonic.F:
                        return DiatonicAlt.FFF;
                    case undefined:
                    case Diatonic.G:
                        return DiatonicAlt.G;
                    case Diatonic.A:
                        return DiatonicAlt.Abb;
                }
                break;
            case Chromatic.GG:
                switch (diatonic) {
                    case undefined:
                    case Diatonic.G:
                        return DiatonicAlt.GG;
                    case Diatonic.A:
                        return DiatonicAlt.Ab;
                }
                break;
            case Chromatic.A:
                switch (diatonic) {
                    case Diatonic.G:
                        return DiatonicAlt.GGG;
                    case undefined:
                    case Diatonic.A:
                        return DiatonicAlt.A;
                    case Diatonic.B:
                        return DiatonicAlt.Bbb;
                }
                break;
            case Chromatic.AA:
                switch (diatonic) {
                    case undefined:
                    case Diatonic.A:
                        return DiatonicAlt.AA;
                    case Diatonic.D:
                        return DiatonicAlt.Bb;
                }
                break;
            case Chromatic.B:
                switch (diatonic) {
                    case Diatonic.A:
                        return DiatonicAlt.AAA;
                    case undefined:
                    case Diatonic.B:
                        return DiatonicAlt.B;
                    case Diatonic.C:
                        return DiatonicAlt.Cb;
                }
                break;
        }
        Error();
    }
    getShifted(intervalChromatic) {
        Utils.assertNotNull(intervalChromatic);
        let intervalDiatonic = IntervalDiatonicUtils.fromIntervalChromatic(intervalChromatic);
        let diatonic = DiatonicUtils.getShifted(this.diatonic, intervalDiatonic);
        let alts = ChromaticUtils.fromDiatonicAlt(this) + intervalChromatic.getSemis() - ChromaticUtils.fromDiatonic(diatonic);
        alts %= ChromaticUtils.NUMBER;
        if (alts > 4)
            alts -= ChromaticUtils.NUMBER;
        else if (alts < -4)
            alts += ChromaticUtils.NUMBER;
        return DiatonicAlt.from(diatonic, alts);
    }
    getDiatonic() {
        return this.diatonic;
    }
    getAlts() {
        return this.alts;
    }
    toString() {
        return DiatonicUtils.toString(this.diatonic) + this.altsToString();
    }
    altsToString() {
        return NameUtils.alts(this.alts);
    }
}
DiatonicAlt.C = DiatonicAlt.from(Diatonic.C, 0);
DiatonicAlt.CC = DiatonicAlt.from(Diatonic.C, 1);
DiatonicAlt.CCC = DiatonicAlt.from(Diatonic.C, 2);
DiatonicAlt.Cb = DiatonicAlt.from(Diatonic.C, -1);
DiatonicAlt.Cbb = DiatonicAlt.from(Diatonic.C, -2);
DiatonicAlt.D = DiatonicAlt.from(Diatonic.D, 0);
DiatonicAlt.DD = DiatonicAlt.from(Diatonic.D, 1);
DiatonicAlt.DDD = DiatonicAlt.from(Diatonic.D, 2);
DiatonicAlt.Db = DiatonicAlt.from(Diatonic.D, -1);
DiatonicAlt.Dbb = DiatonicAlt.from(Diatonic.D, -2);
DiatonicAlt.E = DiatonicAlt.from(Diatonic.E, 0);
DiatonicAlt.EE = DiatonicAlt.from(Diatonic.E, 1);
DiatonicAlt.EEE = DiatonicAlt.from(Diatonic.E, 2);
DiatonicAlt.Eb = DiatonicAlt.from(Diatonic.E, -1);
DiatonicAlt.Ebb = DiatonicAlt.from(Diatonic.E, -2);
DiatonicAlt.F = DiatonicAlt.from(Diatonic.F, 0);
DiatonicAlt.FF = DiatonicAlt.from(Diatonic.F, 1);
DiatonicAlt.FFF = DiatonicAlt.from(Diatonic.F, 2);
DiatonicAlt.Fb = DiatonicAlt.from(Diatonic.F, -1);
DiatonicAlt.Fbb = DiatonicAlt.from(Diatonic.F, -2);
DiatonicAlt.G = DiatonicAlt.from(Diatonic.G, 0);
DiatonicAlt.GG = DiatonicAlt.from(Diatonic.G, 1);
DiatonicAlt.GGG = DiatonicAlt.from(Diatonic.G, 2);
DiatonicAlt.Gb = DiatonicAlt.from(Diatonic.G, -1);
DiatonicAlt.Gbb = DiatonicAlt.from(Diatonic.G, -2);
DiatonicAlt.A = DiatonicAlt.from(Diatonic.A, 0);
DiatonicAlt.AA = DiatonicAlt.from(Diatonic.A, 1);
DiatonicAlt.AAA = DiatonicAlt.from(Diatonic.A, 2);
DiatonicAlt.Ab = DiatonicAlt.from(Diatonic.A, -1);
DiatonicAlt.Abb = DiatonicAlt.from(Diatonic.A, -2);
DiatonicAlt.B = DiatonicAlt.from(Diatonic.B, 0);
DiatonicAlt.BB = DiatonicAlt.from(Diatonic.B, 1);
DiatonicAlt.BBB = DiatonicAlt.from(Diatonic.B, 2);
DiatonicAlt.Bb = DiatonicAlt.from(Diatonic.B, -1);
DiatonicAlt.Bbb = DiatonicAlt.from(Diatonic.B, -2);
//# sourceMappingURL=DiatonicAlt.js.map
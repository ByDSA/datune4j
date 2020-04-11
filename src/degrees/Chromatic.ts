import { IntervalChromatic } from '../interval/IntervalChromatic';
import { NamingChromatic } from '../lang/naming/NamingChromatic';
import { MathUtils } from '../MathUtils';
import { Diatonic } from './Diatonic';
import { DiatonicAlt } from './DiatonicAlt';
import { Utils } from '../Utils';

export class Chromatic {
    public static NUMBER = 12;

    // Precalc

    static C: Chromatic;
    static CC: Chromatic;
    static D: Chromatic;
    static DD: Chromatic;
    static E: Chromatic;
    static F: Chromatic;
    static FF: Chromatic;
    static G: Chromatic;
    static GG: Chromatic;
    static A: Chromatic;
    static AA: Chromatic;
    static B: Chromatic;

    private constructor(private _intValue: number) {
    }

    static fromDiatonic(diatonic: Diatonic): Chromatic {
        switch (diatonic) {
            case Diatonic.C: return Chromatic.C;
            case Diatonic.D: return Chromatic.D;
            case Diatonic.E: return Chromatic.E;
            case Diatonic.F: return Chromatic.F;
            case Diatonic.G: return Chromatic.G;
            case Diatonic.A: return Chromatic.A;
            case Diatonic.B: return Chromatic.B;
        }

        throw new Error("Impossible get Chromatic from Diatonic: " + diatonic);
    }

    static fromInt(intValue: number): Chromatic {
        intValue = MathUtils.rotativeTrim(intValue, Chromatic.NUMBER);
        switch (intValue) {
            case 0: return Chromatic.C;
            case 1: return Chromatic.CC;
            case 2: return Chromatic.D;
            case 3: return Chromatic.DD;
            case 4: return Chromatic.E;
            case 5: return Chromatic.F;
            case 6: return Chromatic.FF;
            case 7: return Chromatic.G;
            case 8: return Chromatic.GG;
            case 9: return Chromatic.A;
            case 10: return Chromatic.AA;
            case 11: return Chromatic.B;
        }
        throw new Error("Impossible get Chromatic from int value: " + intValue);
    }

    static fromDiatonicAlt(diatonicAlt: DiatonicAlt): Chromatic {
        let chromaticInt = Chromatic.fromDiatonic(diatonicAlt.diatonic).intValue;
        chromaticInt += diatonicAlt.alts;

        return Chromatic.fromInt(chromaticInt);
    }

    public getAdd(intervalChromatic: IntervalChromatic): Chromatic {
        return this.getShift(intervalChromatic.semis);
    }

    public getSub(intervalChromatic: IntervalChromatic): Chromatic {
        return this.getShift(-intervalChromatic.semis);
    }

    public getShift(semis: number): Chromatic {
        let intValue = MathUtils.rotativeTrim(this.intValue + semis, Chromatic.NUMBER);
        return Chromatic.fromInt(intValue);
    }

    get intValue() {
        return this._intValue;
    }

    toString() {
        return NamingChromatic.toString(this);
    }

    private static initialize() {
        Chromatic.C = Utils.immutable(new Chromatic(0));
        Chromatic.CC = Utils.immutable(new Chromatic(1));
        Chromatic.D = Utils.immutable(new Chromatic(2));
        Chromatic.DD = Utils.immutable(new Chromatic(3));
        Chromatic.E = Utils.immutable(new Chromatic(4));
        Chromatic.F = Utils.immutable(new Chromatic(5));
        Chromatic.FF = Utils.immutable(new Chromatic(6));
        Chromatic.G = Utils.immutable(new Chromatic(7));
        Chromatic.GG = Utils.immutable(new Chromatic(8));
        Chromatic.A = Utils.immutable(new Chromatic(9));
        Chromatic.AA = Utils.immutable(new Chromatic(10));
        Chromatic.B = Utils.immutable(new Chromatic(11));

        Utils.immutable(Chromatic);
    }
}
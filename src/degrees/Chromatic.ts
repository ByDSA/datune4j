import { NamingChromatic } from '../lang/naming/NamingChromatic';
import { DiatonicAlt } from './DiatonicAlt';
import { MathUtils } from '../MathUtils';
import { Diatonic } from './Diatonic';
import { IntervalChromatic } from '../interval/IntervalChromatic';

export class Chromatic {
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

    get intValue() {
        return this._intValue;
    }

    toString() {
        return NamingChromatic.toString(this);
    }

    static fromString(str: string): Chromatic {
        return NamingChromatic.getChromatic(str);
    }

    public static NUMBER = 12;

    static fromDiatonicAlt(diatonicAlt: DiatonicAlt): Chromatic {
        let chromaticInt = Chromatic.fromDiatonic(diatonicAlt.diatonic).intValue;
        chromaticInt += diatonicAlt.alts;
        chromaticInt = MathUtils.rotativeTrim(chromaticInt, Chromatic.NUMBER);

        return Chromatic.fromInt(chromaticInt);
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

    public static getShifted(root: Chromatic, intervalChromatic: IntervalChromatic): Chromatic {
        return Chromatic.getShiftedBySemis(root, intervalChromatic.semis);
    }

    public static getShiftedBySemis(root: Chromatic, semis: number): Chromatic {
        let intValue = MathUtils.rotativeTrim(root.intValue + semis, Chromatic.NUMBER);
        return Chromatic.fromInt(intValue);
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

    private static initialize() {
        Chromatic.C = new Chromatic(0);
        Chromatic.CC = new Chromatic(1);
        Chromatic.D = new Chromatic(2);
        Chromatic.DD = new Chromatic(3);
        Chromatic.E = new Chromatic(4);
        Chromatic.F = new Chromatic(5);
        Chromatic.FF = new Chromatic(6);
        Chromatic.G = new Chromatic(7);
        Chromatic.GG = new Chromatic(8);
        Chromatic.A = new Chromatic(9);
        Chromatic.AA = new Chromatic(10);
        Chromatic.B = new Chromatic(11);
    }
}
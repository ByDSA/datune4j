import { IntervalDiatonic } from '../interval/IntervalDiatonic';
import { NamingDiatonic } from '../lang/naming/NamingDiatonic';
import { MathUtils } from '../Utils/MathUtils';

export class Diatonic {
    static C: Diatonic;
    static D: Diatonic;
    static E: Diatonic;
    static F: Diatonic;
    static G: Diatonic;
    static A: Diatonic;
    static B: Diatonic;

    public static NUMBER = 7;

    public static getShifted(diatonic: Diatonic, intervalDiatonic: IntervalDiatonic): Diatonic {
        let intValue = MathUtils.rotativeTrim(diatonic.intValue + intervalDiatonic, Diatonic.NUMBER);
        return Diatonic.fromInt(intValue);
    }

    static fromInt(intValue: number): Diatonic {
        intValue = MathUtils.rotativeTrim(intValue, Diatonic.NUMBER);
        switch (intValue) {
            case 0: return Diatonic.C;
            case 1: return Diatonic.D;
            case 2: return Diatonic.E;
            case 3: return Diatonic.F;
            case 4: return Diatonic.G;
            case 5: return Diatonic.A;
            case 6: return Diatonic.B;
        }

        throw new Error("Impossible get Diatonic from int value: " + intValue);
    }

    private constructor(private _intValue: number) {
    }

    get intValue() {
        return this._intValue;
    }

    toString() {
        return NamingDiatonic.toString(this);
    }

    private static initialize() {
        Diatonic.C = new Diatonic(0);
        Diatonic.D = new Diatonic(1);
        Diatonic.E = new Diatonic(2);
        Diatonic.F = new Diatonic(3);
        Diatonic.G = new Diatonic(4);
        Diatonic.A = new Diatonic(5);
        Diatonic.B = new Diatonic(6);
    }
}
import { NamingDiatonicAlt } from '../lang/naming/NamingDiatonicAlt';
import { Hashable } from '../Hashable';
import { Hashing } from '../Hashing';
import { IntervalChromatic } from '../interval/IntervalChromatic';
import { IntervalDiatonicUtils } from '../interval/IntervalDiatonicUtils';
import { Utils } from '../Utils';
import { Chromatic } from './Chromatic';
import { Diatonic } from './Diatonic';

export class DiatonicAlt implements Hashable {
    public static C: DiatonicAlt;
    public static CC: DiatonicAlt;
    public static CCC: DiatonicAlt;
    public static Cb: DiatonicAlt;
    public static Cbb: DiatonicAlt;

    public static D: DiatonicAlt;
    public static DD: DiatonicAlt;
    public static DDD: DiatonicAlt;
    public static Db: DiatonicAlt;
    public static Dbb: DiatonicAlt;

    public static E: DiatonicAlt;
    public static EE: DiatonicAlt;
    public static EEE: DiatonicAlt;
    public static Eb: DiatonicAlt;
    public static Ebb: DiatonicAlt;

    public static F: DiatonicAlt;
    public static FF: DiatonicAlt;
    public static FFF: DiatonicAlt;
    public static Fb: DiatonicAlt;
    public static Fbb: DiatonicAlt;

    public static G: DiatonicAlt;
    public static GG: DiatonicAlt;
    public static GGG: DiatonicAlt;
    public static Gb: DiatonicAlt;
    public static Gbb: DiatonicAlt;

    public static A: DiatonicAlt;
    public static AA: DiatonicAlt;
    public static AAA: DiatonicAlt;
    public static Ab: DiatonicAlt;
    public static Abb: DiatonicAlt;

    public static B: DiatonicAlt;
    public static BB: DiatonicAlt;
    public static BBB: DiatonicAlt;
    public static Bb: DiatonicAlt;
    public static Bbb: DiatonicAlt;

    public static from(diatonic: Diatonic, alts: number): DiatonicAlt {
        return new DiatonicAlt(diatonic, alts);
    }

    public static fromChromatic(chromatic: Chromatic, diatonic?: Diatonic): DiatonicAlt {
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

    private constructor(private _diatonic: Diatonic, private _alts: number) {
    }

    getShifted(intervalChromatic: IntervalChromatic): DiatonicAlt {
        Utils.assertNotNull(intervalChromatic);

        let intervalDiatonic = IntervalDiatonicUtils.fromIntervalChromatic(intervalChromatic);
        let diatonic = Diatonic.getShifted(this.diatonic, intervalDiatonic);
        let alts = Chromatic.fromDiatonicAlt(this).intValue + intervalChromatic.semis - Chromatic.fromDiatonic(diatonic).intValue;
        alts %= Chromatic.NUMBER;
        if (alts > 4)
            alts -= Chromatic.NUMBER;
        else if (alts < -4)
            alts += Chromatic.NUMBER;

        return DiatonicAlt.from(diatonic, alts);
    }

    public get diatonic(): Diatonic {
        return this._diatonic;
    }

    public get alts(): number {
        return this._alts;
    }

    public toString(): string {
        return NamingDiatonicAlt.toString(this);
    }

    hashCode(): string {
        return Hashing.hash(this.diatonic) + Hashing.hash(this.alts);
    }

    private static initialize() {
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
    }
}
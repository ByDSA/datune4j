import { Diatonic } from './Diatonic';
import { Chromatic } from './Chromatic';
import { DiatonicUtils } from './DiatonicUtils';
import { IntervalChromatic } from '../interval/IntervalChromatic';
import { IntervalDiatonicUtils } from '../interval/IntervalDiatonicUtils';
import { ChromaticUtils } from './ChromaticUtils';
import { Utils } from '../Utils';
import { NameUtils } from '../lang/NameUtils';

export class DiatonicAlt {
    public static C = DiatonicAlt.from(Diatonic.C, 0);
    public static CC = DiatonicAlt.from(Diatonic.C, 1);
    public static CCC = DiatonicAlt.from(Diatonic.C, 2);
    public static Cb = DiatonicAlt.from(Diatonic.C, -1);
    public static Cbb = DiatonicAlt.from(Diatonic.C, -2);

    public static D = DiatonicAlt.from(Diatonic.D, 0);
    public static DD = DiatonicAlt.from(Diatonic.D, 1);
    public static DDD = DiatonicAlt.from(Diatonic.D, 2);
    public static Db = DiatonicAlt.from(Diatonic.D, -1);
    public static Dbb = DiatonicAlt.from(Diatonic.D, -2);

    public static E = DiatonicAlt.from(Diatonic.E, 0);
    public static EE = DiatonicAlt.from(Diatonic.E, 1);
    public static EEE = DiatonicAlt.from(Diatonic.E, 2);
    public static Eb = DiatonicAlt.from(Diatonic.E, -1);
    public static Ebb = DiatonicAlt.from(Diatonic.E, -2);

    public static F = DiatonicAlt.from(Diatonic.F, 0);
    public static FF = DiatonicAlt.from(Diatonic.F, 1);
    public static FFF = DiatonicAlt.from(Diatonic.F, 2);
    public static Fb = DiatonicAlt.from(Diatonic.F, -1);
    public static Fbb = DiatonicAlt.from(Diatonic.F, -2);

    public static G = DiatonicAlt.from(Diatonic.G, 0);
    public static GG = DiatonicAlt.from(Diatonic.G, 1);
    public static GGG = DiatonicAlt.from(Diatonic.G, 2);
    public static Gb = DiatonicAlt.from(Diatonic.G, -1);
    public static Gbb = DiatonicAlt.from(Diatonic.G, -2);

    public static A = DiatonicAlt.from(Diatonic.A, 0);
    public static AA = DiatonicAlt.from(Diatonic.A, 1);
    public static AAA = DiatonicAlt.from(Diatonic.A, 2);
    public static Ab = DiatonicAlt.from(Diatonic.A, -1);
    public static Abb = DiatonicAlt.from(Diatonic.A, -2);

    public static B = DiatonicAlt.from(Diatonic.B, 0);
    public static BB = DiatonicAlt.from(Diatonic.B, 1);
    public static BBB = DiatonicAlt.from(Diatonic.B, 2);
    public static Bb = DiatonicAlt.from(Diatonic.B, -1);
    public static Bbb = DiatonicAlt.from(Diatonic.B, -2);

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

    private constructor(private diatonic: Diatonic, private alts: number) {
    }

    getShifted(intervalChromatic: IntervalChromatic): DiatonicAlt {
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

    public getDiatonic(): Diatonic {
        return this.diatonic;
    }

    public getAlts(): number {
        return this.alts;
    }

    public toString(): string {
        return DiatonicUtils.toString(this.diatonic) + this.altsToString();
    }

    private altsToString(): string {
        return NameUtils.alts(this.alts);
    }
}
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { ScalePrecalc } from './ScalePrecalc';
import { Tonality } from "./Tonality";

export class TonalityPrecalc {
    private constructor() {
    }

    public static C = Tonality.from(DiatonicAlt.C, ScalePrecalc.MAJOR);
    public static CC = Tonality.from(DiatonicAlt.CC, ScalePrecalc.MAJOR);
    public static D = Tonality.from(DiatonicAlt.D, ScalePrecalc.MAJOR);
    public static DD = Tonality.from(DiatonicAlt.DD, ScalePrecalc.MAJOR);
    public static E = Tonality.from(DiatonicAlt.E, ScalePrecalc.MAJOR);
    public static F = Tonality.from(DiatonicAlt.F, ScalePrecalc.MAJOR);
    public static FF = Tonality.from(DiatonicAlt.FF, ScalePrecalc.MAJOR);
    public static G = Tonality.from(DiatonicAlt.G, ScalePrecalc.MAJOR);
    public static GG = Tonality.from(DiatonicAlt.GG, ScalePrecalc.MAJOR);
    public static A = Tonality.from(DiatonicAlt.A, ScalePrecalc.MAJOR);
    public static B = Tonality.from(DiatonicAlt.B, ScalePrecalc.MAJOR);

    public static Cm = Tonality.from(DiatonicAlt.C, ScalePrecalc.MINOR);
    public static CCm = Tonality.from(DiatonicAlt.CC, ScalePrecalc.MINOR);
    public static Dm = Tonality.from(DiatonicAlt.D, ScalePrecalc.MINOR);
    public static DDm = Tonality.from(DiatonicAlt.DD, ScalePrecalc.MINOR);
    public static Em = Tonality.from(DiatonicAlt.E, ScalePrecalc.MINOR);
    public static Fm = Tonality.from(DiatonicAlt.F, ScalePrecalc.MINOR);
    public static FFm = Tonality.from(DiatonicAlt.FF, ScalePrecalc.MINOR);
    public static Gm = Tonality.from(DiatonicAlt.G, ScalePrecalc.MINOR);
    public static GGm = Tonality.from(DiatonicAlt.GG, ScalePrecalc.MINOR);
    public static Am = Tonality.from(DiatonicAlt.A, ScalePrecalc.MINOR);
    public static Bm = Tonality.from(DiatonicAlt.B, ScalePrecalc.MINOR);
}

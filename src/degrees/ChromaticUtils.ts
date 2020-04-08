import { IntervalChromatic } from '../interval/IntervalChromatic';
import { MathUtils } from '../MathUtils';
import { Chromatic } from './Chromatic';
import { Diatonic } from './Diatonic';
import { DiatonicAlt } from './DiatonicAlt';
import { DiatonicUtils } from './DiatonicUtils';
import { Settings } from '../Settings';

export class ChromaticUtils {
    public static NUMBER = 12;

    static fromDiatonicAlt(diatonicAlt: DiatonicAlt): Chromatic {
        let chromatic = ChromaticUtils.fromDiatonic(diatonicAlt.diatonic);
        chromatic += diatonicAlt.alts;
        chromatic = MathUtils.rotativeTrim(chromatic, ChromaticUtils.NUMBER);

        return chromatic;
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
    }

    public static getShifted(root: Chromatic, intervalChromatic: IntervalChromatic): Chromatic {
        return ChromaticUtils.getShiftedBySemis(root, intervalChromatic.semis);
    }

    public static getShiftedBySemis(root: Chromatic, semis: number): Chromatic {
        return MathUtils.rotativeTrim(root + semis, ChromaticUtils.NUMBER);
    }

    public static toString(chromatic: Chromatic): string {
        switch (chromatic) {
            case Chromatic.C: return DiatonicUtils.toString(Diatonic.C);
            case Chromatic.CC: return DiatonicUtils.toString(Diatonic.C) + Settings.symbols.alts(1);
            case Chromatic.D: return DiatonicUtils.toString(Diatonic.D);
            case Chromatic.DD: return DiatonicUtils.toString(Diatonic.D) + Settings.symbols.alts(1);
            case Chromatic.E: return DiatonicUtils.toString(Diatonic.E);
            case Chromatic.F: return DiatonicUtils.toString(Diatonic.F);
            case Chromatic.FF: return DiatonicUtils.toString(Diatonic.F) + Settings.symbols.alts(1);
            case Chromatic.G: return DiatonicUtils.toString(Diatonic.G);
            case Chromatic.GG: return DiatonicUtils.toString(Diatonic.G) + Settings.symbols.alts(1);
            case Chromatic.A: return DiatonicUtils.toString(Diatonic.A);
            case Chromatic.AA: return DiatonicUtils.toString(Diatonic.A) + Settings.symbols.alts(1);
            case Chromatic.B: return DiatonicUtils.toString(Diatonic.B);
        }

        return "";
    }

    public static toStringParams(chromatic: Chromatic) {
        return this.toString(chromatic);
    }

    static fromString(noteStr: string): Chromatic {
        switch (noteStr) {
            case this.toString(Chromatic.C): return Chromatic.C;
            case this.toString(Chromatic.CC): return Chromatic.CC;
            case this.toString(Chromatic.D): return Chromatic.D;
            case this.toString(Chromatic.DD): return Chromatic.DD;
            case this.toString(Chromatic.E): return Chromatic.E;
            case this.toString(Chromatic.F): return Chromatic.F;
            case this.toString(Chromatic.FF): return Chromatic.FF;
            case this.toString(Chromatic.G): return Chromatic.G;
            case this.toString(Chromatic.GG): return Chromatic.GG;
            case this.toString(Chromatic.A): return Chromatic.A;
            case this.toString(Chromatic.AA): return Chromatic.AA;
            case this.toString(Chromatic.B): return Chromatic.B;
        }
        throw new Error("Can't convert '" + noteStr + "' to Chromatic.");
    }
}
import { IntervalChromatic } from '../interval/IntervalChromatic';
import { MathUtils } from '../MathUtils';
import { Chromatic } from './Chromatic';
import { Diatonic } from './Diatonic';
import { DiatonicAlt } from './DiatonicAlt';

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
}
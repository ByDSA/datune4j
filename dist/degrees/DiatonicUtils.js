import { Diatonic } from './Diatonic';
import { MathUtils } from '../MathUtils';
export class DiatonicUtils {
    static getShifted(diatonic, intervalDiatonic) {
        return MathUtils.rotativeTrim(diatonic + intervalDiatonic, DiatonicUtils.NUMBER);
    }
    static toString(diatonic) {
        switch (diatonic) {
            case Diatonic.C: return "C";
            case Diatonic.D: return "D";
            case Diatonic.E: return "E";
            case Diatonic.F: return "F";
            case Diatonic.G: return "G";
            case Diatonic.A: return "A";
            case Diatonic.B: return "B";
        }
        Error();
    }
}
DiatonicUtils.NUMBER = 7;
//# sourceMappingURL=DiatonicUtils.js.map
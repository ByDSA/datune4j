import { Diatonic } from './Diatonic';
import { IntervalDiatonic } from '../interval/IntervalDiatonic';
import { MathUtils } from '../MathUtils';

export class DiatonicUtils {
    public static NUMBER = 7;
    
    public static getShifted(diatonic: Diatonic, intervalDiatonic: IntervalDiatonic): Diatonic {
       return MathUtils.rotativeTrim(diatonic + intervalDiatonic, DiatonicUtils.NUMBER);
    }

    public static toString(diatonic : Diatonic) : string {
        switch(diatonic) {
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
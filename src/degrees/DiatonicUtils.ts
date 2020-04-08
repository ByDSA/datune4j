import { Diatonic } from './Diatonic';
import { IntervalDiatonic } from '../interval/IntervalDiatonic';
import { MathUtils } from '../MathUtils';
import { Settings } from '../settings/Settings';

export class DiatonicUtils {
    public static NUMBER = 7;
    
    public static getShifted(diatonic: Diatonic, intervalDiatonic: IntervalDiatonic): Diatonic {
       return MathUtils.rotativeTrim(diatonic + intervalDiatonic, DiatonicUtils.NUMBER);
    }

    public static toString(diatonic : Diatonic) : string {
        switch(diatonic) {
            case Diatonic.C: return Settings.lang.diatonic.C;
            case Diatonic.D: return Settings.lang.diatonic.D;
            case Diatonic.E: return Settings.lang.diatonic.E;
            case Diatonic.F: return Settings.lang.diatonic.F;
            case Diatonic.G: return Settings.lang.diatonic.G;
            case Diatonic.A: return Settings.lang.diatonic.A;
            case Diatonic.B: return Settings.lang.diatonic.B;
        }

        Error();
    }
}
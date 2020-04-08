import { IntervalDiatonic } from '../interval/IntervalDiatonic';
import { MathUtils } from '../MathUtils';
import { Diatonic } from './Diatonic';

export class DiatonicUtils {
    public static NUMBER = 7;
    
    public static getShifted(diatonic: Diatonic, intervalDiatonic: IntervalDiatonic): Diatonic {
       return MathUtils.rotativeTrim(diatonic + intervalDiatonic, DiatonicUtils.NUMBER);
    }
}
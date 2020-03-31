import { Diatonic } from './Diatonic';
import { IntervalDiatonic } from '../interval/IntervalDiatonic';
export declare class DiatonicUtils {
    static NUMBER: number;
    static getShifted(diatonic: Diatonic, intervalDiatonic: IntervalDiatonic): Diatonic;
    static toString(diatonic: Diatonic): string;
}

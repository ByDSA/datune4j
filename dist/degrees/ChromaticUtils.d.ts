import { Chromatic } from './Chromatic';
import { Diatonic } from './Diatonic';
import { DiatonicAlt } from './DiatonicAlt';
import { IntervalChromatic } from '../interval/IntervalChromatic';
export declare class ChromaticUtils {
    static NUMBER: number;
    static fromDiatonicAlt(diatonicAlt: DiatonicAlt): Chromatic;
    static fromDiatonic(diatonic: Diatonic): Chromatic;
    static getShifted(root: Chromatic, intervalChromatic: IntervalChromatic): Chromatic;
    static getShiftedBySemis(root: Chromatic, semis: number): Chromatic;
    static toString(chromatic: Chromatic): string;
    static toStringParams(chromatic: Chromatic): string;
    static fromString(noteStr: string): Chromatic;
}

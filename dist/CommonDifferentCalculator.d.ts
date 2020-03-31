import { Scale } from './tonality/Scale';
export declare class CommonDifferentCalculator {
    private scales;
    private common;
    private different;
    private constructor();
    static from(scales: Scale[]): CommonDifferentCalculator;
    calculate(): void;
    private addAllAbsoluteIntervalsToCommon;
    private removeAbsoluteIntervalsFromCommon;
    getCommon(): Set<number>;
    getDifferent(): Set<number>;
}

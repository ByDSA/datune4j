import { Scale } from './Scale';
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
export interface SourceScaleInfo {
    scale: Scale;
    mode: number;
}
export declare class ScaleUtils {
    private constructor();
    static toString(scale: Scale): string;
    static getSourceScaleFrom(scale: Scale): SourceScaleInfo;
    private static toStringByIntervals;
    static calculateAbsoluteIntervals(scale: Scale): number[];
    static toStringAboluteIntervals(scale: Scale): string;
    static getRefNum(scale: Scale, i: number): number;
    static toStringAboluteInterval(pos: number, intervalAbsolute: number): string;
    private static MAJOR_ABSOLUTE_INTERVALS;
    static toStringParams(scale: Scale): string;
    static getChromaticChordPattern(scale: Scale): ChromaticChordPattern;
}

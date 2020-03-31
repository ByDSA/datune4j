import { Tonality } from './Tonality';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
export declare class TonalityUtils {
    static toStringParams(tonality: Tonality): string;
    static getChordFrom(tonality: Tonality): ChromaticChord;
}

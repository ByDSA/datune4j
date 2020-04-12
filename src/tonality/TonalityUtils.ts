import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { ScaleUtils } from './ScaleUtils';
import { Tonality } from './Tonality';

export class TonalityUtils {
    public static getChordFrom(tonality: Tonality): ChromaticChord {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.scale);
        let chromaticRoot = tonality.root.chromatic;
        let chord = ChromaticChord.fromRootPattern(chromaticRoot, patternScale);

        return chord;
    }
}
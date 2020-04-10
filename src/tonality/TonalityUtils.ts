import { Tonality } from './Tonality';
import { ScaleUtils } from './ScaleUtils';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { Chromatic } from '../degrees/Chromatic';

export class TonalityUtils {
    public static getChordFrom(tonality: Tonality): ChromaticChord {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.scale);
        let chromaticRoot = Chromatic.fromDiatonicAlt(tonality.root)
        let chord = ChromaticChord.fromRootPattern(chromaticRoot, patternScale);

        return chord;
    }
}
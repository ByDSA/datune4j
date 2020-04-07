import { Tonality } from './Tonality';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { ScaleUtils } from './ScaleUtils';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';

export class TonalityUtils {
    public static toStringParams(tonality: Tonality) {
        return tonality.getRoot().toString() + ":" + ScaleUtils.toStringParams(tonality.getScale());
    }

    public static getChordFrom(tonality: Tonality): ChromaticChord {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.getScale());
        let chromaticRoot = ChromaticUtils.fromDiatonicAlt(tonality.getRoot())
        let chord = ChromaticChord.fromRootPattern(chromaticRoot, patternScale);

        return chord;
    }
}
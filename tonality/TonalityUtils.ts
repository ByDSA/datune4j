import { Tonality } from './Tonality';
import { ChromaticUtils } from './ChromaticUtils';
import { ScaleUtils } from './ScaleUtils';
import { ChromaticChord } from './ChromaticChord';

export class TonalityUtils {
    public static toStringParams(tonality: Tonality) {
        return ChromaticUtils.toStringParams(tonality.getRoot()) + ":" + ScaleUtils.toStringParams(tonality.getScale());
    }

    public static getChordFrom(tonality: Tonality): ChromaticChord {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.getScale());
        let chord = ChromaticChord.fromRootPattern(tonality.getRoot(), patternScale);

        return chord;
    }
}
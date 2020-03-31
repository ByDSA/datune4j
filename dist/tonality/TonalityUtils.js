import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { ScaleUtils } from './ScaleUtils';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
export class TonalityUtils {
    static toStringParams(tonality) {
        return ChromaticUtils.toStringParams(tonality.getRoot()) + ":" + ScaleUtils.toStringParams(tonality.getScale());
    }
    static getChordFrom(tonality) {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.getScale());
        let chord = ChromaticChord.fromRootPattern(tonality.getRoot(), patternScale);
        return chord;
    }
}
//# sourceMappingURL=TonalityUtils.js.map
import { Tonality } from './Tonality';
import { ChromaticUtils } from '../degrees/ChromaticUtils';
import { ScaleUtils } from './ScaleUtils';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';

export class TonalityUtils {
    public static toStringParams(tonality: Tonality) {
        return tonality.root.toString() + ":" + ScaleUtils.toStringParams(tonality.scale);
    }

    public static getChordFrom(tonality: Tonality): ChromaticChord {
        let patternScale = ScaleUtils.getChromaticChordPattern(tonality.scale);
        let chromaticRoot = ChromaticUtils.fromDiatonicAlt(tonality.root)
        let chord = ChromaticChord.fromRootPattern(chromaticRoot, patternScale);

        return chord;
    }
}
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { Scale } from './Scale';
import { ScalePrecalc } from './ScalePrecalc';

export class ScaleUtils {
    private constructor() {
    }

    public static getRefNum(scale: Scale, i: number): number {
        switch (scale) {
            case ScalePrecalc.BLUES_b5:
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        return i + 1;
                }
                break;
            /*case ScalePrecalc.BLUES_a4:
                switch (i) {
                    case 2:
                    case 3:
                        return i + 1;
                }
                break;*/
            case ScalePrecalc.PENTATONIC:
                switch (i) {
                    case 4:
                    case 5: return i + 1;
                }
                break;
            case ScalePrecalc.EGYPCIAN:
                switch (i) {
                    case 3:
                    case 4: return i + 1;
                    case 5: return i + 2;
                }
                break;
            case ScalePrecalc.BLUES_MINOR:
                switch (i) {
                    case 2:
                    case 3: return i + 1;
                    case 4:
                    case 5:
                        return i + 2;
                }
                break;
            case ScalePrecalc.BLUES_MAJOR:
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                        return i + 1;
                }
                break;
            case ScalePrecalc.PENTATONIC_MINOR:
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        return i + 1;
                    case 5: return i + 2;
                }
                break;
            case ScalePrecalc.BEBOP_MAJOR:
                switch (i) {
                    case 7:
                    case 8:
                        return i - 1;
                }
                break;
            case ScalePrecalc.AUGMENTED_TRIAD:
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                }
                break;
            case ScalePrecalc.DIMINISHED_7th:
            case ScalePrecalc.DOM7b5:
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                    case 4: return 7;
                }
                break;
            default:
                if (scale.length == 7)
                    return i;
                else if (scale.length > 7) {
                    switch (scale.absoluteIntervals[i - 1]) {
                        case 0:
                        case 1:
                            return 1;
                        case 2:
                        case 3:
                            return 2;
                        case 4:
                            return 3;
                        case 5:
                        case 6:
                            return 4;
                        case 7:
                        case 8:
                            return 5;
                        case 9:
                        case 10:
                            return 6;
                        case 11:
                            return 7;
                        default:
                            return 0;
                    }
                }
        }

        return i;
    }

    public static getChromaticChordPattern(scale: Scale): ChromaticChordPattern {
        let array = [0];
        for (let n of scale.intervals) {
            let newValue = array[array.length - 1] + n;
            array.push(newValue);
        }

        return ChromaticChordPattern.fromArray(array);
    }
}
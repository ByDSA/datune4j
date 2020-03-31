import { Scale } from './Scale';
import { NameUtils } from '../lang/NameUtils';
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { ScaleModeUtils } from './ScaleModeUtils';
export class ScaleUtils {
    constructor() {
    }
    static toString(scale) {
        switch (scale) {
            case Scale.MAJOR: return "MAJOR";
            case Scale.MINOR: return "MINOR";
            case Scale.DORIAN: return "DORIAN";
            case Scale.PHRYGIAN: return "PHRYGIAN";
            case Scale.LYDIAN: return "LYDIAN";
            case Scale.MIXOLYDIAN: return "MIXOLYDIAN";
            case Scale.LOCRIAN: return "LOCRIAN";
            case Scale.HARMONIC_MINOR: return "HARMONIC MINOR";
            case Scale.LOCRIAN_a6: return this.toString(Scale.LOCRIAN) + " " + NameUtils.alts(1) + "6";
            case Scale.IONIAN_a5: return "IONIAN " + NameUtils.alts(1) + "5";
            case Scale.DORIAN_a4: return this.toString(Scale.DORIAN) + " " + NameUtils.alts(1) + "4";
            case Scale.MIXOLYDIAN_b9_b13: return this.toString(Scale.MIXOLYDIAN) + " " + NameUtils.alts(-1) + "9" + NameUtils.alts(-1) + "13";
            case Scale.LYDIAN_a2: return this.toString(Scale.LYDIAN) + " " + NameUtils.alts(1) + "2";
            case Scale.SUPERLOCRIAN_bb7: return this.toString(Scale.SUPERLOCRIAN) + " " + NameUtils.alts(-2) + "7";
            case Scale.HARMONIC_MAJOR: return "HARMONIC MAJOR";
            case Scale.DORIAN_b5: return this.toString(Scale.DORIAN) + " " + NameUtils.alts(-1) + "5";
            case Scale.PHRYGIAN_b4: return this.toString(Scale.PHRYGIAN) + " " + NameUtils.alts(-1) + "4";
            case Scale.LYDIAN_b3: return this.toString(Scale.LYDIAN) + " " + NameUtils.alts(-1) + "3";
            case Scale.MIXOLYDIAN_b2: return this.toString(Scale.MIXOLYDIAN) + " " + NameUtils.alts(-1) + "2";
            case Scale.AEOLIAN_b1: return this.toString(Scale.LYDIAN) + " AUGMENTED " + NameUtils.alts(1) + "2";
            case Scale.LOCRIAN_bb7: return this.toString(Scale.LOCRIAN) + " " + NameUtils.alts(-2) + "7";
            case Scale.MELODIC_MINOR: return "MELODIC MINOR";
            case Scale.DORIAN_b2: return this.toString(Scale.DORIAN) + " " + NameUtils.alts(-1) + "2";
            case Scale.LYDIAN_a5: return this.toString(Scale.LYDIAN) + " " + NameUtils.alts(1) + "5";
            case Scale.LYDIAN_b7: return this.toString(Scale.LYDIAN) + " " + NameUtils.alts(-1) + "7";
            case Scale.MIXOLYDIAN_b13: return this.toString(Scale.MIXOLYDIAN) + " " + NameUtils.alts(-1) + "13";
            case Scale.LOCRIAN_a2: return this.toString(Scale.LOCRIAN) + " " + NameUtils.alts(1) + "2";
            case Scale.SUPERLOCRIAN: return "SUPER" + this.toString(Scale.LOCRIAN);
            case Scale.DOUBLE_HARMONIC: return "DOUBLE HARMONIC";
            case Scale.LYDIAN_a2_a6: return this.toString(Scale.LYDIAN) + " " + NameUtils.alts(1) + "2" + NameUtils.alts(1) + "6";
            case Scale.ULTRAPHRYGIAN: return "ULTRA" + this.toString(Scale.PHRYGIAN);
            case Scale.HUNGARIAN_MINOR: return "HUNGARIAN MINOR";
            case Scale.ORIENTAL: return "ORIENTAL";
            case Scale.IONIAN_AUGMENTED_a2: return "IONIAN AUGMENTED " + NameUtils.alts(1) + "2";
            case Scale.LOCRIAN_bb3_bb7: return this.toString(Scale.LOCRIAN) + " " + NameUtils.alts(-2) + "3" + NameUtils.alts(-2) + "7";
            case Scale.NEAPOLITAN_MINOR: return "NAPOLITAN MINOR";
            case Scale.NEAPOLITAN_MAJOR: return "NAPOLITAN MAJOR";
            // 6
            case Scale.BLUES_b5: return "BLUES " + NameUtils.alts(-1) + "5";
            case Scale.BLUES_a4: return "BLUES " + NameUtils.alts(1) + "4";
            case Scale.WHOLE_TONE: return "WHOLE TONE";
            // 5
            case Scale.PENTATONIC_MINOR: return this.toString(Scale.PENTATONIC) + " MINOR";
            case Scale.PENTATONIC: return "PENTATONIC";
            case Scale.EGYPCIAN: return "EGYPCIAN";
            case Scale.BLUES_MINOR: return "BLUES MINOR";
            case Scale.BLUES_MAJOR: return "BLUES MAJOR";
            // 12
            case Scale.CHROMATIC: return "CHROMATIC";
            case Scale.AUGMENTED_TRIAD: return "AUGMENTED TRIAD";
            case Scale.DIMINISHED_7th: return "DIMINISHED 7th";
            case Scale.MESSIAEN_V_TRUNCATED: return "MESSIAEN V TRUNCATED";
            case Scale.DOM7b5: return "DOM7" + NameUtils.alts(-1) + "5";
            case Scale.MESSIAEN_INV_III_V_TRUNCATED_n2: return "MESSIAEN INV. III V TRUNCATED n2";
            case Scale.HALF_DIMINISHED: return "HALF DIMINISHED";
            case Scale.MESSIAEN_V: return "MESSIAEN V";
            case Scale.RAGA_INDRUPRIYA_INDIA: return "RAGA INDRUPRIYA INDIA";
            case Scale.MESSIAEN_II_TRUNCATED_n3: return "MESSIAEN II TRUNCATED n3";
            case Scale.MESSIAEN_III_INV: return "MESSIAEN III INV";
            case Scale.MESSIAEN_IV: return "MESSIAEN IV";
            case Scale.MESSIAEN_VI: return "MESSIAEN VI";
            case Scale.MESSIAEN_VII: return "MESSIAEN VII";
            case Scale.BEBOP_MAJOR: return "BEBOP MAJOR";
        }
        return this.toStringByIntervals(scale);
    }
    static getSourceScaleFrom(scale) {
        switch (scale) {
            case Scale.MAJOR: return { scale: Scale.MAJOR, mode: 1 };
            case Scale.DORIAN: return { scale: Scale.MAJOR, mode: 2 };
            case Scale.PHRYGIAN: return { scale: Scale.MAJOR, mode: 3 };
            case Scale.LYDIAN: return { scale: Scale.MAJOR, mode: 4 };
            case Scale.MIXOLYDIAN: return { scale: Scale.MAJOR, mode: 5 };
            case Scale.MINOR: return { scale: Scale.MAJOR, mode: 6 };
            case Scale.LOCRIAN: return { scale: Scale.MAJOR, mode: 7 };
            case Scale.HARMONIC_MINOR: return { scale: Scale.HARMONIC_MINOR, mode: 1 };
            case Scale.LOCRIAN_a6: return { scale: Scale.HARMONIC_MINOR, mode: 2 };
            case Scale.IONIAN_a5: return { scale: Scale.HARMONIC_MINOR, mode: 3 };
            case Scale.DORIAN_a4: return { scale: Scale.HARMONIC_MINOR, mode: 4 };
            case Scale.MIXOLYDIAN_b9_b13: return { scale: Scale.HARMONIC_MINOR, mode: 5 };
            case Scale.LYDIAN_a2: return { scale: Scale.HARMONIC_MINOR, mode: 6 };
            case Scale.SUPERLOCRIAN_bb7: return { scale: Scale.HARMONIC_MINOR, mode: 7 };
            case Scale.MELODIC_MINOR: return { scale: Scale.MELODIC_MINOR, mode: 1 };
            case Scale.DORIAN_b2: return { scale: Scale.MELODIC_MINOR, mode: 2 };
            case Scale.LYDIAN_a5: return { scale: Scale.MELODIC_MINOR, mode: 3 };
            case Scale.LYDIAN_b7: return { scale: Scale.MELODIC_MINOR, mode: 4 };
            case Scale.MIXOLYDIAN_b13: return { scale: Scale.MELODIC_MINOR, mode: 5 };
            case Scale.LOCRIAN_a2: return { scale: Scale.MELODIC_MINOR, mode: 6 };
            case Scale.SUPERLOCRIAN: return { scale: Scale.MELODIC_MINOR, mode: 7 };
            case Scale.PENTATONIC: return { scale: Scale.PENTATONIC, mode: 1 };
            case Scale.EGYPCIAN: return { scale: Scale.PENTATONIC, mode: 2 };
            case Scale.BLUES_MINOR: return { scale: Scale.PENTATONIC, mode: 3 };
            case Scale.BLUES_MAJOR: return { scale: Scale.PENTATONIC, mode: 4 };
            case Scale.PENTATONIC_MINOR: return { scale: Scale.PENTATONIC, mode: 5 };
            case Scale.HARMONIC_MAJOR: return { scale: Scale.HARMONIC_MAJOR, mode: 1 };
            case Scale.DORIAN_b5: return { scale: Scale.HARMONIC_MAJOR, mode: 2 };
            case Scale.PHRYGIAN_b4: return { scale: Scale.HARMONIC_MAJOR, mode: 3 };
            case Scale.LYDIAN_b3: return { scale: Scale.HARMONIC_MAJOR, mode: 4 };
            case Scale.MIXOLYDIAN_b2: return { scale: Scale.HARMONIC_MAJOR, mode: 5 };
            case Scale.AEOLIAN_b1: return { scale: Scale.HARMONIC_MAJOR, mode: 6 };
            case Scale.LOCRIAN_bb7: return { scale: Scale.HARMONIC_MAJOR, mode: 7 };
            case Scale.DOUBLE_HARMONIC: return { scale: Scale.DOUBLE_HARMONIC, mode: 1 };
            case Scale.LYDIAN_a2_a6: return { scale: Scale.DOUBLE_HARMONIC, mode: 2 };
            case Scale.ULTRAPHRYGIAN: return { scale: Scale.DOUBLE_HARMONIC, mode: 3 };
            case Scale.HUNGARIAN_MINOR: return { scale: Scale.DOUBLE_HARMONIC, mode: 4 };
            case Scale.ORIENTAL: return { scale: Scale.DOUBLE_HARMONIC, mode: 5 };
            case Scale.IONIAN_AUGMENTED_a2: return { scale: Scale.DOUBLE_HARMONIC, mode: 6 };
            case Scale.LOCRIAN_bb3_bb7: return { scale: Scale.DOUBLE_HARMONIC, mode: 7 };
            default:
                let allScales = Scale.all();
                if (allScales.has(scale))
                    return { scale: scale, mode: 1 };
                let clonedScale = scale.clone();
                for (let i = 2; i <= scale.length(); i++) {
                    let scaleTmp = ScaleModeUtils.getMode(scale, i);
                    if (allScales.has(scale))
                        return { scale: scale, mode: scale.length() - i };
                }
        }
        return { scale: scale, mode: 1 };
    }
    static toStringByIntervals(scale) {
        let intervals = scale.getIntervals();
        let first = true;
        let ret = "";
        intervals.forEach(i => {
            if (first)
                first = false;
            else
                ret += "-";
            ret += i;
        });
        return ret;
    }
    static calculateAbsoluteIntervals(scale) {
        let absoluteIntervals = [0];
        let relativeIntervals = Array.from(scale.getIntervals());
        relativeIntervals.pop();
        let acc = 0;
        relativeIntervals.forEach(n => {
            acc += n;
            absoluteIntervals.push(acc);
        });
        return absoluteIntervals;
    }
    static toStringAboluteIntervals(scale) {
        let absoluteIntervals = ScaleUtils.calculateAbsoluteIntervals(scale);
        let first = true;
        let ret = "";
        let i = 1;
        absoluteIntervals.forEach(n => {
            if (first)
                first = false;
            else
                ret += "-";
            let refNum = ScaleUtils.getRefNum(scale, i);
            ret += ScaleUtils.toStringAboluteInterval(refNum, n);
            i++;
        });
        return ret;
    }
    static getRefNum(scale, i) {
        switch (scale) {
            case Scale.BLUES_b5:
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        return i + 1;
                }
                break;
            case Scale.BLUES_a4:
                switch (i) {
                    case 2:
                    case 3:
                        return i + 1;
                }
                break;
            case Scale.PENTATONIC:
                switch (i) {
                    case 4:
                    case 5: return i + 1;
                }
                break;
            case Scale.EGYPCIAN:
                switch (i) {
                    case 3:
                    case 4: return i + 1;
                    case 5: return i + 2;
                }
                break;
            case Scale.BLUES_MINOR:
                switch (i) {
                    case 2:
                    case 3: return i + 1;
                    case 4:
                    case 5:
                        return i + 2;
                }
                break;
            case Scale.BLUES_MAJOR:
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                        return i + 1;
                }
                break;
            case Scale.PENTATONIC_MINOR:
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        return i + 1;
                    case 5: return i + 2;
                }
                break;
            case Scale.BEBOP_MAJOR:
                switch (i) {
                    case 7:
                    case 8:
                        return i - 1;
                }
                break;
            case Scale.AUGMENTED_TRIAD:
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                }
                break;
            case Scale.DIMINISHED_7th:
            case Scale.DOM7b5:
                switch (i) {
                    case 2: return 3;
                    case 3: return 5;
                    case 4: return 7;
                }
                break;
            default:
                if (scale.length() == 7)
                    return i;
                else if (scale.length() > 7) {
                    switch (scale.getAbsoluteIntervals()[i - 1]) {
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
    static toStringAboluteInterval(pos, intervalAbsolute) {
        return NameUtils.alts(intervalAbsolute - ScaleUtils.MAJOR_ABSOLUTE_INTERVALS[pos - 1]) + pos;
    }
    static toStringParams(scale) {
        return this.toString(scale).toUpperCase();
    }
    static getChromaticChordPattern(scale) {
        let array = [0];
        for (let n of scale.getIntervals()) {
            let newValue = array[array.length - 1] + n;
            array.push(newValue);
        }
        return ChromaticChordPattern.fromArray(array);
    }
}
ScaleUtils.MAJOR_ABSOLUTE_INTERVALS = ScaleUtils.calculateAbsoluteIntervals(Scale.MAJOR);
//# sourceMappingURL=ScaleUtils.js.map
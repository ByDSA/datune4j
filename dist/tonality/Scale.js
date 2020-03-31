import { Utils } from '../Utils';
import { ScaleModeUtils } from './ScaleModeUtils';
import { ScaleUtils } from './ScaleUtils';
export class Scale {
    constructor(...intervals) {
        this.absoluteIntervals = null;
        this.intervalsSet = new Set();
        this._totalModes = -1;
        this.intervals = intervals;
        let hash = Utils.hashArray(intervals);
        Scale.immutablesMap = Scale.immutablesMap || new Map();
        Scale.immutablesMap.set(hash, this);
    }
    static allDiatonicScales() {
        return [
            this.MAJOR,
            this.DORIAN,
            this.PHRYGIAN,
            this.LYDIAN,
            this.MIXOLYDIAN,
            this.MINOR,
            this.LOCRIAN
        ];
    }
    static allHeptatonicScales() {
        return []
            .concat(this.allDiatonicScales())
            .concat([
            this.HARMONIC_MINOR,
            this.LOCRIAN_a6,
            this.IONIAN_a5,
            this.DORIAN_a4,
            this.MIXOLYDIAN_b9_b13,
            this.LYDIAN_a2,
            this.SUPERLOCRIAN_bb7,
            this.HARMONIC_MAJOR,
            this.DORIAN_b5,
            this.PHRYGIAN_b4,
            this.LYDIAN_b3,
            this.MIXOLYDIAN_b2,
            this.AEOLIAN_b1,
            this.LOCRIAN_bb7,
            this.MELODIC_MINOR,
            this.DORIAN_b2,
            this.LYDIAN_a5,
            this.LYDIAN_b7,
            this.MIXOLYDIAN_b13,
            this.LOCRIAN_a2,
            this.SUPERLOCRIAN,
            this.DOUBLE_HARMONIC,
            this.LYDIAN_a2_a6,
            this.ULTRAPHRYGIAN,
            this.HUNGARIAN_MINOR,
            this.ORIENTAL,
            this.IONIAN_AUGMENTED_a2,
            this.LOCRIAN_bb3_bb7,
            this.NEAPOLITAN_MINOR,
            this.NEAPOLITAN_MAJOR
        ]);
    }
    static allBebopScales() {
        return [
            this.BEBOP_MAJOR
        ];
    }
    static allPentatonicScales() {
        return [
            this.PENTATONIC_MINOR,
            this.PENTATONIC,
            this.EGYPCIAN,
            this.BLUES_MINOR
        ];
    }
    static allHexatonicScales() {
        return [
            this.BLUES_b5,
            this.BLUES_a4,
            this.WHOLE_TONE
        ];
    }
    static all() {
        let ret = new Set();
        Utils.setAddArray(ret, this.allHeptatonicScales());
        Utils.setAddArray(ret, this.allPentatonicScales());
        Utils.setAddArray(ret, this.allHexatonicScales());
        Utils.setAddArray(ret, this.allBebopScales());
        Utils.setAddArray(ret, Scale.symmetricScales());
        return ret;
    }
    static symmetricScales() {
        return [
            Scale.CHROMATIC,
            Scale.WHOLE_TONE,
            Scale.AUGMENTED_TRIAD,
            Scale.DIMINISHED_7th,
            Scale.MESSIAEN_V_TRUNCATED,
            Scale.DOM7b5,
            Scale.MESSIAEN_INV_III_V_TRUNCATED_n2,
            Scale.HALF_DIMINISHED,
            Scale.MESSIAEN_V,
            Scale.RAGA_INDRUPRIYA_INDIA,
            Scale.MESSIAEN_II_TRUNCATED_n3,
            Scale.MESSIAEN_III_INV,
            Scale.MESSIAEN_IV,
            Scale.MESSIAEN_VI,
            Scale.MESSIAEN_VII
        ];
    }
    static allSourceScales() {
        return [
            this.MAJOR,
            this.HARMONIC_MINOR,
            this.HARMONIC_MAJOR,
            this.MELODIC_MINOR,
            this.DOUBLE_HARMONIC,
            this.NEAPOLITAN_MINOR,
            this.NEAPOLITAN_MAJOR,
            // 6
            this.BLUES_b5,
            this.WHOLE_TONE,
            // 5
            this.PENTATONIC_MINOR,
            // 12
            this.CHROMATIC
        ];
    }
    static from(...intervals) {
        let hash = Utils.hashArray(intervals);
        let scale = Scale.immutablesMap.get(hash);
        if (!scale)
            scale = new Scale(...intervals);
        return scale;
    }
    calculateAbsoluteIntervals() {
        this.absoluteIntervals = ScaleUtils.calculateAbsoluteIntervals(this);
        for (let absoluteInterval of this.absoluteIntervals)
            this.intervalsSet.add(absoluteInterval);
    }
    calculateAbsoluteIntervalsIfNeeded() {
        if (this.absoluteIntervals == null)
            this.calculateAbsoluteIntervals();
    }
    getIntervals() {
        return this.intervals;
    }
    get totalModes() {
        if (this._totalModes == -1) {
            let i = 1;
            let scaleTmp = this.clone();
            while (true) {
                scaleTmp = ScaleModeUtils.getRotatedScale(scaleTmp, 1);
                if (scaleTmp == this)
                    break;
                i++;
            }
            this._totalModes = i;
            console.log(this + " " + this._totalModes);
        }
        return this._totalModes;
    }
    length() {
        return this.intervals.length;
    }
    hasAbsoluteInterval(absoluteInterval) {
        this.calculateAbsoluteIntervalsIfNeeded();
        return this.intervalsSet.has(absoluteInterval);
    }
    getAbsoluteIntervals() {
        this.calculateAbsoluteIntervalsIfNeeded();
        return this.absoluteIntervals;
    }
    toString() {
        return ScaleUtils.toString(this);
    }
    clone() {
        let scale = new Scale(0);
        scale.intervals = Array.from(this.intervals);
        return scale;
    }
}
Scale.MAJOR = new Scale(2, 2, 1, 2, 2, 2, 1);
Scale.DORIAN = ScaleModeUtils.getMode(Scale.MAJOR, 2);
Scale.PHRYGIAN = ScaleModeUtils.getMode(Scale.MAJOR, 3);
Scale.LYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 4);
Scale.MIXOLYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 5);
Scale.MINOR = ScaleModeUtils.getMode(Scale.MAJOR, 6);
Scale.LOCRIAN = ScaleModeUtils.getMode(Scale.MAJOR, 7);
Scale.HARMONIC_MINOR = new Scale(2, 1, 2, 2, 1, 3, 1);
Scale.LOCRIAN_a6 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 2);
Scale.IONIAN_a5 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 3);
Scale.DORIAN_a4 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 4);
Scale.MIXOLYDIAN_b9_b13 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 5);
Scale.LYDIAN_a2 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 6);
Scale.SUPERLOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 7);
Scale.HARMONIC_MAJOR = new Scale(2, 2, 1, 2, 1, 3, 1);
Scale.DORIAN_b5 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 2);
Scale.PHRYGIAN_b4 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 3);
Scale.LYDIAN_b3 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 4);
Scale.MIXOLYDIAN_b2 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 5);
Scale.AEOLIAN_b1 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 6);
Scale.LOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 7);
Scale.MELODIC_MINOR = new Scale(2, 1, 2, 2, 2, 2, 1);
Scale.DORIAN_b2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 2);
Scale.LYDIAN_a5 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 3);
Scale.LYDIAN_b7 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 4);
Scale.MIXOLYDIAN_b13 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 5);
Scale.LOCRIAN_a2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 6);
Scale.SUPERLOCRIAN = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 7);
Scale.DOUBLE_HARMONIC = new Scale(1, 3, 1, 2, 1, 3, 1);
Scale.LYDIAN_a2_a6 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 2);
Scale.ULTRAPHRYGIAN = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 3);
Scale.HUNGARIAN_MINOR = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 4);
Scale.ORIENTAL = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 5);
Scale.IONIAN_AUGMENTED_a2 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 6);
Scale.LOCRIAN_bb3_bb7 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 7);
Scale.NEAPOLITAN_MINOR = new Scale(1, 2, 2, 2, 1, 3, 1);
Scale.NEAPOLITAN_MAJOR = new Scale(1, 2, 2, 2, 2, 2, 1);
// 6
Scale.BLUES_b5 = new Scale(3, 2, 1, 1, 3, 2);
Scale.BLUES_a4 = Scale.BLUES_b5.clone();
// 5
Scale.PENTATONIC_MINOR = new Scale(3, 2, 2, 3, 2);
Scale.PENTATONIC = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 2);
Scale.EGYPCIAN = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 3);
Scale.BLUES_MINOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 4);
Scale.BLUES_MAJOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 5);
// Symmetric
Scale.CHROMATIC = new Scale(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
Scale.WHOLE_TONE = new Scale(2, 2, 2, 2, 2, 2);
Scale.AUGMENTED_TRIAD = new Scale(4, 4, 4);
Scale.DIMINISHED_7th = new Scale(3, 3, 3, 3);
Scale.MESSIAEN_V_TRUNCATED = new Scale(1, 5, 1, 5);
Scale.DOM7b5 = new Scale(4, 2, 4, 2);
Scale.MESSIAEN_INV_III_V_TRUNCATED_n2 = new Scale(1, 3, 1, 3, 1, 3);
Scale.HALF_DIMINISHED = new Scale(1, 2, 1, 2, 1, 2, 1, 2);
Scale.MESSIAEN_V = new Scale(1, 1, 4, 1, 1, 4);
Scale.RAGA_INDRUPRIYA_INDIA = new Scale(1, 3, 2, 3, 1, 2);
Scale.MESSIAEN_II_TRUNCATED_n3 = new Scale(3, 1, 2, 3, 1, 2);
Scale.MESSIAEN_III_INV = new Scale(2, 1, 1, 2, 1, 1, 2, 1, 1);
Scale.MESSIAEN_IV = new Scale(1, 1, 1, 3, 1, 1, 1, 3);
Scale.MESSIAEN_VI = new Scale(1, 1, 2, 2, 1, 1, 2, 2);
Scale.MESSIAEN_VII = new Scale(1, 1, 1, 1, 2, 1, 1, 1, 1, 2);
// Bebop
Scale.BEBOP_MAJOR = new Scale(2, 2, 1, 2, 1, 1, 2, 1);
//# sourceMappingURL=Scale.js.map
import { Utils } from '../Utils';
import { ScaleModeUtils } from './ScaleModeUtils';
import { ScaleUtils } from './ScaleUtils';

export class Scale {
    public static MAJOR = new Scale(2, 2, 1, 2, 2, 2, 1);
    public static DORIAN = ScaleModeUtils.getMode(Scale.MAJOR, 2);
    public static PHRYGIAN = ScaleModeUtils.getMode(Scale.MAJOR, 3);
    public static LYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 4);
    public static MIXOLYDIAN = ScaleModeUtils.getMode(Scale.MAJOR, 5);
    public static MINOR = ScaleModeUtils.getMode(Scale.MAJOR, 6);
    public static LOCRIAN = ScaleModeUtils.getMode(Scale.MAJOR, 7);

    public static HARMONIC_MINOR = new Scale(2, 1, 2, 2, 1, 3, 1);
    public static LOCRIAN_a6 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 2);
    public static IONIAN_a5 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 3);
    public static DORIAN_a4 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 4);
    public static MIXOLYDIAN_b9_b13 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 5);
    public static LYDIAN_a2 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 6);
    public static SUPERLOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MINOR, 7);

    public static HARMONIC_MAJOR = new Scale(2, 2, 1, 2, 1, 3, 1);
    public static DORIAN_b5 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 2);
    public static PHRYGIAN_b4 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 3);
    public static LYDIAN_b3 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 4);
    public static MIXOLYDIAN_b2 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 5);
    public static AEOLIAN_b1 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 6);
    public static LOCRIAN_bb7 = ScaleModeUtils.getMode(Scale.HARMONIC_MAJOR, 7);

    public static MELODIC_MINOR = new Scale(2, 1, 2, 2, 2, 2, 1);
    public static DORIAN_b2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 2);
    public static LYDIAN_a5 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 3);
    public static LYDIAN_b7 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 4);
    public static MIXOLYDIAN_b13 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 5);
    public static LOCRIAN_a2 = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 6);
    public static SUPERLOCRIAN = ScaleModeUtils.getMode(Scale.MELODIC_MINOR, 7);

    public static DOUBLE_HARMONIC = new Scale(1, 3, 1, 2, 1, 3, 1);
    public static LYDIAN_a2_a6 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 2);
    public static ULTRAPHRYGIAN = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 3);
    public static HUNGARIAN_MINOR = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 4);
    public static ORIENTAL = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 5);
    public static IONIAN_AUGMENTED_a2 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 6);
    public static LOCRIAN_bb3_bb7 = ScaleModeUtils.getMode(Scale.DOUBLE_HARMONIC, 7);

    public static NEAPOLITAN_MINOR = new Scale(1, 2, 2, 2, 1, 3, 1);
    public static NEAPOLITAN_MAJOR = new Scale(1, 2, 2, 2, 2, 2, 1);

    // 6
    public static BLUES_b5 = new Scale(3, 2, 1, 1, 3, 2);
    public static BLUES_a4 = Scale.BLUES_b5.clone();

    // 5
    public static PENTATONIC_MINOR = new Scale(3, 2, 2, 3, 2);
    public static PENTATONIC = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 2);
    public static EGYPCIAN = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 3);
    public static BLUES_MINOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 4);
    public static BLUES_MAJOR = ScaleModeUtils.getMode(Scale.PENTATONIC_MINOR, 5);

    // Symmetric
    public static CHROMATIC = new Scale(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    public static WHOLE_TONE = new Scale(2, 2, 2, 2, 2, 2);
    public static AUGMENTED_TRIAD = new Scale(4, 4, 4);
    public static DIMINISHED_7th = new Scale(3, 3, 3, 3);
    public static MESSIAEN_V_TRUNCATED = new Scale(1, 5, 1, 5);
    public static DOM7b5 = new Scale(4, 2, 4, 2);
    public static MESSIAEN_INV_III_V_TRUNCATED_n2 = new Scale(1, 3, 1, 3, 1, 3);
    public static HALF_DIMINISHED = new Scale(1, 2, 1, 2, 1, 2, 1, 2);
    public static MESSIAEN_V = new Scale(1, 1, 4, 1, 1, 4);
    public static RAGA_INDRUPRIYA_INDIA = new Scale(1, 3, 2, 3, 1, 2);
    public static MESSIAEN_II_TRUNCATED_n3 = new Scale(3, 1, 2, 3, 1, 2);
    public static MESSIAEN_III_INV = new Scale(2, 1, 1, 2, 1, 1, 2, 1, 1);
    public static MESSIAEN_IV = new Scale(1, 1, 1, 3, 1, 1, 1, 3);
    public static MESSIAEN_VI = new Scale(1, 1, 2, 2, 1, 1, 2, 2);
    public static MESSIAEN_VII = new Scale(1, 1, 1, 1, 2, 1, 1, 1, 1, 2);

    // Bebop
    public static BEBOP_MAJOR = new Scale(2, 2, 1, 2, 1, 1, 2, 1);


    public static get allDiatonicScales(): Scale[] {
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

    public static get allHeptatonicScales(): Scale[] {
        return []
            .concat(this.allDiatonicScales)
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

    public static get allBebopScales() {
        return [
            this.BEBOP_MAJOR
        ];
    }

    public static get allPentatonicScales() {
        return [
            this.PENTATONIC_MINOR,
            this.PENTATONIC,
            this.EGYPCIAN,
            this.BLUES_MINOR
        ];
    }

    public static get allHexatonicScales() {
        return [
            this.BLUES_b5,
            this.BLUES_a4,
            this.WHOLE_TONE
        ];
    }

    public static get all(): Set<Scale> {
        let ret: Set<Scale> = new Set<Scale>();
        Utils.setAddArray(ret, this.allHeptatonicScales);
        Utils.setAddArray(ret, this.allPentatonicScales);
        Utils.setAddArray(ret, this.allHexatonicScales);
        Utils.setAddArray(ret, this.allBebopScales);
        Utils.setAddArray(ret, Scale.symmetricScales);

        return ret;
    }

    public static get symmetricScales(): Scale[] {
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

    private intervals: number[];
    private absoluteIntervals: number[] = null;
    private intervalsSet = new Set<number>();
    private static immutablesMap;

    private constructor(...intervals: number[]) {
        this.intervals = intervals;
        let hash = Utils.hashArray(intervals);

        Scale.immutablesMap = Scale.immutablesMap || new Map<string, Scale>();
        Scale.immutablesMap.set(hash, this);
    }

    public static from(...intervals: number[]): Scale {
        let hash = Utils.hashArray(intervals);
        let scale = Scale.immutablesMap.get(hash);
        if (!scale)
            scale = new Scale(...intervals);

        return scale;
    }

    private calculateAbsoluteIntervals() {
        this.absoluteIntervals = ScaleUtils.calculateAbsoluteIntervals(this);
        for (let absoluteInterval of this.absoluteIntervals)
            this.intervalsSet.add(absoluteInterval);
    }

    private calculateAbsoluteIntervalsIfNeeded() {
        if (this.absoluteIntervals == null)
            this.calculateAbsoluteIntervals();
    }

    public getIntervals(): number[] {
        return this.intervals;
    }

    private _modes = null;

    public get modes(): Scale[] {
        if (this._modes == null) {
            let scaleTmp: Scale = this;
            this._modes = [this];
            while (true) {
                scaleTmp = ScaleModeUtils.getRotatedScale(scaleTmp, 1);
                if (scaleTmp == this)
                    break;
            }
        }
        return this._modes;
    }

    public get length(): number {
        return this.intervals.length;
    }

    public hasAbsoluteInterval(absoluteInterval: number): boolean {
        this.calculateAbsoluteIntervalsIfNeeded();
        return this.intervalsSet.has(absoluteInterval);
    }

    public getAbsoluteIntervals() {
        this.calculateAbsoluteIntervalsIfNeeded();
        return this.absoluteIntervals;
    }

    public toString(): string {
        return ScaleUtils.toString(this);
    }

    public clone(): Scale {
        let scale = new Scale(0);
        scale.intervals = Array.from(this.intervals);
        return scale;
    }
}
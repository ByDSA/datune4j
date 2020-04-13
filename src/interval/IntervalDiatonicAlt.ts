import { Diatonic } from '../degrees/Diatonic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Quality } from '../Quality';
import { Assert } from '../Utils/Assert';
import { IntervalDiatonic } from './IntervalDiatonic';

export class IntervalDiatonicAlt {
    // precalc

    public static PERFECT_UNISON;
    public static DIMINISHED_SECOND;
    public static MINOR_SECOND;
    public static AUGMENTED_UNISON;
    public static MAJOR_SECOND;
    public static DIMINISHED_THIRD;
    public static MINOR_THIRD;
    public static AUGMENTED_SECOND;
    public static MAJOR_THIRD;
    public static DIMINISHED_FOURTH;
    public static PERFECT_FOURTH;
    public static AUGMENTED_THIRD;
    public static DIMINISHED_FIFTH;
    public static AUGMENTED_FOURTH;
    public static PERFECT_FIFTH;
    public static DIMINISHED_SIXTH;
    public static MINOR_SIXTH;
    public static AUGMENTED_FIFTH;
    public static MAJOR_SIXTH;
    public static DIMINISHED_SEVENTH;
    public static MINOR_SEVENTH;
    public static AUGMENTED_SIXTH;
    public static MAJOR_SEVENTH;
    public static DIMINISHED_OCTAVE;
    public static PERFECT_OCTAVE;
    public static AUGMENTED_SEVENTH;
    public static DIMINISHED_NINTH;
    public static MINOR_NINTH;
    public static AUGMENTED_OCTAVE;
    public static MAJOR_NINTH;
    public static DIMINISHED_TENTH;
    public static MINOR_TENTH;
    public static AUGMENTED_NINTH;
    public static MAJOR_TENTH;
    public static DIMINISHED_ELEVENTH;
    public static PERFECT_ELEVENTH;
    public static AUGMENTED_TENTH;
    public static DIMINISHED_TWELFTH;
    public static AUGMENTED_ELEVENTH;
    public static PERFECT_TWELFTH;
    public static DIMINISHED_THIRTEENTH;
    public static MINOR_THIRTEENTH;
    public static AUGMENTED_TWELFTH;
    public static MAJOR_THIRTEENTH;
    public static DIMINISHED_FOURTEENTH;
    public static MINOR_FOURTEENTH;
    public static AUGMENTED_THIRTEENTH;
    public static MAJOR_FOURTEENTH;
    public static DIMINISHED_FIFTEENTH;
    public static PERFECT_FIFTEENTH;
    public static AUGMENTED_FOURTEENTH;
    public static AUGMENTED_FIFTEENTH;

    private constructor(private _semitones: number, private _intervalDiatonic, private quality: Quality) {
    }

    private static _from(semitones: number, intervalDiatonic: IntervalDiatonic, quality: Quality): IntervalDiatonicAlt {
        return new IntervalDiatonicAlt(semitones, intervalDiatonic, quality);
    }

    public static between(diatonicAlt1: DiatonicAlt, diatonicAlt2: DiatonicAlt) {
        let intervalDiatonic = diatonicAlt2.diatonic.intValue - diatonicAlt1.diatonic.intValue;
        if (intervalDiatonic < 0) {
            intervalDiatonic = (intervalDiatonic % Diatonic.NUMBER) + Diatonic.NUMBER;
        }

        let semis = diatonicAlt2.chromatic.intValue - diatonicAlt1.chromatic.intValue;

        return this.from(semis, intervalDiatonic);
    }

    public static from(semitones: number, intervalDiatonic: IntervalDiatonic): IntervalDiatonicAlt {
        Assert.notNull(semitones);
        Assert.notNull(intervalDiatonic);

        switch (intervalDiatonic) {
            case IntervalDiatonic.UNISON:
                switch (semitones) {
                    case 0:
                        return IntervalDiatonicAlt.PERFECT_UNISON;
                    case 1:
                        return IntervalDiatonicAlt.AUGMENTED_UNISON;
                }
                break;
            case IntervalDiatonic.SECOND:
                switch (semitones) {
                    case 0:
                        return IntervalDiatonicAlt.DIMINISHED_SECOND;
                    case 1:
                        return IntervalDiatonicAlt.MINOR_SECOND;
                    case 2:
                        return IntervalDiatonicAlt.MAJOR_SECOND;
                    case 3:
                        return IntervalDiatonicAlt.AUGMENTED_SECOND;
                }
                break;
            case IntervalDiatonic.THIRD:
                switch (semitones) {
                    case 2:
                        return IntervalDiatonicAlt.DIMINISHED_THIRD;
                    case 3:
                        return IntervalDiatonicAlt.MINOR_THIRD;
                    case 4:
                        return IntervalDiatonicAlt.MAJOR_THIRD;
                    case 5:
                        return IntervalDiatonicAlt.AUGMENTED_THIRD;
                }
                break;
            case IntervalDiatonic.FOURTH:
                switch (semitones) {
                    case 4:
                        return IntervalDiatonicAlt.DIMINISHED_FOURTH;
                    case 5:
                        return IntervalDiatonicAlt.PERFECT_FOURTH;
                    case 6:
                        return IntervalDiatonicAlt.AUGMENTED_FOURTH;
                }
                break;
            case IntervalDiatonic.FIFTH:
                switch (semitones) {
                    case 6:
                        return IntervalDiatonicAlt.DIMINISHED_FIFTH;
                    case 7:
                        return IntervalDiatonicAlt.PERFECT_FIFTH;
                    case 8:
                        return IntervalDiatonicAlt.AUGMENTED_FIFTH;
                }
                break;
            case IntervalDiatonic.SIXTH:
                switch (semitones) {
                    case 7:
                        return IntervalDiatonicAlt.DIMINISHED_SIXTH;
                    case 8:
                        return IntervalDiatonicAlt.MINOR_SIXTH;
                    case 9:
                        return IntervalDiatonicAlt.MAJOR_SIXTH;
                    case 10:
                        return IntervalDiatonicAlt.AUGMENTED_SIXTH;
                }
                break;
            case IntervalDiatonic.SEVENTH:
                switch (semitones) {
                    case 9:
                        return IntervalDiatonicAlt.DIMINISHED_SEVENTH;
                    case 10:
                        return IntervalDiatonicAlt.MINOR_SEVENTH;
                    case 11:
                        return IntervalDiatonicAlt.MAJOR_SEVENTH;
                    case 12:
                        return IntervalDiatonicAlt.AUGMENTED_SEVENTH;
                }
                break;
            case IntervalDiatonic.OCTAVE:
                switch (semitones) {
                    case 11:
                        return IntervalDiatonicAlt.DIMINISHED_OCTAVE;
                    case 12:
                        return IntervalDiatonicAlt.PERFECT_OCTAVE;
                    case 13:
                        return IntervalDiatonicAlt.AUGMENTED_OCTAVE;
                }
                break;
            case IntervalDiatonic.NINTH:
                switch (semitones) {
                    case 12:
                        return IntervalDiatonicAlt.DIMINISHED_NINTH;
                    case 13:
                        return IntervalDiatonicAlt.MINOR_NINTH;
                    case 14:
                        return IntervalDiatonicAlt.MAJOR_NINTH;
                    case 15:
                        return IntervalDiatonicAlt.AUGMENTED_NINTH;
                }
                break;
            case IntervalDiatonic.TENTH:
                switch (semitones) {
                    case 14:
                        return IntervalDiatonicAlt.DIMINISHED_TENTH;
                    case 15:
                        return IntervalDiatonicAlt.MINOR_TENTH;
                    case 16:
                        return IntervalDiatonicAlt.MAJOR_TENTH;
                    case 17:
                        return IntervalDiatonicAlt.AUGMENTED_TENTH;
                }
                break;
            case IntervalDiatonic.ELEVENTH:
                switch (semitones) {
                    case 16:
                        return IntervalDiatonicAlt.DIMINISHED_ELEVENTH;
                    case 17:
                        return IntervalDiatonicAlt.PERFECT_ELEVENTH;
                    case 18:
                        return IntervalDiatonicAlt.AUGMENTED_ELEVENTH;
                }
                break;
            case IntervalDiatonic.TWELFTH:
                switch (semitones) {
                    case 18:
                        return IntervalDiatonicAlt.DIMINISHED_TWELFTH;
                    case 19:
                        return IntervalDiatonicAlt.PERFECT_TWELFTH;
                    case 20:
                        return IntervalDiatonicAlt.AUGMENTED_TWELFTH;
                }
                break;
            case IntervalDiatonic.THIRTEENTH:
                switch (semitones) {
                    case 19:
                        return IntervalDiatonicAlt.DIMINISHED_THIRTEENTH;
                    case 20:
                        return IntervalDiatonicAlt.MINOR_THIRTEENTH;
                    case 21:
                        return IntervalDiatonicAlt.MAJOR_THIRTEENTH;
                    case 22:
                        return IntervalDiatonicAlt.AUGMENTED_THIRTEENTH;
                }
                break;
            case IntervalDiatonic.FOURTEENTH:
                switch (semitones) {
                    case 21:
                        return IntervalDiatonicAlt.DIMINISHED_FOURTEENTH;
                    case 22:
                        return IntervalDiatonicAlt.MINOR_FOURTEENTH;
                    case 23:
                        return IntervalDiatonicAlt.MAJOR_FOURTEENTH;
                    case 24:
                        return IntervalDiatonicAlt.AUGMENTED_FOURTEENTH;
                }
                break;
            case IntervalDiatonic.FIFTEENTH:
                switch (semitones) {
                    case 23:
                        return IntervalDiatonicAlt.DIMINISHED_FIFTEENTH;
                    case 24:
                        return IntervalDiatonicAlt.PERFECT_FIFTEENTH;
                    case 25:
                        return IntervalDiatonicAlt.AUGMENTED_FIFTEENTH;
                }
                break;
            default: throw new Error("Invalid IntervalDiatonic: " + intervalDiatonic);
        }

        throw new Error();
    }

    get semis() {
        return this._semitones;
    }

    get intervalDiatonic() {
        return this._intervalDiatonic;
    }

    private static initialize() {
        this.PERFECT_UNISON = IntervalDiatonicAlt._from(0, IntervalDiatonic.UNISON, Quality.PERFECT);
        this.DIMINISHED_SECOND = IntervalDiatonicAlt._from(0, IntervalDiatonic.SECOND, Quality.DIMINISHED);
        this.MINOR_SECOND = IntervalDiatonicAlt._from(1, IntervalDiatonic.SECOND, Quality.MINOR);
        this.AUGMENTED_UNISON = IntervalDiatonicAlt._from(1, IntervalDiatonic.UNISON, Quality.AUGMENTED);
        this.MAJOR_SECOND = IntervalDiatonicAlt._from(2, IntervalDiatonic.SECOND, Quality.MAJOR);
        this.DIMINISHED_THIRD = IntervalDiatonicAlt._from(2, IntervalDiatonic.THIRD, Quality.DIMINISHED);
        this.MINOR_THIRD = IntervalDiatonicAlt._from(3, IntervalDiatonic.THIRD, Quality.MINOR);
        this.AUGMENTED_SECOND = IntervalDiatonicAlt._from(3, IntervalDiatonic.SECOND, Quality.AUGMENTED);
        this.MAJOR_THIRD = IntervalDiatonicAlt._from(4, IntervalDiatonic.THIRD, Quality.MAJOR);
        this.DIMINISHED_FOURTH = IntervalDiatonicAlt._from(4, IntervalDiatonic.FOURTH, Quality.DIMINISHED);
        this.PERFECT_FOURTH = IntervalDiatonicAlt._from(5, IntervalDiatonic.FOURTH, Quality.PERFECT);
        this.AUGMENTED_THIRD = IntervalDiatonicAlt._from(5, IntervalDiatonic.THIRD, Quality.AUGMENTED);
        this.DIMINISHED_FIFTH = IntervalDiatonicAlt._from(6, IntervalDiatonic.FIFTH, Quality.DIMINISHED);
        this.AUGMENTED_FOURTH = IntervalDiatonicAlt._from(6, IntervalDiatonic.FOURTH, Quality.AUGMENTED);
        this.PERFECT_FIFTH = IntervalDiatonicAlt._from(7, IntervalDiatonic.FIFTH, Quality.PERFECT);
        this.DIMINISHED_SIXTH = IntervalDiatonicAlt._from(7, IntervalDiatonic.SIXTH, Quality.DIMINISHED);
        this.MINOR_SIXTH = IntervalDiatonicAlt._from(8, IntervalDiatonic.SIXTH, Quality.MINOR);
        this.AUGMENTED_FIFTH = IntervalDiatonicAlt._from(8, IntervalDiatonic.FIFTH, Quality.AUGMENTED);
        this.MAJOR_SIXTH = IntervalDiatonicAlt._from(9, IntervalDiatonic.SIXTH, Quality.MAJOR);
        this.DIMINISHED_SEVENTH = IntervalDiatonicAlt._from(9, IntervalDiatonic.SEVENTH, Quality.DIMINISHED);
        this.MINOR_SEVENTH = IntervalDiatonicAlt._from(10, IntervalDiatonic.SEVENTH, Quality.MINOR);
        this.AUGMENTED_SIXTH = IntervalDiatonicAlt._from(10, IntervalDiatonic.SIXTH, Quality.AUGMENTED);
        this.MAJOR_SEVENTH = IntervalDiatonicAlt._from(11, IntervalDiatonic.SEVENTH, Quality.MAJOR);
        this.DIMINISHED_OCTAVE = IntervalDiatonicAlt._from(11, IntervalDiatonic.OCTAVE, Quality.DIMINISHED);
        this.PERFECT_OCTAVE = IntervalDiatonicAlt._from(12, IntervalDiatonic.OCTAVE, Quality.PERFECT);
        this.AUGMENTED_SEVENTH = IntervalDiatonicAlt._from(12, IntervalDiatonic.SEVENTH, Quality.AUGMENTED);
        this.DIMINISHED_NINTH = IntervalDiatonicAlt._from(12, IntervalDiatonic.NINTH, Quality.DIMINISHED);
        this.MINOR_NINTH = IntervalDiatonicAlt._from(13, IntervalDiatonic.NINTH, Quality.MINOR);
        this.AUGMENTED_OCTAVE = IntervalDiatonicAlt._from(13, IntervalDiatonic.OCTAVE, Quality.AUGMENTED);
        this.MAJOR_NINTH = IntervalDiatonicAlt._from(14, IntervalDiatonic.NINTH, Quality.MAJOR);
        this.DIMINISHED_TENTH = IntervalDiatonicAlt._from(14, IntervalDiatonic.TENTH, Quality.DIMINISHED);
        this.MINOR_TENTH = IntervalDiatonicAlt._from(15, IntervalDiatonic.NINTH, Quality.MINOR);
        this.AUGMENTED_NINTH = IntervalDiatonicAlt._from(15, IntervalDiatonic.NINTH, Quality.AUGMENTED);
        this.MAJOR_TENTH = IntervalDiatonicAlt._from(16, IntervalDiatonic.TENTH, Quality.MAJOR);
        this.DIMINISHED_ELEVENTH = IntervalDiatonicAlt._from(16, IntervalDiatonic.ELEVENTH, Quality.DIMINISHED);
        this.PERFECT_ELEVENTH = IntervalDiatonicAlt._from(17, IntervalDiatonic.ELEVENTH, Quality.MINOR);
        this.AUGMENTED_TENTH = IntervalDiatonicAlt._from(17, IntervalDiatonic.TENTH, Quality.AUGMENTED);
        this.DIMINISHED_TWELFTH = IntervalDiatonicAlt._from(18, IntervalDiatonic.TWELFTH, Quality.DIMINISHED);
        this.AUGMENTED_ELEVENTH = IntervalDiatonicAlt._from(18, IntervalDiatonic.ELEVENTH, Quality.AUGMENTED);
        this.PERFECT_TWELFTH = IntervalDiatonicAlt._from(19, IntervalDiatonic.TWELFTH, Quality.PERFECT);
        this.DIMINISHED_THIRTEENTH = IntervalDiatonicAlt._from(19, IntervalDiatonic.THIRTEENTH, Quality.DIMINISHED);
        this.MINOR_THIRTEENTH = IntervalDiatonicAlt._from(20, IntervalDiatonic.THIRTEENTH, Quality.MINOR);
        this.AUGMENTED_TWELFTH = IntervalDiatonicAlt._from(20, IntervalDiatonic.TWELFTH, Quality.AUGMENTED);
        this.MAJOR_THIRTEENTH = IntervalDiatonicAlt._from(21, IntervalDiatonic.THIRTEENTH, Quality.MAJOR);
        this.DIMINISHED_FOURTEENTH = IntervalDiatonicAlt._from(21, IntervalDiatonic.FOURTEENTH, Quality.DIMINISHED);
        this.MINOR_FOURTEENTH = IntervalDiatonicAlt._from(22, IntervalDiatonic.FOURTEENTH, Quality.MINOR);
        this.AUGMENTED_THIRTEENTH = IntervalDiatonicAlt._from(22, IntervalDiatonic.THIRTEENTH, Quality.AUGMENTED);
        this.MAJOR_FOURTEENTH = IntervalDiatonicAlt._from(23, IntervalDiatonic.FOURTEENTH, Quality.MAJOR);
        this.DIMINISHED_FIFTEENTH = IntervalDiatonicAlt._from(23, IntervalDiatonic.FIFTEENTH, Quality.DIMINISHED);
        this.PERFECT_FIFTEENTH = IntervalDiatonicAlt._from(24, IntervalDiatonic.FIFTEENTH, Quality.PERFECT);
        this.AUGMENTED_FOURTEENTH = IntervalDiatonicAlt._from(24, IntervalDiatonic.FOURTEENTH, Quality.AUGMENTED);
        this.AUGMENTED_FIFTEENTH = IntervalDiatonicAlt._from(25, IntervalDiatonic.FIFTEENTH, Quality.AUGMENTED);
    }
}
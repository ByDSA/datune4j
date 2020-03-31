import { Quality } from '../Quality';
import { IntervalDiatonic } from './IntervalDiatonic';
import { Utils } from '../Utils';

export class IntervalChromatic {
    public static PERFECT_UNISON = IntervalChromatic.from(0, Quality.PERFECT);
    public static DIMINISHED_SECOND = IntervalChromatic.from(0, Quality.DIMINISHED);
    public static MINOR_SECOND = IntervalChromatic.from(1, Quality.MINOR);
    public static AUGMENTED_UNISON = IntervalChromatic.from(1, Quality.AUGMENTED);
    public static MAJOR_SECOND = IntervalChromatic.from(2, Quality.MAJOR);
    public static DIMINISHED_THIRD = IntervalChromatic.from(2, Quality.DIMINISHED);
    public static MINOR_THIRD = IntervalChromatic.from(3, Quality.MINOR);
    public static AUGMENTED_SECOND = IntervalChromatic.from(3, Quality.AUGMENTED);
    public static MAJOR_THIRD = IntervalChromatic.from(4, Quality.MAJOR);
    public static DIMINISHED_FOURTH = IntervalChromatic.from(4, Quality.DIMINISHED);
    public static PERFECT_FOURTH = IntervalChromatic.from(5, Quality.PERFECT);
    public static AUGMENTED_THIRD = IntervalChromatic.from(5, Quality.AUGMENTED);
    public static DIMINISHED_FIFTH = IntervalChromatic.from(6, Quality.DIMINISHED);
    public static AUGMENTED_FOURTH = IntervalChromatic.from(6, Quality.AUGMENTED);
    public static PERFECT_FIFTH = IntervalChromatic.from(7, Quality.PERFECT);
    public static DIMINISHED_SIXTH = IntervalChromatic.from(7, Quality.DIMINISHED);
    public static MINOR_SIXTH = IntervalChromatic.from(8, Quality.MINOR);
    public static AUGMENTED_FIFTH = IntervalChromatic.from(8, Quality.AUGMENTED);
    public static MAJOR_SIXTH = IntervalChromatic.from(9, Quality.MAJOR);
    public static DIMINISHED_SEVENTH = IntervalChromatic.from(9, Quality.DIMINISHED);
    public static MINOR_SEVENTH = IntervalChromatic.from(10, Quality.MINOR);
    public static AUGMENTED_SIXTH = IntervalChromatic.from(10, Quality.AUGMENTED);
    public static MAJOR_SEVENTH = IntervalChromatic.from(11, Quality.MAJOR);
    public static DIMINISHED_OCTAVE = IntervalChromatic.from(11, Quality.DIMINISHED);
    public static PERFECT_OCTAVE = IntervalChromatic.from(12, Quality.PERFECT);
    public static AUGMENTED_SEVENTH = IntervalChromatic.from(12, Quality.AUGMENTED);
    public static DIMINISHED_NINTH = IntervalChromatic.from(12, Quality.DIMINISHED);
    public static MINOR_NINTH = IntervalChromatic.from(13, Quality.MINOR);
    public static AUGMENTED_OCTAVE = IntervalChromatic.from(13, Quality.AUGMENTED);
    public static MAJOR_NINTH = IntervalChromatic.from(14, Quality.MAJOR);
    public static DIMINISHED_TENTH = IntervalChromatic.from(14, Quality.DIMINISHED);
    public static MINOR_TENTH = IntervalChromatic.from(15, Quality.MINOR);
    public static AUGMENTED_NINTH = IntervalChromatic.from(15, Quality.AUGMENTED);
    public static MAJOR_TENTH = IntervalChromatic.from(16, Quality.MAJOR);
    public static DIMINISHED_ELEVENTH = IntervalChromatic.from(16, Quality.DIMINISHED);
    public static PERFECT_ELEVENTH = IntervalChromatic.from(17, Quality.MINOR);
    public static AUGMENTED_TENTH = IntervalChromatic.from(17, Quality.AUGMENTED);
    public static DIMINISHED_TWELFTH = IntervalChromatic.from(18, Quality.DIMINISHED);
    public static AUGMENTED_ELEVENTH = IntervalChromatic.from(18, Quality.AUGMENTED);
    public static PERFECT_TWELFTH = IntervalChromatic.from(19, Quality.PERFECT);
    public static DIMINISHED_THIRTEENTH = IntervalChromatic.from(19, Quality.DIMINISHED);
    public static MINOR_THIRTEENTH = IntervalChromatic.from(20, Quality.MINOR);
    public static AUGMENTED_TWELFTH = IntervalChromatic.from(20, Quality.AUGMENTED);
    public static MAJOR_THIRTEENTH = IntervalChromatic.from(21, Quality.MAJOR);
    public static DIMINISHED_FOURTEENTH = IntervalChromatic.from(21, Quality.DIMINISHED);
    public static MINOR_FOURTEENTH = IntervalChromatic.from(22, Quality.MINOR);
    public static AUGMENTED_THIRTEENTH = IntervalChromatic.from(22, Quality.AUGMENTED);
    public static MAJOR_FOURTEENTH = IntervalChromatic.from(23, Quality.MAJOR);
    public static DIMINISHED_FIFTEENTH = IntervalChromatic.from(23, Quality.DIMINISHED);
    public static PERFECT_FIFTEENTH = IntervalChromatic.from(24, Quality.PERFECT);
    public static AUGMENTED_FOURTEENTH = IntervalChromatic.from(24, Quality.AUGMENTED);
    public static AUGMENTED_FIFTEENTH = IntervalChromatic.from(25, Quality.AUGMENTED);

    private constructor(private semitones: number, private quality: Quality) {
    }

    public static from(semitones: number, quality: Quality): IntervalChromatic {
        return new IntervalChromatic(semitones, quality);
    }

    public static fromSemisAndNotes(semitones: number, intervalDiatonic: IntervalDiatonic): IntervalChromatic {
        Utils.assertNotNull(semitones);
        Utils.assertNotNull(intervalDiatonic);

        switch (intervalDiatonic) {
            case IntervalDiatonic.UNISON:
                switch (semitones) {
                    case 0:
                        return IntervalChromatic.PERFECT_UNISON;
                    case 1:
                        return IntervalChromatic.AUGMENTED_UNISON;
                }
                break;
            case IntervalDiatonic.SECOND:
                switch (semitones) {
                    case 0:
                        return IntervalChromatic.DIMINISHED_SECOND;
                    case 1:
                        return IntervalChromatic.MINOR_SECOND;
                    case 2:
                        return IntervalChromatic.MAJOR_SECOND;
                    case 3:
                        return IntervalChromatic.AUGMENTED_SECOND;
                }
                break;
            case IntervalDiatonic.THIRD:
                switch (semitones) {
                    case 2:
                        return IntervalChromatic.DIMINISHED_THIRD;
                    case 3:
                        return IntervalChromatic.MINOR_THIRD;
                    case 4:
                        return IntervalChromatic.MAJOR_THIRD;
                    case 5:
                        return IntervalChromatic.AUGMENTED_THIRD;
                }
                break;
            case IntervalDiatonic.FOURTH:
                switch (semitones) {
                    case 4:
                        return IntervalChromatic.DIMINISHED_FOURTH;
                    case 5:
                        return IntervalChromatic.PERFECT_FOURTH;
                    case 6:
                        return IntervalChromatic.AUGMENTED_FOURTH;
                }
                break;
            case IntervalDiatonic.FIFTH:
                switch (semitones) {
                    case 6:
                        return IntervalChromatic.DIMINISHED_FIFTH;
                    case 7:
                        return IntervalChromatic.PERFECT_FIFTH;
                    case 8:
                        return IntervalChromatic.AUGMENTED_FIFTH;
                }
                break;
            case IntervalDiatonic.SIXTH:
                switch (semitones) {
                    case 7:
                        return IntervalChromatic.DIMINISHED_SIXTH;
                    case 8:
                        return IntervalChromatic.MINOR_SIXTH;
                    case 9:
                        return IntervalChromatic.MAJOR_SIXTH;
                    case 10:
                        return IntervalChromatic.AUGMENTED_SIXTH;
                }
                break;
            case IntervalDiatonic.SEVENTH:
                switch (semitones) {
                    case 9:
                        return IntervalChromatic.DIMINISHED_SEVENTH;
                    case 10:
                        return IntervalChromatic.MINOR_SEVENTH;
                    case 11:
                        return IntervalChromatic.MAJOR_SEVENTH;
                    case 12:
                        return IntervalChromatic.AUGMENTED_SEVENTH;
                }
                break;
            case IntervalDiatonic.OCTAVE:
                switch (semitones) {
                    case 11:
                        return IntervalChromatic.DIMINISHED_OCTAVE;
                    case 12:
                        return IntervalChromatic.PERFECT_OCTAVE;
                    case 13:
                        return IntervalChromatic.AUGMENTED_OCTAVE;
                }
                break;
            case IntervalDiatonic.NINTH:
                switch (semitones) {
                    case 12:
                        return IntervalChromatic.DIMINISHED_NINTH;
                    case 13:
                        return IntervalChromatic.MINOR_NINTH;
                    case 14:
                        return IntervalChromatic.MAJOR_NINTH;
                    case 15:
                        return IntervalChromatic.AUGMENTED_NINTH;
                }
                break;
            case IntervalDiatonic.TENTH:
                switch (semitones) {
                    case 14:
                        return IntervalChromatic.DIMINISHED_TENTH;
                    case 15:
                        return IntervalChromatic.MINOR_TENTH;
                    case 16:
                        return IntervalChromatic.MAJOR_TENTH;
                    case 17:
                        return IntervalChromatic.AUGMENTED_TENTH;
                }
                break;
            case IntervalDiatonic.ELEVENTH:
                switch (semitones) {
                    case 16:
                        return IntervalChromatic.DIMINISHED_ELEVENTH;
                    case 17:
                        return IntervalChromatic.PERFECT_ELEVENTH;
                    case 18:
                        return IntervalChromatic.AUGMENTED_ELEVENTH;
                }
                break;
            case IntervalDiatonic.TWELFTH:
                switch (semitones) {
                    case 18:
                        return IntervalChromatic.DIMINISHED_TWELFTH;
                    case 19:
                        return IntervalChromatic.PERFECT_TWELFTH;
                    case 20:
                        return IntervalChromatic.AUGMENTED_TWELFTH;
                }
                break;
            case IntervalDiatonic.THIRTEENTH:
                switch (semitones) {
                    case 19:
                        return IntervalChromatic.DIMINISHED_THIRTEENTH;
                    case 20:
                        return IntervalChromatic.MINOR_THIRTEENTH;
                    case 21:
                        return IntervalChromatic.MAJOR_THIRTEENTH;
                    case 22:
                        return IntervalChromatic.AUGMENTED_THIRTEENTH;
                }
                break;
            case IntervalDiatonic.FOURTEENTH:
                switch (semitones) {
                    case 21:
                        return IntervalChromatic.DIMINISHED_FOURTEENTH;
                    case 22:
                        return IntervalChromatic.MINOR_FOURTEENTH;
                    case 23:
                        return IntervalChromatic.MAJOR_FOURTEENTH;
                    case 24:
                        return IntervalChromatic.AUGMENTED_FOURTEENTH;
                }
                break;
            case IntervalDiatonic.FIFTEENTH:
                switch (semitones) {
                    case 23:
                        return IntervalChromatic.DIMINISHED_FIFTEENTH;
                    case 24:
                        return IntervalChromatic.PERFECT_FIFTEENTH;
                    case 25:
                        return IntervalChromatic.AUGMENTED_FIFTEENTH;
                }
                break;
            default: throw new Error("Invalid IntervalDiatonic: " + intervalDiatonic);
        }

        throw new Error();
    }

    getSemis() {
        return this.semitones;
    }
}
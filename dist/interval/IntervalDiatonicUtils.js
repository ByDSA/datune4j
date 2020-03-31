import { IntervalDiatonic } from './IntervalDiatonic';
import { IntervalChromatic } from './IntervalChromatic';
export class IntervalDiatonicUtils {
    static fromIntervalChromatic(intervalChromatic) {
        switch (intervalChromatic) {
            case IntervalChromatic.AUGMENTED_UNISON:
            case IntervalChromatic.PERFECT_UNISON:
                return IntervalDiatonic.UNISON;
            case IntervalChromatic.AUGMENTED_SECOND:
            case IntervalChromatic.DIMINISHED_SECOND:
            case IntervalChromatic.MAJOR_SECOND:
            case IntervalChromatic.MINOR_SECOND:
                return IntervalDiatonic.SECOND;
            case IntervalChromatic.AUGMENTED_THIRD:
            case IntervalChromatic.DIMINISHED_THIRD:
            case IntervalChromatic.MAJOR_THIRD:
            case IntervalChromatic.MINOR_THIRD:
                return IntervalDiatonic.THIRD;
            case IntervalChromatic.AUGMENTED_FOURTH:
            case IntervalChromatic.DIMINISHED_FOURTH:
            case IntervalChromatic.PERFECT_FOURTH:
                return IntervalDiatonic.FOURTH;
            case IntervalChromatic.AUGMENTED_FIFTH:
            case IntervalChromatic.DIMINISHED_FIFTH:
            case IntervalChromatic.PERFECT_FIFTH:
                return IntervalDiatonic.FIFTH;
            case IntervalChromatic.AUGMENTED_SIXTH:
            case IntervalChromatic.DIMINISHED_SIXTH:
            case IntervalChromatic.MAJOR_SIXTH:
            case IntervalChromatic.MINOR_SIXTH:
                return IntervalDiatonic.SIXTH;
            case IntervalChromatic.AUGMENTED_SEVENTH:
            case IntervalChromatic.DIMINISHED_SEVENTH:
            case IntervalChromatic.MAJOR_SEVENTH:
            case IntervalChromatic.MINOR_SEVENTH:
                return IntervalDiatonic.SEVENTH;
            case IntervalChromatic.DIMINISHED_OCTAVE:
            case IntervalChromatic.PERFECT_OCTAVE:
            case IntervalChromatic.AUGMENTED_OCTAVE:
                return IntervalDiatonic.OCTAVE;
            case IntervalChromatic.AUGMENTED_NINTH:
            case IntervalChromatic.DIMINISHED_NINTH:
            case IntervalChromatic.MAJOR_NINTH:
            case IntervalChromatic.MINOR_NINTH:
                return IntervalDiatonic.NINTH;
            case IntervalChromatic.AUGMENTED_TENTH:
            case IntervalChromatic.DIMINISHED_TENTH:
            case IntervalChromatic.MAJOR_TENTH:
            case IntervalChromatic.MINOR_TENTH:
                return IntervalDiatonic.TENTH;
            case IntervalChromatic.AUGMENTED_ELEVENTH:
            case IntervalChromatic.DIMINISHED_ELEVENTH:
            case IntervalChromatic.PERFECT_ELEVENTH:
                return IntervalDiatonic.ELEVENTH;
            case IntervalChromatic.AUGMENTED_TWELFTH:
            case IntervalChromatic.DIMINISHED_TWELFTH:
            case IntervalChromatic.PERFECT_TWELFTH:
                return IntervalDiatonic.TWELFTH;
            case IntervalChromatic.AUGMENTED_THIRTEENTH:
            case IntervalChromatic.DIMINISHED_THIRTEENTH:
            case IntervalChromatic.MAJOR_THIRTEENTH:
            case IntervalChromatic.MINOR_THIRTEENTH:
                return IntervalDiatonic.THIRTEENTH;
            case IntervalChromatic.AUGMENTED_FOURTEENTH:
            case IntervalChromatic.DIMINISHED_FOURTEENTH:
            case IntervalChromatic.MAJOR_FOURTEENTH:
            case IntervalChromatic.MINOR_FOURTEENTH:
                return IntervalDiatonic.FOURTEENTH;
            case IntervalChromatic.DIMINISHED_FIFTEENTH:
            case IntervalChromatic.PERFECT_FIFTEENTH:
            case IntervalChromatic.AUGMENTED_FIFTEENTH:
                return IntervalDiatonic.FIFTEENTH;
        }
        Error();
    }
}
//# sourceMappingURL=IntervalDiatonicUtils.js.map
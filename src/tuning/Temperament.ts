import { Degree } from '../degrees/Degree';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { IntervalSymbolic } from '../interval/IntervalSymbolic';
import { Settings } from '../settings/Settings';
import { IntervalPitch } from './IntervalPitch';

export abstract class Temperament {
    public static ET12;
    public static LIMIT_5_SYMMETRIC_N1;
    public static LIMIT_5_SYMMETRIC_N2;
    public static PYTHAGOREAN;

    public abstract getIntervalPitch(interval: IntervalSymbolic<Degree>): IntervalPitch;

    private static initialize(): void {
        this.ET12 = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic<DiatonicAlt>): IntervalPitch {
                if (interval instanceof IntervalDiatonicAlt) {
                    switch (interval.semis) {
                        case 0: return IntervalPitch.UNISON;
                        case 1: return IntervalPitch.ET12.MINOR_SECOND;
                        case 2: return IntervalPitch.ET12.MAJOR_SECOND;
                        case 3: return IntervalPitch.ET12.MINOR_THIRD;
                        case 4: return IntervalPitch.ET12.MAJOR_THIRD;
                        case 5: return IntervalPitch.ET12.PERFECT_FOURTH;
                        case 6: return IntervalPitch.ET12.TRITONE;
                        case 7: return IntervalPitch.ET12.PERFECT_FIFTH;
                        case 8: return IntervalPitch.ET12.MINOR_SIXTH;
                        case 9: return IntervalPitch.ET12.MAJOR_SIXTH;
                        case 10: return IntervalPitch.ET12.MINOR_SEVENTH;
                        case 11: return IntervalPitch.ET12.MAJOR_SEVENTH;
                    }
                }

                throw new Error();
            }
        });

        this.LIMIT_5_SYMMETRIC_N1 = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic<DiatonicAlt>): IntervalPitch {
                if (interval instanceof IntervalDiatonicAlt) {
                    switch (interval.semis) {
                        case 0: return IntervalPitch.UNISON;
                        case 1: return IntervalPitch.JUST.MINOR_SECOND;
                        case 2: return IntervalPitch.JUST.MAJOR_TONE;
                        case 3: return IntervalPitch.JUST.MINOR_THIRD;
                        case 4: return IntervalPitch.JUST.MAJOR_THIRD;
                        case 5: return IntervalPitch.JUST.PERFECT_FOURTH;
                        case 7: return IntervalPitch.JUST.PERFECT_FIFTH;;
                        case 8: return IntervalPitch.JUST.MINOR_SIXTH;
                        case 9: return IntervalPitch.JUST.MAJOR_SIXTH;
                        case 10: return IntervalPitch.JUST.MINOR_SEVENTH_SMALL;
                        case 11: return IntervalPitch.JUST.MAJOR_SEVENTH;
                        case 6:
                            if (interval == IntervalDiatonicAlt.DIMINISHED_FIFTH)
                                return IntervalPitch.JUST.TRITONE;
                            else if (interval == IntervalDiatonicAlt.AUGMENTED_FOURTH)
                                return IntervalPitch.JUST.AUGMENTED_FOURTH;
                    }
                }

                throw Temperament.generateError(interval);
            }
        });

        this.LIMIT_5_SYMMETRIC_N2 = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic<DiatonicAlt>): IntervalPitch {
                if (interval instanceof IntervalDiatonicAlt) {
                    switch (interval.semis) {
                        case 2: return IntervalPitch.JUST.MINOR_TONE;
                        case 10: return IntervalPitch.JUST.MINOR_SEVENTH_GREATER;
                        default: return Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval);
                    }
                }

                throw Temperament.generateError(interval);
            }
        });


        this.PYTHAGOREAN = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic<DiatonicAlt>): IntervalPitch {
                if (interval instanceof IntervalDiatonicAlt) {
                    switch (interval) {
                        case IntervalDiatonicAlt.DIMINISHED_SECOND: return IntervalPitch.PYTHAGOREAN.DIMINISHED_SECOND;
                        case IntervalDiatonicAlt.PERFECT_UNISON: return IntervalPitch.UNISON;
                        case IntervalDiatonicAlt.AUGMENTED_UNISON: return IntervalPitch.PYTHAGOREAN.AUGMENTED_UNISON;
                        case IntervalDiatonicAlt.MINOR_SECOND: return IntervalPitch.PYTHAGOREAN.MINOR_SECOND;
                        case IntervalDiatonicAlt.DIMINISHED_THIRD: return IntervalPitch.PYTHAGOREAN.DIMINISHED_THIRD;
                        case IntervalDiatonicAlt.MAJOR_SECOND: return IntervalPitch.PYTHAGOREAN.MAJOR_SECOND;
                        case IntervalDiatonicAlt.MINOR_THIRD: return IntervalPitch.PYTHAGOREAN.MINOR_THIRD;
                        case IntervalDiatonicAlt.AUGMENTED_SECOND: return IntervalPitch.PYTHAGOREAN.AUGMENTED_SECOND;
                        case IntervalDiatonicAlt.DIMINISHED_FOURTH: return IntervalPitch.PYTHAGOREAN.DIMINISHED_FOURTH;
                        case IntervalDiatonicAlt.MAJOR_THIRD: return IntervalPitch.PYTHAGOREAN.MAJOR_THIRD;
                        case IntervalDiatonicAlt.PERFECT_FOURTH: return IntervalPitch.PYTHAGOREAN.PERFECT_FOURTH;
                        case IntervalDiatonicAlt.AUGMENTED_THIRD: return IntervalPitch.PYTHAGOREAN.AUGMENTED_THIRD;
                        case IntervalDiatonicAlt.DIMINISHED_FIFTH: return IntervalPitch.PYTHAGOREAN.DIMINISHED_FIFTH;
                        case IntervalDiatonicAlt.AUGMENTED_FOURTH: return IntervalPitch.PYTHAGOREAN.AUGMENTED_FOURTH;
                        case IntervalDiatonicAlt.DIMINISHED_SIXTH: return IntervalPitch.PYTHAGOREAN.DIMINISHED_SIXTH;
                        case IntervalDiatonicAlt.PERFECT_FIFTH: return IntervalPitch.PYTHAGOREAN.PERFECT_FIFTH;
                        case IntervalDiatonicAlt.MINOR_SIXTH: return IntervalPitch.PYTHAGOREAN.MINOR_SIXTH;
                        case IntervalDiatonicAlt.AUGMENTED_FIFTH: return IntervalPitch.PYTHAGOREAN.AUGMENTED_FIFTH;
                        case IntervalDiatonicAlt.DIMINISHED_SEVENTH: return IntervalPitch.PYTHAGOREAN.DIMINISHED_SEVENTH;
                        case IntervalDiatonicAlt.MAJOR_SIXTH: return IntervalPitch.PYTHAGOREAN.MAJOR_SIXTH;
                        case IntervalDiatonicAlt.MINOR_SEVENTH: return IntervalPitch.PYTHAGOREAN.MINOR_SEVENTH;
                        case IntervalDiatonicAlt.AUGMENTED_SIXTH: return IntervalPitch.PYTHAGOREAN.AUGMENTED_SIXTH;
                        case IntervalDiatonicAlt.DIMINISHED_OCTAVE: return IntervalPitch.PYTHAGOREAN.DIMINISHED_OCTAVE;
                        case IntervalDiatonicAlt.MAJOR_SEVENTH: return IntervalPitch.PYTHAGOREAN.MAJOR_SEVENTH;
                    }
                }

                throw Temperament.generateError(interval);
            }
        });
    }

    private static generateError(interval: IntervalSymbolic<Degree>): Error {
        return new Error("Cannot convert interval " + interval + ".");
    }

    public toString(): string {
        switch (this) {
            case Temperament.ET12: return Settings.lang.temperaments.ET12;
            case Temperament.LIMIT_5_SYMMETRIC_N1: return Settings.lang.temperaments.LIMIT_5_SYMMETRIC_N1;
            case Temperament.LIMIT_5_SYMMETRIC_N2: return Settings.lang.temperaments.LIMIT_5_SYMMETRIC_N2;
            case Temperament.PYTHAGOREAN: return Settings.lang.temperaments.PYTHAGOREAN;
        }
    }

    public hashCode(): string {
        switch (this) {
            case Temperament.ET12: return "ET12";
            case Temperament.LIMIT_5_SYMMETRIC_N1: return "LIMIT_5_SYMMETRIC_N1";
            case Temperament.LIMIT_5_SYMMETRIC_N2: return "LIMIT_5_SYMMETRIC_N2";
            case Temperament.PYTHAGOREAN: return "PYTHAGOREAN";
        }

        throw new Error();
    }
}
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { IntervalPitch } from '../interval/IntervalPitch';
import { IntervalSymbolic } from '../interval/IntervalSymbolic';

export abstract class Temperament {
    public static ET12;
    public static LIMIT_5_SYMMETRIC_N1;
    public static LIMIT_5_SYMMETRIC_N2;

    public abstract getIntervalPitch(interval: IntervalSymbolic): IntervalPitch;

    private static initialize(): void {
        this.ET12 = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic): IntervalPitch {
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
            public getIntervalPitch(interval: IntervalSymbolic): IntervalPitch {
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

                throw new Error();
            }
        });

        this.LIMIT_5_SYMMETRIC_N2 = new (class extends Temperament {
            public getIntervalPitch(interval: IntervalSymbolic): IntervalPitch {
                if (interval instanceof IntervalDiatonicAlt) {
                    switch (interval.semis) {
                        case 2: return IntervalPitch.JUST.MINOR_TONE;
                        case 10: return IntervalPitch.JUST.MINOR_SEVENTH_GREATER;
                        default: return Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval);
                    }
                }

                throw new Error();
            }
        });
    }

    public toString(): string {
        switch(this) {
            case Temperament.ET12: return "12-ET";
            case Temperament.LIMIT_5_SYMMETRIC_N1: return "5-LIMIT: SYMMETRIC N1";
            case Temperament.LIMIT_5_SYMMETRIC_N2: return "5-LIMIT: SYMMETRIC N2";
        }
    }
}
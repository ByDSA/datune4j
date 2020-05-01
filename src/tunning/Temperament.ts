import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { Chromatic } from '../degrees/Chromatic';
import { IntervalSymbolic } from '../interval/Interval';
import { Ratio } from './ratios/Ratio';
import { RatioFrac } from './ratios/RatioFrac';
import { RatioNumber } from './ratios/RatioNumber';

export abstract class Temperament {
    public static EQUAL;
    public static FIVE_LIMIT_SYMMETRIC_N1;

    public abstract getRatio(interval: IntervalSymbolic): Ratio;

    private static initialize(): void {
        this.EQUAL = new (class extends Temperament {
            public getRatio(interval: IntervalSymbolic): Ratio {
                let size: number;
                let dist: number;

                if (interval instanceof IntervalDiatonicAlt) {
                    dist = interval.semis;
                    size = Chromatic.NUMBER;
                }

                if (size === undefined || dist === undefined)
                    throw new Error();

                return RatioNumber.from(Math.pow(2, dist / size));
            }
        });

        this.FIVE_LIMIT_SYMMETRIC_N1 = new (class extends Temperament {
            public getRatio(interval: IntervalSymbolic): Ratio {
                if (interval instanceof IntervalDiatonicAlt) {
                    let dist = interval.semis;
                    let size = Chromatic.NUMBER;

                    switch (dist) {
                        case 0: return RatioFrac.from(1, 1);
                        case 1: return RatioFrac.from(16, 15);
                        case 2: return RatioFrac.from(9, 8);
                        case 3: return RatioFrac.from(6, 5);
                        case 4: return RatioFrac.from(5, 4);
                        case 5: return RatioFrac.from(4, 3);
                        case 7: return RatioFrac.from(3, 2);
                        case 8: return RatioFrac.from(8, 5);
                        case 9: return RatioFrac.from(5, 3);
                        case 10: return RatioFrac.from(16, 9);
                        case 11: return RatioFrac.from(15, 8);
                        case 6:
                            if (interval instanceof IntervalDiatonicAlt && interval.alts < 0)
                                return RatioFrac.from(64, 45);
                            else
                                return RatioFrac.from(45, 32);
                    }
                }

                throw new Error();
            }
        });
    }
}
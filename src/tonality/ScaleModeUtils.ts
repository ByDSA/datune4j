import { IntervalDiatonicAlt } from 'interval/IntervalDiatonicAlt';
import { Assert } from '../common/Assert';
import { Utils } from '../common/Utils';
import { Scale } from './Scale';

export class ScaleModeUtils {
    private constructor() {
    }

    public static getMode(sourceScale: Scale, n: number): Scale {
        Assert.notNull(sourceScale);

        if (n > 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n - 1);
        else if (n < 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n);
        else
            return sourceScale;
    }

    public static getRotatedScale(sourceScale: Scale, n: number): Scale {
        Assert.notNull(sourceScale);

        let scaleIntervals: IntervalDiatonicAlt[] = sourceScale.intervals;

        if (n > 0)
            Utils.arrayRotateLeft(scaleIntervals, n);
        else if (n < 0)
            Utils.arrayRotateRight(scaleIntervals, n);
        else
            return sourceScale;

        return Scale.fromIntervals(...scaleIntervals);
    }
}
import { IntervalDiatonicAlt } from 'interval/IntervalDiatonicAlt';
import { Assert } from '../Utils/Assert';
import { Utils } from '../Utils/Utils';
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
            Utils.arrayRotate(scaleIntervals, n);
        else if (n < 0)
            Utils.arrayRotate(scaleIntervals, -n, true);
        else
            return sourceScale;

        return Scale.fromIntervals(...scaleIntervals);
    }
}
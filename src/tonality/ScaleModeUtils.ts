import { Scale } from './Scale';
import { Utils } from '../Utils';

export class ScaleModeUtils {
    private constructor() {
    }

    public static getMode(sourceScale: Scale, n: number): Scale {
        if (n > 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n - 1);
        else if (n < 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n);
        else
            return sourceScale;
    }

    public static getRotatedScale(sourceScale: Scale, n: number): Scale {
        let scaleIntervals: number[] = sourceScale.intervals;

        if (n > 0)
            Utils.arrayRotate(scaleIntervals, n);
        else if (n < 0)
            Utils.arrayRotate(scaleIntervals, -n, true);
        else
            return sourceScale;

        return Scale.from(...scaleIntervals);
    }
}
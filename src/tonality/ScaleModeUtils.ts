import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { Assert } from '../common/Assert';
import { Utils } from '../common/Utils';
import { Degree } from '../degrees/Degree';
import { Scale } from './Scale';
import { ScaleAbstract } from './ScaleInterface';

export class ScaleModeUtils {
    private constructor() {
    }

    public static getMode<S extends ScaleAbstract<I, D>, I, D extends Degree>(sourceScale: S, n: number): S {
        Assert.notNull(sourceScale);

        if (n > 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n - 1);
        else if (n < 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n);
        else
            return sourceScale;
    }

    public static getRotatedScale<S extends ScaleAbstract<I, D>, I, D extends Degree>(sourceScale: S, n: number): S {
        Assert.notNull(sourceScale);

        let scaleIntervals: I[] = sourceScale.intervals;

        if (n > 0)
            Utils.arrayRotateLeft(scaleIntervals, n);
        else if (n < 0)
            Utils.arrayRotateRight(scaleIntervals, n);
        else
            return sourceScale;

        if (scaleIntervals[0] instanceof IntervalDiatonicAlt)
            return <S><any>Scale.fromIntervals(...<IntervalDiatonicAlt[]><any>scaleIntervals);
        else
            return null;
    }
}
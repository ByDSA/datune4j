import { Scale } from './Scale';
import { Utils } from '../Utils';
export class ScaleModeUtils {
    constructor() {
    }
    static getMode(sourceScale, n) {
        if (n > 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n - 1);
        else if (n < 0)
            return ScaleModeUtils.getRotatedScale(sourceScale, n);
        else
            return sourceScale;
    }
    static getRotatedScale(sourceScale, n) {
        let scaleIntervals = Array.from(sourceScale.intervals);
        if (n > 0)
            Utils.arrayRotate(scaleIntervals, n);
        else if (n < 0)
            Utils.arrayRotate(scaleIntervals, -n, true);
        else
            return sourceScale;
        return Scale.from(...scaleIntervals);
    }
}
//# sourceMappingURL=ScaleModeUtils.js.map
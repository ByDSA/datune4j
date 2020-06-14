import { IntervalSymbolic } from '../interval/IntervalSymbolic';
import { ScaleModeUtils } from './ScaleModeUtils';

export abstract class ScaleAbstract<I extends IntervalSymbolic<D>, D> {
    protected _intervals: I[];
    protected _precalcDegrees: D[] = null;
    protected _precalcModes: ScaleAbstract<I, D>[] = null;

    protected constructor(...intervals: I[]) {
        this._intervals = intervals;
        Object.freeze(this._intervals);
    }

     // Modes

     public get modes(): ScaleAbstract<I, D>[] {
        if (!this._precalcModes)
            this.calculateModes();

        return this._precalcModes;
    }

    private calculateModes(): void {
        let scaleTmp: ScaleAbstract<I, D> = this;
        this._precalcModes = [this];
        while (true) {
            scaleTmp = ScaleModeUtils.getRotatedScale(scaleTmp, 1);
            if (scaleTmp == this)
                break;
            this._precalcModes.push(scaleTmp);
        }
    }

    // Absolute Intervals

    public get degrees(): D[] {
        if (this._precalcDegrees == null)
            this.calculateDegrees();
        return this._precalcDegrees;
    }

    protected abstract calculateDegrees();

    get intervals(): I[] {
        return Array.from(this._intervals);
    }

    public get length(): number {
        return this._intervals.length;
    }

    hasDegrees(...degrees: D[]): boolean {
        for (let degree of degrees) {
            if (!this.degrees.includes(degree))
                return false;
        }

        return true;
    }
}
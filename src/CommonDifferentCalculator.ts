import { Scale } from './tonality/Scale';

export class CommonDifferentCalculator {
    private _common = new Set<number>();
    private _different = new Set<number>();

    private constructor(private scales: Scale[]) {
    }

    public static from(scales: Scale[]): CommonDifferentCalculator {
        return new CommonDifferentCalculator(scales);
    }

    public calculate(): void {
        this.addAllAbsoluteIntervalsToCommon();
        this.removeAbsoluteIntervalsFromCommon();
    }

    private addAllAbsoluteIntervalsToCommon(): void {
        for (let scale of this.scales) {
            let absoluteIntervals = scale.getAbsoluteIntervals();
            for (let absoluteInterval of absoluteIntervals)
                this._common.add(absoluteInterval);
        }
    }

    private removeAbsoluteIntervalsFromCommon(): void {
        mainFor: for (let absoluteInterval of this._common)
            for (let scale of this.scales) {
                if (!scale.hasAbsoluteInterval(absoluteInterval)) {
                    this._common.delete(absoluteInterval)
                    this._different.add(absoluteInterval);
                    continue mainFor;
                }
            }
    }

    public get common(): Set<number> {
        return this._common;
    }

    public get different(): Set<number> {
        return this._different;
    }
}
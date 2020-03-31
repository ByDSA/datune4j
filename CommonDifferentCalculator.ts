import { Scale } from './Scale';

export class CommonDifferentCalculator {
    private common = new Set<number>();
    private different = new Set<number>();

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
                this.common.add(absoluteInterval);
        }
    }

    private removeAbsoluteIntervalsFromCommon(): void {
        mainFor: for (let absoluteInterval of this.common)
            for (let scale of this.scales) {
                if (!scale.hasAbsoluteInterval(absoluteInterval)) {
                    this.common.delete(absoluteInterval)
                    this.different.add(absoluteInterval);
                    continue mainFor;
                }
            }
    }

    public getCommon(): Set<number> {
        return this.common;
    }

    public getDifferent(): Set<number> {
        return this.different;
    }
}
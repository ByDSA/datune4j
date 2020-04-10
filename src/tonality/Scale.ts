import { Hashing } from '../Hashing';
import { NamingScale } from '../lang/naming/NamingScale';
import { Utils } from '../Utils';
import { ScaleModeUtils } from './ScaleModeUtils';

export class Scale {
    private _intervals: number[];
    private _absoluteIntervals: number[] = null;
    private static immutablesMap;
    private _modes: Scale[] = null;

    private constructor(...intervals: number[]) {
        if (!intervals)
            throw new Error("No intervals have been put.");
        this._intervals = intervals;
        Utils.assertNotNull(this._intervals);
        Scale.addToImmutables(this);
    }

    private static addToImmutables(scale: Scale): void {
        let hash = Hashing.hashArray(scale._intervals);

        Scale.immutablesMap = Scale.immutablesMap || new Map<string, Scale>();
        Scale.immutablesMap.set(hash, scale);
    }

    public static from(...intervals: number[]): Scale {
        let scale: Scale | undefined = Scale.getFromImmutables(intervals);
        if (!scale)
            scale = new Scale(...intervals);

        return scale;
    }

    private static getFromImmutables(intervals: number[]): Scale | undefined {
        let hash = Hashing.hashArray(intervals);
        Scale.immutablesMap = Scale.immutablesMap || new Map<string, Scale>();
        return Scale.immutablesMap.get(hash);
    }

    // Relative Intervals

    public get intervals(): number[] {
        return Array.from(this._intervals);
    }

    // Modes

    public get modes(): Scale[] {
        if (!this._modes)
            this.calculateModes();

        return this._modes;
    }

    private calculateModes(): void {
        let scaleTmp: Scale = this;
        this._modes = [this];
        while (true) {
            scaleTmp = ScaleModeUtils.getRotatedScale(scaleTmp, 1);
            if (scaleTmp == this)
                break;
            this._modes.push(scaleTmp);
        }
    }

    // Absolute Intervals

    public get absoluteIntervals() {
        if (this._absoluteIntervals == null)
            this._absoluteIntervals = this.calculateAbsoluteIntervals();

        return this._absoluteIntervals;
    }

    private calculateAbsoluteIntervals(): number[] {
        let absoluteIntervals = [0];

        let relativeIntervals = this.intervals;
        relativeIntervals.pop();

        let acc = 0;
        relativeIntervals.forEach(n => {
            acc += n;
            absoluteIntervals.push(acc);
        });

        return absoluteIntervals;
    }

    // General

    public get length(): number {
        return this._intervals.length;
    }

    public toString(): string {
        return NamingScale.toString(this);
    }

    public clone(): Scale {
        let scale = new Scale(0);
        scale._intervals = this.intervals;
        return scale;
    }
}
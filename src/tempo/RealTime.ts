import { Time } from './Time';

export class RealTime implements Time {
    private constructor(private _millis: number) {
    }

    public static fromMillis(millis: number): RealTime {
        return new RealTime(millis);
    }

    get millis(): number {
        return this._millis;
    }

    getAdd(time: RealTime): RealTime {
        return RealTime.fromMillis(this.millis + time.millis);
    }

    getSub(time: RealTime): Time {
        return RealTime.fromMillis(this.millis - time.millis);
    }

    getMult(factor: number): Time {
        return RealTime.fromMillis(this.millis * factor);
    }

    getDivCell(cellSize: RealTime): number {
        return Math.floor(this.millis / cellSize.millis);
    }

    getDiv(n: number): RealTime {
        return RealTime.fromMillis(this.millis / n);
    }

    clone(): RealTime {
        return RealTime.fromMillis(this.millis);
    }

    public valueOf(): number {
        return this.millis;
    }
}
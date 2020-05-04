import { Time } from '../tempo/Time';
import { Interval } from '../utils/Interval';

export abstract class DurableEvent<E, T extends Time> {
    protected constructor(private _interval: Interval<T>, private _event: E) {
    }

    public get from(): T {
        return this._interval.from;
    }

    public get to(): T {
        return this._interval.to;
    }

    public get interval(): Interval<T> {
        return this._interval;
    }

    public get event(): E {
        return this._event;
    }

    public set event(note: E) {
        this._event = note;
    }

    public toString(): string {
        return this._interval + ": " + this.event;
    }
}
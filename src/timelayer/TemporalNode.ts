import { Time } from '../tempo/Time';
import { Interval } from '../utils/Interval';
import { TemporalEvent } from './TemporalEvent';

export class TemporalNode<E extends TemporalEvent<T>, T extends Time> {
    private constructor(private _ini: T, private _event: E) {
    }

    public static createFrom<E extends TemporalEvent<T>, T extends Time>(ini: T, event: E): TemporalNode<E, T> {
        return new TemporalNode(ini, event);
    }

    public get from(): T {
        return this._ini;
    }

    public get to(): T {
        return <T>this._ini.getAdd(this._event.duration);
    }

    public get event(): E {
        return this._event;
    }

    public get interval(): Interval<T> {
        return Interval.fromInclusiveToExclusive(this.from, this.to);
    }

    public set event(note: E) {
        this._event = note;
    }

    public toString(): string {
        return this._ini + ": " + this.event;
    }
}
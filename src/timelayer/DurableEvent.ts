import { Time } from 'tempo/Time';

export abstract class DurableEvent<E, T extends Time> {
    private _end: T;

    protected constructor(private _ini: T, private _event: E, length: T) {
        this._end = <T>_ini.getAdd(length);
    }

    public get ini(): T {
        return this._ini;
    }

    public get end(): T {
        return this._end;
    }

    public get event(): E {
        return this._event;
    }

    public set event(note: E) {
        this._event = note;
    }

    public toString(): string {
        return "[" + this.ini + ", " + this.end + "]: " + this.event;
    }
}
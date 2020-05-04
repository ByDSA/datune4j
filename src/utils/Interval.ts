export class Interval<C> {
    private constructor(private _from: C, private _fromInclusive: boolean, private _to: C, private _toInclusive: boolean) {
    }

    public static from<C>(from: C, fromInclusive: boolean, to: C, toInclusive: boolean): Interval<C> {
        return new Interval(from, fromInclusive, to, toInclusive);
    }

    public static fromInclusiveToExclusive<C>(from: C, to: C) {
        return this.from(from, true, to, false);
    }

    public get from(): C {
        return this._from;
    }

    public get to(): C {
        return this._to;
    }

    public contains(element: C): boolean {
        return element > this._from && element < this._to
            || this._fromInclusive && element.valueOf() == this._from.valueOf()
            || this._toInclusive && element.valueOf() == this._to.valueOf();
    }

    public intersects(interval: Interval<C>): boolean {
        return this.to > interval.from;
    }

    public toString(): string {
        return (this._fromInclusive ? "[" : "(")
            + this.from + ", " + this.to
            + (this._toInclusive ? "]" : ")");
    }
}
import { Ratio } from './Ratio';

export class RatioPow2Frac extends Ratio {
    get value(): number {
        return Math.pow(2, this._numerator / this._denominator);
    }

    private constructor(private _numerator: number, private _denominator: number) {
        super();
    }

    public static from(numerator: number, denominator: number): RatioPow2Frac {
        return new RatioPow2Frac(numerator, denominator);
    }

    public static fromCents(cents: number): RatioPow2Frac {
        return new RatioPow2Frac(cents, 1200);
    }

    get cents() {
        return 1200 * this._numerator / this._denominator;
    }
}
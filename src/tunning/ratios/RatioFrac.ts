import { Ratio } from './Ratio';

export class RatioFrac extends Ratio {
    get(): number {
        return this.numerator / this.denominator;
    }

    private constructor(private numerator: number, private denominator: number) {
        super();
    }

    public static from(numerator: number, denominator: number): RatioFrac {
        return new RatioFrac(numerator, denominator);
    }
}
import { Ratio } from './Ratio';

export class RatioNumber extends Ratio {
    constructor(private num) {
        super();
    }

    static from(n: number) {
        return new RatioNumber(n);
    }

    get value(): number {
        return this.num;
    }
}
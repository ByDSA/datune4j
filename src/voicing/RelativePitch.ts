import { Degree } from '../degrees/Degree';

export class RelativePitch<D extends Degree> {
    private constructor(private _degree: D, private _octaveRelative: number) {
    }

    public static from<D extends Degree>(degree: D, octaveRelative: number): RelativePitch<D> {
        return new RelativePitch(degree, octaveRelative);
    }

    public get octaveRelative(): number {
        return this._octaveRelative;
    }

    public get degree(): D {
        return this._degree;
    }

    public toString(): string {
        return this._degree + " " + this._octaveRelative;
    }
}
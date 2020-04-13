import { HarmonicFunction } from '../../function/HarmonicFunction';
import { Tonality } from '../../tonality/Tonality';

export class TonalChord {
    private constructor(private _tonality: Tonality, private _harmonicFunction: HarmonicFunction) {
    }

    public static from(tonality: Tonality, harmonicFunction: HarmonicFunction): TonalChord {
        return new TonalChord(tonality, harmonicFunction);
    }

    /* Getters and setters */

    public get tonality(): Tonality {
        return this._tonality;
    }

    public set tonality(tonality: Tonality) {
        this._tonality = tonality;
    }

    public get harmonicFunction(): HarmonicFunction {
        return this._harmonicFunction;
    }

    public set harmonicFunction(harmonicFunction: HarmonicFunction) {
        this._harmonicFunction = harmonicFunction;
    }

    /* Object */

    public toString(): string {
        return this._tonality + " " + this._harmonicFunction;
    }

    public hashCode(): string {
        return this.tonality.hashCode() + "|" + this.harmonicFunction.hashCode();
    }
}

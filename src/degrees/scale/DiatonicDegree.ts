import { Diatonic } from '../../degrees/Diatonic';
import { Immutables } from '../../Utils/Immutables';
import { MathUtils } from '../../Utils/MathUtils';

export class DiatonicDegree {
    public static I;
    public static II;
    public static III;
    public static IV;
    public static V;
    public static VI;
    public static VII;

    private constructor(private _intValue: number) {
    }

    public static fromInt(n: number): DiatonicDegree {
        n = MathUtils.rotativeTrim(n, Diatonic.NUMBER);

        switch (n) {
            case 0: return DiatonicDegree.I;
            case 1: return DiatonicDegree.II;
            case 2: return DiatonicDegree.III;
            case 3: return DiatonicDegree.IV;
            case 4: return DiatonicDegree.V;
            case 5: return DiatonicDegree.VI;
            case 6: return DiatonicDegree.VII;
        }

        throw new Error();
    }

    get intValue(): number {
        return this._intValue;
    }

    public hashCode(): string {
        return "DiatonicDegree:" + this._intValue;
    }

    private static initialize() {
        DiatonicDegree.I = new DiatonicDegree(0);
        DiatonicDegree.II = new DiatonicDegree(1);
        DiatonicDegree.III = new DiatonicDegree(2);
        DiatonicDegree.IV = new DiatonicDegree(3);
        DiatonicDegree.V = new DiatonicDegree(4);
        DiatonicDegree.VI = new DiatonicDegree(5);
        DiatonicDegree.VII = new DiatonicDegree(6);

        Immutables.lockr(DiatonicDegree);
    }
}
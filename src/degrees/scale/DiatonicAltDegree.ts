import { Diatonic } from '../../degrees/Diatonic';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';
import { Hashing } from '../../Utils/Hashing';
import { ImmutablesCache } from '../../Utils/ImmutablesCache';
import { DiatonicDegree } from './DiatonicDegree';
import { Settings } from '../../settings/Settings';

type HashingObjectType = { diatonicDegree: DiatonicDegree, alts: number };
export class DiatonicAltDegree {
    public static I: DiatonicAltDegree;
    public static bII: DiatonicAltDegree;
    public static II: DiatonicAltDegree;
    public static bIII: DiatonicAltDegree;
    public static III: DiatonicAltDegree;
    public static IV: DiatonicAltDegree;
    public static bV: DiatonicAltDegree;
    public static V: DiatonicAltDegree;
    public static bVI: DiatonicAltDegree;
    public static VI: DiatonicAltDegree;
    public static bVII: DiatonicAltDegree;
    public static VII: DiatonicAltDegree;

    private static immutablesCache = new ImmutablesCache<DiatonicAltDegree, HashingObjectType>(
        function (hashingObject: HashingObjectType): string {
            return hashingObject.diatonicDegree.hashCode() + "|" + Hashing.hash(hashingObject.alts);
        },
        function (diatonicAltDegree: DiatonicAltDegree): HashingObjectType {
            return { diatonicDegree: diatonicAltDegree.diatonicDegree, alts: diatonicAltDegree.alts };
        },
        function (hashingObject: HashingObjectType): DiatonicAltDegree {
            return new DiatonicAltDegree(hashingObject.diatonicDegree, hashingObject.alts);
        }
    );

    private constructor(private _diatonicDegree: DiatonicDegree, private _alts: number) {
    }

    public static from(diatonicDegree: DiatonicDegree, alts: number): DiatonicAltDegree {
        return this.immutablesCache.getOrCreate({ diatonicDegree: diatonicDegree, alts: alts });
    }

    public get diatonicDegree(): DiatonicDegree {
        return this._diatonicDegree;
    }

    public get alts(): number {
        return this._alts;
    }

    public get semis(): number {
        return Diatonic.fromInt(this.diatonicDegree.intValue).chromatic.intValue + this.alts;
    }

    public get intervalDiatonicAlt(): IntervalDiatonicAlt {
        let semis = Diatonic.fromInt(this.diatonicDegree.intValue).chromatic.intValue + this.alts;
        return IntervalDiatonicAlt.from(semis, this.diatonicDegree.intValue);
    }

    public hashCode(): string {
        return this._diatonicDegree.hashCode() + "|alts:" + Hashing.hash(this._alts);
    }

    public toString(): string {
        let alts = Settings.symbols.alts(this.alts);
        return alts + this.diatonicDegree;
    }

    private static initialize() {
        DiatonicAltDegree.I = DiatonicAltDegree.from(DiatonicDegree.I, 0);
        DiatonicAltDegree.bII = DiatonicAltDegree.from(DiatonicDegree.II, -1);
        DiatonicAltDegree.II = DiatonicAltDegree.from(DiatonicDegree.II, 0);
        DiatonicAltDegree.bIII = DiatonicAltDegree.from(DiatonicDegree.III, -1);
        DiatonicAltDegree.III = DiatonicAltDegree.from(DiatonicDegree.III, 0);
        DiatonicAltDegree.IV = DiatonicAltDegree.from(DiatonicDegree.IV, 0);
        DiatonicAltDegree.bV = DiatonicAltDegree.from(DiatonicDegree.V, -1);
        DiatonicAltDegree.V = DiatonicAltDegree.from(DiatonicDegree.V, 0);
        DiatonicAltDegree.bVI = DiatonicAltDegree.from(DiatonicDegree.VI, -1);
        DiatonicAltDegree.VI = DiatonicAltDegree.from(DiatonicDegree.VI, 0);
        DiatonicAltDegree.bVII = DiatonicAltDegree.from(DiatonicDegree.VII, -1);
        DiatonicAltDegree.VII = DiatonicAltDegree.from(DiatonicDegree.VII, 0);
    }
}
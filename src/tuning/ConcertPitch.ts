import { ImmutablesCache } from '../common/ImmutablesCache';
import { SPN } from '../pitch/symbolic/SPN';
import { SymbolicPitch } from '../pitch/symbolic/SymbolicPitch';
import { Pitch } from '../pitch/Pitch';

type HashingObject = { frequency: number, symbolicPitch: SymbolicPitch };
export class ConcertPitch implements Pitch {
    public static A440;
    public static A432;

    private static immutablesCache = new ImmutablesCache<ConcertPitch, HashingObject>(
        function (hashingObject: HashingObject): string {
            let symbolicPitchHashCode: string = (<any>hashingObject.symbolicPitch).hashCode();
            if (!symbolicPitchHashCode)
                throw new Error();
            return symbolicPitchHashCode + hashingObject.frequency;
        },
        function (concertPitch: ConcertPitch): HashingObject {
            return { frequency: concertPitch.frequency, symbolicPitch: concertPitch.symbolicPitch };
        },
        function (hashingObject: HashingObject): ConcertPitch {
            return new ConcertPitch(hashingObject.frequency, hashingObject.symbolicPitch);
        }
    );

    private constructor(private _frequency: number, private _symbolicPitch: SymbolicPitch) {
    }

    public static from(frequency: number, symbolicPitch: SymbolicPitch): ConcertPitch {
        return this.immutablesCache.getOrCreate({ frequency: frequency, symbolicPitch: symbolicPitch });
    }

    public get frequency(): number {
        return this._frequency;
    }

    public get symbolicPitch(): SymbolicPitch {
        return this._symbolicPitch;
    }

    public toString(): string {
        return "" + this.symbolicPitch + this.frequency;
    }

    public hashCode(): string {
        return ConcertPitch.immutablesCache.getHash({ frequency: this.frequency, symbolicPitch: this.symbolicPitch });
    }

    private static initialize() {
        this.A440 = ConcertPitch.from(440, SPN.A4);
        this.A432 = ConcertPitch.from(432, SPN.A4);
    }
}
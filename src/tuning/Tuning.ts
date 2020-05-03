import { ImmutablesCache } from '../common/ImmutablesCache';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Degree } from '../degrees/Degree';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { IntervalSymbolic } from '../interval/IntervalSymbolic';
import { SymbolicPitch } from '../pitch/symbolic/SymbolicPitch';
import { ConcertPitch } from './ConcertPitch';
import { Temperament } from './Temperament';

type HashingObject = { concertPitch: ConcertPitch, temperament: Temperament };
export class Tuning {
    public static EQUAL_440;
    public static LIMIT_5_SYMMETRIC_N1_440;

    private static immutablesCache = new ImmutablesCache<Tuning, HashingObject>(
        function (hashingObject: HashingObject): string {
            let concertPitchHashCode = hashingObject.concertPitch.hashCode();
            let temperamentHashCode = hashingObject.temperament.hashCode();

            if (!concertPitchHashCode || !temperamentHashCode)
                throw new Error();

            return concertPitchHashCode + temperamentHashCode;
        },
        function (tuning: Tuning): HashingObject {
            return { concertPitch: tuning.concertPitch, temperament: tuning.temperament };
        },
        function (hashingObject: HashingObject): Tuning {
            return new Tuning(hashingObject.concertPitch, hashingObject.temperament);
        }
    );

    private constructor(private _concertPitch: ConcertPitch, private _temperament: Temperament) {
    }

    getFrequency(symbolicPitch: SymbolicPitch): number {
        let symbolicNote: Degree = symbolicPitch.degree;
        let symbolicNoteRoot: Degree = this._concertPitch.symbolicPitch.degree;
        let interval: IntervalSymbolic;
        if (symbolicNoteRoot instanceof DiatonicAlt && symbolicNote instanceof DiatonicAlt) {
            interval = IntervalDiatonicAlt.betweenDiatonicAlt(symbolicNoteRoot, symbolicNote);
        } else if (symbolicNoteRoot instanceof Chromatic && symbolicNote instanceof Chromatic) {
            interval = IntervalDiatonicAlt.betweenChromatic(symbolicNoteRoot, symbolicNote);
        } else {
            throw new Error("Cannot calculate the interval: root=" + symbolicNoteRoot + " note=" + symbolicNote);
        }

        let ratioNumber = this._temperament.getIntervalPitch(interval).ratio.value;

        if (typeof symbolicNote != typeof symbolicNoteRoot)
            throw new Error();

        let distOctave = symbolicPitch.octave - this._concertPitch.symbolicPitch.octave;
        if ((<Degree>symbolicNote).compareTo(<Degree>symbolicNoteRoot) < 0)
            distOctave--;

        return this._concertPitch.frequency * Math.pow(2, distOctave) * ratioNumber;
    }

    get concertPitch(): ConcertPitch {
        return this._concertPitch;
    }

    get temperament(): Temperament {
        return this._temperament;
    }

    public static from(concertPitch: ConcertPitch, temperament: Temperament) {
        return this.immutablesCache.getOrCreate({ concertPitch: concertPitch, temperament: temperament });
    }

    public toString(): string {
        return this.concertPitch + " " + this.temperament;
    }

    private static initialize() {
        this.EQUAL_440 = Tuning.from(ConcertPitch.A440, Temperament.ET12);
        this.LIMIT_5_SYMMETRIC_N1_440 = Tuning.from(ConcertPitch.A440, Temperament.LIMIT_5_SYMMETRIC_N1);
    }
}
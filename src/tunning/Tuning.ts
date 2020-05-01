import { ImmutablesCache } from '../common/ImmutablesCache';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { IntervalSymbolic } from '../interval/Interval';
import { IntervalDiatonicAlt } from '../interval/IntervalDiatonicAlt';
import { ConcertPitch } from './ConcertPitch';
import { SymbolicNote } from './SymbolicNote';
import { SymbolicPitch } from './SymbolicPitch';
import { Temperament } from './Temperament';

type HashingObject = { concertPitch: ConcertPitch, temperament: Temperament };
type InfoTunning = { root: SymbolicNote, symbolicPitch: SymbolicPitch }
export class Tuning {
    public static EQUAL_440;

    private static immutablesCache = new ImmutablesCache<Tuning, HashingObject>(
        function (hashingObject: HashingObject): string {
            return "" + hashingObject.concertPitch + hashingObject.temperament;
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

    getFrequency(info: InfoTunning): number {
        let symbolicPitch = info.symbolicPitch;
        let symbolicNote: SymbolicNote = symbolicPitch.symbolicNote;
        let symbolicNoteRoot: SymbolicNote = this._concertPitch.symbolicPitch.symbolicNote;
        let interval: IntervalSymbolic;
        if (symbolicNoteRoot instanceof DiatonicAlt && symbolicNote instanceof DiatonicAlt) {
            interval = IntervalDiatonicAlt.betweenDiatonicAlt(symbolicNoteRoot, symbolicNote);
        } else if (symbolicNoteRoot instanceof Chromatic && symbolicNote instanceof Chromatic) {
            interval = IntervalDiatonicAlt.betweenChromatic(symbolicNoteRoot, symbolicNote);
        } else {
            throw new Error("Cannot calculate the interval: root=" + symbolicNoteRoot + " note=" + symbolicNote);
        }

        let ratioNumber = this._temperament.getRatio(interval).value;

        if (typeof symbolicNote != typeof symbolicNoteRoot)
            throw new Error();

        let distOctave = symbolicPitch.octave - this._concertPitch.symbolicPitch.octave;
        if ((<SymbolicNote>symbolicNote).compareTo(<SymbolicNote>symbolicNoteRoot) < 0)
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
        return Tuning.immutablesCache.getHash(this);
    }

    private static initialize() {
        this.EQUAL_440 = Tuning.from(ConcertPitch.A440, Temperament.EQUAL);
    }
}
import { ImmutablesCache } from '../common/ImmutablesCache';
import { Chromatic } from "../degrees/Chromatic";
import { ChromaticSymbolicPitch } from "../tunning/ChromaticSymbolicPitch";
import { Tuning } from "../tunning/Tuning";

type HashingObject = { chromaticSymbolicPitch: ChromaticSymbolicPitch, detuned: number };
export class MidiNote {
    public static MIN: MidiNote;

    public static C0: MidiNote;
    public static CC0: MidiNote;
    public static D0: MidiNote;
    public static DD0: MidiNote;
    public static E0: MidiNote;
    public static F0: MidiNote;
    public static FF0: MidiNote;
    public static G0: MidiNote;
    public static GG0: MidiNote;
    public static A0: MidiNote;
    public static AA0: MidiNote;
    public static B0: MidiNote;
    public static C1: MidiNote;
    public static CC1: MidiNote;
    public static D1: MidiNote;
    public static DD1: MidiNote;
    public static E1: MidiNote;
    public static F1: MidiNote;
    public static FF1: MidiNote;
    public static G1: MidiNote;
    public static GG1: MidiNote;
    public static A1: MidiNote;
    public static AA1: MidiNote;
    public static B1: MidiNote;
    public static C2: MidiNote;
    public static CC2: MidiNote;
    public static D2: MidiNote;
    public static DD2: MidiNote;
    public static E2: MidiNote;
    public static F2: MidiNote;
    public static FF2: MidiNote;
    public static G2: MidiNote;
    public static GG2: MidiNote;
    public static A2: MidiNote;
    public static AA2: MidiNote;
    public static B2: MidiNote;
    public static C3: MidiNote;
    public static CC3: MidiNote;
    public static D3: MidiNote;
    public static DD3: MidiNote;
    public static E3: MidiNote;
    public static F3: MidiNote;
    public static FF3: MidiNote;
    public static G3: MidiNote;
    public static GG3: MidiNote;
    public static A3: MidiNote;
    public static AA3: MidiNote;
    public static B3: MidiNote;
    public static C4: MidiNote;
    public static CC4: MidiNote;
    public static D4: MidiNote;
    public static DD4: MidiNote;
    public static E4: MidiNote;
    public static F4: MidiNote;
    public static FF4: MidiNote;
    public static G4: MidiNote;
    public static GG4: MidiNote;
    public static A4: MidiNote;
    public static AA4: MidiNote;
    public static B4: MidiNote;
    public static C5: MidiNote;
    public static CC5: MidiNote;
    public static D5: MidiNote;
    public static DD5: MidiNote;
    public static E5: MidiNote;
    public static F5: MidiNote;
    public static FF5: MidiNote;
    public static G5: MidiNote;
    public static GG5: MidiNote;
    public static A5: MidiNote;
    public static AA5: MidiNote;
    public static B5: MidiNote;
    public static C6: MidiNote;
    public static CC6: MidiNote;
    public static D6: MidiNote;
    public static DD6: MidiNote;
    public static E6: MidiNote;
    public static F6: MidiNote;
    public static FF6: MidiNote;
    public static G6: MidiNote;
    public static GG6: MidiNote;
    public static A6: MidiNote;
    public static AA6: MidiNote;
    public static B6: MidiNote;
    public static C7: MidiNote;
    public static CC7: MidiNote;
    public static D7: MidiNote;
    public static DD7: MidiNote;
    public static E7: MidiNote;
    public static F7: MidiNote;
    public static FF7: MidiNote;
    public static G7: MidiNote;
    public static GG7: MidiNote;
    public static A7: MidiNote;
    public static AA7: MidiNote;
    public static B7: MidiNote;
    public static C8: MidiNote;
    public static CC8: MidiNote;
    public static D8: MidiNote;
    public static DD8: MidiNote;
    public static E8: MidiNote;
    public static F8: MidiNote;
    public static FF8: MidiNote;
    public static G8: MidiNote;
    public static GG8: MidiNote;
    public static A8: MidiNote;
    public static AA8: MidiNote;
    public static B8: MidiNote;
    public static C9: MidiNote;
    public static CC9: MidiNote;
    public static D9: MidiNote;
    public static DD9: MidiNote;
    public static E9: MidiNote;
    public static F9: MidiNote;
    public static FF9: MidiNote;
    public static G9: MidiNote;
    public static GG9: MidiNote;
    public static A9: MidiNote;
    public static AA9: MidiNote;
    public static B9: MidiNote;
    public static C10: MidiNote;
    public static CC10: MidiNote;
    public static D10: MidiNote;
    public static DD10: MidiNote;
    public static E10: MidiNote;
    public static F10: MidiNote;
    public static FF10: MidiNote;
    public static G10: MidiNote;

    public static MAX: MidiNote;

    private static immutablesCache = new ImmutablesCache<MidiNote, HashingObject>(
        function (hashingObject: HashingObject): string {
            return hashingObject.chromaticSymbolicPitch.hashCode() + "-" + hashingObject.detuned;
        },
        function (midiNote: MidiNote): HashingObject {
            return { chromaticSymbolicPitch: midiNote.chromaticSymbolicPitch, detuned: midiNote.cents };
        },
        function (hashingObject: HashingObject): MidiNote {
            return new MidiNote(hashingObject.chromaticSymbolicPitch, hashingObject.detuned);
        }
    );

    private constructor(private _chromaticSymbolicPitch: ChromaticSymbolicPitch, private _cents: number) {
    }

    public static from(chromaticSymbolicPitch: ChromaticSymbolicPitch, detuned: number) {
        return this.immutablesCache.getOrCreate({ chromaticSymbolicPitch: chromaticSymbolicPitch, detuned: detuned });
    }

    public static fromFrequency(f: number): MidiNote {
        let semis = 12 * Math.log2(f / 440);
        let code = 69 + Math.round(semis);
        let cents = Math.round(100 * (semis - Math.round(semis)));

        return this.fromCode(code, cents);
    }

    public static fromCode(code: number, cents: number = 0): MidiNote {
        if (Math.floor(code) != code)
            throw new Error();

        if (code < 0 || code > 127)
            throw new Error();

        let octave = Math.floor(code / Chromatic.NUMBER);
        let chromaticInt = code - Chromatic.NUMBER * octave;
        let chromatic: Chromatic = Chromatic.fromInt(chromaticInt);
        let chromaticSymbolicPitch: ChromaticSymbolicPitch = ChromaticSymbolicPitch.from(chromatic, octave - 1)

        return this.from(chromaticSymbolicPitch, cents);
    }

    get chromaticSymbolicPitch(): ChromaticSymbolicPitch {
        return this._chromaticSymbolicPitch;
    }

    get cents(): number {
        return this._cents;
    }

    private _precalcFrequency: number;
    private _precalcFrequencyWithoutDetuned: number;

    get frequency(): number {
        if (!this._precalcFrequency) {
            this.precalcFreq();
        }

        return this._precalcFrequency;
    }

    get code(): number {
        if (!this._precalcFrequency) {
            this.precalcFreq();
        }
        return 69 + 12 * Math.log2(this._precalcFrequencyWithoutDetuned / 440);
    }

    private precalcFreq() {
        this._precalcFrequencyWithoutDetuned = Tuning.EQUAL_440.getFrequency(this.chromaticSymbolicPitch);
        this._precalcFrequency = this._precalcFrequencyWithoutDetuned + this.cents;
    }

    private static initialize() {
        mainLoop: for (let i = 0; i <= 10; i++) {
            for (const chromatic of Chromatic.all) {
                let varStr: string = (<any>chromatic).varStr + i;
                let varChromaticSymbolicPitch = this.getVarChromaticSymbolicPitch(chromatic, i);

                this[varStr] = MidiNote.from(ChromaticSymbolicPitch[varChromaticSymbolicPitch], 0);

                if (varStr == "G10")
                    break mainLoop;
            }
        }

        this.MIN = this.C0;
        this.MAX = this.G10;
    }

    private static getVarChromaticSymbolicPitch(chromatic: Chromatic, octave: number): string {
        let varChromaticSymbolicPitch = (<any>chromatic).varStr;
        if (octave > 0)
            varChromaticSymbolicPitch += octave - 1;
        else
            varChromaticSymbolicPitch += "_S" + (-(octave - 1));

        return varChromaticSymbolicPitch;
    }
}
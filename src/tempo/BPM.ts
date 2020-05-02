import { MusicalDuration } from "./MusicalDuration";
import { Tempo } from "./Tempo";

export class BPM extends Tempo {
    public static QUARTER_120: BPM;

    private constructor(private _bpm: number, private _beat: MusicalDuration) {
        super();
    }

    public static from(bpm: number, beat: MusicalDuration = MusicalDuration.QUARTER): BPM {
        return new BPM(bpm, beat);
    }

    public getMillis(musicalDuration: MusicalDuration): number {
        let msPerMin = 1000 * 60;
        let baseDuration = msPerMin / this._bpm;
        let wholeDuration = baseDuration / this._beat.value;

        return musicalDuration.value * wholeDuration;
    }

    get bpm(): number {
        return this._bpm;
    }

    get beat(): MusicalDuration {
        return this._beat;
    }

    private static initialize() {
        this.QUARTER_120 = BPM.from(120, MusicalDuration.QUARTER);
    }
}
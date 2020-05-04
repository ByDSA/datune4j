import { MusicalDuration } from 'tempo/MusicalDuration';
import { MidiPitch } from "./MidiPitch";

export class MidiNote {
    private _velocity: number;

    private constructor(private _midiPitch: MidiPitch, private _duration: MusicalDuration, velocity: number) {
        this.velocity = velocity;
    }

    public static from(pitch: MidiPitch, duration: MusicalDuration, velocity: number = 100) {
        return new MidiNote(pitch, duration, velocity);
    }

    get velocity(): number {
        return this._velocity;
    }

    set velocity(value: number) {
        if (value < 0)
            value = 0;
        else if (value > 127)
            value = 127;

        this._velocity = value;
    }

    get pitch(): MidiPitch {
        return this._midiPitch;
    }

    get duration(): MusicalDuration {
        return this._duration;
    }
}
import { MusicalDuration } from '../tempo/MusicalDuration';
import { TimeSequence } from "../timelayer/TimeSequence";
import { MidiEvent } from './MidiEvent';
import { MidiNote } from './MidiNote';

export class MidiSequence extends TimeSequence<MidiNote, MidiEvent, MusicalDuration> {
    protected constructor(cellSize: MusicalDuration) {
        super(cellSize);
    }

    public static from(cellSize: MusicalDuration): MidiSequence {
        return new MidiSequence(cellSize);
    }

    public get cellSize(): MusicalDuration {
        return super.cellSize;
    }

    public get events(): MidiEvent[] {
        return super.events;
    }

    public get duration(): MusicalDuration {
        return super.duration;
    }
}
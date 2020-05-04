import { MusicalDuration } from '../tempo/MusicalDuration';
import { DurableEvent } from '../timelayer/DurableEvent';
import { Interval } from '../utils/Interval';
import { MidiNote } from './MidiNote';

export class MidiEvent extends DurableEvent<MidiNote, MusicalDuration> {
    private constructor(ini: MusicalDuration, midiNote: MidiNote) {
        let interval = Interval.fromInclusiveToExclusive(ini, ini.getAdd(midiNote.duration));
        super(interval, midiNote);
    }

    public static from(ini: MusicalDuration, midiNote: MidiNote): MidiEvent {
        return new MidiEvent(ini, midiNote);
    }

    get from(): MusicalDuration {
        return super.from;
    }

    get to(): MusicalDuration {
        return super.to;
    }

    get interval(): Interval<MusicalDuration> {
        return super.interval;
    }

    get event(): MidiNote {
        return super.event;
    }
}
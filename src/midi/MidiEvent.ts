import { MusicalDuration } from '../tempo/MusicalDuration';
import { DurableEvent } from '../timelayer/DurableEvent';
import { MidiNote } from './MidiNote';

export class MidiEvent extends DurableEvent<MidiNote, MusicalDuration> {
    private constructor(ini: MusicalDuration, midiNote: MidiNote) {
        super(ini, midiNote, midiNote.duration);
    }

    public static from(ini: MusicalDuration, midiNote: MidiNote): MidiEvent {
        return new MidiEvent(ini, midiNote);
    }

    get ini(): MusicalDuration {
        return super.ini;
    }

    get end(): MusicalDuration {
        return super.end;
    }

    get event(): MidiNote {
        return super.event;
    }
}
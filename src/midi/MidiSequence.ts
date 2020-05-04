import { MusicalDuration } from 'tempo/MusicalDuration';
import { TimeSequence } from "timelayer/TimeSequence";
import { MidiEvent } from './MidiEvent';
import { MidiNote } from './MidiNote';

export class MidiSequence extends TimeSequence<MidiNote, MidiEvent, MusicalDuration> {
    protected constructor(cellSize: MusicalDuration) {
        super(cellSize);
    }
}
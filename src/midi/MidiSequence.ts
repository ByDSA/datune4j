import { MusicalDuration } from '../tempo/MusicalDuration';
import { TemporalNode } from '../timelayer/TemporalNode';
import { TimeSequence } from "../timelayer/TimeSequence";
import { MidiNote } from './MidiNote';

export class MidiSequence extends TimeSequence<MidiNote, MusicalDuration> {
    protected constructor(cellSize: MusicalDuration) {
        super(cellSize);
    }

    public static create(): MidiSequence {
        return new MidiSequence(MusicalDuration.QUARTER);
    }

    public get cellSize(): MusicalDuration {
        return super.cellSize;
    }

    public get nodes(): TemporalNode<MidiNote, MusicalDuration>[] {
        return super.nodes;
    }

    public get duration(): MusicalDuration {
        return super.duration;
    }

    public get startTime(): MusicalDuration {
        return MusicalDuration.ZERO;
    }
}
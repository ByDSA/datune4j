import * as precalc from "../precalc";
import { MusicalDuration } from "../tempo/MusicalDuration";
import { MidiEvent } from "./MidiEvent";
import { MidiNote } from "./MidiNote";
import { MidiPitch } from "./MidiPitch";
import { MidiSequence } from "./MidiSequence";
precalc.midiPitches();
precalc.musicalDurations();

test('from - cellSize=QUARTER', () => {
    let cellSize: MusicalDuration = MusicalDuration.QUARTER;

    let midiSequence: MidiSequence = MidiSequence.from(cellSize);

    expect(midiSequence.cellSize).toEqual(cellSize);
});

test('add - ZERO [C5 QUARTER]', () => {
    let duration: MusicalDuration = MusicalDuration.QUARTER;
    let midiNote: MidiNote = MidiNote.from(MidiPitch.C5, duration);
    let midiEvent: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote);

    let midiSequence: MidiSequence = MidiSequence.from(MusicalDuration.QUARTER);
    midiSequence.add(midiEvent);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.ZERO);

    expect(durableEvents.length).toEqual(1);
    expect(durableEvents[0]).toEqual(midiEvent);
});

function generateSample(): MidiSequence {
    let midiSequence: MidiSequence = MidiSequence.from(MusicalDuration.QUARTER);
    
    let duration: MusicalDuration = MusicalDuration.QUARTER;
    let midiNote: MidiNote = MidiNote.from(MidiPitch.C5, duration);
    let midiEvent: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote);

    let midiNote2: MidiNote = MidiNote.from(MidiPitch.E5, duration);
    let midiEvent2: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote2);
    
    let midiNote3: MidiNote = MidiNote.from(MidiPitch.G5, duration);
    let midiEvent3: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote3);

    midiSequence.add(midiEvent);
    midiSequence.add(midiEvent2);
    midiSequence.add(midiEvent3);
    

    return midiSequence;
}

test('removeAt - sample - EIGHT = nothing at ZERO', () => {
    let midiSequence: MidiSequence = generateSample();
    midiSequence.removeAtTime(MusicalDuration.EIGHTH);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.ZERO);

    expect(durableEvents.length).toEqual(0);
});
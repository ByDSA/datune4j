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

test('removeAt - sample - EIGHT = nothing at ZERO', () => {
    let midiSequence: MidiSequence = generateSample();
    midiSequence.removeAtTime(MusicalDuration.EIGHTH);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.ZERO);

    expect(durableEvents.length).toEqual(0);
});

test('removeAt - sampleArp - remove EIGHT, length = 2', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    midiSequence.removeAtTime(MusicalDuration.EIGHTH);

    expect(midiSequence.events.length).toEqual(2);
});

test('removeAt - sampleArp - remove QUARTER , 1 at ZERO', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    midiSequence.removeAtTime(MusicalDuration.QUARTER);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.ZERO);

    expect(durableEvents.length).toEqual(1);
});

test('removeAt - sampleArp - remove QUARTER, nothing at QUARTER', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    midiSequence.removeAtTime(MusicalDuration.QUARTER);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.QUARTER);

    expect(durableEvents.length).toEqual(0);
});

test('removeAt - sampleArp - remove QUARTER, 1 element at HALF', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    midiSequence.removeAtTime(MusicalDuration.QUARTER);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.HALF);

    expect(durableEvents.length).toEqual(1);
});

test('removeAt - sampleArp - remove EIGHT -> 0 element at HALF.dotted', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    midiSequence.removeAtTime(MusicalDuration.EIGHTH);
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.HALF.dotted);

    expect(durableEvents.length).toEqual(0);
});

test('getAtTime - sampleArp - WHOLE = nothing', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    let durableEvents: MidiEvent[] = midiSequence.getAtTime(MusicalDuration.WHOLE);

    expect(durableEvents.length).toEqual(0);
});

test('events - sampleArp - length = 3', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    let length = midiSequence.events.length;

    expect(length).toEqual(3);
});

test('events - sample - length = 3', () => {
    let midiSequence: MidiSequence = generateSample();
    let length = midiSequence.events.length;

    expect(length).toEqual(3);
});


test('duration - sample - duration = QUARTER', () => {
    let midiSequence: MidiSequence = generateSample();
    let duration = midiSequence.duration;

    expect(duration).toEqual(MusicalDuration.QUARTER);
});

test('duration - sampleArp - duration = HALF.dotted', () => {
    let midiSequence: MidiSequence = generateSampleArp();
    let duration = midiSequence.duration;

    expect(duration).toEqual(MusicalDuration.HALF.dotted);
});


// SAMPLES
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

function generateSampleArp(): MidiSequence {
    let midiSequence: MidiSequence = MidiSequence.from(MusicalDuration.QUARTER);

    let duration: MusicalDuration = MusicalDuration.QUARTER;
    let midiNote: MidiNote = MidiNote.from(MidiPitch.C5, duration);
    let midiEvent: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote);

    let midiNote2: MidiNote = MidiNote.from(MidiPitch.E5, duration);
    let midiEvent2: MidiEvent = MidiEvent.from(MusicalDuration.QUARTER, midiNote2);

    let midiNote3: MidiNote = MidiNote.from(MidiPitch.G5, duration);
    let midiEvent3: MidiEvent = MidiEvent.from(MusicalDuration.HALF, midiNote3);

    midiSequence.add(midiEvent);
    midiSequence.add(midiEvent2);
    midiSequence.add(midiEvent3);

    return midiSequence;
}

/***************************************/
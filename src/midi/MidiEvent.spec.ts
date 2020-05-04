import * as precalc from "../precalc";
import { MusicalDuration } from "../tempo/MusicalDuration";
import { MidiEvent } from "./MidiEvent";
import { MidiNote } from "./MidiNote";
import { MidiPitch } from "./MidiPitch";
precalc.midiPitches();
precalc.musicalDurations();

test('from - ZERO (C5 QUARTER 90)', () => {
    let midiPitch: MidiPitch = MidiPitch.C5;
    let duration: MusicalDuration = MusicalDuration.QUARTER;
    let velocity = 90;

    let midiNote: MidiNote = MidiNote.from(midiPitch, duration, velocity);

    let midiEvent: MidiEvent = MidiEvent.from(MusicalDuration.ZERO, midiNote);

    expect(midiEvent.ini).toEqual(MusicalDuration.ZERO);
    expect(midiEvent.event).toEqual(midiNote);
    expect(midiEvent.end).toEqual(MusicalDuration.QUARTER);
});

test('from - QUARTER (C5 QUARTER 90)', () => {
    let midiPitch: MidiPitch = MidiPitch.C5;
    let duration: MusicalDuration = MusicalDuration.QUARTER;
    let velocity = 90;

    let midiNote: MidiNote = MidiNote.from(midiPitch, duration, velocity);

    let midiEvent: MidiEvent = MidiEvent.from(MusicalDuration.QUARTER, midiNote);

    expect(midiEvent.ini).toEqual(MusicalDuration.QUARTER);
    expect(midiEvent.event).toEqual(midiNote);
    expect(midiEvent.end).toEqual(MusicalDuration.HALF);
});
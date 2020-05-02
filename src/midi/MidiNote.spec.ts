import * as precalc from "../precalc";
import { ChromaticSymbolicPitch } from "../tunning/ChromaticSymbolicPitch";
import { SymbolicPitch } from "../tunning/SymbolicPitch";
import { Tuning } from "../tunning/Tuning";
import { MidiNote } from "./MidiNote";
import { Settings } from "../settings/Settings";
import { Language } from "../lang/Language";
precalc.midiNotes();
precalc.settings();

test('MidiNote - PRECALC', () => {
    let midiNote = MidiNote.C5;

    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let cents: number = midiNote.cents;

    expect(chromaticSymbolicPitch).toEqual(ChromaticSymbolicPitch.C4);
    expect(cents).toEqual(0);
});

test('MidiNote - frequency - C4', () => {
    let midiNote = MidiNote.C4;
    let frequency: number = midiNote.frequency;
    let expected: number = 130.81;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - A4', () => {
    let midiNote = MidiNote.A4;
    let frequency: number = midiNote.frequency;
    let expected: number = 220;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - A5', () => {
    let midiNote = MidiNote.A5;
    let frequency: number = midiNote.frequency;
    let expected: number = 440;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - A0', () => {
    let midiNote = MidiNote.A0;
    let frequency: number = midiNote.frequency;
    let expected: number = 13.75;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - C0', () => {
    let midiNote = MidiNote.C0;
    let frequency: number = midiNote.frequency;
    let expected: number = 8.18;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - B1', () => {
    let midiNote = MidiNote.B2;
    let frequency: number = midiNote.frequency;
    let expected: number = 61.74;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - code - C0', () => {
    let midiNote = MidiNote.C0;
    let code: number = midiNote.code;
    let expected: number = 0;

    expect(code).toEqual(expected);
});

test('MidiNote - chromaticSymbolicPitch - C0', () => {
    let midiNote = MidiNote.C0;
    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let expected: ChromaticSymbolicPitch = ChromaticSymbolicPitch.C_S1;

    expect(chromaticSymbolicPitch).toEqual(expected);
});

test('MidiNote - code - B0', () => {
    let midiNote = MidiNote.B0;
    let code: number = midiNote.code;
    let expected: number = 11;

    expect(code).toEqual(expected);
});

test('MidiNote - code - C1', () => {
    let midiNote = MidiNote.C1;
    let code: number = midiNote.code;
    let expected: number = 12;

    expect(code).toEqual(expected);
});

test('MidiNote - code - A5', () => {
    let midiNote = MidiNote.A5;
    let code: number = midiNote.code;
    let expected: number = 69;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - chromaticSymbolicPitch - A5', () => {
    let midiNote = MidiNote.A5;
    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let expected: ChromaticSymbolicPitch = ChromaticSymbolicPitch.A4;

    expect(chromaticSymbolicPitch).toEqual(expected);
});

test('MidiNote - chromaticSymbolicPitch - C10', () => {
    let midiNote = MidiNote.C10;
    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let expected: ChromaticSymbolicPitch = ChromaticSymbolicPitch.C9;

    expect(chromaticSymbolicPitch).toEqual(expected);
});

test('MidiNote - code - A4', () => {
    let midiNote = MidiNote.A4;
    let code: number = midiNote.code;
    let expected: number = 57;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - code - C5', () => {
    let midiNote = MidiNote.C5;
    let code: number = midiNote.code;
    let expected: number = 60;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - code - C6', () => {
    let midiNote = MidiNote.C6;
    let code: number = midiNote.code;
    let expected: number = 72;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - code - C8', () => {
    let midiNote = MidiNote.C8;
    let code: number = midiNote.code;
    let expected: number = 96;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - code - C9', () => {
    let midiNote = MidiNote.C9;
    let code: number = midiNote.code;
    let expected: number = 108;

    expect(code).toBeCloseTo(expected);
});


test('MidiNote - code - B9', () => {
    let midiNote = MidiNote.B9;
    let code: number = midiNote.code;
    let expected: number = 119;

    expect(code).toBeCloseTo(expected);
});

test('MidiNote - code - C10', () => {
    let midiNote = MidiNote.C10;
    let code: number = midiNote.code;
    let expected: number = 120;

    expect(code).toEqual(expected);
});

test('MidiNote - code - MIN = 0', () => {
    let midiNote = MidiNote.MIN;
    let code: number = midiNote.code;
    let expected: number = 0;

    expect(code).toEqual(expected);
});

test('MidiNote - code - MAX = 127', () => {
    let midiNote = MidiNote.MAX;
    let code: number = midiNote.code;
    let expected: number = 127;

    expect(code).toEqual(expected);
});

test('MidiNote - frequency - G10', () => {
    let midiNote = MidiNote.G10;
    let frequency: number = midiNote.frequency;
    let expected: number = 12543.85;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - frequency - C10', () => {
    let midiNote = MidiNote.C10;
    let frequency: number = midiNote.frequency;
    let expected: number = 8372.02;

    expect(frequency).toBeCloseTo(expected);
});

test('MidiNote - fromCode - 60 = C5', () => {
    let midiNote = MidiNote.fromCode(60);
    let expected: MidiNote = MidiNote.C5;

    expect(midiNote).toEqual(expected);
});

test('MidiNote - fromFrequency - 440 = A5', () => {
    let midiNote = MidiNote.fromFrequency(440);
    let expected: MidiNote = MidiNote.A5;

    expect(midiNote).toEqual(expected);
});

test('MidiNote - fromFrequency - LIMIT_5_SYMMETRIC_N1_440 E5 = E5 + 2 cents', () => {
    let symbolicPitch: SymbolicPitch = ChromaticSymbolicPitch.E5;
    let freq: number = Tuning.LIMIT_5_SYMMETRIC_N1_440.getFrequency(symbolicPitch);
    let midiNote = MidiNote.fromFrequency(freq);
    let expectedDetuned = 2;

    expect(midiNote.chromaticSymbolicPitch).toEqual(symbolicPitch);
    expect(midiNote.cents).toEqual(expectedDetuned);
});

test('MidiNote - fromFrequency - LIMIT_5_SYMMETRIC_N1_440 FF5 = FF5 - 16 cents', () => {
    let symbolicPitch: SymbolicPitch = ChromaticSymbolicPitch.FF5;
    let freq: number = Tuning.LIMIT_5_SYMMETRIC_N1_440.getFrequency(symbolicPitch);
    let midiNote = MidiNote.fromFrequency(freq);
    let expectedCents = -16;

    expect(midiNote.chromaticSymbolicPitch).toEqual(symbolicPitch);
    expect(midiNote.cents).toEqual(expectedCents);
});

test('MidiNote - fromFrequency - 60 ~ 60 ', () => {
    let expected: number = 60;
    let midiNote = MidiNote.fromFrequency(expected);
    let frequency: number = midiNote.frequency;

    expect(frequency).toBeCloseTo(expected, 0);
});

test('MidiNote - fromFrequency - 60 = ChromaticSymbolicPitch.B1 - 49 cents', () => {
    let expected: number = 60;
    let midiNote = MidiNote.fromFrequency(expected);
    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let cents: number = midiNote.cents;

    expect(chromaticSymbolicPitch).toEqual(ChromaticSymbolicPitch.B1);
    expect(cents).toEqual(-49);
});

test('MidiNote - from - A5 -1200 cents', () => {
    let midiNote = MidiNote.from(ChromaticSymbolicPitch.A5, -1200);
    let chromaticSymbolicPitch: ChromaticSymbolicPitch = midiNote.chromaticSymbolicPitch;
    let cents: number = midiNote.cents;

    expect(chromaticSymbolicPitch).toEqual(ChromaticSymbolicPitch.A5);
    expect(cents).toEqual(-1200);
});

test('MidiNote - toString - ENG - 60 Hz', () => {
    Settings.lang = Language.ENG;
    let midiNote = MidiNote.fromFrequency(60);
    let expected ="B2 (-49)";

    expect(midiNote.toString()).toEqual(expected);
});

test('MidiNote - toString - ENG - A5 -1200 cents', () => {
    let midiNote = MidiNote.from(ChromaticSymbolicPitch.A4, -1200);
    let expected ="A5 (-1200)";

    expect(midiNote.toString()).toEqual(expected);
});

test('MidiNote - toString - ESP - 440 Hz', () => {
    Settings.lang = Language.ESP;
    let midiNote = MidiNote.fromFrequency(440);
    let expected ="La5";

    expect(midiNote.toString()).toEqual(expected);
});
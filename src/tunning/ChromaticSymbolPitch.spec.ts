import { Chromatic } from "../degrees/Chromatic";
import * as precalc from "../precalc";
import { ChromaticSymbolicPitch } from "./ChromaticSymbolicPitch";
precalc.chromaticSymbolicPitches();

test('ChromaticSymbolPitch - precalc - C5', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.C5;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let expectedChromatic: Chromatic = Chromatic.C;
    let expectedOctave: number = 5;

    expect(chromatic).toEqual(expectedChromatic);
    expect(octave).toEqual(expectedOctave);
});

test('ChromaticSymbolPitch - precalc - A4', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.A4;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let expectedChromatic: Chromatic = Chromatic.A;
    let expectedOctave: number = 4;

    expect(chromatic).toBe(expectedChromatic);
    expect(octave).toBe(expectedOctave);
});

test('ChromaticSymbolPitch - precalc - C0', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.C0;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let expectedChromatic: Chromatic = Chromatic.C;
    let expectedOctave: number = 0;

    expect(chromatic).toBe(expectedChromatic);
    expect(octave).toBe(expectedOctave);
});

test('ChromaticSymbolPitch - precalc - G8', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.G8;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let expectedChromatic: Chromatic = Chromatic.G;
    let expectedOctave: number = 8;

    expect(chromatic).toBe(expectedChromatic);
    expect(octave).toBe(expectedOctave);
});


test('ChromaticSymbolPitch - precalc - B7', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.B7;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let expectedChromatic: Chromatic = Chromatic.B;
    let expectedOctave: number = 7;

    expect(chromatic).toBe(expectedChromatic);
    expect(octave).toBe(expectedOctave);
});

test('ChromaticSymbolPitch - from - is cached', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.B7;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;
    let octave = chromaticSymbolicPitch.octave;

    let actual: ChromaticSymbolicPitch = ChromaticSymbolicPitch.from(chromatic, octave);

    expect(actual).toBe(chromaticSymbolicPitch);
});

test('ChromaticSymbolPitch - from - not cached value', () => {
    let chromaticSymbolicPitch = ChromaticSymbolicPitch.B7;
    let chromatic: Chromatic = chromaticSymbolicPitch.chromatic;

    let actual: ChromaticSymbolicPitch = ChromaticSymbolicPitch.from(chromatic, 100);
    let actual2: ChromaticSymbolicPitch = ChromaticSymbolicPitch.from(chromatic, 100);

    expect(actual.octave).toBe(100);
    expect(actual.chromatic).toBe(chromatic);
    expect(actual).toBe(actual2);
});
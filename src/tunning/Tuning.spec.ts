import { Chromatic } from "../degrees/Chromatic";
import * as precalc from "../precalc";
import { ConcertPitch } from "./ConcertPitch";
import { Tuning } from "./Tuning";
import { ChromaticSymbolicPitch } from "./ChromaticSymbolicPitch";
precalc.chromatics();
precalc.diatonicAlts();
precalc.chromaticSymbolicPitches();
precalc.concertPitches();
precalc.temperaments();
precalc.tunings();

test('Tuning - EQUAL_440 - A4 = 440', () => {
    let symbolicPitch = ConcertPitch.A440.symbolicPitch;
    let root = Chromatic.A;

    let actual: number = Tuning.EQUAL_440.getFrequency({ root: root, symbolicPitch: symbolicPitch });
    let expected: number = 440;

    expect(actual).toEqual(expected);
});

test('Tuning - EQUAL_440 - C0', () => {
    let symbolicPitch = ChromaticSymbolicPitch.C0;
    let root = Chromatic.A;

    let actual: number = Tuning.EQUAL_440.getFrequency({ root: root, symbolicPitch: symbolicPitch });
    let expected: number =  16.35;

    expect(actual).toBeCloseTo(expected);
});

test('Tuning - EQUAL_440 - AA4', () => {
    let symbolicPitch = ChromaticSymbolicPitch.AA4;
    let root = Chromatic.A;

    let actual: number = Tuning.EQUAL_440.getFrequency({ root: root, symbolicPitch: symbolicPitch });
    let expected: number = 466.16;

    expect(actual).toBeCloseTo(expected);
});

test('Tuning - EQUAL_440 - GG4', () => {
    let symbolicPitch = ChromaticSymbolicPitch.GG4;
    let root = Chromatic.A;

    let actual: number = Tuning.EQUAL_440.getFrequency({ root: root, symbolicPitch: symbolicPitch });
    let expected: number =  415.30;

    expect(actual).toBeCloseTo(expected);
});
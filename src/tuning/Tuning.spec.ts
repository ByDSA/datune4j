import { SPN } from "../pitch/symbolic/SPN";
import * as precalc from "../precalc";
import { ConcertPitch } from "./ConcertPitch";
import { Tuning } from "./Tuning";
precalc.chromatics();
precalc.diatonicAlts();
precalc.spns();
precalc.concertPitches();
precalc.temperaments();
precalc.settings();
precalc.tunings();

test('Tuning - EQUAL_440 - A4 = 440', () => {
    let symbolicPitch = ConcertPitch.A440.symbolicPitch;

    let actual: number = Tuning.EQUAL_440.getFrequency(symbolicPitch);
    let expected: number = 440;

    expect(actual).toEqual(expected);
});

test('Tuning - EQUAL_440 - C0', () => {
    let symbolicPitch = SPN.C0;

    let actual: number = Tuning.EQUAL_440.getFrequency(symbolicPitch);
    let expected: number = 16.35;

    expect(actual).toBeCloseTo(expected);
});

test('Tuning - EQUAL_440 - AA4', () => {
    let symbolicPitch = SPN.AA4;

    let actual: number = Tuning.EQUAL_440.getFrequency(symbolicPitch);
    let expected: number = 466.16;

    expect(actual).toBeCloseTo(expected);
});

test('Tuning - EQUAL_440 - GG4', () => {
    let symbolicPitch = SPN.GG4;

    let actual: number = Tuning.EQUAL_440.getFrequency(symbolicPitch);
    let expected: number = 415.30;

    expect(actual).toBeCloseTo(expected);
});

test('Tuning - LIMIT_5_SYMMETRIC_N1_440 - A4 = 440', () => {
    let symbolicPitch = ConcertPitch.A440.symbolicPitch;

    let actual: number = Tuning.LIMIT_5_SYMMETRIC_N1_440.getFrequency(symbolicPitch);
    let expected: number = 440;

    expect(actual).toEqual(expected);
});

test('Tuning - LIMIT_5_SYMMETRIC_N1_440 - E4 = 330', () => {
    let symbolicPitch = SPN.E4;

    let actual: number = Tuning.LIMIT_5_SYMMETRIC_N1_440.getFrequency(symbolicPitch);
    let expected: number = 330;

    expect(actual).toEqual(expected);
});
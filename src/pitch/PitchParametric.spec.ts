import * as precalc from "../precalc";
import { Tuning } from "../tuning/Tuning";
import { PitchParametric } from "./PitchParametric";
import { SPN as SPN } from "./symbolic/SPN";
precalc.spns();
precalc.tunings();

test('PitchParametric - from - C4 EQUAL_440 = 261.63', () => {
    let chromaticSymbolicPitch = SPN.C4;
    let tuning = Tuning.EQUAL_440;
    let pitchParametric = PitchParametric.from(chromaticSymbolicPitch, tuning);
    let actual = pitchParametric.frequency;
    let expected = 261.63;

    expect(actual).toBeCloseTo(expected);
});

test('PitchParametric - from - C0 EQUAL_440 = 16.35', () => {
    let chromaticSymbolicPitch = SPN.C0;
    let tuning = Tuning.EQUAL_440;
    let pitchParametric = PitchParametric.from(chromaticSymbolicPitch, tuning);
    let actual = pitchParametric.frequency;
    let expected = 16.35;

    expect(actual).toBeCloseTo(expected);
});
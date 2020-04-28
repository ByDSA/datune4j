import { Chromatic } from "../degrees/Chromatic";
import * as precalc from "../precalc";
import { ConcertPitch } from "./ConcertPitch";
import { Tuning } from "./Tuning";
import { SymbolicPitch } from "./SymbolicPitch";
import { ChromaticSymbolicPitch } from "./ChromaticSymbolicPitch";
precalc.concertPitches();
precalc.chromaticSymbolicPitches();

test('ConcertPitch - A440 - symbolicPitch = A4', () => {
    let concertPitch = ConcertPitch.A440;
    let actual: SymbolicPitch = concertPitch.symbolicPitch;
    let expected: SymbolicPitch = ChromaticSymbolicPitch.A4;

    expect(actual).toEqual(expected);
});

test('ConcertPitch - A440 - frequency = 440', () => {
    let concertPitch = ConcertPitch.A440;
    let actual: number = concertPitch.frequency;
    let expected: number = 440;

    expect(actual).toEqual(expected);
});
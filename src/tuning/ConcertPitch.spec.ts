import { SPN } from "../pitch/symbolic/SPN";
import { SymbolicPitch } from "../pitch/symbolic/SymbolicPitch";
import * as precalc from "../precalc";
import { ConcertPitch } from "./ConcertPitch";
precalc.concertPitches();
precalc.spns();

test('ConcertPitch - A440 - symbolicPitch = A4', () => {
    let concertPitch = ConcertPitch.A440;
    let actual: SymbolicPitch = concertPitch.symbolicPitch;
    let expected: SymbolicPitch = SPN.A4;

    expect(actual).toEqual(expected);
});

test('ConcertPitch - A440 - frequency = 440', () => {
    let concertPitch = ConcertPitch.A440;
    let actual: number = concertPitch.frequency;
    let expected: number = 440;

    expect(actual).toEqual(expected);
});
import * as precalc from "../precalc";
import { IntervalPitch } from "./IntervalPitch";
precalc.intervalPitches();

test('IntervalPitch - UNISON - cents', () => {
    let intervalPitch = IntervalPitch.UNISON;
    let actual = intervalPitch.cents;
    let expected: number = 0;

    expect(actual).toEqual(expected);
});

test('IntervalPitch - OCTAVE - cents', () => {
    let intervalPitch = IntervalPitch.OCTAVE;
    let actual = intervalPitch.cents;
    let expected: number = 1200;

    expect(actual).toEqual(expected);
});

test('IntervalPitch - OCTAVE - ratio', () => {
    let intervalPitch = IntervalPitch.OCTAVE;
    let actual = intervalPitch.ratio.value;
    let expected: number = 2;

    expect(actual).toEqual(expected);
});

test('IntervalPitch - CENT - cents', () => {
    let intervalPitch = IntervalPitch.CENT;
    let actual = intervalPitch.cents;
    let expected: number = 1;

    expect(actual).toEqual(expected);
});

test('IntervalPitch - COMMAS - PYTHAGOREAN_COMMA - cents', () => {
    let intervalPitch = IntervalPitch.COMMAS.PYTHAGOREAN_COMMA;
    let actual = intervalPitch.cents;
    let expected: number = 23.46;

    expect(actual).toBeCloseTo(expected);
});

test('IntervalPitch - ET12 - QUARTER_TONE - cents', () => {
    let intervalPitch = IntervalPitch.ET12.QUARTER_TONE;
    let actual = intervalPitch.cents;
    let expected: number = 50;

    expect(actual).toEqual(expected);
});

test('IntervalPitch - JUST - QUARTER_TONE - cents', () => {
    let intervalPitch = IntervalPitch.JUST.QUARTER_TONE;
    let actual = intervalPitch.cents;
    let expected: number = 49.98;

    expect(actual).toBeCloseTo(expected);
});
import * as precalc from "../precalc";
import { MusicalDuration } from "./MusicalDuration";
precalc.musicalDurations();

test('MusicalDuration - precalc - QUARTER', () => {
    let value: number = MusicalDuration.QUARTER.value;

    let expected = 0.25;

    expect(value).toEqual(expected);
});

test('MusicalDuration - precalc - HALF', () => {
    let value: number = MusicalDuration.HALF.value;

    let expected = 0.5;

    expect(value).toEqual(expected);
});

test('MusicalDuration - precalc - WHOLE', () => {
    let value: number = MusicalDuration.WHOLE.value;

    let expected = 1;

    expect(value).toEqual(expected);
});

test('MusicalDuration - precalc - ZERO', () => {
    let value: number = MusicalDuration.ZERO.value;

    let expected = 0;

    expect(value).toEqual(expected);
});

test('MusicalDuration - getAdd - QUARTER + QUARTER = HALF', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.getAdd(MusicalDuration.QUARTER);

    let expected = MusicalDuration.HALF;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getAdd - QUARTER + ZERO = QUARTER', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.getAdd(MusicalDuration.ZERO);

    let expected = MusicalDuration.QUARTER;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getSub - HALF - QUARTER = QUARTER', () => {
    let actual: MusicalDuration = MusicalDuration.HALF.getSub(MusicalDuration.QUARTER);

    let expected = MusicalDuration.QUARTER;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getSub - QUARTER - QUARTER = ZERO', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.getSub(MusicalDuration.QUARTER);

    let expected = MusicalDuration.ZERO;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getMult - QUARTER * 3 = WHOLE-QUARTER', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.getMult(3);

    let expected = MusicalDuration.WHOLE.getSub(MusicalDuration.QUARTER);

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getDiv - WHOLE / 4 = QUARTER', () => {
    let actual: MusicalDuration = MusicalDuration.WHOLE.getDiv(4);

    let expected = MusicalDuration.QUARTER;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - dotted - QUARTER.dotted = QUARTER + EIGHTH', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.dotted;

    let expected = MusicalDuration.QUARTER.getAdd(MusicalDuration.EIGHTH);

    expect(actual).toEqual(expected);
});

test('MusicalDuration - dotted - QUARTER.dotted.dotted = 2*QUARTER + SIXTEENTH', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.dotted.dotted;

    let expected = MusicalDuration.QUARTER.getMult(2).getAdd(MusicalDuration.SIXTEENTH);

    expect(actual).toEqual(expected);
});

test('MusicalDuration - dotted - QUARTER.triplet*3 = 2*QUARTER', () => {
    let actual: MusicalDuration = MusicalDuration.QUARTER.triplet.getMult(3);

    let expected = MusicalDuration.QUARTER.getMult(2);

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getDivCell - WHOLE div QUARTER.dotted = 2', () => {
    let actual: number = MusicalDuration.WHOLE.getDivCell(MusicalDuration.QUARTER.dotted);

    let expected = 2;

    expect(actual).toEqual(expected);
});

test('MusicalDuration - getDivCell - WHOLE div ZERO', () => {
    let actual: number = MusicalDuration.WHOLE.getDivCell(MusicalDuration.ZERO);

    let expected = Infinity;

    expect(actual).toEqual(expected);
});


test('MusicalDuration - isBetween - QUARTER < QUARTER.dotted < HALF', () => {
    let actual: boolean = MusicalDuration.QUARTER.dotted.isBetween(MusicalDuration.QUARTER, MusicalDuration.HALF);

    let expected = true;

    expect(actual).toEqual(expected);
});

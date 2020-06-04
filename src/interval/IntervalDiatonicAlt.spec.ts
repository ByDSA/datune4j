import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { IntervalDiatonic } from './IntervalDiatonic';
import { IntervalDiatonicAlt } from './IntervalDiatonicAlt';
import { Quality } from './Quality';
precalc.settings();
precalc.chromatics();
precalc.diatonicAlts();
precalc.intervalDiatonicAlts();

test('IntervalDiatonicAlt - fromRootNotes: get from ImmutableCache', () => {
    let intervalDiatonicAlt = IntervalDiatonicAlt.between(DiatonicAlt.C, DiatonicAlt.E)
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - Gb to D#: DOUBLY DIMINISHED FIFTH', () => {
    let a = DiatonicAlt.Gb;
    let b = DiatonicAlt.DD;
    let intervalDiatonicAlt = IntervalDiatonicAlt.between(a, b);
    let expected = IntervalDiatonicAlt.DOUBLY_AUGMENTED_FIFTH;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - D# to Gb: DOUBLY DIMINISHED FIFTH', () => {
    let a = DiatonicAlt.DD;
    let b = DiatonicAlt.Gb;
    let intervalDiatonicAlt = IntervalDiatonicAlt.between(a, b);
    let expected = IntervalDiatonicAlt.DOUBLY_DIMINISHED_FOURTH;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - A to A#: ', () => {
    let a = DiatonicAlt.A;
    let b = DiatonicAlt.AA;
    let intervalDiatonicAlt = IntervalDiatonicAlt.between(a, b);
    let expected = IntervalDiatonicAlt.AUGMENTED_UNISON;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('fromIntervalQuality - M3 ', () => {
    let actual = IntervalDiatonicAlt.from(IntervalDiatonic.THIRD, Quality.MAJOR);
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(actual).toBe(expected);
});

test('fromIntervalQuality - M10 ', () => {
    let actual = IntervalDiatonicAlt.from(IntervalDiatonic.TENTH, Quality.MAJOR);
    let expected = IntervalDiatonicAlt.MAJOR_TENTH;
    expect(actual).toBe(expected);
});

test('fromString - M3 ', () => {
    let actual = IntervalDiatonicAlt.fromString("M3");
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(actual).toBe(expected);
});

test('fromString - M10 ', () => {
    let actual = IntervalDiatonicAlt.fromString("M10");
    let expected = IntervalDiatonicAlt.MAJOR_TENTH;
    expect(actual).toBe(expected);
});

test('fromString - M17 ', () => {
    let actual = IntervalDiatonicAlt.fromString("M17");
    let expected = IntervalDiatonicAlt.from(IntervalDiatonic.from(17-1), Quality.MAJOR);
    expect(actual).toBe(expected);
});
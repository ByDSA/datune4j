import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { IntervalDiatonicAlt } from './IntervalDiatonicAlt';
precalc.chromatics();
precalc.diatonicAlts();
precalc.intervalDiatonicAlts();

test('IntervalDiatonicAlt - fromRootNotes: get from ImmutableCache', () => {
    let intervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(DiatonicAlt.C, DiatonicAlt.E)
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - Gb to D#: DOUBLY DIMINISHED FIFTH', () => {
    let a = DiatonicAlt.Gb;
    let b = DiatonicAlt.DD;
    let intervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(a, b);
    let expected = IntervalDiatonicAlt.DOUBLY_AUGMENTED_FIFTH;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - D# to Gb: DOUBLY DIMINISHED FIFTH', () => {
    let a = DiatonicAlt.DD;
    let b = DiatonicAlt.Gb;
    let intervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(a, b);
    let expected = IntervalDiatonicAlt.DOUBLY_DIMINISHED_FOURTH;
    expect(intervalDiatonicAlt).toBe(expected);
});

test('IntervalDiatonicAlt - A to A#: ', () => {
    let a = DiatonicAlt.A;
    let b = DiatonicAlt.AA;
    let intervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(a, b);
    let expected = IntervalDiatonicAlt.AUGMENTED_UNISON;
    expect(intervalDiatonicAlt).toBe(expected);
});
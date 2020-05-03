import { Chromatic } from "../degrees/Chromatic";
import { DiatonicAlt } from "../degrees/DiatonicAlt";
import { IntervalDiatonicAlt } from "../interval/IntervalDiatonicAlt";
import * as precalc from "../precalc";
import { IntervalPitch } from "./IntervalPitch";
import { Temperament } from "./Temperament";
precalc.chromatics();
precalc.diatonicAlts();
precalc.temperaments();

test('Temperament - EQUAL - root ratio - Chromatic.C', () => {
    let note = Chromatic.C;
    let root = Chromatic.C;

    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenChromatic(root, note);
    let actualIntervalPitch: IntervalPitch = Temperament.ET12.getIntervalPitch(intervalDiatonicAlt);
    let actual: number = actualIntervalPitch.ratio.value;
    let expected: number = 1;

    expect(actual).toEqual(expected);
});

test('Temperament - EQUAL - root ratio - DiatonicAlt.C', () => {
    let note = DiatonicAlt.C;
    let root = DiatonicAlt.C;
    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(root, note);
    let actual: number = Temperament.ET12.getIntervalPitch(intervalDiatonicAlt).ratio.value;
    let expected: number = 1;

    expect(actual).toEqual(expected);
});

test('Temperament - EQUAL - root ratio - DiatonicAlt.G', () => {
    let note = DiatonicAlt.G;
    let root = DiatonicAlt.C;
    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(root, note);
    let actual: number = Temperament.ET12.getIntervalPitch(intervalDiatonicAlt).ratio.value;
    let expected: number = 1.498307;

    expect(actual).toBeCloseTo(expected);
});

test('Temperament - EQUAL - root ratio - note= DiatonicAlt.C, root = DiatonicAlt.G', () => {
    let note = DiatonicAlt.C;
    let root = DiatonicAlt.G;

    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(root, note);
    let actual: number = Temperament.ET12.getIntervalPitch(intervalDiatonicAlt).ratio.value;
    let expected: number = 1.334840;

    expect(actual).toBeCloseTo(expected);
});

test('Temperament - EQUAL - root ratio - note= DiatonicAlt.CCC, root = DiatonicAlt.GGG', () => {
    let note = DiatonicAlt.CCC;
    let root = DiatonicAlt.GGG;

    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(root, note);
    let actual: number = Temperament.ET12.getIntervalPitch(intervalDiatonicAlt).ratio.value;
    let expected: number = 1.334840;

    expect(actual).toBeCloseTo(expected);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - P5 = 1.5', () => {
    let note = DiatonicAlt.E;
    let root = DiatonicAlt.A;

    let intervalDiatonicAlt: IntervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(root, note);
    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(intervalDiatonicAlt).ratio.value;
    let expected: number = 1.5;

    expect(actual).toEqual(expected);
});


test('Temperament - LIMIT_5_SYMMETRIC_N1 - UNISON - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_UNISON;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 0;

    expect(actual).toEqual(expected);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MINOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SECOND;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 112;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MAJOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SECOND;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 204;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N2 - MAJOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SECOND;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N2.getIntervalPitch(interval).cents;
    let expected: number = 182;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MINOR THIRD - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_THIRD;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 316;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MAJOR THIRD - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_THIRD;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 386;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - PERFECT FOURTH - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_FOURTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 498;

    expect(actual).toBeCloseTo(expected, 0);
});


test('Temperament - LIMIT_5_SYMMETRIC_N1 - AUGMENTED FOURTH - cents', () => {
    let interval = IntervalDiatonicAlt.AUGMENTED_FOURTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 590;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - PERFECT FIFTH - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_FIFTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 702;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MINOR SIXTH - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SIXTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 814;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MAJOR SIXTH - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SIXTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 884;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MINOR SEVENTH - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SEVENTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 996;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N2 - MINOR SEVENTH - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SEVENTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N2.getIntervalPitch(interval).cents;
    let expected: number = 1018;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - LIMIT_5_SYMMETRIC_N1 - MAJOR SEVENTH - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SEVENTH;

    let actual: number = Temperament.LIMIT_5_SYMMETRIC_N1.getIntervalPitch(interval).cents;
    let expected: number = 1088;

    expect(actual).toBeCloseTo(expected, 0);
});


/* PYTHAGOREAN */

test('Temperament - PYTHAGOREAN - MINOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_UNISON;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 0;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MINOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SECOND;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 90;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MAJOR SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SECOND;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 204;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MINOR THIRD - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_THIRD;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 294;

    expect(actual).toBeCloseTo(expected, 0);
});


test('Temperament - PYTHAGOREAN - AUGMENTED SECOND - cents', () => {
    let interval = IntervalDiatonicAlt.AUGMENTED_SECOND;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 318;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MAJOR THIRD - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_THIRD;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 408;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - DIMINISHED FOURTH - cents', () => {
    let interval = IntervalDiatonicAlt.DIMINISHED_FOURTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 384;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - PERFECT FOURTH - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_FOURTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 498;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - AUGMENTED THIRD - cents', () => {
    let interval = IntervalDiatonicAlt.AUGMENTED_THIRD;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 522;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - AUGMENTED FOURTH - cents', () => {
    let interval = IntervalDiatonicAlt.AUGMENTED_FOURTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 612;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - DIMINISHED FIFTH - cents', () => {
    let interval = IntervalDiatonicAlt.DIMINISHED_FIFTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 588;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - PERFECT FIFTH - cents', () => {
    let interval = IntervalDiatonicAlt.PERFECT_FIFTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 702;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - DIMINISHED SIXTH - cents', () => {
    let interval = IntervalDiatonicAlt.DIMINISHED_SIXTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 678;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MINOR SIXTH - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SIXTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 792;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MAJOR SIXTH - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SIXTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 906;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MINOR SEVENTH - cents', () => {
    let interval = IntervalDiatonicAlt.MINOR_SEVENTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 996;

    expect(actual).toBeCloseTo(expected, 0);
});

test('Temperament - PYTHAGOREAN - MAJOR SEVENTH - cents', () => {
    let interval = IntervalDiatonicAlt.MAJOR_SEVENTH;

    let actual: number = Temperament.PYTHAGOREAN.getIntervalPitch(interval).cents;
    let expected: number = 1110;

    expect(actual).toBeCloseTo(expected, 0);
});
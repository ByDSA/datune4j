import { Chromatic } from "../degrees/Chromatic";
import { DiatonicAlt } from "../degrees/DiatonicAlt";
import { IntervalDiatonicAlt } from "../interval/IntervalDiatonicAlt";
import * as precalc from "../precalc";
import { Temperament } from "./Temperament";
import { IntervalPitch } from "../interval/IntervalPitch";
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
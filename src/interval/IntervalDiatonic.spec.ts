import * as precalc from "../precalc";
import { IntervalDiatonic } from "./IntervalDiatonic";
import { Settings } from "../settings/Settings";
import { Language } from "../lang/Language";
precalc.intervalDiatonics();

test('IntervalDiatonic - precalc - UNISON', () => {
    let actual: IntervalDiatonic = IntervalDiatonic.from(0);
    let expected = IntervalDiatonic.UNISON;

    expect(actual).toEqual(expected);
});

test('IntervalDiatonic - intValue - UNISON', () => {
    let actual: IntervalDiatonic = IntervalDiatonic.UNISON.intValue;
    let expected = 0;

    expect(actual).toEqual(expected);
});

test('IntervalDiatonic - intValue - OCTAVE', () => {
    let actual: IntervalDiatonic = IntervalDiatonic.OCTAVE.intValue;
    let expected = 7;

    expect(actual).toEqual(expected);
});

test('IntervalDiatonic - from - uncached', () => {
    let actual: IntervalDiatonic = IntervalDiatonic.from(1234);
    let expected = IntervalDiatonic.from(1234);

    expect(actual).toEqual(expected);
});

test('IntervalDiatonic - from - uncached 17', () => {
    let actual: IntervalDiatonic = IntervalDiatonic.from(17);
    let expected = IntervalDiatonic.from(17);

    expect(actual).toEqual(expected);
});

test('toString() - ENG', () => {
    Settings.lang = Language.ENG;

    let actual: string = IntervalDiatonic.UNISON.toString();
    let expected = "UNISON";

    expect(actual).toEqual(expected);
});
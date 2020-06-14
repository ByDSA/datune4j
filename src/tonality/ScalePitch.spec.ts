import * as precalc from "../precalc";
import { IntervalPitch } from "../tuning/IntervalPitch";
import { ScalePitch } from "./ScalePitch";
precalc.scalePitches();
precalc.intervalPitches();

test('precalc - MAJOR 12-ET', () => {
    let scale = ScalePitch.MAJOR_ET12;

    expect(scale).toBe(ScalePitch.MAJOR_ET12);
});

test('intervals: MAJOR ET-12', () => {
    let scale = ScalePitch.MAJOR_ET12;
    let intervals = scale.intervals;
    expect(intervals).toStrictEqual([
        IntervalPitch.UNISON,
        IntervalPitch.ET12.MAJOR_SECOND,
        IntervalPitch.ET12.MAJOR_THIRD,
        IntervalPitch.ET12.PERFECT_FOURTH,
        IntervalPitch.ET12.PERFECT_FIFTH,
        IntervalPitch.ET12.MAJOR_SIXTH,
        IntervalPitch.ET12.MAJOR_SEVENTH,
    ]);
});

test('intervals: MAJOR PYTHAGOREAN', () => {
    let scale = ScalePitch.MAJOR_PYTHAGOREAN;
    let intervals = scale.intervals;
    expect(intervals).toStrictEqual([
        IntervalPitch.UNISON,
        IntervalPitch.PYTHAGOREAN.MAJOR_SECOND,
        IntervalPitch.PYTHAGOREAN.MAJOR_THIRD,
        IntervalPitch.PYTHAGOREAN.PERFECT_FOURTH,
        IntervalPitch.PYTHAGOREAN.PERFECT_FIFTH,
        IntervalPitch.PYTHAGOREAN.MAJOR_SIXTH,
        IntervalPitch.PYTHAGOREAN.MAJOR_SEVENTH,
    ]);
});
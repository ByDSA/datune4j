import { Scale } from "./Scale";
import * as precalc from "../precalc";
precalc.scales();
precalc.settings();

test('Scale: ', () => {
    let scale = Scale.MAJOR;

    expect(scale).toBe(Scale.MAJOR);
});

test('Scale: intervals not null or undefined', () => {
    for (let scale of Scale.all()) {
        expect(scale.intervals).not.toBe(null);
    }
});

test('Scale: absoluteIntervals not null or undefined', () => {
    for (let scale of Scale.all()) {
        expect(scale.absoluteIntervals).not.toBe(null);
    }
});

test('Scale - toString: all have string', () => {
    for (let scale of Scale.all()) {
        expect(scale.toString()).not.toBe(null);
        expect(scale.toString()).not.toBe(undefined);
    }
});
import { ScalePrecalc } from './ScalePrecalc';

test('Scale: ', () => {
    let scale = ScalePrecalc.MAJOR;

    expect(scale).toBe(ScalePrecalc.MAJOR);
});

test('Scale: intervals not null or undefined', () => {
    for (let scale of ScalePrecalc.all) {
        expect(scale.intervals).not.toBe(null);
        expect(scale.intervals).not.toBe(undefined);
    }
});

test('Scale: absoluteIntervals not null or undefined', () => {
    for (let scale of ScalePrecalc.all) {
        expect(scale.absoluteIntervals).not.toBe(null);
        expect(scale.absoluteIntervals).not.toBe(undefined);
    }
});

test('Scale - toString: all have string', () => {
    for (let scale of ScalePrecalc.all) {
        expect(scale.toString()).not.toBe(null);
        expect(scale.toString()).not.toBe(undefined);
    }
});
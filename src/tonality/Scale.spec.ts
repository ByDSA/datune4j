import { Scale } from './Scale';

test('Scale: ', () => {
    let scale = Scale.MAJOR;

    expect(scale).toBe(Scale.MAJOR);
});

test('Scale: intervals not null or undefined', () => {
    for (let scale of Scale.all) {
        expect(scale.intervals).not.toBe(null);
        expect(scale.intervals).not.toBe(undefined);
    }
});

test('Scale: absoluteIntervals not null or undefined', () => {
    for (let scale of Scale.all) {
        expect(scale.absoluteIntervals).not.toBe(null);
        expect(scale.absoluteIntervals).not.toBe(undefined);
    }
});
import { MathUtils } from './MathUtils';

test('MathUtils - rotativeTrim: does nothing', () => {
    let n = 7;
    let limit = 12;

    expect(MathUtils.rotativeTrim(n, limit)).toBe(7);
});

test('MathUtils - rotativeTrim: over limit', () => {
    let n = 14;
    let limit = 12;

    expect(MathUtils.rotativeTrim(n, limit)).toBe(2);
});

test('MathUtils - rotativeTrim: below 0', () => {
    let n = -1;
    let limit = 12;

    expect(MathUtils.rotativeTrim(n, limit)).toBe(11);
});
import * as precalc from "../precalc";
import { Chromatic } from './Chromatic';
precalc.chromatics();

test('Chromatic - intValues ', () => {
    expect(Chromatic.C.intValue).toBe(0);
    expect(Chromatic.CC.intValue).toBe(1);
    expect(Chromatic.D.intValue).toBe(2);
    expect(Chromatic.DD.intValue).toBe(3);
    expect(Chromatic.E.intValue).toBe(4);
    expect(Chromatic.F.intValue).toBe(5);
    expect(Chromatic.FF.intValue).toBe(6);
    expect(Chromatic.G.intValue).toBe(7);
    expect(Chromatic.GG.intValue).toBe(8);
    expect(Chromatic.A.intValue).toBe(9);
    expect(Chromatic.AA.intValue).toBe(10);
    expect(Chromatic.B.intValue).toBe(11);
});

test('Chromatic - fromInt ', () => {
    expect(Chromatic.fromInt(0)).toBe(Chromatic.C);
    expect(Chromatic.fromInt(1)).toBe(Chromatic.CC);
    expect(Chromatic.fromInt(2)).toBe(Chromatic.D);
    expect(Chromatic.fromInt(3)).toBe(Chromatic.DD);
    expect(Chromatic.fromInt(4)).toBe(Chromatic.E);
    expect(Chromatic.fromInt(5)).toBe(Chromatic.F);
    expect(Chromatic.fromInt(6)).toBe(Chromatic.FF);
    expect(Chromatic.fromInt(7)).toBe(Chromatic.G);
    expect(Chromatic.fromInt(8)).toBe(Chromatic.GG);
    expect(Chromatic.fromInt(9)).toBe(Chromatic.A);
    expect(Chromatic.fromInt(10)).toBe(Chromatic.AA);
    expect(Chromatic.fromInt(11)).toBe(Chromatic.B);
});
import * as precalc from "../precalc";
import { Chromatic } from "./Chromatic";
import { Diatonic } from "./Diatonic";
precalc.chromatics();
precalc.diatonics();

test('Diatonic - chromatic: B ', () => {
    expect(Diatonic.B.chromatic).toBe(Chromatic.B);
});

test('Diatonic - chromatic: C ', () => {
    expect(Diatonic.C.chromatic).toBe(Chromatic.C);
});

test('Diatonic - chromatic: A ', () => {
    expect(Diatonic.A.chromatic).toBe(Chromatic.A);
});
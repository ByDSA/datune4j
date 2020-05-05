import * as precalc from "../precalc";
import { Chromatic } from "../degrees/Chromatic";
import { DiatonicAlt } from "../degrees/DiatonicAlt";
import { RelativePitch } from "./RelativePitch";
precalc.chromatics();
precalc.diatonicAlts();

test('from - C 0', () => {
    let degree = Chromatic.C;
    let octaveRelative = 0;
    let actual = RelativePitch.from(degree, octaveRelative);

    expect(actual.octaveRelative).toEqual(octaveRelative);
    expect(actual.degree).toEqual(degree);
});

test('from - Bb 2', () => {
    let degree = DiatonicAlt.Bb;
    let octaveRelative = 2;
    let actual = RelativePitch.from(degree, octaveRelative);

    expect(actual.octaveRelative).toEqual(octaveRelative);
    expect(actual.degree).toEqual(degree);
});
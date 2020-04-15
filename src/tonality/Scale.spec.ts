import { DiatonicAltDegree } from "../degrees/scale/DiatonicAltDegree";
import { DiatonicDegree } from "../degrees/scale/DiatonicDegree";
import { DegreeFunction } from "../function/DegreeFunction";
import * as precalc from "../precalc";
import { Scale } from "./Scale";
precalc.scales();
precalc.diatonics();
precalc.chromatics();
precalc.diatonicAltDegrees();
precalc.diatonicAltChordPatterns();
precalc.settings();
precalc.diatonicDegrees();
precalc.degreeFunctions();

test('Scale: ', () => {
    let scale = Scale.MAJOR;

    expect(scale).toBe(Scale.MAJOR);
});

test('Scale: degrees not null or undefined', () => {
    for (let scale of Scale.sets.all()) {
        expect(scale.degrees).not.toBeNull();
    }
});

test('Scale - degrees: MAJOR', () => {
    let scale = Scale.MAJOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI,
        DiatonicAltDegree.VII
    ]);
});

test('Scale - degrees: MINOR', () => {
    let scale = Scale.MINOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVI,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - degrees: BLUES_b5', () => {
    let scale = Scale.BLUES_b5;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.bV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - degrees: BLUES_a4', () => {
    let scale = Scale.BLUES_a4;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.from(DiatonicDegree.IV, 1),
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - toString: all have string', () => {
    for (let scale of Scale.sets.all()) {
        expect(scale.toString()).not.toBeNull();
        expect(scale.toString()).not.toBeUndefined();
    }
});

test('Scale - degreeFunctions: MAJOR', () => {
    let scale = Scale.MAJOR;
    let degreeFunctions: DegreeFunction[] = scale.degreeFunctions;
    let someFunctions = [
        DegreeFunction.I,
        DegreeFunction.ISUS4,
        DegreeFunction.ii,
        DegreeFunction.iii,
        DegreeFunction.IV,
        DegreeFunction.V,
        DegreeFunction.VSUS4,
        DegreeFunction.vi,
        DegreeFunction.VII0,
    ];

    expect([1, 2, 3, 4]).toEqual(expect.arrayContaining([1, 2]));

    expect(degreeFunctions).toEqual(expect.arrayContaining(someFunctions));
});
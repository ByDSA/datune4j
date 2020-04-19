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


test('Scale - degrees: pentatonic minor', () => {
    let scale = Scale.PENTATONIC_MINOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - degrees: pentatonic', () => {
    let scale = Scale.PENTATONIC;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI
    ]);
});

test('Scale - degrees: egypcian', () => {
    let scale = Scale.EGYPCIAN;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - degrees: blues minor', () => {
    let scale = Scale.BLUES_MINOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.bVI,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - degrees: blues major', () => {
    let scale = Scale.BLUES_MAJOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI
    ]);
});

test('Scale - set all: contains BLUES_a4', () => {
    expect(Scale.sets.all().includes(Scale.BLUES_a4)).toBe(true);
});

test('Scale - degrees: BEBOP DOMINANT', () => {
    let scale = Scale.BEBOP_DOMINANT;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI,
        DiatonicAltDegree.bVII,
        DiatonicAltDegree.VII,
    ]);
});

test('Scale - degrees: BLUES_b5, mode V', () => {
    let scale = Scale.BLUES_b5.modes[4];
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.bVI,
        DiatonicAltDegree.bVII,
        DiatonicAltDegree.from(DiatonicDegree.I, -1),
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
    expect(degreeFunctions).toEqual(expect.arrayContaining(someFunctions));
});

test('Scale - degreeFunctions: MINOR', () => {
    let scale = Scale.MINOR;
    let degreeFunctions: DegreeFunction[] = scale.degreeFunctions;
    let someFunctions = [
        DegreeFunction.i,
        DegreeFunction.II0,
        DegreeFunction.bIII,
        DegreeFunction.iv,
        DegreeFunction.v,
        DegreeFunction.bVI,
        DegreeFunction.bVII,
    ];
    expect(degreeFunctions).toEqual(expect.arrayContaining(someFunctions));
});
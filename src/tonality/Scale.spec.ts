import { DiatonicAltDegree } from "../degrees/scale/DiatonicAltDegree";
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

test('Scale: distances not null or undefined', () => {
    for (let scale of Scale.all()) {
        expect(scale.distances).not.toBeNull();
    }
});

test('Scale: absoluteIntervals not null or undefined', () => {
    for (let scale of Scale.all()) {
        expect(scale.absoluteIntervals).not.toBeNull();
    }
});

test('Scale - absoluteIntervals: MAJOR', () => {
    let scale = Scale.MAJOR;
    let absoluteIntervals = scale.absoluteIntervals;
    expect(absoluteIntervals).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI,
        DiatonicAltDegree.VII
    ]);
});

test('Scale - absoluteIntervals: MINOR', () => {
    let scale = Scale.MINOR;
    let absoluteIntervals = scale.absoluteIntervals;
    expect(absoluteIntervals).toStrictEqual([
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVI,
        DiatonicAltDegree.bVII
    ]);
});

test('Scale - absoluteDistances: MAJOR', () => {
    let scale = Scale.MAJOR;
    let absoluteDistances: number[] = scale.absoluteDistances;
    expect(absoluteDistances).toStrictEqual([
        0,
        2,
        4,
        5,
        7,
        9,
        11
    ]);
});

test('Scale - absoluteDistances: MINOR', () => {
    let scale = Scale.MINOR;
    let absoluteDistances: number[] = scale.absoluteDistances;
    expect(absoluteDistances).toStrictEqual([
        0,
        2,
        3,
        5,
        7,
        8,
        10
    ]);
});

test('Scale - toString: all have string', () => {
    for (let scale of Scale.all()) {
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
        DegreeFunction.III,
        DegreeFunction.IV,
        DegreeFunction.V,
        DegreeFunction.VSUS4,
        DegreeFunction.vi,
        DegreeFunction.VII0,
    ]
    for (const degreeFunction of someFunctions)
        expect(degreeFunctions).toContainEqual(degreeFunction);
});
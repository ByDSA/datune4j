import { DiatonicAltDegree } from "../degrees/scale/DiatonicAltDegree";
import { DiatonicDegree } from "../degrees/scale/DiatonicDegree";
import * as precalc from "../precalc";
import { Scale } from "../tonality/Scale";
import { ScaleDegreeComparator } from "./ScaleDegreeComparator";
precalc.scales();
precalc.diatonicAltDegrees();

test('ScaleDegreeComparator: Scale.MAJOR and itself nonenharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.MAJOR, Scale.MAJOR], false);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;

    let expected = [
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI,
        DiatonicAltDegree.VII,
    ];

    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});

test('ScaleDegreeComparator: Scale.MAJOR and itself enharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.MAJOR, Scale.MAJOR], true);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;
    
    let expected = [
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.III,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.VI,
        DiatonicAltDegree.VII,
    ];

    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});

test('ScaleDegreeComparator: Scale.MAJOR and Scale.MINOR nonenharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.MAJOR, Scale.MINOR], false);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;
    
    let expected = [
        DiatonicAltDegree.I,
        DiatonicAltDegree.II,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.V
    ];

    expect(common.size).toEqual(4);
    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});

test('ScaleDegreeComparator: Scale.LYDIAN and Scale.LOCRIAN nonenharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.LYDIAN, Scale.LOCRIAN], false);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;
    
    let expected = [
        DiatonicAltDegree.I
    ];

    expect(common.size).toEqual(1);
    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});

test('ScaleDegreeComparator: Scale.LYDIAN and Scale.LOCRIAN enharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.LYDIAN, Scale.LOCRIAN], true);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;
    
    let expected = [
        DiatonicAltDegree.I,
        DiatonicAltDegree.from(DiatonicDegree.IV, 1),
        DiatonicAltDegree.from(DiatonicDegree.V, -1),
    ];

    expect(common.size).toEqual(3);
    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});

test('ScaleDegreeComparator: Scale.BLUES_b5 and Scale.BLUES_a4 enharmonic', () => {
    let scaleComparator = ScaleDegreeComparator.from([Scale.BLUES_b5, Scale.BLUES_a4], true);
    scaleComparator.calculate();
    let common: Set<DiatonicAltDegree> = scaleComparator.common;
    
    let expected = [
        DiatonicAltDegree.I,
        DiatonicAltDegree.bIII,
        DiatonicAltDegree.IV,
        DiatonicAltDegree.from(DiatonicDegree.IV, 1),
        DiatonicAltDegree.bV,
        DiatonicAltDegree.V,
        DiatonicAltDegree.bVII,
    ];

    expect(common.size).toEqual(7);
    for (const degree of expected)
        expect(common.has(degree)).toEqual(true);
});
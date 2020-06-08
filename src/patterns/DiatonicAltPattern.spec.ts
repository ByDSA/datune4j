import { IntervalDiatonicAlt } from "../interval/IntervalDiatonicAlt";
import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { DiatonicAltPattern } from "./DiatonicAltPattern";
import { ChromaticPattern } from "./ChromaticPattern";
import { DiatonicPattern } from "./DiatonicPattern";
precalc.diatonicAltPatterns();
precalc.diatonicAltChords();
precalc.intervalDiatonicAlts();
precalc.settings();

test('from - immutable: 0, 4, 7', () => {
    let diatonicAltPattern = DiatonicAltPattern.from(IntervalDiatonicAlt.PERFECT_UNISON, IntervalDiatonicAlt.MAJOR_THIRD, IntervalDiatonicAlt.PERFECT_FIFTH);
    expect(diatonicAltPattern).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('from - immutable new pattern: 0, 1', () => {
    let diatonicAltPattern = DiatonicAltPattern.from(IntervalDiatonicAlt.PERFECT_UNISON, IntervalDiatonicAlt.MINOR_SECOND);
    let diatonicAltPattern2 = DiatonicAltPattern.from(IntervalDiatonicAlt.PERFECT_UNISON, IntervalDiatonicAlt.MINOR_SECOND);
    expect(diatonicAltPattern2).toBe(diatonicAltPattern);
});

test('getInv: TRIAD MAJOR + 2inv', () => {
    let diatonicAltPattern = DiatonicAltPattern.TRIAD_MAJOR.getInv(2);
    let expected = DiatonicAltPattern.from(IntervalDiatonicAlt.PERFECT_UNISON, IntervalDiatonicAlt.PERFECT_FOURTH, IntervalDiatonicAlt.MAJOR_SIXTH);
    expect(diatonicAltPattern).toBe(expected);
});

test('toString ENG: TRIAD MAJOR', () => {
    Settings.lang = Language.ENG;
    let str = DiatonicAltPattern.TRIAD_MAJOR.toString();
    let expected = "MAJOR";
    expect(str).toBe(expected);
});

test('toString ESP: TRIAD MAJOR', () => {
    Settings.lang = Language.ESP;
    let str = DiatonicAltPattern.TRIAD_MAJOR.toString();
    let expected = "MAYOR";
    expect(str).toBe(expected);
});


test('fromString - ESP - "m" = TRIAD_MINOR', () => {
    Settings.lang = Language.ESP;
    expect(DiatonicAltPattern.fromString("m")).toBe(DiatonicAltPattern.TRIAD_MINOR);
});

test('fromString - ESP - " " = TRIAD_MAJOR', () => {
    Settings.lang = Language.ESP;
    expect(DiatonicAltPattern.fromString(" ")).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('fromString - ESP - "MAyOR" = TRIAD_MAJOR', () => {
    Settings.lang = Language.ESP;
    expect(DiatonicAltPattern.fromString("MAyOR")).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('fromString - ENG - "m" = TRIAD_MINOR', () => {
    Settings.lang = Language.ENG;
    expect(DiatonicAltPattern.fromString("m")).toBe(DiatonicAltPattern.TRIAD_MINOR);
});

test('fromString - ENG - " " = TRIAD_MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(DiatonicAltPattern.fromString(" ")).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('fromString - ENG - "MAjOR" = TRIAD_MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(DiatonicAltPattern.fromString("MAjOR")).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('precalc - SEVENTH MAJ7 b5', () => {
    let chromaticPattern = ChromaticPattern.from(0, 4, 6, 11);
    let diatonicAltPattern = DiatonicAltPattern.fromPatterns(chromaticPattern, DiatonicPattern.SEVENTH);
    let expected = DiatonicAltPattern.SEVENTH_MAJ7_b5;
    expect(diatonicAltPattern).toBe(expected);
});

test('shortName - ENG - SEVENTH MAJ7 b5', () => {
    Settings.lang = Language.ENG;
    let actual = DiatonicAltPattern.SEVENTH_MAJ7_b5.shortName;
    let expected = "Maj7♭5";
    expect(actual).toBe(expected);
});

test('toString() - ENG - SEVENTH MAJ7 b5', () => {
    Settings.lang = Language.ENG;
    let actual = DiatonicAltPattern.SEVENTH_MAJ7_b5.toString();
    let expected = "SEVENTH MAJ7 ♭5";
    expect(actual).toBe(expected);
});

test('shortName - ESP - SEVENTH MAJ7 b5', () => {
    Settings.lang = Language.ESP;
    let actual = DiatonicAltPattern.SEVENTH_MAJ7_b5.shortName;
    let expected = "Maj7♭5";
    expect(actual).toBe(expected);
});

test('toString() - ESP - SEVENTH MAJ7 b5', () => {
    Settings.lang = Language.ESP;
    let actual = DiatonicAltPattern.SEVENTH_MAJ7_b5.toString();
    let expected = "SÉPTIMA MAJ7 ♭5";
    expect(actual).toBe(expected);
});
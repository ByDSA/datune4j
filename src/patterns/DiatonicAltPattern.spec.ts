import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { ChromaticPattern } from "./ChromaticPattern";
import { DiatonicAltPattern } from "./DiatonicAltPattern";
import { IntervalDiatonicAlt } from "../interval/IntervalDiatonicAlt";
precalc.diatonicAltPatterns();
precalc.diatonicAltChords();
precalc.intervalDiatonicAlts();

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

test('ChromaticChord - getInv: TRIAD MAJOR + 3inv = TRIAD MAJOR', () => {
    let chromaticPattern = ChromaticPattern.TRIAD_MAJOR.getInv(3);
    let expected = ChromaticPattern.TRIAD_MAJOR;
    expect(chromaticPattern).toBe(expected);
});

test('ChromaticChord - getInv: TRIAD MAJOR + inv + inv', () => {
    let chromaticPattern = ChromaticPattern.TRIAD_MAJOR.getInv().getInv();
    let expected = ChromaticPattern.from(0, 5, 9);
    expect(chromaticPattern).toBe(expected);
});

test('ChromaticChord - getInv: TRIAD MAJOR + inv', () => {
    let chromaticPattern = ChromaticPattern.TRIAD_MAJOR.getInv();
    let expected = ChromaticPattern.from(0, 3, 8);
    expect(chromaticPattern).toBe(expected);
});

test('ChromaticChord - toString ENG: TRIAD MAJOR', () => {
    Settings.lang = Language.ENG;
    let str = ChromaticPattern.TRIAD_MAJOR.toString();
    let expected = "MAJOR";
    expect(str).toBe(expected);
});

test('ChromaticChord - toString ESP: TRIAD MAJOR', () => {
    Settings.lang = Language.ESP;
    let str = ChromaticPattern.TRIAD_MAJOR.toString();
    let expected = "MAYOR";
    expect(str).toBe(expected);
});

test('ChromaticChord - toString: 0, 1, 2', () => {
    Settings.lang = Language.ENG;
    let str = ChromaticPattern.from(0, 1, 2).toString();
    let expected = "0-1-2";
    expect(str).toBe(expected);
});
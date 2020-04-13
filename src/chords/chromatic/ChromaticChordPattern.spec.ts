import { Language } from "../../lang/Language";
import * as precalc from "../../precalc";
import { Settings } from "../../settings/Settings";
import { ChromaticChordPattern } from "./ChromaticChordPattern";
precalc.chromaticChordPatterns();
precalc.chromaticChords();

test('ChromaticChordPattern - fromArray - immutable: 0, 4, 7', () => {
    let chromaticChordPattern = ChromaticChordPattern.from(0, 4, 7);
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});

test('ChromaticChordPattern - fromArray - immutable new pattern: 0, 1, 2', () => {
    let chromaticChordPattern = ChromaticChordPattern.from(0, 1, 2);
    let chromaticChordPattern2 = ChromaticChordPattern.from(0, 1, 2);
    expect(chromaticChordPattern2).toBe(chromaticChordPattern);
});

test('ChromaticChord - getInv: TRIAD MAJOR + 2inv', () => {
    let chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR.getInv(2);
    let expected = ChromaticChordPattern.from(0, 5, 9);
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - getInv: TRIAD MAJOR + 3inv = TRIAD MAJOR', () => {
    let chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR.getInv(3);
    let expected = ChromaticChordPattern.TRIAD_MAJOR;
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - getInv: TRIAD MAJOR + inv + inv', () => {
    let chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR.getInv().getInv();
    let expected = ChromaticChordPattern.from(0, 5, 9);
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - getInv: TRIAD MAJOR + inv', () => {
    let chromaticChordPattern = ChromaticChordPattern.TRIAD_MAJOR.getInv();
    let expected = ChromaticChordPattern.from(0, 3, 8);
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - toString ENG: TRIAD MAJOR', () => {
    Settings.lang = Language.ENG;
    let str = ChromaticChordPattern.TRIAD_MAJOR.toString();
    let expected = "MAJOR";
    expect(str).toBe(expected);
});

test('ChromaticChord - toString ESP: TRIAD MAJOR', () => {
    Settings.lang = Language.ESP;
    let str = ChromaticChordPattern.TRIAD_MAJOR.toString();
    let expected = "MAYOR";
    expect(str).toBe(expected);
});

test('ChromaticChord - toString: 0, 1, 2', () => {
    Settings.lang = Language.ENG;
    let str = ChromaticChordPattern.from(0, 1, 2).toString();
    let expected = "0-1-2";
    expect(str).toBe(expected);
});
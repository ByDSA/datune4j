import * as precalc from "../../precalc";
import { ChromaticChord } from "./ChromaticChord";
import { ChromaticPattern } from "../../patterns/ChromaticPattern";
import { Language } from "../../lang/Language";
import { Settings } from "../../settings/Settings";
import { RootPatternChord } from "../root-pattern/RootPatternChord";
import { Chromatic } from "../../degrees/Chromatic";
precalc.chromaticPatterns();
precalc.chromaticChords();

test('ChromaticChord - pattern: ChromaticChord.C', () => {
    let chromaticChordPattern = ChromaticChord.C.pattern;
    expect(chromaticChordPattern).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('ChromaticChord - pattern: ChromaticChord.C/G', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv(2).pattern;
    let expected = ChromaticPattern.TRIAD_MAJOR.getInv(2);
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - pattern: ChromaticChord.C/E', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv().pattern;
    let expected = ChromaticPattern.TRIAD_MAJOR.getInv();
    expect(chromaticChordPattern).toBe(expected);
});

test('fromString - ENG - " c  " = C MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(ChromaticChord.fromString(" c  ")).toBe(ChromaticChord.C);
});

test('fromString - ENG - "c7" = C SEVENTH', () => {
    Settings.lang = Language.ENG;
    expect(ChromaticChord.fromString("c7")).toBe(ChromaticChord.C7);
});

test('getShift - C7 + 2 = D7', () => {
    let actual = ChromaticChord.C7.getShift(2);
    let expected = RootPatternChord.from(Chromatic.D, ChromaticPattern.SEVENTH).chord;
    expect(actual).toBe(expected);
});

test('getShift - C7 - 1 = B7', () => {
    let actual = ChromaticChord.C7.getShift(-1);
    let expected = RootPatternChord.from(Chromatic.B, ChromaticPattern.SEVENTH).chord;
    expect(actual).toBe(expected);
});
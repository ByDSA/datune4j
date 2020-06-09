import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { ChromaticPattern } from "./ChromaticPattern";
precalc.chromaticPatterns();
precalc.chromaticChords();

test('ChromaticPattern - fromArray - immutable: 0, 4, 7', () => {
    let chromaticPattern = ChromaticPattern.from(0, 4, 7);
    expect(chromaticPattern).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('ChromaticPattern - fromArray - immutable new pattern: 0, 1, 2', () => {
    let chromaticPattern = ChromaticPattern.from(0, 1, 2);
    let chromaticPattern2 = ChromaticPattern.from(0, 1, 2);
    expect(chromaticPattern2).toBe(chromaticPattern);
});

test('ChromaticChord - getInv: TRIAD MAJOR + 2inv', () => {
    let chromaticPattern = ChromaticPattern.TRIAD_MAJOR.getInv(2);
    let expected = ChromaticPattern.from(0, 5, 9);
    expect(chromaticPattern).toBe(expected);
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

test('fromString - ESP - "m" = TRIAD_MINOR', () => {
    Settings.lang = Language.ESP;
    expect(ChromaticPattern.fromString("m")).toBe(ChromaticPattern.TRIAD_MINOR);
});

test('fromString - ESP - " " = TRIAD_MAJOR', () => {
    Settings.lang = Language.ESP;
    expect(ChromaticPattern.fromString(" ")).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('fromString - ESP - "MAyOR" = TRIAD_MAJOR', () => {
    Settings.lang = Language.ESP;
    expect(ChromaticPattern.fromString("MAyOR")).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('fromString - ENG - "m" = TRIAD_MINOR', () => {
    Settings.lang = Language.ENG;
    expect(ChromaticPattern.fromString("m")).toBe(ChromaticPattern.TRIAD_MINOR);
});

test('fromString - ENG - " " = TRIAD_MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(ChromaticPattern.fromString(" ")).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('fromString - ENG - "MAjOR" = TRIAD_MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(ChromaticPattern.fromString("MAjOR")).toBe(ChromaticPattern.TRIAD_MAJOR);
});

// TODO
/*
test('fromString - "0 4 6 11" = SEVENTH MAJ7 b5', () => {
    let from = "0 4 6 11";
    let actual = ChromaticPattern.fromString(from);
    let expected = ChromaticPattern.SEVENTH_MAJ7_b5;

    expect(actual).toBe(expected);
});
*/

test('precalc - SEVENTH MAJ7 b5', () => {
    let actual = ChromaticPattern.from(0, 4, 6, 11);
    let expected = ChromaticPattern.SEVENTH_MAJ7_b5;
    expect(actual).toBe(expected);
});

test('precalc - SEVENTH SUS4 b9', () => {
    let actual = ChromaticPattern.from(0, 5, 7, 10, 15);
    let expected = ChromaticPattern.SEVENTH_SUS4_b9;
    expect(actual).toBe(expected);
});
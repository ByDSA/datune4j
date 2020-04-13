import * as precalc from "../../precalc";
import { ChromaticChord } from "./ChromaticChord";
import { ChromaticChordPattern } from "./ChromaticChordPattern";
precalc.chromaticChordPatterns();
precalc.chromaticChords();

test('ChromaticChord - patternRoot: ChromaticChord.C', () => {
    let chromaticChordPattern = ChromaticChord.C.patternFromRoot;
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});

test('ChromaticChord - patternRoot: ChromaticChord.C/G', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv(2).patternFromRoot;
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});

test('ChromaticChord - pattern: ChromaticChord.C/G', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv(2).pattern;
    let expected = ChromaticChordPattern.from(0, 5, 9);
    expect(chromaticChordPattern).toBe(expected);
});

test('ChromaticChord - pattern: ChromaticChord.C/E', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv().pattern;
    let expected = ChromaticChordPattern.from(0, 3, 8);
    expect(chromaticChordPattern).toBe(expected);
});
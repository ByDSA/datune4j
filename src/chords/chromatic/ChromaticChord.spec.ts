import * as precalc from "../../precalc";
import { ChromaticChord } from "./ChromaticChord";
import { ChromaticPattern } from "../../patterns/ChromaticPattern";
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
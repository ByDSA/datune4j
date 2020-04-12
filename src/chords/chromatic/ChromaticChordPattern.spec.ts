import * as precalc from "../../precalc";
import { ChromaticChordPattern } from "./ChromaticChordPattern";
import { ChromaticChord } from "./ChromaticChord";
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

test('ChromaticChordPattern - fromChord: ChromaticChord.C', () => {
    let chromaticChordPattern = ChromaticChordPattern.fromChord(ChromaticChord.C);
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});

test('ChromaticChordPattern - fromChord: ChromaticChord.C/G', () => {
    let chromaticChordPattern = ChromaticChordPattern.fromChord(ChromaticChord.C.getInv(2));
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});
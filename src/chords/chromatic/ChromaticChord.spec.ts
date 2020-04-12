import * as precalc from "../../precalc";
import { ChromaticChord } from "./ChromaticChord";
import { ChromaticChordPattern } from "./ChromaticChordPattern";
precalc.chromaticChordPatterns();
precalc.chromaticChords();

test('ChromaticChord - patternRoot: ChromaticChord.C', () => {
    let chromaticChordPattern = ChromaticChord.C.patternRoot;
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});
test('ChromaticChord - patternRoot: ChromaticChord.C/G', () => {
    let chromaticChordPattern = ChromaticChord.C.getInv(2).patternRoot;
    expect(chromaticChordPattern).toBe(ChromaticChordPattern.TRIAD_MAJOR);
});
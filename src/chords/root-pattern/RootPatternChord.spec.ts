import { Chromatic } from "../../degrees/Chromatic";
import { DiatonicAlt } from "../../degrees/DiatonicAlt";
import { IntervalDiatonicAlt } from "../../interval/IntervalDiatonicAlt";
import { ChromaticPattern } from "../../patterns/ChromaticPattern";
import { DiatonicAltPattern } from "../../patterns/DiatonicAltPattern";
import * as precalc from "../../precalc";
import { ChromaticChord } from "../chromatic/ChromaticChord";
import { DiatonicAltChord } from "../diatonicalt/DiatonicAltChord";
import { RootPatternChord } from "./RootPatternChord";
precalc.chromatics();
precalc.chromaticChords();
precalc.chromaticPatterns();
precalc.diatonicAlts();
precalc.diatonicAltPatterns();
precalc.diatonicAltChords();

/** Diatonic Alt */

test('from - DiatonicAlt C + TRIAD MAJOR', () => {
    let actual: RootPatternChord<DiatonicAlt, IntervalDiatonicAlt> = RootPatternChord.from(DiatonicAlt.C, DiatonicAltPattern.TRIAD_MAJOR);
    expect(actual.degree).toBe(DiatonicAlt.C);
    expect(actual.pattern).toBe(DiatonicAltPattern.TRIAD_MAJOR);
});

test('chord - DiatonicAlt C + TRIAD MAJOR = DiatonicAltChord C', () => {
    let patternChord: RootPatternChord<DiatonicAlt, IntervalDiatonicAlt> = RootPatternChord.from(DiatonicAlt.C, DiatonicAltPattern.TRIAD_MAJOR);
    let actual = patternChord.chord;
    expect(actual).toBe(DiatonicAltChord.C);
});

/** Chromatic */

test('from - Chromatic C + TRIAD MAJOR', () => {
    let actual: RootPatternChord<Chromatic, number> = RootPatternChord.from(Chromatic.C, ChromaticPattern.TRIAD_MAJOR);
    expect(actual.degree).toBe(Chromatic.C);
    expect(actual.pattern).toBe(ChromaticPattern.TRIAD_MAJOR);
});

test('chord - Chromatic C + TRIAD MAJOR = Chord C', () => {
    let patternChord: RootPatternChord<Chromatic, number> = RootPatternChord.from(Chromatic.C, ChromaticPattern.TRIAD_MAJOR);
    let actual = patternChord.chord;
    expect(actual).toBe(ChromaticChord.C);
});
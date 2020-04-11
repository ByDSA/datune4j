import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { ChromaticChordPattern } from './chromatic/ChromaticChordPattern';
import { DiatonicAltChord } from './DiatonicAltChord';
precalc.chromatics();
precalc.chromaticChordPatterns();
precalc.diatonics();
precalc.diatonicAlts();
precalc.diatonicAltChords();
precalc.settings();

test('DiatonicAltChord - fromRootNotes: get from ImmutableCache', () => {
    let diatonicAltChord = DiatonicAltChord.fromRootNotes(0,
        [
            DiatonicAlt.C,
            DiatonicAlt.E,
            DiatonicAlt.G,
            DiatonicAlt.Bb,
        ]);

    let expected = DiatonicAltChord.C7;
    expect(diatonicAltChord).toBe(expected);
});

test('DiatonicAltChord - fromRootPattern: get from ImmutableCache', () => {
    let diatonicAltChord = DiatonicAltChord.fromRootPattern(DiatonicAlt.C, ChromaticChordPattern.SEVENTH);

    let expected = DiatonicAltChord.C7;
    expect(diatonicAltChord).toBe(expected);
});


test('DiatonicAltChord - toString: C7', () => {
    let str = DiatonicAltChord.C7.toString();

    let expected = "C7";
    expect(str).toBe(expected);
});

test('DiatonicAltChord - toString: B##7', () => {
    let str = DiatonicAltChord.fromRootPattern(
        DiatonicAlt.BBB,
        ChromaticChordPattern.SEVENTH).toString();

    let expected = DiatonicAlt.BBB.toString() + "7";
    expect(str).toBe(expected);
});
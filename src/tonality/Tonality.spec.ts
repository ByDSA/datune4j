import { DiatonicAltChord } from '../chords/diatonicalt/DiatonicAltChord';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { Scale } from './Scale';
import { Tonality } from './Tonality';
precalc.diatonics();
precalc.diatonicAlts();
precalc.diatonicAltChordPatterns();
precalc.diatonicAltChords();
precalc.chromatics();
precalc.scales();
precalc.tonalities();
precalc.settings();

test('Tonality - scales & root: ', () => {
    expect(Tonality.C.scale).toBe(Scale.MAJOR);
    expect(Tonality.C.root).toBe(DiatonicAlt.C);
});

test('Tonality - notes: C', () => {
    let notes = Tonality.C.notes;
    expect(notes.length).toBe(7);
    expect(notes).toStrictEqual(
        [
            DiatonicAlt.C,
            DiatonicAlt.D,
            DiatonicAlt.E,
            DiatonicAlt.F,
            DiatonicAlt.G,
            DiatonicAlt.A,
            DiatonicAlt.B
        ]
    );
});

test('Tonality - rootChord3: C -> C', () => {
    let rootChord3: DiatonicAltChord = Tonality.C.rootChord3;
    expect(rootChord3.length).toBe(3);
    expect(rootChord3).toBe(DiatonicAltChord.C);
});

test('Tonality - rootChord4: C -> CMaj7', () => {
    let rootChord4 = Tonality.C.rootChord4;
    expect(rootChord4.length).toBe(4);
    expect(rootChord4).toBe(DiatonicAltChord.CMaj7);
});


test('Tonality - notes: C BLUES MINOR', () => {
    let notes = Tonality.from(DiatonicAlt.C, Scale.BLUES_MINOR).notes;
    expect(notes.length).toBe(5);
    expect(notes).toStrictEqual(
        [
            DiatonicAlt.C,
            DiatonicAlt.Eb,
            DiatonicAlt.F,
            DiatonicAlt.Ab,
            DiatonicAlt.Bb
        ]
    );
});
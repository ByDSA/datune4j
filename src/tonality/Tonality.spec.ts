import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { Scale } from './Scale';
import { Tonality } from './Tonality';
precalc.diatonics();
precalc.diatonicAlts();
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
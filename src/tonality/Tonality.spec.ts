import { DiatonicAltChord } from '../chords/diatonicalt/DiatonicAltChord';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Language } from '../lang/Language';
import * as precalc from "../precalc";
import { Settings } from '../settings/Settings';
import { Scale } from './Scale';
import { Tonality } from './Tonality';
precalc.diatonics();
precalc.chromatics();
precalc.diatonicAlts();
precalc.intervalDiatonicAlts();
precalc.diatonicAltPatterns();
precalc.diatonicAltChords();
precalc.scales();
precalc.tonalities();
precalc.settings();

test('Tonality - scales & root: ', () => {
    expect(Tonality.C.scale).toBe(Scale.MAJOR);
    expect(Tonality.C.root).toBe(DiatonicAlt.C);
});

test('Tonality - scales & root: Scale.ORIENTAL', () => {
    let tonality = Tonality.from(DiatonicAlt.C, Scale.ORIENTAL);
    expect(tonality.scale).toBe(Scale.ORIENTAL);
    expect(tonality.root).toBe(DiatonicAlt.C);
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

test('Tonality - rootChord3: C Oriental -> Am', () => {
    let tonality = Tonality.from(DiatonicAlt.C, Scale.ORIENTAL);
    let rootChord3: DiatonicAltChord = tonality.rootChord3;
    expect(rootChord3.length).toBe(3);
    expect(rootChord3).toBe(DiatonicAltChord.Am);
});

test('Tonality - rootChord4: C -> CMaj7', () => {
    let rootChord4 = Tonality.C.rootChord4;
    expect(rootChord4.length).toBe(4);
    expect(rootChord4).toBe(DiatonicAltChord.CMaj7);
});

test('Tonality - notes: C BLUES MINOR', () => {
    let tonality = Tonality.from(DiatonicAlt.C, Scale.BLUES_MINOR);
    let notes = tonality.notes;
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

test('toString - ENG - C', () => {
    Settings.lang = Language.ENG;
    let tonality = Tonality.C;
    let actual = tonality.toString();
    let expected = "C MAJOR";
    
    expect(actual).toBe(expected);
});

test('fromString - ESP - Do MAYOR', () => {
    Settings.lang = Language.ESP;
    expect(Tonality.fromString("Do MAYOR")).toBe(Tonality.C);
});

test('fromString - ESP - Do ', () => {
    Settings.lang = Language.ESP;
    expect(Tonality.fromString("Do ")).toBe(Tonality.C);
});

test('fromString - ESP - Do m', () => {
    Settings.lang = Language.ESP;
    expect(Tonality.fromString("Do m")).toBe(Tonality.Cm);
});

test('fromString - ENG - C MAJOR', () => {
    Settings.lang = Language.ENG;
    expect(Tonality.fromString("C MAJOR")).toBe(Tonality.C);
});

test('fromString - ENG - C ', () => {
    Settings.lang = Language.ENG;
    expect(Tonality.fromString("C ")).toBe(Tonality.C);
});

test('fromString - ENG - C m', () => {
    Settings.lang = Language.ENG;
    expect(Tonality.fromString("C m")).toBe(Tonality.Cm);
});

test('fromString - ENG - bBBbLuEsB5', () => {
    Settings.lang = Language.ENG;
    expect(Tonality.fromString("bBBbLuEsB5")).toBe(Tonality.from(DiatonicAlt.Bbb, Scale.BLUES_b5));
});
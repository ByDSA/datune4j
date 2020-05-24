import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { Chromatic } from "./Chromatic";
import { Diatonic } from "./Diatonic";
precalc.chromatics();
precalc.diatonics();
precalc.settings();

test('Diatonic - chromatic: B ', () => {
    expect(Diatonic.B.chromatic).toBe(Chromatic.B);
});

test('Diatonic - chromatic: C ', () => {
    expect(Diatonic.C.chromatic).toBe(Chromatic.C);
});

test('Diatonic - chromatic: A ', () => {
    expect(Diatonic.A.chromatic).toBe(Chromatic.A);
});

test('fromString - ESP - Do', () => {
    Settings.lang = Language.ESP;
    expect(Diatonic.fromString("Do")).toBe(Diatonic.C);
});

test('fromString - ESP - La#', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        Diatonic.fromString("La#");
    };
    expect(t).toThrow(Error);
});

test('fromString - ESP - La (spaces)', () => {
    Settings.lang = Language.ESP;
    expect(Diatonic.fromString("   La    ")).toBe(Diatonic.A);
});

test('fromString - ESP - La (spaces middle)', () => {
    Settings.lang = Language.ESP;
    expect(Diatonic.fromString("   L a     ")).toBe(Diatonic.A);
});

test('fromString - ESP - Lab', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        Diatonic.fromString("Lab");
    };
    expect(t).toThrow(Error);
});

test('fromString - ESP - C', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        Diatonic.fromString("C");
    };
    expect(t).toThrow(Error);
});

test('fromString - ENG - C', () => {
    Settings.lang = Language.ENG;
    expect(Diatonic.fromString("C")).toBe(Diatonic.C);
});

test('fromString - ENG - A (spaces)', () => {
    Settings.lang = Language.ENG;
    expect(Diatonic.fromString("   A    ")).toBe(Diatonic.A);
});

test('fromString - ENG - La# (spaces middle)', () => {
    Settings.lang = Language.ENG;
    expect(Diatonic.fromString("   A     ")).toBe(Diatonic.A);
});

test('fromString - ENG - Ab', () => {
    Settings.lang = Language.ENG;
    const t = () => {
        Diatonic.fromString("Ab");
    };
    expect(t).toThrow(Error);
});

test('fromString - ENG - Do', () => {
    Settings.lang = Language.ENG;
    const t = () => {
        Diatonic.fromString("Do");
    };
    expect(t).toThrow(Error);
});
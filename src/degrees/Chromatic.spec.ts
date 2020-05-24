import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { Chromatic } from './Chromatic';
precalc.chromatics();
precalc.diatonics();
precalc.diatonicAlts();
precalc.settings();

test('Chromatic - precalc ', () => {
    expect(Chromatic.C).not.toBe(undefined);
    expect(Chromatic.CC).not.toBe(undefined);
    expect(Chromatic.D).not.toBe(undefined);
    expect(Chromatic.DD).not.toBe(undefined);
    expect(Chromatic.E).not.toBe(undefined);
    expect(Chromatic.F).not.toBe(undefined);
    expect(Chromatic.FF).not.toBe(undefined);
    expect(Chromatic.G).not.toBe(undefined);
    expect(Chromatic.GG).not.toBe(undefined);
    expect(Chromatic.A).not.toBe(undefined);
    expect(Chromatic.AA).not.toBe(undefined);
    expect(Chromatic.B).not.toBe(undefined);
});

test('Chromatic - precalc immutables: reassign Chromatic.C', () => {
    const t = () => {
        Chromatic.C = Chromatic.D;
    };
    expect(t).toThrow(TypeError);
});

test('Chromatic - precalc immutables: reassign Chromatic.C._intValue', () => {
    const t = () => {
        (<any>Chromatic.C)._intValue = 2;
    };
    expect(t).toThrow(TypeError);
});

test('Chromatic - intValues ', () => {
    expect(Chromatic.C.intValue).toBe(0);
    expect(Chromatic.CC.intValue).toBe(1);
    expect(Chromatic.D.intValue).toBe(2);
    expect(Chromatic.DD.intValue).toBe(3);
    expect(Chromatic.E.intValue).toBe(4);
    expect(Chromatic.F.intValue).toBe(5);
    expect(Chromatic.FF.intValue).toBe(6);
    expect(Chromatic.G.intValue).toBe(7);
    expect(Chromatic.GG.intValue).toBe(8);
    expect(Chromatic.A.intValue).toBe(9);
    expect(Chromatic.AA.intValue).toBe(10);
    expect(Chromatic.B.intValue).toBe(11);
});

test('Chromatic - fromInt: 0-11 ', () => {
    expect(Chromatic.fromInt(0)).toBe(Chromatic.C);
    expect(Chromatic.fromInt(1)).toBe(Chromatic.CC);
    expect(Chromatic.fromInt(2)).toBe(Chromatic.D);
    expect(Chromatic.fromInt(3)).toBe(Chromatic.DD);
    expect(Chromatic.fromInt(4)).toBe(Chromatic.E);
    expect(Chromatic.fromInt(5)).toBe(Chromatic.F);
    expect(Chromatic.fromInt(6)).toBe(Chromatic.FF);
    expect(Chromatic.fromInt(7)).toBe(Chromatic.G);
    expect(Chromatic.fromInt(8)).toBe(Chromatic.GG);
    expect(Chromatic.fromInt(9)).toBe(Chromatic.A);
    expect(Chromatic.fromInt(10)).toBe(Chromatic.AA);
    expect(Chromatic.fromInt(11)).toBe(Chromatic.B);
});

test('Chromatic - fromInt: negative', () => {
    expect(Chromatic.fromInt(-1)).toBe(Chromatic.B);
    expect(Chromatic.fromInt(-12)).toBe(Chromatic.C);
});

test('Chromatic - fromInt: above 11', () => {
    expect(Chromatic.fromInt(12)).toBe(Chromatic.C);
    expect(Chromatic.fromInt(25)).toBe(Chromatic.CC);
});

test('Chromatic - toString() - ENG', () => {
    Settings.lang = Language.ENG;
    expect(Chromatic.C.toString()).toBe("C");
    expect(Chromatic.CC.toString()).toBe("C♯");
    expect(Chromatic.D.toString()).toBe("D");
    expect(Chromatic.DD.toString()).toBe("D♯");
    expect(Chromatic.E.toString()).toBe("E");
    expect(Chromatic.F.toString()).toBe("F");
    expect(Chromatic.FF.toString()).toBe("F♯");
    expect(Chromatic.G.toString()).toBe("G");
    expect(Chromatic.GG.toString()).toBe("G♯");
    expect(Chromatic.A.toString()).toBe("A");
    expect(Chromatic.AA.toString()).toBe("A♯");
    expect(Chromatic.B.toString()).toBe("B");
});

test('Chromatic - toString() - ESP', () => {
    Settings.lang = Language.ESP;
    expect(Chromatic.C.toString()).toBe("Do");
    expect(Chromatic.CC.toString()).toBe("Do♯");
    expect(Chromatic.D.toString()).toBe("Re");
    expect(Chromatic.DD.toString()).toBe("Re♯");
    expect(Chromatic.E.toString()).toBe("Mi");
    expect(Chromatic.F.toString()).toBe("Fa");
    expect(Chromatic.FF.toString()).toBe("Fa♯");
    expect(Chromatic.G.toString()).toBe("Sol");
    expect(Chromatic.GG.toString()).toBe("Sol♯");
    expect(Chromatic.A.toString()).toBe("La");
    expect(Chromatic.AA.toString()).toBe("La♯");
    expect(Chromatic.B.toString()).toBe("Si");
});

test('Chromatic - getShift: +1', () => {
    let chromatic = Chromatic.C.getShift(1);
    let expected = Chromatic.CC;
    expect(chromatic).toBe(expected);
});

test('Chromatic - getShift: -1', () => {
    let chromatic = Chromatic.C.getShift(-1);
    let expected = Chromatic.B;
    expect(chromatic).toBe(expected);
});

test('Chromatic - getShift: -27', () => {
    let chromatic = Chromatic.C.getShift(-27);
    let expected = Chromatic.A;
    expect(chromatic).toBe(expected);
});

test('fromString - ESP - Do', () => {
    Settings.lang = Language.ESP;
    expect(Chromatic.fromString("Do")).toBe(Chromatic.C);
});

test('fromString - ESP - La#', () => {
    Settings.lang = Language.ESP;
    expect(Chromatic.fromString("La#")).toBe(Chromatic.AA);
});

test('fromString - ESP - La# (spaces)', () => {
    Settings.lang = Language.ESP;
    expect(Chromatic.fromString("   La#    ")).toBe(Chromatic.AA);
});

test('fromString - ESP - La# (spaces middle)', () => {
    Settings.lang = Language.ESP;
    expect(Chromatic.fromString("   L a #    ")).toBe(Chromatic.AA);
});

test('fromString - ESP - Lab', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        Chromatic.fromString("Lab");
      };
      expect(t).toThrow(Error);
});

test('fromString - ESP - C', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        Chromatic.fromString("C");
      };
      expect(t).toThrow(Error);
});

test('fromString - ENG - C', () => {
    Settings.lang = Language.ENG;
    expect(Chromatic.fromString("C")).toBe(Chromatic.C);
});

test('fromString - ENG - La#', () => {
    Settings.lang = Language.ENG;
    expect(Chromatic.fromString("A#")).toBe(Chromatic.AA);
});

test('fromString - ENG - A# (spaces)', () => {
    Settings.lang = Language.ENG;
    expect(Chromatic.fromString("   A#    ")).toBe(Chromatic.AA);
});

test('fromString - ENG - La# (spaces middle)', () => {
    Settings.lang = Language.ENG;
    expect(Chromatic.fromString("   A #    ")).toBe(Chromatic.AA);
});

test('fromString - ENG - Ab', () => {
    Settings.lang = Language.ENG;
    const t = () => {
        Chromatic.fromString("Ab");
      };
      expect(t).toThrow(Error);
});

test('fromString - ENG - Do', () => {
    Settings.lang = Language.ENG;
    const t = () => {
        Chromatic.fromString("Do");
      };
      expect(t).toThrow(Error);
});
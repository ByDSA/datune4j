import { Language } from "../lang/Language";
import * as precalc from "../precalc";
import { Settings } from "../settings/Settings";
import { ScaleChromatic } from "./ScaleChromatic";
precalc.scaleChromatics();
precalc.diatonics();
precalc.chromatics();
precalc.diatonicAltDegrees();
precalc.diatonicAltPatterns();
precalc.settings();
precalc.diatonicDegrees();
precalc.degreeFunctions();

test('precalc', () => {
    let scale = ScaleChromatic.MAJOR;

    expect(scale).not.toBeUndefined();
    expect(scale).not.toBeNull();
    expect(scale).toBe(ScaleChromatic.MAJOR);
});

test('precalc all', () => {
    expect(ScaleChromatic.MAJOR).not.toBeUndefined();
    expect(ScaleChromatic.DORIAN).not.toBeUndefined();
    expect(ScaleChromatic.PHRYGIAN).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN).not.toBeUndefined();
    expect(ScaleChromatic.MIXOLYDIAN).not.toBeUndefined();
    expect(ScaleChromatic.MINOR).not.toBeUndefined();
    expect(ScaleChromatic.LOCRIAN).not.toBeUndefined();

    expect(ScaleChromatic.HARMONIC_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.LOCRIAN_a6).not.toBeUndefined();
    expect(ScaleChromatic.IONIAN_a5).not.toBeUndefined();
    expect(ScaleChromatic.DORIAN_a4).not.toBeUndefined();
    expect(ScaleChromatic.MIXOLYDIAN_b9_b13).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN_a2).not.toBeUndefined();
    expect(ScaleChromatic.SUPERLOCRIAN_bb7).not.toBeUndefined();

    expect(ScaleChromatic.HARMONIC_MAJOR).not.toBeUndefined();
    expect(ScaleChromatic.DORIAN_b5).not.toBeUndefined();
    expect(ScaleChromatic.PHRYGIAN_b4).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN_b3).not.toBeUndefined();
    expect(ScaleChromatic.MIXOLYDIAN_b2).not.toBeUndefined();
    expect(ScaleChromatic.AEOLIAN_b1).not.toBeUndefined();
    expect(ScaleChromatic.LOCRIAN_bb7).not.toBeUndefined();

    expect(ScaleChromatic.MELODIC_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.DORIAN_b2).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN_a5).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN_b7).not.toBeUndefined();
    expect(ScaleChromatic.MIXOLYDIAN_b13).not.toBeUndefined();
    expect(ScaleChromatic.LOCRIAN_a2).not.toBeUndefined();
    expect(ScaleChromatic.SUPERLOCRIAN).not.toBeUndefined();

    expect(ScaleChromatic.DOUBLE_HARMONIC).not.toBeUndefined();
    expect(ScaleChromatic.LYDIAN_a2_a6).not.toBeUndefined();
    expect(ScaleChromatic.ULTRAPHRYGIAN).not.toBeUndefined();
    expect(ScaleChromatic.HUNGARIAN_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.ORIENTAL).not.toBeUndefined();
    expect(ScaleChromatic.IONIAN_AUGMENTED_a2).not.toBeUndefined();
    expect(ScaleChromatic.LOCRIAN_bb3_bb7).not.toBeUndefined();

    expect(ScaleChromatic.NEAPOLITAN_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.NEAPOLITAN_MAJOR).not.toBeUndefined();

    // 6
    expect(ScaleChromatic.BLUES_b5).not.toBeUndefined();
    expect(ScaleChromatic.BLUES_a4).not.toBeUndefined();

    // 5
    expect(ScaleChromatic.PENTATONIC_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.PENTATONIC).not.toBeUndefined();
    expect(ScaleChromatic.EGYPCIAN).not.toBeUndefined();
    expect(ScaleChromatic.BLUES_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.BLUES_MAJOR).not.toBeUndefined();

    // Symmetric
    expect(ScaleChromatic.DOM7b5).not.toBeUndefined();
    expect(ScaleChromatic.AUGMENTED_TRIAD).not.toBeUndefined();
    expect(ScaleChromatic.DIMINISHED_7th).not.toBeUndefined();
    expect(ScaleChromatic.HALF_DIMINISHED).not.toBeUndefined();
    expect(ScaleChromatic.CHROMATIC).not.toBeUndefined();
    expect(ScaleChromatic.WHOLE_TONE).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_V_TRUNCATED).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_INV_III_V_TRUNCATED_n2).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_V).not.toBeUndefined();
    expect(ScaleChromatic.RAGA_INDRUPRIYA_INDIA).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_II_TRUNCATED_n3).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_III_INV).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_IV).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_VI).not.toBeUndefined();
    expect(ScaleChromatic.MESSIAEN_VII).not.toBeUndefined();

    // Bebop
    expect(ScaleChromatic.BEBOP_MAJOR).not.toBeUndefined();
    expect(ScaleChromatic.BEBOP_DORIAN).not.toBeUndefined();
    expect(ScaleChromatic.BEBOP_DOMINANT).not.toBeUndefined();
    expect(ScaleChromatic.BEBOP_MELODIC_MINOR).not.toBeUndefined();
    expect(ScaleChromatic.BEBOP_HARMONIC_MINOR).not.toBeUndefined();

    for (let scale of ScaleChromatic.sets.all()) {
        expect(scale).not.toBeUndefined();
        expect(scale).not.toBeNull();
    }
});

test('getModeIntraIntervals - -III  = MINOR.intervals', () => {
    let actual: number[] = (<any>ScaleChromatic.MAJOR).getModeIntraIntervals(-3);
    let expected: number[] = [2, 1, 2, 2, 1, 2, 2];

    expect(actual).toStrictEqual(expected);
});

test('getModeIntraIntervals - VI  = MINOR.intervals', () => {
    let actual: number[] = (<any>ScaleChromatic.MAJOR).getModeIntraIntervals(6);
    let expected: number[] = [2, 1, 2, 2, 1, 2, 2];

    expect(actual).toStrictEqual(expected);
});

test('getMode - I = MAJOR', () => {
    let mode = ScaleChromatic.MAJOR.getMode(1);
    let expected = ScaleChromatic.MAJOR;

    expect(mode).toBe(expected);
});

test('getMode - -I = MAJOR', () => {
    let mode = ScaleChromatic.MAJOR.getMode(-1);
    let expected = ScaleChromatic.MAJOR;

    expect(mode).toBe(expected);
});

test('getMode - II = DORIAN', () => {
    let mode = ScaleChromatic.MAJOR.getMode(2);
    let expected = ScaleChromatic.DORIAN;

    expect(mode).toBe(expected);
});

test('getMode - -II = LOCRIAN', () => {
    let mode = ScaleChromatic.MAJOR.getMode(-2);
    let expected = ScaleChromatic.LOCRIAN;

    expect(mode).toBe(expected);
});

test('degrees not null or undefined', () => {
    for (let scale of ScaleChromatic.sets.all()) {
        expect(scale.degrees).not.toBeNull();
    }
});

test('degrees: MAJOR', () => {
    let scale = ScaleChromatic.MAJOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([0, 2, 4, 5, 7, 9, 11]);
});

test('degrees: MINOR', () => {
    let scale = ScaleChromatic.MINOR;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([0, 2, 3, 5, 7, 8, 10]);
});

test('intraIntervals: BLUES_b5', () => {
    let scale = ScaleChromatic.BLUES_b5;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([3, 2, 1, 1, 3, 2]);
});

test('intraIntervals: BLUES_a4', () => {
    let scale = ScaleChromatic.BLUES_a4;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([3, 2, 1, 1, 3, 2]);
});


test('intraIntervals: pentatonic minor', () => {
    let scale = ScaleChromatic.PENTATONIC_MINOR;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([3, 2, 2, 3, 2]);
});

test('intraIntervals: pentatonic', () => {
    let scale = ScaleChromatic.PENTATONIC;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([2, 2, 3, 2, 3]);
});

test('intraIntervals: egypcian', () => {
    let scale = ScaleChromatic.EGYPCIAN;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([2, 3, 2, 3, 2]);
});

test('intraIntervals: blues minor', () => {
    let scale = ScaleChromatic.BLUES_MINOR;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([3, 2, 3, 2, 2]);
});

test('intraIntervals: blues major', () => {
    let scale = ScaleChromatic.BLUES_MAJOR;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([2, 3, 2, 2, 3]);
});

test('set all: contains BLUES_a4', () => {
    expect(ScaleChromatic.sets.all().includes(ScaleChromatic.BLUES_a4)).toBe(true);
});

test('pitchClass: MIXOLYDIAN', () => {
    let scale = ScaleChromatic.MIXOLYDIAN;
    let degrees = scale.degrees;
    expect(degrees).toStrictEqual([0, 2, 4, 5, 7, 9, 10]);
});

test('intervalClass: BEBOP DOMINANT', () => {
    let scale = ScaleChromatic.BEBOP_DOMINANT;
    let intraIntervals = scale.intraIntervals;
    expect(intraIntervals).toStrictEqual([2, 2, 1, 2, 2, 1, 1, 1]);
});

test('fromPC: MAJOR', () => {
    let scale = ScaleChromatic.fromRootIntervals(0, 2, 4, 5, 7, 9, 11);
    expect(scale).toBe(ScaleChromatic.MAJOR);
});

test('fromIC: MAJOR', () => {
    let scale = ScaleChromatic.fromIntraIntervals(2, 2, 1, 2, 2, 2, 1);
    expect(scale).toBe(ScaleChromatic.MAJOR);
});

test('intervalClass: BLUES_b5, mode V', () => {
    let scale: ScaleChromatic = ScaleChromatic.BLUES_b5.modes[4];
    let intervals = scale.intraIntervals;
    expect(intervals).toStrictEqual([3, 2, 3, 2, 1, 1]);
});

test('toString: all have string', () => {
    for (let scale of ScaleChromatic.sets.all()) {
        expect(scale.toString()).not.toBeNull();
        expect(scale.toString()).not.toBeUndefined();
    }
});

test('toString - ESP - AEOLIAN_b1 - LIDIA AUMENTADA #2', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.AEOLIAN_b1.toString()).toEqual("LIDIA AUMENTADA ♯2");
});

test('fromString - ESP - MAYOR', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("MAYOR")).toBe(ScaleChromatic.MAJOR);
});

test('fromString - ESP - MAJOR', () => {
    Settings.lang = Language.ESP;
    const t = () => {
        ScaleChromatic.fromString("MAJOR")
    };
    expect(t).toThrow(Error);
});

test('fromString - ESP - maYor (with spaces)', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("  ma Yor  ")).toBe(ScaleChromatic.MAJOR);
});

test('fromString - ESP - MENOR', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("MENOR")).toBe(ScaleChromatic.MINOR);
});

test('fromString - ESP - LiDIA aume Ntada #2', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("LiDIA aume Ntada #2")).toBe(ScaleChromatic.AEOLIAN_b1);
});

test('fromString - ESP - LiDIA AUMENTada ♯2', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("LiDIA AUMENTada ♯2")).toBe(ScaleChromatic.AEOLIAN_b1);
});

test('fromString - ESP - LYDIAN b7', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("LiDIA b7")).toBe(ScaleChromatic.LYDIAN_b7);
});

test('fromString - ENG - SUPERLOCRIA bb7', () => {
    Settings.lang = Language.ESP;
    expect(ScaleChromatic.fromString("SUPERLOCRIA bb7")).toBe(ScaleChromatic.SUPERLOCRIAN_bb7);
});

test('toString - ENG - AEOLIAN_b1 - LYDIAN AUGMENTED #2', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.AEOLIAN_b1.toString()).toEqual("LYDIAN AUGMENTED ♯2");
});
test('fromString - ENG - MAYOR', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("MAJOR")).toBe(ScaleChromatic.MAJOR);
});

test('fromString - ENG - MAYOR', () => {
    Settings.lang = Language.ENG;
    const t = () => {
        ScaleChromatic.fromString("MAYOR")
    };
    expect(t).toThrow(Error);
});

test('fromString - ENG - maJor (with spaces)', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("  ma Jor  ")).toBe(ScaleChromatic.MAJOR);
});

test('fromString - ENG - MINOR', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("MINOR")).toBe(ScaleChromatic.MINOR);
});

test('fromString - ENG - LyDIAN augme Nted #2', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("LyDIAN augme Nted #2")).toBe(ScaleChromatic.AEOLIAN_b1);
});

test('fromString - ENG - LYDIAN AUGMENTED ♯2', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("LYDIAN AUGMENTED ♯2")).toBe(ScaleChromatic.AEOLIAN_b1);
});

test('fromString - ENG - LYDIAN b7', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("LYDIAN b7")).toBe(ScaleChromatic.LYDIAN_b7);
});

test('fromString - ENG - BLUES b5', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("blues b5")).toBe(ScaleChromatic.BLUES_b5);
});

test('fromString - ENG - SUPERLOCRIAN bb7', () => {
    Settings.lang = Language.ENG;
    expect(ScaleChromatic.fromString("SUPERLOCRIAN bb7")).toBe(ScaleChromatic.SUPERLOCRIAN_bb7);
});

test('fromIntraIntervals - 2-2-1-2-2-2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromIntraIntervals(2, 2, 1, 2, 2, 2, 1);
    expect(actual).toBe(ScaleChromatic.MAJOR);
});

test('fromString - 2-2-1-2-2-2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2-2-1-2-2-2-1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});

test('fromString - 2:2-1:2-2:2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2:2-1:2-2:2-1");
    expect(actual).toBe(ScaleChromatic.MAJOR);
});

test('fromString - 2 2 1 2-2 2:1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2 2 1 2-2 2:1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});

test('fromString - 2:2-1 2-2:2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2:2-1 2-2:2-1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});

test('fromString - 2-2-1-2-2-2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2-2-1-2-2-2-1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});

test('fromString - 2:2-1:2-2:2-1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2:2-1:2-2:2-1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});

test('fromString - 2 2 1 2-2 2:1 (MAJOR)', () => {
    let actual = ScaleChromatic.fromString("2 2 1 2-2 2:1");
    let expected = ScaleChromatic.MAJOR;
    expect(actual).toBe(expected);
});
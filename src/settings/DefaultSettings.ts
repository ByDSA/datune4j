import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Language } from '../lang/Language';
import { Scale } from '../tonality/Scale';
import { Tonality } from '../tonality/Tonality';
import { SettingsInterface } from './SettingsInterface';
import { Settings } from './Settings';

export const DefaultSettings: SettingsInterface = {
    default: {
        get chromatic(): Chromatic { return Chromatic.C },
        get diatonicAlt(): DiatonicAlt { return DiatonicAlt.C },
        get scale(): Scale { return Scale.MAJOR },
        get tonality(): Tonality { return Tonality.C },
        get chord(): ChromaticChord { return ChromaticChord.C },
        get pattern(): ChromaticChordPattern { return ChromaticChordPattern.TRIAD_MAJOR }
    },
    lang: Language.ENG,
    scales: {
        get MAJOR(): string { return Settings.scales.MAJOR },
        get MINOR(): string { return Settings.scales.MINOR },
        get DORIAN(): string { return Settings.scales.DORIAN },
        get PHRYGIAN(): string { return Settings.scales.PHRYGIAN },
        get LYDIAN(): string { return Settings.scales.LYDIAN },
        get MIXOLYDIAN(): string { return Settings.scales.MIXOLYDIAN },
        get LOCRIAN(): string { return Settings.scales.LOCRIAN },
        get HARMONIC_MINOR(): string { return Settings.scales.HARMONIC_MINOR },
        get LOCRIAN_a6(): string { return Settings.scales.LOCRIAN_a6 },
        get IONIAN_a5(): string { return Settings.scales.IONIAN_a5 },
        get DORIAN_a4(): string { return Settings.scales.DORIAN_a4 },
        get MIXOLYDIAN_b9_b13(): string { return Settings.scales.MIXOLYDIAN_b9_b13 },
        get LYDIAN_a2(): string { return Settings.scales.LYDIAN_a2 },
        get SUPERLOCRIAN_bb7(): string { return Settings.scales.SUPERLOCRIAN_bb7 },
        get HARMONIC_MAJOR(): string { return Settings.scales.HARMONIC_MAJOR },
        get DORIAN_b5(): string { return Settings.scales.DORIAN_b5 },
        get PHRYGIAN_b4(): string { return Settings.scales.PHRYGIAN_b4 },
        get LYDIAN_b3(): string { return Settings.scales.LYDIAN_b3 },
        get MIXOLYDIAN_b2(): string { return Settings.scales.MIXOLYDIAN_b2 },
        get AEOLIAN_b1(): string { return Settings.scales.AEOLIAN_b1 },
        get LOCRIAN_bb7(): string { return Settings.scales.LOCRIAN_bb7 },
        get MELODIC_MINOR(): string { return Settings.scales.MELODIC_MINOR },
        get DORIAN_b2(): string { return Settings.scales.DORIAN_b2 },
        get LYDIAN_a5(): string { return Settings.scales.LYDIAN_a5 },
        get LYDIAN_b7(): string { return Settings.scales.LYDIAN_b7 },
        get MIXOLYDIAN_b13(): string { return Settings.scales.MIXOLYDIAN_b13 },
        get LOCRIAN_a2(): string { return Settings.scales.LOCRIAN_a2 },
        get SUPERLOCRIAN(): string { return Settings.scales.SUPERLOCRIAN },
        get DOUBLE_HARMONIC(): string { return Settings.scales.DOUBLE_HARMONIC },
        get LYDIAN_a2_a6(): string { return Settings.scales.LYDIAN_a2_a6 },
        get ULTRAPHRYGIAN(): string { return Settings.scales.ULTRAPHRYGIAN },
        get HUNGARIAN_MINOR(): string { return Settings.scales.HUNGARIAN_MINOR },
        get ORIENTAL(): string { return Settings.scales.ORIENTAL },
        get IONIAN_AUGMENTED_a2(): string { return Settings.scales.IONIAN_AUGMENTED_a2 },
        get LOCRIAN_bb3_bb7(): string { return Settings.scales.LOCRIAN_bb3_bb7 },
        get NEAPOLITAN_MINOR(): string { return Settings.scales.NEAPOLITAN_MINOR },
        get NEAPOLITAN_MAJOR(): string { return Settings.scales.NEAPOLITAN_MAJOR },
        get BLUES_b5(): string { return Settings.scales.BLUES_b5 },
        get WHOLE_TONE(): string { return Settings.scales.WHOLE_TONE },
        get PENTATONIC_MINOR(): string { return Settings.scales.PENTATONIC_MINOR },
        get PENTATONIC(): string { return Settings.scales.PENTATONIC },
        get EGYPCIAN(): string { return Settings.scales.EGYPCIAN },
        get BLUES_MINOR(): string { return Settings.scales.BLUES_MINOR },
        get BLUES_MAJOR(): string { return Settings.scales.BLUES_MAJOR },
        get CHROMATIC(): string { return Settings.scales.CHROMATIC },
        get AUGMENTED_TRIAD(): string { return Settings.scales.AUGMENTED_TRIAD },
        get DIMINISHED_7th(): string { return Settings.scales.DIMINISHED_7th },
        get MESSIAEN_V_TRUNCATED(): string { return Settings.scales.MESSIAEN_V_TRUNCATED },
        get DOM7b5(): string { return Settings.scales.DOM7b5 },
        get MESSIAEN_INV_III_V_TRUNCATED_n2(): string { return Settings.scales.MESSIAEN_INV_III_V_TRUNCATED_n2 },
        get HALF_DIMINISHED(): string { return Settings.scales.HALF_DIMINISHED },
        get MESSIAEN_V(): string { return Settings.scales.MESSIAEN_V },
        get RAGA_INDRUPRIYA_INDIA(): string { return Settings.scales.RAGA_INDRUPRIYA_INDIA },
        get MESSIAEN_II_TRUNCATED_n3(): string { return Settings.scales.MESSIAEN_II_TRUNCATED_n3 },
        get MESSIAEN_III_INV(): string { return Settings.scales.MESSIAEN_III_INV },
        get MESSIAEN_IV(): string { return Settings.scales.MESSIAEN_IV },
        get MESSIAEN_VI(): string { return Settings.scales.MESSIAEN_VI },
        get MESSIAEN_VII(): string { return Settings.scales.MESSIAEN_VII },
        get BEBOP_MAJOR(): string { return Settings.scales.BEBOP_MAJOR },
    },
    symbols: {
        sharp: "♯",
        bemol: "♭",
        alts: function (n: number): string {
            if (n < 0)
                return Settings.symbols.bemol.repeat(-n);
            else if (n > 0)
                return Settings.symbols.sharp.repeat(n);
            else
                return "";
        }
    },
    mods: {
        get b9(): string { return Settings.symbols.alts(-1) + "9"; },
        get a9(): string { return Settings.symbols.alts(1) + "9"; },
        get b5(): string { return Settings.symbols.alts(-1) + "5"; },
        get a5(): string { return Settings.symbols.alts(1) + "5"; },
        get a11(): string { return Settings.symbols.alts(1) + "11"; },
        get add(): string { return "ADD"; }
    }
}
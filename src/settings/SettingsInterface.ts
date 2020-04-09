import { Chromatic } from '../degrees/Chromatic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Scale } from '../tonality/Scale';
import { Tonality } from '../tonality/Tonality';
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { LanguageInterface } from '../lang/LanguageInterface';

export interface SettingsInterface {
    default: {
        chromatic: Chromatic,
        diatonicAlt: DiatonicAlt,
        scale: Scale,
        tonality: Tonality,
        chord: ChromaticChord,
        pattern: ChromaticChordPattern
    },
    scales: {
        MAJOR: string,
        MINOR: string,
        DORIAN: string,
        PHRYGIAN: string,
        LYDIAN: string,
        MIXOLYDIAN: string,
        LOCRIAN: string,
        HARMONIC_MINOR: string,
        LOCRIAN_a6: string,
        IONIAN_a5: string,
        DORIAN_a4: string,
        MIXOLYDIAN_b9_b13: string,
        LYDIAN_a2: string,
        SUPERLOCRIAN_bb7: string,
        HARMONIC_MAJOR: string,
        DORIAN_b5: string,
        PHRYGIAN_b4: string,
        LYDIAN_b3: string,
        MIXOLYDIAN_b2: string,
        AEOLIAN_b1: string,
        LOCRIAN_bb7: string,
        MELODIC_MINOR: string,
        DORIAN_b2: string,
        LYDIAN_a5: string,
        LYDIAN_b7: string,
        MIXOLYDIAN_b13: string,
        LOCRIAN_a2: string,
        SUPERLOCRIAN: string,
        DOUBLE_HARMONIC: string,
        LYDIAN_a2_a6: string,
        ULTRAPHRYGIAN: string,
        HUNGARIAN_MINOR: string,
        ORIENTAL: string,
        IONIAN_AUGMENTED_a2: string,
        LOCRIAN_bb3_bb7: string,
        NEAPOLITAN_MINOR: string,
        NEAPOLITAN_MAJOR: string,
        BLUES_b5: string,
        WHOLE_TONE: string,
        PENTATONIC_MINOR: string,
        PENTATONIC: string,
        EGYPCIAN: string,
        BLUES_MINOR: string,
        BLUES_MAJOR: string,
        CHROMATIC: string,
        AUGMENTED_TRIAD: string,
        DIMINISHED_7th: string,
        MESSIAEN_V_TRUNCATED: string,
        DOM7b5: string,
        MESSIAEN_INV_III_V_TRUNCATED_n2: string,
        HALF_DIMINISHED: string,
        MESSIAEN_V: string,
        RAGA_INDRUPRIYA_INDIA: string,
        MESSIAEN_II_TRUNCATED_n3: string,
        MESSIAEN_III_INV: string,
        MESSIAEN_IV: string,
        MESSIAEN_VI: string,
        MESSIAEN_VII: string,
        BEBOP_MAJOR: string,
    }
    lang: LanguageInterface,
    symbols: {
        sharp: string,
        bemol: string,
        alts(n: number): string
    },
    mods: {
        b9: string,
        a9: string,
        b5: string,
        a5: string,
        a11: string,
        add: string,
    }

}
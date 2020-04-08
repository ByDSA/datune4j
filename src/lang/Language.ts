import { Settings } from '../settings/Settings';
import { LanguageInterface } from 'lang/LanguageInterface';

export class Language {
    static ENG: LanguageInterface = {
        diatonic: {
            C: "C",
            D: "D",
            E: "E",
            F: "F",
            G: "G",
            A: "A",
            B: "B",
        },
        scales: {
            MAJOR: "MAJOR",
            MINOR: "MINOR",
            DORIAN: "DORIAN",
            PHRYGIAN: "PHRYGIAN",
            LYDIAN: "LYDIAN",
            MIXOLYDIAN: "MIXOLYDIAN",
            LOCRIAN: "LOCRIAN",

            HARMONIC_MINOR: "HARMONIC MINOR",
            LOCRIAN_a6: "LOCRIAN " + Settings.symbols.alts(1) + "6",
            IONIAN_a5: "IONIAN " + Settings.symbols.alts(1) + "5",
            DORIAN_a4: "DORIAN " + Settings.symbols.alts(1) + "4",
            MIXOLYDIAN_b9_b13: "MIXOLYDIAN " + Settings.symbols.alts(-1) + "9" + Settings.symbols.alts(-1) + "13",
            LYDIAN_a2: "LYDIAN " + Settings.symbols.alts(1) + "2",
            SUPERLOCRIAN_bb7: "SUPERLOCRIAN " + Settings.symbols.alts(-2) + "7",

            HARMONIC_MAJOR: "HARMONIC MAJOR",
            DORIAN_b5: "DORIAN " + Settings.symbols.alts(-1) + "5",
            PHRYGIAN_b4: "PHRYGIAN " + Settings.symbols.alts(-1) + "4",
            LYDIAN_b3: "LYDIAN " + Settings.symbols.alts(-1) + "3",
            MIXOLYDIAN_b2: "MIXOLYDIAN " + Settings.symbols.alts(-1) + "2",
            AEOLIAN_b1: "LYDIAN AUGMENTED " + Settings.symbols.alts(1) + "2",
            LOCRIAN_bb7: "LOCRIAN " + Settings.symbols.alts(-2) + "7",

            MELODIC_MINOR: "MELODIC MINOR",
            DORIAN_b2: "DORIAN " + Settings.symbols.alts(-1) + "2",
            LYDIAN_a5: "LYDIAN " + Settings.symbols.alts(1) + "5",
            LYDIAN_b7: "LYDIAN " + Settings.symbols.alts(-1) + "7",
            MIXOLYDIAN_b13: "MIXOLYDIAN " + Settings.symbols.alts(-1) + "13",
            LOCRIAN_a2: "LOCRIAN " + Settings.symbols.alts(1) + "2",
            SUPERLOCRIAN: "SUPER" + "LOCRIAN",

            DOUBLE_HARMONIC: "DOUBLE HARMONIC",
            LYDIAN_a2_a6: "LYDIAN " + Settings.symbols.alts(1) + "2" + Settings.symbols.alts(1) + "6",
            ULTRAPHRYGIAN: "ULTRA" + "PHRYGIAN",
            HUNGARIAN_MINOR: "HUNGARIAN MINOR",
            ORIENTAL: "ORIENTAL",
            IONIAN_AUGMENTED_a2: "IONIAN AUGMENTED " + Settings.symbols.alts(1) + "2",
            LOCRIAN_bb3_bb7: "LOCRIAN " + Settings.symbols.alts(-2) + "3" + Settings.symbols.alts(-2) + "7",

            NEAPOLITAN_MINOR: "NAPOLITAN MINOR",
            NEAPOLITAN_MAJOR: "NAPOLITAN MAJOR",

            // 6
            BLUES_b5: "BLUES " + Settings.symbols.alts(-1) + "5",
            BLUES_a4: "BLUES " + Settings.symbols.alts(1) + "4",

            WHOLE_TONE: "WHOLE TONE",

            // 5
            PENTATONIC_MINOR: "PENTATONIC MINOR",
            PENTATONIC: "PENTATONIC",
            EGYPCIAN: "EGYPCIAN",
            BLUES_MINOR: "BLUES MINOR",
            BLUES_MAJOR: "BLUES MAJOR",

            // 12
            CHROMATIC: "CHROMATIC",

            AUGMENTED_TRIAD: "AUGMENTED TRIAD",
            DIMINISHED_7th: "DIMINISHED 7th",
            MESSIAEN_V_TRUNCATED: "MESSIAEN V TRUNCATED",
            DOM7b5: "DOM7" + Settings.symbols.alts(-1) + "5",
            MESSIAEN_INV_III_V_TRUNCATED_n2: "MESSIAEN INV. III V TRUNCATED n2",
            HALF_DIMINISHED: "HALF DIMINISHED",
            MESSIAEN_V: "MESSIAEN V",
            RAGA_INDRUPRIYA_INDIA: "RAGA INDRUPRIYA INDIA",
            MESSIAEN_II_TRUNCATED_n3: "MESSIAEN II TRUNCATED n3",
            MESSIAEN_III_INV: "MESSIAEN III INV",
            MESSIAEN_IV: "MESSIAEN IV",
            MESSIAEN_VI: "MESSIAEN VI",
            MESSIAEN_VII: "MESSIAEN VII",

            BEBOP_MAJOR: "BEBOP MAJOR"
        },
        patterns: {
            TRIAD_MAJOR: "MAJOR",
            TRIAD_MINOR: "MINOR",
            TRIAD_AUGMENTED: "AUGMENTED",
            TRIAD_DIMINISHED: "DIMINISHED",
            TRIAD_SUS4: "SUS4",
            TRIAD_QUARTAL: "QUARTAL",
            ELEVENTH: "ELEVENTH",
            ELEVENTH_MAJ11: "ELEVENTH MAJ11",
            ELEVENTH_MINOR_MAJ11: "ELEVENTH MINOR MAJ11",
            ELEVENTH_a9: "ELEVENTH " + Settings.mods.a9,
            ELEVENTH_b9: "ELEVENTH " + Settings.mods.b9,
            NINTH: "NINTH",
            NINTH_ADD6: "NINTH ADD6",
            NINTH_MAJ9: "NINTH MAJ9",
            NINTH_MAJ9_a11: "NINTH MAJ9 " + Settings.mods.a11,
            NINTH_MINOR: "NINTH_MINOR",
            NINTH_MINOR_MAJ9: "NINTH MINOR MAJ9",
            NINTH_SUS4: "NINTH SUS4",
            NINTH_a11: "NINTH " + Settings.mods.a11,
            NINTH_a5: "NINTH " + Settings.mods.a5,
            NINTH_b5: "NINTH " + Settings.mods.b5,
            POWER_CHORD: "POWER CHORD",
            SEVENTH: "SEVENTH",
            SEVENTH_ADD11: "SEVENTH ADD11",
            SEVENTH_ADD13: "SEVENTH ADD13",
            SEVENTH_MAJ7: "SEVENTH MAJ7",
            SEVENTH_MINOR: "SEVENTH MINOR",
            SEVENTH_MINOR_MAJ7: "SEVENTH MINOR MAJ7",
            SEVENTH_MINOR_a5: "SEVENTH MINOR " + Settings.mods.a5,
            SEVENTH_MINOR_b5: "SEVENTH MINOR " + Settings.mods.b5,
            SEVENTH_MINOR_b9: "SEVENTH MINOR " + Settings.mods.b9,
            SEVENTH_SUS4: "SEVENTH SUS4",
            SEVENTH_a5: "SEVENTH " + Settings.mods.a5,
            SEVENTH_a9: "SEVENTH " + Settings.mods.a9,
            SEVENTH_b5: "SEVENTH " + Settings.mods.b5,
            SEVENTH_b9: "SEVENTH " + Settings.mods.b9,
            SIXTH: "SIXTH",
            SIXTH_ADD9: "SIXTH ADD9",
            SIXTH_MINOR: "SIXTH MINOR",
            SIXTH_MINOR_ADD9: "SIXTH MINOR ADD9",
            SIXTH_SUS4: "SIXTH SUS4",
            THIRTEENTH_MAJ13: "THIRTEENTH MAJ13",
            THIRTEENTH_MAJ13_a5: "THIRTEENTH MAJ13 " + Settings.mods.a5,
            THIRTEENTH_MAJ13_a5a9: "THIRTEENTH MAJ13 " + Settings.mods.a5 + Settings.mods.a9
        }
    }
}
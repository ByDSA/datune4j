import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { Settings } from '../../settings/Settings';

export const NamingChromaticChordPattern = {
    toString: function (chromaticChordPattern: ChromaticChordPattern): string {
        switch (chromaticChordPattern) {
            case ChromaticChordPattern.TRIAD_MAJOR: return "MAJOR";
            case ChromaticChordPattern.TRIAD_MINOR: return "MINOR";
            case ChromaticChordPattern.TRIAD_AUGMENTED: return "AUGMENTED";
            case ChromaticChordPattern.TRIAD_DIMINISHED: return "DIMINISHED";
            case ChromaticChordPattern.TRIAD_SUS4: return "SUS4";
            case ChromaticChordPattern.TRIAD_QUARTAL: return "QUARTAL";
            case ChromaticChordPattern.ELEVENTH: return "ELEVENTH";
            case ChromaticChordPattern.ELEVENTH_MAJ11: return "ELEVENTH MAJ11";
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11: return "ELEVENTH MINOR MAJ11";
            case ChromaticChordPattern.ELEVENTH_a9: return "ELEVENTH " + Settings.mods.a9;
            case ChromaticChordPattern.ELEVENTH_b9: return "ELEVENTH " + Settings.mods.b9;
            case ChromaticChordPattern.NINTH: return "NINTH";
            case ChromaticChordPattern.NINTH_ADD6: return "NINTH ADD6";
            case ChromaticChordPattern.NINTH_MAJ9: return "NINTH MAJ9";
            case ChromaticChordPattern.NINTH_MAJ9_a11: return "NINTH MAJ9 " + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_MINOR: return "NINTH_MINOR";
            case ChromaticChordPattern.NINTH_MINOR_MAJ9: return "NINTH MINOR MAJ9";
            case ChromaticChordPattern.NINTH_SUS4: return "NINTH SUS4";
            case ChromaticChordPattern.NINTH_a11: return "NINTH " + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_a5: return "NINTH " + Settings.mods.a5;
            case ChromaticChordPattern.NINTH_b5: return "NINTH " + Settings.mods.b5;
            case ChromaticChordPattern.POWER_CHORD: return "POWER CHORD";
            case ChromaticChordPattern.SEVENTH: return "SEVENTH";
            case ChromaticChordPattern.SEVENTH_ADD11: return "SEVENTH ADD11";
            case ChromaticChordPattern.SEVENTH_ADD13: return "SEVENTH ADD13";
            case ChromaticChordPattern.SEVENTH_MAJ7: return "SEVENTH MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR: return "SEVENTH MINOR";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7: return "SEVENTH MINOR MAJ7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5: return "SEVENTH MINOR " + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5: return "SEVENTH MINOR " + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9: return "SEVENTH MINOR " + Settings.mods.b9;
            case ChromaticChordPattern.SEVENTH_SUS4: return "SEVENTH SUS4";
            case ChromaticChordPattern.SEVENTH_a5: return "SEVENTH " + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_a9: return "SEVENTH " + Settings.mods.a9;
            case ChromaticChordPattern.SEVENTH_b5: return "SEVENTH " + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_b9: return "SEVENTH " + Settings.mods.b9;
            case ChromaticChordPattern.SIXTH: return "SIXTH";
            case ChromaticChordPattern.SIXTH_ADD9: return "SIXTH ADD9";
            case ChromaticChordPattern.SIXTH_MINOR: return "SIXTH MINOR";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9: return "SIXTH MINOR ADD9";
            case ChromaticChordPattern.SIXTH_SUS4: return "SIXTH SUS4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13: return "THIRTEENTH MAJ13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5: return "THIRTEENTH MAJ13 " + Settings.mods.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9: return "THIRTEENTH MAJ13 " + Settings.mods.a5 + Settings.mods.a9;
        }
        return chromaticChordPattern.values.toString();
    },
    toStringShort: function patternShort(pattern: ChromaticChordPattern): string {
        switch (pattern) {
            case ChromaticChordPattern.TRIAD_MAJOR: return "";
            case ChromaticChordPattern.TRIAD_MINOR: return "m";
            case ChromaticChordPattern.TRIAD_AUGMENTED: return "+";
            case ChromaticChordPattern.TRIAD_DIMINISHED: return "dim";
            case ChromaticChordPattern.TRIAD_SUS4: return "sus4";
            case ChromaticChordPattern.TRIAD_QUARTAL: return "quartal";
            case ChromaticChordPattern.ELEVENTH: return "11";
            case ChromaticChordPattern.ELEVENTH_MAJ11: return "Maj11";
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11: return "mMaj11";
            case ChromaticChordPattern.ELEVENTH_a9: return "11#9";
            case ChromaticChordPattern.ELEVENTH_b9: return "11b9";
            case ChromaticChordPattern.NINTH: return "9";
            case ChromaticChordPattern.NINTH_ADD6: return "9add6";
            case ChromaticChordPattern.NINTH_MAJ9: return "Maj9";
            case ChromaticChordPattern.NINTH_MAJ9_a11: return "Maj9#11";
            case ChromaticChordPattern.NINTH_MINOR: return "m9";
            case ChromaticChordPattern.NINTH_MINOR_MAJ9: return "mMaj9";
            case ChromaticChordPattern.NINTH_SUS4: return "9sus4";
            case ChromaticChordPattern.NINTH_a11: return "9" + Settings.mods.a11;
            case ChromaticChordPattern.NINTH_a5: return "9" + Settings.mods.a5;
            case ChromaticChordPattern.NINTH_b5: return "9" + Settings.mods.b5;
            case ChromaticChordPattern.POWER_CHORD: return "5";
            case ChromaticChordPattern.SEVENTH: return "7";
            case ChromaticChordPattern.SEVENTH_ADD11: return "7add11";
            case ChromaticChordPattern.SEVENTH_ADD13: return "7add13";
            case ChromaticChordPattern.SEVENTH_MAJ7: return "Maj7";
            case ChromaticChordPattern.SEVENTH_MINOR: return "m7";
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7: return "mMaj7";
            case ChromaticChordPattern.SEVENTH_MINOR_a5: return "m7" + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5: return "m7" + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9: return "m7" + Settings.mods.b9;
            case ChromaticChordPattern.SEVENTH_SUS4: return "7sus4";
            case ChromaticChordPattern.SEVENTH_a5: return "7" + Settings.mods.a5;
            case ChromaticChordPattern.SEVENTH_a9: return "7" + Settings.mods.a9;
            case ChromaticChordPattern.SEVENTH_b5: return "7" + Settings.mods.b5;
            case ChromaticChordPattern.SEVENTH_b9: return "7" + Settings.mods.b9;
            case ChromaticChordPattern.SIXTH: return "6";
            case ChromaticChordPattern.SIXTH_ADD9: return "6add9";
            case ChromaticChordPattern.SIXTH_MINOR: return "m6";
            case ChromaticChordPattern.SIXTH_MINOR_ADD9: return "m6add9";
            case ChromaticChordPattern.SIXTH_SUS4: return "6sus4";
            case ChromaticChordPattern.TRIAD_SUS4: return "sus4";
            case ChromaticChordPattern.THIRTEENTH_MAJ13: return "Maj13";
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5: return "Maj13" + Settings.mods.a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9: return "Maj13" + Settings.mods.a5 + Settings.mods.a9;
        }

        return pattern.values.toString();
    },
    get: function (str: string): ChromaticChordPattern {
        throw new Error("Can't convert '" + str + "' to ChromaticChordPattern.");
    }
};
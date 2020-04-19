import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { Settings } from '../../settings/Settings';

export const NamingChromaticChordPattern = {
    toString: function (chromaticChordPattern: ChromaticChordPattern): string {
        switch (chromaticChordPattern) {
            case ChromaticChordPattern.TRIAD_MAJOR: return Settings.patterns.TRIAD_MAJOR;
            case ChromaticChordPattern.TRIAD_MINOR: return Settings.patterns.TRIAD_MINOR;
            case ChromaticChordPattern.TRIAD_AUGMENTED: return Settings.patterns.TRIAD_AUGMENTED;
            case ChromaticChordPattern.TRIAD_DIMINISHED: return Settings.patterns.TRIAD_DIMINISHED;
            case ChromaticChordPattern.TRIAD_SUS4: return Settings.patterns.TRIAD_SUS4;
            case ChromaticChordPattern.TRIAD_QUARTAL: return Settings.patterns.TRIAD_QUARTAL;
            case ChromaticChordPattern.ELEVENTH: return Settings.patterns.ELEVENTH;
            case ChromaticChordPattern.ELEVENTH_MAJ11: return Settings.patterns.ELEVENTH_MAJ11;
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11: return Settings.patterns.ELEVENTH_MAJ11;
            case ChromaticChordPattern.ELEVENTH_a9: return Settings.patterns.ELEVENTH_a9;
            case ChromaticChordPattern.ELEVENTH_b9: return Settings.patterns.ELEVENTH_b9;
            case ChromaticChordPattern.NINTH: return Settings.patterns.NINTH;
            case ChromaticChordPattern.NINTH_ADD6: return Settings.patterns.NINTH_ADD6;
            case ChromaticChordPattern.NINTH_MAJ9: return Settings.patterns.NINTH_MAJ9;
            case ChromaticChordPattern.NINTH_MAJ9_a11: return Settings.patterns.NINTH_MAJ9_a11;
            case ChromaticChordPattern.NINTH_MINOR: return Settings.patterns.NINTH_MINOR;
            case ChromaticChordPattern.NINTH_MINOR_MAJ9: return Settings.patterns.NINTH_MINOR_MAJ9;
            case ChromaticChordPattern.NINTH_SUS4: return Settings.patterns.NINTH_SUS4;
            case ChromaticChordPattern.NINTH_a11: return Settings.patterns.NINTH_a11;
            case ChromaticChordPattern.NINTH_a5: return Settings.patterns.NINTH_a5;
            case ChromaticChordPattern.NINTH_b5: return Settings.patterns.NINTH_b5;
            case ChromaticChordPattern.POWER_CHORD: return Settings.patterns.POWER_CHORD;
            case ChromaticChordPattern.SEVENTH: return Settings.patterns.SEVENTH;
            case ChromaticChordPattern.SEVENTH_ADD11: return Settings.patterns.SEVENTH_ADD11;
            case ChromaticChordPattern.SEVENTH_ADD13: return Settings.patterns.SEVENTH_ADD13;
            case ChromaticChordPattern.SEVENTH_MAJ7: return Settings.patterns.SEVENTH_MAJ7;
            case ChromaticChordPattern.SEVENTH_MINOR: return Settings.patterns.NINTH_MINOR;
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7: return Settings.patterns.SEVENTH_MINOR_MAJ7;
            case ChromaticChordPattern.SEVENTH_MINOR_a5: return Settings.patterns.SEVENTH_MINOR_a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5: return Settings.patterns.SEVENTH_MINOR_b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9: return Settings.patterns.SEVENTH_MINOR_b9;
            case ChromaticChordPattern.SEVENTH_SUS4: return Settings.patterns.SEVENTH_SUS4;
            case ChromaticChordPattern.SEVENTH_a5: return Settings.patterns.SEVENTH_a5;
            case ChromaticChordPattern.SEVENTH_a9: return Settings.patterns.SEVENTH_a9;
            case ChromaticChordPattern.SEVENTH_b5: return Settings.patterns.SEVENTH_b5;
            case ChromaticChordPattern.SEVENTH_b9: return Settings.patterns.SEVENTH_b9;
            case ChromaticChordPattern.SIXTH: return Settings.patterns.SIXTH;
            case ChromaticChordPattern.SIXTH_ADD9: return Settings.patterns.SIXTH_ADD9;
            case ChromaticChordPattern.SIXTH_MINOR: return Settings.patterns.SIXTH_MINOR;
            case ChromaticChordPattern.SIXTH_MINOR_ADD9: return Settings.patterns.SIXTH_MINOR_ADD9;
            case ChromaticChordPattern.SIXTH_SUS4: return Settings.patterns.SIXTH_SUS4;
            case ChromaticChordPattern.THIRTEENTH_MAJ13: return Settings.patterns.THIRTEENTH_MAJ13;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5: return Settings.patterns.THIRTEENTH_MAJ13_a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9: return Settings.patterns.THIRTEENTH_MAJ13_a5a9;
        }
        return chromaticChordPattern.values.toString().replace(/,/g, "-");
    },
    toStringShort: function patternShort(chromaticChordPattern: ChromaticChordPattern): string {
        switch (chromaticChordPattern) {
            case ChromaticChordPattern.TRIAD_MAJOR: return Settings.shortPatterns.TRIAD_MAJOR;
            case ChromaticChordPattern.TRIAD_MINOR: return Settings.shortPatterns.TRIAD_MINOR;
            case ChromaticChordPattern.TRIAD_AUGMENTED: return Settings.shortPatterns.TRIAD_AUGMENTED;
            case ChromaticChordPattern.TRIAD_DIMINISHED: return Settings.shortPatterns.TRIAD_DIMINISHED;
            case ChromaticChordPattern.TRIAD_SUS4: return Settings.shortPatterns.TRIAD_SUS4;
            case ChromaticChordPattern.TRIAD_QUARTAL: return Settings.shortPatterns.TRIAD_QUARTAL;
            case ChromaticChordPattern.ELEVENTH: return Settings.shortPatterns.ELEVENTH;
            case ChromaticChordPattern.ELEVENTH_MAJ11: return Settings.shortPatterns.ELEVENTH_MAJ11;
            case ChromaticChordPattern.ELEVENTH_MINOR_MAJ11: return Settings.shortPatterns.ELEVENTH_MAJ11;
            case ChromaticChordPattern.ELEVENTH_a9: return Settings.shortPatterns.ELEVENTH_a9;
            case ChromaticChordPattern.ELEVENTH_b9: return Settings.shortPatterns.ELEVENTH_b9;
            case ChromaticChordPattern.NINTH: return Settings.shortPatterns.NINTH;
            case ChromaticChordPattern.NINTH_ADD6: return Settings.shortPatterns.NINTH_ADD6;
            case ChromaticChordPattern.NINTH_MAJ9: return Settings.shortPatterns.NINTH_MAJ9;
            case ChromaticChordPattern.NINTH_MAJ9_a11: return Settings.shortPatterns.NINTH_MAJ9_a11;
            case ChromaticChordPattern.NINTH_MINOR: return Settings.shortPatterns.NINTH_MINOR;
            case ChromaticChordPattern.NINTH_MINOR_MAJ9: return Settings.shortPatterns.NINTH_MINOR_MAJ9;
            case ChromaticChordPattern.NINTH_SUS4: return Settings.shortPatterns.NINTH_SUS4;
            case ChromaticChordPattern.NINTH_a11: return Settings.shortPatterns.NINTH_a11;
            case ChromaticChordPattern.NINTH_a5: return Settings.shortPatterns.NINTH_a5;
            case ChromaticChordPattern.NINTH_b5: return Settings.shortPatterns.NINTH_b5;
            case ChromaticChordPattern.POWER_CHORD: return Settings.shortPatterns.POWER_CHORD;
            case ChromaticChordPattern.SEVENTH: return Settings.shortPatterns.SEVENTH;
            case ChromaticChordPattern.SEVENTH_ADD11: return Settings.shortPatterns.SEVENTH_ADD11;
            case ChromaticChordPattern.SEVENTH_ADD13: return Settings.shortPatterns.SEVENTH_ADD13;
            case ChromaticChordPattern.SEVENTH_MAJ7: return Settings.shortPatterns.SEVENTH_MAJ7;
            case ChromaticChordPattern.SEVENTH_MINOR: return Settings.shortPatterns.SEVENTH_MINOR;
            case ChromaticChordPattern.SEVENTH_MINOR_MAJ7: return Settings.shortPatterns.SEVENTH_MINOR_MAJ7;
            case ChromaticChordPattern.SEVENTH_MINOR_a5: return Settings.shortPatterns.SEVENTH_MINOR_a5;
            case ChromaticChordPattern.SEVENTH_MINOR_b5: return Settings.shortPatterns.SEVENTH_MINOR_b5;
            case ChromaticChordPattern.SEVENTH_MINOR_b9: return Settings.shortPatterns.SEVENTH_MINOR_b9;
            case ChromaticChordPattern.SEVENTH_SUS4: return Settings.shortPatterns.SEVENTH_SUS4;
            case ChromaticChordPattern.SEVENTH_a5: return Settings.shortPatterns.SEVENTH_a5;
            case ChromaticChordPattern.SEVENTH_a9: return Settings.shortPatterns.SEVENTH_a9;
            case ChromaticChordPattern.SEVENTH_b5: return Settings.shortPatterns.SEVENTH_b5;
            case ChromaticChordPattern.SEVENTH_b9: return Settings.shortPatterns.SEVENTH_b9;
            case ChromaticChordPattern.SIXTH: return Settings.shortPatterns.SIXTH;
            case ChromaticChordPattern.SIXTH_ADD9: return Settings.shortPatterns.SIXTH_ADD9;
            case ChromaticChordPattern.SIXTH_MINOR: return Settings.shortPatterns.SIXTH_MINOR;
            case ChromaticChordPattern.SIXTH_MINOR_ADD9: return Settings.shortPatterns.SIXTH_MINOR_ADD9;
            case ChromaticChordPattern.SIXTH_SUS4: return Settings.shortPatterns.SIXTH_SUS4;
            case ChromaticChordPattern.THIRTEENTH_MAJ13: return Settings.shortPatterns.THIRTEENTH_MAJ13;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5: return Settings.shortPatterns.THIRTEENTH_MAJ13_a5;
            case ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9: return Settings.shortPatterns.THIRTEENTH_MAJ13_a5a9;
        }

        return chromaticChordPattern.values.toString();
    },
    get: function (str: string): ChromaticChordPattern {
        throw new Error("Can't convert '" + str + "' to ChromaticChordPattern.");
    }
};
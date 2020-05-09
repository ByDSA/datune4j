import { Settings } from '../../settings/Settings';
import { DiatonicAltPattern } from '../../patterns/DiatonicAltPattern';

export const NamingDiatonicAltPattern = {
    toString: function (pattern: DiatonicAltPattern): string {
        switch (pattern) {
            case DiatonicAltPattern.TRIAD_MAJOR: return Settings.patterns.TRIAD_MAJOR;
            case DiatonicAltPattern.TRIAD_MINOR: return Settings.patterns.TRIAD_MINOR;
            case DiatonicAltPattern.TRIAD_AUGMENTED: return Settings.patterns.TRIAD_AUGMENTED;
            case DiatonicAltPattern.TRIAD_DIMINISHED: return Settings.patterns.TRIAD_DIMINISHED;
            case DiatonicAltPattern.TRIAD_SUS4: return Settings.patterns.TRIAD_SUS4;
            case DiatonicAltPattern.TRIAD_SUS2: return Settings.patterns.TRIAD_SUS2;
            case DiatonicAltPattern.TRIAD_QUARTAL: return Settings.patterns.TRIAD_QUARTAL;
            case DiatonicAltPattern.ELEVENTH: return Settings.patterns.ELEVENTH;
            case DiatonicAltPattern.ELEVENTH_MAJ11: return Settings.patterns.ELEVENTH_MAJ11;
            case DiatonicAltPattern.ELEVENTH_MINOR_MAJ11: return Settings.patterns.ELEVENTH_MAJ11;
            case DiatonicAltPattern.ELEVENTH_a9: return Settings.patterns.ELEVENTH_a9;
            case DiatonicAltPattern.ELEVENTH_b9: return Settings.patterns.ELEVENTH_b9;
            case DiatonicAltPattern.NINTH: return Settings.patterns.NINTH;
            case DiatonicAltPattern.NINTH_ADD6: return Settings.patterns.NINTH_ADD6;
            case DiatonicAltPattern.NINTH_MAJ9: return Settings.patterns.NINTH_MAJ9;
            case DiatonicAltPattern.NINTH_MAJ9_a11: return Settings.patterns.NINTH_MAJ9_a11;
            case DiatonicAltPattern.NINTH_MINOR: return Settings.patterns.NINTH_MINOR;
            case DiatonicAltPattern.NINTH_MINOR_MAJ9: return Settings.patterns.NINTH_MINOR_MAJ9;
            case DiatonicAltPattern.NINTH_SUS4: return Settings.patterns.NINTH_SUS4;
            case DiatonicAltPattern.NINTH_a11: return Settings.patterns.NINTH_a11;
            case DiatonicAltPattern.NINTH_a5: return Settings.patterns.NINTH_a5;
            case DiatonicAltPattern.NINTH_b5: return Settings.patterns.NINTH_b5;
            case DiatonicAltPattern.POWER_CHORD: return Settings.patterns.POWER_CHORD;
            case DiatonicAltPattern.SEVENTH: return Settings.patterns.SEVENTH;
            case DiatonicAltPattern.SEVENTH_ADD11: return Settings.patterns.SEVENTH_ADD11;
            case DiatonicAltPattern.SEVENTH_ADD13: return Settings.patterns.SEVENTH_ADD13;
            case DiatonicAltPattern.SEVENTH_MAJ7: return Settings.patterns.SEVENTH_MAJ7;
            case DiatonicAltPattern.SEVENTH_MINOR: return Settings.patterns.NINTH_MINOR;
            case DiatonicAltPattern.SEVENTH_MINOR_MAJ7: return Settings.patterns.SEVENTH_MINOR_MAJ7;
            case DiatonicAltPattern.SEVENTH_MINOR_a5: return Settings.patterns.SEVENTH_MINOR_a5;
            case DiatonicAltPattern.SEVENTH_MINOR_b5: return Settings.patterns.SEVENTH_MINOR_b5;
            case DiatonicAltPattern.SEVENTH_MINOR_b9: return Settings.patterns.SEVENTH_MINOR_b9;
            case DiatonicAltPattern.SEVENTH_SUS4: return Settings.patterns.SEVENTH_SUS4;
            case DiatonicAltPattern.SEVENTH_a5: return Settings.patterns.SEVENTH_a5;
            case DiatonicAltPattern.SEVENTH_a9: return Settings.patterns.SEVENTH_a9;
            case DiatonicAltPattern.SEVENTH_b5: return Settings.patterns.SEVENTH_b5;
            case DiatonicAltPattern.SEVENTH_b9: return Settings.patterns.SEVENTH_b9;
            case DiatonicAltPattern.SIXTH: return Settings.patterns.SIXTH;
            case DiatonicAltPattern.SIXTH_ADD9: return Settings.patterns.SIXTH_ADD9;
            case DiatonicAltPattern.SIXTH_MINOR: return Settings.patterns.SIXTH_MINOR;
            case DiatonicAltPattern.SIXTH_MINOR_ADD9: return Settings.patterns.SIXTH_MINOR_ADD9;
            case DiatonicAltPattern.SIXTH_SUS4: return Settings.patterns.SIXTH_SUS4;
            case DiatonicAltPattern.THIRTEENTH_MAJ13: return Settings.patterns.THIRTEENTH_MAJ13;
            case DiatonicAltPattern.THIRTEENTH_MAJ13_a5: return Settings.patterns.THIRTEENTH_MAJ13_a5;
            case DiatonicAltPattern.THIRTEENTH_MAJ13_a5a9: return Settings.patterns.THIRTEENTH_MAJ13_a5a9;
            case DiatonicAltPattern.THIRTEENTH_b5a9: return Settings.patterns.THIRTEENTH_b5a9;
        }
        return pattern.values.toString().replace(/,/g, "-");
    },
    toStringShort: function patternShort(pattern: DiatonicAltPattern): string {
        switch (pattern) {
            case DiatonicAltPattern.TRIAD_MAJOR: return Settings.shortPatterns.TRIAD_MAJOR;
            case DiatonicAltPattern.TRIAD_MINOR: return Settings.shortPatterns.TRIAD_MINOR;
            case DiatonicAltPattern.TRIAD_AUGMENTED: return Settings.shortPatterns.TRIAD_AUGMENTED;
            case DiatonicAltPattern.TRIAD_DIMINISHED: return Settings.shortPatterns.TRIAD_DIMINISHED;
            case DiatonicAltPattern.TRIAD_SUS4: return Settings.shortPatterns.TRIAD_SUS4;
            case DiatonicAltPattern.TRIAD_SUS2: return Settings.shortPatterns.TRIAD_SUS2;
            case DiatonicAltPattern.TRIAD_QUARTAL: return Settings.shortPatterns.TRIAD_QUARTAL;
            case DiatonicAltPattern.ELEVENTH: return Settings.shortPatterns.ELEVENTH;
            case DiatonicAltPattern.ELEVENTH_MAJ11: return Settings.shortPatterns.ELEVENTH_MAJ11;
            case DiatonicAltPattern.ELEVENTH_MINOR_MAJ11: return Settings.shortPatterns.ELEVENTH_MAJ11;
            case DiatonicAltPattern.ELEVENTH_a9: return Settings.shortPatterns.ELEVENTH_a9;
            case DiatonicAltPattern.ELEVENTH_b9: return Settings.shortPatterns.ELEVENTH_b9;
            case DiatonicAltPattern.NINTH: return Settings.shortPatterns.NINTH;
            case DiatonicAltPattern.NINTH_ADD6: return Settings.shortPatterns.NINTH_ADD6;
            case DiatonicAltPattern.NINTH_MAJ9: return Settings.shortPatterns.NINTH_MAJ9;
            case DiatonicAltPattern.NINTH_MAJ9_a11: return Settings.shortPatterns.NINTH_MAJ9_a11;
            case DiatonicAltPattern.NINTH_MINOR: return Settings.shortPatterns.NINTH_MINOR;
            case DiatonicAltPattern.NINTH_MINOR_MAJ9: return Settings.shortPatterns.NINTH_MINOR_MAJ9;
            case DiatonicAltPattern.NINTH_SUS4: return Settings.shortPatterns.NINTH_SUS4;
            case DiatonicAltPattern.NINTH_a11: return Settings.shortPatterns.NINTH_a11;
            case DiatonicAltPattern.NINTH_a5: return Settings.shortPatterns.NINTH_a5;
            case DiatonicAltPattern.NINTH_b5: return Settings.shortPatterns.NINTH_b5;
            case DiatonicAltPattern.POWER_CHORD: return Settings.shortPatterns.POWER_CHORD;
            case DiatonicAltPattern.SEVENTH: return Settings.shortPatterns.SEVENTH;
            case DiatonicAltPattern.SEVENTH_ADD11: return Settings.shortPatterns.SEVENTH_ADD11;
            case DiatonicAltPattern.SEVENTH_ADD13: return Settings.shortPatterns.SEVENTH_ADD13;
            case DiatonicAltPattern.SEVENTH_MAJ7: return Settings.shortPatterns.SEVENTH_MAJ7;
            case DiatonicAltPattern.SEVENTH_MINOR: return Settings.shortPatterns.SEVENTH_MINOR;
            case DiatonicAltPattern.SEVENTH_MINOR_MAJ7: return Settings.shortPatterns.SEVENTH_MINOR_MAJ7;
            case DiatonicAltPattern.SEVENTH_MINOR_a5: return Settings.shortPatterns.SEVENTH_MINOR_a5;
            case DiatonicAltPattern.SEVENTH_MINOR_b5: return Settings.shortPatterns.SEVENTH_MINOR_b5;
            case DiatonicAltPattern.SEVENTH_MINOR_b9: return Settings.shortPatterns.SEVENTH_MINOR_b9;
            case DiatonicAltPattern.SEVENTH_SUS4: return Settings.shortPatterns.SEVENTH_SUS4;
            case DiatonicAltPattern.SEVENTH_a5: return Settings.shortPatterns.SEVENTH_a5;
            case DiatonicAltPattern.SEVENTH_a9: return Settings.shortPatterns.SEVENTH_a9;
            case DiatonicAltPattern.SEVENTH_b5: return Settings.shortPatterns.SEVENTH_b5;
            case DiatonicAltPattern.SEVENTH_b9: return Settings.shortPatterns.SEVENTH_b9;
            case DiatonicAltPattern.SIXTH: return Settings.shortPatterns.SIXTH;
            case DiatonicAltPattern.SIXTH_ADD9: return Settings.shortPatterns.SIXTH_ADD9;
            case DiatonicAltPattern.SIXTH_MINOR: return Settings.shortPatterns.SIXTH_MINOR;
            case DiatonicAltPattern.SIXTH_MINOR_ADD9: return Settings.shortPatterns.SIXTH_MINOR_ADD9;
            case DiatonicAltPattern.SIXTH_SUS4: return Settings.shortPatterns.SIXTH_SUS4;
            case DiatonicAltPattern.THIRTEENTH_MAJ13: return Settings.shortPatterns.THIRTEENTH_MAJ13;
            case DiatonicAltPattern.THIRTEENTH_MAJ13_a5: return Settings.shortPatterns.THIRTEENTH_MAJ13_a5;
            case DiatonicAltPattern.THIRTEENTH_MAJ13_a5a9: return Settings.shortPatterns.THIRTEENTH_MAJ13_a5a9;
            case DiatonicAltPattern.THIRTEENTH_b5a9: return Settings.shortPatterns.THIRTEENTH_b5a9;
        }

        return pattern.values.toString();
    },
    get: function (str: string): DiatonicAltPattern {
        throw new Error("Can't convert '" + str + "' to ChromaticChordPattern.");
    }
};
import { ChromaticChord } from './chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from './chords/chromatic/ChromaticChordPattern';
import { DiatonicChordPattern } from './chords/Diatonic/DiatonicChordPattern';
import { DiatonicAltChord } from './chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern } from './chords/diatonicalt/DiatonicAltChordPattern';
import { Chromatic } from './degrees/Chromatic';
import { Diatonic } from './degrees/Diatonic';
import { DiatonicAlt } from './degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from './interval/IntervalDiatonicAlt';
import { DefaultSettings } from './settings/DefaultSettings';
import { Settings } from './settings/Settings';
import { Scale } from './tonality/Scale';
import { SourceScaleUtils } from './tonality/SourceScaleUtils';
import { Tonality } from './tonality/Tonality';

// DIATONICS
export function diatonics() {
    (<any>Diatonic).initialize();
}

// DIATONIC ALTS
export function diatonicAlts() {
    if (!Diatonic.C)
        diatonics();

    (<any>DiatonicAlt).initialize();
}

// DIATONIC ALTS
export function diatonicAltChords() {
    (<any>DiatonicAltChord).initialize();
}


// INTERVAL DIATONIC ALTS
export function intervalDiatonicAlts() {
    (<any>IntervalDiatonicAlt).initialize();
}

// CHROMATICS
export function chromatics() {
    (<any>Chromatic).initialize();
}

// DIATONIC ALT CHORD PATTERNS
export function diatonicChordPatterns() {
    (<any>DiatonicChordPattern).initialize();
}

// DIATONIC ALT CHORD PATTERNS
export function diatonicAltChordPatterns() {
    if (!DiatonicChordPattern.TRIAD)
        diatonicChordPatterns();

    if (!ChromaticChordPattern.TRIAD_MAJOR)
        chromaticChordPatterns();

    (<any>DiatonicAltChordPattern).initialize();
}

// CHROMATIC CHORD PATTERNS
export function chromaticChordPatterns() {
    (<any>ChromaticChordPattern).initialize();
}

// CHROMATIC CHORDS
export function chromaticChords() {
    if (!Chromatic.C)
        chromatics();

    (<any>ChromaticChord).initialize();
}

// SCALES
export function scales() {
    (<any>Scale).initialize();
};

// SOURCE SCALES
export function sourceScales() {
    (<any>SourceScaleUtils)._sourceScales = [
        Scale.MAJOR,
        Scale.HARMONIC_MINOR,
        Scale.MELODIC_MINOR,
        Scale.HARMONIC_MAJOR,
        Scale.DOUBLE_HARMONIC,
        Scale.PENTATONIC
    ];

    // Static initialization
    (<any>SourceScaleUtils).sourceScaleMapInitialize();

};

// TONALITIES
export function tonalities() {
    Tonality.C = Tonality.from(DiatonicAlt.C, Scale.MAJOR);
    Tonality.CC = Tonality.from(DiatonicAlt.CC, Scale.MAJOR);
    Tonality.D = Tonality.from(DiatonicAlt.D, Scale.MAJOR);
    Tonality.DD = Tonality.from(DiatonicAlt.DD, Scale.MAJOR);
    Tonality.E = Tonality.from(DiatonicAlt.E, Scale.MAJOR);
    Tonality.F = Tonality.from(DiatonicAlt.F, Scale.MAJOR);
    Tonality.FF = Tonality.from(DiatonicAlt.FF, Scale.MAJOR);
    Tonality.G = Tonality.from(DiatonicAlt.G, Scale.MAJOR);
    Tonality.GG = Tonality.from(DiatonicAlt.GG, Scale.MAJOR);
    Tonality.A = Tonality.from(DiatonicAlt.A, Scale.MAJOR);
    Tonality.B = Tonality.from(DiatonicAlt.B, Scale.MAJOR);

    Tonality.Cm = Tonality.from(DiatonicAlt.C, Scale.MINOR);
    Tonality.CCm = Tonality.from(DiatonicAlt.CC, Scale.MINOR);
    Tonality.Dm = Tonality.from(DiatonicAlt.D, Scale.MINOR);
    Tonality.DDm = Tonality.from(DiatonicAlt.DD, Scale.MINOR);
    Tonality.Em = Tonality.from(DiatonicAlt.E, Scale.MINOR);
    Tonality.Fm = Tonality.from(DiatonicAlt.F, Scale.MINOR);
    Tonality.FFm = Tonality.from(DiatonicAlt.FF, Scale.MINOR);
    Tonality.Gm = Tonality.from(DiatonicAlt.G, Scale.MINOR);
    Tonality.GGm = Tonality.from(DiatonicAlt.GG, Scale.MINOR);
    Tonality.Am = Tonality.from(DiatonicAlt.A, Scale.MINOR);
    Tonality.Bm = Tonality.from(DiatonicAlt.B, Scale.MINOR);
};

// Settings
export function settings() {
    Object.assign(Settings, DefaultSettings)
}

export function all() {
    diatonics();
    diatonicAlts();
    intervalDiatonicAlts();
    diatonicAltChords();
    chromaticChordPatterns();
    diatonicChordPatterns();
    diatonicAltChordPatterns();
    chromatics();
    chromaticChords();
    scales();
    sourceScales();
    tonalities();
    settings();
}
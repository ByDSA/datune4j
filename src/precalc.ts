import { IntervalDiatonic } from './interval/IntervalDiatonic';
import { ChromaticChord } from './chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from './chords/chromatic/ChromaticChordPattern';
import { DiatonicChordPattern } from './chords/Diatonic/DiatonicChordPattern';
import { DiatonicAltChord } from './chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern } from './chords/diatonicalt/DiatonicAltChordPattern';
import { Chromatic } from './degrees/Chromatic';
import { Diatonic } from './degrees/Diatonic';
import { DiatonicAlt } from './degrees/DiatonicAlt';
import { DiatonicAltDegree } from './degrees/scale/DiatonicAltDegree';
import { DiatonicDegree } from './degrees/scale/DiatonicDegree';
import { DegreeFunction } from './function/DegreeFunction';
import { IntervalDiatonicAlt } from './interval/IntervalDiatonicAlt';
import { DefaultSettings } from './settings/DefaultSettings';
import { Settings } from './settings/Settings';
import { Scale } from './tonality/Scale';
import { SourceScaleUtils } from './tonality/SourceScaleUtils';
import { Tonality } from './tonality/Tonality';
import { ChromaticSymbolicPitch } from './tunning/ChromaticSymbolicPitch';
import { ConcertPitch } from './tunning/ConcertPitch';
import { Temperament } from './tunning/Temperament';
import { Tuning as Tuning } from './tunning/Tuning';

// DIATONICS
export function diatonics() {
    if (Diatonic.C)
        return;

    (<any>Diatonic).initialize();
}

// DIATONIC ALTS
export function diatonicAlts() {
    if (DiatonicAlt.C)
        return;

    if (!Diatonic.C)
        diatonics();

    (<any>DiatonicAlt).initialize();
}

// DIATONIC ALTS
export function diatonicAltChords() {
    if (DiatonicAltChord.C)
        return;

    if (!DiatonicAltChordPattern.TRIAD_MAJOR)
        diatonicAltChordPatterns();

    (<any>DiatonicAltChord).initialize();
}


// INTERVAL DIATONIC ALTS
export function intervalDiatonicAlts() {
    if (IntervalDiatonicAlt.PERFECT_UNISON)
        return;

    intervalDiatonics();

    (<any>IntervalDiatonicAlt).initialize();
}

// CHROMATICS
export function chromatics() {
    if (Chromatic.C)
        return;
    (<any>Chromatic).initialize();
}

// DIATONIC ALT CHORD PATTERNS
export function diatonicChordPatterns() {
    (<any>DiatonicChordPattern).initialize();
}

// DIATONIC ALT CHORD PATTERNS
export function diatonicAltChordPatterns() {
    if (DiatonicAltChordPattern.TRIAD_MAJOR)
        return;

    if (!DiatonicChordPattern.TRIAD)
        diatonicChordPatterns();

    if (!ChromaticChordPattern.TRIAD_MAJOR)
        chromaticChordPatterns();

    (<any>DiatonicAltChordPattern).initialize();
}

// CHROMATIC CHORD PATTERNS
export function chromaticChordPatterns() {
    if (ChromaticChordPattern.TRIAD_MAJOR)
        return;
    (<any>ChromaticChordPattern).initialize();
}

// CHROMATIC CHORDS
export function chromaticChords() {
    if (ChromaticChord.C)
        return;
    if (!Chromatic.C)
        chromatics();

    (<any>ChromaticChord).initialize();
}

// SCALES
export function scales() {
    if (Scale.MAJOR)
        return;

    diatonicAltDegrees();
    intervalDiatonicAlts();
    chromatics();

    (<any>Scale).initialize();
};

// SOURCE SCALES
export function sourceScales() {
    if ((<any>SourceScaleUtils)._sourceScales)
        return;

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
    if (Tonality.C)
        return;

    scales();
    diatonicAlts();
    chromatics();
    intervalDiatonicAlts();
    diatonicAltChordPatterns();

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

// DEGREE FUNCTIONS
export function degreeFunctions() {
    if (DegreeFunction.I)
        return;
    (<any>DegreeFunction).initialize();
}

// DEGREE FUNCTIONS
export function diatonicDegrees() {
    if (DiatonicDegree.I)
        return;
    (<any>DiatonicDegree).initialize();
}

// DIATONIC ALT DEGREES
export function diatonicAltDegrees() {
    diatonicDegrees();
    diatonics();

    (<any>DiatonicAltDegree).initialize();
}

// TEMPERAMENTS
export function temperaments() {
    if (Temperament.EQUAL)
        return;

    intervalDiatonicAlts();

    (<any>Temperament).initialize();
}

// CHROMATIC SYMBOLIC PITCHES
export function chromaticSymbolicPitches() {
    if (ChromaticSymbolicPitch.A4)
        return;

    chromatics();

    (<any>ChromaticSymbolicPitch).initialize();
}

// INTERVAL DIATONIC
export function intervalDiatonics() {
    if (IntervalDiatonic.UNISON)
        return;

    (<any>IntervalDiatonic).initialize();
}

// CONCERT PITCHES
export function concertPitches() {
    if (ConcertPitch.A440)
        return;

    chromaticSymbolicPitches();

    (<any>ConcertPitch).initialize();
}

// TUNINGS
export function tunings() {
    if (Tuning.EQUAL_440)
        return;

    concertPitches();

    (<any>Tuning).initialize();
}

export function all() {
    diatonics();
    intervalDiatonics();
    diatonicChordPatterns();

    chromatics();
    chromaticChordPatterns();
    chromaticChords();

    diatonicAlts();
    diatonicDegrees();
    diatonicAltDegrees();
    intervalDiatonicAlts();
    diatonicAltChordPatterns();
    diatonicAltChords();

    scales();
    sourceScales();

    tonalities();

    degreeFunctions();

    chromaticSymbolicPitches();
    concertPitches();
    temperaments();
    tunings();


    settings();
}
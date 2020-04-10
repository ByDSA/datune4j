export * from './chords/chromatic/ChromaticChord';
export * from './chords/chromatic/ChromaticChordPattern';
export * from './CommonDifferentCalculator';
export * from './degrees/Chromatic';
export * from './degrees/ChromaticUtils';
export * from './degrees/Diatonic';
export * from './degrees/DiatonicAlt';
export * from './degrees/DiatonicUtils';
export * from './Hashing';
export * from './lang/Language';
export * from './lang/LanguageInterface';
export * from './lang/naming/Naming';
export * from './lang/naming/NamingChromatic';
export * from './lang/naming/NamingScale';
export * from './settings/DefaultSettings';
export * from './settings/Settings';
export * from './settings/SettingsInterface';
export * from './tonality/Scale';
export * from './tonality/ScaleModeUtils';
export * from './tonality/ScaleUtils';
export * from './tonality/Tonality';
export * from './tonality/TonalityUtils';
export * from './Utils';

// precalc
import * as precalc from './precalc';
precalc.scales();
precalc.sourceScales();
precalc.tonalities();
import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
export declare class NameChordCalculator {
    private chord;
    private rootDiatonicAlt;
    private pattern;
    private inversion;
    constructor(chord: ChromaticChord, rootDiatonicAlt: DiatonicAlt);
    get(): string;
    private patternName;
    private inversionName;
    private getInversionDiatonicAlt;
}

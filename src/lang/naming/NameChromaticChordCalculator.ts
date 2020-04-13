import { ChromaticChord } from '../../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { Chromatic } from '../../degrees/Chromatic';

export class NameChromaticChordCalculator {
    private pattern: ChromaticChordPattern;
    private inversion: number;

    constructor(private chord: ChromaticChord) {
    }

    public get(): string {
        this.pattern = this.chord.patternFromRoot;
        this.inversion = this.chord.inversionNumber;

        return this.chord.root.toString() + this.pattern.toStringShort() + this.inversionName();
    }

    private inversionName(): string {
        if (this.inversion == 0 || !this.pattern)
            return "";

        let str = "/" + this.getInversionChromatic().toString();

        return str;
    }

    private getInversionChromatic(): Chromatic {
        let semis: number = this.pattern.values[this.inversion];
        return this.chord.root.getShift(semis);
    }
}
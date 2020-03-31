import { ChromaticChord } from '../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { IntervalChromatic } from '../interval/IntervalChromatic';

export class NameChordCalculator {
    private pattern: ChromaticChordPattern;
    private inversion: number;

    constructor(private chord: ChromaticChord, private rootDiatonicAlt: DiatonicAlt) {
    }

    public get(): string {
        this.pattern = ChromaticChordPattern.from(this.chord);
        this.inversion = this.chord.getInversionNumber();

        return this.rootDiatonicAlt.toString() + this.patternName() + this.inversionName();
    }

    private patternName(): string {
        return (this.pattern ? this.pattern.toStringShort() : '');
    }

    private inversionName(): string {
        if (this.inversion == 0 || !this.pattern)
            return "";

        let str = "/" + this.getInversionDiatonicAlt().toString();

        return str;
    }

    private getInversionDiatonicAlt(): DiatonicAlt {
        let semis: number = this.pattern.getValues()[this.inversion];
        let intervalDiatonic: number = this.pattern.getDiatonicChordPattern().getValues()[this.inversion];
        let intervalChromatic = IntervalChromatic.fromSemisAndNotes(semis, intervalDiatonic);
        return this.rootDiatonicAlt.getShifted(intervalChromatic);
    }
}
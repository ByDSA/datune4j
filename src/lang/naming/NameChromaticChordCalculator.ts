import { ChromaticChord } from '../../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalChromatic } from '../../interval/IntervalChromatic';

export class NameChromaticChordCalculator {
    private pattern: ChromaticChordPattern;
    private inversion: number;

    constructor(private chord: ChromaticChord, private rootDiatonicAlt: DiatonicAlt) {
    }

    public get(): string {
        this.pattern = ChromaticChordPattern.from(this.chord);
        this.inversion = this.chord.inversionNumber;

        return this.rootDiatonicAlt.toString() + this.pattern.toStringShort() + this.inversionName();
    }

    private inversionName(): string {
        if (this.inversion == 0 || !this.pattern)
            return "";

        let str = "/" + this.getInversionDiatonicAlt().toString();

        return str;
    }

    private getInversionDiatonicAlt(): DiatonicAlt {
        let semis: number = this.pattern.values[this.inversion];
        let intervalDiatonic: number = this.pattern.diatonicChordPattern.values[this.inversion];
        let intervalChromatic = IntervalChromatic.fromSemisAndNotes(semis, intervalDiatonic);
        return this.rootDiatonicAlt.getShifted(intervalChromatic);
    }
}
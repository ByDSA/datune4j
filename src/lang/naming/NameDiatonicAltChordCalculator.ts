import { ChromaticChord } from '../../chords/chromatic/ChromaticChord';
import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalChromatic } from '../../interval/IntervalChromatic';
import { DiatonicAltChord } from 'chords/DiatonicAltChord';

export class NameDiatonicAltChordCalculator {
    private pattern: ChromaticChordPattern;
    private inversion: number;

    constructor(private chord: DiatonicAltChord) {
    }

    public get(): string {
        this.pattern = ChromaticChordPattern.fromDiatonicAltChord(this.chord);
        this.inversion = this.chord.inversionNumber;

        return this.chord.root.toString() + this.pattern.toStringShort() + this.inversionName();
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
        return this.chord.root.getShifted(intervalChromatic);
    }
}
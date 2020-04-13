import { DiatonicAltChord } from '../../chords/DiatonicAltChord';
import { DiatonicAltChordPattern, DiatonicAltChordPatternValueType } from '../../chords/DiatonicAltChordPattern';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';

export class NameDiatonicAltChordCalculator {
    private pattern: DiatonicAltChordPattern;
    private inversion: number;

    constructor(private chord: DiatonicAltChord) {
    }

    public get(): string {
        this.pattern = this.chord.patternFromRoot;
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
        let diatonicAltChordPatternValue: DiatonicAltChordPatternValueType = this.pattern.values[this.inversion];
        let intervalDiatonicAlt = IntervalDiatonicAlt.from(diatonicAltChordPatternValue.semis, diatonicAltChordPatternValue.diatonicIntValue);
        return this.chord.root.getAdd(intervalDiatonicAlt);
    }
}
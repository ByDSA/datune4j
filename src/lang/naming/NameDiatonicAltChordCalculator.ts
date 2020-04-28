import { DiatonicAltChord } from '../../chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern, DiatonicAltChordPatternValueType } from '../../chords/diatonicalt/DiatonicAltChordPattern';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { IntervalDiatonicAlt } from '../../interval/IntervalDiatonicAlt';
import { IntervalDiatonic } from '../../interval/IntervalDiatonic';

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
        let diatonicInterval = IntervalDiatonic.from(diatonicAltChordPatternValue.diatonicIntValue);
        let intervalDiatonicAlt = IntervalDiatonicAlt.from(diatonicAltChordPatternValue.semis, diatonicInterval);
        return this.chord.root.getAdd(intervalDiatonicAlt);
    }
}
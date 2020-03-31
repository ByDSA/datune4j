import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { IntervalChromatic } from '../interval/IntervalChromatic';
export class NameChordCalculator {
    constructor(chord, rootDiatonicAlt) {
        this.chord = chord;
        this.rootDiatonicAlt = rootDiatonicAlt;
    }
    get() {
        this.pattern = ChromaticChordPattern.from(this.chord);
        this.inversion = this.chord.getInversionNumber();
        return this.rootDiatonicAlt.toString() + this.patternName() + this.inversionName();
    }
    patternName() {
        return (this.pattern ? this.pattern.toStringShort() : '');
    }
    inversionName() {
        if (this.inversion == 0 || !this.pattern)
            return "";
        let str = "/" + this.getInversionDiatonicAlt().toString();
        return str;
    }
    getInversionDiatonicAlt() {
        let semis = this.pattern.getValues()[this.inversion];
        let intervalDiatonic = this.pattern.getDiatonicChordPattern().getValues()[this.inversion];
        let intervalChromatic = IntervalChromatic.fromSemisAndNotes(semis, intervalDiatonic);
        return this.rootDiatonicAlt.getShifted(intervalChromatic);
    }
}
//# sourceMappingURL=NameChordCalculator.js.map
package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.PitchOctaveEditable;

public interface PitchMidiInterface<D extends RelativeDegree, I extends Interval> extends PitchOctaveEditable, AbsoluteDegree<D, I> {
    default int getCode() { // provisional
        if (this instanceof PitchChromaticMidi)
            return this.getCode();
        else if (this instanceof PitchDiatonicMidi)
            return PitchChromaticMidi.from((PitchDiatonicMidi)this).getCode();
        else
            throw new RuntimeException();
    }
}

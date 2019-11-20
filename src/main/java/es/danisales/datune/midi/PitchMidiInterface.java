package es.danisales.datune.midi;

import es.danisales.datune.pitch.PitchOctaveEditable;

public interface PitchMidiInterface extends PitchOctaveEditable {
    default int getCode() { // provisional
        if (this instanceof PitchChromaticMidi)
            return this.getCode();
        else if (this instanceof PitchDiatonicMidi)
            return PitchChromaticMidi.from((PitchDiatonicMidi)this).getCode();
        else
            throw new RuntimeException();
    }
}

package es.danisales.datune.midi.pitch;

import es.danisales.datune.pitch.PitchException;
import es.danisales.datune.pitch.PitchOctaveEditable;

public interface PitchOctaveMidiEditable extends PitchOctaveEditable {
	default void setMinOctave() {
        try {
            setOctave(PitchChromaticMidi.MIN_OCTAVE);
        } catch (PitchException e) {
            e.printStackTrace();
            throw new RuntimeException("Impossible!"); // todo: hacer tests, porque puede que no sea impossible en PitchDiatonicMidi
        }
	}
}

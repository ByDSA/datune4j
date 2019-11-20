package es.danisales.datune.midi;

import es.danisales.datune.pitch.PitchOctaveEditable;

public interface PitchOctaveMidiEditable extends PitchOctaveEditable {
	default void setMinOctave() {
		setOctave(PitchChromaticMidi.MIN_OCTAVE);
	}
}

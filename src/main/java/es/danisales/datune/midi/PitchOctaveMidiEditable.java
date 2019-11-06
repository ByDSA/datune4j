package es.danisales.datune.midi;

import es.danisales.datune.pitch.PitchOctave;
import es.danisales.datune.pitch.PitchOctaveEditable;

public interface PitchOctaveMidiEditable extends PitchOctaveMidi, PitchOctaveEditable {
	default void setMinOctave() {
		setOctave(MIN_OCTAVE);
	}
}

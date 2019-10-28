package es.danisales.datune.midi;

import es.danisales.datune.pitch.PitchOctave;

public interface PitchOctaveMidi extends PitchOctave {
	int MIN_OCTAVE = 0;
	int MAX_OCTAVE = 10;
	
	default PitchMidi setMinOctave() {
		return setOctave(MIN_OCTAVE);
	}
}

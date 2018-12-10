package pitch;

import midi.Settings;
import tonality.Tonality;

public interface PitchMidiableChord<Target> extends PitchMidiable<Target> {	
	public default Target toMidi(Tonality t, int octave) {
		return toMidi(t, octave, Settings.DefaultValues.DURATION_CHORD);
	}
}
package pitch;

import diatonic.Tonality;
import midi.Settings;

public interface PitchMidiableSingle<This, Target> extends PitchMidiable<This, Target> {	
	public default Target toMidi(Tonality t, int octave) {
		return toMidi(t, octave, Settings.DefaultValues.DURATION_NOTE);
	}
}

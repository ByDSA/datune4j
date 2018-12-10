package pitch;

import midi.Settings;
import tonality.Tonality;

public interface PitchMidiable<Target> extends PitchInterface {
	public default Target toMidi(Tonality t) {
		return toMidi(t, Settings.DefaultValues.OCTAVE);
	}
	
	public Target toMidi(Tonality t, int octave);
	
	public default Target toMidi(Tonality t, int octave, int length) {
		return toMidi(t, octave, length, Settings.DefaultValues.VELOCITY);
	}
	
	public Target toMidi(Tonality t, int octave, int length, int velocity);
}

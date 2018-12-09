package pitch;

import diatonic.Tonality;
import midi.Settings;

public interface PitchMidiable<This, Target> extends PitchInterface<This> {
	public default Target toMidi(Tonality t) {
		return toMidi(t, Settings.DefaultValues.OCTAVE);
	}
	
	public Target toMidi(Tonality t, int octave);
	
	public default Target toMidi(Tonality t, int octave, int length) {
		return toMidi(t, octave, length, Settings.DefaultValues.VELOCITY);
	}
	
	public Target toMidi(Tonality t, int octave, int length, int velocity);
}

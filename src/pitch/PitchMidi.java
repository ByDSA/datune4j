package pitch;

public interface PitchMidi extends PitchOctave {
	public static final int MIN_OCTAVE = 0;
	public static final int MAX_OCTAVE = 10;
	
	public default NoteMidi setMinOctave() {
		return setOctave(MIN_OCTAVE);
	}
}

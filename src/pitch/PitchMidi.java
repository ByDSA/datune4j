package pitch;

public interface PitchMidi extends PitchChromaticable, PitchOctave {
	public static final int MIN_OCTAVE = 0;
	public static final int MAX_OCTAVE = 10;
	public static final int NOTES_PER_OCTAVE = 12;
	
	public default PitchMidiEnum setMinOctave() {
		return setOctave(MIN_OCTAVE);
	}
}

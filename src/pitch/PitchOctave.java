package pitch;

public interface PitchOctave extends PitchInterface {
	<T extends PitchOctave> T shiftOctave(int o);

	<T extends PitchOctave> T setOctave(int o);

	int getOctave();
}

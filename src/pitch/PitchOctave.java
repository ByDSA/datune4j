package pitch;

public interface PitchOctave<This> extends PitchInterface<This> {
	public static final int MIN = 0;
	public static final int MAX = 10;
	public This shiftOctave(int o);

	public This setOctave(int o);

	public int getOctave();
	
	public default This setMinOctave() {
		return setOctave(PitchOctave.MIN);
	}
}

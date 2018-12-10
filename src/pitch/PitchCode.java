package pitch;

public interface PitchCode<This extends PitchCode<This, DistType>, DistType> extends PitchChromaticableSingle, PitchOctave<This> {	
	public PitchMidi getPitchCode();
}

package pitch;

public interface PitchCode<This extends PitchCode<This, DistType>, DistType> extends PitchChromaticableSingle<This>, PitchOctave<This> {	
	public Pitch getPitchCode();
}

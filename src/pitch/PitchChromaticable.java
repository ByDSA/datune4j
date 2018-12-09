package pitch;

public interface PitchChromaticable<This> extends PitchInterface<This> {
	public float getPitchMean();
	/*public default float dist(PitchChromaticable<This> n) {
		return n.getPitchMean() - getPitchMean();
	}*/
}

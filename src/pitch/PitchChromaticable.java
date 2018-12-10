package pitch;

public interface PitchChromaticable extends PitchInterface {
	public float getPitchMean();
	/*public default float dist(PitchChromaticable<This> n) {
		return n.getPitchMean() - getPitchMean();
	}*/
}

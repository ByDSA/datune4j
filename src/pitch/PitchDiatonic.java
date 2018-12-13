package pitch;

import diatonic.Degree;

public interface PitchDiatonic<This extends PitchDiatonic<This, DistType>, DistType> extends PitchDiatonicable {
	public Degree getDegree();
	public DistType dist(This n2);
}
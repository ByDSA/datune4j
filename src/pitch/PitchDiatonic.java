package pitch;

import diatonic.Degree;

public interface PitchDiatonic<This extends PitchDiatonic<This, DistType>, DistType> extends PitchSingle {
	public Degree getDegree();
	public DistType dist(This n2);
}
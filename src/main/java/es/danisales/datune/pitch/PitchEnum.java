package es.danisales.datune.pitch;

public enum PitchEnum implements Pitch{
	A440(440);
	
	double f;

	PitchEnum(double f) {
		this.f = f;
	}

	@Override
	public double getFrequency() {
		return f;
	}
}

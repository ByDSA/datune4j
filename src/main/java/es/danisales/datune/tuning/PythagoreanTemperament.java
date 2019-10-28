package es.danisales.datune.tuning;

public class PythagoreanTemperament extends DiatonicTemperament {
	@Override
	public double semi() {
		return 256.0d/243;
	}
	
	@Override
	public double tone() {
		return 1.125;
	}

	public double fourth() {
		return 4.0d/3;
	}

	public double fifth() {
		return 1.5;
	}
}

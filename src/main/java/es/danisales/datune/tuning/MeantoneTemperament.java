package es.danisales.datune.tuning;

public class MeantoneTemperament extends DiatonicTemperament {
	public MeantoneTemperament() {
	}

	@Override
	public double semi() {
		double den = tone()*tone()*tone()*tone()*tone();
		return Math.sqrt(2/den);
	}

	@Override
	public double tone() {
		return Math.sqrt( 1.25 );
	}
}

package tuning;

public class EqualTemperament extends DiatonicTemperament {
	@Override
	public double semi() {
		return Math.pow( 2, 1/12.0d );
	}

	@Override
	public double tone() {
		return semi()*semi();
	}
}

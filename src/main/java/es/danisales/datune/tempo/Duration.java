package es.danisales.datune.tempo;

public enum Duration implements SymbolicDuration {
	MAXIMA(8), LONGA(4), DOUBLE(2), WHOLE(1), HALF(1/2.0d), QUARTER(1/4.0d), EIGHTH(1/8.0d), SIXTEENTH(1/16.0d), THIRTYSECOND(1/32.0d), SIXTYFOURTH(1/64.0d);
	
	double val;

    Duration(double n) {
		val = n;
	}

	public double getValue() {
    	return val;
	}
}

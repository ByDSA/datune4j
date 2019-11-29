package es.danisales.datune.tonality;

public class ScaleNonDiatonicException extends RuntimeException {
	public ScaleNonDiatonicException(Scale n) {
		super("La escala musical " + n + " no es diatónica.");
	}

	public static void check(Scale s) throws ScaleNonDiatonicException {
		if ( !s.isDiatonic() )
			throw new ScaleNonDiatonicException(s);
	}
}
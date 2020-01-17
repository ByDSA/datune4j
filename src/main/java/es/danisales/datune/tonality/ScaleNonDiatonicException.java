package es.danisales.datune.tonality;

@SuppressWarnings("WeakerAccess")
public class ScaleNonDiatonicException extends RuntimeException {
	public ScaleNonDiatonicException(Scale n) {
		super("La escala chords " + n + " no es diatónica.");
	}

	public static void check(Scale s) throws ScaleNonDiatonicException {
		if ( !s.isDiatonic() )
			throw new ScaleNonDiatonicException(s);
	}
}
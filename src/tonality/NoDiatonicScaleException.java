package tonality;

public class NoDiatonicScaleException extends RuntimeException {
	public NoDiatonicScaleException(Scale n) {
		super( "La escala musical " + n +  "no es diatónica.");
	}

	public static void check(Scale s) throws NoDiatonicScaleException {
		if ( !s.isDiatonic() )
			throw new NoDiatonicScaleException( s );
	}
}
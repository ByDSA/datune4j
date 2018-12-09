package midi;

import pitch.Pitch;
import pitch.PitchCode;

public class PitchException extends RuntimeException {
	public PitchException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

	public PitchException(PitchCode n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getPitchCode().val() );
	}

	public static boolean check(int code) {
		if ( code > Pitch.MAX.val() || code < Pitch.MIN.val() )
			throw new PitchException( code );

		return true;
	}

	public static boolean check(PitchCode n) {
		return check( n.getPitchCode().ordinal() );
	}
}
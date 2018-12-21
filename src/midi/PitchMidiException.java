package midi;

import pitch.NoteMidi;

public class PitchMidiException extends RuntimeException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

	public PitchMidiException(NoteMidi n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

	public static boolean check(int code) {
		if ( code > NoteMidi.MAX.getCode() || code < NoteMidi.MIN.getCode() )
			throw new PitchMidiException( code );

		return true;
	}

	public static boolean check(NoteMidi n) {
		return check( n.getCode() );
	}
}
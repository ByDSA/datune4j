package midi;

import pitch.PitchMidiEnum;
import pitch.PitchMidiSingle;

public class PitchMidiException extends RuntimeException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

	public PitchMidiException(PitchMidiSingle n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

	public static boolean check(int code) {
		if ( code > PitchMidiEnum.MAX.getCode() || code < PitchMidiEnum.MIN.getCode() )
			throw new PitchMidiException( code );

		return true;
	}

	public static boolean check(PitchMidiSingle n) {
		return check( n.getCode() );
	}
}
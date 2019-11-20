package es.danisales.datune.midi;

@SuppressWarnings("WeakerAccess")
public class PitchMidiException extends RuntimeException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

	public PitchMidiException(PitchChromaticMidi n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

	public static boolean check(int code) {
		if ( code > PitchChromaticMidi.MAX.getCode() || code < PitchChromaticMidi.MIN.getCode() )
			throw new PitchMidiException( code );

		return true;
	}

	public static boolean check(PitchChromaticMidi n) {
		return check( n.getCode() );
	}
}
package es.danisales.datune.midi;

public class PitchMidiException extends RuntimeException {
	public PitchMidiException(int n) {
		super( "La figura musical est� fuera de rango: " + n );
	}

	public PitchMidiException(PitchMidi n) {
		super( "La figura musical " + n + "est� fuera de rango: " + n.getCode() );
	}

	public static boolean check(int code) {
		if ( code > PitchMidi.MAX.getCode() || code < PitchMidi.MIN.getCode() )
			throw new PitchMidiException( code );

		return true;
	}

	public static boolean check(PitchMidi n) {
		return check( n.getCode() );
	}
}
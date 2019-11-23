package es.danisales.datune.midi;

@SuppressWarnings("WeakerAccess")
public class PitchMidiException extends RuntimeException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

    public PitchMidiException(PitchChromaticMidiInmutable n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

	public static boolean check(int code) {
        if (code > PitchChromaticMidi.MAX.getMidiCode() || code < PitchChromaticMidi.MIN.getMidiCode())
			throw new PitchMidiException( code );

		return true;
	}

    public static boolean check(PitchChromaticMidiInmutable n) {
		return check( n.getCode() );
	}
}
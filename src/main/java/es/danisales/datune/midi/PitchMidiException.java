package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.pitch.PitchException;

@SuppressWarnings("WeakerAccess")
public class PitchMidiException extends PitchException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

    public PitchMidiException(PitchChromaticMidiInmutable n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

    public PitchMidiException(Chromatic chromatic, int octave) {
        super("La figura musical está fuera de rango: " + chromatic + " " + octave);
    }

    public static boolean check(int code) throws PitchMidiException {
        if (code > PitchChromaticMidi.MAX.getMidiCode() || code < PitchChromaticMidi.MIN.getMidiCode())
			throw new PitchMidiException( code );

		return true;
	}

    public static boolean check(PitchChromaticMidiInmutable n) throws PitchMidiException {
		return check( n.getCode() );
	}
}
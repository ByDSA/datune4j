package es.danisales.datune.midi.pitch;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.pitch.PitchException;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings("WeakerAccess")
public class PitchMidiException extends PitchException {
	public PitchMidiException(int n) {
		super( "La figura musical está fuera de rango: " + n );
	}

	public PitchMidiException(@NonNull PitchChromaticMidiImmutable n) {
		super( "La figura musical " + n + "está fuera de rango: " + n.getCode() );
	}

	public PitchMidiException(@NonNull PitchDiatonicMidi n) {
		super("La figura musical está fuera de rango: Degree=" + n.degree + " Tonality=" + n.tonality + " Octave=" + n.octave);
	}

    public PitchMidiException(Chromatic chromatic, int octave) {
        super("La figura musical está fuera de rango: " + chromatic + " " + octave);
    }

    public static void check(int code) throws PitchMidiException {
        if (code > PitchChromaticMidi.MAX.getMidiCode() || code < PitchChromaticMidi.MIN.getMidiCode())
			throw new PitchMidiException( code );
	}

	public static void check(@NonNull PitchDiatonicMidi pitchDiatonicMidi) throws PitchMidiException {
		try {
			PitchChromaticMidi.from(pitchDiatonicMidi);
		} catch (RuntimeException e) {
			throw new PitchMidiException(pitchDiatonicMidi);
		}
	}
}
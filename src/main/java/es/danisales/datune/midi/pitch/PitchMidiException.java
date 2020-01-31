package es.danisales.datune.midi.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.pitch.PitchException;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings("WeakerAccess")
public class PitchMidiException extends PitchException {
	public PitchMidiException(int n) {
        super("PitchMidi out of range: " + n);
	}

	public PitchMidiException(@NonNull PitchChromaticMidiImmutable n) {
        super("PitchMidi of " + n + " is out of range: " + n.getCode());
	}

	public PitchMidiException(@NonNull PitchTonalMidi n) {
        super("PitchMidi out of range: ScaleDegree=" + n.degree + " Tonality=" + n.tonality + " Octave=" + n.octave);
	}

    public PitchMidiException(Chromatic chromatic, int octave) {
        super("PitchMidi out of range: " + chromatic + " " + octave);
    }

    public static void check(int code) throws PitchMidiException {
        if (code > PitchChromaticMidi.MAX.getMidiCode() || code < PitchChromaticMidi.MIN.getMidiCode())
			throw new PitchMidiException( code );
	}

	public static void check(@NonNull PitchTonalMidi pitchDiatonicMidi) throws PitchMidiException {
		try {
			PitchChromaticMidi.from(pitchDiatonicMidi);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new PitchMidiException(pitchDiatonicMidi);
		}
	}
}
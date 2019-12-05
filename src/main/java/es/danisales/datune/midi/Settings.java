package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;

public class Settings {
	public static final int VELOCITY_MAX = 127;
	public static class DefaultValues {
		public static final int OCTAVE = 5;
		public static final int VELOCITY = VELOCITY_MAX;
		public static final int VELOCITY_CHORD = 100;
		public static final int LENGTH_CHORD = Duration.L1;
		public static final int LENGTH_NOTE = Duration.L4;
		public static final Chromatic CHROMATIC = Chromatic.C;
        public static final PitchChromaticMidi PITCH_CHROMATIC_MIDI;

        static {
            try {
                PITCH_CHROMATIC_MIDI = PitchChromaticMidi.from(CHROMATIC, OCTAVE);
            } catch (PitchMidiException e) {
                throw new RuntimeException();
            }
        }
		public static final Scale SCALE = Scale.MAJOR;
		public static final Tonality TONALITY = Tonality.from(CHROMATIC, SCALE);
	}
}

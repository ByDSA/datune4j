package es.danisales.datune.midi;

import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityInterface;

public class Settings {
	public static final int VELOCITY_MAX = 127;
	public static class DefaultValues {
		public static final int OCTAVE = 5;
		public static final int VELOCITY = VELOCITY_MAX;
		public static final int DURATION_CHORD = Duration.V1;
		public static final int DURATION_NOTE = Duration.V4;
		public static final Chromatic CHROMATIC = Chromatic.C;
		public static final Scale SCALE = Scale.MAJOR;
		public static final Tonality TONALITY = Tonality.from(CHROMATIC, SCALE);
	}
}

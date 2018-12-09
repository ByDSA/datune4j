package midi;

import diatonic.ScaleEnum;
import diatonic.Tonality;
import pitch.Chromatic;

public class Settings {
	public static final int VELOCITY_MAX = 127;
	public static class DefaultValues {
		public static final int OCTAVE = 5;
		public static final int VELOCITY = VELOCITY_MAX;
		public static final int DURATION_CHORD = Duration.V1;
		public static final int DURATION_NOTE = Duration.V4;
		public static final Chromatic CHROMATIC = Chromatic.C;
		public static final ScaleEnum SCALE = ScaleEnum.MAJOR;
		public static final Tonality TONALITY = new Tonality(CHROMATIC, SCALE);
	}
}

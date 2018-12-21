package tuning;

import musical.Chromatic;
import pitch.SingleFrequency;

public abstract class Temperament<KEY> {
	public abstract <OCT extends Octave<KEY>> OCT makeOctave(KEY key, double noteBase);
}

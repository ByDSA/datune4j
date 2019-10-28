package es.danisales.datune.tuning;

public abstract class Temperament<KEY> {
	public abstract <OCT extends Octave<KEY>> OCT makeOctave(KEY key, double noteBase);
}

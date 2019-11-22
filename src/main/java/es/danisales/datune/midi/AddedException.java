package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.pitch.ChordNamer;

public class AddedException extends RuntimeException {
	public <N extends Note<P, D, I>, D extends RelativeDegree, I extends Interval, P extends PitchMidiInterface<D, I>> AddedException(N n, ChordMidi<N, D, I, P> c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir.");
	}
}
package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.pitch.ChordNamer;

public class AddedException extends RuntimeException {
    public <N extends Note<P>, I extends Interval, P extends PitchMidiInterface> AddedException(N n, ChordMidi<N, I, P> c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir.");
	}
}
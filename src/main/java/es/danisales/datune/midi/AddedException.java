package es.danisales.datune.midi;

import es.danisales.datune.pitch.ChordNamer;

public class AddedException extends RuntimeException {
	public <N extends PitchSingleMidi> AddedException(N n, ChordMidi<N> c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta a�adir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta a�adir.");
	}
}
package es.danisales.datune.midi;

public class AddedException extends RuntimeException {
	public <N extends PitchSingleMidi> AddedException(N n, ChordMidi<N> c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta a�adir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta a�adir.");
	}
}
package midi;

import pitch.ChordMidi;
import pitch.NoteMidiReal;
import pitch.PitchSingle;

public class AddedException extends RuntimeException {
	public <N extends NoteMidiReal> AddedException(N n, ChordMidi<N> c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta añadir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta añadir.");
	}
}
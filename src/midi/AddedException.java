package midi;

import pitch.ChordMidi;
import pitch.PitchInterface;

public class AddedException extends RuntimeException {
	public AddedException(PitchInterface n, ChordMidi c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta añadir (" + n + ")");
	}

	public AddedException(ChordMidi c) {
		super("Ya existe en el acorde (" + c.notesToString() + ") la nota que se intenta añadir.");
	}
}
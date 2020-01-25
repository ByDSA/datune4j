package es.danisales.datune.midi;

import es.danisales.datune.midi.pitch.PitchMidiInterface;

public class AddedException extends RuntimeException {
	AddedException(NoteMidi n, ChordMidi c) {
		super("Already exists " + n + " in chord (" + c + ").");
	}

	AddedException(ChordMidi c) {
		super("Already exists in chord (" + c + ").");
	}
}
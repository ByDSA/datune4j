package es.danisales.datune.midi;

public class AddedException extends RuntimeException {
	AddedException(NoteMidi n, ChordMidi c) {
		super("Already exists " + n + " in chord (" + c + ").");
	}
}
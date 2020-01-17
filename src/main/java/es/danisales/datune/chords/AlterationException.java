package es.danisales.datune.chords;

public class AlterationException extends RuntimeException {
	public AlterationException() {
		super("Error altering the note");
	}
}

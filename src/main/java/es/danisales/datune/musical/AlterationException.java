package es.danisales.datune.musical;

public class AlterationException extends RuntimeException {
	public AlterationException() {
		super("Error altering the note");
	}
}

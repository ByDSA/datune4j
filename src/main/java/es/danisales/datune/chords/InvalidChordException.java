package es.danisales.datune.chords;

public class InvalidChordException extends RuntimeException {

    public InvalidChordException() {
        super("Acorde imposible");
    }
}

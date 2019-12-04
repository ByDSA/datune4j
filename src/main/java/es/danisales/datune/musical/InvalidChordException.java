package es.danisales.datune.musical;

public class InvalidChordException extends RuntimeException {

    public InvalidChordException() {
        super("Acorde imposible");
    }
}

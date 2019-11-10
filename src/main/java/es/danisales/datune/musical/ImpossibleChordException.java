package es.danisales.datune.musical;

public class ImpossibleChordException extends RuntimeException {

    public ImpossibleChordException() {
        super("Acorde imposible");
    }
}

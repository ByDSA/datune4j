package es.danisales.datune.chords;

@SuppressWarnings("WeakerAccess")
public class ChordCreationException extends RuntimeException {
    public ChordCreationException() {
        super("Acorde imposible");
    }
}

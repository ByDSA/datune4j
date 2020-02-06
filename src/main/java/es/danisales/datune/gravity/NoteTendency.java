package es.danisales.datune.gravity;

import es.danisales.datune.degrees.octave.Chromatic;
import javafx.util.Pair;
import org.checkerframework.checker.nullness.qual.NonNull;

public class NoteTendency {
    public enum Type {
        TRITONE, SUS4, SUS4_inv, SUS2, DOMINANT
    }
    private final Pair<Chromatic, Chromatic> pair;
    private final Type type;

    private NoteTendency(@NonNull Chromatic key, @NonNull Chromatic value, @NonNull Type type) {
        pair = new Pair<>(key, value);
        this.type = type;
    }

    public static NoteTendency from(Chromatic key, Chromatic value, Type type) {
        return new NoteTendency(key, value, type);
    }

    public Chromatic getFrom() {
        return pair.getKey();
    }

    @SuppressWarnings("WeakerAccess")
    public Chromatic getTo() {
        return pair.getValue();
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return getFrom() + "=>" + getTo() + " (" + type + ")";
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof NoteTendency) )
            return false;

        NoteTendency noteTendency = (NoteTendency)o;

        return pair.equals(noteTendency.pair) && type.equals(noteTendency.type);
    }

    @Override
    public int hashCode() {
        return pair.hashCode() + type.hashCode();
    }
}

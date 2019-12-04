package es.danisales.datune.degree;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Grado cromático
 */
public enum ChromaticDegree implements Degree {
    I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII;

    @NonNull
    @Override
    public ChromaticDegree getPrevious() {
        int index = ordinal() - 1;
        if (index < 0)
            index += values().length;

        return values()[index];
    }

    @NonNull
    @Override
    public ChromaticDegree getNext() {
        int index = ordinal() + 1;
        index %= values().length;
        return values()[index];
    }

    @Override
    public String toString() {
        return "Chromatic Degree " + super.toString();
    }
}

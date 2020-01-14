package es.danisales.datune.degree;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum PentatonicDegree implements Degree {
	I, II, III, IV, V;

    @NonNull
    @Override
    public PentatonicDegree getPrevious() {
        int index = ordinal() - 1;
        if (index < 0)
            index += values().length;

        return values()[index];
    }

    @NonNull
    @Override
    public PentatonicDegree getNext() {
        int index = ordinal() + 1;
        index %= values().length;
        return values()[index];
    }

    @Override
    public String toString() {
        return "Pentatonic Degree " + super.toString();
    }
}

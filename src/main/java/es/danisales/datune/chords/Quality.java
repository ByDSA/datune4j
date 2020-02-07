package es.danisales.datune.chords;

import es.danisales.datune.lang.Nominator;

public enum Quality {
    PERFECT, MAJOR, MINOR, AUGMENTED, DIMINISHED, UNDEFINED;

    @Override
    public String toString() {
        return Nominator.longFrom(this);
    }
}
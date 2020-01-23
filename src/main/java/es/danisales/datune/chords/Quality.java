package es.danisales.datune.chords;

import es.danisales.datune.lang.Namer;

public enum Quality {
    PERFECT, MAJOR, MINOR, AUGMENTED, DIMINISHED, INDETERMINATED;

    @Override
    public String toString() {
        return Namer.longFrom(this);
    }
}
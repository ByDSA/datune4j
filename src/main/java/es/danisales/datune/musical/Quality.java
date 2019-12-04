package es.danisales.datune.musical;

import es.danisales.datune.musical.transformations.Namer;

public enum Quality {
    PERFECT, MAJOR, MINOR, AUGMENTED, DIMINISHED, INDETERMINATED;

    @Override
    public String toString() {
        return Namer.longFrom(this);
    }
}
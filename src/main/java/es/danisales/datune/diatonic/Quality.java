package es.danisales.datune.diatonic;

import es.danisales.datune.musical.transformations.Namer;

public enum Quality {
    PERFECT, MAJOR, MINOR, AUGMENTED, DIMINISHED, INDETERMINATED;

    @Override
    public String toString() {
        return Namer.longFrom(this);
    }
}
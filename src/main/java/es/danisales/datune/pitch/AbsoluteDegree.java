package es.danisales.datune.pitch;

import es.danisales.datune.degree.Degree;

interface AbsoluteDegree<D extends Degree> {
    D getDegree();
    default int ordinal() {
        return getDegree().ordinal();
    }
}

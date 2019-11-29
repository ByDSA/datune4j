package es.danisales.datune.pitch;

import es.danisales.datune.degree.RelativeDegree;

interface AbsoluteDegree<D extends RelativeDegree> {
    D getDegree();
    default int ordinal() {
        return getDegree().ordinal();
    }
}

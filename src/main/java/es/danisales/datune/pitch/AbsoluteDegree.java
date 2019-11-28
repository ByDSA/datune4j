package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;

interface AbsoluteDegree<D extends RelativeDegree, I extends Interval> {
    D getDegree();
    default int ordinal() {
        return getDegree().ordinal();
    }
}

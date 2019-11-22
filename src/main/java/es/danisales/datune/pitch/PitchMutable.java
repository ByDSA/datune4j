package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;

public interface PitchMutable<I extends Interval> extends Cloneable {
    void shift(I interval);
    void shiftNegative(I interval);

    PitchMutable<I> clone();
}

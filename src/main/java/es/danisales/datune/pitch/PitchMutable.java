package es.danisales.datune.pitch;

import es.danisales.datune.interval.Interval;

public interface PitchMutable<I extends Interval> extends Cloneable {
    void shift(I interval) throws PitchException;

    void shiftNegative(I interval) throws PitchException;

    PitchMutable<I> clone();
}

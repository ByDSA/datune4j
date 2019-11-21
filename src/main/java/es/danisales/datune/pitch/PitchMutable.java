package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;

public interface PitchMutable<I extends Interval> {
    void shift(I interval);
    void shiftNegative(I interval);
}

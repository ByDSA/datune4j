package es.danisales.datune.chords;

import es.danisales.datune.interval.Interval;

public interface IntervalShifter<I extends Interval> {
    void shift(I intervalChromatic);
    void shiftNegative(I intervalChromatic);
}

package es.danisales.datune.pitch;

import es.danisales.datune.interval.IntervalDiatonic;

public interface PitchDiatonicMutable extends PitchMutable<IntervalDiatonic> {
    @Override void shift(IntervalDiatonic intervalDiatonic);
    @Override void shiftNegative(IntervalDiatonic intervalDiatonic);
}
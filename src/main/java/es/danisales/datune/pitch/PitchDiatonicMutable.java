package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.IntervalDiatonic;

public interface PitchDiatonicMutable extends PitchMutable<IntervalDiatonic> {
    @Override void shift(IntervalDiatonic intervalDiatonic);
    @Override void shiftNegative(IntervalDiatonic intervalDiatonic);
}
package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.IntervalDiatonic;

public interface PitchDiatonic {
    PitchDiatonic getShifted(IntervalDiatonic intervalDiatonic);
    PitchDiatonic getShiftedNegative(IntervalDiatonic intervalDiatonic);
}
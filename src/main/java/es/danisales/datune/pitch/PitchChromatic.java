package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.IntervalChromatic;

public interface PitchChromatic {
    PitchChromatic getShifted(IntervalChromatic intervalChromatic);
    PitchChromatic getShiftedNegative(IntervalChromatic intervalChromatic);
}
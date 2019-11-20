package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Diatonic;

public interface PitchDiatonicSingle extends AbsoluteDegree<DiatonicDegree>, SymbolicPitch {
	Diatonic getDiatonic();
	PitchDiatonicSingle getShifted(IntervalDiatonic intervalDiatonic);
	PitchDiatonicSingle getShiftedNegative(IntervalDiatonic intervalDiatonic);
}

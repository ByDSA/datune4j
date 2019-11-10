package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Diatonic;

public interface PitchDiatonicSingle extends PitchDiatonic, SymbolicPitch {
	Diatonic getDiatonic();
	PitchDiatonicSingle getShifted(IntervalDiatonic i);
}

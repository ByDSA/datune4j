package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.musical.Diatonic;

public interface PitchDiatonicSingle extends AbsoluteDegree<DiatonicDegree, IntervalDiatonic>, PitchDiatonic, SymbolicPitch {
	Diatonic getDiatonic();
	@Override PitchDiatonicSingle getNext();
	@Override PitchDiatonicSingle getPrevious();
	@Override PitchDiatonicSingle getShifted(IntervalDiatonic intervalDiatonic);
	@Override PitchDiatonicSingle getShiftedNegative(IntervalDiatonic intervalDiatonic);
}

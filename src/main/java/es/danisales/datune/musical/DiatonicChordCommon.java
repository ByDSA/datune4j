package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.pitch.PitchDiatonicSingle;

public interface DiatonicChordCommon<N extends PitchDiatonicSingle> extends ChordCommon<N>, PitchDiatonic {
	DiatonicChordCommon getShifted(IntervalDiatonic intervalDiatonic);
}

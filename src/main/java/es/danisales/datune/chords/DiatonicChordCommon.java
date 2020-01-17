package es.danisales.datune.chords;

import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.pitch.PitchDiatonicSingle;

public interface DiatonicChordCommon<N extends PitchDiatonicSingle> extends ChordCommon<N>, PitchDiatonic {
	//DiatonicChordCommon<N> getShifted(IntervalDiatonic intervalDiatonic);
}

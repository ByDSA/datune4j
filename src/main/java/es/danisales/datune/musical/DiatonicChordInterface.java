package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Collections;

interface DiatonicChordInterface extends DiatonicChordCommon<Diatonic> {
	static @NonNull DiatonicChordInterface from(@NonNull Collection<Diatonic> diatonicChord) {
		return DiatonicChordAdapter.from(diatonicChord);
	}
	
	static @NonNull DiatonicChordInterface from(@NonNull DiatonicFunction f) {
		return DiatonicChordAdapter.from(f);
	}

	@Override
	DiatonicChordInterface getShifted(IntervalDiatonic i);

	@Override
	DiatonicChordInterface duplicate();
}

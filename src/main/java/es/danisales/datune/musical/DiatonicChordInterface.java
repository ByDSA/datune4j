package es.danisales.datune.musical;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

interface DiatonicChordInterface extends DiatonicChordCommon<Diatonic> {
	static @NonNull DiatonicChordInterface from(@NonNull Collection<Diatonic> diatonicChord) {
		return DiatonicChordInterfaceAdapter.from(diatonicChord);
	}
}

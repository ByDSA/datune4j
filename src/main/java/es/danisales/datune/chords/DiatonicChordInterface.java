package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Diatonic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

interface DiatonicChordInterface extends DiatonicChordCommon<Diatonic> {
	static @NonNull DiatonicChordInterface from(@NonNull Collection<Diatonic> diatonicChord) {
		return DiatonicChordInterfaceAdapter.from(diatonicChord);
	}
}

package es.danisales.datune.chords;

import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.pitch.SymbolicPitch;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
interface ChordCommon<N extends SymbolicPitch> extends List<N> {
	int getRootIndex();

	@Nullable N getRoot();

	default @NonNull N getCyclic(int noteNumber) throws PitchMidiException {
		while (noteNumber < 0)
			noteNumber += size();

		return get(noteNumber % size());
	}

	default int getInversionNumber() {
		int rootPos = getRootIndex();
		if (rootPos > 0)
			return size() - rootPos;
		else
			return 0;
	}
}

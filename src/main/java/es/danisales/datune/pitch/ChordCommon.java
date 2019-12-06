package es.danisales.datune.pitch;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends SymbolicPitch> extends List<N> {
	int getRootIndex();

	@Nullable N getRoot();

	default <E extends PitchException> @NonNull N getCyclic(int noteNumber) throws E {
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

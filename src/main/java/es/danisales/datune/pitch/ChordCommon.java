package es.danisales.datune.pitch;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends SymbolicPitch> extends List<N> {
	int NO_INVERSION = -1;

	int getRootIndex();

	@NonNull N getRoot();

	default int getInversionNumber() {
		int rootPos = getRootIndex();
		if (rootPos >= 0)
			return size() - rootPos;
		else
			return NO_INVERSION;
	}

	// todo: move (make private)
	default int _hashCode() { // si se usa hashCode normal, no se puede usar en enum, donde no se peude sobreescribir
		if (size() == 0)
			return 0;

		int result = 1;

		for (N element : this)
			result = 31 * result + (element == null ? 0 : element.hashCode());
		result = 37 * result + getRootIndex();

		return result;
	}
}

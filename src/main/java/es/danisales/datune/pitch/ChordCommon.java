package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.RelativeDegree;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends AbsoluteDegree<D, I>, D extends RelativeDegree, I extends Interval> extends List<N> {
	int getRootPos();
	@Nullable N getRoot();
	default int getInversionNumber() {
		int rootPos = getRootPos();
		if (rootPos >= 0)
			return size() - rootPos;
		else
			return -1;
	}
	ChordCommon<N, D, I> duplicate(); // Si se usa clone, no se puede definir como default en la interfaz p. ej. DiatonicChordInterface

	default int _hashCode() { // si se usa hashCode normal, no se puede usar en enum, donde no se peude sobreescribir
		if (size() == 0)
			return 0;

		int result = 1;

		for (N element : this)
			result = 31 * result + (element == null ? 0 : element.hashCode());
		result = 37 * result + getRootPos();

		return result;
	}
}

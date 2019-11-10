package es.danisales.datune.pitch;

import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends SymbolicPitch> extends List<N>, Cloneable {
	<T extends ChordCommon<N>> List<T> getAllInversions();
	int getRootPos();
	<T extends ChordCommon<N>> T getInv(int n);
	@Nullable N getRoot();
	default int getInversionNumber() {
		int rootPos = getRootPos();
		if (rootPos >= 0)
			return size() - rootPos;
		else
			return -1;
	}
	default <T extends ChordCommon<N>> T getInv() {
		return getInv(1);
	}

	@Nullable ChordCommon<N> getOver(@Nonnull N c);
}

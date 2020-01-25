package es.danisales.datune.chords;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

// Common Immutable-Mutable Chord's Stuff
public interface ChordCommon<N extends Cloneable>
		extends List<N> {
	int getRootIndex();

	@Nullable N getRoot();

	default int getInversionNumber() {
		int rootPos = getRootIndex();
		if (rootPos > 0)
			return size() - rootPos;
		else
			return 0;
	}
}

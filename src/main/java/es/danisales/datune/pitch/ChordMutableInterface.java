package es.danisales.datune.pitch;

import es.danisales.datune.interval.Interval;
import es.danisales.datune.musical.InvalidChordException;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;

import static com.google.common.base.Preconditions.checkState;

public interface ChordMutableInterface<N extends SymbolicPitch, I extends Interval>
		extends ChordCommon<N>, PitchMutable<I>, Cloneable {
	default void resetRoot() {
		if ( isEmpty() )
			return;

		setRootIndex(0);
	}

	void setRootIndex(int pos);

	default void removeInv() throws PitchException {
        inv(getRootIndex());
        checkState(getRootIndex() == 0, getRootIndex());
    }

	default void over(@NonNull N b) throws PitchException {
		for (int i = 0; i < size(); i++) {
			if (get(0).equals(b))
				return;
			inv();
		}

		throw new InvalidChordException();
	}

	default void inv() throws PitchException {
		inv( 1 );
	}

	default void inv(int n) throws PitchException {
		if ( n == 0 )
			return;
		Collections.rotate(this, -n);
		int rootIndex = MathUtils.rotativeTrim(getRootIndex() - n, size());
		setRootIndex(rootIndex);
	}

	ChordMutableInterface<N, I> clone();
}

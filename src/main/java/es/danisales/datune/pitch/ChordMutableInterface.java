package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.musical.ImpossibleChordException;
import es.danisales.utils.MathUtils;

import java.util.Collections;

public interface ChordMutableInterface<N extends SymbolicPitch, I extends Interval>
		extends ChordCommon<N>, PitchMutable<I>, Cloneable {
	default void resetRoot() {
		if ( isEmpty() )
			return;

		setRootIndex(0);
	}

	void setRootIndex(int pos);

	default void over(N b) {
		for (int i = 0; i < size(); i++) {
			if (get(0).equals(b))
				return;
			inv();
		}

		throw new ImpossibleChordException();
	}

	default void inv() {
		inv( 1 );
	}

	default void inv(int n) {
		if ( n == 0 )
			return;
		Collections.rotate(this, -n);
		int rootIndex = MathUtils.rotativeTrim(getRootIndex() - n, size());
		setRootIndex(rootIndex);
	}

	ChordMutableInterface<N, I> clone();
}

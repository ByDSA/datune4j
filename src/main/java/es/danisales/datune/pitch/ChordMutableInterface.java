package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.musical.ImpossibleChordException;
import es.danisales.utils.MathUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ChordMutableInterface<N, I extends Interval> extends ChordCommon<N>, PitchMutable<I>, Cloneable {
	default <T extends ChordMutableInterface<N, I>> List<T> getAllInversions() {
		List<T> ret = new ArrayList<>();

		T last = (T) this.clone();
		for ( int i = 0; i < size(); i++ ) {
			ret.add((T) last.clone());
			if (i < size()-1)
				last.inv();
		}

		return ret;
	}

	default void resetRoot() {
		if ( isEmpty() )
			return;

		setRootPos( 0 );
	}

	void setRootPos(int pos);

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
		int rootIndex = MathUtils.rotativeTrim(getRootPos()-n, size());
		setRootPos(rootIndex);
	}

	ChordMutableInterface<N, I> clone();

	default <T extends ChordCommon<N>> T removeHigherDuplicates() { // todo: move
		ChordMutableInterface<N, I> out = clone();
		for ( N n : this ) {
			boolean found = false;

			if ( !found )
				out.add( n );
		}

		this.clear();
		this.addAll(out);

		return (T)out;
	}
}

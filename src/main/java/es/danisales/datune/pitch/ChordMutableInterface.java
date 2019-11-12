package es.danisales.datune.pitch;

import es.danisales.datune.musical.*;
import es.danisales.utils.MathUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public interface ChordMutableInterface<N extends SymbolicPitch> extends ChordCommon<N> {
	ChordMutableInterface<N> duplicate();

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

	// todo: protected
	default Boolean updateWhatIsIt() {
		return updateWhatIsIt(
				(List<CustomChromaticChord> chords, ChordCommon<?> self) -> chords.get( 0 )
		);
	}

	Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord);

	Boolean updateWhatIsItIfNeeded();

	default <T extends ChordCommon<N>> T removeHigherDuplicates() {
		ChordMutableInterface<N> out = duplicate();
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

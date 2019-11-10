package es.danisales.datune.pitch;

import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.musical.ImpossibleChordException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BiFunction;

public interface ChordMutableInterface<N extends SymbolicPitch> extends ChordCommon<N> {
	ChordMutableInterface<N> clone();

	default void resetRoot() {
		if ( isEmpty() )
			return;

		setRootPos( 0 );
	}

	void setRootPos(int pos);

	default void inv() {
		inv( 1 );
	}

	default void inv(int n) {
		if ( size() < 2 || n == 0 )
			return;

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;
			add( remove( 0 ) );

			if ( updateRoot )
				setRootPos( size() - 1 );
		}

		if ( n < 0 ) {
			int lastIndex = size() - 1;

			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;
				add( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRootPos( 0 );
			}
		}
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
		ChordMutableInterface<N> out = clone();
		for ( N n : this ) {
			boolean found = false;

			if ( !found )
				out.add( n );
		}

		this.clear();
		this.addAll(out);

		return (T)out;
	}

	default @Nullable ChordMutableInterface<N> getOver(@Nonnull N c) {
		ChordMutableInterface<N> dup = clone();
		dup.addAll(this);
		dup.over(c);

		return dup;
	}

	default void over(@Nonnull N c) throws ImpossibleChordException {
		for(int i = 0; i < size(); i++) {
			if ( get(0).equals( c ) )
				return;
			if (i < size()-1)
				inv();
		}

		throw new ImpossibleChordException();
	}
}

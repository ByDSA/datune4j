package es.danisales.datune.pitch;

import es.danisales.datune.midi.AddedException;
import es.danisales.datune.musical.CustomChromaticChord;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public interface ChordMutableInterface<N extends SymbolicPitch> extends ChordCommon<N> {
	/*default ChordMutableInterface<N> inv(int n) {
		if ( size() < 2 || n == 0 )
			return this;

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;
			addSemi( remove( 0 ) );

			if ( updateRoot )
				setRootPos( size() - 1 );
		}

		if ( n < 0 ) {
			int lastIndex = size() - 1;

			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;
				addSemi( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRootPos( 0 );
			}
		}

		return this;
	}*/
	
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
	default <T extends ChordCommon<N>> T add(N... cs) throws AddedException {
		this.addAll(Arrays.asList(cs));
		return (T) this;
	}
	
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
	
	default Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(List<CustomChromaticChord> chords, ChordCommon<?> self) -> chords.get( 0 )
				);
	}

	Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord);

	Boolean updateWhatIsItIfNeeded();
	<T extends ChordCommon<N>> T add(ChordCommon<N> cs) throws AddedException;
	<T extends ChordCommon<N>> T add(int pos, N... ns) throws AddedException;
}

package pitch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import midi.AddedException;
import musical.CustomChromaticChord;

public interface ChordMutableInterface<N extends PitchSingle> extends ChordInterface<N> {
	public default ChordMutableInterface<N> inv(int n) {
		if ( size() < 2 || n == 0 )
			return (ChordMutableInterface<N>) this;

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;
			add( remove( 0 ) );

			if ( updateRoot )
				setRoot( size() - 1 );
		}

		if ( n < 0 ) {
			int lastIndex = size() - 1;

			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;
				add( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRoot( 0 );
			}
		}

		return (ChordMutableInterface<N>) this;
	}
	
	public ChordMutableInterface<N> clone();
	
	public default <T extends ChordInterface<N>> T resetRoot() {
		if ( size() == 0 )
			return null;

		setRoot( 0 );

		return (T)this;
	}
	
	public default <T extends ChordInterface<N>> T removeHigherDuplicates() {
		ChordMutableInterface<N> out = (ChordMutableInterface<N>)clone();
		for ( N n : this ) {
			boolean found = false;

			if ( !found )
				out.add( n );
		}

		this.clear();
		for ( N n : out )
			add( n );
		
		return (T)out;
	}
	
	public default Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(List<CustomChromaticChord> chords, ChordInterface<?> self) -> {
				return chords.get( 0 );
			}
				);
	}

	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordInterface<?>, CustomChromaticChord> fSelectChord);

	public Boolean updateWhatIsItIfNeeded();
	
	public <T extends ChordInterface<N>> T setRoot(int n);
	public <T extends ChordInterface<N>> T add(ChordInterface<N> cs) throws AddedException;
	public <T extends ChordInterface<N>> T add(int pos, N... ns) throws AddedException;
}

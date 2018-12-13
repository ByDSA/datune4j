package pitch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import chromaticchord.CustomChromaticChord;
import midi.AddedException;

public interface PitchChordMutable<N extends PitchSingle, Ret> extends PitchChord<N, Ret> {
	public void removeHigherDuplicates();
	public boolean add(N... cs) throws AddedException;
	public <T extends PitchChord<N, Ret>> boolean add(T cs) throws AddedException;
	public void add(int pos, N... ns) throws AddedException;
	public default <T extends PitchChord<? extends N, ? extends Ret>> T inv() {
		return inv( 1 );
	}

	public default <T extends PitchChord<? extends N, ? extends Ret>> T inv(int n) {
		if ( size() < 2 || n == 0 )
			return (T) this;

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

		return (T) this;
	}
	
	public PitchChord<N, Ret> clone();
	
	public default <T extends PitchChord<? extends N, ? extends Ret>> T resetRoot() {
		if ( size() == 0 )
			return null;

		setRoot( 0 );

		return (T)this;
	}
	
	public default Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(List<CustomChromaticChord> chords, PitchChord<?, ?> self) -> {
				return chords.get( 0 );
			}
				);
	}

	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, PitchChord<?, ?>, CustomChromaticChord> fSelectChord);

	public Boolean updateWhatIsItIfNeeded();
}

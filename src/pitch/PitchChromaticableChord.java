package pitch;

import java.util.ArrayList;
import java.util.function.BiFunction;

public interface PitchChromaticableChord<N extends PitchChromaticableSingle<N>, This extends PitchChromaticableChord<N, This, DistType>, DistType>
		extends PitchChord<N, This, DistType>, PitchChromaticable<This> {
	public default <Array extends PitchChromaticableChord<N, Array, DistType>> boolean hasSameNotesOrder(Array notes) {
		if ( size() != notes.size() )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).getChromatic().val() != notes.get( i ).getChromatic().val() )
				return false;
		}

		return true;
	}

	public default boolean equalsEnharmonic(PitchChromaticableChord<? extends PitchChromaticableSingle, ?, ?> ca) {
		if ( size() != ca.size() )
			return false;
		for ( int i = 0; i < size(); i++ )
			if ( !get( i ).getChromatic().equalsEnharmonic( ca.get( i ).getChromatic() ) )
				return false;

		if ( getRootPos() != ca.getRootPos() )
			return false;

		return true;
	}

	public default Boolean updateWhatIsIt() {
		return updateWhatIsIt(
			(ArrayList<ChromaticChord> chords, PitchChromaticableChord<?, ?, ?> self) -> {
				return chords.get( 0 );
			}
		);
	}

	public default void removeHigherDuplicates() {
		This out = this.newArray();
		for ( N n : this ) {
			boolean found = false;

			if ( !found )
				out.add( n );
		}

		this.clear();
		for ( N n : out )
			add( n );
	}

	public Boolean updateWhatIsIt(BiFunction<ArrayList<ChromaticChord>, PitchChromaticableChord<?, ?, ?>, ChromaticChord> fSelectChord);

	public Boolean updateWhatIsItIfNeeded();

	public boolean resetRoot();

	public boolean setRoot(int n);

	public N getRoot();

	public int getRootPos();

	public int getInversionNumber();

	public This inv();

	public This inv(int n);

	/*
	 * public boolean equalsEnharmonic(ChromaticChord cc); public boolean
	 * equalsEnharmonicInv(ChromaticChord cc); public boolean
	 * equalsEnharmonicInvArray(ChromaticChord[] cc); public boolean
	 * equalsEnharmonicArray(ChromaticChord[] cc); public boolean
	 * equalsArray(ChromaticChord[] cc);
	 */

	public default <Array extends PitchChromaticableChord<N, ?, ?>> boolean equalsEnharmonicInv(Array cc) {
		Array cc2 = (Array) cc.duplicate();
		for ( int i = 0; i < cc2.size(); i++, cc2.inv() ) {
			if ( this.equalsEnharmonic( cc2 ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?, ?>> boolean equalsEnharmonicInvArray(Array[] ccs) {
		for ( Array cc : ccs ) {
			if ( this.equalsEnharmonicInv( cc ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?, ?>> boolean equalsEnharmonicArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equalsEnharmonic( c ) )
				return true;
		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?, ?>> boolean equalsArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equals( c ) )
				return true;
		return false;
	}
}
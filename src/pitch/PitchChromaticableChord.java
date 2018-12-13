package pitch;

import java.util.ArrayList;
import java.util.function.BiFunction;

import chromaticchord.CustomChromaticChord;

public interface PitchChromaticableChord<N extends PitchChromaticableSingle, DistType>
		extends PitchChord<N, DistType>, PitchChromaticable {
	public default <Array extends PitchChromaticableChord<N, DistType>> boolean hasSameNotesOrder(Array notes) {
		if ( size() != notes.size() )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).getChromatic().val() != notes.get( i ).getChromatic().val() )
				return false;
		}

		return true;
	}

	public default boolean equalsEnharmonic(PitchChromaticableChord<? extends PitchChromaticableSingle, ?> ca) {
		if ( size() != ca.size() )
			return false;
		for ( int i = 0; i < size(); i++ )
			if ( !get( i ).getChromatic().equalsEnharmonic( ca.get( i ).getChromatic() ) )
				return false;

		if ( getRootPos() != ca.getRootPos() )
			return false;

		return true;
	}

	public default void removeHigherDuplicates() {
		PitchChromaticableChord<N, DistType> out = this.newArray();
		for ( N n : this ) {
			boolean found = false;

			if ( !found )
				out.add( n );
		}

		this.clear();
		for ( N n : out )
			add( n );
	}
/*

	

*/

	public N getRoot();

	public int getRootPos();

	public int getInversionNumber();

	/*
	 * public boolean equalsEnharmonic(ChromaticChord cc); public boolean
	 * equalsEnharmonicInv(ChromaticChord cc); public boolean
	 * equalsEnharmonicInvArray(ChromaticChord[] cc); public boolean
	 * equalsEnharmonicArray(ChromaticChord[] cc); public boolean
	 * equalsArray(ChromaticChord[] cc);
	 */

	public default <Array extends PitchChromaticableChord<N, ?>> boolean equalsEnharmonicInv(Array cc) {
		CustomChromaticChord cc2 = new CustomChromaticChord( cc );
		for ( int i = 0; i < cc2.size(); i++, cc2.inv() ) {
			if ( this.equalsEnharmonic( cc2 ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?>> boolean equalsEnharmonicInvArray(Array[] ccs) {
		for ( Array cc : ccs ) {
			if ( this.equalsEnharmonicInv( cc ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?>> boolean equalsEnharmonicArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equalsEnharmonic( c ) )
				return true;
		return false;
	}

	public default <Array extends PitchChromaticableChord<N, ?>> boolean equalsArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equals( c ) )
				return true;
		return false;
	}
}
package pitch;

import java.util.Arrays;
import java.util.List;

import diatonic.Quality;
import musical.Chromatic;
import musical.ChromaticChordEnum;
import musical.CustomChromaticChord;
import musical.CustomChromaticChord.ImpossibleChord;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordInterface<N> {	
	boolean hasSameNotes(PitchChromaticChord<N> chord);
	
	public default <Array extends PitchChromaticChord<N>> boolean hasSameNotesOrder(Array notes) {
		if ( size() != notes.size() )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).getChromatic().val() != notes.get( i ).getChromatic().val() )
				return false;
		}

		return true;
	}

	public default boolean equalsEnharmonic(PitchChromaticChord<?> ca) {
		if ( size() != ca.size() )
			return false;
		for ( int i = 0; i < size(); i++ )
			if ( !get( i ).getChromatic().equalsEnharmonic( ca.get( i ).getChromatic() ) )
				return false;

		if ( getRootPos() != ca.getRootPos() )
			return false;

		return true;
	}

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

	public default <Array extends PitchChromaticChord<?>> boolean equalsEnharmonicInv(Array cc) {
		CustomChromaticChord cc2 = CustomChromaticChord.copyOf( cc );
		for ( int i = 0; i < cc2.size(); i++, cc2.inv() ) {
			if ( this.equalsEnharmonic( cc2 ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticChord<N>> boolean equalsEnharmonicInvArray(Array[] ccs) {
		for ( Array cc : ccs ) {
			if ( this.equalsEnharmonicInv( cc ) )
				return true;
		}

		return false;
	}

	public default <Array extends PitchChromaticChord<N>> boolean equalsEnharmonicArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equalsEnharmonic( c ) )
				return true;
		return false;
	}

	public default <Array extends PitchChromaticChord<N>> boolean equalsArray(Array[] ccs) {
		for ( Array c : ccs )
			if ( equals( c ) )
				return true;
		return false;
	}

	Quality getQuality();
	<T extends PitchChromaticChord> T over(Chromatic c) throws ImpossibleChord;

	public static PitchChromaticChord of(PitchChromaticSingle... chord) {
		return of( Arrays.asList( chord ));
	}

	public static <T extends PitchChromaticSingle> PitchChromaticChord<Chromatic> of(Iterable<T> chord) {
		PitchChromaticChord<Chromatic> c = ChromaticChordEnum.of(chord);
		if (c == null) {
			c = CustomChromaticChord.copyOf( chord );
		}
		return c;
	}

	boolean isSus4();
	boolean isSus2();	
}

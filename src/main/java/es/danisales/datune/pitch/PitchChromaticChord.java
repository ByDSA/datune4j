package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N> {
	static ChromaticChord from(ChromaticChordMidi chromaticChordMidi) {
		if (chromaticChordMidi.getRootPos() != 0) {
			ChromaticChord ns = ChromaticChord.createEmpty();
			for ( ChromaticMidi n : chromaticChordMidi ) {
				Chromatic chromatic = Chromatic.from(n);
				ns.add( chromatic );

				if ( n == chromaticChordMidi.getRoot() )
					ns.setRootPos( ns.size() - 1 );
			}

			return ns;
		} else
			return ChromaticChord.from(chromaticChordMidi);
	}

	default <Array extends PitchChromaticChord<? extends PitchChromaticSingle>> boolean hasSameNotesOrder(Array notes) {
		if ( size() != notes.size() )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			Chromatic chromatic = ChromaticAdapter.from( get(i) );
			Chromatic chromaticOther = ChromaticAdapter.from( notes.get(i) );
			if ( chromatic.ordinal() != chromaticOther.ordinal() )
				return false;
		}

		return true;
	}

	default List<Integer> integerNotationFromRoot() {
		List<Integer> ret = new ArrayList<>();
		for (PitchChromaticSingle chromatic : this) {
			Chromatic c = Chromatic.from(chromatic);
			Chromatic first = Chromatic.from(get(0));
			ret.add(c.distSemitonesTo(first));
		}

		return ret;
	}

	default boolean equalsEnharmonic(ChromaticChord ca) {
		if ( size() != ca.size() )
			return false;
		for ( int i = 0; i < size(); i++ ) {
			Chromatic chromatic = ChromaticAdapter.from( get(i) );
			Chromatic chromaticOther = ChromaticAdapter.from( ca.get(i) );
			if ( chromatic.ordinal() != chromaticOther.ordinal() )
				return false;
		}

		if ( getRootPos() != ca.getRootPos() )
			return false;

		return true;
	}

	/*
	 * public boolean equalsEnharmonic(ChromaticChord cc); public boolean
	 * equalsEnharmonicInv(ChromaticChord cc); public boolean
	 * equalsEnharmonicInvArray(ChromaticChord[] cc); public boolean
	 * equalsEnharmonicArray(ChromaticChord[] cc); public boolean
	 * equalsArray(ChromaticChord[] cc);
	 */
/*
	default <Array extends PitchChromaticChord<?>> boolean equalsEnharmonicInv(Array cc) {
		CustomChromaticChord cc2 = CustomChromaticChord.fromDistances( cc );
		for ( int i = 0; i < cc2.size(); i++, cc2.inv() ) {
			if ( this.equalsEnharmonic( cc2 ) )
				return true;
		}

		return false;
	}

	default <Array extends PitchChromaticChord<NUMBER>> boolean equalsEnharmonicInvArray(Array[] ccs) {
		for ( Array cc : ccs ) {
			if ( this.equalsEnharmonicInv( cc ) )
				return true;
		}

		return false;
	}*/


	@NonNull
	Quality getQuality();
}

package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N, ChromaticDegree, IntervalChromatic> {
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

	@NonNull
	Quality getQuality();
}

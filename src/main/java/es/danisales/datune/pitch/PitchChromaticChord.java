package es.danisales.datune.pitch;

import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticAdapter;
import es.danisales.datune.musical.ChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PitchChromaticChord<N extends PitchChromaticSingle> extends ChordCommon<N> {
	static ChromaticChord from(ChromaticChordMidi chromaticChordMidi) {
		if (chromaticChordMidi.getRootPos() != 0) {
            ChromaticChord ns = ChromaticChord.builder().build();
			for ( ChromaticMidi n : chromaticChordMidi ) {
				Chromatic chromatic = Chromatic.from(n);
				ns.add( chromatic );

				if ( n == chromaticChordMidi.getRoot() )
					ns.setRootPos( ns.size() - 1 );
			}

			return ns;
		} else
			return ChromaticChord.builder().fromChromaticMidi(chromaticChordMidi).build();
	}

	@NonNull
	Quality getQuality();
}

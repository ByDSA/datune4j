package es.danisales.datune.diatonic;

import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.tonality.Tonality;

public interface HarmonicFunction {
	DiatonicDegree getDegree();

	static HarmonicFunction get(DiatonicChordMidi diatonicChordMidi) {
		HarmonicFunction hf = ChromaticFunction.from( diatonicChordMidi );
		if ( hf == null )
			hf = DiatonicFunction.from( diatonicChordMidi );

		return hf;
	}
}

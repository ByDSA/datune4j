package es.danisales.datune.diatonic;

import es.danisales.datune.midi.DiatonicChordMidi;

public interface HarmonicFunction {
	DiatonicDegree getDegree();

	static HarmonicFunction get(DiatonicChordMidi diatonicChordMidi) {
		HarmonicFunction hf = ChromaticFunction.from( diatonicChordMidi );
		if ( hf == null )
			hf = DiatonicFunction.from( diatonicChordMidi );

		return hf;
	}
}

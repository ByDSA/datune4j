package es.danisales.datune.diatonic;

import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;

public interface HarmonicFunction {
    static HarmonicFunction get(ChromaticChord chromaticChord, Tonality tonality) {
        HarmonicFunction hf = ChromaticFunction.from(chromaticChord, tonality);
		if ( hf == null )
            hf = DiatonicFunction.from(chromaticChord, tonality);

		return hf;
	}
}

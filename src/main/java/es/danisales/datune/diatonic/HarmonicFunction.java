package es.danisales.datune.diatonic;

import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.tonality.TonalityEnum;

public interface HarmonicFunction {
	DiatonicDegree getDegree();

	static HarmonicFunction get(DiatonicChordMidi diatonicChordMidi) {
		HarmonicFunction hf = ChromaticFunction.get( diatonicChordMidi );
		if ( hf == null )
			hf = DiatonicFunction.from( diatonicChordMidi );
		assert hf != null : diatonicChordMidi.notesToString() + " " + diatonicChordMidi.getMetatonality() + " " + TonalityEnum.Cm.get(DiatonicFunction.VII7).notesToString();
		
		return hf;
	}
}

package diatonic;

import pitch.DiatonicChordMidi;
import tonality.TonalityEnum;

public interface HarmonicFunction {
	public Degree getDegree();

	public static HarmonicFunction get(DiatonicChordMidi diatonicChordMidi) {
		HarmonicFunction hf = ChromaticFunction.get( diatonicChordMidi );
		if ( hf == null )
			hf = DiatonicFunction.get( diatonicChordMidi );
		assert hf != null : diatonicChordMidi.notesToString() + " " + diatonicChordMidi.getMetatonality() + " " + TonalityEnum.Cm.get(DiatonicFunction.VII7).notesToString();
		
		return hf;
	}
}

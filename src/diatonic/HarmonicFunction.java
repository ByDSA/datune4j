package diatonic;

import pitch.DiatonicChordMidi;

public interface HarmonicFunction {
	public Degree getDegree();

	public static HarmonicFunction get(DiatonicChordMidi diatonicChordMidi) {
		HarmonicFunction hf = ChromaticFunction.get( diatonicChordMidi );
		if ( hf == null )
			hf = DiatonicFunction.get( diatonicChordMidi );
		assert hf != null : diatonicChordMidi.notesToString() + " " + diatonicChordMidi.getMetatonality() + " " + Tonality.Cm.get(DiatonicFunction.VII7).notesToString();
		
		return hf;
	}
}

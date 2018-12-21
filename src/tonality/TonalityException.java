package tonality;

import pitch.DiatonicMidi;
import pitch.PitchChromaticChord;
import pitch.PitchSingle;

public class TonalityException extends RuntimeException {
	public TonalityException(PitchSingle n, Tonality s) {
		super(
			"La nota " + n + " no pertenece a la tonalidad " + s + ": "
					+ s.notesToString() + "."
				);
	}

	public TonalityException(PitchChromaticChord n, Tonality s) {
		super(
			"El acorde a añadir " + n + " de notas " + n.notesToString()
			+ " no pertenece a la escala " + s + ": "
			+ s.notesToString() + "."
				);
	}

	public TonalityException(DiatonicMidi n1, DiatonicMidi n2) {
		super(
			"Las nota " + n1 + " de tonalidad " + n1.getTonality() + " y " + n2
			+ " de tonalidad " + n2.getTonality()
			+ " pertenecen a diferentes tonalidades."
				);
	}
}
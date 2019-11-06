package es.danisales.datune.tonality;

import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.SymbolicPitch;

public class TonalityException extends RuntimeException {
	public TonalityException(DiatonicAlt n, Tonality s) {
		super(
			"La nota " + n + " no pertenece a la tonalidad " + s + ": "
					+ s.notesToString() + "."
				);
	}

	public TonalityException(Chromatic n, Tonality s) {
		super(
			"La nota " + n + " no pertenece a la tonalidad " + s + ": "
					+ s.notesToString() + "."
				);
	}

	public TonalityException(PitchChromaticChord n, Tonality s) {
		super(
			"El acorde a a�adir " + n + " de notas " + n.notesToString()
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
package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.pitch.PitchChromaticChord;

public class TonalityException extends Exception {
	public TonalityException(DiatonicAlt diatonicAlt, Tonality tonality) {
		super(
			"La nota " + diatonicAlt + " no pertenece a la tonalidad " + tonality + ": "
					+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(Chromatic chromatic, Tonality tonality) {
		super(
			"La nota " + chromatic + " no pertenece a la tonalidad " + tonality + ": "
					+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(PitchChromaticChord pitchChromaticChord, Tonality tonality) {
		super(
			"El acorde a añadir " + pitchChromaticChord + " de notas " + ChordNamer.from(pitchChromaticChord)
			+ " no pertenece a la escala " + tonality + ": "
			+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(DiatonicMidi n1, DiatonicMidi n2) {
		super(
                "Las nota " + n1 + " de tonalidad " + n1.getPitch().getTonality() + " y " + n2
                        + " de tonalidad " + n2.getPitch().getTonality()
			+ " pertenecen a diferentes tonalidades."
				);
	}

    public TonalityException(DiatonicDegree diatonicDegree, Tonality tonality, int octave) {
        super(diatonicDegree + " " + tonality + " " + octave);
    }
}
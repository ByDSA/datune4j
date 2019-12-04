package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.ChordNamer;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TonalityException extends Exception {
	public TonalityException(@NonNull DiatonicAlt diatonicAlt, @NonNull Tonality tonality) {
		super(
			"La nota " + diatonicAlt + " no pertenece a la tonalidad " + tonality + ": "
					+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(@NonNull Diatonic diatonic, @NonNull Tonality tonality) {
		super(
				"El grado " + diatonic + " no pertenece a la tonalidad " + tonality + ": "
						+ TonalityNamer.notesFrom(tonality) + "."
		);
	}

	public TonalityException(@NonNull Chromatic chromatic, @NonNull Tonality tonality) {
		super(
			"La nota " + chromatic + " no pertenece a la tonalidad " + tonality + ": "
					+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(@NonNull ChromaticChord chromaticChord, @NonNull Tonality tonality) {
		super(
				"El acorde a añadir " + chromaticChord + " de notas " + ChordNamer.from(chromaticChord)
			+ " no pertenece a la escala " + tonality + ": "
			+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(@NonNull DiatonicMidi n1, @NonNull DiatonicMidi n2) {
		super(
                "Las nota " + n1 + " de tonalidad " + n1.getPitch().getTonality() + " y " + n2
                        + " de tonalidad " + n2.getPitch().getTonality()
			+ " pertenecen a diferentes tonalidades."
				);
	}

	public TonalityException(@NonNull Degree relativeDegree, @NonNull Tonality tonality, int octave) {
		super(relativeDegree + " " + tonality + " " + octave);
	}

    public TonalityException(Tonality tonality, HarmonicFunction harmonicFunction) {
		super("Tonality " + tonality + " containsAll not harmonic function " + harmonicFunction);
    }
}
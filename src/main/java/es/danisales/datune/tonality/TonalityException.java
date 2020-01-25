package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.scale.ScaleDegree;
import es.danisales.datune.function.HarmonicFunction;
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
				"El acorde a añadir " + chromaticChord + " de notas " + chromaticChord
			+ " no pertenece a la escala " + tonality + ": "
			+ TonalityNamer.notesFrom(tonality) + "."
				);
	}

	public TonalityException(@NonNull ScaleDegree relativeDegree, @NonNull Tonality tonality, int octave) {
		super(relativeDegree + " " + tonality + " " + octave);
	}

    public TonalityException(Tonality tonality, HarmonicFunction harmonicFunction) {
		super("Tonality " + tonality + " containsAll not harmonic function " + harmonicFunction);
    }
}
package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TonalityException extends Exception {
	private TonalityException(@NonNull DiatonicAlt diatonicAlt, @NonNull Tonality<DiatonicAlt> tonality) {
		super(
			"La nota " + diatonicAlt + " no pertenece a la tonalidad " + tonality + ": "
					+ tonality.getNotes() + "."
				);
	}

	private TonalityException(@NonNull Diatonic diatonic, @NonNull Tonality<DiatonicAlt> tonality) {
		super(
				"El grado " + diatonic + " no está en la tonalidad " + tonality + ": "
						+ tonality.getNotes() + "."
		);
	}

	private TonalityException(@NonNull Chromatic chromatic, @NonNull Tonality<Chromatic> tonality) {
		super(
			"La nota " + chromatic + " no pertenece a la tonalidad " + tonality + ": "
					+ tonality.getNotes() + "."
				);
	}

	public static TonalityException from(@NonNull Chromatic chromatic, @NonNull Tonality<Chromatic> tonality) {
		return new TonalityException(chromatic, tonality);
	}

	public static TonalityException from(DiatonicAlt diatonicAlt, Tonality<DiatonicAlt> tonality) {
		return new TonalityException(diatonicAlt, tonality);
	}

	public static TonalityException from(Diatonic diatonic, Tonality<DiatonicAlt> tonality) {
		return new TonalityException(diatonic, tonality);
	}
}
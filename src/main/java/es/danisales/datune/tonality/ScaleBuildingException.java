package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.IntervalChromatic;

@SuppressWarnings("WeakerAccess")
public class ScaleBuildingException extends RuntimeException {
	ScaleBuildingException(ScaleInterface s) {
		super( "La escala no suma " + IntervalChromatic.PERFECT_OCTAVE.getSemitones() + " semitonos, sino " + sum(s) + ": " + ScaleNamer.distOf(new Scale(s)) );
	}

	private static int sum(ScaleInterface scale) {
		int s = 0;
		for (ScaleDistance distanceScale : scale.getCode())
			s += distanceScale.getSemitones();

		return s;
	}
}
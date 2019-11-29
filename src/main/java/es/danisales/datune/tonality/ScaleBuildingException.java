package es.danisales.datune.tonality;

import es.danisales.datune.interval.IntervalChromatic;

@SuppressWarnings("WeakerAccess")
public class ScaleBuildingException extends RuntimeException {
	ScaleBuildingException(ScaleInner s) {
		super("La escala no suma " + IntervalChromatic.PERFECT_OCTAVE.getSemitones() + " semitonos, sino " + sum(s) + ": " + ScaleUtils.getDistancesFrom(new Scale(s)));
	}

	private static float sum(ScaleInner scale) {
		float s = 0f;
		for (ScaleDistance distanceScale : scale.getCode())
			s += distanceScale.getMicrotonalSemitones();

		return s;
	}
}
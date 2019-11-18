package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface ScaleInterface {
	static @NonNull ScaleInterface from(List<ScaleDistance> values) {
		ScaleInterface ret = ScaleEnum.from(values);
		if (ret == null)
			ret = new ScaleCustom( values );

		return ret;
	}

	static float sumOf(List<ScaleDistance> distanceScales) {
		float sum = 0;
		for (ScaleDistance distanceScale : distanceScales)
			sum += distanceScale.getMicrotonalSemitones();

		return sum;
	}

	default @NonNull ScaleInterface getMode(@NonNull DiatonicDegree diatonicDegree) {
		List<ScaleDistance> baseValues = new ArrayList<>( this.getCode() );
		Collections.rotate( baseValues, -diatonicDegree.ordinal() );
		return ScaleInterface.from( baseValues );
	}

	default void sumCheck() {
		float sum = sumOf(getCode());
		int octaveSemitones = IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		if ( !ScaleDistance.compare(sum, octaveSemitones) ) {
			throw new ScaleBuildingException( this );
		}
	}

	List<ScaleDistance> getCode();

	int size();

	@NonNull ScaleDistance get(DiatonicDegree diatonicDegree);
}

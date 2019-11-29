package es.danisales.datune.tonality;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface ScaleInner {
	static @NonNull ScaleInner from(List<ScaleDistance> values) {
		ScaleInner ret = ScaleInnerImmutable.from(values);
		if (ret == null)
			ret = new ScaleInnerMutable(values);

		return ret;
	}

	static float sumOf(List<ScaleDistance> distanceScales) {
		float sum = 0;
		for (ScaleDistance distanceScale : distanceScales)
			sum += distanceScale.getMicrotonalSemitones();

		return sum;
	}

	default @NonNull ScaleInner getMode(@NonNull DiatonicDegree diatonicDegree) {
		List<ScaleDistance> baseValues = new ArrayList<>( this.getCode() );
		Collections.rotate( baseValues, -diatonicDegree.ordinal() );
		return ScaleInner.from(baseValues);
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

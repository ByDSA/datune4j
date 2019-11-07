package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface ScaleInterface {
	static @NonNull ScaleInterface of(List<ScaleDistance> values) {
		ScaleInterface ret = ScaleEnum.of(values);
		if (ret == null)
			ret = new ScaleCustom( values );

		return ret;
	}

	static int sumOf(List<ScaleDistance> distanceScales) {
		int sum = 0;
		for (ScaleDistance distanceScale : distanceScales)
			sum += distanceScale.getSemitones();

		return sum;
	}

	default ScaleInterface getMode(DiatonicDegree diatonicDegree) {
		List<ScaleDistance> baseValues = new ArrayList<>( this.getCode() );
		Collections.rotate( baseValues, -diatonicDegree.ordinal() );
		return ScaleInterface.of( baseValues );
	}

	default void sumCheck() {
		if (sumOf(getCode()) != IntervalChromatic.PERFECT_OCTAVE.getSemitones()) {
			throw new ScaleBuildingException( this );
		}
	}

	/**
	 * Get all modes fromIndex the scale
	 * @return the array within all modes fromIndex the scale
	 */
	default @NonNull List<ScaleInterface> getAllModes() {
		List<ScaleInterface> ret = new ArrayList<>();
		for ( int i = 0; i < size(); i++) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[i];
			ScaleInterface scaleMode = getMode(diatonicDegree);
			ret.add(scaleMode);
		}

		return ret;
	}

	List<ScaleDistance> getCode();

	int size();

	@NonNull ScaleDistance get(DiatonicDegree diatonicDegree);
}

package es.danisales.datune.tonality;

import com.google.common.collect.ImmutableSet;
import es.danisales.datune.degree.Degree;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

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

	// private
	default List<Degree> getMainDegrees() {
		return Degree.getMainDegreesFromScaleSize(size());
	}

	default @NonNull Set<Degree> getRelativeDegreeByIndex(int i) {
		ScaleDegreeReparametrizer scaleDegreeReparametrizer = getScaleDegreeReparametrizer();
		i = MathUtils.rotativeTrim(i, size());

		Set<Degree> ret = new HashSet<>();
		Degree iDegree = getMainDegrees().get(i);
		ret.add(iDegree);

		if (scaleDegreeReparametrizer == null)
			return ImmutableSet.copyOf(ret);

		ret.addAll(scaleDegreeReparametrizer.getByIndex(i));

		return ImmutableSet.copyOf(ret);
	}

	default int getIndexByDegree(Degree relativeDegree) throws ScaleDegreeException {
		ScaleDegreeReparametrizer scaleDegreeReparametrizer = getScaleDegreeReparametrizer();
		if (scaleDegreeReparametrizer == null)
			return getIndexByDegreeDefault(relativeDegree);

		Integer ret = scaleDegreeReparametrizer.getByKey(relativeDegree);
		if (ret == null)
			ret = getIndexByDegreeDefault(relativeDegree);

		return ret;
	}

	// private
	default int getIndexByDegreeDefault(Degree degree) throws ScaleDegreeException {
		List<Degree> mainDegrees = getMainDegrees();
		for (int i = 0; i < mainDegrees.size(); i++)
			if (mainDegrees.get(i).equals(degree))
				return i;

		throw new ScaleDegreeException(degree, this);
	}

	default @NonNull ScaleInner getModeFrom(@NonNull Degree relativeDegree) throws ScaleDegreeException {
		List<ScaleDistance> baseValues = new ArrayList<>( this.getCode() );
		int pos = getIndexByDegree(relativeDegree);
		Collections.rotate(baseValues, -pos);
		return ScaleInner.from(baseValues);
	}

	// protected
	default @NonNull ScaleInner getModeFromSecure(@NonNull Degree relativeDegree) {
		try {
			return getModeFrom(relativeDegree);
		} catch (ScaleDegreeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	// protected
	default void sumCheck() {
		float sum = sumOf(getCode());
		int octaveSemitones = IntervalChromatic.PERFECT_OCTAVE.getSemitones();
		if ( !ScaleDistance.compare(sum, octaveSemitones) ) {
			throw new ScaleBuildingException( this );
		}
	}

	List<ScaleDistance> getCode();

	int size();

	@NonNull
	default ScaleDistance getDistance(Degree relativeDegree) throws ScaleDegreeException {
		int index = getIndexByDegree(relativeDegree);
		if (index == 0)
			return ScaleDistance.NONE;
		return getCode().get(index - 1);
	}

	@Nullable ScaleDegreeReparametrizer getScaleDegreeReparametrizer();

	void setScaleDegreeReparametrizer(@Nullable ScaleDegreeReparametrizer scaleDegreeReparametrizer);
}

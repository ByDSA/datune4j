package es.danisales.datune.tonality;

import com.google.common.collect.ImmutableSet;
import es.danisales.datune.degrees.scale.ScaleDegree;
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
	default List<ScaleDegree> getMainDegrees() {
		return ScaleDegree.getDefaultDegreesFromScaleSize(size());
	}

	default @NonNull Set<ScaleDegree> getRelativeDegreeByIndex(int i) {
		ScaleDegreeReparameterize scaleDegreeReparameterize = getScaleDegreeReparametrizer();
		i = MathUtils.rotativeTrim(i, size());

		Set<ScaleDegree> ret = new HashSet<>();
		ScaleDegree iDegree = getMainDegrees().get(i);
		ret.add(iDegree);

		if (scaleDegreeReparameterize == null)
			return ImmutableSet.copyOf(ret);

		Set<ScaleDegree> scaleDegrees_i = scaleDegreeReparameterize.getByIndex(i);
		if (scaleDegrees_i != null)
			ret.addAll(scaleDegrees_i);

		return ImmutableSet.copyOf(ret);
	}

	default int getIndexByDegree(ScaleDegree relativeDegree) throws ScaleRelativeDegreeException {
		ScaleDegreeReparameterize scaleDegreeReparameterize = getScaleDegreeReparametrizer();
		if (scaleDegreeReparameterize == null)
			return getIndexByDegreeDefault(relativeDegree);

		Integer ret = scaleDegreeReparameterize.getByKey(relativeDegree);
		if (ret == null)
			ret = getIndexByDegreeDefault(relativeDegree);

		return ret;
	}

	// private
	default int getIndexByDegreeDefault(ScaleDegree degree) throws ScaleRelativeDegreeException {
		List<ScaleDegree> mainDegrees = getMainDegrees();
		for (int i = 0; i < mainDegrees.size(); i++)
			if (mainDegrees.get(i).equals(degree))
				return i;

		throw new ScaleRelativeDegreeException(degree, this);
	}

	default @NonNull ScaleInner getModeFrom(@NonNull ScaleDegree relativeDegree) throws ScaleRelativeDegreeException {
		List<ScaleDistance> baseValues = new ArrayList<>( this.getCode() );
		int pos = getIndexByDegree(relativeDegree);
		Collections.rotate(baseValues, -pos);
		return ScaleInner.from(baseValues);
	}

	// protected
	default @NonNull ScaleInner getModeFromSecure(@NonNull ScaleDegree relativeDegree) {
		try {
			return getModeFrom(relativeDegree);
		} catch (ScaleRelativeDegreeException e) {
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
	default ScaleDistance getDistance(ScaleDegree relativeDegree) throws ScaleRelativeDegreeException {
		int index = getIndexByDegree(relativeDegree);
		if (index == 0)
			return ScaleDistance.NONE;
		return getCode().get(index - 1);
	}

	@Nullable ScaleDegreeReparameterize getScaleDegreeReparametrizer();

	void setScaleDegreeReparametrizer(@Nullable ScaleDegreeReparameterize scaleDegreeReparameterize);
}

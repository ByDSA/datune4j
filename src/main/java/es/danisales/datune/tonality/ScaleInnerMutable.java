package es.danisales.datune.tonality;

import es.danisales.datune.degrees.scale.ScaleDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collections;
import java.util.List;

class ScaleInnerMutable implements ScaleInner {
	private List<ScaleDistance> value;
    private ScaleDegreeReparameterize scaleDiatonicReparametrizer;

    ScaleInnerMutable(@NonNull List<ScaleDistance> values) {
		value = values;
        scaleDiatonicReparametrizer = ScaleDegreeReparameterize.create();

		sumCheck();
	}
	
	@Override
	public @NonNull List<ScaleDistance> getCode() {
		return Collections.unmodifiableList(value);
	}

	@Override
	public int size() {
		return value.size();
	}

	@Override
    public @NonNull ScaleDistance getDistance(ScaleDegree diatonicDegree) {
        if (diatonicDegree.ordinal() == 0)
            return ScaleDistance.NONE;

        return value.get(diatonicDegree.ordinal() - 1);
    }

    @Override
    public @Nullable ScaleDegreeReparameterize getScaleDegreeReparametrizer() {
        return scaleDiatonicReparametrizer;
    }

    @Override
    public void setScaleDegreeReparametrizer(@Nullable ScaleDegreeReparameterize scaleDegreeReparameterize) {
        this.scaleDiatonicReparametrizer = scaleDegreeReparameterize;
	}
}

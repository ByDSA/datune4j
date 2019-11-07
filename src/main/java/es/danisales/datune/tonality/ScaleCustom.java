package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.List;

class ScaleCustom implements ScaleInterface {
	private List<ScaleDistance> value;
	
	ScaleCustom(@NonNull List<ScaleDistance> values) {
		value = values;

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
	public @NonNull ScaleDistance get(DiatonicDegree diatonicDegree) {
		return value.get(diatonicDegree.ordinal());
	}
}

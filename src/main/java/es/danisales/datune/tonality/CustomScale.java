package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;

import java.util.Collections;
import java.util.List;

public class CustomScale implements Scale {
	private List<Integer> value;
	
	public CustomScale(List<Integer> values) {
		value = values;
	}
	
	@Override
	public List<Integer> getValue() {
		return Collections.unmodifiableList(value);
	}

	@Override
	public boolean equals(Object m) {
		if ( m instanceof Scale )
			return
				value.equals(((Scale) m ).getValue());
		else
			return false;
	}

	@Override
	public int size() {
		return value.size();
	}

	@Override
	public int get(DiatonicDegree diatonicDegree) {
		return value.get(diatonicDegree.ordinal());
	}
}

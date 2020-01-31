package es.danisales.datune.tempo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public abstract class UnitConverter<IN, OUT> implements Function<IN, OUT> {
	private Map<IN, OUT> map;
	
	final void initialize() {
		map = _init();
	}
	
	abstract void init(Map<IN, OUT> map);
	
	private Map<IN, OUT> _init() {
		Map<IN, OUT> map = new HashMap<>();
		
		init(map);

		return Collections.unmodifiableMap(map);
	}
	
	public final OUT apply(IN sd) {
		return map.get(sd);
	}
}

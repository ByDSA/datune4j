package es.danisales.datune.tempo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public abstract class UnitConversor<IN, OUT> implements Function<IN, OUT> {
	Map<IN, OUT> map;
	
	public final void initialize() {
		map = _init();
	}
	
	public abstract void init(Map<SymbolicDuration, Double> map);
	
	private final Map _init() {
		Map<SymbolicDuration, Double> map = new HashMap();
		
		init(map);

		return Collections.unmodifiableMap(map);
	}
	
	public final OUT apply(IN sd) {
		return map.get(sd);
	}
}

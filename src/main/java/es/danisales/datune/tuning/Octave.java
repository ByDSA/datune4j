package es.danisales.datune.tuning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Octave<KEY> {
	List<Double> notes = new ArrayList<>();
	Map<KEY, Double> map = new HashMap<>();
	
	public Double get(KEY key) {
		return map.get( key );
	}
	
	public Double put(KEY key, Double value) {
		Double prev = map.put( key, value );
		if (prev != null)
			notes.remove( prev );
		
		notes.add( value ); // TODO: que se a�ada ordenado
		
		return prev;
	}
}

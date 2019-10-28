package es.danisales.datune.tempo;

import java.util.Map;


public class BPM extends Tempo {
	int bpm;
	Duration base;
	
	private BPM() { }
	
	public static BPM of(int q) {
		return of(q, Duration.QUARTER);
	}
	
	public static BPM of(int q, Duration sd) {
		BPM bpm = new BPM();
		bpm.bpm = q;
		bpm.base = sd;
		
		bpm.initialize();
		return bpm;
	}

	public void init(Map<SymbolicDuration, Double> map) {
		final double msPerMin = 1000 * 60;
		final double baseDuration = msPerMin/bpm;
		final double wholeDuration = baseDuration / base.val;
		map.put( base, baseDuration );
		
		for (Duration d : Duration.values())
			if (d != base)
			map.put( d, wholeDuration * d.val);
	}
}

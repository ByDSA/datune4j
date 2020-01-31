package es.danisales.datune.tempo;

import java.util.Map;


public class BPM extends Tempo {
	private int bpm;
	private Duration base;
	
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

	@Override
	public void init(Map<Double, SymbolicDuration> map) {
		final double msPerMin = 1000 * 60;
		final double baseDuration = msPerMin/bpm;
		final double wholeDuration = baseDuration / base.val;
		map.put( baseDuration, base );
		
		for (Duration d : Duration.values())
			if (d != base)
			map.put( wholeDuration * d.val, d);
	}
}

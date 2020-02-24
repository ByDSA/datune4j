package es.danisales.datune.tempo;

import java.util.Map;


public class BPM extends Tempo {
	private int bpm;
	private MusicalTime base;

	private BPM() { }

	public static BPM of(int q) {
		return of(q, MusicalTime.QUARTER);
	}

	@SuppressWarnings("WeakerAccess")
	public static BPM of(int q, MusicalTime sd) {
		BPM bpm = new BPM();
		bpm.bpm = q;
		bpm.base = sd;

		bpm.initialize();
		return bpm;
	}

	@Override
	public void init(Map<Double, MusicalTime> map) {
		final double msPerMin = 1000 * 60;
		final double baseDuration = msPerMin/bpm;
		final double wholeDuration = baseDuration / base.val;
		map.put( baseDuration, base );

		for (MusicalTime d : MusicalTime.values())
			if (d.equals(base))
				map.put( wholeDuration * d.val, d);
	}
}

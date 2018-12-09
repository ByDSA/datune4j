package midi.Progressions;

import diatonic.DiatonicFunction;
import diatonic.Tonality;
import midi.Duration;
import midi.Arpegios.ArpegioAscDesc;

public class Pachelbel extends Progression {
	public static final int NORMAL = 0;
	public static final int ARPEGIO = 1;

	public Pachelbel(Tonality s, int o, int type) {
		super(s, o);

		add(DiatonicFunction.I, 1);
		add(DiatonicFunction.V);
		add(DiatonicFunction.VII);
		add(DiatonicFunction.III);
		add(DiatonicFunction.IV);
		add(DiatonicFunction.I);
		add(DiatonicFunction.IV);
		add(DiatonicFunction.V7);

		if (type == ARPEGIO) {
			this.setArpegio( new ArpegioAscDesc(Duration.V1, Duration.V4) );
		}
	}
}

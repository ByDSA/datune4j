package es.danisales.datune.midi.Progressions;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.arpegios.ArpeggioAscDesc;
import es.danisales.datune.tonality.Tonality;

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
			this.setArpegio(new ArpeggioAscDesc(DurationMidi.L1, DurationMidi.L4));
		}
	}
}

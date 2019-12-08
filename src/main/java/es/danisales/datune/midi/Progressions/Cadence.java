package es.danisales.datune.midi.Progressions;

import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.tonality.Tonality;

public class Cadence extends Progression {
    private static final int PLAGAL = 0;
    private static final int PERFECT = 1;
    private static final int I_VI = 2;
    private static final int I_III = 3;

	public Cadence(Tonality s, int o, int type, int repeats, boolean end) {
		super(s, o);

		for(int i = 0; i < repeats; i++) {
			add(DiatonicFunction.I);

		if (type == PLAGAL)
			add(DiatonicFunction.IV).inv(1);
		else if (type == PERFECT)
			add(DiatonicFunction.V).inv(2);
		else if (type == I_VI)
			add(DiatonicFunction.VI).inv(2);
		else if (type == I_III)
			add(DiatonicFunction.III).inv(2);
		
		}
		
		if (end)
			add(DiatonicFunction.I);
	}
}

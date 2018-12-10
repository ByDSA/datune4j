package midi.Progressions;

import diatonic.DiatonicFunction;
import pitch.DiatonicChordMidi;
import tonality.Tonality;

public class Cadence extends Progression {
	public static final int PLAGAL = 0;
	public static final int PERFECT = 1;
	public static final int I_VI = 2;
	public static final int I_III = 2;

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

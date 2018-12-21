package pitch;

import musical.Chromatic;
import musical.Diatonic;
import tonality.Tonality;

public interface PitchDiatonicSingle extends PitchDiatonic, PitchSingle {
	public Diatonic getDiatonic();
	public Chromatic toChromatic(Tonality t);
}

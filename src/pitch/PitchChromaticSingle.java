package pitch;

import musical.Chromatic;
import musical.Diatonic;
import tonality.Tonality;
import tonality.TonalityException;

public interface PitchChromaticSingle extends PitchSingle {
	public Chromatic getChromatic();
	public Diatonic getDiatonic(Tonality ton) throws TonalityException;
}

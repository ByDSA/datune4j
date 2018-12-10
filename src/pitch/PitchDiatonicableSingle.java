package pitch;

import tonality.Tonality;

public interface PitchDiatonicableSingle extends PitchSingle, PitchDiatonicable {	
	public Diatonic getDiatonic();
	public Chromatic toChromatic(Tonality t);
}

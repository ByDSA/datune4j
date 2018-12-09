package pitch;

import diatonic.Tonality;

public interface PitchDiatonicableSingle<This> extends PitchSingle<This>, PitchDiatonicable<This> {	
	public Diatonic getDiatonic();
	public Chromatic toChromatic(Tonality t);
}

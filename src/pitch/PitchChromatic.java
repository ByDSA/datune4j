package pitch;

import tonality.Tonality;
import tonality.TonalityException;

public interface PitchChromatic extends PitchChromaticable {
	public <Diatonic extends PitchDiatonic<Diatonic, ?>> Diatonic toDiatonicChordMidi(Tonality ton) throws TonalityException;
}

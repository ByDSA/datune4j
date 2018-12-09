package pitch;

import diatonic.Tonality;
import diatonic.TonalityException;

public interface PitchChromatic<This> extends PitchChromaticable<This> {
	public <Diatonic extends PitchDiatonic<Diatonic, ?>> Diatonic toDiatonicChordMidi(Tonality ton) throws TonalityException;
}

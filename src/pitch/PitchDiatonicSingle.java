package pitch;

import diatonic.IntervalDiatonic;

public interface PitchDiatonicSingle<This extends PitchDiatonicSingle<This>> extends PitchDiatonic<This, IntervalDiatonic>, PitchDiatonicableSingle<This> {

}

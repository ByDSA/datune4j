package pitch;

import diatonic.IntervalChromatic;

public interface PitchChromaticSingle<This extends PitchChromaticSingle<This>> extends PitchChromaticableSingle<This>, PitchChromatic<This> {
	public int val();
	public default Integer dist(PitchChromaticSingle<This> n2) {
		int d = n2.val() - val();
		while (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.val();
		
		return d;
	}
	
	public default <P extends PitchChromaticSingle<This>> boolean equalsEnharmonic(P c) {
		return val() == c.val();
	}
}

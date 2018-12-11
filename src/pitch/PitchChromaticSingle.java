package pitch;

import diatonic.IntervalChromatic;

public interface PitchChromaticSingle extends PitchChromaticableSingle, PitchChromatic {
	public int val();
	public default Integer dist(PitchChromaticSingle n2) {
		int d = n2.val() - val();
		while (d < 0)
			d += IntervalChromatic.PERFECT_OCTAVE.val();
		
		return d;
	}
	
	public default boolean equalsEnharmonic(PitchChromaticSingle c) {
		return val() == c.val();
	}
}

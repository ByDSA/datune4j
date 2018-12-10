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
	
	public default <P extends PitchChromaticSingle> boolean equalsEnharmonic(P c) {
		return val() == c.val();
	}
}

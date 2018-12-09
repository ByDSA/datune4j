package pitch;

import diatonic.IntervalChromatic;

public interface PitchChromaticChord<N extends PitchChromaticSingle<N>, This extends PitchChromaticChord<N, This>>
		extends PitchChord<N, This, Integer>, PitchChromatic<This>,
		PitchChromaticableChord<N, This, Integer>, Iterable<N> {
	public default Integer[] integerNotationFromRoot() {
		assert size() > 0;

		Integer[] distancesAbsolute = new Integer[size()];
		distancesAbsolute[0] = 0;

		for ( int i = 1; i < size(); i++ ) {
			N n1 = get( 0 );
			N n2 = get( i );
			distancesAbsolute[i] = n1.dist( n2 );
			while (distancesAbsolute[i] < distancesAbsolute[i-1])
				distancesAbsolute[i] += IntervalChromatic.PERFECT_OCTAVE.val();
		}

		return distancesAbsolute;
	}
}

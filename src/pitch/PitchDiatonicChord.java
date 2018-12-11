package pitch;

import diatonic.IntervalDiatonic;

public interface PitchDiatonicChord<N extends PitchDiatonicSingle<N>, This extends PitchDiatonicChord<N, This>>
		extends PitchChord<N, IntervalDiatonic>, PitchDiatonicableChord<N, This, IntervalDiatonic>, Iterable<N> {
	public default IntervalDiatonic[] integerNotationFromRoot() {
		assert size() > 0;

		IntervalDiatonic[] distancesAbsolute = new IntervalDiatonic[size()];
		distancesAbsolute[0] = IntervalDiatonic.UNISON;

		for ( int i = 1; i < size(); i++ ) {
			N n1 = get( 0 );
			N n2 = get( i );
			distancesAbsolute[i] = n1.dist( n2 );
		}

		return distancesAbsolute;
	}
}

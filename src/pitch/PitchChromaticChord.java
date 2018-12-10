package pitch;

import chromaticchord.ChromaticChordEnum;
import chromaticchord.CustomChromaticChord;
import chromaticchord.CustomChromaticChord.ImpossibleChord;
import diatonic.IntervalChromatic;
import diatonic.Quality;

public interface PitchChromaticChord<N extends PitchChromaticSingle, This extends PitchChromaticChord<N, This>>
		extends PitchChord<N, This, Integer>, PitchChromatic,
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
	
	Quality getQuality();
	This over(Chromatic c) throws ImpossibleChord;

	public static PitchChromaticChord of(PitchChromaticableSingle... chord) {
		PitchChromaticChord c = ChromaticChordEnum.of(chord);
		if (c == null)
			c = new CustomChromaticChord(chord);
		return c;
	}
	
	public static PitchChromaticChord of(PitchChromaticableChord chord) {
		PitchChromaticChord c = ChromaticChordEnum.of(chord);
		if (c == null)
			c = new CustomChromaticChord(chord);
		return c;
	}
	
	boolean isSus4();
	boolean isSus2();
}

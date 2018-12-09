package pitch;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class ProgressionChromaticChordMidi extends ArrayList<ChromaticChordMidi> {
	public ProgressionChromaticChordMidi(
			PitchChromaticableChord... a) {
		for ( PitchChromaticableChord cm : a ) {
			if ( cm instanceof ChromaticChordMidi )
				add( (ChromaticChordMidi) cm );
			else if ( cm instanceof ChromaticChord )
				add( ( (ChromaticChord) cm ).toMidi() );
			else if (cm instanceof DiatonicChordMidi)
				add( ( (DiatonicChordMidi) cm ).toChromaticChordMidi() );
			else
				throw new RuntimeErrorException( null, "asasa" );
		}
	}
}

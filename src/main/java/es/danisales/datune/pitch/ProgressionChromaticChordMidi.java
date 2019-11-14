package es.danisales.datune.pitch;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChordCustom;

public class ProgressionChromaticChordMidi extends ArrayList<ChromaticChordMidi> {
	public ProgressionChromaticChordMidi(
			PitchChromaticChord... a) {
		for ( PitchChromaticChord cm : a ) {
			if ( cm instanceof ChromaticChordMidi )
				add( (ChromaticChordMidi) cm );
			else if ( cm instanceof ChromaticChordCustom)
				add( ( (ChromaticChordCustom) cm ).toMidi() );
			else if (cm instanceof DiatonicChordMidi)
				add( ( (DiatonicChordMidi) cm ).toChromaticChordMidi() );
			else
				throw new RuntimeErrorException( null, "asasa" );
		}
	}
}

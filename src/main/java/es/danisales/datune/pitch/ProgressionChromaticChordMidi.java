package es.danisales.datune.pitch;

import es.danisales.datune.midi.ChromaticChordMidi;

import java.util.ArrayList;
import java.util.Collection;

public class ProgressionChromaticChordMidi extends ArrayList<ChromaticChordMidi> {
	public ProgressionChromaticChordMidi(Collection<? extends PitchChromaticSingle>... a) {
		for ( Collection<? extends PitchChromaticSingle> cm : a ) {
			//addAll(cm);
		}
	}
}

package es.danisales.datune.pitch;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.midi.ChordMidi;

import java.util.ArrayList;
import java.util.Collection;

public class ProgressionChromaticChordMidi extends ArrayList<ChordMidi> {
	public ProgressionChromaticChordMidi(Collection<Chromatic>... a) {
		for ( Collection<Chromatic> cm : a ) {
			//addAll(cm);
		}
	}
}

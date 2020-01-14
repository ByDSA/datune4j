package es.danisales.datune.midi;

import es.danisales.datune.interval.Interval;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.pitch.SymbolicPitch;

public class AddedException extends RuntimeException {
	<N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface> AddedException(N n, ChordMidi<N, I, P> c) {
		super("Already exists " + n + " in chord (" + ChordNamer.from(c) + ").");
	}

	<N extends SymbolicPitch> AddedException(ChordCommon<N> c) {
		super("Already exists in chord (" + ChordNamer.from(c) + ").");
	}
}
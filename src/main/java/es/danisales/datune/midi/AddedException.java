package es.danisales.datune.midi;

import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.midi.pitch.PitchMidiInterface;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.pitch.SymbolicPitch;

public class AddedException extends RuntimeException {
	public <N extends NoteMidi<P>, I extends Interval, P extends PitchMidiInterface> AddedException(N n, ChordMidi<N, I, P> c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir (" + n + ")");
	}

    public <N extends SymbolicPitch> AddedException(ChordCommon<N> c) {
		super("Ya existe en el acorde (" + ChordNamer.from(c) + ") la nota que se intenta añadir.");
	}
}
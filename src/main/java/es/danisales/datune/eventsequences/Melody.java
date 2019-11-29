package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.Durable;
import es.danisales.datune.midi.binaries.events.Event;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.pitch.PitchMidiException;

public abstract class Melody implements EventComplex, Durable {
	protected long			seek;
	protected EventSequence	notes;

	public Melody() {
		notes = new EventSequence();
		seek = 0;
	}

	public void show() {
		notes.forEach( (Event e) -> {
			System.out.println( e );
			return true;
		} );
	}

	public void addSilence(int d) {
		seek += d;
	}

	public void setSeek(int p) {
		seek = p;
	}

    public abstract Melody shiftOctave(int o) throws PitchMidiException;
	
	public abstract Melody clone();
}

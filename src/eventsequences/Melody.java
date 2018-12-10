package eventsequences;

import midi.FigureLength;
import midi.Events.Event;
import midi.Events.EventComplex;

public abstract class Melody implements EventComplex, FigureLength {
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

	public abstract Melody shiftOctave(int o);
	
	public abstract Melody clone();
}

package midi;

import midi.Events.Event;
import midi.Events.EventComplex;

public interface FigureLength<This> extends EventComplex<This> {
	public final Integer NO_DURATION = -1;
	
	public This setLength(int d);
	public int getLength();
}

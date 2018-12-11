package midi;

import midi.Events.EventComplex;

public interface FigureLength extends EventComplex {
	public final Integer NO_DURATION = -1;
	
	public <T extends FigureLength> T setLength(int d);
	public int getLength();
}

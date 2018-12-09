package midi;

import midi.Events.EventComplex;

public interface FigureVelocity<This extends FigureVelocity> extends EventComplex<This> {
	public This setVelocity(int v);
	
	public int getVelocity();
}

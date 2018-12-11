package midi;

import midi.Events.EventComplex;

public interface FigureVelocity extends EventComplex {
	public <T extends FigureVelocity> T setVelocity(int v);
	
	public int getVelocity();
}

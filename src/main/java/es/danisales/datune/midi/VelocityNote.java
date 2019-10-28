package es.danisales.datune.midi;

import es.danisales.datune.midi.Events.EventComplex;

public interface VelocityNote extends EventComplex {
	<T extends VelocityNote> T setVelocity(int v);
	
	int getVelocity();
}

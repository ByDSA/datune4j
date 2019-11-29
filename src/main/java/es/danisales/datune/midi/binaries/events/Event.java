package es.danisales.datune.midi.binaries.events;

import es.danisales.io.binary.types.Binary;

public interface Event extends Cloneable, Binary {
	Event clone();
}

package es.danisales.datune.midi.Events;

import es.danisales.io.binary.types.Binary;

public interface Event extends Cloneable, Binary {
	Event clone() throws CloneNotSupportedException;
}

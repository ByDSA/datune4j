package midi.Events;

import binary.Binary;

public interface Event extends Cloneable, Binary {
	Event clone() throws CloneNotSupportedException;
}

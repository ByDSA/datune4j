package pitch;

import midi.Events.Duplicable;

public interface PitchInterface<This> extends Duplicable<This> {
	public String toString();
}

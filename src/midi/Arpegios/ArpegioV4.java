package midi.Arpegios;

import midi.Duration;
import pitch.ChromaticMidi;

public class ArpegioV4 extends ArpegioV {
	public ArpegioV4(int noteLength) {
		super(noteLength, Duration.V4);
	}
	
	public ArpegioV4() {
		this(Duration.V4);
	}
}
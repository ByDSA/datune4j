package midi.Arpegios;

import midi.Duration;

public class ArpegioV8 extends ArpegioV {
	public ArpegioV8(int noteLength) {
		super(noteLength, Duration.V8);
	}
	
	public ArpegioV8() {
		this(Duration.V8);
	}
}
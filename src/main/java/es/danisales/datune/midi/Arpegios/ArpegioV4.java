package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioV4 extends ArpegioV {
	public ArpegioV4(int noteLength) {
		super(noteLength, Duration.V4);
	}
	
	public ArpegioV4() {
		this(Duration.V4);
	}
}
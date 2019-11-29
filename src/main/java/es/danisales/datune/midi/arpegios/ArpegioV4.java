package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioV4 extends ArpegioV {
	public ArpegioV4(int noteLength) {
		super(noteLength, Duration.L4);
	}
	
	public ArpegioV4() {
		this(Duration.L4);
	}
}
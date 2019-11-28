package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioV8 extends ArpegioV {
	public ArpegioV8(int noteLength) {
		super(noteLength, Duration.L8);
	}
	
	public ArpegioV8() {
		this(Duration.L8);
	}
}
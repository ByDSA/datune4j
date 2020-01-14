package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.Duration;

public class ArpeggioV8 extends ArpeggioV {
	public ArpeggioV8(int noteLength) {
		super(noteLength, Duration.L8);
	}

	public ArpeggioV8() {
		this(Duration.L8);
	}
}
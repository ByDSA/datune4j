package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.Duration;

public class ArpeggioV4 extends ArpeggioV {
	public ArpeggioV4(int noteLength) {
		super(noteLength, Duration.L4);
	}

	public ArpeggioV4() {
		this(Duration.L4);
	}
}
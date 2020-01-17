package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.DurationMidi;

public class ArpeggioV4 extends ArpeggioV {
	public ArpeggioV4(int noteLength) {
		super(noteLength, DurationMidi.L4);
	}

	public ArpeggioV4() {
		this(DurationMidi.L4);
	}
}
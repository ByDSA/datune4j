package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.DurationMidi;

public class ArpeggioV8 extends ArpeggioV {
	public ArpeggioV8(int noteLength) {
		super(noteLength, DurationMidi.L8);
	}

	public ArpeggioV8() {
		this(DurationMidi.L8);
	}
}
package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.Duration;

public class ArpeggioDefault extends Arpeggio {
	public ArpeggioDefault(int duration) {
		super((This) -> {
			for(int i = 0; i < This.chord.size(); i++) {
				This.add(0, i, duration);
			}
		});
	}

	public ArpeggioDefault() {
		this(Duration.L1);
	}
}

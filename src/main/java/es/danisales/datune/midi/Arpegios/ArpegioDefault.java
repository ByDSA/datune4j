package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioDefault extends Arpegio {
	public ArpegioDefault(int duration) {
		super((This) -> {
			for(int i = 0; i < This.chord.size(); i++) {
				This.add(0, i, duration);
			}
		});
	}
	
	public ArpegioDefault() {
		this(Duration.V1);
	}
}

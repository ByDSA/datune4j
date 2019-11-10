package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioPowerGuitars extends Arpegio {

	public ArpegioPowerGuitars() {
		super((This) -> {
			int length2 = This.chord.getLength() / Duration.V1;
			This.add(0, -1, Duration.V1);
			for(int i = 0; i < 4; i++) {
				This.add(i*Duration.V4, Duration.V16);

				if (i == 3) {
					This.add(i*Duration.V4, Duration.V16);
					This.add(i*Duration.V4 + Duration.V8, Duration.V8);
				} else {
					This.add(i*Duration.V4 + Duration.V8, Duration.V32);
					This.add(i*Duration.V4 + Duration.V8 + Duration.V16, Duration.V32);
				}
			}
		});
	}
}

package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioPowerGuitars extends Arpegio {

	public ArpegioPowerGuitars() {
		super((This) -> {
			int length2 = This.chord.getLength() / Duration.L1;
			This.add(0, -1, Duration.L1);
			for(int i = 0; i < 4; i++) {
				This.add(i*Duration.L4, Duration.L16);

				if (i == 3) {
					This.add(i*Duration.L4, Duration.L16);
					This.add(i*Duration.L4 + Duration.L8, Duration.L8);
				} else {
					This.add(i*Duration.L4 + Duration.L8, Duration.L32);
					This.add(i*Duration.L4 + Duration.L8 + Duration.L16, Duration.L32);
				}
			}
		});
	}
}

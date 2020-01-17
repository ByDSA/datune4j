package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.DurationMidi;

public class ArpeggioPowerGuitars extends Arpeggio {

	public ArpeggioPowerGuitars() {
		super((This) -> {
			int length2 = This.chord.getLength() / DurationMidi.L1;
			This.add(0, -1, DurationMidi.L1);
			for(int i = 0; i < 4; i++) {
				This.add(i* DurationMidi.L4, DurationMidi.L16);

				if (i == 3) {
					This.add(i* DurationMidi.L4, DurationMidi.L16);
					This.add(i* DurationMidi.L4 + DurationMidi.L8, DurationMidi.L8);
				} else {
					This.add(i* DurationMidi.L4 + DurationMidi.L8, DurationMidi.L32);
					This.add(i* DurationMidi.L4 + DurationMidi.L8 + DurationMidi.L16, DurationMidi.L32);
				}
			}
		});
	}
}

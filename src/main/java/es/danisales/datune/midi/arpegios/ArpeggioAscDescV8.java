package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.DurationMidi;

public class ArpeggioAscDescV8 extends Arpeggio {
	public ArpeggioAscDescV8(int a, int n) {
		super((This) -> {
			int aa = a-1;
			for(int i = 0; i < n; i++) {
				int num = (-Math.abs(i%(2*aa)-aa)+aa);
				This.add(DurationMidi.L8 *i, num, DurationMidi.L8);
			}
		});
	}
}

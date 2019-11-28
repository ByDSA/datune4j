package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioAscDescV8 extends Arpegio {
	public ArpegioAscDescV8(int a, int n) {
		super((This) -> {
			int aa = a-1;
			for(int i = 0; i < n; i++) {
				int num = (-Math.abs(i%(2*aa)-aa)+aa);
				This.add(Duration.L8 *i, num, Duration.L8);
			}
		});
	}
}

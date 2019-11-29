package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioV2_3 extends Arpegio {	
	public ArpegioV2_3(int duration) {
		super((This) -> {
			for(int j = 0; j < duration; j += Duration.L2_3)
				for(int i = 0; i < This.chord.size(); i++) {
					int ini = j+Duration.L16 /4*0;
					int d = Math.min(Duration.L8 + ini, Duration.L1) - j;
					if (j + d == Duration.L1)
						d /= 2;

					if (ini < Duration.L1)
						This.add(ini, i, d);
				}
		});
	}
	
	public ArpegioV2_3() {
		this(Duration.L1);
	}
}
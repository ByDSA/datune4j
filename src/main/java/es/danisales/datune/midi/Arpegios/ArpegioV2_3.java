package es.danisales.datune.midi.Arpegios;

import es.danisales.datune.midi.Duration;

public class ArpegioV2_3 extends Arpegio {	
	public ArpegioV2_3(int duration) {
		super((This) -> {
			for(int j = 0; j < duration; j += Duration.V2_3)
				for(int i = 0; i < This.chord.size(); i++) {
					int ini = j+Duration.V16/4*0;
					int d = Math.min(Duration.V8 + ini, Duration.V1) - j;
					if (j + d == Duration.V1)
						d /= 2;

					if (ini < Duration.V1)
						This.add(ini, i, d);
				}
		});
	}
	
	public ArpegioV2_3() {
		this(Duration.V1);
	}
}
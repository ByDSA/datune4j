package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.DurationMidi;

public class ArpeggioV2_3 extends Arpeggio {
	public ArpeggioV2_3(int duration) {
		super((This) -> {
			for(int j = 0; j < duration; j += DurationMidi.L2_3)
				for(int i = 0; i < This.chord.size(); i++) {
					int ini = j+ DurationMidi.L16 /4*0;
					int d = Math.min(DurationMidi.L8 + ini, DurationMidi.L1) - j;
					if (j + d == DurationMidi.L1)
						d /= 2;

					if (ini < DurationMidi.L1)
						This.add(ini, i, d);
				}
		});
	}

	public ArpeggioV2_3() {
		this(DurationMidi.L1);
	}
}
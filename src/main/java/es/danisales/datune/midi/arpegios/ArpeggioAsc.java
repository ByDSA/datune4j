package es.danisales.datune.midi.arpegios;

public class ArpeggioAsc extends Arpeggio {
	public ArpeggioAsc(int length, int freq) {
		super((This) -> {
			int n = (int)Math.ceil(length / (float)freq);
			for(int i = 0; i < n; i++) {
				int num = i % This.chord.size();
				This.add(freq*i, num, freq);
			}
		});
	}
}

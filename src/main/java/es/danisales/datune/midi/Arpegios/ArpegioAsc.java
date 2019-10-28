package es.danisales.datune.midi.Arpegios;

public class ArpegioAsc extends Arpegio {
	public ArpegioAsc(int length, int freq) {
		super((This) -> {
			int n = (int)Math.ceil(length / (float)freq);
			for(int i = 0; i < n; i++) {
				int num = i % This.chord.size();
				This.add(freq*i, num, freq);
			}
		});
	}
}

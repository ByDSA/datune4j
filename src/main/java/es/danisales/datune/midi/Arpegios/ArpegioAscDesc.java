package es.danisales.datune.midi.Arpegios;

public class ArpegioAscDesc extends Arpegio {
	public ArpegioAscDesc(int length, int freq) {
		super((This) -> {
			int numNotasAsc = This.chord.size();
			numNotasAsc--;
			int n = (int)Math.ceil(length / (float)freq);
			for(int i = 0; i < n; i++) {
				int num = (-Math.abs(i%(2*numNotasAsc)-numNotasAsc)+numNotasAsc);
				This.add(freq*i, num, freq);
			}
		});
	}
}

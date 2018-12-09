package midi.Arpegios;

public class ArpegioDesc extends Arpegio {
	public ArpegioDesc(int length, int freq) {
		super((This) -> {
			int numNotasAsc = This.chord.size();
			int n = (int)Math.ceil(length / (float)freq);
			for(int i = 0; i < n; i++) {
				int num = numNotasAsc - 1 - i % numNotasAsc;
				This.add(freq*i, num, freq);
			}
		});
	}
}

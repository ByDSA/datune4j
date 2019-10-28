package es.danisales.datune.midi.Arpegios;

public class ArpegioV extends Arpegio {
	public ArpegioV(int noteLength, int arpLength) {
		super((This) -> {
			This.add(0, -1, This.chord.size());
			
			for(int i = 0; i < This.chord.size(); i++) {
				This.add(0, i, noteLength);
			}
		});
	}
	
	public ArpegioV(int a) {
		this(a, a);
	}
}
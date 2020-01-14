package es.danisales.datune.midi.arpegios;

public class ArpeggioV extends Arpeggio {
	public ArpeggioV(int noteLength, int arpLength) {
		super((This) -> {
			This.add(0, -1, This.chord.size());
			
			for(int i = 0; i < This.chord.size(); i++) {
				This.add(0, i, noteLength);
			}
		});
	}

	public ArpeggioV(int a) {
		this(a, a);
	}
}
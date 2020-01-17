package es.danisales.datune.tuning;

import es.danisales.datune.chords.DiatonicAlt;

public class NoteTuning implements Cloneable {
	public DiatonicAlt note;
	public int octave;
	
	public NoteTuning(DiatonicAlt c, int o) {
		note = c;
		octave = o;
	}

	@Override
	public boolean equals(Object n) {
		return n instanceof NoteTuning && ((NoteTuning)n).note == note && ((NoteTuning)n).octave == octave;
	}

	@Override
	public String toString() {
		return note.toString() + octave;
	}
	
	@Override
	public NoteTuning clone() {
		try {
			return (NoteTuning)super.clone();
		} catch ( CloneNotSupportedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

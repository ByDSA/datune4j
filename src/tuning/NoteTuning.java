package tuning;

import musical.Chromatic;

public class NoteTuning implements Cloneable {
	public Chromatic note;
	public int octave;
	
	public NoteTuning(Chromatic c, int o) {
		note = c;
		octave = o;
	}

	@Override
	public boolean equals(Object n) {
		return n instanceof NoteTuning && ((NoteTuning)n).note == note && ((NoteTuning)n).octave == octave;
	}

	@Override
	public int hashCode() {
		return octave + note.ordinal();
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

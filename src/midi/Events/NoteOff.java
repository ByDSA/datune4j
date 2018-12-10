package midi.Events;

import midi.Settings;
import pitch.ChromaticMidi;

public class NoteOff extends ChannelEvent {
	public ChromaticMidi note;
	
	public NoteOff(int d, ChromaticMidi n, int v) {
		this(d, n.getPitchCode().val(), v);
		
		note = n;
	}
	
	public NoteOff(int d, int key, int vel) {
		super(d, (byte)(0x80));
		
		byte code = (byte)key;
		byte velocity = (byte)vel;
		
		
		setData( new byte[]{ code, velocity });
	}
	
	public NoteOff(int code, int v) {
		this(0, code, v);
	}
	
	public NoteOff(ChromaticMidi n) {
		this(0, n, Settings.DefaultValues.VELOCITY);
	}
	
	public NoteOff(ChromaticMidi n, int v) {
		this(0, n, v);
	}
	
	public String toString() {
		return "NoteOff " + note;
	}
	
	@Override
	public NoteOff clone() {
		NoteOff r = new NoteOff(note.clone(), 0);
		r.setData(getData());
		
		return r;
	}
}

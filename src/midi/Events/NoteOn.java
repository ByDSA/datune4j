package midi.Events;

import midi.Settings;
import pitch.ChromaticMidi;

public class NoteOn extends ChannelEvent {
	public ChromaticMidi note; // para toString
	
	public NoteOn(int d, ChromaticMidi n, int v) {
		this(d, n.getPitchCode().val(), v);
		note = n;
	}
	
	public NoteOn(ChromaticMidi n, int v) {
		this(0, n, v);
	}
	
	public NoteOn(ChromaticMidi n) {
		this(0, n, Settings.DefaultValues.VELOCITY);
	}
	
	public NoteOn(int d, int key, int vel) {
		super(d, (byte)(0x90));
		
		byte code = (byte)key;
		byte velocity = (byte)vel;
		
		
		setData( new byte[]{ code, velocity });
	}
	
	public NoteOn(int key, int vel) {
		this(0, key, vel);
	}
	
	public NoteOn(int key) {
		this(0, key, Settings.DefaultValues.VELOCITY);
	}
	
	public String toString() {
		return "NoteOn " + note;
	}
	
	@Override
	public NoteOn clone() {
		NoteOn r = new NoteOn(note.clone());
		r.setData(getData());
		
		return r;
	}
}

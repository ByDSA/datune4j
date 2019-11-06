package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.PitchSingleMidi;

public class NoteOff extends ChannelEvent {
	public PitchSingleMidi note;
	
	public NoteOff(PitchSingleMidi n) {
		this(0, n.getCode(), n.getVelocity());
		
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
	
	public String toString() {
		return "NoteOff " + note;
	}
	
	@Override
	public NoteOff clone() {
		NoteOff r = new NoteOff(note.clone());
		r.setData(getData());
		
		return r;
	}
}

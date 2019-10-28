package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.Settings;

public class NoteOn extends ChannelEvent {
	public ChromaticMidi note; // para toString
	
	public NoteOn(ChromaticMidi n) {
		this(0, n.getCode(), n.getVelocity());
		note = n;
	}
	
	public NoteOn(int delta, int key, int vel) {
		super(delta, (byte)(0x90));
		
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

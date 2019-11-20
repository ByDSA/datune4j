package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.PitchChromaticMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.musical.Diatonic;

public class NoteOn extends ChannelEvent {
	public ChromaticMidi note; // para toString
	
	public NoteOn(ChromaticMidi n) {
		this(0, n.getPitch().getCode(), n.getVelocity());
		note = n;
	}

	public NoteOn(DiatonicMidi n) {
		this(0, PitchChromaticMidi.from(n.getPitch()).getCode(), n.getVelocity());
		note = ChromaticMidi.from(n);
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

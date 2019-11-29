package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.Settings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NoteOn extends ChannelEvent {
	private NoteMidi note;

	public NoteOn(NoteMidi n) {
		this(0, n.getPitch().getMidiCode(), n.getVelocity());
		note = n;
	}

	private NoteOn(int delta, int key, int vel) {
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

	public @Nullable NoteMidi getNote() {
		return note;
	}
	
	public String toString() {
		return "NoteOn " + note;
	}

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@Override
	public NoteOn clone() {
		NoteOn r = new NoteOn(note.clone());
		r.setData(getData());

		return r;
	}
}

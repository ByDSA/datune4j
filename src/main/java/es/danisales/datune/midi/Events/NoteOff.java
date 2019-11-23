package es.danisales.datune.midi.Events;

import es.danisales.datune.midi.Note;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NoteOff extends ChannelEvent {
    private Note note;

    public NoteOff(Note n) {
        this(0, n.getPitch().getMidiCode(), n.getVelocity());
		note = n;
	}

    private NoteOff(int d, int key, int vel) {
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

    public @Nullable Note getNote() {
        return note;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
	@Override
	public NoteOff clone() {
		NoteOff r = new NoteOff(note.clone());
		r.setData(getData());
		
		return r;
	}
}

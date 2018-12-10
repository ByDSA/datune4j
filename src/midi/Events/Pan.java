package midi.Events;

public class Pan extends ControlChangeEvent {
	public static final int RIGHT=127;
	public static final int LEFT=0;
	public static final int MID=63;
	
	public Pan(int delta, int v) {
		super(delta, (byte)0xB0, (byte)0x0A, v);
	}
	
	public Pan(int v) {
		this(0, v);
	}
	
	@Override
	public Pan clone() {
		Pan r = new Pan(0, 0);
		r.setData(getData());
		
		return r;
	}
}

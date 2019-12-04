package es.danisales.datune.midi.binaries.events;

public class Pan extends ControlChangeEvent {
	public static final int RIGHT = 127;
	public static final int LEFT = 0;
	public static final int MID = 63;
	
	private Pan(int delta, int value) {
		super(delta, (byte)0xB0, (byte)0x0A, value);
	}
	
	public Pan(int value) {
		this(0, value);
	}

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Pan clone() {
        Pan r = new Pan(0, 0);
        r.setData(getData());

        return r;
    }
}

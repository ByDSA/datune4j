package midi.Events;

public class Volume extends ControlChangeEvent {
	public static final int MAX=127;
	public static final int MIN=0;
	
	public Volume(int delta, int v) {
		super(delta, (byte)0xB0, (byte)0x07, v);
	}
	
	public Volume(int v) {
		this(0, v);
	}
}

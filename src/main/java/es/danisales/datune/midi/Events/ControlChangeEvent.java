package es.danisales.datune.midi.Events;

public class ControlChangeEvent extends ChannelEvent {
	int value;
	byte controllerNumber;

	public ControlChangeEvent(int delta, byte status, byte c, int channel, int v) {
		super(delta, status, channel);
		
		controllerNumber = c;
		setValue(v);
	}
	
	public ControlChangeEvent(int delta, byte status, byte c, int v) {
		this(delta, status, c, 0, v);
	}
	
	public ControlChangeEvent(byte status, byte c, int v) {
		this(0, status, c, 0, v);
	}

	public void setValue(int v) {
		value = v;

		setData(new byte[]{controllerNumber, (byte)(value & 0x7F)});
	}
}

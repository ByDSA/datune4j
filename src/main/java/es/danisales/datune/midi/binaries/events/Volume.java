package es.danisales.datune.midi.binaries.events;

public class Volume extends ControlChangeEvent {
	public static final int MAX = 127;
	@SuppressWarnings("unused")
	public static final int MIN = 0;

	public Volume(int delta, int channel, int value) {
		super(delta, (byte) 0xB0, (byte) 0x07, channel, value);
	}

	@Override
	public Volume clone() {
		return new Volume(getDelta(), getChannel(), getValue());
	}
}

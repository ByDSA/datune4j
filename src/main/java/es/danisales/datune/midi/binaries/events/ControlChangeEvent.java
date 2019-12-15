package es.danisales.datune.midi.binaries.events;

public abstract class ControlChangeEvent extends ChannelEvent {
	private int value;
	private byte controllerNumber;

	protected ControlChangeEvent(int delta, byte status, byte controllerNumber, int channel, int value) {
		super(delta, status, channel);

		this.controllerNumber = controllerNumber;
		setValue(value);
	}

	public void setValue(int v) {
		value = v;

		updateData();
	}

	public int getValue() {
		return value;
	}

	@Override
	public byte[] generateData() {
		return new byte[]{controllerNumber, (byte) (value & 0x7F)};
	}
}

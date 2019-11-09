package es.danisales.datune.midi.Events;

public class ChannelEvent extends ChunkData {
	private int channel;
	private byte statusBase;

	private ChannelEvent() {
		super(0, (byte)0);
	}

	ChannelEvent(int d, byte s, int n) {
		super(d, s);
		statusBase = s;
		setChannel(n);
	}

	ChannelEvent(int d, byte s) {
		this(d, s, 0);
	}

	void setChannel(int n) {
		channel = n;
		setStatus((byte)(statusBase + (n & 0x0F)));
	}

	@Override
	public ChannelEvent clone() {
		ChannelEvent ce = new ChannelEvent();
		cloneInto(ce);
		ce.channel = channel;
		ce.statusBase = statusBase;

		return ce;
	}
}

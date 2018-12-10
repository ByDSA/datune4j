package midi.Events;

import java.nio.ByteBuffer;

public class ChannelEvent extends ChunkData {
	int channel;
	byte statusBase;

	private ChannelEvent() {
		super(0, (byte)0);
	}

	public ChannelEvent(int d, byte s, int n) {
		super(d, s);
		statusBase = s;
		setChannel(n);
	}

	public ChannelEvent(int d, byte s) {
		this(d, s, 0);
	}

	public ChannelEvent setChannel(int n) {
		channel = n;
		setStatus((byte)(statusBase + (n & 0x0F)));

		return this;
	}
	
	public int getChannel() {
		return channel;
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

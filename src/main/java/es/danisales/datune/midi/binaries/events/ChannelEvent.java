package es.danisales.datune.midi.binaries.events;

abstract class ChannelEvent extends ChunkData {
	private int channel;
	private byte statusBase;

	ChannelEvent(int delta, byte status, int channelNumber) {
		super(delta, status);
		statusBase = status;
		setChannel(channelNumber);
	}

	void setChannel(int channelNumber) {
		channel = channelNumber;
		setStatus((byte) (statusBase + (channelNumber & 0x0F)));
	}

	int getChannel() {
		return channel;
	}
}

package es.danisales.datune.midi.binaries.events;

abstract class ChannelEvent extends ChunkData {
    public static final int MIN_CHANNEL = 0;
    public static final int DRUMS_CHANNEL = 10;
    public static final int MAX_CHANNEL = 15;

	private int channel;
	private byte statusBase;

    public static int boundChannel(int channel) {
        if (MIN_CHANNEL < 0 || channel > MAX_CHANNEL)
            return 0;

        return channel;
    }

	ChannelEvent(int delta, byte status, int channelNumber) {
		super(delta, status);
		statusBase = status;
		setChannel(channelNumber);
	}

	void setChannel(int channelNumber) {
        channel = boundChannel(channelNumber);
		setStatus((byte) (statusBase + (channelNumber & 0x0F)));
	}

	int getChannel() {
		return channel;
	}
}

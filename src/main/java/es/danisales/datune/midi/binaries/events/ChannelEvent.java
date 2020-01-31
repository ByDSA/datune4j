package es.danisales.datune.midi.binaries.events;

public abstract class ChannelEvent extends ChunkData {
    @SuppressWarnings("WeakerAccess")
    public static final int MIN_CHANNEL = 0;
    public static final int DRUMS_CHANNEL = 10;
    @SuppressWarnings("WeakerAccess")
    public static final int MAX_CHANNEL = 15;

	private int channel;
	private byte statusBase;

    public abstract static class Builder<B, RET> extends es.danisales.utils.building.Builder<Builder<B, RET>, RET> {
        int delta = 0;
        int channel = 0;

        public Builder<B, RET> delta(int delta) {
            this.delta = boundDelta(delta);

            return self();
        }

        public Builder<B, RET> channel(int channel) {
            this.channel = boundChannel(channel);

            return self();
        }
    }

    public static int boundChannel(int channel) {
        if (channel < MIN_CHANNEL)
            return MIN_CHANNEL;
        else if (channel > MAX_CHANNEL)
            return MAX_CHANNEL;

        return channel;
    }

	ChannelEvent(int delta, byte status, int channelNumber) {
		super(delta, status);
		statusBase = status;
		setChannel(channelNumber);
	}

    public void setChannel(int channelNumber) {
        channel = boundChannel(channelNumber);
        super.setStatus((byte) (statusBase + (channelNumber & 0x0F)));
	}

	int getChannel() {
		return channel;
	}
}

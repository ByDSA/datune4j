package es.danisales.datune.midi.binaries.events;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Pan extends ControlChangeEvent {
	static final byte STATUS = (byte) 0xB0;
	static final byte CONTROLLER_NUMBER = (byte) 0x0A;

	public static final int RIGHT = 127;
	public static final int LEFT = 0;
	public static final int MID = 63;

	private Pan(int delta, int value, int channel) {
		super(delta, STATUS, CONTROLLER_NUMBER, channel, value);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder extends es.danisales.utils.building.Builder<Builder, Pan> {
		int delta = 0;
		int value = MID;
		int channel = 0;

		public Builder delta(int delta) {
			this.delta = delta;

			return self();
		}

		public Builder value(int value) {
			this.value = value;

			return self();
		}

		public Builder channel(int channel) {
			this.channel = channel;

			return self();
		}

		@NonNull
		@Override
		public Pan build() {
			return new Pan(delta, value, channel);
		}

		@NonNull
		@Override
		protected Builder self() {
			return this;
		}
	}

	@Override
    public Pan clone() {
		return new Pan(getDelta(), getValue(), getChannel());
    }
}

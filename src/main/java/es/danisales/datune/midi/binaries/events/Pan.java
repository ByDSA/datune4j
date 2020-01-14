package es.danisales.datune.midi.binaries.events;

import es.danisales.utils.Utils;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Pan extends ControlChangeEvent {
	static final byte STATUS = (byte) 0xB0;
	static final byte CONTROLLER_NUMBER = (byte) 0x0A;

	public static final int RIGHT = 127;
	public static final int MID = 63;
    public static final int LEFT = 0;

	private Pan(int delta, int value, int channel) {
		super(delta, STATUS, CONTROLLER_NUMBER, channel, value);
	}

    private static int boundPanValue(int value) {
        return Utils.bound(value, LEFT, RIGHT);
    }

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public void setStatus(byte status) {
		throw new UnsupportedOperationException();
	}

    public static class Builder extends ControlChangeEvent.Builder<Builder, Pan> {
		int value = MID;

		public Builder value(int value) {
            this.value = boundPanValue(value);

			return self();
		}

        @Override
        public Builder delta(int delta) {
            return (Builder) super.delta(delta);
        }

        @Override
        public Builder channel(int channel) {
            return (Builder) super.channel(channel);
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

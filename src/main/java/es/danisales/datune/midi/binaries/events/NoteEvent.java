package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

abstract class NoteEvent extends ChannelEvent {
    private int pitch;
    private int velocity;

    public static abstract class Builder<N extends NoteEvent>
            extends es.danisales.utils.building.Builder<Builder<N>, N> {
        protected int delta = 0;
        protected int pitch = 0;
        protected int velocity = Settings.DefaultValues.VELOCITY;
        protected int channel = 0;

        Builder() {
        }

        public Builder<N> delta(int delta) {
            this.delta = boundDelta(delta);

            return self();
        }

        public Builder<N> pitch(int pitch) {
            this.pitch = PitchChromaticMidi.boundCode(pitch);

            return self();
        }

        public Builder<N> from(@NonNull NoteMidi noteMidi) {
            this.pitch = noteMidi.getPitch().getMidiCode();
            this.velocity = noteMidi.getVelocity();

            return self();
        }

        public Builder<N> velocity(int velocity) {
            this.velocity = boundVelocity(velocity);

            return self();
        }

        public Builder<N> channel(int channel) {
            this.channel = ChannelEvent.boundChannel(channel);

            return self();
        }

        @NonNull
        @Override
        protected Builder<N> self() {
            return this;
        }
    }

    static int boundVelocity(int velocity) {
        return es.danisales.utils.Utils.bound(velocity, 0, 127);
    }

    NoteEvent(int delta, int pitch, int velocity, byte statusBase, int channel) {
        super(delta, statusBase, channel);

        this.pitch = pitch;
        this.velocity = velocity;

        updateData();
    }

    public int getMidiCode() {
        return pitch;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    protected byte[] generateData() {
        byte keyByte = (byte) pitch;
        byte velocityByte = (byte) velocity;

        return new byte[]{keyByte, velocityByte};
    }

    public String toString() {
        try {
            return "NoteOn: " + PitchChromaticMidi.from(pitch);
        } catch (PitchMidiException e) {
            throw NeverHappensException.make("El código siempre es válido");
        }
    }
}
